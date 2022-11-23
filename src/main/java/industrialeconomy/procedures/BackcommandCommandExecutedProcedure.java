package industrialeconomy.procedures;

import net.minecraftforge.fml.loading.FMLPaths;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceKey;
import net.minecraft.network.protocol.game.ClientboundUpdateMobEffectPacket;
import net.minecraft.network.protocol.game.ClientboundPlayerAbilitiesPacket;
import net.minecraft.network.protocol.game.ClientboundLevelEventPacket;
import net.minecraft.network.protocol.game.ClientboundGameEventPacket;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;

import java.io.IOException;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

import com.google.gson.Gson;

public class BackcommandCommandExecutedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		com.google.gson.JsonObject mainObject = new com.google.gson.JsonObject();
		String owner = "";
		File playerConfig = new File("");
		playerConfig = new File((FMLPaths.GAMEDIR.get().toString() + "/config/"), File.separator + (entity.getDisplayName().getString() + ".json"));
		{
			try {
				BufferedReader bufferedReader = new BufferedReader(new FileReader(playerConfig));
				StringBuilder jsonstringbuilder = new StringBuilder();
				String line;
				while ((line = bufferedReader.readLine()) != null) {
					jsonstringbuilder.append(line);
				}
				bufferedReader.close();
				mainObject = new Gson().fromJson(jsonstringbuilder.toString(), com.google.gson.JsonObject.class);
				if (!("" + entity.level.dimension()).equals(mainObject.get("backDimension").getAsString())
						&& mainObject.get("backDimension").getAsString().contains("overworld")) {
					if (entity instanceof ServerPlayer _player && !_player.level.isClientSide()) {
						ResourceKey<Level> destinationType = Level.OVERWORLD;
						if (_player.level.dimension() == destinationType)
							return;
						ServerLevel nextLevel = _player.server.getLevel(destinationType);
						if (nextLevel != null) {
							_player.connection.send(new ClientboundGameEventPacket(ClientboundGameEventPacket.WIN_GAME, 0));
							_player.teleportTo(nextLevel, _player.getX(), _player.getY(), _player.getZ(), _player.getYRot(), _player.getXRot());
							_player.connection.send(new ClientboundPlayerAbilitiesPacket(_player.getAbilities()));
							for (MobEffectInstance _effectinstance : _player.getActiveEffects())
								_player.connection.send(new ClientboundUpdateMobEffectPacket(_player.getId(), _effectinstance));
							_player.connection.send(new ClientboundLevelEventPacket(1032, BlockPos.ZERO, 0, false));
						}
					}
					{
						Entity _ent = entity;
						_ent.teleportTo(mainObject.get("backX").getAsDouble(), mainObject.get("backY").getAsDouble(),
								mainObject.get("backZ").getAsDouble());
						if (_ent instanceof ServerPlayer _serverPlayer)
							_serverPlayer.connection.teleport(mainObject.get("backX").getAsDouble(), mainObject.get("backY").getAsDouble(),
									mainObject.get("backZ").getAsDouble(), _ent.getYRot(), _ent.getXRot());
					}
					if (entity instanceof Player _player && !_player.level.isClientSide())
						_player.displayClientMessage(Component.literal("You was returned to your previous location."), (false));
				}
				if (!("" + entity.level.dimension()).equals(mainObject.get("backDimension").getAsString())
						&& mainObject.get("backDimension").getAsString().contains("nether")) {
					if (entity instanceof ServerPlayer _player && !_player.level.isClientSide()) {
						ResourceKey<Level> destinationType = Level.NETHER;
						if (_player.level.dimension() == destinationType)
							return;
						ServerLevel nextLevel = _player.server.getLevel(destinationType);
						if (nextLevel != null) {
							_player.connection.send(new ClientboundGameEventPacket(ClientboundGameEventPacket.WIN_GAME, 0));
							_player.teleportTo(nextLevel, _player.getX(), _player.getY(), _player.getZ(), _player.getYRot(), _player.getXRot());
							_player.connection.send(new ClientboundPlayerAbilitiesPacket(_player.getAbilities()));
							for (MobEffectInstance _effectinstance : _player.getActiveEffects())
								_player.connection.send(new ClientboundUpdateMobEffectPacket(_player.getId(), _effectinstance));
							_player.connection.send(new ClientboundLevelEventPacket(1032, BlockPos.ZERO, 0, false));
						}
					}
					{
						Entity _ent = entity;
						_ent.teleportTo(mainObject.get("backX").getAsDouble(), mainObject.get("backY").getAsDouble(),
								mainObject.get("backZ").getAsDouble());
						if (_ent instanceof ServerPlayer _serverPlayer)
							_serverPlayer.connection.teleport(mainObject.get("backX").getAsDouble(), mainObject.get("backY").getAsDouble(),
									mainObject.get("backZ").getAsDouble(), _ent.getYRot(), _ent.getXRot());
					}
					if (entity instanceof Player _player && !_player.level.isClientSide())
						_player.displayClientMessage(Component.literal("You was returned to your previous location."), (false));
				}
				if (!("" + entity.level.dimension()).equals(mainObject.get("backDimension").getAsString())
						&& mainObject.get("backDimension").getAsString().contains("end")) {
					if (entity instanceof ServerPlayer _player && !_player.level.isClientSide()) {
						ResourceKey<Level> destinationType = Level.END;
						if (_player.level.dimension() == destinationType)
							return;
						ServerLevel nextLevel = _player.server.getLevel(destinationType);
						if (nextLevel != null) {
							_player.connection.send(new ClientboundGameEventPacket(ClientboundGameEventPacket.WIN_GAME, 0));
							_player.teleportTo(nextLevel, _player.getX(), _player.getY(), _player.getZ(), _player.getYRot(), _player.getXRot());
							_player.connection.send(new ClientboundPlayerAbilitiesPacket(_player.getAbilities()));
							for (MobEffectInstance _effectinstance : _player.getActiveEffects())
								_player.connection.send(new ClientboundUpdateMobEffectPacket(_player.getId(), _effectinstance));
							_player.connection.send(new ClientboundLevelEventPacket(1032, BlockPos.ZERO, 0, false));
						}
					}
					{
						Entity _ent = entity;
						_ent.teleportTo(mainObject.get("backX").getAsDouble(), mainObject.get("backY").getAsDouble(),
								mainObject.get("backZ").getAsDouble());
						if (_ent instanceof ServerPlayer _serverPlayer)
							_serverPlayer.connection.teleport(mainObject.get("backX").getAsDouble(), mainObject.get("backY").getAsDouble(),
									mainObject.get("backZ").getAsDouble(), _ent.getYRot(), _ent.getXRot());
					}
					if (entity instanceof Player _player && !_player.level.isClientSide())
						_player.displayClientMessage(Component.literal("You was returned to your previous location."), (false));
				} else {
					{
						Entity _ent = entity;
						_ent.teleportTo(mainObject.get("backX").getAsDouble(), mainObject.get("backY").getAsDouble(),
								mainObject.get("backZ").getAsDouble());
						if (_ent instanceof ServerPlayer _serverPlayer)
							_serverPlayer.connection.teleport(mainObject.get("backX").getAsDouble(), mainObject.get("backY").getAsDouble(),
									mainObject.get("backZ").getAsDouble(), _ent.getYRot(), _ent.getXRot());
					}
					if (entity instanceof Player _player && !_player.level.isClientSide())
						_player.displayClientMessage(Component.literal("You was returned to your previous location."), (false));
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
