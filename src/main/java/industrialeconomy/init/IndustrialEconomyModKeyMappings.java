
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package industrialeconomy.init;

import org.lwjgl.glfw.GLFW;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.Minecraft;
import net.minecraft.client.KeyMapping;

import industrialeconomy.network.PlasmashootkeybindMessage;
import industrialeconomy.network.NodeScannerModesKeybindMessage;
import industrialeconomy.network.JetpackKeyBindMessage;
import industrialeconomy.network.DiamondPickaxeMENUMessage;
import industrialeconomy.network.DSArmorkeybindMessage;
import industrialeconomy.network.AdminmenukeybindMessage;

import industrialeconomy.IndustrialEconomyMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class IndustrialEconomyModKeyMappings {
	public static final KeyMapping ADMINMENUKEYBIND = new KeyMapping("key.industrial_economy.adminmenukeybind", GLFW.GLFW_KEY_F12,
			"key.categories.misc") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				IndustrialEconomyMod.PACKET_HANDLER.sendToServer(new AdminmenukeybindMessage(0, 0));
				AdminmenukeybindMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping NODE_SCANNER_MODES_KEYBIND = new KeyMapping("key.industrial_economy.node_scanner_modes_keybind", GLFW.GLFW_KEY_V,
			"key.categories.misc") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				IndustrialEconomyMod.PACKET_HANDLER.sendToServer(new NodeScannerModesKeybindMessage(0, 0));
				NodeScannerModesKeybindMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping DIAMOND_PICKAXE_MENU = new KeyMapping("key.industrial_economy.diamond_pickaxe_menu", GLFW.GLFW_KEY_B,
			"key.categories.gameplay") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				IndustrialEconomyMod.PACKET_HANDLER.sendToServer(new DiamondPickaxeMENUMessage(0, 0));
				DiamondPickaxeMENUMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping DS_ARMORKEYBIND = new KeyMapping("key.industrial_economy.ds_armorkeybind", GLFW.GLFW_KEY_KP_0,
			"key.categories.misc") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				IndustrialEconomyMod.PACKET_HANDLER.sendToServer(new DSArmorkeybindMessage(0, 0));
				DSArmorkeybindMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping JETPACK_KEY_BIND = new KeyMapping("key.industrial_economy.jetpack_key_bind", GLFW.GLFW_KEY_SPACE,
			"key.categories.movement") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				IndustrialEconomyMod.PACKET_HANDLER.sendToServer(new JetpackKeyBindMessage(0, 0));
				JetpackKeyBindMessage.pressAction(Minecraft.getInstance().player, 0, 0);
				JETPACK_KEY_BIND_LASTPRESS = System.currentTimeMillis();
			} else if (isDownOld != isDown && !isDown) {
				int dt = (int) (System.currentTimeMillis() - JETPACK_KEY_BIND_LASTPRESS);
				IndustrialEconomyMod.PACKET_HANDLER.sendToServer(new JetpackKeyBindMessage(1, dt));
				JetpackKeyBindMessage.pressAction(Minecraft.getInstance().player, 1, dt);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping PLASMASHOOTKEYBIND = new KeyMapping("key.industrial_economy.plasmashootkeybind", GLFW.GLFW_KEY_TAB,
			"key.categories.misc") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				IndustrialEconomyMod.PACKET_HANDLER.sendToServer(new PlasmashootkeybindMessage(0, 0));
				PlasmashootkeybindMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	private static long JETPACK_KEY_BIND_LASTPRESS = 0;

	@SubscribeEvent
	public static void registerKeyMappings(RegisterKeyMappingsEvent event) {
		event.register(ADMINMENUKEYBIND);
		event.register(NODE_SCANNER_MODES_KEYBIND);
		event.register(DIAMOND_PICKAXE_MENU);
		event.register(DS_ARMORKEYBIND);
		event.register(JETPACK_KEY_BIND);
		event.register(PLASMASHOOTKEYBIND);
	}

	@Mod.EventBusSubscriber({Dist.CLIENT})
	public static class KeyEventListener {
		@SubscribeEvent
		public static void onClientTick(TickEvent.ClientTickEvent event) {
			if (Minecraft.getInstance().screen == null) {
				ADMINMENUKEYBIND.consumeClick();
				NODE_SCANNER_MODES_KEYBIND.consumeClick();
				DIAMOND_PICKAXE_MENU.consumeClick();
				DS_ARMORKEYBIND.consumeClick();
				JETPACK_KEY_BIND.consumeClick();
				PLASMASHOOTKEYBIND.consumeClick();
			}
		}
	}
}
