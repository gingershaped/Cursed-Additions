package io.github.gingerindustries.cursedadditions.items.weapons.tiers;
import java.util.function.Supplier;

import io.github.gingerindustries.cursedadditions.init.ItemSetup;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;

public enum CursedTiers implements IItemTier {
	
	COBBLESTONE_STICK(1, 10, 3.0F, 4.0F, 5, () -> {
        return Ingredient.of(ItemSetup.COBBLESTONE_STICK.get());
    //You may also return Items.EMPTY if it has no material repair type
    }),
	WATER_SWORD(0, 121, 1F, 0F, 0, () -> {
        return Ingredient.of(Items.WATER_BUCKET);
    //You may also return Items.EMPTY if it has no material repair type
    });


	private final int harvestLevel;
	private final int maxUses;
	private final float efficiency;
	private final float attackDamage;
	private final int enchantability;
	private final LazyValue<Ingredient> repairMaterial;

	private CursedTiers(int harvestLevelIn, int maxUsesIn, float attackDamageIn, float efficiencyIn, int enchantabilityIn, Supplier<Ingredient> repairMaterialIn) {
		this.harvestLevel = harvestLevelIn;
		this.maxUses = maxUsesIn;
		this.efficiency = efficiencyIn;
		this.attackDamage = attackDamageIn;
		this.enchantability = enchantabilityIn;
		this.repairMaterial = new LazyValue<>(repairMaterialIn);
	}

	public int getMaxUses() {
		return this.maxUses;
	}

	public float getEfficiency() {
		return this.efficiency;
	}

	public float getAttackDamage() {
		return this.attackDamage;
	}

	public int getHarvestLevel() {
		return this.harvestLevel;
	}

	public int getEnchantability() {
		return this.enchantability;
	}

	public Ingredient getRepairMaterial() {
		return this.repairMaterial.get();
	}

	@Override
	public int getUses() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float getSpeed() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float getAttackDamageBonus() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getLevel() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getEnchantmentValue() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Ingredient getRepairIngredient() {
		// TODO Auto-generated method stub
		return null;
	}
}