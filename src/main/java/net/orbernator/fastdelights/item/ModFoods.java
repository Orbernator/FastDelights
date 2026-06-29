package net.orbernator.fastdelights.item;

import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static final FoodProperties SLICED_POTATOES = new FoodProperties.Builder().nutrition(1).saturationModifier(0.3F).fast().build();
    public static final FoodProperties CHIPS = new FoodProperties.Builder().nutrition(2).saturationModifier(0.3F).fast().build();
    public static final FoodProperties RAW_CHICKEN_PATTY = new FoodProperties.Builder().nutrition(1).saturationModifier(0.1F).fast().build();
    public static final FoodProperties CHICKEN_PATTY = new FoodProperties.Builder().nutrition(3).saturationModifier(0.5f).fast().build();
    public static final FoodProperties RED_ONION = new FoodProperties.Builder().nutrition(2).saturationModifier(0.2F).fast().build();
    public static final FoodProperties RAW_LAMB_PATTY = new FoodProperties.Builder().nutrition(1).saturationModifier(0.1F).fast().build();
    public static final FoodProperties LAMB_PATTY = new FoodProperties.Builder().nutrition(3).saturationModifier(0.5f).fast().build();
    public static final FoodProperties SLICED_RED_ONION = new FoodProperties.Builder().nutrition(1).saturationModifier(0.3F).build();
    public static final FoodProperties CHEESE_SLICE = new FoodProperties.Builder().nutrition(1).saturationModifier(0.1F).build();
    public static final FoodProperties BURGER_BUN = new FoodProperties.Builder().nutrition(1).saturationModifier(0.3F).fast().build();
}