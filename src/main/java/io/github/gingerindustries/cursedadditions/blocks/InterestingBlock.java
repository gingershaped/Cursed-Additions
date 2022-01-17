package io.github.gingerindustries.cursedadditions.blocks;

import java.util.List;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.IBlockReader;

public class InterestingBlock extends Block {

	public InterestingBlock() {
		super(AbstractBlock.Properties.of(Material.METAL)
				.sound(SoundType.METAL)
				.harvestLevel(2)
				.lightLevel(((state) -> {
	                return 3;
	            }))
				.jumpFactor(-1.0F)
				);
	}
	
	@Override
    public void appendHoverText(ItemStack stack, IBlockReader worldIn, List<ITextComponent> tooltip, ITooltipFlag
            flagIn) {
        tooltip.add(new StringTextComponent("Its purpose is unclear."));
        super.appendHoverText(stack, worldIn, tooltip, flagIn);
    }

}
