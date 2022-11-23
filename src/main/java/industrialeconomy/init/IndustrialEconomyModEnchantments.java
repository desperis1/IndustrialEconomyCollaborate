
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package industrialeconomy.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.enchantment.Enchantment;

import industrialeconomy.enchantment.SmelterEnchantment;
import industrialeconomy.enchantment.CheapPlasmaEnchantment;
import industrialeconomy.enchantment.BuildrangeEnchantment;
import industrialeconomy.enchantment.BetterCoolDownEnchantmentEnchantment;

import industrialeconomy.IndustrialEconomyMod;

public class IndustrialEconomyModEnchantments {
	public static final DeferredRegister<Enchantment> REGISTRY = DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, IndustrialEconomyMod.MODID);
	public static final RegistryObject<Enchantment> BUILDRANGE = REGISTRY.register("buildrange", () -> new BuildrangeEnchantment());
	public static final RegistryObject<Enchantment> BETTER_COOL_DOWN_ENCHANTMENT = REGISTRY.register("better_cool_down_enchantment",
			() -> new BetterCoolDownEnchantmentEnchantment());
	public static final RegistryObject<Enchantment> CHEAP_PLASMA = REGISTRY.register("cheap_plasma", () -> new CheapPlasmaEnchantment());
	public static final RegistryObject<Enchantment> SMELTER = REGISTRY.register("smelter", () -> new SmelterEnchantment());
}
