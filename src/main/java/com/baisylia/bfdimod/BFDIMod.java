package com.baisylia.bfdimod;

import com.baisylia.bfdimod.block.ModBlocks;
import com.baisylia.bfdimod.block.entity.ModBlockEntities;
import com.baisylia.bfdimod.block.entity.screen.ModMenus;
import com.baisylia.bfdimod.block.entity.screen.StoneToBootOTronScreen;
import com.baisylia.bfdimod.client.ModSounds;
import com.baisylia.bfdimod.effect.ModEffects;
import com.baisylia.bfdimod.recipe.ModRecipes;
import com.baisylia.bfdimod.tab.ModCreativeModeTabs;
import com.baisylia.bfdimod.item.ModItems;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.fml.loading.FMLEnvironment;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(BFDIMod.MOD_ID)
public class BFDIMod
{
    public static final String MOD_ID = "bfdimod";
    private static final Logger LOGGER = LogUtils.getLogger();

    public BFDIMod(IEventBus modEventBus, ModContainer modContainer)
    {
        modEventBus.addListener(this::commonSetup);

        ModCreativeModeTabs.register(modEventBus);
        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModEffects.register(modEventBus);
        ModBlockEntities.register(modEventBus);
        ModMenus.register(modEventBus);
        ModRecipes.register(modEventBus);

        NeoForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative);
        modEventBus.addListener(this::registerScreens);
        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);

        if (FMLEnvironment.dist.isClient())
            ModSounds.register(modEventBus);
    }

    public static ResourceLocation locate(String identifier) {
        return ResourceLocation.fromNamespaceAndPath(MOD_ID, identifier);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {

    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {
        //if(event.getTabKey() == CreativeModeTabs.FOOD_AND_DRINKS) {
        //    event.accept(ModItems.YOYLEBERRY);
        //}
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {

    }

    public void registerScreens(RegisterMenuScreensEvent event) {
        event.register(ModMenus.STONE_TO_BOOT_O_TRON_MENU.get(), StoneToBootOTronScreen::new);
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @EventBusSubscriber(modid = MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.YOYLEBERRY_BUSH_BLOCK.get(), RenderType.cutoutMipped());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.BLUEBERRY_BUSH_BLOCK.get(), RenderType.cutoutMipped());
        }
    }
}
