package industrialeconomy.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;

import industrialeconomy.init.IndustrialEconomyModBlocks;

public class BuilderclearprocedureProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		boolean found = false;
		double sx = 0;
		double sy = 0;
		double sz = 0;
		sx = -150;
		for (int index0 = 0; index0 < (int) (300); index0++) {
			sy = -30;
			for (int index1 = 0; index1 < (int) (80); index1++) {
				sz = -150;
				for (int index2 = 0; index2 < (int) (300); index2++) {
					if ((world.getBlockState(new BlockPos(x + sx, y + sy, z + sz))).getBlock() == IndustrialEconomyModBlocks.BUILDER_PREVIEWBLOCK
							.get()) {
						world.setBlock(new BlockPos(x + sx, y + sy, z + sz), Blocks.AIR.defaultBlockState(), 3);
					}
					sz = sz + 1;
				}
				sy = sy + 1;
			}
			sx = sx + 1;
		}
		if (entity instanceof Player _player && !_player.level.isClientSide())
			_player.displayClientMessage(Component.literal("Preview Cleared."), (false));
	}
}
