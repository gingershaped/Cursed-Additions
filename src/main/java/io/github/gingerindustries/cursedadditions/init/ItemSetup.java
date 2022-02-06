package io.github.gingerindustries.cursedadditions.init;

import io.github.gingerindustries.cursedadditions.CursedAdditions;
import io.github.gingerindustries.cursedadditions.discs.DreamDiscItem;
import io.github.gingerindustries.cursedadditions.items.food.CookedFleshItem;
import io.github.gingerindustries.cursedadditions.items.food.FferfiItem;
import io.github.gingerindustries.cursedadditions.items.food.FixedSpawnEggItem;
import io.github.gingerindustries.cursedadditions.items.food.VerticalBreadItem;
import io.github.gingerindustries.cursedadditions.items.weapons.CobblestoneStickItem;
import io.github.gingerindustries.cursedadditions.items.weapons.InterestingStaffItem;
import io.github.gingerindustries.cursedadditions.items.weapons.WaterSwordItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = CursedAdditions.ID, bus = Bus.MOD)
public class ItemSetup {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, CursedAdditions.ID);

    // Items
    public static final RegistryObject<Item> BLACKSTONE_DUST = ITEMS.register("blackstone_dust", () -> new Item(new Item.Properties().tab(CursedAdditions.TAB)));
    public static final RegistryObject<Item> COBBLESTONE_DUST = ITEMS.register("cobblestone_dust", () -> new Item(new Item.Properties().tab(CursedAdditions.TAB)));
    public static final RegistryObject<Item> INTERESTING_SHARD = ITEMS.register("interesting_shard", () -> new Item(new Item.Properties().tab(CursedAdditions.TAB)));
    // Food items
    public static final RegistryObject<Item> FFERFI = ITEMS.register("fferfi", () -> new FferfiItem());
    public static final RegistryObject<Item> COOKED_FLESH = ITEMS.register("cooked_flesh", () -> new CookedFleshItem());
    public static final RegistryObject<Item> VERTICAL_BREAD = ITEMS.register("vertical_bread", () -> new VerticalBreadItem());
    // Weaponry
    public static final RegistryObject<Item> COBBLESTONE_STICK = ITEMS.register("cobblestone_stick", () -> new CobblestoneStickItem());
    public static final RegistryObject<Item> WATER_SWORD = ITEMS.register("water_sword", () -> new WaterSwordItem());
    public static final RegistryObject<Item> INTERESTING_STAFF = ITEMS.register("interesting_staff", () -> new InterestingStaffItem());
    // Discs
    public static final RegistryObject<Item> DREAM_DISC = ITEMS.register("dream_disc", () -> new DreamDiscItem());
    // Spawn eggs
    public static final RegistryObject<Item> SUSPICIOUS_CREATURE_SPAWN_EGG = ITEMS.register("suspicious_creature_spawn_egg", () -> new FixedSpawnEggItem(EntityTypeSetup.SUSPICIOUS_CREATURE_ENTITY, 14421539, 2158564, new Item.Properties().tab(CursedAdditions.TAB)));
    
    // BlockItems
    public static final RegistryObject<Item> COBBLED_COBBLESTONE_ITEM = ITEMS.register("cobbled_cobblestone",
            () -> new BlockItem(BlockSetup.COBBLED_COBBLESTONE_BLOCK.get(), new Item.Properties().tab(CursedAdditions.TAB)));
    public static final RegistryObject<Item> COBBLED_STONE_ITEM = ITEMS.register("cobbled_stone",
            () -> new BlockItem(BlockSetup.COBBLED_STONE_BLOCK.get(), new Item.Properties().tab(CursedAdditions.TAB)));
    public static final RegistryObject<Item> INTERESTING_BLOCK_ITEM = ITEMS.register("interesting_block",
            () -> new BlockItem(BlockSetup.INTERESTING_BLOCK.get(), new Item.Properties().tab(CursedAdditions.TAB)));
    public static final RegistryObject<Item> INTERESTING_ORE_ITEM = ITEMS.register("interesting_ore",
            () -> new BlockItem(BlockSetup.INTERESTING_ORE.get(), new Item.Properties().tab(CursedAdditions.TAB)));
    
    public static final RegistryObject<Item> SMOOTH_FURNACE_ITEM = ITEMS.register("smooth_furnace",
            () -> new BlockItem(BlockSetup.SMOOTH_FURNACE_BLOCK.get(), new Item.Properties().tab(CursedAdditions.TAB)));
}
