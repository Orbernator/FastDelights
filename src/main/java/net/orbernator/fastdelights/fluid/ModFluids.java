package net.orbernator.fastdelights.fluid;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.neoforged.neoforge.common.SoundActions;
import net.neoforged.neoforge.fluids.BaseFlowingFluid;
import net.neoforged.neoforge.fluids.FluidType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import net.orbernator.fastdelights.FastDelights;
import net.orbernator.fastdelights.block.ModBlocks;
import net.orbernator.fastdelights.item.ModItems;

import net.neoforged.neoforge.client.extensions.common.IClientFluidTypeExtensions;
import java.util.function.Consumer;

public class ModFluids {
    public static final DeferredRegister<FluidType> FLUID_TYPES = DeferredRegister.create(NeoForgeRegistries.Keys.FLUID_TYPES, FastDelights.MODID);
    public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(Registries.FLUID, FastDelights.MODID);

    public static final DeferredHolder<FluidType, FluidType> OIL_FLUID_TYPE = FLUID_TYPES.register("oil",
            () -> new FluidType(FluidType.Properties.create()
                    .descriptionId("fluid_type.fastdelights.oil")
                    .canPushEntity(true)
                    .canSwim(true)
                    .canDrown(true)
                    .density(900)
                    .viscosity(2000)
                    .sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL)
                    .sound(SoundActions.BUCKET_EMPTY, SoundEvents.BUCKET_EMPTY)
            ) {
                @Override
                public void initializeClient(Consumer<IClientFluidTypeExtensions> consumer) {
                    consumer.accept(new IClientFluidTypeExtensions() {
                        private static final ResourceLocation WATER_STILL = ResourceLocation.withDefaultNamespace("block/water_still");
                        private static final ResourceLocation WATER_FLOW = ResourceLocation.withDefaultNamespace("block/water_flow");

                        @Override
                        public ResourceLocation getStillTexture() {
                            return WATER_STILL;
                        }

                        @Override
                        public ResourceLocation getFlowingTexture() {
                            return WATER_FLOW;
                        }

                        @Override
                        public int getTintColor() {
                            return 0xFF3E3E3E; // Dark greyish for oil
                        }
                    });
                }
            });

    public static final DeferredHolder<Fluid, FlowingFluid> OIL_SOURCE = FLUIDS.register("oil",
            () -> new BaseFlowingFluid.Source(ModFluids.OIL_PROPERTIES));

    public static final DeferredHolder<Fluid, FlowingFluid> OIL_FLOWING = FLUIDS.register("oil_flowing",
            () -> new BaseFlowingFluid.Flowing(ModFluids.OIL_PROPERTIES));

    public static final BaseFlowingFluid.Properties OIL_PROPERTIES = new BaseFlowingFluid.Properties(
            OIL_FLUID_TYPE, OIL_SOURCE, OIL_FLOWING)
            .slopeFindDistance(2)
            .levelDecreasePerBlock(2)
            .block(ModBlocks.OIL_BLOCK)
            .bucket(ModItems.OIL_BUCKET);
}
