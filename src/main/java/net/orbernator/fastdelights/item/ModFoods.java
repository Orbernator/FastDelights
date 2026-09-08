package net.orbernator.fastdelights.item;

import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static final FoodProperties SLICED_POTATOES = new FoodProperties.Builder().nutrition(1).saturationModifier(0.3F).fast().build();
    public static final FoodProperties CHIPS = new FoodProperties.Builder().nutrition(2).saturationModifier(0.6F).build();
    public static final FoodProperties RAW_CHICKEN_PATTY = new FoodProperties.Builder().nutrition(1).saturationModifier(0.1F).build();
    public static final FoodProperties CHICKEN_PATTY = new FoodProperties.Builder().nutrition(2).saturationModifier(0.6f).build();
    public static final FoodProperties SLICED_PICKLES = new FoodProperties.Builder().nutrition(1).saturationModifier(0.3F).fast().build();
    public static final FoodProperties CHIPS_WITH_TOMATO_SAUCE = new FoodProperties.Builder().nutrition(4).saturationModifier(0.8F).build();
}