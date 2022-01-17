package io.github.gingerindustries.cursedadditions.eventhandlers;

import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import io.github.gingerindustries.cursedadditions.init.ItemSetup;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingDeathEvent;

public class DeathHandler {
	private static final Random random = new Random();
	public static final Logger LOGGER = LogManager.getLogger();

	public DeathHandler() {
		MinecraftForge.EVENT_BUS.addListener(this::onLivingDeath);
	}
	
	private void onLivingDeath(LivingDeathEvent event) {
    	Entity entity = event.getEntity();
    	if (entity.getCustomName() != null) {
    		if (entity.getCustomName().getString().equals("Dream")) {
    			if (random.nextInt(100) == 10) {
    				entity.level.addFreshEntity(new ItemEntity(entity.level, entity.getX(), entity.getY(), entity.getZ(), new ItemStack(ItemSetup.DREAM_DISC.get())));
    			}
    		}
    	}
    }

}
