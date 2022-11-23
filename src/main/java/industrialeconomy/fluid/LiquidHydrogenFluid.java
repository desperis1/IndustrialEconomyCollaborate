
package industrialeconomy.fluid;

import net.minecraftforge.fluids.ForgeFlowingFluid;

import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.LiquidBlock;

import industrialeconomy.init.IndustrialEconomyModItems;
import industrialeconomy.init.IndustrialEconomyModFluids;
import industrialeconomy.init.IndustrialEconomyModFluidTypes;
import industrialeconomy.init.IndustrialEconomyModBlocks;

public abstract class LiquidHydrogenFluid extends ForgeFlowingFluid {
	public static final ForgeFlowingFluid.Properties PROPERTIES = new ForgeFlowingFluid.Properties(
			() -> IndustrialEconomyModFluidTypes.LIQUID_HYDROGEN_TYPE.get(), () -> IndustrialEconomyModFluids.LIQUID_HYDROGEN.get(),
			() -> IndustrialEconomyModFluids.FLOWING_LIQUID_HYDROGEN.get()).explosionResistance(100f)
			.bucket(() -> IndustrialEconomyModItems.LIQUID_HYDROGEN_BUCKET.get())
			.block(() -> (LiquidBlock) IndustrialEconomyModBlocks.LIQUID_HYDROGEN.get());

	private LiquidHydrogenFluid() {
		super(PROPERTIES);
	}

	public static class Source extends LiquidHydrogenFluid {
		public int getAmount(FluidState state) {
			return 8;
		}

		public boolean isSource(FluidState state) {
			return true;
		}
	}

	public static class Flowing extends LiquidHydrogenFluid {
		protected void createFluidStateDefinition(StateDefinition.Builder<Fluid, FluidState> builder) {
			super.createFluidStateDefinition(builder);
			builder.add(LEVEL);
		}

		public int getAmount(FluidState state) {
			return state.getValue(LEVEL);
		}

		public boolean isSource(FluidState state) {
			return false;
		}
	}
}
