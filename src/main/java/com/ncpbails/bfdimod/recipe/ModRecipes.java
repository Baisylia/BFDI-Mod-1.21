package com.ncpbails.bfdimod.recipe;

import com.ncpbails.bfdimod.BFDIMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModRecipes {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS =
            DeferredRegister.create(Registries.RECIPE_SERIALIZER, BFDIMod.MOD_ID);
    public static final DeferredRegister<RecipeType<?>> TYPES =
            DeferredRegister.create(Registries.RECIPE_TYPE, BFDIMod.MOD_ID);

    public static final DeferredHolder<RecipeSerializer<?>, RecipeSerializer<StoneToBootOTronRecipe>> STONE_TO_BOOT_O_TRON_SERIALIZER =
            SERIALIZERS.register("stone_to_boot_o_tron", StoneToBootOTronRecipe.Serializer::new);
    public static final DeferredHolder<RecipeType<?>, RecipeType<StoneToBootOTronRecipe>> STONE_TO_BOOT_O_TRON_TYPE =
            TYPES.register("stone_to_boot_o_tron", () -> new RecipeType<StoneToBootOTronRecipe>() {
                @Override
                public String toString() {
                    return "stone_to_boot_o_tron";
                }
            });


    public static void register(IEventBus eventBus) {
        SERIALIZERS.register(eventBus);
        TYPES.register(eventBus);
    }
}
