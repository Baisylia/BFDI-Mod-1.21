package com.ncpbails.bfdimod.block.custom;

import com.google.common.annotations.VisibleForTesting;
import com.ncpbails.bfdimod.block.ModBlocks;
import com.ncpbails.bfdimod.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.BottleItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.common.ItemAbility;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public class ModFlammableRotatedPillarBlock extends RotatedPillarBlock {
    public ModFlammableRotatedPillarBlock(Properties properties) {
        super(properties);
    }

    @Override
    public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return true;
    }

    @Override
    public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return 5;
    }

    @Override
    public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return 5;
    }

    @Override
    public @Nullable BlockState getToolModifiedState(BlockState state, UseOnContext context,
            ItemAbility itemAbility, boolean simulate) {
        if(context.getItemInHand().getItem() instanceof AxeItem) {
            if(state.is(ModBlocks.LIME_LOG)) {
                return Blocks.STRIPPED_OAK_LOG.defaultBlockState().setValue(AXIS, state.getValue(AXIS));
            }

            if(state.is(ModBlocks.LIME_WOOD)) {
                return Blocks.STRIPPED_OAK_WOOD.defaultBlockState().setValue(AXIS, state.getValue(AXIS));
            }

            if(state.is(ModBlocks.MANGOSTEEN_LOG)) {
                return Blocks.STRIPPED_JUNGLE_LOG.defaultBlockState().setValue(AXIS, state.getValue(AXIS));
            }

            if(state.is(ModBlocks.MANGOSTEEN_WOOD)) {
                return Blocks.STRIPPED_JUNGLE_WOOD.defaultBlockState().setValue(AXIS, state.getValue(AXIS));
            }

            if(state.is(ModBlocks.RUBBER_LOG)) {
                Random rand = new Random();
                if (rand.nextInt(3) == 1) {
                    return Blocks.STRIPPED_JUNGLE_LOG.defaultBlockState().setValue(AXIS, state.getValue(AXIS));
                }
                else {
                    return ModBlocks.LATEX_JUNGLE_LOG.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
                }
            }

            if(state.is(ModBlocks.RUBBER_WOOD)) {
                Random rand = new Random();
                if (rand.nextInt(3) == 1) {
                    return Blocks.STRIPPED_JUNGLE_WOOD.defaultBlockState().setValue(AXIS, state.getValue(AXIS));
                }
                else {
                    return ModBlocks.LATEX_JUNGLE_WOOD.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
                }
            }
        }
        if(context.getItemInHand().getItem() instanceof BottleItem) {
            if(state.is(ModBlocks.LATEX_JUNGLE_LOG)) {
                doLatex(context);
                return Blocks.STRIPPED_JUNGLE_LOG.defaultBlockState().setValue(AXIS, state.getValue(AXIS));
            }

            if(state.is(ModBlocks.LATEX_JUNGLE_WOOD)) {
                doLatex(context);
                return Blocks.STRIPPED_JUNGLE_WOOD.defaultBlockState().setValue(AXIS, state.getValue(AXIS));
            }
        }

        return super.getToolModifiedState(state, context, itemAbility, simulate);
    }


    public void doLatex(UseOnContext context) {
        context.getItemInHand().shrink(1);
        ItemStack latexBottle = new ItemStack(ModItems.LATEX_BOTTLE.get());

        if (!context.getPlayer().addItem(latexBottle)) {
            context.getPlayer().drop(latexBottle, false);
        }
    }
}
