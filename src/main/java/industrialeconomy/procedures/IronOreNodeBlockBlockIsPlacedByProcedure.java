package industrialeconomy.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.GameType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.core.BlockPos;
import net.minecraft.client.Minecraft;

import industrialeconomy.init.IndustrialEconomyModBlocks;

public class IronOreNodeBlockBlockIsPlacedByProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((world.getBlockState(new BlockPos(x, y - 1, z))).getBlock() == Blocks.DIRT
				|| (world.getBlockState(new BlockPos(x, y - 1, z))).getBlock() == Blocks.STONE
				|| (world.getBlockState(new BlockPos(x, y - 1, z))).getBlock() == Blocks.GRASS_BLOCK) {
			world.setBlock(new BlockPos(x, y, z), Blocks.AIR.defaultBlockState(), 3);
			world.setBlock(new BlockPos(x, y - 1, z), IndustrialEconomyModBlocks.IRON_ORE_NODE_BLOCK.get().defaultBlockState(), 3);
			world.setBlock(new BlockPos(x - 1, y - 1, z), Blocks.IRON_ORE.defaultBlockState(), 3);
			world.setBlock(new BlockPos(x + 1, y - 1, z), Blocks.IRON_ORE.defaultBlockState(), 3);
			world.setBlock(new BlockPos(x, y - 1, z - 1), Blocks.IRON_ORE.defaultBlockState(), 3);
			world.setBlock(new BlockPos(x, y - 1, z + 1), Blocks.IRON_ORE.defaultBlockState(), 3);
		} else {
			world.setBlock(new BlockPos(x, y, z), Blocks.AIR.defaultBlockState(), 3);
			if (new Object() {
				public boolean checkGamemode(Entity _ent) {
					if (_ent instanceof ServerPlayer _serverPlayer) {
						return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.SURVIVAL;
					} else if (_ent.level.isClientSide() && _ent instanceof Player _player) {
						return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null && Minecraft
								.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.SURVIVAL;
					}
					return false;
				}
			}.checkGamemode(entity)) {
				if (world instanceof Level _level && !_level.isClientSide()) {
					ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(IndustrialEconomyModBlocks.IRON_ORE_NODE_BLOCK.get()));
					entityToSpawn.setPickUpDelay(1);
					_level.addFreshEntity(entityToSpawn);
				}
			}
		}
	}
}
