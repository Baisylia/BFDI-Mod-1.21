package com.baisylia.bfdimod.recipe;

import com.baisylia.bfdimod.BFDIMod;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.items.wrapper.RecipeWrapper;

public class StoneToBootOTronShapedRecipe implements Recipe<RecipeWrapper> {

    final ItemStack output;
    private final ShapedRecipePattern pattern;
    private final Ingredient fuel;
    private final int cookTime;

    public StoneToBootOTronShapedRecipe(ShapedRecipePattern pattern, ItemStack output, int cookTime, Ingredient fuel) {
        this.output = output;
        this.pattern = pattern;
        this.fuel = fuel;
        this.cookTime = cookTime;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return ModRecipes.STONE_TO_BOOTING_SHAPED_SERIALIZER.get();
    }

    @Override
    public ItemStack getResultItem(HolderLookup.Provider provider) {
        return output.copy();
    }

    @Override
    public NonNullList<Ingredient> getIngredients() {
        return pattern.ingredients();
    }

    public Ingredient getFuel() {
        return fuel;
    }

    public int getCookTime() {
        return this.cookTime;
    }

    public boolean matches(RecipeWrapper inv, Level level) {
        ItemStack outputSlot = inv.getItem(10);
        if (!outputSlot.isEmpty() && !ItemStack.isSameItem(this.output, outputSlot)) {
            return false;
        }

        if (!outputSlot.isEmpty() && outputSlot.getCount() >= outputSlot.getMaxStackSize()) {
            return false;
        }

        boolean[][] slotUsed = new boolean[3][3]; // Track which slots are used

        // Iterate over the crafting grid
        for (int offsetX = 0; offsetX <= 3 - this.getWidth(); ++offsetX) {
            for (int offsetY = 0; offsetY <= 3 - this.getHeight(); ++offsetY) {
                if (checkIngredients(inv, offsetX, offsetY, slotUsed)) {
                    if (areOtherSlotsEmpty(inv, offsetX, offsetY)) {
                        return hasRequiredFuel(inv, level); // Match found, return true
                    }
                }
            }
        }

        return false; // No match found
    }

    private boolean hasRequiredFuel(RecipeWrapper inv, Level level) {
        ItemStack fuelStack = inv.getItem(9);
        return fuel.test(fuelStack);
    }

    private boolean areOtherSlotsEmpty(RecipeWrapper pContainer, int offsetX, int offsetY) {
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                if (i < offsetX || i >= offsetX + this.getWidth() || j < offsetY || j >= offsetY + this.getHeight()) {
                    ItemStack itemStack = pContainer.getItem(i + j * 3); // Use a fixed grid size of 3x3
                    if (!itemStack.isEmpty()) {
                        return false; // Slot is not empty
                    }
                }
            }
        }
        return true; // All other slots are empty
    }
    private boolean checkIngredients(RecipeWrapper pContainer, int offsetX, int offsetY, boolean[][] slotUsed) {
        // Iterate over the recipe's dimensions
        for (int i = 0; i < this.getWidth(); ++i) {
            for (int j = 0; j < this.getHeight(); ++j) {
                int gridX = i + offsetX;
                int gridY = j + offsetY;

                // Check if the current position is within the crafting grid
                if (gridX >= 3 || gridY >= 3) {
                    continue;
                }

                // Check if the slot is already used by another recipe
                if (slotUsed[gridX][gridY]) {
                    return false;
                }

                Ingredient recipeIngredient = this.pattern.ingredients().get(i + j * this.getWidth());
                ItemStack gridStack = pContainer.getItem(gridX + gridY * 3); // Use a fixed grid size of 3x3

                // Ensure the ingredient matches and the stack size is exactly 64
                if (!recipeIngredient.test(gridStack) || gridStack.getCount() != 64) {
                    return false;
                }

                // Mark the slot as used
                slotUsed[gridX][gridY] = true;
            }
        }

        return true; // All ingredients matched
    }

    @Override
    public ItemStack assemble(RecipeWrapper inv, HolderLookup.Provider provider) {
        return output;
    }

    public int getWidth() {
        return this.pattern.width();
    }

    public int getHeight() {
        return this.pattern.height();
    }

    @Override
    public boolean canCraftInDimensions(int p_43999_, int p_44000_) {
        return true;
    }

    @Override
    public RecipeType<?> getType() {
        return ModRecipes.STONE_TO_BOOTING_SHAPED.get();
    }

    public boolean isIncomplete() {
        NonNullList<Ingredient> nonnulllist = this.getIngredients();
        return nonnulllist.isEmpty() || nonnulllist.stream().filter((ingredient) -> !ingredient.isEmpty()).anyMatch((ingredient) -> true);
    }

    public static class Serializer implements RecipeSerializer<StoneToBootOTronShapedRecipe> {
        private static final ResourceLocation NAME = BFDIMod.locate("stone_to_booting_shaped");

        public static final MapCodec<StoneToBootOTronShapedRecipe> CODEC = RecordCodecBuilder.mapCodec((recipe) -> recipe.group(
                ShapedRecipePattern.MAP_CODEC.forGetter((p_311733_) -> p_311733_.pattern),
                Ingredient.CODEC.optionalFieldOf("fuel", Ingredient.EMPTY).forGetter(StoneToBootOTronShapedRecipe::getFuel),
                ItemStack.STRICT_CODEC.fieldOf("result").forGetter((r) -> r.output),
                Codec.INT.optionalFieldOf("cookingtime", 200).forGetter(StoneToBootOTronShapedRecipe::getCookTime)
        ).apply(recipe, (shapedrecipepattern, output, cookTime, fuel) -> new StoneToBootOTronShapedRecipe(shapedrecipepattern, cookTime, fuel, output)));


        public MapCodec<StoneToBootOTronShapedRecipe> codec() {
            return CODEC;
        }

        public StreamCodec<RegistryFriendlyByteBuf, StoneToBootOTronShapedRecipe> streamCodec() {
            return StreamCodec.of(Serializer::toNetwork, Serializer::fromNetwork);
        }


        public static StoneToBootOTronShapedRecipe fromNetwork(RegistryFriendlyByteBuf buffer) {
            ShapedRecipePattern shapedrecipepattern = ShapedRecipePattern.STREAM_CODEC.decode(buffer);

            ItemStack itemstack = ItemStack.STREAM_CODEC.decode(buffer);
            int cookTimeIn = buffer.readVarInt();
            Ingredient fuel = Ingredient.CONTENTS_STREAM_CODEC.decode(buffer);
            return new StoneToBootOTronShapedRecipe(shapedrecipepattern, itemstack, cookTimeIn, fuel);
        }


        public static void toNetwork(RegistryFriendlyByteBuf buffer, StoneToBootOTronShapedRecipe recipe) {
            ShapedRecipePattern.STREAM_CODEC.encode(buffer, recipe.pattern);

            ItemStack.STREAM_CODEC.encode(buffer, recipe.output);
            buffer.writeVarInt(recipe.cookTime);
            Ingredient.CONTENTS_STREAM_CODEC.encode(buffer, recipe.fuel);
        }
    }
}