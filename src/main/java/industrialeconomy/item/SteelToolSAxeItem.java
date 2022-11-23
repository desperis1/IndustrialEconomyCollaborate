
package industrialeconomy.item;

import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.AxeItem;

import industrialeconomy.init.IndustrialEconomyModTabs;
import industrialeconomy.init.IndustrialEconomyModBlocks;

public class SteelToolSAxeItem extends AxeItem {
	public SteelToolSAxeItem() {
		super(new Tier() {
			public int getUses() {
				return 2505;
			}

			public float getSpeed() {
				return 12f;
			}

			public float getAttackDamageBonus() {
				return 6f;
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
		}, 1, -3f, new Item.Properties().tab(IndustrialEconomyModTabs.TAB_PROJECT_MEGA));
	}
}
