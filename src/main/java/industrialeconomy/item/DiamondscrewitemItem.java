
package industrialeconomy.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.network.chat.Component;

import java.util.List;

import industrialeconomy.init.IndustrialEconomyModTabs;

public class DiamondscrewitemItem extends Item {
	public DiamondscrewitemItem() {
		super(new Item.Properties().tab(IndustrialEconomyModTabs.TAB_PROJECT_MEGA).stacksTo(64).rarity(Rarity.COMMON));
	}

	@Override
	public UseAnim getUseAnimation(ItemStack itemstack) {
		return UseAnim.EAT;
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		list.add(Component.literal("Iron: 2"));
		list.add(Component.literal("Coal: 18"));
	}
}
