
/*
 * MCreator note: This file will be REGENERATED on each build.
 */
package industrialeconomy.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.ItemBlockRenderTypes;

import industrialeconomy.fluid.LiquidHydrogenFluid;

import industrialeconomy.IndustrialEconomyMod;

public class IndustrialEconomyModFluids {
	public static final DeferredRegister<Fluid> REGISTRY = DeferredRegister.create(ForgeRegistries.FLUIDS, IndustrialEconomyMod.MODID);
	public static final RegistryObject<FlowingFluid> LIQUID_HYDROGEN = REGISTRY.register("liquid_hydrogen", () -> new LiquidHydrogenFluid.Source());
	public static final RegistryObject<FlowingFluid> FLOWING_LIQUID_HYDROGEN = REGISTRY.register("flowing_liquid_hydrogen",
			() -> new LiquidHydrogenFluid.Flowing());

	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
	public static class ClientSideHandler {
		@SubscribeEvent
		public static void clientSetup(FMLClientSetupEvent event) {
			ItemBlockRenderTypes.setRenderLayer(LIQUID_HYDROGEN.get(), RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(FLOWING_LIQUID_HYDROGEN.get(), RenderType.translucent());
		}
	}
}
