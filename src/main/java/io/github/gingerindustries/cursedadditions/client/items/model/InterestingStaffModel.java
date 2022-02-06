package io.github.gingerindustries.cursedadditions.client.items.model;

import io.github.gingerindustries.cursedadditions.CursedAdditions;
import io.github.gingerindustries.cursedadditions.items.weapons.InterestingStaffItem;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class InterestingStaffModel extends AnimatedGeoModel<InterestingStaffItem> {

	@Override
	public ResourceLocation getAnimationFileLocation(InterestingStaffItem animatable) {
		// TODO Auto-generated method stub
		return new ResourceLocation(CursedAdditions.ID, "animations/interesting_staff/crystal_spin.json");
	}

	@Override
	public ResourceLocation getModelLocation(InterestingStaffItem object) {
		// TODO Auto-generated method stub
		return new ResourceLocation(CursedAdditions.ID, "geo/interesting_staff.json");
	}

	@Override
	public ResourceLocation getTextureLocation(InterestingStaffItem object) {
		// TODO Auto-generated method stub
		return new ResourceLocation(CursedAdditions.ID, "textures/items/interesting_staff/texture.png");
	}

}
