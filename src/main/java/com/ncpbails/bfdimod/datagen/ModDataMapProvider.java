package com.ncpbails.bfdimod.datagen;

import com.ncpbails.bfdimod.block.ModBlocks;
import com.ncpbails.bfdimod.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DataMapProvider;
import net.neoforged.neoforge.registries.datamaps.builtin.Compostable;
import net.neoforged.neoforge.registries.datamaps.builtin.FurnaceFuel;
import net.neoforged.neoforge.registries.datamaps.builtin.NeoForgeDataMaps;

import java.util.concurrent.CompletableFuture;

public class ModDataMapProvider extends DataMapProvider {
    protected ModDataMapProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(packOutput, lookupProvider);
    }

    @Override
    protected void gather() {
        this.builder(NeoForgeDataMaps.FURNACE_FUELS)
                .add(ModBlocks.LIME_SAPLING.getId(), new FurnaceFuel(50), false)
                .add(ModBlocks.LIME_LOG.getId(), new FurnaceFuel(50), false)
                .add(ModBlocks.LIME_WOOD.getId(), new FurnaceFuel(50), false)
                .add(ModBlocks.MANGOSTEEN_SAPLING.getId(), new FurnaceFuel(50), false)
                .add(ModBlocks.MANGOSTEEN_LOG.getId(), new FurnaceFuel(50), false)
                .add(ModBlocks.MANGOSTEEN_WOOD.getId(), new FurnaceFuel(50), false)
                .add(ModBlocks.RUBBER_SAPLING.getId(), new FurnaceFuel(50), false)
                .add(ModBlocks.RUBBER_LOG.getId(), new FurnaceFuel(50), false)
                .add(ModBlocks.RUBBER_WOOD.getId(), new FurnaceFuel(50), false)
                .add(ModBlocks.LATEX_JUNGLE_LOG.getId(), new FurnaceFuel(50), false);

        this.builder(NeoForgeDataMaps.COMPOSTABLES)
                .add(ModItems.YOYLESEEDS.getId(), new Compostable(0.25f), false)
                .add(ModItems.YOYLEBERRY.getId(), new Compostable(0.25f), false)
                .add(ModItems.DREAM_BERRY.getId(), new Compostable(0.25f), false)
                .add(ModItems.YELLOW_TOMATO.getId(), new Compostable(0.25f), false)
                .add(ModItems.GRAPES.getId(), new Compostable(0.25f), false)
                .add(ModItems.BLUEBERRIES.getId(), new Compostable(0.25f), false)
                .add(ModItems.CHERRIES.getId(), new Compostable(0.25f), false)
                .add(ModItems.LIME.getId(), new Compostable(0.25f), false)
                .add(ModBlocks.LIME_SAPLING.getId(), new Compostable(0.45f), false)
                .add(ModBlocks.MANGOSTEEN_SAPLING.getId(), new Compostable(0.45f), false)
                .add(ModBlocks.RUBBER_SAPLING.getId(), new Compostable(0.45f), false)
                .add(ModItems.POO.getId(), new Compostable(1.0f), false)
                .add(ModItems.POLISHED_POO.getId(), new Compostable(1.0f), false)
                .add(ModBlocks.REGULAR_CAKE.getId(), new Compostable(1.0f), false)
                .add(ModItems.REGULAR_CAKE_SLICE.getId(), new Compostable(0.45f), false)
                .add(ModBlocks.YOYLECAKE.getId(), new Compostable(1.0f), false)
                .add(ModItems.YOYLECAKE_SLICE.getId(), new Compostable(0.45f), false)
                .add(ModBlocks.CHOCOLATE_CAKE.getId(), new Compostable(1.0f), false)
                .add(ModItems.CHOCOLATE_CAKE_SLICE.getId(), new Compostable(0.45f), false)
                .add(ModBlocks.YOYLE_PIE.getId(), new Compostable(1.0f), false)
                .add(ModItems.YOYLE_PIE_SLICE.getId(), new Compostable(0.45f), false)
                .add(ModBlocks.BLUEBERRY_PIE.getId(), new Compostable(1.0f), false)
                .add(ModItems.BLUEBERRY_PIE_SLICE.getId(), new Compostable(0.45f), false)
                .add(ModBlocks.TRAPPED_BLUEBERRY_PIE.getId(), new Compostable(1.0f), false)
                .add(ModItems.DONUT.getId(), new Compostable(0.25f), false)
                .add(ModItems.LEAF.getId(), new Compostable(0.25f), false)
                .add(ModItems.EVIL_LEAF.getId(), new Compostable(0.25f), false);
    }
}