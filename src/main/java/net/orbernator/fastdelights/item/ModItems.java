package net.orbernator.fastdelights.item;

import net.minecraft.core.Registry;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.orbernator.fastdelights.FastDelights;
import net.orbernator.fastdelights.fluid.ModFluids;

import javax.swing.*;

public class ModItems {
    private static Registry<Item> NeoForgeRegistries;
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(FastDelights.MODID);


    // Foods
    public static final DeferredItem<Item> CHIPS = ITEMS.register("chips", () -> new Item(new Item.Properties().food(ModFoods.CHIPS)));
    public static final DeferredItem<Item> SLICED_POTATOES = ITEMS.register("sliced_potatoes", () -> new Item(new Item.Properties().food(ModFoods.SLICED_POTATOES)));
    public static final DeferredItem<Item> RAW_CHICKEN_PATTY = ITEMS.register("raw_chicken_patty" , () -> new Item(new Item.Properties().food(ModFoods.RAW_CHICKEN_PATTY)));
    public static final DeferredItem<Item> CHICKEN_PATTY = ITEMS.register("chicken_patty", () -> new Item(new Item.Properties().food(ModFoods.CHICKEN_PATTY)));
    public static final DeferredItem<Item> RAW_LAMB_PATTY = ITEMS.register("raw_lamb_patty", () -> new Item(new Item.Properties().food(ModFoods.RAW_LAMB_PATTY)));
    public static final DeferredItem<Item> LAMB_PATTY = ITEMS.register("lamb_patty", () -> new Item(new Item.Properties().food(ModFoods.LAMB_PATTY)));
    public static final DeferredItem<Item> CHEESE_SLICE = ITEMS.register("cheese_slice", () -> new Item(new Item.Properties().food(ModFoods.CHEESE_SLICE)));
    public static final DeferredItem<Item> BURGER_BUN = ITEMS.register("burger_bun", () -> new Item(new Item.Properties().food(ModFoods.BURGER_BUN)));
    public static final DeferredItem<Item> SLICED_PICKLES = ITEMS.register("sliced_pickles", () -> new Item(new Item.Properties().food(ModFoods.SLICED_PICKLES)));
    public static final DeferredItem<Item> HASHBROWN = ITEMS.register("hashbrown", () -> new Item(new Item.Properties().food(ModFoods.HASHBROWN)));

    // Liquids
    public static final DeferredItem<Item> OIL_BUCKET = ITEMS.register("oil_bucket",
            () -> new BucketItem(ModFluids.OIL_SOURCE.get(), new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));

    // Food Holders
    public static final DeferredItem<Item> CHIPHOLDER = ITEMS.register("chipholder", () -> new Item(new Item.Properties()));

    // Pulverizers
    public static final DeferredItem<Item> COPPER_PULVERIZER = ITEMS.register("copper_pulverizer", () -> new Item(new Item.Properties().durability(64)));
    public static final DeferredItem<Item> IRON_PULVERIZER = ITEMS.register("iron_pulverizer", () -> new Item(new Item.Properties().durability(128)));
    public static final DeferredItem<Item> GOLD_PULVERIZER = ITEMS.register("gold_pulverizer", () -> new Item(new Item.Properties().durability(32)));
    public static final DeferredItem<Item> DIAMOND_PULVERIZER = ITEMS.register("diamond_pulverizer", () -> new Item(new Item.Properties().durability(512)));
    public static final DeferredItem<Item> NETHERITE_PULVERIZER = ITEMS.register("netherite_pulverizer", () -> new Item(new Item.Properties().durability(1024).fireResistant()));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}


