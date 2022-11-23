package industrialeconomy.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.BlockPos;

import industrialeconomy.init.IndustrialEconomyModParticleTypes;

public class LiquidHydrogenClientDisplayRandomTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (Math.random() < 0.5) {
			if (world.isEmptyBlock(new BlockPos(x, y + 1, z))) {
				world.addParticle((SimpleParticleType) (IndustrialEconomyModParticleTypes.HYDROGEN_PARTICLE.get()), x, y, z, 0, 0.3, 0);
			}
		}
	}
}
