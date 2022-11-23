
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package industrialeconomy.init;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;

public class IndustrialEconomyModTabs {
	public static CreativeModeTab TAB_PROJECT_MEGA;

	public static void load() {
		TAB_PROJECT_MEGA = new CreativeModeTab("tabproject_mega") {
			@Override
			public ItemStack makeIcon() {
				return new ItemStack(IndustrialEconomyModItems.CIRCUIT_BOARDITEM.get());
			}

			@Override
			public boolean hasSearchBar() {
				return true;
			}
		}.setBackgroundSuffix("item_search.png");
	}
}
