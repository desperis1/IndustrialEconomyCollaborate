
package industrialeconomy.item;

import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;

import industrialeconomy.init.IndustrialEconomyModTabs;

public class CopperIngotItem extends Item {
	public CopperIngotItem() {
		super(new Item.Properties().tab(IndustrialEconomyModTabs.TAB_PROJECT_MEGA).stacksTo(64).rarity(Rarity.COMMON));
	}

	@Override
	public UseAnim getUseAnimation(ItemStack itemstack) {
		return UseAnim.EAT;
	}
}