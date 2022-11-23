package industrialeconomy.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

public class CateriumExtractorBlockDestroyedByPlayerProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (world instanceof ServerLevel _level)
			_level.getServer().getCommands().performPrefixedCommand(
					new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(),
							null).withSuppressedOutput(),
					("forceload remove " + new java.text.DecimalFormat("#").format(x) + " " + new java.text.DecimalFormat("#").format(z)));
		if (entity instanceof Player _player && !_player.level.isClientSide())
			_player.displayClientMessage(
					Component
							.literal("Chunk Force Unloaded! Other Miners/Generators in range 16 blocks may be affected. Make sure you replace them."),
					(false));
	}
}
