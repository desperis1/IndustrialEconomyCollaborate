
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package industrialeconomy.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.effect.MobEffect;

import industrialeconomy.potion.OxygenEffectMobEffect;

import industrialeconomy.IndustrialEconomyMod;

public class IndustrialEconomyModMobEffects {
	public static final DeferredRegister<MobEffect> REGISTRY = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, IndustrialEconomyMod.MODID);
	public static final RegistryObject<MobEffect> OXYGEN_EFFECT = REGISTRY.register("oxygen_effect", () -> new OxygenEffectMobEffect());
}
