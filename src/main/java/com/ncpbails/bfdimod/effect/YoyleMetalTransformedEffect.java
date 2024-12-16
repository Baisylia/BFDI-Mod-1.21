package com.ncpbails.bfdimod.effect;

import com.google.common.annotations.VisibleForTesting;
import com.ncpbails.bfdimod.item.ModItems;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import java.util.Random;

public class YoyleMetalTransformedEffect extends MobEffect {
    public YoyleMetalTransformedEffect(MobEffectCategory category, int color) {
        super(category, color);
    }

    @VisibleForTesting
    protected static int numberOfItemsToSpawn() {
        Random rand = new Random();
        return rand.nextInt(4) + 1;
    }

    public void onMobRemoved(LivingEntity livingEntity, int amplifier, Entity.RemovalReason reason) {
        if (reason == Entity.RemovalReason.KILLED) {
            int k = numberOfItemsToSpawn();

            for(int l = 0; l < k; ++l) {
                this.spawnItems(livingEntity.level(), livingEntity.getX(), livingEntity.getY() + (double)0.5F, livingEntity.getZ());
            }
        }
    }

    private void spawnItems(Level level, double x, double y, double z) {
        ItemStack itemStack = new ItemStack(ModItems.YOYLE_METAL_NUGGET.get());
        ItemEntity itemEntity = new ItemEntity(level, x, y, z, itemStack);

        itemEntity.setDeltaMovement(level.random.nextGaussian() * 0.05, 0.2, level.random.nextGaussian() * 0.05);

        level.addFreshEntity(itemEntity);
    }
}
