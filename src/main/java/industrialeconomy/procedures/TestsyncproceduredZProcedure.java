package industrialeconomy.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import industrialeconomy.init.IndustrialEconomyModBlocks;

public class TestsyncproceduredZProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		world.setBlock(new BlockPos(x, y, z), IndustrialEconomyModBlocks.CATERIUM_BLOCK.get().defaultBlockState(), 3);
	}
}
