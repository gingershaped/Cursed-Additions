package io.github.gingerindustries.cursedadditions.client.entities.render;

import io.github.gingerindustries.cursedadditions.CursedAdditions;
import io.github.gingerindustries.cursedadditions.init.EntityTypeSetup;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = CursedAdditions.ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class CursedRenderers {

	@SubscribeEvent
    public static void register(final FMLClientSetupEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(EntityTypeSetup.SUSPICIOUS_ENTITY.get(),
                renderManager -> new SuspiciousCreatureRenderer(renderManager)
        );
    }
}
