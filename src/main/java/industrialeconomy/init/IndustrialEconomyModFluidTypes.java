
/*
 * MCreator note: This file will be REGENERATED on each build.
 */
package industrialeconomy.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fluids.FluidType;

import industrialeconomy.fluid.types.LiquidHydrogenFluidType;

import industrialeconomy.IndustrialEconomyMod;

public class IndustrialEconomyModFluidTypes {
	public static final DeferredRegister<FluidType> REGISTRY = DeferredRegister.create(ForgeRegistries.Keys.FLUID_TYPES, IndustrialEconomyMod.MODID);
	public static final RegistryObject<FluidType> LIQUID_HYDROGEN_TYPE = REGISTRY.register("liquid_hydrogen", () -> new LiquidHydrogenFluidType());
}
