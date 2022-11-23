
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package industrialeconomy.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleType;

import industrialeconomy.IndustrialEconomyMod;

public class IndustrialEconomyModParticleTypes {
	public static final DeferredRegister<ParticleType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES,
			IndustrialEconomyMod.MODID);
	public static final RegistryObject<SimpleParticleType> HYDROGEN_PARTICLE = REGISTRY.register("hydrogen_particle",
			() -> new SimpleParticleType(false));
}
