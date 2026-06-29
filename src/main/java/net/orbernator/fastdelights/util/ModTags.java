package net.orbernator.fastdelights.util;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.orbernator.fastdelights.FastDelights;


public class ModTags {
    public static class Items{
        public static final TagKey<Item> PULVERIZERS = createTag("pulverizers");

        private static TagKey<Item> createTag(String name) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(FastDelights.MODID, name));
        }
    }

}
