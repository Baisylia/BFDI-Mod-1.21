package com.ncpbails.bfdimod.item;

import com.ncpbails.bfdimod.BFDIMod;
import com.ncpbails.bfdimod.block.ModBlocks;
import net.minecraft.world.item.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import vectorwing.farmersdelight.common.item.KnifeItem;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(BFDIMod.MOD_ID);


    public static final DeferredItem<Item> YOYLESEEDS = ITEMS.register("yoyleseeds",
            () -> new ItemNameBlockItem(ModBlocks.YOYLEBERRY_BUSH_BLOCK.get(), new Item.Properties()));

    public static final DeferredItem<Item> YOYLEBERRY = ITEMS.register("yoyleberry", () -> new Item(new Item.Properties()
            .food(ModFoodProperties.YOYLEBERRY)));

    public static final DeferredItem<Item> YOYLECAKE_SLICE = ITEMS.register("yoylecake_slice", () -> new Item(new Item.Properties()
            .food(ModFoodProperties.YOYLECAKE_SLICE)));

    public static final DeferredItem<Item> REGULAR_CAKE_SLICE = ITEMS.register("regular_cake_slice", () -> new Item(new Item.Properties()
            .food(ModFoodProperties.REGULAR_CAKE)));

    public static final DeferredItem<Item> DREAM_BERRY = ITEMS.register("dream_berry", () -> new Item(new Item.Properties()
            .food(ModFoodProperties.DREAM_BERRY)));

    public static final DeferredItem<Item> YELLOW_TOMATO = ITEMS.register("yellow_tomato", () -> new Item(new Item.Properties()
            .food(ModFoodProperties.YELLOW_TOMATO)));

    public static final DeferredItem<Item> YOYLE_METAL_INGOT = ITEMS.register("yoyle_metal_ingot", () -> new Item(new Item.Properties()));
    
    public static final DeferredItem<Item> YOYLE_METAL_NUGGET = ITEMS.register("yoyle_metal_nugget", () -> new Item(new Item.Properties()));

    public static final DeferredItem<SwordItem> YOYLE_METAL_SWORD = ITEMS.register("yoyle_metal_sword",
            () -> new SwordItem(ModToolTiers.YOYLE_METAL, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ModToolTiers.YOYLE_METAL, 3, -2.4f))));
    
    public static final DeferredItem<PickaxeItem> YOYLE_METAL_PICKAXE = ITEMS.register("yoyle_metal_pickaxe",
            () -> new PickaxeItem(ModToolTiers.YOYLE_METAL, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModToolTiers.YOYLE_METAL, 1.0F, -2.8f))));
    
    public static final DeferredItem<ShovelItem> YOYLE_METAL_SHOVEL = ITEMS.register("yoyle_metal_shovel",
            () -> new ShovelItem(ModToolTiers.YOYLE_METAL, new Item.Properties()
                    .attributes(ShovelItem.createAttributes(ModToolTiers.YOYLE_METAL, 1.5F, -3.0f))));
    
    public static final DeferredItem<AxeItem> YOYLE_METAL_AXE = ITEMS.register("yoyle_metal_axe",
            () -> new AxeItem(ModToolTiers.YOYLE_METAL, new Item.Properties()
                    .attributes(AxeItem.createAttributes(ModToolTiers.YOYLE_METAL, 5.0F, -3.0f))));
    
    public static final DeferredItem<HoeItem> YOYLE_METAL_HOE = ITEMS.register("yoyle_metal_hoe",
            () -> new HoeItem(ModToolTiers.YOYLE_METAL, new Item.Properties()
                    .attributes(HoeItem.createAttributes(ModToolTiers.YOYLE_METAL, -4.0F, 0.0f))));

    public static final DeferredItem<KnifeItem> YOYLE_METAL_KNIFE = ITEMS.register("yoyle_metal_knife",
            () -> new KnifeItem(ModToolTiers.YOYLE_METAL, new Item.Properties()
                    .attributes(HoeItem.createAttributes(ModToolTiers.YOYLE_METAL, -4.0F, 0.0f))));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
