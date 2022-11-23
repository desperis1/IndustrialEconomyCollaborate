
package industrialeconomy.item;

import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;

import industrialeconomy.init.IndustrialEconomyModTabs;
import industrialeconomy.init.IndustrialEconomyModBlocks;

public class SteelToolSSwordItem extends SwordItem {
	public SteelToolSSwordItem() {
		super(new Tier() {
			public int getUses() {
				return 2505;
			}

			public float getSpeed() {
				return 12f;
			}

			public float getAttackDamageBonus() {
				return 8f;
			}

			public int getLevel() {
				return 5;
			}

			public int getEnchantmentValue() {
				return 15;
			}

			public Ingredient getRepairIngredient() {
				return Ingredient.of(new ItemStack(IndustrialEconomyModBlocks.STEEL_BLOCK.get()));
			}
		}, 3, -3f, new Item.Properties().tab(IndustrialEconomyModTabs.TAB_PROJECT_MEGA));
	}
}
