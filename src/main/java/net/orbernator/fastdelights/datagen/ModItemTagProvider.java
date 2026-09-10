package net.orbernator.fastdelights.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.orbernator.fastdelights.FastDelights;
import net.orbernator.fastdelights.item.ModItems;
import net.orbernator.fastdelights.util.ModTags;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider {

    public ModItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider,
                              CompletableFuture<TagLookup<Block>> blockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, blockTags, FastDelights.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(ModTags.Items.PULVERIZERS)
                .add(ModItems.COPPER_PULVERIZER.get())
                .add(ModItems.IRON_PULVERIZER.get())
                .add(ModItems.GOLD_PULVERIZER.get())
                .add(ModItems.DIAMOND_PULVERIZER.get())
                .add(ModItems.NETHERITE_PULVERIZER.get());

        tag(ModTags.Items.BURGERS)
                .add(ModItems.CHEESEBURGER.get())
                .add(ModItems.BACON_CHEESEBURGER.get())
                .add(ModItems.CHICKEN_N_CHEESEBURGER.get())
                .add(ModItems.CHICKEN_BACON_CHEESEBURGER.get());
    }
}
