package industrialeconomy.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import industrialeconomy.init.IndustrialEconomyModBlocks;

public class PlaceToolRightClickedOnBlockProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		Direction looking_at_side = Direction.NORTH;
		looking_at_side = entity.level.clip(new ClipContext(entity.getEyePosition(1f),
				entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(5)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
				.getDirection();
		if (Direction.UP == looking_at_side) {
			world.setBlock(new BlockPos(x, y + 1, z), IndustrialEconomyModBlocks.PRESSER_MK_2.get().defaultBlockState(), 3);
		} else if (Direction.DOWN == looking_at_side) {
			world.setBlock(new BlockPos(x, y - 1, z), IndustrialEconomyModBlocks.PRESSER_MK_2.get().defaultBlockState(), 3);
		} else if (Direction.NORTH == looking_at_side) {
			world.setBlock(new BlockPos(x, y, z - 1), IndustrialEconomyModBlocks.PRESSER_MK_2.get().defaultBlockState(), 3);
		} else if (Direction.SOUTH == looking_at_side) {
			world.setBlock(new BlockPos(x, y, z + 1), IndustrialEconomyModBlocks.PRESSER_MK_2.get().defaultBlockState(), 3);
		} else if (Direction.WEST == looking_at_side) {
			world.setBlock(new BlockPos(x + 1, y, z), IndustrialEconomyModBlocks.PRESSER_MK_2.get().defaultBlockState(), 3);
		} else if (Direction.EAST == looking_at_side) {
			world.setBlock(new BlockPos(x - 1, y, z), IndustrialEconomyModBlocks.PRESSER_MK_2.get().defaultBlockState(), 3);
		}
	}
}
