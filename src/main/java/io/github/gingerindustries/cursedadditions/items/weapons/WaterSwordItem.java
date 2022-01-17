package io.github.gingerindustries.cursedadditions.items.weapons;

import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import io.github.gingerindustries.cursedadditions.CursedAdditions;
import io.github.gingerindustries.cursedadditions.items.weapons.tiers.CursedTiers;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.SwordItem;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

public class WaterSwordItem extends SwordItem {
	private static final Random random = new Random();
	private static final Logger LOGGER = LogManager.getLogger();

	public WaterSwordItem() {
		super(CursedTiers.WATER_SWORD, -1, -2.4f, (new Item.Properties())
				.tab(CursedAdditions.TAB)
    	);
	}
	
	@Override
	public boolean onLeftClickEntity(ItemStack stack, PlayerEntity player, Entity target) {
		LOGGER.debug("Hurt enemy: " + target.getType());
		if (target.getType() == EntityType.FIREBALL) {
			target.kill();
			World world = target.level;
			target.playSound(SoundEvents.LAVA_EXTINGUISH, 1, 1);
			world.addFreshEntity(new ItemEntity(world, target.getX(), target.getY(), target.getZ(), new ItemStack(Items.COBBLESTONE)));
			if (random.nextInt(3) == 0) {
				world.addFreshEntity(new ItemEntity(world, target.getX(), target.getY(), target.getZ(), new ItemStack(Items.GUNPOWDER)));
			}
			
			
		}
		if (target.getType() == EntityType.ENDERMAN) {
			stack.hurtAndBreak(1, player, (p_220045_0_) -> {
		         p_220045_0_.broadcastBreakEvent(EquipmentSlotType.MAINHAND);
		      });
			target.hurt(DamageSource.mobAttack(player), 20);
		}
		if (target.getType() == EntityType.BLAZE || target.getType() == EntityType.MAGMA_CUBE) {
			stack.hurtAndBreak(1, player, (p_220045_0_) -> {
		         p_220045_0_.broadcastBreakEvent(EquipmentSlotType.MAINHAND);
		      });
			target.hurt(DamageSource.mobAttack(player), 7);
		}
		return super.onLeftClickEntity(stack, player, target);
	}
	
	@Override
    public void appendHoverText(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add(new StringTextComponent("Very effective against Endermen and some nether mobs. Ideal for Ghast defense."));
        super.appendHoverText(stack, worldIn, tooltip, flagIn);
    }


}
