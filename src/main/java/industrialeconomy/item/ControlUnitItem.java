
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

public class ControlUnitItem extends Item {
	public ControlUnitItem() {
		super(new Item.Properties().tab(IndustrialEconomyModTabs.TAB_PROJECT_MEGA).stacksTo(64).rarity(Rarity.UNCOMMON));
	}

	@Override
	public UseAnim getUseAnimation(ItemStack itemstack) {
		return UseAnim.EAT;
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		list.add(Component.literal("Copper: 500"));
		list.add(Component.literal("Caterium: 584"));
		list.add(Component.literal("Iron: 2 343"));
		list.add(Component.literal("Coal: 1 254"));
	}
}
