package industrialeconomy.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.core.BlockPos;

public class DiamondsteelaxeBlockDestroyedWithToolProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		boolean found = false;
		double sx = 0;
		double sy = 0;
		double sz = 0;
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag()
				.getBoolean("TreeChopper") == true) {
			if ((world.getBlockState(new BlockPos(x, y, z))).getBlock() == Blocks.OAK_LOG) {
				sx = -2;
				found = false;
				for (int index0 = 0; index0 < (int) (5); index0++) {
					sy = -1;
					for (int index1 = 0; index1 < (int) (15); index1++) {
						sz = -2;
						for (int index2 = 0; index2 < (int) (5); index2++) {
							if ((world.getBlockState(new BlockPos(x + sx, y + sy, z + sz))).getBlock() == Blocks.OAK_LOG) {
								{
									BlockPos _pos = new BlockPos(x + sx, y + sy, z + sz);
									Block.dropResources(world.getBlockState(_pos), world, new BlockPos(x, y, z), null);
									world.destroyBlock(_pos, false);
								}
								{
									ItemStack _ist = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
									if (_ist.hurt(1, RandomSource.create(), null)) {
										_ist.shrink(1);
										_ist.setDamageValue(0);
									}
								}
							}
							sz = sz + 1;
						}
						sy = sy + 1;
					}
					sx = sx + 1;
				}
			} else if ((world.getBlockState(new BlockPos(x, y, z))).getBlock() == Blocks.BIRCH_LOG) {
				sx = -1;
				found = false;
				for (int index3 = 0; index3 < (int) (3); index3++) {
					sy = -1;
					for (int index4 = 0; index4 < (int) (15); index4++) {
						sz = -1;
						for (int index5 = 0; index5 < (int) (3); index5++) {
							if ((world.getBlockState(new BlockPos(x + sx, y + sy, z + sz))).getBlock() == Blocks.BIRCH_LOG) {
								{
									BlockPos _pos = new BlockPos(x + sx, y + sy, z + sz);
									Block.dropResources(world.getBlockState(_pos), world, new BlockPos(x, y, z), null);
									world.destroyBlock(_pos, false);
								}
								{
									ItemStack _ist = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
									if (_ist.hurt(1, RandomSource.create(), null)) {
										_ist.shrink(1);
										_ist.setDamageValue(0);
									}
								}
							}
							sz = sz + 1;
						}
						sy = sy + 1;
					}
					sx = sx + 1;
				}
			} else if ((world.getBlockState(new BlockPos(x, y, z))).getBlock() == Blocks.JUNGLE_LOG) {
				sx = -1;
				found = false;
				for (int index6 = 0; index6 < (int) (3); index6++) {
					sy = -1;
					for (int index7 = 0; index7 < (int) (30); index7++) {
						sz = -1;
						for (int index8 = 0; index8 < (int) (3); index8++) {
							if ((world.getBlockState(new BlockPos(x + sx, y + sy, z + sz))).getBlock() == Blocks.JUNGLE_LOG) {
								{
									BlockPos _pos = new BlockPos(x + sx, y + sy, z + sz);
									Block.dropResources(world.getBlockState(_pos), world, new BlockPos(x, y, z), null);
									world.destroyBlock(_pos, false);
								}
								{
									ItemStack _ist = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
									if (_ist.hurt(1, RandomSource.create(), null)) {
										_ist.shrink(1);
										_ist.setDamageValue(0);
									}
								}
							}
							sz = sz + 1;
						}
						sy = sy + 1;
					}
					sx = sx + 1;
				}
			} else if ((world.getBlockState(new BlockPos(x, y, z))).getBlock() == Blocks.SPRUCE_LOG) {
				sx = -1;
				found = false;
				for (int index9 = 0; index9 < (int) (3); index9++) {
					sy = -1;
					for (int index10 = 0; index10 < (int) (15); index10++) {
						sz = -1;
						for (int index11 = 0; index11 < (int) (3); index11++) {
							if ((world.getBlockState(new BlockPos(x + sx, y + sy, z + sz))).getBlock() == Blocks.SPRUCE_LOG) {
								{
									BlockPos _pos = new BlockPos(x + sx, y + sy, z + sz);
									Block.dropResources(world.getBlockState(_pos), world, new BlockPos(x, y, z), null);
									world.destroyBlock(_pos, false);
								}
								{
									ItemStack _ist = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
									if (_ist.hurt(1, RandomSource.create(), null)) {
										_ist.shrink(1);
										_ist.setDamageValue(0);
									}
								}
							}
							sz = sz + 1;
						}
						sy = sy + 1;
					}
					sx = sx + 1;
				}
			} else if ((world.getBlockState(new BlockPos(x, y, z))).getBlock() == Blocks.ACACIA_LOG) {
				sx = -1;
				found = false;
				for (int index12 = 0; index12 < (int) (3); index12++) {
					sy = -1;
					for (int index13 = 0; index13 < (int) (15); index13++) {
						sz = -1;
						for (int index14 = 0; index14 < (int) (3); index14++) {
							if ((world.getBlockState(new BlockPos(x + sx, y + sy, z + sz))).getBlock() == Blocks.ACACIA_LOG) {
								{
									BlockPos _pos = new BlockPos(x + sx, y + sy, z + sz);
									Block.dropResources(world.getBlockState(_pos), world, new BlockPos(x, y, z), null);
									world.destroyBlock(_pos, false);
								}
								{
									ItemStack _ist = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
									if (_ist.hurt(1, RandomSource.create(), null)) {
										_ist.shrink(1);
										_ist.setDamageValue(0);
									}
								}
							}
							sz = sz + 1;
						}
						sy = sy + 1;
					}
					sx = sx + 1;
				}
			} else if ((world.getBlockState(new BlockPos(x, y, z))).getBlock() == Blocks.DARK_OAK_LOG) {
				sx = -1;
				found = false;
				for (int index15 = 0; index15 < (int) (3); index15++) {
					sy = -1;
					for (int index16 = 0; index16 < (int) (15); index16++) {
						sz = -1;
						for (int index17 = 0; index17 < (int) (3); index17++) {
							if ((world.getBlockState(new BlockPos(x + sx, y + sy, z + sz))).getBlock() == Blocks.DARK_OAK_LOG) {
								{
									BlockPos _pos = new BlockPos(x + sx, y + sy, z + sz);
									Block.dropResources(world.getBlockState(_pos), world, new BlockPos(x, y, z), null);
									world.destroyBlock(_pos, false);
								}
								{
									ItemStack _ist = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
									if (_ist.hurt(1, RandomSource.create(), null)) {
										_ist.shrink(1);
										_ist.setDamageValue(0);
									}
								}
							}
							sz = sz + 1;
						}
						sy = sy + 1;
					}
					sx = sx + 1;
				}
			}
		}
	}
}
