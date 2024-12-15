package com.ncpbails.bfdimod.item;

import com.ncpbails.bfdimod.BFDIMod;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(BFDIMod.MOD_ID);


    public static final DeferredItem<Item> YOYLEBERRY = ITEMS.register("yoyleberry", () -> new Item(new Item.Properties()
            .food(ModFoodProperties.YOYLEBERRY)));

    public static final DeferredItem<Item> YELLOW_TOMATO = ITEMS.register("yellow_tomato", () -> new Item(new Item.Properties()
            .food(ModFoodProperties.YELLOW_TOMATO)));

    public static final DeferredItem<Item> YOYLE_METAL_INGOT = ITEMS.register("yoyle_metal_ingot", () -> new Item(new Item.Properties()));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
