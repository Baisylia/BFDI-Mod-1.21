package com.baisylia.bfdimod.integration;

import com.baisylia.bfdimod.BFDIMod;
import com.baisylia.bfdimod.block.ModBlocks;
import com.baisylia.bfdimod.recipe.StoneToBootOTronRecipe;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.drawable.IDrawableAnimated;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import vectorwing.farmersdelight.common.utility.RecipeUtils;

public class StoneToBootOTronRecipeCategory implements IRecipeCategory<StoneToBootOTronRecipe> {
    public final static ResourceLocation UID = BFDIMod.locate( "stone_to_booting");
    public final static ResourceLocation TEXTURE =
            BFDIMod.locate( "textures/gui/stone_to_boot_o_tron_gui_jei.png");

    private final IDrawable background;
    private final IDrawable icon;
    private final int regularCookTime = 400;
    private final LoadingCache<Integer, IDrawableAnimated> cachedArrows;

    public StoneToBootOTronRecipeCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 0, 0, 124, 58);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ModBlocks.STONE_TO_BOOT_O_TRON.get()));
        this.cachedArrows = CacheBuilder.newBuilder()
                .maximumSize(25)
                .build(new CacheLoader<>() {
                    @Override
                    public IDrawableAnimated load(Integer cookTime) {
                        return helper.drawableBuilder(TEXTURE, 126, 0, 23, 18)
                                .buildAnimated(cookTime, IDrawableAnimated.StartDirection.LEFT, false);
                    }
                });
    }

    @Override
    public void draw(StoneToBootOTronRecipe recipe, IRecipeSlotsView recipeSlotsView, GuiGraphics guiGraphics, double mouseX, double mouseY) {
        IDrawableAnimated arrow = getArrow(recipe);
        arrow.draw(guiGraphics, 63, 2);
        drawCookTime(recipe, guiGraphics, 45);
    }

    protected void drawCookTime(StoneToBootOTronRecipe recipe, GuiGraphics guiGraphics, int y) {
        int cookTime = recipe.getCookTime();
        if (cookTime > 0) {
            int cookTimeSeconds = cookTime / 20;
            Component timeString = Component.translatable("gui.jei.category.smelting.time.seconds", cookTimeSeconds);
            Minecraft minecraft = Minecraft.getInstance();
            Font fontRenderer = minecraft.font;
            int stringWidth = fontRenderer.width(timeString);
            guiGraphics.drawString(fontRenderer, timeString, getWidth() - stringWidth, y, 0xFF808080, false);
        }
    }

    protected IDrawableAnimated getArrow(StoneToBootOTronRecipe recipe) {
        int cookTime = recipe.getCookTime();
        if (cookTime <= 0) {
            cookTime = regularCookTime;
        }
        return this.cachedArrows.getUnchecked(cookTime);
    }

    @Override
    public RecipeType<StoneToBootOTronRecipe> getRecipeType() {
        return JEICooksCollectionPlugin.STONE_TO_BOOTING_TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.translatable("recipe.bfdimod.shapeless_stone_to_booting");
    }

    @Override
    public IDrawable getBackground() {
        return this.background;
    }

    @Override
    public IDrawable getIcon() {
        return this.icon;
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, StoneToBootOTronRecipe recipe, IFocusGroup focuses) {
        int startX = 3;
        int startY = 3;
        int offset = 18;

        // Loop through the ingredients and place them properly
        for (int i = 0; i < recipe.getIngredients().size(); i++) {
            int x = startX + (i % 3) * offset;  // Spread horizontally in columns of 3
            int y = startY + (i / 3) * offset;  // Move to the next row every 3 items

            builder.addSlot(RecipeIngredientRole.INPUT, x, y)
                    .addItemStack(new ItemStack(recipe.getIngredients().get(i).getItems()[0].getItem(), 64));
        }

        // Set the output slot at a fixed position
        builder.addSlot(RecipeIngredientRole.OUTPUT, 97, 5)
                .addItemStack(RecipeUtils.getResultItem(recipe));

        builder.addSlot(RecipeIngredientRole.INPUT, 66, 39)
                .addItemStack(recipe.getFuel().getItems()[0]);

    }
}