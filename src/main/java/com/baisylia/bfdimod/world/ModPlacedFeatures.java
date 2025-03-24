package com.baisylia.bfdimod.world;

import com.baisylia.bfdimod.BFDIMod;
import com.baisylia.bfdimod.block.ModBlocks;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public class ModPlacedFeatures {
    public static final ResourceKey<PlacedFeature> LIME_PLACED_KEY = registerKey("lime_placed");
    public static final ResourceKey<PlacedFeature> MANGOSTEEN_PLACED_KEY = registerKey("mangosteen_placed");
    public static final ResourceKey<PlacedFeature> RUBBER_PLACED_KEY = registerKey("rubber_placed");
    public static final ResourceKey<PlacedFeature> YOYLE_BUSH_PLACED_KEY = registerKey("yoyleberry_bush_placed");
    public static final ResourceKey<PlacedFeature> BLUEBERRY_BUSH_PLACED_KEY = registerKey("blueberry_bush_placed");

    public static void bootstrap(BootstrapContext<PlacedFeature> context) {
        var configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        register(context, LIME_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.LIME_PLACED_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(0, 0.1f, 1),
                        ModBlocks.LIME_SAPLING.get()));

        register(context, MANGOSTEEN_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.MANGOSTEEN_PLACED_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(1, 0.5f, 1),
                        ModBlocks.MANGOSTEEN_SAPLING.get()));

        register(context, RUBBER_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.RUBBER_PLACED_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(1, 0.5f, 1),
                        ModBlocks.RUBBER_SAPLING.get()));

        register(context, YOYLE_BUSH_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.YOYLE_BUSH_PLACED_KEY),
                List.of(RarityFilter.onAverageOnceEvery(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome()));

        register(context, BLUEBERRY_BUSH_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.BLUEBERRY_BUSH_PLACED_KEY),
                List.of(RarityFilter.onAverageOnceEvery(32), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome()));
    }

    private static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, ResourceLocation.fromNamespaceAndPath(BFDIMod.MOD_ID, name));
    }

    private static void register(BootstrapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}
