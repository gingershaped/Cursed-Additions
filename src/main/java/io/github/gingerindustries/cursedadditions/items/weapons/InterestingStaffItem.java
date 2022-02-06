package io.github.gingerindustries.cursedadditions.items.weapons;

import io.github.gingerindustries.cursedadditions.CursedAdditions;
import io.github.gingerindustries.cursedadditions.client.items.render.InterestingStaffRenderer;
import net.minecraft.enchantment.IVanishable;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Hand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import software.bernie.geckolib3.network.GeckoLibNetwork;
import software.bernie.geckolib3.network.ISyncable;

public class InterestingStaffItem extends Item implements IVanishable, IAnimatable, ISyncable {
	public AnimationFactory factory = new AnimationFactory(this);
	public static final int RADIUS = 5;

	public InterestingStaffItem() {
		super(new Item.Properties().durability(100).rarity(Rarity.RARE).tab(CursedAdditions.TAB).setISTER(() -> InterestingStaffRenderer::new));
		GeckoLibNetwork.registerSyncable(this);
	}
	
	private <P extends Item & IAnimatable> PlayState predicate(AnimationEvent<P> event) {
		event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.interesting_staff.crystal_spin", true));
        return PlayState.CONTINUE;
    }

	@Override
	public void onAnimationSync(int id, int state) {
		return;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void registerControllers(AnimationData data) {
		data.addAnimationController(new AnimationController(this, "controller", 20, this::predicate));
		
	}

	@Override
	public AnimationFactory getFactory() {
		return this.factory;
	}
	
	@Override
	public ActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
		Vector3d p = player.position();
		Vector3d c1 = new Vector3d(p.x-RADIUS, p.y, p.z-RADIUS);
		Vector3d c2 = new Vector3d(p.x+RADIUS, p.y+1, p.z+RADIUS);
		AxisAlignedBB box = new AxisAlignedBB(c1, c2);
		for (LivingEntity entity : world.getLoadedEntitiesOfClass(LivingEntity.class, box)) {
			Vector3d mag = p.subtract(entity.position()).normalize().scale(Math.min(RADIUS - p.distanceTo(entity.position()), 0));
			entity.hurt(DamageSource.playerAttack(player), (float) Math.min(RADIUS - p.distanceTo(entity.position()), 0));
			entity.push(mag.x, mag.y, mag.z);
		}
		return ActionResult.success(player.getItemInHand(hand));
	}
	

}
