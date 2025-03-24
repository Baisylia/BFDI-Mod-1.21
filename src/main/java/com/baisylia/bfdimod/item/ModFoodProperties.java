package com.baisylia.bfdimod.item;

import com.baisylia.bfdimod.effect.ModEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoodProperties {

    public static final FoodProperties YOYLEBERRY = new FoodProperties.Builder().nutrition(1).saturationModifier(0.3f)
            .effect(() -> new MobEffectInstance(ModEffects.YOYLE_METAL_TRANSFORMED_EFFECT, Integer.MAX_VALUE), 1f).build();

    public static final FoodProperties DREAM_BERRY = new FoodProperties.Builder().nutrition(6).saturationModifier(1f).build();

    public static final FoodProperties YELLOW_TOMATO = new FoodProperties.Builder().nutrition(1).saturationModifier(0.3f)
            .effect(() -> new MobEffectInstance(MobEffects.NIGHT_VISION, 400), 1f).build();

    public static final FoodProperties BERRY = new FoodProperties.Builder().nutrition(1).saturationModifier(0.3f).build();



    public static final FoodProperties YOYLECAKE_SLICE = new FoodProperties.Builder().nutrition(2).saturationModifier(0.1f)
            .effect(() -> new MobEffectInstance(ModEffects.YOYLE_METAL_TRANSFORMED_EFFECT, Integer.MAX_VALUE), 1f).build();

    public static final FoodProperties REGULAR_CAKE_SLICE = new FoodProperties.Builder().nutrition(2).saturationModifier(0.1f).build();

    public static final FoodProperties YOYLE_PIE_SLICE = new FoodProperties.Builder().nutrition(3).saturationModifier(0.3F)
            .effect(() -> new MobEffectInstance(ModEffects.YOYLE_METAL_TRANSFORMED_EFFECT, Integer.MAX_VALUE), 1f).build();

    public static final FoodProperties BLUEBERRY_PIE_SLICE = new FoodProperties.Builder().nutrition(3).saturationModifier(0.3F).build();

    public static final FoodProperties YOYLE_STEW = new FoodProperties.Builder().nutrition(2).saturationModifier(0.1f)
            .effect(() -> new MobEffectInstance(MobEffects.POISON, 200), 1f)
            .effect(() -> new MobEffectInstance(MobEffects.CONFUSION, 200), 1f).build();

    public static final FoodProperties DONUT = new FoodProperties.Builder().nutrition(3).saturationModifier(0.6f).build();

    public static final FoodProperties GELATIN = new FoodProperties.Builder().nutrition(5).saturationModifier(0.9f).build();

    public static final FoodProperties CEMENT_GELATIN = new FoodProperties.Builder().nutrition(5).saturationModifier(0.9f)
            .effect(() -> new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 200), 1f)
            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 200), 1f).build();

    public static final FoodProperties POO_GELATIN = new FoodProperties.Builder().nutrition(5).saturationModifier(0.9f)
            .effect(() -> new MobEffectInstance(MobEffects.CONFUSION, 200), 1f).build();

    public static final FoodProperties LOLLIPOP = new FoodProperties.Builder().nutrition(2).saturationModifier(0.2f).build();

    public static final FoodProperties CEMENT_LOLLIPOP = new FoodProperties.Builder().nutrition(2).saturationModifier(0.2f)
            .effect(() -> new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 200), 1f)
            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 200), 1f).build();

    public static final FoodProperties POO_LOLLIPOP = new FoodProperties.Builder().nutrition(2).saturationModifier(0.2f)
            .effect(() -> new MobEffectInstance(MobEffects.CONFUSION, 200), 1f).build();
}
