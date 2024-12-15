package com.ncpbails.bfdimod.tab;

import com.ncpbails.bfdimod.BFDIMod;
import com.ncpbails.bfdimod.item.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, BFDIMod.MOD_ID);

    public static final Supplier<CreativeModeTab> BFDI_TAB = CREATIVE_MODE_TAB.register("bfdi_tab", () -> CreativeModeTab.builder()
            .icon(() -> new ItemStack(ModItems.YOYLEBERRY.get()))
            .title(Component.translatable("creativetab.ncpbails.bfdi_tab"))
            .displayItems((itemDisplayParameters, output) -> {
                output.accept(ModItems.YOYLEBERRY);
                output.accept(ModItems.YELLOW_TOMATO);
                output.accept(ModItems.YOYLE_METAL_INGOT);
            }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
