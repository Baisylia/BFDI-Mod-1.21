package com.ncpbails.bfdimod.item;

import com.ncpbails.bfdimod.effect.ModEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoodProperties {

    public static final FoodProperties YOYLEBERRY = new FoodProperties.Builder().nutrition(1).saturationModifier(0.3f)
            .effect(() -> new MobEffectInstance(ModEffects.YOYLE_METAL_TRANSFORMED_EFFECT, Integer.MAX_VALUE), 1f).build();

    public static final FoodProperties DREAM_BERRY = new FoodProperties.Builder().nutrition(6).saturationModifier(1f).build();

    public static final FoodProperties YOYLECAKE_SLICE = new FoodProperties.Builder().nutrition(2).saturationModifier(0.1f)
            .effect(() -> new MobEffectInstance(ModEffects.YOYLE_METAL_TRANSFORMED_EFFECT, Integer.MAX_VALUE), 1f).build();

    public static final FoodProperties REGULAR_CAKE = new FoodProperties.Builder().nutrition(2).saturationModifier(0.1f).build();

    public static final FoodProperties YELLOW_TOMATO = new FoodProperties.Builder().nutrition(1).saturationModifier(0.3f)
            .effect(() -> new MobEffectInstance(MobEffects.NIGHT_VISION, 400), 1f).build();
}
