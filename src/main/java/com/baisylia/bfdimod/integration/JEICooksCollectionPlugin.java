package com.baisylia.bfdimod.integration;

import com.baisylia.bfdimod.BFDIMod;
import com.baisylia.bfdimod.block.ModBlocks;
import com.baisylia.bfdimod.recipe.StoneToBootOTronRecipe;
import com.baisylia.bfdimod.recipe.StoneToBootOTronShapedRecipe;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.resources.ResourceLocation;

@JeiPlugin
public class JEICooksCollectionPlugin implements IModPlugin {
    public static RecipeType<StoneToBootOTronRecipe> STONE_TO_BOOTING_TYPE =
            new RecipeType<>(StoneToBootOTronRecipeCategory.UID, StoneToBootOTronRecipe.class);

    public static RecipeType<StoneToBootOTronShapedRecipe> STONE_TO_BOOTING_SHAPED_TYPE =
            new RecipeType<>(StoneToBootOTronShapedRecipeCategory.UID, StoneToBootOTronShapedRecipe.class);

    @Override
    public ResourceLocation getPluginUid() {
        return BFDIMod.locate("jei_plugin");
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(
                new StoneToBootOTronRecipeCategory(registration.getJeiHelpers().getGuiHelper()),
                new StoneToBootOTronShapedRecipeCategory(registration.getJeiHelpers().getGuiHelper())
        );
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        CCRecipes modRecipes = new CCRecipes();

        registration.addRecipes(STONE_TO_BOOTING_TYPE, modRecipes.getStoneToBootOTronRecipes());
        registration.addRecipes(STONE_TO_BOOTING_SHAPED_TYPE, modRecipes.getStoneToBootOTronShapedRecipes());
    }

    @Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
        var stack = ModBlocks.STONE_TO_BOOT_O_TRON.get().asItem().getDefaultInstance();
        registration.addRecipeCatalyst(stack, STONE_TO_BOOTING_SHAPED_TYPE);
        registration.addRecipeCatalyst(stack, STONE_TO_BOOTING_TYPE);
    }
}
