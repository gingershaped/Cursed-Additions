package io.github.gingerindustries.cursedadditions.client.entities.model;

import io.github.gingerindustries.cursedadditions.entities.SuspiciousCreatureEntity;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class SuspiciousCreatureModel<T extends SuspiciousCreatureEntity> extends BipedModel<T> {
	public SuspiciousCreatureModel() {
		super(0.5F, 0F, 64, 64);
		this.body.addBox(-4.0F, 0.0F, 2.0F, 8.0F, 12.0F, 4.0F, 0); // Backpack thing
	}
	
}