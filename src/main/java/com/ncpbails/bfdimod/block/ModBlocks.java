package com.ncpbails.bfdimod.block;

import com.ncpbails.bfdimod.BFDIMod;
import com.ncpbails.bfdimod.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CakeBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(BFDIMod.MOD_ID);


    public static final DeferredBlock<Block> YOYLE_METAL_BLOCK = registerBlock("yoyle_metal_block",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK)
                    .strength(6f).requiresCorrectToolForDrops().sound(SoundType.METAL).explosionResistance(9)));

    public static final DeferredBlock<Block> YOYLEBERRY_BUSH_BLOCK = BLOCKS.register("yoyleberry_bush",
            () -> new YoyleberryBushBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SWEET_BERRY_BUSH)));

    public static final DeferredBlock<Block> REGULAR_CAKE = registerBlock("regular_cake",
            () -> new CakeBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CAKE)));

    public static final DeferredBlock<Block> YOYLECAKE = registerBlock("yoylecake",
            () -> new CakeBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CAKE)));


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
