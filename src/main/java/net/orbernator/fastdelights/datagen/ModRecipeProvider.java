package net.orbernator.fastdelights.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;
import net.orbernator.fastdelights.FastDelights;
import net.orbernator.fastdelights.item.ModItems;
import net.orbernator.fastdelights.util.ModTags;
import umpaz.brewinandchewin.common.registry.BnCItems;
import vectorwing.farmersdelight.client.recipebook.CookingPotRecipeBookTab;
import vectorwing.farmersdelight.common.tag.CommonTags;
import vectorwing.farmersdelight.data.builder.CookingPotRecipeBuilder;
import vectorwing.farmersdelight.data.builder.CuttingBoardRecipeBuilder;


import java.util.concurrent.CompletableFuture;


import static vectorwing.farmersdelight.data.recipe.CookingRecipes.MEDIUM_EXP;
import static vectorwing.farmersdelight.data.recipe.CookingRecipes.NORMAL_COOKING;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {
        // Cutting Board Recipes
        CuttingBoardRecipeBuilder.cuttingRecipe(
                Ingredient.of(Items.CHICKEN),
                Ingredient.of(ModTags.Items.PULVERIZERS),
                ModItems.RAW_CHICKEN_PATTY.get(),
                2)
        .build(recipeOutput, FastDelights.MODID + ":cutting/raw_chicken_patty");

        CuttingBoardRecipeBuilder.cuttingRecipe(
                Ingredient.of(Items.SEA_PICKLE),
                Ingredient.of(CommonTags.Items.TOOLS_KNIFE),
                ModItems.SLICED_PICKLES.get(),
                2)
                .build(recipeOutput, FastDelights.MODID + ":cutting/sliced_pickles");

        CuttingBoardRecipeBuilder.cuttingRecipe(
                Ingredient.of(vectorwing.farmersdelight.common.registry.ModItems.ONION.get()),
                Ingredient.of(CommonTags.Items.TOOLS_KNIFE),
                ModItems.SLICED_ONION.get(),
                2)
                .build(recipeOutput, FastDelights.MODID + ":cutting/sliced_onion");

        CuttingBoardRecipeBuilder.cuttingRecipe(
                Ingredient.of(Items.POTATO),
                Ingredient.of(CommonTags.Items.TOOLS_KNIFE),
                ModItems.SLICED_POTATOES.get(),
                2)
        .build(recipeOutput, FastDelights.MODID + ":cutting/sliced_potatoes");

        CuttingBoardRecipeBuilder.cuttingRecipe(
                Ingredient.of(Items.BREAD),
                Ingredient.of(CommonTags.Items.TOOLS_KNIFE),
                ModItems.BUN.get(),
                2)
        .build(recipeOutput, FastDelights.MODID + ":cutting/bun");

        //Unshaped Crafting

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.CHIPS_WITH_TOMATO_SAUCE.get())
                .requires(ModItems.CHIPS)
                .requires(vectorwing.farmersdelight.common.registry.ModItems.TOMATO_SAUCE.get())
                .unlockedBy("has potato", has(ModItems.SLICED_POTATOES.get())).save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.HOT_DOG.get())
                .requires(ModItems.COOKED_HOT_DOG.get())
                .requires(ModItems.BUN.get())
                .unlockedBy("has hot_dog", has(ModItems.RAW_HOT_DOG.get())).save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.HOT_DOG_WITH_SAUCE.get())
                .requires(ModItems.HOT_DOG.get())
                .requires(vectorwing.farmersdelight.common.registry.ModItems.TOMATO_SAUCE.get())
                .unlockedBy("has hot_dog", has(ModItems.RAW_HOT_DOG.get())).save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.HOT_DOG_WITH_SAUCE_AND_CHEESE.get())
                .requires(ModItems.HOT_DOG_WITH_SAUCE.get())
                .requires(BnCItems.FLAXEN_CHEESE_WEDGE)
                .unlockedBy("has hot_dog", has(ModItems.RAW_HOT_DOG.get()))
                .save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.BACON_CHEESEBURGER.get())
                .requires(ModItems.CHEESEBURGER.get())
                .requires(vectorwing.farmersdelight.common.registry.ModItems.BACON.get())
                .unlockedBy("has bacon", has(vectorwing.farmersdelight.common.registry.ModItems.BACON.get()))
                .save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.CHICKEN_BACON_CHEESEBURGER.get())
                .requires(ModItems.CHICKEN_N_CHEESEBURGER.get())
                .requires(vectorwing.farmersdelight.common.registry.ModItems.BACON.get())
                .unlockedBy("has bacon", has(vectorwing.farmersdelight.common.registry.ModItems.BACON.get()))
                .save(recipeOutput);

        //Shaped Crafting

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.COPPER_PULVERIZER.get())
                .pattern(" CC")
                .pattern("CS ")
                .pattern("S  ")
                .define('C', Items.COPPER_INGOT)
                .define('S', Items.STICK)
                .unlockedBy("has copper", has(Items.COPPER_INGOT)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.IRON_PULVERIZER.get())
                .pattern(" II")
                .pattern("IS ")
                .pattern("S  ")
                .define('I', Items.IRON_INGOT)
                .define('S', Items.STICK)
                .unlockedBy("has iron", has(Items.IRON_INGOT)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.GOLD_PULVERIZER.get())
                .pattern(" GG")
                .pattern("GS ")
                .pattern("S  ")
                .define('G', Items.GOLD_INGOT)
                .define('S', Items.STICK)
                .unlockedBy("has gold", has(Items.GOLD_INGOT)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.DIAMOND_PULVERIZER.get())
                .pattern(" DD")
                .pattern("DS ")
                .pattern("S  ")
                .define('D', Items.DIAMOND)
                .define('S', Items.STICK)
                .unlockedBy("has diamond", has(Items.DIAMOND)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.NETHERITE_PULVERIZER.get())
                .pattern(" NN")
                .pattern("NS ")
                .pattern("S  ")
                .define('N', Items.NETHERITE_INGOT)
                .define('S', Items.STICK)
                .unlockedBy("has netherite", has(Items.NETHERITE_INGOT)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.CHIPHOLDER.get())
                .pattern("P P")
                .pattern("P P")
                .pattern("PPP")
                .define('P', Items.PAPER)
                .unlockedBy("has paper", has(Items.PAPER)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.OIL_BUCKET.get())
                .pattern(" C ")
                .pattern("CWC")
                .pattern(" C ")
                .define('C', Items.COAL)
                .define('W', Items.WATER_BUCKET)
                .unlockedBy("has coal", has(Items.COAL)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ModItems.RAW_HOT_DOG.get(), 3)
                .pattern("   ")
                .pattern("PPP")
                .pattern("   ")
                .define('P', CommonTags.Items.FOODS_RAW_BEEF)
                .unlockedBy("has beef", has(CommonTags.Items.FOODS_RAW_BEEF)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ModItems.CHEESEBURGER.get(), 1)
                .pattern(" B ")
                .pattern("ECP")
                .pattern(" B ")
                .define('B', ModItems.BUN.get())
                .define('P', ModItems.SLICED_PICKLES.get())
                .define('E', vectorwing.farmersdelight.common.registry.ModItems.BEEF_PATTY.get())
                .define('C', BnCItems.FLAXEN_CHEESE_WEDGE)
                .unlockedBy("has beef", has(vectorwing.farmersdelight.common.registry.ModItems.BEEF_PATTY.get())).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ModItems.CHICKEN_N_CHEESEBURGER.get(), 1)
                .pattern(" B ")
                .pattern("ECP")
                .pattern(" B ")
                .define('B', ModItems.BUN.get())
                .define('P', ModItems.SLICED_PICKLES.get())
                .define('E', ModItems.CHICKEN_PATTY.get())
                .define('C', BnCItems.FLAXEN_CHEESE_WEDGE)
                .unlockedBy("has chicken_patty", has(ModItems.CHICKEN_PATTY.get())).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ModItems.BACON_CHEESEBURGER.get(), 1)
                .pattern("Bb ")
                .pattern("ECP")
                .pattern("  B")
                .define('B', ModItems.BUN.get())
                .define('b', vectorwing.farmersdelight.common.registry.ModItems.BACON.get())
                .define('P', ModItems.SLICED_PICKLES.get())
                .define('E', vectorwing.farmersdelight.common.registry.ModItems.BEEF_PATTY.get())
                .define('C', BnCItems.FLAXEN_CHEESE_WEDGE)
                .unlockedBy("has beef", has(vectorwing.farmersdelight.common.registry.ModItems.BEEF_PATTY.get())).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ModItems.CHICKEN_BACON_CHEESEBURGER.get(), 1)
                .pattern("Bb ")
                .pattern("ECP")
                .pattern("  B")
                .define('B', ModItems.BUN.get())
                .define('b', vectorwing.farmersdelight.common.registry.ModItems.BACON.get())
                .define('P', ModItems.SLICED_PICKLES.get())
                .define('E', ModItems.CHICKEN_PATTY.get())
                .define('C', BnCItems.FLAXEN_CHEESE_WEDGE)
                .unlockedBy("has chicken_patty", has(ModItems.CHICKEN_PATTY.get())).save(recipeOutput);



        //Cooking Pot
        CookingPotRecipeBuilder.cookingPotRecipe(ModItems.CHIPS.get(), 1, NORMAL_COOKING, MEDIUM_EXP, ModItems.CHIPHOLDER)
                .addIngredient(ModItems.SLICED_POTATOES.get())
                .addIngredient(ModItems.OIL_BUCKET.get())
                .unlockedByAnyIngredient(ModItems.SLICED_POTATOES.get(), ModItems.OIL_BUCKET.get())
                .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                .save(recipeOutput, FastDelights.MODID + ":cooking/chips");

        CookingPotRecipeBuilder.cookingPotRecipe(ModItems.ONION_RINGS.get(), 1, NORMAL_COOKING, MEDIUM_EXP, ModItems.CHIPHOLDER)
                .addIngredient(ModItems.SLICED_ONION.get())
                .addIngredient(ModItems.OIL_BUCKET.get())
                .unlockedByAnyIngredient(ModItems.SLICED_ONION.get(), ModItems.OIL_BUCKET.get())
                .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                .save(recipeOutput, FastDelights.MODID + ":cooking/onion_rings");

        //Smoking
        SimpleCookingRecipeBuilder.smoking(
                        Ingredient.of(ModItems.RAW_CHICKEN_PATTY.get()),
                        RecipeCategory.FOOD,
                        ModItems.CHICKEN_PATTY.get(),
                        0.25f,
                        30
                )
                .unlockedBy("has_raw_chicken_patty", has(ModItems.RAW_CHICKEN_PATTY.get()))
                .save(recipeOutput, FastDelights.MODID + ":smoking/chicken_patty");

        SimpleCookingRecipeBuilder.smoking(
                Ingredient.of(ModItems.RAW_HOT_DOG.get()),
                RecipeCategory.FOOD,
                ModItems.COOKED_HOT_DOG.get(),
                0.25f,
                30
        )
                .unlockedBy("has_raw_hot_dog", has(ModItems.RAW_HOT_DOG.get()))
                .save(recipeOutput, FastDelights.MODID + ":smoking/hot_dog");

        //Furnace
        SimpleCookingRecipeBuilder.smelting(
                Ingredient.of(ModItems.RAW_CHICKEN_PATTY.get()),
                RecipeCategory.FOOD,
                ModItems.CHICKEN_PATTY.get(),
                0.25f,
                60)
                .unlockedBy("has_raw_chicken_patty", has(ModItems.RAW_CHICKEN_PATTY.get()))
                .save(recipeOutput, FastDelights.MODID + ":furnace/chicken_patty");

        SimpleCookingRecipeBuilder.smelting(
                Ingredient.of(ModItems.RAW_HOT_DOG.get()),
                RecipeCategory.FOOD,
                ModItems.COOKED_HOT_DOG.get(),
                0.25f,
                60)
                .unlockedBy("has_raw_hot_dog", has(ModItems.RAW_HOT_DOG.get()))
                .save(recipeOutput, FastDelights.MODID + ":furnace/hot_dog");


        //Campfire
        SimpleCookingRecipeBuilder.campfireCooking(
                Ingredient.of(ModItems.RAW_CHICKEN_PATTY.get()),
                RecipeCategory.FOOD,
                ModItems.CHICKEN_PATTY.get(),
                0.25f,
                60)
                .unlockedBy("has_raw_chicken_patty", has(ModItems.RAW_CHICKEN_PATTY.get()))
                .save(recipeOutput, FastDelights.MODID + ":campfire/chicken_patty");

        SimpleCookingRecipeBuilder.campfireCooking(
                Ingredient.of(ModItems.RAW_HOT_DOG.get()),
                RecipeCategory.FOOD,
                ModItems.COOKED_HOT_DOG.get(),
                 0.25f,
                 60)
                .unlockedBy("has_raw_hot_dog", has(ModItems.RAW_HOT_DOG.get()))
                .save(recipeOutput, FastDelights.MODID + ":campfire/hot_dog");



    }
}
