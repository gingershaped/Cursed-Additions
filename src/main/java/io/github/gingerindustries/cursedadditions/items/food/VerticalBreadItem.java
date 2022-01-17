package io.github.gingerindustries.cursedadditions.items.food;

import io.github.gingerindustries.cursedadditions.CursedAdditions;
import net.minecraft.item.Food;
import net.minecraft.item.Item;

public class VerticalBreadItem extends Item {
	public VerticalBreadItem() {
        super(new Item.Properties()
                .tab(CursedAdditions.TAB)
                .food(new Food.Builder()
                        .nutrition(5)
                        .saturationMod(6)
                        .build())
        );
	}
}
