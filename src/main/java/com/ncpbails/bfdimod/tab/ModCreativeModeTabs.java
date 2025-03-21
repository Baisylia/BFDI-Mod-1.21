package com.ncpbails.bfdimod.tab;

import com.ncpbails.bfdimod.BFDIMod;
import com.ncpbails.bfdimod.block.ModBlocks;
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
                output.accept(ModItems.YOYLESEEDS);
                output.accept(ModItems.YOYLEBERRY);
                output.accept(ModItems.DREAM_BERRY);
                output.accept(ModItems.YELLOW_TOMATO);
                output.accept(ModItems.NEW_YELLOW_FACE);
                output.accept(ModItems.GRAPES);
                output.accept(ModItems.BLUEBERRIES);
                output.accept(ModItems.CHERRIES);
                output.accept(ModBlocks.LIME_SAPLING);
                output.accept(ModBlocks.LIME_LEAVES);
                output.accept(ModBlocks.FRUITING_LIME_LEAVES);
                output.accept(ModBlocks.LIME_LOG);
                output.accept(ModBlocks.LIME_WOOD);
                output.accept(ModItems.LIME);
                output.accept(ModBlocks.MANGOSTEEN_SAPLING);
                output.accept(ModBlocks.MANGOSTEEN_LEAVES);
                output.accept(ModBlocks.FRUITING_MANGOSTEEN_LEAVES);
                output.accept(ModBlocks.MANGOSTEEN_LOG);
                output.accept(ModBlocks.MANGOSTEEN_WOOD);
                output.accept(ModItems.MANGOSTEEN);
                output.accept(ModItems.NEW_PURPLE_FACE);
                output.accept(ModItems.POO);
                output.accept(ModItems.POLISHED_POO);

                output.accept(ModBlocks.YOYLECAKE);
                output.accept(ModItems.YOYLECAKE_SLICE);
                output.accept(ModBlocks.REGULAR_CAKE);
                output.accept(ModItems.REGULAR_CAKE_SLICE);
                output.accept(ModBlocks.CHOCOLATE_CAKE);
                output.accept(ModItems.CHOCOLATE_CAKE_SLICE);
                output.accept(ModBlocks.YOYLE_PIE);
                output.accept(ModItems.YOYLE_PIE_SLICE);
                output.accept(ModBlocks.BLUEBERRY_PIE);
                output.accept(ModItems.BLUEBERRY_PIE_SLICE);
                output.accept(ModBlocks.TRAPPED_BLUEBERRY_PIE);
                output.accept(ModItems.YOYLE_STEW);
                output.accept(ModItems.DONUT);
                output.accept(ModItems.CHERRY_GELATIN);
                output.accept(ModItems.GRAPE_GELATIN);
                output.accept(ModItems.BLUEBERRY_GELATIN);
                output.accept(ModItems.MELON_GELATIN);
                output.accept(ModItems.LIME_GELATIN);
                output.accept(ModItems.LEMON_GELATIN);
                output.accept(ModItems.CEMENT_GELATIN);
                output.accept(ModItems.POO_GELATIN);
                output.accept(ModItems.CHERRY_LOLLIPOP);
                output.accept(ModItems.GRAPE_LOLLIPOP);
                output.accept(ModItems.BLUEBERRY_LOLLIPOP);
                output.accept(ModItems.MELON_LOLLIPOP);
                output.accept(ModItems.LIME_LOLLIPOP);
                output.accept(ModItems.LEMON_LOLLIPOP);
                output.accept(ModItems.CEMENT_LOLLIPOP);
                output.accept(ModItems.POO_LOLLIPOP);

                output.accept(ModBlocks.LOSER_CONTESTONE);
                output.accept(ModBlocks.POLISHED_LOSER_CONTESTONE);
                output.accept(ModBlocks.WINNER_CONTESTONE);
                output.accept(ModBlocks.POLISHED_WINNER_CONTESTONE);
                output.accept(ModItems.PRICE_TAG);
                output.accept(ModItems.COIN);
                output.accept(ModItems.MATCH);
                output.accept(ModItems.LEAF);
                output.accept(ModItems.EVIL_LEAF);
                output.accept(ModItems.TEARDROPS);

                output.accept(ModBlocks.RUBY_ORE);
                output.accept(ModItems.RUBY);
                output.accept(ModBlocks.NICKEL_ORE);
                output.accept(ModItems.RAW_NICKEL);
                output.accept(ModItems.NICKEL_INGOT);
                output.accept(ModItems.NICKEL_NUGGET);
                output.accept(ModBlocks.NICKEL_BLOCK);
                output.accept(ModItems.YOYLE_METAL_INGOT);
                output.accept(ModItems.YOYLE_METAL_NUGGET);
                output.accept(ModBlocks.YOYLE_METAL_BLOCK);

                output.accept(ModItems.NEEDLE);
                output.accept(ModItems.NAIL);
                output.accept(ModItems.SAW);
                output.accept(ModItems.NICKEL);

                output.accept(ModItems.YOYLE_METAL_SWORD);
                output.accept(ModItems.YOYLE_METAL_AXE);
                output.accept(ModItems.YOYLE_METAL_PICKAXE);
                output.accept(ModItems.YOYLE_METAL_SHOVEL);
                output.accept(ModItems.YOYLE_METAL_HOE);
                output.accept(ModItems.YOYLE_METAL_KNIFE);

                output.accept(ModBlocks.RUBBER_SAPLING);
                output.accept(ModBlocks.RUBBER_LEAVES);
                output.accept(ModBlocks.RUBBER_LOG);
                output.accept(ModBlocks.RUBBER_WOOD);
                output.accept(ModBlocks.LATEX_JUNGLE_LOG);
                output.accept(ModBlocks.LATEX_JUNGLE_WOOD);
                output.accept(ModItems.LATEX_BOTTLE);
                output.accept(ModItems.RUBBER);
                output.accept(ModBlocks.RUBBER_BLOCK);
                output.accept(ModBlocks.TIRE);
                output.accept(ModItems.ERASER);
                output.accept(ModItems.PENCIL);
                output.accept(ModItems.BALLOON);
                output.accept(ModItems.BASKETBALL);
                output.accept(ModItems.TENNIS_BALL);
                output.accept(ModItems.BRACELET);

                output.accept(ModBlocks.YOYLITE);
                output.accept(ModBlocks.PLASTIC_BLOCK);
                output.accept(ModItems.PLASTIC);
                output.accept(ModItems.PLASTIC_STICK);
                output.accept(ModItems.BOZO);
                output.accept(ModItems.GOLF_BALL);
                output.accept(ModItems.EIGHT_BALL);
                output.accept(ModItems.NINE_BALL);
                output.accept(ModItems.NICENESS_DETECTOR);
                output.accept(ModItems.PIN);
                output.accept(ModItems.PEN);
                output.accept(ModItems.RED_MARKER);
                output.accept(ModItems.ORANGE_MARKER);
                output.accept(ModItems.YELLOW_MARKER);
                output.accept(ModItems.LIME_MARKER);
                output.accept(ModItems.GREEN_MARKER);
                output.accept(ModItems.CYAN_MARKER);
                output.accept(ModItems.LIGHT_BLUE_MARKER);
                output.accept(ModItems.BLUE_MARKER);
                output.accept(ModItems.PURPLE_MARKER);
                output.accept(ModItems.MAGENTA_MARKER);
                output.accept(ModItems.PINK_MARKER);
                output.accept(ModItems.WHITE_MARKER);
                output.accept(ModItems.LIGHT_GREY_MARKER);
                output.accept(ModItems.GREY_MARKER);
                output.accept(ModItems.BLACK_MARKER);
                output.accept(ModItems.BROWN_MARKER);

                output.accept(ModBlocks.RED_BLOCK);
                output.accept(ModBlocks.ORANGE_BLOCK);
                output.accept(ModBlocks.YELLOW_BLOCK);
                output.accept(ModBlocks.LIME_BLOCK);
                output.accept(ModBlocks.GREEN_BLOCK);
                output.accept(ModBlocks.CYAN_BLOCK);
                output.accept(ModBlocks.LIGHT_BLUE_BLOCK);
                output.accept(ModBlocks.BLUE_BLOCK);
                output.accept(ModBlocks.PURPLE_BLOCK);
                output.accept(ModBlocks.MAGENTA_BLOCK);
                output.accept(ModBlocks.PINK_BLOCK);
                output.accept(ModBlocks.WHITE_BLOCK);
                output.accept(ModBlocks.LIGHT_GREY_BLOCK);
                output.accept(ModBlocks.GREY_BLOCK);
                output.accept(ModBlocks.BLACK_BLOCK);
                output.accept(ModBlocks.BROWN_BLOCK);

                output.accept(ModBlocks.STONE_TO_BOOT_O_TRON);
            }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
