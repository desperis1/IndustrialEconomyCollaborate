package industrialeconomy.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;

import industrialeconomy.network.IndustrialEconomyModVariables;

import industrialeconomy.init.IndustrialEconomyModItems;

public class DSAplasmalabelProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY)
				.getItem() == IndustrialEconomyModItems.DIAMOND_STEEL_ARMOR_CHESTPLATE
						.get()) == ((entity.getCapability(IndustrialEconomyModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new IndustrialEconomyModVariables.PlayerVariables())).DSA_PlasmaShoot == true)) {
			return true;
		}
		return false;
	}
}