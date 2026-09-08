package net.orbernator.fastdelights.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.CraftingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.NeoForgeConfig;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;
import net.orbernator.fastdelights.FastDelights;
import net.orbernator.fastdelights.block.ModBlocks;
import net.orbernator.fastdelights.item.ModItems;
import net.orbernator.fastdelights.util.ModTags;
import umpaz.brewinandchewin.common.tag.BnCTags;
import vectorwing.farmersdelight.FarmersDelight;
import vectorwing.farmersdelight.client.recipebook.CookingPotRecipeBookTab;
import vectorwing.farmersdelight.common.tag.CommonTags;
import vectorwing.farmersdelight.data.builder.CookingPotRecipeBuilder;
import vectorwing.farmersdelight.data.builder.CuttingBoardRecipeBuilder;
import vectorwing.farmersdelight.data.recipe.CookingRecipes;
import vectorwing.farmersdelight.data.recipe.CuttingRecipes;

import java.util.concurrent.CompletableFuture;

import static net.minecraft.data.recipes.SimpleCookingRecipeBuilder.smoking;
import static net.minecraft.data.recipes.SimpleCookingRecipeBuilder.smoking;
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
                Ingredient.of(Items.POTATO),
                Ingredient.of(CommonTags.Items.TOOLS_KNIFE),
                ModItems.SLICED_POTATOES.get(),
                2)
        .build(recipeOutput, FastDelights.MODID + ":cutting/sliced_potatoes");


        //Unshaped Crafting

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.CHIPS_WITH_TOMATO_SAUCE.get())
                .requires(ModItems.CHIPS)
                .requires(CommonTags.Items.FOODS_TOMATO)
                .unlockedBy("has potato", has(ModItems.SLICED_POTATOES.get()));

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

        //Cooking Pot
        CookingPotRecipeBuilder.cookingPotRecipe(ModItems.CHIPS.get(), 1, NORMAL_COOKING, MEDIUM_EXP, ModItems.CHIPHOLDER)
                .addIngredient(ModItems.SLICED_POTATOES.get())
                .addIngredient(ModItems.OIL_BUCKET.get())
                .unlockedByAnyIngredient(ModItems.SLICED_POTATOES.get(), ModItems.OIL_BUCKET.get())
                .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                .save(recipeOutput, FastDelights.MODID + ":cooking/chips");

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

        //Furnace
        SimpleCookingRecipeBuilder.smelting(
                Ingredient.of(ModItems.RAW_CHICKEN_PATTY.get()),
                RecipeCategory.FOOD,
                ModItems.CHICKEN_PATTY.get(),
                0.25f,
                60)
                .unlockedBy("has_raw_chicken_patty", has(ModItems.RAW_CHICKEN_PATTY.get()))
                .save(recipeOutput, FastDelights.MODID + ":furnace/chicken_patty");


        //Campfire
        SimpleCookingRecipeBuilder.campfireCooking(
                Ingredient.of(ModItems.RAW_CHICKEN_PATTY.get()),
                RecipeCategory.FOOD,
                ModItems.CHICKEN_PATTY.get(),
                0.25f,
                60)
                .unlockedBy("has_raw_chicken_patty", has(ModItems.RAW_CHICKEN_PATTY.get()))
                .save(recipeOutput, FastDelights.MODID + ":campfire/chicken_patty");



    }
}
