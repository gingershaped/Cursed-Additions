package io.github.gingerindustries.cursedadditions.blocks.tileentities;

import io.github.gingerindustries.cursedadditions.init.TileEntitySetup;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.FurnaceContainer;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.tileentity.AbstractFurnaceTileEntity;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;

public class SmoothFurnaceTileEntity extends AbstractFurnaceTileEntity {
	public SmoothFurnaceTileEntity() {
		super(TileEntitySetup.SMOOTH_FURNACE_TILE.get(), IRecipeType.SMELTING);
	}
	
	@Override
	protected ITextComponent getDefaultName() {
	   return new TranslationTextComponent("container.cursedadditions.smooth_furnace");
	}
	@Override
	protected int getTotalCookTime() {
		return (int) (Math.round(super.getTotalCookTime() / 1.3));
	}
	@Override
	protected Container createMenu(int p_213906_1_, PlayerInventory p_213906_2_) {
		   return new FurnaceContainer(p_213906_1_, p_213906_2_, this, this.dataAccess);
	}
}
