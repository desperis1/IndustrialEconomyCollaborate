package industrialeconomy.procedures;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import industrialeconomy.init.IndustrialEconomyModBlocks;

public class GivememarkersbuttonProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (!(entity instanceof Player _playerHasItem
				? _playerHasItem.getInventory().contains(new ItemStack(IndustrialEconomyModBlocks.POSITION_1BLOCK.get()))
				: false)) {
			if (entity instanceof Player _player) {
				ItemStack _setstack = new ItemStack(IndustrialEconomyModBlocks.POSITION_1BLOCK.get());
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
		} else {
			if (entity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(Component.literal("You already have Pos 1 Marker in inventory"), (false));
		}
		if (!(entity instanceof Player _playerHasItem
				? _playerHasItem.getInventory().contains(new ItemStack(IndustrialEconomyModBlocks.POSITION_2BLOCK.get()))
				: false)) {
			if (entity instanceof Player _player) {
				ItemStack _setstack = new ItemStack(IndustrialEconomyModBlocks.POSITION_2BLOCK.get());
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
		} else {
			if (entity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(Component.literal("You already have Pos 2 Marker in inventory"), (false));
		}
	}
}
