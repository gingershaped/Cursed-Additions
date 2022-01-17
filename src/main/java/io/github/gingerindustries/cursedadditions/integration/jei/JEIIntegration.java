package io.github.gingerindustries.cursedadditions.integration.jei;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import io.github.gingerindustries.cursedadditions.CursedAdditions;
import io.github.gingerindustries.cursedadditions.init.ItemSetup;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.constants.VanillaRecipeCategoryUid;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

// TODO Need to make it so that it shows the time it takes to smelt accurately
@JeiPlugin
public class JEIIntegration implements IModPlugin {
	public static final Logger LOGGER = LogManager.getLogger();
	
	@Override
	public ResourceLocation getPluginUid() {
		return new ResourceLocation(CursedAdditions.ID, "jei_plugin_" + CursedAdditions.ID);
	}
	
	public void registerRecipeCatalysts(IRecipeCatalystRegistration registry) {
		LOGGER.info("JEI plugin inititalized");
		registry.addRecipeCatalyst(new ItemStack(ItemSetup.SMOOTH_FURNACE_ITEM.get()), VanillaRecipeCategoryUid.FURNACE);
		registry.addRecipeCatalyst(new ItemStack(ItemSetup.SMOOTH_FURNACE_ITEM.get()), VanillaRecipeCategoryUid.FUEL);
	}

}
