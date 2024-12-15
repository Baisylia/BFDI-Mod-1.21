package com.ncpbails.bfdimod.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoodProperties {
    public static final FoodProperties YOYLEBERRY = new FoodProperties.Builder().nutrition(1).saturationModifier(0.3f)
            .effect(() -> new MobEffectInstance(MobEffects.NIGHT_VISION, 400), 1f).build();
    public static final FoodProperties YELLOW_TOMATO = new FoodProperties.Builder().nutrition(1).saturationModifier(0.3f)
            .effect(() -> new MobEffectInstance(MobEffects.NIGHT_VISION, 400), 1f).build();
}
