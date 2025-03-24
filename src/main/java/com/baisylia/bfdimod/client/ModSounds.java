package com.baisylia.bfdimod.client;

import net.minecraft.core.registries.Registries;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

import static com.baisylia.bfdimod.BFDIMod.MOD_ID;
import static com.baisylia.bfdimod.BFDIMod.locate;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(Registries.SOUND_EVENT, MOD_ID);

    public static final Supplier<SoundEvent> STONE_TO_BOOT_O_TRON_CRACKLE = SOUND_EVENTS.register("stone_to_boot_o_tron_crackle",
            () -> SoundEvent.createVariableRangeEvent(locate( "block.stone_to_boot_o_tron.crackle")));

    public static final Supplier<SoundEvent> STONE_TO_BOOT_O_TRON_OPEN = SOUND_EVENTS.register("stone_to_boot_o_tron_open",
            () -> SoundEvent.createVariableRangeEvent(locate( "block.stone_to_boot_o_tron.open")));

    public static final Supplier<SoundEvent> STONE_TO_BOOT_O_TRON_CLOSE = SOUND_EVENTS.register("stone_to_boot_o_tron_close",
            () -> SoundEvent.createVariableRangeEvent(locate( "block.stone_to_boot_o_tron.close")));

    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }
}