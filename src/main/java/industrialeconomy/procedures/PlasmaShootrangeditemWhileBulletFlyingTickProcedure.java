package industrialeconomy.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.particles.ParticleTypes;

public class PlasmaShootrangeditemWhileBulletFlyingTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		world.addParticle(ParticleTypes.FLAME, x, y, z, 0, 0, 0);
		world.addParticle(ParticleTypes.FLAME, x, y, z, 0, 0.1, 0);
		world.addParticle(ParticleTypes.FLAME, x, y, z, 0.1, 0, 0);
		world.addParticle(ParticleTypes.FLAME, x, y, z, 0, (-0.1), 0);
		world.addParticle(ParticleTypes.FLAME, x, y, z, 0, 0, (-0.1));
	}
}
