package io.github.gingerindustries.cursedadditions.discs;

import io.github.gingerindustries.cursedadditions.CursedAdditions;
import io.github.gingerindustries.cursedadditions.init.SoundSetup;
import net.minecraft.item.Item;
import net.minecraft.item.MusicDiscItem;
import net.minecraft.item.Rarity;

public class DreamDiscItem extends MusicDiscItem {

	public DreamDiscItem() {
		//TODO: Need to update this to the new constructor
		super(14, SoundSetup.DREAM_DISC_LAZY.get(), new Item.Properties().stacksTo(1).tab(CursedAdditions.TAB).rarity(Rarity.RARE));
	}

}
