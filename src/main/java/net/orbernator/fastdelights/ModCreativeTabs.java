package net.orbernator.fastdelights;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.orbernator.fastdelights.item.ModItems;

public class ModCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, FastDelights.MODID);

    public static DeferredHolder<CreativeModeTab, CreativeModeTab> FAST_DELIGHTS = CREATIVE_MODE_TABS.register("fastdelights", () -> CreativeModeTab.builder()
            .icon(ModCreativeTabs::createIcon)
            .title(Component.translatable("itemGroup.fastdelights")).displayItems(ModCreativeTabs::displayItems).build());

    public static ItemStack createIcon() {
        return ModItems.CHIPS.get().getDefaultInstance();
    }

    public static void displayItems(CreativeModeTab.ItemDisplayParameters displayParameters, CreativeModeTab.Output output) {
        output.accept(ModItems.SLICED_POTATOES.get());
        output.accept(ModItems.CHIPS.get());
        output.accept(ModItems.CHIPS_WITH_TOMATO_SAUCE.get());
        output.accept(ModItems.RAW_CHICKEN_PATTY.get());
        output.accept(ModItems.CHICKEN_PATTY.get());
        output.accept(ModItems.SLICED_PICKLES.get());
        output.accept(ModItems.OIL_BUCKET.get());
        output.accept(ModItems.CHIPHOLDER.get());
        output.accept(ModItems.COPPER_PULVERIZER.get());
        output.accept(ModItems.IRON_PULVERIZER.get());
        output.accept(ModItems.GOLD_PULVERIZER.get());
        output.accept(ModItems.DIAMOND_PULVERIZER.get());
        output.accept(ModItems.NETHERITE_PULVERIZER.get());
    }
}