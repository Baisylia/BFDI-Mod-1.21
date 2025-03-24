package com.baisylia.bfdimod.item;

import com.baisylia.bfdimod.BFDIMod;
import com.baisylia.bfdimod.block.ModBlocks;
import com.baisylia.bfdimod.item.custom.LatexBottleItem;
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

    public static final DeferredItem<Item> DREAM_BERRY = ITEMS.register("dream_berry", () -> new Item(new Item.Properties()
            .food(ModFoodProperties.DREAM_BERRY)));

    public static final DeferredItem<Item> YELLOW_TOMATO = ITEMS.register("yellow_tomato", () -> new Item(new Item.Properties()
            .food(ModFoodProperties.YELLOW_TOMATO)));

    public static final DeferredItem<Item> NEW_YELLOW_FACE = ITEMS.register("new_yellow_face", () -> new Item(new Item.Properties()
            .food(ModFoodProperties.YELLOW_TOMATO)));

    public static final DeferredItem<Item> GRAPES = ITEMS.register("grapes", () -> new Item(new Item.Properties()
            .food(ModFoodProperties.BERRY)));

    public static final DeferredItem<Item> BLUEBERRIES = ITEMS.register("blueberries", () -> new ItemNameBlockItem(ModBlocks.BLUEBERRY_BUSH_BLOCK.get(),
            new Item.Properties().food(ModFoodProperties.BERRY)));

    public static final DeferredItem<Item> CHERRIES = ITEMS.register("cherries", () -> new Item(new Item.Properties()
            .food(ModFoodProperties.BERRY)));

    public static final DeferredItem<Item> LIME = ITEMS.register("lime", () -> new Item(new Item.Properties()
            .food(ModFoodProperties.BERRY)));

    public static final DeferredItem<Item> MANGOSTEEN = ITEMS.register("mangosteen", () -> new Item(new Item.Properties()
            .food(ModFoodProperties.BERRY)));

    public static final DeferredItem<Item> NEW_PURPLE_FACE = ITEMS.register("new_purple_face", () -> new Item(new Item.Properties()
            .food(ModFoodProperties.BERRY)));

    public static final DeferredItem<Item> POO = ITEMS.register("poo", () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> POLISHED_POO = ITEMS.register("polished_poo", () -> new Item(new Item.Properties()));



    public static final DeferredItem<Item> REGULAR_CAKE_SLICE = ITEMS.register("regular_cake_slice", () -> new Item(new Item.Properties()
            .food(ModFoodProperties.REGULAR_CAKE_SLICE)));

    public static final DeferredItem<Item> YOYLECAKE_SLICE = ITEMS.register("yoylecake_slice", () -> new Item(new Item.Properties()
            .food(ModFoodProperties.YOYLECAKE_SLICE)));

    public static final DeferredItem<Item> CHOCOLATE_CAKE_SLICE = ITEMS.register("chocolate_cake_slice", () -> new Item(new Item.Properties()
            .food(ModFoodProperties.REGULAR_CAKE_SLICE)));

    public static final DeferredItem<Item> YOYLE_PIE_SLICE = ITEMS.register("yoyle_pie_slice", () -> new Item(new Item.Properties()
            .food(ModFoodProperties.YOYLE_PIE_SLICE)));

    public static final DeferredItem<Item> BLUEBERRY_PIE_SLICE = ITEMS.register("blueberry_pie_slice", () -> new Item(new Item.Properties()
            .food(ModFoodProperties.BLUEBERRY_PIE_SLICE)));

    public static final DeferredItem<Item> YOYLE_STEW = ITEMS.register("yoyle_stew", () -> new Item(new Item.Properties()
            .food(ModFoodProperties.YOYLE_STEW)));

    public static final DeferredItem<Item> DONUT = ITEMS.register("donut", () -> new Item(new Item.Properties()
            .food(ModFoodProperties.DONUT)));

    public static final DeferredItem<Item> CHERRY_GELATIN = ITEMS.register("cherry_gelatin", () -> new Item(new Item.Properties()
            .food(ModFoodProperties.GELATIN)));

    public static final DeferredItem<Item> GRAPE_GELATIN = ITEMS.register("grape_gelatin", () -> new Item(new Item.Properties()
            .food(ModFoodProperties.GELATIN)));

    public static final DeferredItem<Item> BLUEBERRY_GELATIN = ITEMS.register("blueberry_gelatin", () -> new Item(new Item.Properties()
            .food(ModFoodProperties.GELATIN)));

    public static final DeferredItem<Item> MELON_GELATIN = ITEMS.register("melon_gelatin", () -> new Item(new Item.Properties()
            .food(ModFoodProperties.GELATIN)));

    public static final DeferredItem<Item> LIME_GELATIN = ITEMS.register("lime_gelatin", () -> new Item(new Item.Properties()
            .food(ModFoodProperties.GELATIN)));

    public static final DeferredItem<Item> LEMON_GELATIN = ITEMS.register("lemon_gelatin", () -> new Item(new Item.Properties()
            .food(ModFoodProperties.GELATIN)));

    public static final DeferredItem<Item> CEMENT_GELATIN = ITEMS.register("cement_gelatin", () -> new Item(new Item.Properties()
            .food(ModFoodProperties.CEMENT_GELATIN)));

    public static final DeferredItem<Item> POO_GELATIN = ITEMS.register("poo_gelatin", () -> new Item(new Item.Properties()
            .food(ModFoodProperties.POO_GELATIN)));

    public static final DeferredItem<Item> CHERRY_LOLLIPOP = ITEMS.register("cherry_lollipop", () -> new Item(new Item.Properties()
            .food(ModFoodProperties.LOLLIPOP)));

    public static final DeferredItem<Item> GRAPE_LOLLIPOP = ITEMS.register("grape_lollipop", () -> new Item(new Item.Properties()
            .food(ModFoodProperties.LOLLIPOP)));

    public static final DeferredItem<Item> BLUEBERRY_LOLLIPOP = ITEMS.register("blueberry_lollipop", () -> new Item(new Item.Properties()
            .food(ModFoodProperties.LOLLIPOP)));

    public static final DeferredItem<Item> MELON_LOLLIPOP = ITEMS.register("melon_lollipop", () -> new Item(new Item.Properties()
            .food(ModFoodProperties.LOLLIPOP)));

    public static final DeferredItem<Item> LIME_LOLLIPOP = ITEMS.register("lime_lollipop", () -> new Item(new Item.Properties()
            .food(ModFoodProperties.LOLLIPOP)));

    public static final DeferredItem<Item> LEMON_LOLLIPOP = ITEMS.register("lemon_lollipop", () -> new Item(new Item.Properties()
            .food(ModFoodProperties.LOLLIPOP)));

    public static final DeferredItem<Item> CEMENT_LOLLIPOP = ITEMS.register("cement_lollipop", () -> new Item(new Item.Properties()
            .food(ModFoodProperties.CEMENT_LOLLIPOP)));

    public static final DeferredItem<Item> POO_LOLLIPOP = ITEMS.register("poo_lollipop", () -> new Item(new Item.Properties()
            .food(ModFoodProperties.POO_LOLLIPOP)));



    public static final DeferredItem<Item> PRICE_TAG = ITEMS.register("price_tag", () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> COIN = ITEMS.register("coin", () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> MATCH = ITEMS.register("match", () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> LEAF = ITEMS.register("leaf", () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> EVIL_LEAF = ITEMS.register("evil_leaf", () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> TEARDROPS = ITEMS.register("teardrops", () -> new Item(new Item.Properties()));



    public static final DeferredItem<Item> RUBY = ITEMS.register("ruby", () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> RAW_NICKEL = ITEMS.register("raw_nickel", () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> NICKEL_INGOT = ITEMS.register("nickel_ingot", () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> NICKEL_NUGGET = ITEMS.register("nickel_nugget", () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> YOYLE_METAL_INGOT = ITEMS.register("yoyle_metal_ingot", () -> new Item(new Item.Properties()));
    
    public static final DeferredItem<Item> YOYLE_METAL_NUGGET = ITEMS.register("yoyle_metal_nugget", () -> new Item(new Item.Properties()));



    public static final DeferredItem<Item> NEEDLE = ITEMS.register("needle", () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> NAIL = ITEMS.register("nail", () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> SAW = ITEMS.register("saw", () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> NICKEL = ITEMS.register("nickel", () -> new Item(new Item.Properties()));



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



    public static final DeferredItem<Item> LATEX_BOTTLE = ITEMS.register("latex_bottle", () -> new LatexBottleItem(new Item.Properties()));

    public static final DeferredItem<Item> RUBBER = ITEMS.register("rubber", () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> ERASER = ITEMS.register("eraser", () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> PENCIL = ITEMS.register("pencil", () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> BALLOON = ITEMS.register("balloon", () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> BASKETBALL = ITEMS.register("basketball", () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> TENNIS_BALL = ITEMS.register("tennis_ball", () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> BRACELET = ITEMS.register("bracelet", () -> new Item(new Item.Properties()));



    public static final DeferredItem<Item> PLASTIC = ITEMS.register("plastic", () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> PLASTIC_STICK = ITEMS.register("plastic_stick", () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> BOZO = ITEMS.register("bozo", () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> GOLF_BALL = ITEMS.register("golf_ball", () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> EIGHT_BALL = ITEMS.register("eight_ball", () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> NINE_BALL = ITEMS.register("nine_ball", () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> NICENESS_DETECTOR = ITEMS.register("niceness_detector", () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> PIN = ITEMS.register("pin", () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> PEN = ITEMS.register("pen", () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> RED_MARKER = ITEMS.register("red_marker", () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> ORANGE_MARKER = ITEMS.register("orange_marker", () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> YELLOW_MARKER = ITEMS.register("yellow_marker", () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> LIME_MARKER = ITEMS.register("lime_marker", () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> GREEN_MARKER = ITEMS.register("green_marker", () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> CYAN_MARKER = ITEMS.register("cyan_marker", () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> LIGHT_BLUE_MARKER = ITEMS.register("light_blue_marker", () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> BLUE_MARKER = ITEMS.register("blue_marker", () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> PURPLE_MARKER = ITEMS.register("purple_marker", () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> MAGENTA_MARKER = ITEMS.register("magenta_marker", () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> PINK_MARKER = ITEMS.register("pink_marker", () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> WHITE_MARKER = ITEMS.register("white_marker", () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> LIGHT_GREY_MARKER = ITEMS.register("light_grey_marker", () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> GREY_MARKER = ITEMS.register("grey_marker", () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> BLACK_MARKER = ITEMS.register("black_marker", () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> BROWN_MARKER = ITEMS.register("brown_marker", () -> new Item(new Item.Properties()));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
