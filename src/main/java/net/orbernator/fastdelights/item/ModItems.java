package net.orbernator.fastdelights.item;

import net.minecraft.core.Registry;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.orbernator.fastdelights.FastDelights;
import net.orbernator.fastdelights.fluid.ModFluids;

public class ModItems {
    private static Registry<Item> NeoForgeRegistries;
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(FastDelights.MODID);

    public static final DeferredItem<Item> CHIPS = ITEMS.register("chips", () -> new Item(new Item.Properties().food(ModFoods.CHIPS)));
    public static final DeferredItem<Item> SLICED_POTATOES = ITEMS.register("sliced_potatoes", () -> new Item(new Item.Properties().food(ModFoods.SLICED_POTATOES)));

    public static final DeferredItem<Item> OIL_BUCKET = ITEMS.register("oil_bucket",
            () -> new BucketItem(ModFluids.OIL_SOURCE.get(), new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));

    public static final DeferredItem<Item> CHIPHOLDER = ITEMS.register("chipholder", () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}


