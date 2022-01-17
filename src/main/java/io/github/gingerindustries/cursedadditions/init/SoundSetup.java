package io.github.gingerindustries.cursedadditions.init;

import io.github.gingerindustries.cursedadditions.CursedAdditions;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.common.util.Lazy;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class SoundSetup {
	    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, CursedAdditions.ID);
	    
	    public static final Lazy<SoundEvent> DREAM_DISC_LAZY = Lazy
	            .of(() -> new SoundEvent(new ResourceLocation(CursedAdditions.ID, "item.dream_disc")));

	    public static final RegistryObject<SoundEvent> DREAM_DISC = SOUNDS.register("item.dream_disc.disc", DREAM_DISC_LAZY);

}
