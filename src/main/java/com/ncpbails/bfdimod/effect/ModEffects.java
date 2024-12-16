package com.ncpbails.bfdimod.effect;

import com.ncpbails.bfdimod.BFDIMod;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModEffects {
    public static final DeferredRegister<MobEffect> MOB_EFFECTS =
            DeferredRegister.create(BuiltInRegistries.MOB_EFFECT, BFDIMod.MOD_ID);

    public static final Holder<MobEffect> YOYLE_METAL_TRANSFORMED_EFFECT = MOB_EFFECTS.register("yoyle_metal_transformed",
            () -> new YoyleMetalTransformedEffect(MobEffectCategory.NEUTRAL, 0x575756)
                    .addAttributeModifier(Attributes.MOVEMENT_SPEED,
                            ResourceLocation.fromNamespaceAndPath(BFDIMod.MOD_ID, "yoyle_metal_transformed"), -0.25f,
                            AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
                    .addAttributeModifier(Attributes.ATTACK_DAMAGE,
                            ResourceLocation.fromNamespaceAndPath(BFDIMod.MOD_ID, "yoyle_metal_transformed"), +0.25f,
                            AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL));

    public static void register(IEventBus eventBus) {
        MOB_EFFECTS.register(eventBus);
    }
}
