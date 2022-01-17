package io.github.gingerindustries.cursedadditions.items.weapons;

import io.github.gingerindustries.cursedadditions.CursedAdditions;
import io.github.gingerindustries.cursedadditions.items.weapons.tiers.CursedTiers;
import net.minecraft.item.Item;
import net.minecraft.item.SwordItem;

public class CobblestoneStickItem extends SwordItem {

	public CobblestoneStickItem() {
		super(CursedTiers.COBBLESTONE_STICK, 3, -2.4f, (new Item.Properties())
				.tab(CursedAdditions.TAB)
				.durability(10)
				.setNoRepair()
    	);
	}
	
}