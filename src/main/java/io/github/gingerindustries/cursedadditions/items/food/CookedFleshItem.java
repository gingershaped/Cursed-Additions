package io.github.gingerindustries.cursedadditions.items.food;

import io.github.gingerindustries.cursedadditions.CursedAdditions;
import net.minecraft.item.Food;
import net.minecraft.item.Item;

public class CookedFleshItem extends Item {

	public CookedFleshItem() {
        super(new Item.Properties()
                .tab(CursedAdditions.TAB)
                .food(new Food.Builder()
                        .nutrition(10)
                        .saturationMod(15)
                        .meat()
                        .build())
        );

	}

}
