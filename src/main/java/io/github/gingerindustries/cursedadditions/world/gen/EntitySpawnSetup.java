package io.github.gingerindustries.cursedadditions.world.gen;

import java.util.Arrays;
import java.util.HashSet;

import io.github.gingerindustries.cursedadditions.CursedAdditions;
import io.github.gingerindustries.cursedadditions.init.EntityTypeSetup;
import net.minecraft.entity.EntityClassification;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.MobSpawnInfo.Spawners;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.registries.ForgeRegistries;


//@Mod.EventBusSubscriber(modid = CursedAdditions.ID, bus = Mod.EventBusSubscriber.Bus.MOD)
// Disabled until I can figure out what the issue is
public class EntitySpawnSetup {
	public static HashSet<Biome.Category> SUSPICIOUS_ENTITY_SPAWN_BIOME_CATEGORIES = new HashSet<Biome.Category>(Arrays.asList(Biome.Category.FOREST, Biome.Category.PLAINS));

	//@SubscribeEvent
	public static void generateOres(FMLLoadCompleteEvent event) {
		for (Biome biome : ForgeRegistries.BIOMES) {
			if (SUSPICIOUS_ENTITY_SPAWN_BIOME_CATEGORIES.contains(biome.getBiomeCategory())) {
				biome.getMobSettings().getMobs(EntityClassification.CREATURE).add(new Spawners(EntityTypeSetup.SUSPICIOUS_CREATURE_ENTITY.get(), 5, 1, 6));
			}
		}
	}

}
