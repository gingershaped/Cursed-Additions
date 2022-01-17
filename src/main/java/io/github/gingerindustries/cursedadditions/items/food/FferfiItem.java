package io.github.gingerindustries.cursedadditions.items.food;

import io.github.gingerindustries.cursedadditions.CursedAdditions;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class FferfiItem extends Item {

	public FferfiItem() {
        super(new Item.Properties()
                .tab(CursedAdditions.TAB)
                .food(new Food.Builder()
                        .nutrition(2)
                        .saturationMod(0.5f)
                        .meat()
                        .build())
        );
	}
	
	@Override
	public boolean hasContainerItem(ItemStack stack) {
		return true;
	}
	@Override
	public ItemStack getContainerItem(ItemStack is) {
		return is.copy();
    }
}
