
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package industrialeconomy.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.common.Mod;

import net.minecraft.world.level.levelgen.feature.Feature;

import industrialeconomy.world.features.ores.CrystalFeature;
import industrialeconomy.world.features.ores.CopperOreFeature;
import industrialeconomy.world.features.ores.CateriumOreFeature;

import industrialeconomy.IndustrialEconomyMod;

@Mod.EventBusSubscriber
public class IndustrialEconomyModFeatures {
	public static final DeferredRegister<Feature<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.FEATURES, IndustrialEconomyMod.MODID);
	public static final RegistryObject<Feature<?>> CATERIUM_ORE = REGISTRY.register("caterium_ore", CateriumOreFeature::feature);
	public static final RegistryObject<Feature<?>> COPPER_ORE = REGISTRY.register("copper_ore", CopperOreFeature::feature);
	public static final RegistryObject<Feature<?>> CRYSTAL = REGISTRY.register("crystal", CrystalFeature::feature);
}
