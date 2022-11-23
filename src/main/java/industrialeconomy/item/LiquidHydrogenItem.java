
package industrialeconomy.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.BucketItem;

import industrialeconomy.init.IndustrialEconomyModFluids;

public class LiquidHydrogenItem extends BucketItem {
	public LiquidHydrogenItem() {
		super(IndustrialEconomyModFluids.LIQUID_HYDROGEN,
				new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1).rarity(Rarity.COMMON).tab(CreativeModeTab.TAB_MISC));
	}
}
