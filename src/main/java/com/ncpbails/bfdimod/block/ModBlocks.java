package com.ncpbails.bfdimod.block;

import com.ncpbails.bfdimod.BFDIMod;
import com.ncpbails.bfdimod.block.custom.*;
import com.ncpbails.bfdimod.item.ModItems;
import com.ncpbails.bfdimod.block.custom.FruitingLeaves;
import com.ncpbails.bfdimod.block.custom.ModFlammableRotatedPillarBlock;
import com.ncpbails.bfdimod.world.tree.ModTreeGrowers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(BFDIMod.MOD_ID);


    public static final DeferredBlock<Block> YOYLEBERRY_BUSH_BLOCK = BLOCKS.register("yoyleberry_bush",
            () -> new YoyleberryBushBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SWEET_BERRY_BUSH)));

    public static final DeferredBlock<Block> BLUEBERRY_BUSH_BLOCK = BLOCKS.register("blueberry_bush",
            () -> new BlueberryBushBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SWEET_BERRY_BUSH)));

    public static final DeferredBlock<Block> LIME_SAPLING = registerBlock("lime_sapling",
            () -> new SaplingBlock(ModTreeGrowers.LIME, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));

    public static final DeferredBlock<Block> LIME_LOG = registerBlock("lime_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_LOG)));

    public static final DeferredBlock<Block> LIME_WOOD = registerBlock("lime_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_WOOD)));

    public static final DeferredBlock<Block> LIME_LEAVES = registerBlock("lime_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_LEAVES)) {
                @Override public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return true; }
                @Override public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return 60; }
                @Override public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return 30; }
            });

    public static final DeferredBlock<Block> FRUITING_LIME_LEAVES = registerBlock("fruiting_lime_leaves",
            () -> new FruitingLeaves(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_LEAVES), ModItems.LIME) {
                @Override public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return true; }
                @Override public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return 60; }
                @Override public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return 30; }
            });

    public static final DeferredBlock<Block> MANGOSTEEN_SAPLING = registerBlock("mangosteen_sapling",
            () -> new SaplingBlock(ModTreeGrowers.MANGOSTEEN, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));

    public static final DeferredBlock<Block> MANGOSTEEN_LOG = registerBlock("mangosteen_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_LOG)));

    public static final DeferredBlock<Block> MANGOSTEEN_WOOD = registerBlock("mangosteen_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_WOOD)));

    public static final DeferredBlock<Block> MANGOSTEEN_LEAVES = registerBlock("mangosteen_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_LEAVES)) {
                @Override public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return true; }
                @Override public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return 60; }
                @Override public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return 30; }
            });

    public static final DeferredBlock<Block> FRUITING_MANGOSTEEN_LEAVES = registerBlock("fruiting_mangosteen_leaves",
            () -> new FruitingLeaves(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_LEAVES), ModItems.MANGOSTEEN) {
                @Override public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return true; }
                @Override public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return 60; }
                @Override public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return 30; }
            });

    public static final DeferredBlock<Block> RUBBER_SAPLING = registerBlock("rubber_sapling",
            () -> new SaplingBlock(ModTreeGrowers.RUBBER, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));

    public static final DeferredBlock<Block> RUBBER_LOG = registerBlock("rubber_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_LOG)));

    public static final DeferredBlock<Block> RUBBER_WOOD = registerBlock("rubber_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_WOOD)));

    public static final DeferredBlock<Block> RUBBER_LEAVES = registerBlock("rubber_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_LEAVES)) {
                @Override public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return true; }
                @Override public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return 60; }
                @Override public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return 30; }
            });

    public static final DeferredBlock<Block> LATEX_JUNGLE_LOG = registerBlock("latex_jungle_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_LOG)));

    public static final DeferredBlock<Block> LATEX_JUNGLE_WOOD = registerBlock("latex_jungle_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_WOOD)));



    public static final DeferredBlock<Block> REGULAR_CAKE = registerBlock("regular_cake",
            () -> new CakeBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CAKE)));

    public static final DeferredBlock<Block> YOYLECAKE = registerBlock("yoylecake",
            () -> new CakeBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CAKE)));

    public static final DeferredBlock<Block> CHOCOLATE_CAKE = registerBlock("chocolate_cake",
            () -> new CakeBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CAKE)));

    public static final DeferredBlock<Block> YOYLE_PIE = registerBlock("yoyle_pie",
            () -> new PieBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CAKE), ModItems.YOYLE_PIE_SLICE));

    public static final DeferredBlock<Block> BLUEBERRY_PIE = registerBlock("blueberry_pie",
            () -> new PieBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CAKE), ModItems.BLUEBERRY_PIE_SLICE));

    public static final DeferredBlock<Block> TRAPPED_BLUEBERRY_PIE = registerBlock("trapped_blueberry_pie",
            () -> new TrappedPieBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CAKE), ModItems.BLUEBERRY_PIE_SLICE));



    public static final DeferredBlock<Block> LOSER_CONTESTONE = registerBlock("loser_contestone",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).requiresCorrectToolForDrops()));

    public static final DeferredBlock<Block> POLISHED_LOSER_CONTESTONE = registerBlock("polished_loser_contestone",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).requiresCorrectToolForDrops()));

    public static final DeferredBlock<Block> WINNER_CONTESTONE = registerBlock("winner_contestone",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).requiresCorrectToolForDrops()));

    public static final DeferredBlock<Block> POLISHED_WINNER_CONTESTONE = registerBlock("polished_winner_contestone",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).requiresCorrectToolForDrops()));



    public static final DeferredBlock<Block> RUBY_ORE = registerBlock("ruby_ore",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIAMOND_ORE).requiresCorrectToolForDrops()));

    public static final DeferredBlock<Block> RUBY_BLOCK = registerBlock("ruby_block",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIAMOND_BLOCK).requiresCorrectToolForDrops()));

    public static final DeferredBlock<Block> NICKEL_ORE = registerBlock("nickel_ore",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_ORE).requiresCorrectToolForDrops()));

    public static final DeferredBlock<Block> NICKEL_BLOCK = registerBlock("nickel_block",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK).requiresCorrectToolForDrops().sound(SoundType.COPPER)));

    public static final DeferredBlock<Block> YOYLE_METAL_BLOCK = registerBlock("yoyle_metal_block",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK).strength(6f).requiresCorrectToolForDrops().sound(SoundType.METAL).explosionResistance(9)));



    public static final DeferredBlock<Block> RUBBER_BLOCK = registerBlock("rubber_block",
            () -> new RubberBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SLIME_BLOCK)
                    .strength(2f).requiresCorrectToolForDrops().sound(SoundType.FUNGUS).explosionResistance(2)));

    public static final DeferredBlock<Block> TIRE = registerBlock("tire",
            () -> new TireBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SLIME_BLOCK)
                    .strength(2f).requiresCorrectToolForDrops().sound(SoundType.FUNGUS).explosionResistance(2)));



    public static final DeferredBlock<Block> YOYLITE = registerBlock("yoylite",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE).requiresCorrectToolForDrops()));

    public static final DeferredBlock<Block> PLASTIC_BLOCK = registerBlock("plastic_block",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
                    .requiresCorrectToolForDrops().sound(SoundType.STONE)));



    public static final DeferredBlock<Block> RED_BLOCK = registerBlock("red_block",
            () -> new WoodenBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)
                    .requiresCorrectToolForDrops().sound(SoundType.WOOD)));

    public static final DeferredBlock<Block> ORANGE_BLOCK = registerBlock("orange_block",
            () -> new WoodenBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)
                    .requiresCorrectToolForDrops().sound(SoundType.WOOD)));

    public static final DeferredBlock<Block> YELLOW_BLOCK = registerBlock("yellow_block",
            () -> new WoodenBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)
                    .requiresCorrectToolForDrops().sound(SoundType.WOOD)));

    public static final DeferredBlock<Block> LIME_BLOCK = registerBlock("lime_block",
            () -> new WoodenBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)
                    .requiresCorrectToolForDrops().sound(SoundType.WOOD)));

    public static final DeferredBlock<Block> GREEN_BLOCK = registerBlock("green_block",
            () -> new WoodenBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)
                    .requiresCorrectToolForDrops().sound(SoundType.WOOD)));

    public static final DeferredBlock<Block> CYAN_BLOCK = registerBlock("cyan_block",
            () -> new WoodenBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)
                    .requiresCorrectToolForDrops().sound(SoundType.WOOD)));

    public static final DeferredBlock<Block> LIGHT_BLUE_BLOCK = registerBlock("light_blue_block",
            () -> new WoodenBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)
                    .requiresCorrectToolForDrops().sound(SoundType.WOOD)));

    public static final DeferredBlock<Block> BLUE_BLOCK = registerBlock("blue_block",
            () -> new WoodenBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)
                    .requiresCorrectToolForDrops().sound(SoundType.WOOD)));

    public static final DeferredBlock<Block> PURPLE_BLOCK = registerBlock("purple_block",
            () -> new WoodenBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)
                    .requiresCorrectToolForDrops().sound(SoundType.WOOD)));

    public static final DeferredBlock<Block> MAGENTA_BLOCK = registerBlock("magenta_block",
            () -> new WoodenBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)
                    .requiresCorrectToolForDrops().sound(SoundType.WOOD)));

    public static final DeferredBlock<Block> PINK_BLOCK = registerBlock("pink_block",
            () -> new WoodenBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)
                    .requiresCorrectToolForDrops().sound(SoundType.WOOD)));

    public static final DeferredBlock<Block> WHITE_BLOCK = registerBlock("white_block",
            () -> new WoodenBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)
                    .requiresCorrectToolForDrops().sound(SoundType.WOOD)));

    public static final DeferredBlock<Block> LIGHT_GREY_BLOCK = registerBlock("light_grey_block",
            () -> new WoodenBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)
                    .requiresCorrectToolForDrops().sound(SoundType.WOOD)));

    public static final DeferredBlock<Block> GREY_BLOCK = registerBlock("grey_block",
            () -> new WoodenBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)
                    .requiresCorrectToolForDrops().sound(SoundType.WOOD)));

    public static final DeferredBlock<Block> BLACK_BLOCK = registerBlock("black_block",
            () -> new WoodenBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)
                    .requiresCorrectToolForDrops().sound(SoundType.WOOD)));

    public static final DeferredBlock<Block> BROWN_BLOCK = registerBlock("brown_block",
            () -> new WoodenBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)
                    .requiresCorrectToolForDrops().sound(SoundType.WOOD)));



    public static final DeferredBlock<Block> STONE_TO_BOOT_O_TRON = registerBlock("stone_to_boot_o_tron",
            () -> new StoneToBootOTronBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK).requiresCorrectToolForDrops().sound(SoundType.COPPER)));



    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
