package io.github.gingerindustries.cursedadditions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import io.github.gingerindustries.cursedadditions.client.entities.render.CursedRenderers;
import io.github.gingerindustries.cursedadditions.entities.SuspiciousCreatureEntity;
import io.github.gingerindustries.cursedadditions.eventhandlers.DeathHandler;
import io.github.gingerindustries.cursedadditions.init.BlockSetup;
import io.github.gingerindustries.cursedadditions.init.EntityTypeSetup;
import io.github.gingerindustries.cursedadditions.init.ItemSetup;
import io.github.gingerindustries.cursedadditions.init.SoundSetup;
import io.github.gingerindustries.cursedadditions.init.TileEntitySetup;
import io.github.gingerindustries.cursedadditions.world.gen.OreGenSetup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import software.bernie.geckolib3.GeckoLib;

@Mod("cursedadditions")
public class CursedAdditions {
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String ID = "cursedadditions";

    public CursedAdditions() {
    	GeckoLib.initialize();
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMC);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(CursedRenderers::register);
        
        EntityTypeSetup.ENTITY_TYPES.register(FMLJavaModLoadingContext.get().getModEventBus());
        BlockSetup.BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        ItemSetup.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        SoundSetup.SOUNDS.register(FMLJavaModLoadingContext.get().getModEventBus());
        TileEntitySetup.TILES.register(FMLJavaModLoadingContext.get().getModEventBus());
        
        MinecraftForge.EVENT_BUS.addListener(EventPriority.HIGH, OreGenSetup::generateOres);
        
        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
        
        //Event handler setup
        new DeathHandler();
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        // some preinit code
        LOGGER.info("Setup complete, let's do this!");
    }
    private void doClientStuff(final FMLClientSetupEvent event) {
        // do something that can only be done on the client
        //LOGGER.info("Got game settings {}", event.getMinecraftSupplier().get().options);
    }

    private void enqueueIMC(final InterModEnqueueEvent event)
    {
        // some example code to dispatch IMC to another mod
        //InterModComms.sendTo("cursedadditions", "helloworld", () -> { LOGGER.info("Hello world from the MDK"); return "Hello world";});
    }

    private void processIMC(final InterModProcessEvent event)
    {
        // some example code to receive and process InterModComms from other mods
        //LOGGER.info("Got IMC {}", event.getIMCStream().
                //map(m->m.getMessageSupplier().get()).
                //collect(Collectors.toList()));
    }
    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {
        // do something when the server starts
        //LOGGER.info("HELLO from server starting");
    }

    // You can use EventBusSubscriber to automatically subscribe events on the contained class (this is subscribing to the MOD
    // Event bus for receiving Registry Events)
    @Mod.EventBusSubscriber(modid=ID, bus=Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
        @SubscribeEvent
        public static void entityAttributeCreationEvent(EntityAttributeCreationEvent event) {
        	LOGGER.info("Entity attributes created");
    		event.put(EntityTypeSetup.SUSPICIOUS_CREATURE_ENTITY.get(), SuspiciousCreatureEntity.setCustomAttributes().build());
    	}
    }
    
    public static final ItemGroup TAB = new ItemGroup("cursedTab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ItemSetup.SMOOTH_FURNACE_ITEM.get());
        }
    };
    
}
