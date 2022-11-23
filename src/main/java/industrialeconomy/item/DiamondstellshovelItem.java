
package industrialeconomy.item;

import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;

import industrialeconomy.init.IndustrialEconomyModTabs;
import industrialeconomy.init.IndustrialEconomyModItems;

public class DiamondstellshovelItem extends ShovelItem {
	public DiamondstellshovelItem() {
		super(new Tier() {
			public int getUses() {
				return 115144;
			}

			public float getSpeed() {
				return 15f;
			}

			public float getAttackDamageBonus() {
				return 7f;
			}

			public int getLevel() {
				return 3;
			}

			public int getEnchantmentValue() {
				return 2;
			}

			public Ingredient getRepairIngredient() {
				return Ingredient.of(new ItemStack(IndustrialEconomyModItems.DIAMONDSTEELPLATE.get()));
			}
		}, 1, -2f, new Item.Properties().tab(IndustrialEconomyModTabs.TAB_PROJECT_MEGA));
	}
}
