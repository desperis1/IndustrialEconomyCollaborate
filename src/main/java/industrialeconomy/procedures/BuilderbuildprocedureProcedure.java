package industrialeconomy.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;

import industrialeconomy.network.IndustrialEconomyModVariables;

import industrialeconomy.init.IndustrialEconomyModBlocks;

public class BuilderbuildprocedureProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double sx = 0;
		double sy = 0;
		double sz = 0;
		if (((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)).getDamageValue() < 745) {
			sx = -150;
			for (int index0 = 0; index0 < (int) (300); index0++) {
				sy = -20;
				for (int index1 = 0; index1 < (int) (70); index1++) {
					sz = -150;
					for (int index2 = 0; index2 < (int) (300); index2++) {
						if ((world.getBlockState(new BlockPos(x + sx, y + sy, z + sz))).getBlock() == IndustrialEconomyModBlocks.BUILDER_PREVIEWBLOCK
								.get()) {
							if (entity instanceof Player _playerHasItem
									? _playerHasItem.getInventory()
											.contains(((entity.getCapability(IndustrialEconomyModVariables.PLAYER_VARIABLES_CAPABILITY, null)
													.orElse(new IndustrialEconomyModVariables.PlayerVariables())).buildgun_material))
									: false) {
								world.setBlock(new BlockPos(x + sx, y + sy, z + sz),
										(((entity.getCapability(IndustrialEconomyModVariables.PLAYER_VARIABLES_CAPABILITY, null)
												.orElse(new IndustrialEconomyModVariables.PlayerVariables())).buildgun_material)
												.getItem() instanceof BlockItem _bi
														? _bi.getBlock().defaultBlockState()
														: Blocks.AIR.defaultBlockState()),
										3);
								if (entity instanceof Player _player) {
									ItemStack _stktoremove = ((entity.getCapability(IndustrialEconomyModVariables.PLAYER_VARIABLES_CAPABILITY, null)
											.orElse(new IndustrialEconomyModVariables.PlayerVariables())).buildgun_material);
									_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1,
											_player.inventoryMenu.getCraftSlots());
								}
								if (((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)).getDamageValue() < 745) {
									{
										ItemStack _ist = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
										if (_ist.hurt(1, RandomSource.create(), null)) {
											_ist.shrink(1);
											_ist.setDamageValue(0);
										}
									}
								} else {
									if (entity instanceof Player _player && !_player.level.isClientSide())
										_player.displayClientMessage(Component.literal("Low Battery!"), (false));
									break;
								}
							} else {
								if (entity instanceof Player _player && !_player.level.isClientSide())
									_player.displayClientMessage(Component.literal("No Enough Material In Inventory."), (false));
								break;
							}
						}
						sz = sz + 1;
					}
					sy = sy + 1;
				}
				sx = sx + 1;
			}
			if (entity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(Component.literal("Builded"), (false));
		} else {
			if (entity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(Component.literal("Low Battery!"), (false));
		}
	}
}
