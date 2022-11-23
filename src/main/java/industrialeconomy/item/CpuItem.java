
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

public class CpuItem extends Item {
	public CpuItem() {
		super(new Item.Properties().tab(IndustrialEconomyModTabs.TAB_PROJECT_MEGA).stacksTo(64).rarity(Rarity.RARE));
	}

	@Override
	public UseAnim getUseAnimation(ItemStack itemstack) {
		return UseAnim.EAT;
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		list.add(Component.literal("Copper: 2 376"));
		list.add(Component.literal("Caterium: 2 712"));
		list.add(Component.literal("Iron: 10 380"));
		list.add(Component.literal("Coal: 5 472"));
	}
}
