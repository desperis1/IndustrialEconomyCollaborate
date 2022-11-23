package industrialeconomy.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;

import industrialeconomy.init.IndustrialEconomyModBlocks;

public class NodeScannerRightClickedOnBlockProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		boolean found = false;
		double sx = 0;
		double sy = 0;
		double sz = 0;
		double mark_height = 0;
		if ((itemstack).getDamageValue() < 98) {
			if ((itemstack.getOrCreateTag().getString("NodeMaterial")).equals("Iron")) {
				{
					ItemStack _ist = itemstack;
					if (_ist.hurt(1, RandomSource.create(), null)) {
						_ist.shrink(1);
						_ist.setDamageValue(0);
					}
				}
				sx = -50;
				found = false;
				for (int index0 = 0; index0 < (int) (100); index0++) {
					sy = -50;
					for (int index1 = 0; index1 < (int) (100); index1++) {
						sz = -50;
						for (int index2 = 0; index2 < (int) (100); index2++) {
							if ((world.getBlockState(new BlockPos(x + sx, y + sy, z + sz)))
									.getBlock() == IndustrialEconomyModBlocks.IRON_ORE_NODE_BLOCK.get()
									&& !((world.getBlockState(new BlockPos(x + sx, y + sy + 1, z + sz)))
											.getBlock() == IndustrialEconomyModBlocks.MINERBLOCK.get())) {
								if (entity instanceof Player _player && !_player.level.isClientSide())
									_player.displayClientMessage(Component.literal(("Free Iron Node Found On:" + " X:" + Math.round(x + sx + 1)
											+ " Y:" + Math.round(y + sy) + " Z:" + Math.round(z + sz))), (false));
								mark_height = 3;
								for (int index3 = 0; index3 < (int) (25); index3++) {
									world.setBlock(new BlockPos(x + sx, y + sy + 1 + mark_height, z + sz),
											IndustrialEconomyModBlocks.MARKBLOCK.get().defaultBlockState(), 3);
									mark_height = mark_height + 1;
								}
								found = true;
							}
							sz = sz + 1;
						}
						sy = sy + 1;
					}
					sx = sx + 1;
				}
				if (found == false) {
					if (entity instanceof Player _player && !_player.level.isClientSide())
						_player.displayClientMessage(Component.literal("No Free Iron Nodes Around"), (false));
				}
			} else if ((itemstack.getOrCreateTag().getString("NodeMaterial")).equals("Caterium")) {
				{
					ItemStack _ist = itemstack;
					if (_ist.hurt(1, RandomSource.create(), null)) {
						_ist.shrink(1);
						_ist.setDamageValue(0);
					}
				}
				sx = -50;
				found = false;
				for (int index4 = 0; index4 < (int) (100); index4++) {
					sy = -50;
					for (int index5 = 0; index5 < (int) (100); index5++) {
						sz = -50;
						for (int index6 = 0; index6 < (int) (100); index6++) {
							if ((world.getBlockState(new BlockPos(x + sx, y + sy, z + sz)))
									.getBlock() == IndustrialEconomyModBlocks.CATERIUM_NOD_EBLOCK.get()
									&& !((world.getBlockState(new BlockPos(x + sx, y + sy + 1, z + sz)))
											.getBlock() == IndustrialEconomyModBlocks.MINERBLOCK.get())) {
								if (entity instanceof Player _player && !_player.level.isClientSide())
									_player.displayClientMessage(Component.literal(("Free Caterium Node Found On:" + " X:" + Math.round(x + sx + 1)
											+ " Y:" + Math.round(y + sy) + " Z:" + Math.round(z + sz))), (false));
								mark_height = 3;
								for (int index7 = 0; index7 < (int) (25); index7++) {
									world.setBlock(new BlockPos(x + sx, y + sy + 1 + mark_height, z + sz),
											IndustrialEconomyModBlocks.MARKBLOCK.get().defaultBlockState(), 3);
									mark_height = mark_height + 1;
								}
								found = true;
							}
							sz = sz + 1;
						}
						sy = sy + 1;
					}
					sx = sx + 1;
				}
				if (found == false) {
					if (entity instanceof Player _player && !_player.level.isClientSide())
						_player.displayClientMessage(Component.literal("No Free Caterium Nodes Around"), (false));
				}
			} else if ((itemstack.getOrCreateTag().getString("NodeMaterial")).equals("Coal")) {
				{
					ItemStack _ist = itemstack;
					if (_ist.hurt(1, RandomSource.create(), null)) {
						_ist.shrink(1);
						_ist.setDamageValue(0);
					}
				}
				sx = -50;
				found = false;
				for (int index8 = 0; index8 < (int) (100); index8++) {
					sy = -50;
					for (int index9 = 0; index9 < (int) (100); index9++) {
						sz = -50;
						for (int index10 = 0; index10 < (int) (100); index10++) {
							if ((world.getBlockState(new BlockPos(x + sx, y + sy, z + sz))).getBlock() == IndustrialEconomyModBlocks.COAL_NODE.get()
									&& !((world.getBlockState(new BlockPos(x + sx, y + sy + 1, z + sz)))
											.getBlock() == IndustrialEconomyModBlocks.MINERBLOCK.get())) {
								if (entity instanceof Player _player && !_player.level.isClientSide())
									_player.displayClientMessage(Component.literal(("Free Coal Node Found On:" + " X:" + Math.round(x + sx + 1)
											+ " Y:" + Math.round(y + sy) + " Z:" + Math.round(z + sz))), (false));
								mark_height = 3;
								for (int index11 = 0; index11 < (int) (25); index11++) {
									world.setBlock(new BlockPos(x + sx, y + sy + 1 + mark_height, z + sz),
											IndustrialEconomyModBlocks.MARKBLOCK.get().defaultBlockState(), 3);
									mark_height = mark_height + 1;
								}
								found = true;
							}
							sz = sz + 1;
						}
						sy = sy + 1;
					}
					sx = sx + 1;
				}
				if (found == false) {
					if (entity instanceof Player _player && !_player.level.isClientSide())
						_player.displayClientMessage(Component.literal("No Free Coal Nodes Around"), (false));
				}
			} else if ((itemstack.getOrCreateTag().getString("NodeMaterial")).equals("Copper")) {
				{
					ItemStack _ist = itemstack;
					if (_ist.hurt(1, RandomSource.create(), null)) {
						_ist.shrink(1);
						_ist.setDamageValue(0);
					}
				}
				sx = -50;
				found = false;
				for (int index12 = 0; index12 < (int) (100); index12++) {
					sy = -50;
					for (int index13 = 0; index13 < (int) (100); index13++) {
						sz = -50;
						for (int index14 = 0; index14 < (int) (100); index14++) {
							if ((world.getBlockState(new BlockPos(x + sx, y + sy, z + sz))).getBlock() == IndustrialEconomyModBlocks.COPPER_NODE.get()
									&& !((world.getBlockState(new BlockPos(x + sx, y + sy + 1, z + sz)))
											.getBlock() == IndustrialEconomyModBlocks.MINERBLOCK.get())) {
								if (entity instanceof Player _player && !_player.level.isClientSide())
									_player.displayClientMessage(Component.literal(("Free Copper Node Found On:" + " X:" + Math.round(x + sx + 1)
											+ " Y:" + Math.round(y + sy) + " Z:" + Math.round(z + sz))), (false));
								mark_height = 3;
								for (int index15 = 0; index15 < (int) (25); index15++) {
									world.setBlock(new BlockPos(x + sx, y + sy + 1 + mark_height, z + sz),
											IndustrialEconomyModBlocks.MARKBLOCK.get().defaultBlockState(), 3);
									mark_height = mark_height + 1;
								}
								found = true;
							}
							sz = sz + 1;
						}
						sy = sy + 1;
					}
					sx = sx + 1;
				}
				if (found == false) {
					if (entity instanceof Player _player && !_player.level.isClientSide())
						_player.displayClientMessage(Component.literal("No Free Copper Nodes Around"), (false));
				}
			} else if ((itemstack.getOrCreateTag().getString("NodeMaterial")).equals("SandStone")) {
				{
					ItemStack _ist = itemstack;
					if (_ist.hurt(1, RandomSource.create(), null)) {
						_ist.shrink(1);
						_ist.setDamageValue(0);
					}
				}
				sx = -50;
				found = false;
				for (int index16 = 0; index16 < (int) (100); index16++) {
					sy = -50;
					for (int index17 = 0; index17 < (int) (100); index17++) {
						sz = -50;
						for (int index18 = 0; index18 < (int) (100); index18++) {
							if ((world.getBlockState(new BlockPos(x + sx, y + sy, z + sz))).getBlock() == IndustrialEconomyModBlocks.LIMESTONEACTIVE
									.get()
									&& !((world.getBlockState(new BlockPos(x + sx, y + sy + 1, z + sz)))
											.getBlock() == IndustrialEconomyModBlocks.MINERBLOCK.get())) {
								if (entity instanceof Player _player && !_player.level.isClientSide())
									_player.displayClientMessage(Component.literal(("Free SandStone Node Found On:" + " X:" + Math.round(x + sx + 1)
											+ " Y:" + Math.round(y + sy) + " Z:" + Math.round(z + sz))), (false));
								mark_height = 3;
								for (int index19 = 0; index19 < (int) (25); index19++) {
									world.setBlock(new BlockPos(x + sx, y + sy + 1 + mark_height, z + sz),
											IndustrialEconomyModBlocks.MARKBLOCK.get().defaultBlockState(), 3);
									mark_height = mark_height + 1;
								}
								found = true;
							}
							sz = sz + 1;
						}
						sy = sy + 1;
					}
					sx = sx + 1;
				}
				if (found == false) {
					if (entity instanceof Player _player && !_player.level.isClientSide())
						_player.displayClientMessage(Component.literal("No Free SandStone Nodes Around"), (false));
				}
			}
		} else {
			if (entity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(Component.literal("Low Battery!"), (false));
		}
	}
}
