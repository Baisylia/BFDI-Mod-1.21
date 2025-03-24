package com.baisylia.bfdimod.block.entity.screen;

import com.baisylia.bfdimod.BFDIMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.inventory.MenuType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModMenus {
    public static final DeferredRegister<MenuType<?>> MOD_MENUS = DeferredRegister.create(Registries.MENU, BFDIMod.MOD_ID);

    public static final Supplier<MenuType<StoneToBootOTronMenu>> STONE_TO_BOOT_O_TRON_MENU = MOD_MENUS
            .register("stone_to_boot_o_tron_menu", () -> IMenuTypeExtension.create(StoneToBootOTronMenu::new));

    public static void register(IEventBus eventBus) {
        MOD_MENUS.register(eventBus);
    }
}