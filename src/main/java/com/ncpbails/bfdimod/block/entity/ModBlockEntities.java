package com.ncpbails.bfdimod.block.entity;

import com.ncpbails.bfdimod.BFDIMod;
import com.ncpbails.bfdimod.block.ModBlocks;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, BFDIMod.MOD_ID);

    public static final Supplier<BlockEntityType<StoneToBootOTronBlockEntity>> STONE_TO_BOOT_O_TRON_BLOCK_ENTITY =
            BLOCK_ENTITIES.register("stone_to_boot_o_tron_block_entity", () -> BlockEntityType.Builder.of(
                    StoneToBootOTronBlockEntity::new, ModBlocks.STONE_TO_BOOT_O_TRON.get()).build(null));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
