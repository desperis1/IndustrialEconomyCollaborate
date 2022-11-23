package industrialeconomy.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;

import industrialeconomy.network.IndustrialEconomyModVariables;

import industrialeconomy.init.IndustrialEconomyModItems;

public class DSAoverlayslowfallingProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY)
				.getItem() == IndustrialEconomyModItems.DIAMOND_STEEL_ARMOR_LEGGINGS.get()
				&& (entity.getCapability(IndustrialEconomyModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new IndustrialEconomyModVariables.PlayerVariables())).DSA_SlowFalling == true) {
			return true;
		}
		return false;
	}
}
