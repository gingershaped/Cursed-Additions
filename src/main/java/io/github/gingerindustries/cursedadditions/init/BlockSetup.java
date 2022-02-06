package io.github.gingerindustries.cursedadditions.init;

import io.github.gingerindustries.cursedadditions.CursedAdditions;
import io.github.gingerindustries.cursedadditions.blocks.CobbledStoneBlock;
import io.github.gingerindustries.cursedadditions.blocks.InterestingBlock;
import io.github.gingerindustries.cursedadditions.blocks.SmoothFurnaceBlock;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.OreBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockSetup {
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, CursedAdditions.ID);
	
	public static final RegistryObject<Block> COBBLED_COBBLESTONE_BLOCK = BLOCKS.register("cobbled_cobblestone", () -> new Block(AbstractBlock.Properties.of(Material.STONE)));
	public static final RegistryObject<Block> COBBLED_STONE_BLOCK = BLOCKS.register("cobbled_stone", () -> new CobbledStoneBlock());
	public static final RegistryObject<Block> INTERESTING_BLOCK = BLOCKS.register("interesting_block", () -> new InterestingBlock());
	public static final RegistryObject<Block> INTERESTING_ORE = BLOCKS.register("interesting_ore", () -> new OreBlock(AbstractBlock.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(2.0F, 2.0F)));
	
	public static final RegistryObject<Block> SMOOTH_FURNACE_BLOCK = BLOCKS.register("smooth_furnace", SmoothFurnaceBlock::new);
}
