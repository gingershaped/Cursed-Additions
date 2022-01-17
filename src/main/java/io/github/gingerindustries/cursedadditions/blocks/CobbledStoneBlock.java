package io.github.gingerindustries.cursedadditions.blocks;

import java.util.List;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.IBlockReader;

public class CobbledStoneBlock extends Block {

	public CobbledStoneBlock() {
		super(AbstractBlock.Properties.of(Material.STONE));
	}
	
	@Override
    public void appendHoverText(ItemStack stack, IBlockReader worldIn, List<ITextComponent> tooltip, ITooltipFlag
            flagIn) {
        tooltip.add(new StringTextComponent("Not to be confused with Cobblestone."));
        super.appendHoverText(stack, worldIn, tooltip, flagIn);
    }


}
