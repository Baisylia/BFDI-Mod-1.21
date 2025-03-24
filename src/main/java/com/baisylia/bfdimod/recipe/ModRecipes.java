package com.baisylia.bfdimod.recipe;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

import static com.baisylia.bfdimod.BFDIMod.MOD_ID;

public class ModRecipes {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS = DeferredRegister.create(Registries.RECIPE_SERIALIZER, MOD_ID);
    public static final DeferredRegister<RecipeType<?>> RECIPE_TYPES = DeferredRegister.create(Registries.RECIPE_TYPE, MOD_ID);;

    public static final Supplier<RecipeType<StoneToBootOTronRecipe>> STONE_TO_BOOTING = RECIPE_TYPES.register("stone_to_booting", () -> registerRecipeType("stone_to_booting"));
    public static final Supplier<RecipeType<StoneToBootOTronShapedRecipe>> STONE_TO_BOOTING_SHAPED = RECIPE_TYPES.register("stone_to_booting_shaped", () -> registerRecipeType("stone_to_booting_shaped"));

    public static final Supplier<RecipeSerializer<?>> STONE_TO_BOOTING_SERIALIZER = SERIALIZERS.register("stone_to_booting", StoneToBootOTronRecipe.Serializer::new);
    public static final Supplier<RecipeSerializer<?>> STONE_TO_BOOTING_SHAPED_SERIALIZER = SERIALIZERS.register("stone_to_booting_shaped", StoneToBootOTronShapedRecipe.Serializer::new);

    public static <T extends Recipe<?>> RecipeType<T> registerRecipeType(final String identifier) {
        return new RecipeType<T>() {
            public String toString() {
                return MOD_ID + ":" + identifier;
            }
        };
    }

    public static void register(IEventBus eventBus) {
        RECIPE_TYPES.register(eventBus);
        SERIALIZERS.register(eventBus);
    }
}