package industrialeconomy.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.GameType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.client.Minecraft;

import industrialeconomy.network.IndustrialEconomyModVariables;

public class DiamondSteelArmorBodyTickEventProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (new Object() {
			public boolean checkGamemode(Entity _ent) {
				if (_ent instanceof ServerPlayer _serverPlayer) {
					return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.SURVIVAL;
				} else if (_ent.level.isClientSide() && _ent instanceof Player _player) {
					return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null && Minecraft.getInstance()
							.getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.SURVIVAL;
				}
				return false;
			}
		}.checkGamemode(entity)) {
			if ((entity.getCapability(IndustrialEconomyModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new IndustrialEconomyModVariables.PlayerVariables())).DSA_Jetpack == true
					&& (entity.getCapability(IndustrialEconomyModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new IndustrialEconomyModVariables.PlayerVariables())).DSA_energy > 1) {
				if (entity instanceof Player _player) {
					_player.getAbilities().mayfly = (true);
					_player.onUpdateAbilities();
				}
				if ((entity.getCapability(IndustrialEconomyModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new IndustrialEconomyModVariables.PlayerVariables())).DSA_Jetpack == true
						&& (entity.getCapability(IndustrialEconomyModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new IndustrialEconomyModVariables.PlayerVariables())).DSA_energy > 1
						&& !entity.isOnGround()) {
					world.addParticle(ParticleTypes.FLAME, x, (y + 1), z, 0, (-0.2), 0);
					world.addParticle(ParticleTypes.CLOUD, x, (y + 0.5), z, 0, (-0.2), 0);
					if (Math.random() < 0.15) {
						{
							double _setval = (entity.getCapability(IndustrialEconomyModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new IndustrialEconomyModVariables.PlayerVariables())).DSA_energy - 1;
							entity.getCapability(IndustrialEconomyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.DSA_energy = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					}
				}
			} else {
				if (entity instanceof Player _player) {
					_player.getAbilities().mayfly = (false);
					_player.onUpdateAbilities();
				}
			}
		}
	}
}
