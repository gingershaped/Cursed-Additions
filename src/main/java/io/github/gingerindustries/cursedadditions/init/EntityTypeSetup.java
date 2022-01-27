package io.github.gingerindustries.cursedadditions.init;

import io.github.gingerindustries.cursedadditions.CursedAdditions;
import io.github.gingerindustries.cursedadditions.entities.SuspiciousCreatureEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.item.SpawnEggItem;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class EntityTypeSetup {

	public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES, CursedAdditions.ID);

	// Entity types
    public static final RegistryObject<EntityType<SuspiciousCreatureEntity>> SUSPICIOUS_ENTITY = ENTITY_TYPES.register("suspicious_creature",
            () -> EntityType.Builder.<SuspiciousCreatureEntity>of(SuspiciousCreatureEntity::new, EntityClassification.MONSTER)
                    .sized(1.0f, 2.0f) // Hitbox Size
                    .clientTrackingRange(8)
                    .build("suspicious_creature"));

}
