package com.baisylia.bfdimod.item;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.SimpleTier;

public class ModToolTiers {
    public static final Tier YOYLE_METAL = new SimpleTier(BlockTags.INCORRECT_FOR_NETHERITE_TOOL,
            2031, 9.0F, 4.0F, 5, () -> Ingredient.of(ModItems.YOYLE_METAL_INGOT));
}
