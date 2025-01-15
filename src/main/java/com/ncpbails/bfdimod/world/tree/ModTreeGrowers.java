package com.ncpbails.bfdimod.world.tree;

import com.ncpbails.bfdimod.BFDIMod;
import com.ncpbails.bfdimod.world.ModConfiguredFeatures;
import net.minecraft.world.level.block.grower.TreeGrower;

import java.util.Optional;

public class ModTreeGrowers {
    public static final TreeGrower LIME = new TreeGrower(BFDIMod.MOD_ID + ":lime",
            Optional.empty(), Optional.of(ModConfiguredFeatures.LIME_PLACED_KEY), Optional.empty());

    public static final TreeGrower MANGOSTEEN = new TreeGrower(BFDIMod.MOD_ID + ":mangosteen",
            Optional.empty(), Optional.of(ModConfiguredFeatures.MANGOSTEEN_PLACED_KEY), Optional.empty());

    public static final TreeGrower RUBBER = new TreeGrower(BFDIMod.MOD_ID + ":rubber",
            Optional.empty(), Optional.of(ModConfiguredFeatures.RUBBER_PLACED_KEY), Optional.empty());
}
