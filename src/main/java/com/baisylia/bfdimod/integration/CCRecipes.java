package com.baisylia.bfdimod.integration;

import com.baisylia.bfdimod.recipe.StoneToBootOTronRecipe;
import com.baisylia.bfdimod.recipe.StoneToBootOTronShapedRecipe;
import com.baisylia.bfdimod.recipe.ModRecipes;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeManager;

import java.util.List;

public class CCRecipes {
    private final RecipeManager recipeManager;

    public CCRecipes() {
        Minecraft minecraft = Minecraft.getInstance();
        ClientLevel level = minecraft.level;

        if (level != null) {
            this.recipeManager = level.getRecipeManager();
        } else {
            throw new NullPointerException("minecraft world must not be null.");
        }
    }

    public List<StoneToBootOTronRecipe> getStoneToBootOTronRecipes() {
        return recipeManager.getAllRecipesFor(ModRecipes.STONE_TO_BOOTING.get()).stream().map(RecipeHolder::value).toList();
    }

    public List<StoneToBootOTronShapedRecipe> getStoneToBootOTronShapedRecipes() {
        return recipeManager.getAllRecipesFor(ModRecipes.STONE_TO_BOOTING_SHAPED.get()).stream().map(RecipeHolder::value).toList();
    }
}
