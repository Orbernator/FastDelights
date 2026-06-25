package net.orbernator.fastdelights.block;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.orbernator.fastdelights.FastDelights;
import net.orbernator.fastdelights.fluid.ModFluids;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(FastDelights.MODID);

    public static final DeferredBlock<LiquidBlock> OIL_BLOCK = BLOCKS.register("oil",
            () -> new LiquidBlock(ModFluids.OIL_SOURCE.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.WATER).noLootTable()));


}
