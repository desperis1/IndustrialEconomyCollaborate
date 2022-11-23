package industrialeconomy.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;

import industrialeconomy.init.IndustrialEconomyModItems;

public class JetpackKeyBindOnKeyReleasedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (IndustrialEconomyModItems.DIAMOND_STEEL_ARMOR_CHESTPLATE
				.get() == (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY)
						.getItem()) {
			entity.getPersistentData().putBoolean("Jetpack", (false));
		}
	}
}
