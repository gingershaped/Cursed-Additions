package io.github.gingerindustries.cursedadditions.entities;

import javax.annotation.Nullable;

import net.minecraft.entity.EntitySize;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.Pose;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.PanicGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.EntityPredicates;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Util;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.World;

public class SuspiciousCreatureEntity extends MonsterEntity {
	private static final DataParameter<Boolean> DATA_TYPE_IS_HOSTILE = EntityDataManager
			.defineId(SuspiciousCreatureEntity.class, DataSerializers.BOOLEAN);

	public SuspiciousCreatureEntity(EntityType<? extends MonsterEntity> p_i48553_1_, World p_i48553_2_) {
		super(p_i48553_1_, p_i48553_2_);
	}

	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(0, new SwimGoal(this));
		this.goalSelector.addGoal(4, new LookAtGoal(this, this.getClass(), 6.0F));
		this.goalSelector.addGoal(5, new LookRandomlyGoal(this));
	}

	public Boolean getRandomHostility(IServerWorld world) {
		if (MonsterEntity.isDarkEnoughToSpawn(world, this.blockPosition(), this.getRandom())) {
			if (this.getRandom().nextInt(20) == 0) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	@Nullable
	public ILivingEntityData finalizeSpawn(IServerWorld world, DifficultyInstance difficulty, SpawnReason reason,
			@Nullable ILivingEntityData data, @Nullable CompoundNBT nbt) {
		Boolean hostile = this.getRandomHostility(world);
		if (data instanceof SuspiciousCreatureData) {
			hostile = ((SuspiciousCreatureEntity.SuspiciousCreatureData) data).isHostile;
		} else {
			data = new SuspiciousCreatureData(hostile);
		}
		this.setHostile(hostile);

		return super.finalizeSpawn(world, difficulty, reason, data, nbt);
	}

	public void addAdditionalSaveData(CompoundNBT data) {
		super.addAdditionalSaveData(data);
		data.putBoolean("IsHostile", this.getHostile());
	}

	public void readAdditionalSaveData(CompoundNBT data) {
		super.readAdditionalSaveData(data);
		this.setHostile(data.getBoolean("IsHostile"));
	}
	
	protected void defineSynchedData() {
	      super.defineSynchedData();
	      this.entityData.define(DATA_TYPE_IS_HOSTILE, false);
	   }

	public Boolean getHostile() {
		return this.entityData.get(DATA_TYPE_IS_HOSTILE);
	}

	public void setHostile(Boolean hostile) {
		if (hostile) {
			this.getAttribute(Attributes.ARMOR).setBaseValue(2.0D);
			this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.25D);
			this.getAttribute(Attributes.ATTACK_DAMAGE).setBaseValue(4.5D);
			this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.3D, true));
			this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, false));
			this.targetSelector.addGoal(3,
					new NearestAttackableTargetGoal<>(this, this.getClass(), 7, true, true, (entity) -> {
						return !entity.getEntityData().get(DATA_TYPE_IS_HOSTILE);
					}));
			if (!this.hasCustomName()) {
				this.setCustomName(new TranslationTextComponent(
						Util.makeDescriptionId("entity", new ResourceLocation("cursedadditions:hostile_suspicious_creature"))));
			}
		} else {
			this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.25D);
			this.goalSelector.addGoal(1, new PanicGoal(this, 1.25D));
			this.goalSelector.addGoal(2, new AvoidEntityGoal<>(this, ServerPlayerEntity.class, 10F, 1.2D, 1.2D));
			this.goalSelector.addGoal(2, new AvoidEntityGoal<>(this, this.getClass(), (entity) -> {
				return entity.getEntityData().get(DATA_TYPE_IS_HOSTILE);
			}, 30F, 1.3D, 1.3D, EntityPredicates.NO_CREATIVE_OR_SPECTATOR::test));
			this.goalSelector.addGoal(3, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
		}
		this.entityData.set(DATA_TYPE_IS_HOSTILE, hostile);
	}

	public static AttributeModifierMap.MutableAttribute setCustomAttributes() {
		return MonsterEntity.createMonsterAttributes().add(Attributes.MAX_HEALTH, 10.0D)
				.add(Attributes.FOLLOW_RANGE, 16.0F);
	}

	protected float getStandingEyeHeight(Pose p_213348_1_, EntitySize p_213348_2_) {
		return 2F;
	}

	public static class SuspiciousCreatureData implements ILivingEntityData {
		public final Boolean isHostile;

		public SuspiciousCreatureData(Boolean isHostile) {
			this.isHostile = isHostile;
		}
	}

}
