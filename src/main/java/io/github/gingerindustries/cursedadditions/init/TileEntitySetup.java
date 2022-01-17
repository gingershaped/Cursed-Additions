package io.github.gingerindustries.cursedadditions.init;

import io.github.gingerindustries.cursedadditions.CursedAdditions;
import io.github.gingerindustries.cursedadditions.blocks.tileentities.SmoothFurnaceTileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class TileEntitySetup {
	
	public static final DeferredRegister<TileEntityType<?>> TILES = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, CursedAdditions.ID);
	
	public static final RegistryObject<TileEntityType<SmoothFurnaceTileEntity>> SMOOTH_FURNACE_TILE = TILES.register("smooth_furnace", () -> TileEntityType.Builder.of(SmoothFurnaceTileEntity::new, BlockSetup.SMOOTH_FURNACE_BLOCK.get()).build(null));

}
