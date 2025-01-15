package com.ncpbails.bfdimod.world;

import com.ncpbails.bfdimod.BFDIMod;
import com.ncpbails.bfdimod.world.ModPlacedFeatures;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.common.world.BiomeModifiers;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

public class ModBiomeModifiers {
    public static final ResourceKey<BiomeModifier> ADD_TREE_LIME = registerKey("add_tree_lime");

    public static final ResourceKey<BiomeModifier> ADD_TREE_MANGOSTEEN = registerKey("add_tree_mangosteen");

    public static final ResourceKey<BiomeModifier> ADD_TREE_RUBBER = registerKey("add_tree_rubber");

    public static final ResourceKey<BiomeModifier> ADD_YOYLE_BUSH = registerKey("add_yoyle_bush");

    public static final ResourceKey<BiomeModifier> ADD_BLUEBERRY_BUSH = registerKey("add_blueberry_bush");

    public static void bootstrap(BootstrapContext<BiomeModifier> context) {
        // CF -> PF -> BM
        var placedFeatures = context.lookup(Registries.PLACED_FEATURE);
        var biomes = context.lookup(Registries.BIOME);

        context.register(ADD_TREE_LIME, new BiomeModifiers.AddFeaturesBiomeModifier(
                HolderSet.direct(biomes.getOrThrow(Biomes.SAVANNA), biomes.getOrThrow(Biomes.SAVANNA_PLATEAU), biomes.getOrThrow(Biomes.WINDSWEPT_SAVANNA)),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.LIME_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION));

        context.register(ADD_TREE_MANGOSTEEN, new BiomeModifiers.AddFeaturesBiomeModifier(
                HolderSet.direct(biomes.getOrThrow(Biomes.JUNGLE), biomes.getOrThrow(Biomes.BAMBOO_JUNGLE), biomes.getOrThrow(Biomes.BAMBOO_JUNGLE)),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.MANGOSTEEN_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION));

        context.register(ADD_TREE_RUBBER, new BiomeModifiers.AddFeaturesBiomeModifier(
                HolderSet.direct(biomes.getOrThrow(Biomes.JUNGLE), biomes.getOrThrow(Biomes.BAMBOO_JUNGLE), biomes.getOrThrow(Biomes.BAMBOO_JUNGLE)),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.RUBBER_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION));

        context.register(ADD_YOYLE_BUSH, new BiomeModifiers.AddFeaturesBiomeModifier(
                HolderSet.direct(biomes.getOrThrow(Biomes.PLAINS), biomes.getOrThrow(Biomes.SUNFLOWER_PLAINS), biomes.getOrThrow(Biomes.SNOWY_PLAINS), biomes.getOrThrow(Biomes.SAVANNA_PLATEAU)),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.YOYLE_BUSH_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION));

        context.register(ADD_BLUEBERRY_BUSH, new BiomeModifiers.AddFeaturesBiomeModifier(
                HolderSet.direct(biomes.getOrThrow(Biomes.PLAINS), biomes.getOrThrow(Biomes.SUNFLOWER_PLAINS), biomes.getOrThrow(Biomes.SNOWY_PLAINS), biomes.getOrThrow(Biomes.SAVANNA_PLATEAU)),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.BLUEBERRY_BUSH_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION));
    }

    private static ResourceKey<BiomeModifier> registerKey(String name) {
        return ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS, ResourceLocation.fromNamespaceAndPath(BFDIMod.MOD_ID, name));
    }
}
