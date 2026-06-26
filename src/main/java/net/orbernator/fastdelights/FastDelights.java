package net.orbernator.fastdelights;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.loading.FMLEnvironment;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import net.orbernator.fastdelights.block.ModBlocks;
import net.orbernator.fastdelights.block.entity.ModBlockEntities;
import net.orbernator.fastdelights.fluid.ModFluids;
import net.orbernator.fastdelights.item.ModItems;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;


// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod("fastdelights")
public class FastDelights {
    public static final String MODID = "fastdelights";
    public static final Logger LOGGER = LogUtils.getLogger();

    public FastDelights(IEventBus eventBus, ModContainer modContainer) {
        if(FMLEnvironment.dist == Dist.CLIENT)
            modContainer.registerExtensionPoint(IConfigScreenFactory.class, ConfigurationScreen::new);

        ModItems.ITEMS.register(eventBus);
        ModBlocks.BLOCKS.register(eventBus);
        ModBlockEntities.BLOCK_ENTITIES.register(eventBus);
        ModFluids.FLUIDS.register(eventBus);
        ModFluids.FLUID_TYPES.register(eventBus);
        ModCreativeTabs.CREATIVE_MODE_TABS.register(eventBus);

        // Register ourselves for server and other game events we are interested in.
        // Note that this is necessary if and only if we want *this* class (ExampleMod) to respond directly to events.
        // Do not add this line if there are no @SubscribeEvent-annotated functions in this class, like onServerStarting() below.
        NeoForge.EVENT_BUS.register(this);


        // Register our mod's ModConfigSpec so that FML can create and load the config file for us
        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }


    }
