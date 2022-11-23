package industrialeconomy.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.util.RandomSource;

import industrialeconomy.init.IndustrialEconomyModMobEffects;
import industrialeconomy.init.IndustrialEconomyModItems;

public class SpaceSuitWithCanisterBodyTickEventProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY)
				.getItem() == IndustrialEconomyModItems.SPACE_SUIT_HELMET.get()
				&& (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY)
						.getItem() == IndustrialEconomyModItems.SPACE_SUIT_WITH_CANISTER_CHESTPLATE.get()
				&& (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY)
						.getItem() == IndustrialEconomyModItems.SPACE_SUIT_LEGGINGS.get()
				&& (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY)
						.getItem() == IndustrialEconomyModItems.SPACE_SUIT_BOOTS.get()) {
			if (((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY))
					.getDamageValue() < 990) {
				if (entity instanceof LivingEntity _entity)
					_entity.addEffect(new MobEffectInstance(IndustrialEconomyModMobEffects.OXYGEN_EFFECT.get(), 60, 1, (false), (false)));
				if (Math.random() < 0.05) {
					{
						ItemStack _ist = (entity instanceof LivingEntity _entGetArmor
								? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST)
								: ItemStack.EMPTY);
						if (_ist.hurt(1, RandomSource.create(), null)) {
							_ist.shrink(1);
							_ist.setDamageValue(0);
						}
					}
				}
			}
		}
	}
}
