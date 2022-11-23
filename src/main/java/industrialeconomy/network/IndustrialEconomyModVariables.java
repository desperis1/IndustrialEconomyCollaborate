package industrialeconomy.network;

import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.Capability;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.nbt.Tag;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.Direction;
import net.minecraft.client.Minecraft;

import java.util.function.Supplier;

import java.io.File;

import industrialeconomy.IndustrialEconomyMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class IndustrialEconomyModVariables {
	public static File prices = new File("");

	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		IndustrialEconomyMod.addNetworkMessage(PlayerVariablesSyncMessage.class, PlayerVariablesSyncMessage::buffer, PlayerVariablesSyncMessage::new,
				PlayerVariablesSyncMessage::handler);
	}

	@SubscribeEvent
	public static void init(RegisterCapabilitiesEvent event) {
		event.register(PlayerVariables.class);
	}

	@Mod.EventBusSubscriber
	public static class EventBusVariableHandlers {
		@SubscribeEvent
		public static void onPlayerLoggedInSyncPlayerVariables(PlayerEvent.PlayerLoggedInEvent event) {
			if (!event.getEntity().level.isClientSide())
				((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()))
						.syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void onPlayerRespawnedSyncPlayerVariables(PlayerEvent.PlayerRespawnEvent event) {
			if (!event.getEntity().level.isClientSide())
				((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()))
						.syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void onPlayerChangedDimensionSyncPlayerVariables(PlayerEvent.PlayerChangedDimensionEvent event) {
			if (!event.getEntity().level.isClientSide())
				((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()))
						.syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void clonePlayer(PlayerEvent.Clone event) {
			event.getOriginal().revive();
			PlayerVariables original = ((PlayerVariables) event.getOriginal().getCapability(PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new PlayerVariables()));
			PlayerVariables clone = ((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new PlayerVariables()));
			clone.diamondsteel_itembuffer = original.diamondsteel_itembuffer;
			clone.player_minnig_level = original.player_minnig_level;
			clone.buildgun_material = original.buildgun_material;
			clone.build_gun_pos_num = original.build_gun_pos_num;
			clone.builder_pos2_z = original.builder_pos2_z;
			clone.builder_pos1_z = original.builder_pos1_z;
			clone.builder_pos2_y = original.builder_pos2_y;
			clone.builder_pos1_y = original.builder_pos1_y;
			clone.builder_pos2_x = original.builder_pos2_x;
			clone.builder_pos1_x = original.builder_pos1_x;
			clone.DSA_energy = original.DSA_energy;
			clone.DSA_PlasmaShoot_Cooldown = original.DSA_PlasmaShoot_Cooldown;
			clone.placetool_machine = original.placetool_machine;
			if (!event.isWasDeath()) {
				clone.DSA_NightVision = original.DSA_NightVision;
				clone.DSA_Jetpack = original.DSA_Jetpack;
				clone.DSA_Speed = original.DSA_Speed;
				clone.DSA_SlowFalling = original.DSA_SlowFalling;
				clone.DSA_DolphinGrace = original.DSA_DolphinGrace;
				clone.DSA_PlasmaShoot = original.DSA_PlasmaShoot;
				clone.DSA_WaterBreathe = original.DSA_WaterBreathe;
			}
		}
	}

	public static final Capability<PlayerVariables> PLAYER_VARIABLES_CAPABILITY = CapabilityManager.get(new CapabilityToken<PlayerVariables>() {
	});

	@Mod.EventBusSubscriber
	private static class PlayerVariablesProvider implements ICapabilitySerializable<Tag> {
		@SubscribeEvent
		public static void onAttachCapabilities(AttachCapabilitiesEvent<Entity> event) {
			if (event.getObject() instanceof Player && !(event.getObject() instanceof FakePlayer))
				event.addCapability(new ResourceLocation("industrial_economy", "player_variables"), new PlayerVariablesProvider());
		}

		private final PlayerVariables playerVariables = new PlayerVariables();
		private final LazyOptional<PlayerVariables> instance = LazyOptional.of(() -> playerVariables);

		@Override
		public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
			return cap == PLAYER_VARIABLES_CAPABILITY ? instance.cast() : LazyOptional.empty();
		}

		@Override
		public Tag serializeNBT() {
			return playerVariables.writeNBT();
		}

		@Override
		public void deserializeNBT(Tag nbt) {
			playerVariables.readNBT(nbt);
		}
	}

	public static class PlayerVariables {
		public boolean DSA_NightVision = false;
		public boolean DSA_Jetpack = false;
		public boolean DSA_Speed = false;
		public boolean DSA_SlowFalling = false;
		public boolean DSA_DolphinGrace = false;
		public boolean DSA_PlasmaShoot = false;
		public boolean DSA_WaterBreathe = false;
		public boolean diamondsteel_itembuffer = false;
		public double player_minnig_level = 1.0;
		public ItemStack buildgun_material = ItemStack.EMPTY;
		public double build_gun_pos_num = 1.0;
		public double builder_pos2_z = 0;
		public double builder_pos1_z = 0;
		public double builder_pos2_y = 0;
		public double builder_pos1_y = 0;
		public double builder_pos2_x = 0;
		public double builder_pos1_x = 0;
		public double DSA_energy = 0;
		public double DSA_PlasmaShoot_Cooldown = 0;
		public String placetool_machine = "\"\"";

		public void syncPlayerVariables(Entity entity) {
			if (entity instanceof ServerPlayer serverPlayer)
				IndustrialEconomyMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> serverPlayer), new PlayerVariablesSyncMessage(this));
		}

		public Tag writeNBT() {
			CompoundTag nbt = new CompoundTag();
			nbt.putBoolean("DSA_NightVision", DSA_NightVision);
			nbt.putBoolean("DSA_Jetpack", DSA_Jetpack);
			nbt.putBoolean("DSA_Speed", DSA_Speed);
			nbt.putBoolean("DSA_SlowFalling", DSA_SlowFalling);
			nbt.putBoolean("DSA_DolphinGrace", DSA_DolphinGrace);
			nbt.putBoolean("DSA_PlasmaShoot", DSA_PlasmaShoot);
			nbt.putBoolean("DSA_WaterBreathe", DSA_WaterBreathe);
			nbt.putBoolean("diamondsteel_itembuffer", diamondsteel_itembuffer);
			nbt.putDouble("player_minnig_level", player_minnig_level);
			nbt.put("buildgun_material", buildgun_material.save(new CompoundTag()));
			nbt.putDouble("build_gun_pos_num", build_gun_pos_num);
			nbt.putDouble("builder_pos2_z", builder_pos2_z);
			nbt.putDouble("builder_pos1_z", builder_pos1_z);
			nbt.putDouble("builder_pos2_y", builder_pos2_y);
			nbt.putDouble("builder_pos1_y", builder_pos1_y);
			nbt.putDouble("builder_pos2_x", builder_pos2_x);
			nbt.putDouble("builder_pos1_x", builder_pos1_x);
			nbt.putDouble("DSA_energy", DSA_energy);
			nbt.putDouble("DSA_PlasmaShoot_Cooldown", DSA_PlasmaShoot_Cooldown);
			nbt.putString("placetool_machine", placetool_machine);
			return nbt;
		}

		public void readNBT(Tag Tag) {
			CompoundTag nbt = (CompoundTag) Tag;
			DSA_NightVision = nbt.getBoolean("DSA_NightVision");
			DSA_Jetpack = nbt.getBoolean("DSA_Jetpack");
			DSA_Speed = nbt.getBoolean("DSA_Speed");
			DSA_SlowFalling = nbt.getBoolean("DSA_SlowFalling");
			DSA_DolphinGrace = nbt.getBoolean("DSA_DolphinGrace");
			DSA_PlasmaShoot = nbt.getBoolean("DSA_PlasmaShoot");
			DSA_WaterBreathe = nbt.getBoolean("DSA_WaterBreathe");
			diamondsteel_itembuffer = nbt.getBoolean("diamondsteel_itembuffer");
			player_minnig_level = nbt.getDouble("player_minnig_level");
			buildgun_material = ItemStack.of(nbt.getCompound("buildgun_material"));
			build_gun_pos_num = nbt.getDouble("build_gun_pos_num");
			builder_pos2_z = nbt.getDouble("builder_pos2_z");
			builder_pos1_z = nbt.getDouble("builder_pos1_z");
			builder_pos2_y = nbt.getDouble("builder_pos2_y");
			builder_pos1_y = nbt.getDouble("builder_pos1_y");
			builder_pos2_x = nbt.getDouble("builder_pos2_x");
			builder_pos1_x = nbt.getDouble("builder_pos1_x");
			DSA_energy = nbt.getDouble("DSA_energy");
			DSA_PlasmaShoot_Cooldown = nbt.getDouble("DSA_PlasmaShoot_Cooldown");
			placetool_machine = nbt.getString("placetool_machine");
		}
	}

	public static class PlayerVariablesSyncMessage {
		public PlayerVariables data;

		public PlayerVariablesSyncMessage(FriendlyByteBuf buffer) {
			this.data = new PlayerVariables();
			this.data.readNBT(buffer.readNbt());
		}

		public PlayerVariablesSyncMessage(PlayerVariables data) {
			this.data = data;
		}

		public static void buffer(PlayerVariablesSyncMessage message, FriendlyByteBuf buffer) {
			buffer.writeNbt((CompoundTag) message.data.writeNBT());
		}

		public static void handler(PlayerVariablesSyncMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
			NetworkEvent.Context context = contextSupplier.get();
			context.enqueueWork(() -> {
				if (!context.getDirection().getReceptionSide().isServer()) {
					PlayerVariables variables = ((PlayerVariables) Minecraft.getInstance().player.getCapability(PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new PlayerVariables()));
					variables.DSA_NightVision = message.data.DSA_NightVision;
					variables.DSA_Jetpack = message.data.DSA_Jetpack;
					variables.DSA_Speed = message.data.DSA_Speed;
					variables.DSA_SlowFalling = message.data.DSA_SlowFalling;
					variables.DSA_DolphinGrace = message.data.DSA_DolphinGrace;
					variables.DSA_PlasmaShoot = message.data.DSA_PlasmaShoot;
					variables.DSA_WaterBreathe = message.data.DSA_WaterBreathe;
					variables.diamondsteel_itembuffer = message.data.diamondsteel_itembuffer;
					variables.player_minnig_level = message.data.player_minnig_level;
					variables.buildgun_material = message.data.buildgun_material;
					variables.build_gun_pos_num = message.data.build_gun_pos_num;
					variables.builder_pos2_z = message.data.builder_pos2_z;
					variables.builder_pos1_z = message.data.builder_pos1_z;
					variables.builder_pos2_y = message.data.builder_pos2_y;
					variables.builder_pos1_y = message.data.builder_pos1_y;
					variables.builder_pos2_x = message.data.builder_pos2_x;
					variables.builder_pos1_x = message.data.builder_pos1_x;
					variables.DSA_energy = message.data.DSA_energy;
					variables.DSA_PlasmaShoot_Cooldown = message.data.DSA_PlasmaShoot_Cooldown;
					variables.placetool_machine = message.data.placetool_machine;
				}
			});
			context.setPacketHandled(true);
		}
	}
}
