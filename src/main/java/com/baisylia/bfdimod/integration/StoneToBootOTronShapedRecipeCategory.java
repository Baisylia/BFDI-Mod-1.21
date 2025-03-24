package com.baisylia.bfdimod.integration;

import com.baisylia.bfdimod.BFDIMod;
import com.baisylia.bfdimod.block.ModBlocks;
import com.baisylia.bfdimod.recipe.StoneToBootOTronShapedRecipe;
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

public class StoneToBootOTronShapedRecipeCategory implements IRecipeCategory<StoneToBootOTronShapedRecipe> {
    public final static ResourceLocation UID = BFDIMod.locate("stone_to_booting_shaped");
    public final static ResourceLocation TEXTURE =
            BFDIMod.locate("textures/gui/stone_to_boot_o_tron_gui_jei.png");

    private final IDrawable background;
    private final IDrawable icon;
    private final int regularCookTime = 400;
    private final LoadingCache<Integer, IDrawableAnimated> cachedArrows;


    public StoneToBootOTronShapedRecipeCategory(IGuiHelper helper) {
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
    public void draw(StoneToBootOTronShapedRecipe recipe, IRecipeSlotsView recipeSlotsView, GuiGraphics guiGraphics, double mouseX, double mouseY) {
        IDrawableAnimated arrow = getArrow(recipe);
        arrow.draw(guiGraphics, 63, 19);
        drawCookTime(recipe, guiGraphics, 45);
    }

    protected void drawCookTime(StoneToBootOTronShapedRecipe recipe, GuiGraphics guiGraphics, int y) {
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

    protected IDrawableAnimated getArrow(StoneToBootOTronShapedRecipe recipe) {
        int cookTime = recipe.getCookTime();
        if (cookTime <= 0) {
            cookTime = regularCookTime;
        }
        return this.cachedArrows.getUnchecked(cookTime);
    }

    @Override
    public RecipeType<StoneToBootOTronShapedRecipe> getRecipeType() {
        return JEICooksCollectionPlugin.STONE_TO_BOOTING_SHAPED_TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.translatable("recipe.bfdimod.shaped_stone_to_booting");
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
    public void setRecipe(IRecipeLayoutBuilder builder, StoneToBootOTronShapedRecipe recipe, IFocusGroup focuses) {
        int start = 3;
        int index = 0;

        for (int y = 0; y < recipe.getHeight(); y++) {
            for (int x = 0; x < recipe.getWidth(); x++) {
                builder.addSlot(RecipeIngredientRole.INPUT, start + x * 18, start + y * 18)
                        .addIngredients(recipe.getIngredients().get(index));
                index++;
            }
        }

        // Add output slot
        builder.addSlot(RecipeIngredientRole.OUTPUT, 97, 21).addItemStack(RecipeUtils.getResultItem(recipe));
    }
}