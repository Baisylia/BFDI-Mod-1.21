package com.ncpbails.bfdimod.item.custom;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.common.EffectCures;
import org.jetbrains.annotations.NotNull;

public class LatexBottleItem extends Item {

    public LatexBottleItem(Item.Properties properties) {
        super(properties);
    }

    public @NotNull ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity entityLiving) {
        super.finishUsingItem(stack, level, entityLiving);

        if (stack.isEmpty()) {
            return new ItemStack(Items.GLASS_BOTTLE);
        } else {
            if (entityLiving instanceof Player) {
                Player player = (Player)entityLiving;
                if (!player.hasInfiniteMaterials()) {
                    ItemStack itemstack = new ItemStack(Items.GLASS_BOTTLE);
                    if (!player.getInventory().add(itemstack)) {
                        player.drop(itemstack, false);
                    }
                }
            }

            return stack;
        }
    }
}
