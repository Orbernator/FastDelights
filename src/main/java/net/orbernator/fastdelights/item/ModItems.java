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
    public static final DeferredItem<Item> SLICED_PICKLES = ITEMS.register("sliced_pickles", () -> new Item(new Item.Properties().food(ModFoods.SLICED_PICKLES)));
    public static final DeferredItem<Item> CHIPS_WITH_TOMATO_SAUCE = ITEMS.register("chips_with_tomato_sauce", () -> new Item(new Item.Properties().food(ModFoods.CHIPS_WITH_TOMATO_SAUCE)));
    //0.2.0: The Hot Dog Update
    public static final DeferredItem<Item> RAW_HOT_DOG = ITEMS.register("raw_hot_dog", () -> new Item(new Item.Properties().food(ModFoods.RAW_HOT_DOG)));
    public static final DeferredItem<Item> COOKED_HOT_DOG = ITEMS.register("cooked_hot_dog", () -> new Item(new Item.Properties().food(ModFoods.COOKED_HOT_DOG)));
    public static final DeferredItem<Item> BUN = ITEMS.register("bun", () -> new Item(new Item.Properties().food(ModFoods.BUN)));
    public static final DeferredItem<Item> HOT_DOG = ITEMS.register("hot_dog", () -> new Item(new Item.Properties().food(ModFoods.HOT_DOG)));
    //0.3.0: The Toppings Update
    public static final DeferredItem<Item> HOT_DOG_WITH_SAUCE = ITEMS.register("hot_dog_with_sauce", () -> new Item(new Item.Properties().food(ModFoods.HOT_DOG_WITH_SAUCE)));
    public static final DeferredItem<Item> HOT_DOG_WITH_SAUCE_AND_CHEESE = ITEMS.register("hot_dog_with_sauce_and_cheese", () -> new Item(new Item.Properties().food(ModFoods.HOT_DOG_WITH_SAUCE_AND_CHEESE)));
    public static final DeferredItem<Item> CHEESEBURGER = ITEMS.register("cheeseburger", () -> new Item(new Item.Properties().food(ModFoods.CHEESEBURGER)));
    public static final DeferredItem<Item> CHICKEN_N_CHEESEBURGER = ITEMS.register("chicken_n_cheeseburger", () -> new Item(new Item.Properties().food(ModFoods.CHICKEN_N_CHEESEBURGER)));


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


