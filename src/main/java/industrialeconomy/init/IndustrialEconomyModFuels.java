
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package industrialeconomy.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;

import net.minecraft.world.item.ItemStack;

@Mod.EventBusSubscriber
public class IndustrialEconomyModFuels {
	@SubscribeEvent
	public static void furnaceFuelBurnTimeEvent(FurnaceFuelBurnTimeEvent event) {
		ItemStack itemstack = event.getItemStack();
		if (itemstack.getItem() == IndustrialEconomyModItems.TURBOFUELITEM.get())
			event.setBurnTime(9600);
		else if (itemstack.getItem() == IndustrialEconomyModItems.TURBOFUELITEM_3.get())
			event.setBurnTime(345600);
		else if (itemstack.getItem() == IndustrialEconomyModItems.TURBOFUELITEM_2.get())
			event.setBurnTime(57600);
		else if (itemstack.getItem() == IndustrialEconomyModItems.TURBO_FUEL_MK_4.get())
			event.setBurnTime(3345600);
	}
}
