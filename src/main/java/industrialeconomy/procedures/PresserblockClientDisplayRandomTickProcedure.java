package industrialeconomy.procedures;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

public class PresserblockClientDisplayRandomTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if ((new Object() {
			public boolean getValue(LevelAccessor world, BlockPos pos, String tag) {
				BlockEntity blockEntity = world.getBlockEntity(pos);
				if (blockEntity != null)
					return blockEntity.getPersistentData().getBoolean(tag);
				return false;
			}
		}.getValue(world, new BlockPos(x, y, z), "Working")) == true) {
			world.addParticle(ParticleTypes.CRIT, (x + 0.5), (y + 0.5), (z + 0.5), 0, 0.05, 0);
		}
	}
}
