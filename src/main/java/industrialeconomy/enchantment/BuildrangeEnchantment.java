
package industrialeconomy.enchantment;

import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.EquipmentSlot;

import java.util.List;

import industrialeconomy.init.IndustrialEconomyModItems;

public class BuildrangeEnchantment extends Enchantment {
	public BuildrangeEnchantment(EquipmentSlot... slots) {
		super(Enchantment.Rarity.VERY_RARE, EnchantmentCategory.DIGGER, slots);
	}

	@Override
	public int getMaxLevel() {
		return 2;
	}

	@Override
	public boolean canApplyAtEnchantingTable(ItemStack stack) {
		Item item = stack.getItem();
		return List.of(IndustrialEconomyModItems.BUILDERTOOL.get(), IndustrialEconomyModItems.BUILDERTOOL.get()).contains(item);
	}
}
