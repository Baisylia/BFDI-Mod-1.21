package com.ncpbails.bfdimod.recipe;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;

public record StoneToBootOTronRecipe(Ingredient inputItem, ItemStack output) implements Recipe<StoneToBootOTronRecipeInput> {
    // inputItem & output ==> Read From JSON File!
    // GrowthChamberRecipeInput --> INVENTORY of the Block Entity

    @Override
    public NonNullList<Ingredient> getIngredients() {
        NonNullList<Ingredient> list = NonNullList.create();
        list.add(inputItem);
        return list;
    }

    @Override
    public boolean matches(StoneToBootOTronRecipeInput stoneToBootOTronRecipeInput, Level level) {
        if (level.isClientSide()) {
            return false;
        }

        return inputItem.test(stoneToBootOTronRecipeInput.getItem(0));
    }

    @Override
    public ItemStack assemble(StoneToBootOTronRecipeInput stoneToBootOTronRecipeInput, HolderLookup.Provider provider) {
        return output.copy();
    }

    @Override
    public boolean canCraftInDimensions(int i, int i1) {
        return true;
    }

    @Override
    public ItemStack getResultItem(HolderLookup.Provider provider) {
        return output;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return ModRecipes.STONE_TO_BOOT_O_TRON_SERIALIZER.get();
    }

    @Override
    public RecipeType<?> getType() {
        return ModRecipes.STONE_TO_BOOT_O_TRON_TYPE.get();
    }

    public static class Serializer implements RecipeSerializer<StoneToBootOTronRecipe> {
        public static final MapCodec<StoneToBootOTronRecipe> CODEC = RecordCodecBuilder.mapCodec(inst -> inst.group(
                Ingredient.CODEC_NONEMPTY.fieldOf("ingredient").forGetter(StoneToBootOTronRecipe::inputItem),
                ItemStack.CODEC.fieldOf("result").forGetter(StoneToBootOTronRecipe::output)
        ).apply(inst, StoneToBootOTronRecipe::new));

        public static final StreamCodec<RegistryFriendlyByteBuf, StoneToBootOTronRecipe> STREAM_CODEC =
                StreamCodec.composite(
                        Ingredient.CONTENTS_STREAM_CODEC, StoneToBootOTronRecipe::inputItem,
                        ItemStack.STREAM_CODEC, StoneToBootOTronRecipe::output,
                        StoneToBootOTronRecipe::new);

        @Override
        public MapCodec<StoneToBootOTronRecipe> codec() {
            return CODEC;
        }

        @Override
        public StreamCodec<RegistryFriendlyByteBuf, StoneToBootOTronRecipe> streamCodec() {
            return STREAM_CODEC;
        }
    }
}