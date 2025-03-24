package com.baisylia.bfdimod.recipe;

import com.baisylia.bfdimod.block.ModBlocks;
import com.mojang.serialization.Codec;
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
import net.neoforged.neoforge.common.util.RecipeMatcher;
import net.neoforged.neoforge.items.wrapper.RecipeWrapper;

import java.util.ArrayList;
import java.util.List;

public class StoneToBootOTronRecipe implements Recipe<RecipeWrapper> {
    private final NonNullList<Ingredient> inputItems;
    private final ItemStack output;
    private final int cookTime;

    public StoneToBootOTronRecipe(NonNullList<Ingredient> inputItems, ItemStack output, int cookTime) {
        this.inputItems = inputItems;
        this.output = output;
        this.cookTime = cookTime;
    }

    public NonNullList<Ingredient> getIngredients() {
        return this.inputItems;
    }

    public ItemStack getResultItem(HolderLookup.Provider provider) {
        return this.output;
    }

    public ItemStack assemble(RecipeWrapper inv, HolderLookup.Provider provider) {
        return this.output.copy();
    }

    public int getCookTime() {
        return this.cookTime;
    }

    public static class Type implements RecipeType<StoneToBootOTronRecipe> {
        private Type() { }
        public static final Type INSTANCE = new Type();
        public static final String ID = "stone_to_booting";
    }

    public boolean matches(RecipeWrapper inv, Level level) {
        List<ItemStack> inputs = new ArrayList<>();
        int i = 0;

        for (int j = 0; j < 9; ++j) {
            ItemStack itemstack = inv.getItem(j);
            if (!itemstack.isEmpty()) {
                ++i;
                inputs.add(itemstack);
            }
        }

        return i == this.inputItems.size() && RecipeMatcher.findMatches(inputs, this.inputItems) != null;
    }

    public boolean canCraftInDimensions(int width, int height) {
        return width * height >= this.inputItems.size();
    }

    public RecipeSerializer<?> getSerializer() {
        return ModRecipes.STONE_TO_BOOTING_SERIALIZER.get();
    }

    public RecipeType<?> getType() {
        return ModRecipes.STONE_TO_BOOTING.get();
    }

    public ItemStack getToastSymbol() {
        return new ItemStack(ModBlocks.STONE_TO_BOOT_O_TRON.get());
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o != null && this.getClass() == o.getClass()) {
            StoneToBootOTronRecipe that = (StoneToBootOTronRecipe) o;
            if (this.getCookTime() != that.getCookTime()) {
                return false;
            } else if (!this.inputItems.equals(that.inputItems)) {
                return false;
            } else {
                return this.output.equals(that.output);
            }
        } else {
            return false;
        }
    }

    public int hashCode() {
        int result = this.inputItems.hashCode();
        result = 31 * result + this.output.hashCode();
        result = 31 * result + this.getCookTime();
        return result;
    }

    public static class Serializer implements RecipeSerializer<StoneToBootOTronRecipe> {
        private static final MapCodec<StoneToBootOTronRecipe> CODEC = RecordCodecBuilder.mapCodec((inst) -> inst.group(
                Ingredient.LIST_CODEC_NONEMPTY.fieldOf("ingredients").forGetter(StoneToBootOTronRecipe::getIngredients),
                ItemStack.STRICT_CODEC.fieldOf("result").forGetter((r) -> r.output),
                Codec.INT.optionalFieldOf("cookingtime", 200).forGetter(StoneToBootOTronRecipe::getCookTime)
        ).apply(inst, (ingredients, output, cookTime) -> new StoneToBootOTronRecipe(NonNullList.copyOf(ingredients), output, cookTime)));

        public Serializer() {}

        public MapCodec<StoneToBootOTronRecipe> codec() {
            return CODEC;
        }

        public StreamCodec<RegistryFriendlyByteBuf, StoneToBootOTronRecipe> streamCodec() {
            return StreamCodec.of(Serializer::toNetwork, Serializer::fromNetwork);
        }

        private static StoneToBootOTronRecipe fromNetwork(RegistryFriendlyByteBuf buffer) {
            int i = buffer.readVarInt();
            NonNullList<Ingredient> inputItemsIn = NonNullList.withSize(i, Ingredient.EMPTY);
            inputItemsIn.replaceAll((ignored) -> Ingredient.CONTENTS_STREAM_CODEC.decode(buffer));
            ItemStack outputIn = ItemStack.STREAM_CODEC.decode(buffer);
            int cookTimeIn = buffer.readVarInt();
            return new StoneToBootOTronRecipe(inputItemsIn, outputIn, cookTimeIn);
        }

        private static void toNetwork(RegistryFriendlyByteBuf buffer, StoneToBootOTronRecipe recipe) {
            buffer.writeVarInt(recipe.inputItems.size());
            for (Ingredient ingredient : recipe.inputItems) {
                Ingredient.CONTENTS_STREAM_CODEC.encode(buffer, ingredient);
            }
            ItemStack.STREAM_CODEC.encode(buffer, recipe.output);
            buffer.writeVarInt(recipe.cookTime);
        }
    }
}
