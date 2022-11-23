
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package industrialeconomy.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;

import industrialeconomy.IndustrialEconomyMod;

public class IndustrialEconomyModSounds {
	public static final DeferredRegister<SoundEvent> REGISTRY = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, IndustrialEconomyMod.MODID);
	public static final RegistryObject<SoundEvent> PLASMA_SHOOT = REGISTRY.register("plasma_shoot",
			() -> new SoundEvent(new ResourceLocation("industrial_economy", "plasma_shoot")));
	public static final RegistryObject<SoundEvent> PLAZMA = REGISTRY.register("plazma",
			() -> new SoundEvent(new ResourceLocation("industrial_economy", "plazma")));
	public static final RegistryObject<SoundEvent> JETPACK_SOUND = REGISTRY.register("jetpack_sound",
			() -> new SoundEvent(new ResourceLocation("industrial_economy", "jetpack_sound")));
	public static final RegistryObject<SoundEvent> PARTICLEACCELERATOR = REGISTRY.register("particleaccelerator",
			() -> new SoundEvent(new ResourceLocation("industrial_economy", "particleaccelerator")));
}
