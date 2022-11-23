
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package industrialeconomy.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.biome.Biome;

import industrialeconomy.world.biome.TestBiome;

import industrialeconomy.IndustrialEconomyMod;

public class IndustrialEconomyModBiomes {
	public static final DeferredRegister<Biome> REGISTRY = DeferredRegister.create(ForgeRegistries.BIOMES, IndustrialEconomyMod.MODID);
	public static final RegistryObject<Biome> TEST = REGISTRY.register("test", TestBiome::createBiome);
}
