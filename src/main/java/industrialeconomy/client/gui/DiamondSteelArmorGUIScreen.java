
package industrialeconomy.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.Minecraft;

import java.util.HashMap;

import industrialeconomy.world.inventory.DiamondSteelArmorGUIMenu;

import industrialeconomy.procedures.DSAplasmalabelProcedure;
import industrialeconomy.procedures.DSAoverlaywaterbreatheProcedure;
import industrialeconomy.procedures.DSAoverlayspeedProcedure;
import industrialeconomy.procedures.DSAoverlayslowfallingProcedure;
import industrialeconomy.procedures.DSAoverlaynightvisionProcedure;
import industrialeconomy.procedures.DSAoverlayjetpackProcedure;
import industrialeconomy.procedures.DSAoverlaydolphingraceProcedure;

import industrialeconomy.network.IndustrialEconomyModVariables;
import industrialeconomy.network.DiamondSteelArmorGUIButtonMessage;

import industrialeconomy.IndustrialEconomyMod;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class DiamondSteelArmorGUIScreen extends AbstractContainerScreen<DiamondSteelArmorGUIMenu> {
	private final static HashMap<String, Object> guistate = DiamondSteelArmorGUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;

	public DiamondSteelArmorGUIScreen(DiamondSteelArmorGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 248;
		this.imageHeight = 218;
	}

	private static final ResourceLocation texture = new ResourceLocation("industrial_economy:textures/screens/diamond_steel_armor_gui.png");

	@Override
	public void render(PoseStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderTooltip(ms, mouseX, mouseY);
	}

	@Override
	protected void renderBg(PoseStack ms, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		RenderSystem.setShaderTexture(0, texture);
		this.blit(ms, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);

		RenderSystem.setShaderTexture(0, new ResourceLocation("industrial_economy:textures/screens/2.png"));
		this.blit(ms, this.leftPos + 114, this.topPos + 87, 0, 0, 16, 16, 16, 16);

		RenderSystem.setShaderTexture(0, new ResourceLocation("industrial_economy:textures/screens/1.png"));
		this.blit(ms, this.leftPos + 114, this.topPos + 60, 0, 0, 16, 16, 16, 16);

		RenderSystem.setShaderTexture(0, new ResourceLocation("industrial_economy:textures/screens/3.png"));
		this.blit(ms, this.leftPos + 114, this.topPos + 33, 0, 0, 16, 16, 16, 16);

		RenderSystem.setShaderTexture(0, new ResourceLocation("industrial_economy:textures/screens/4.png"));
		this.blit(ms, this.leftPos + 114, this.topPos + 114, 0, 0, 16, 16, 16, 16);

		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
	}

	@Override
	protected void renderLabels(PoseStack poseStack, int mouseX, int mouseY) {
		this.font.draw(poseStack, "Armor Panel", 4, 4, -12829636);
		if (DSAoverlayspeedProcedure.execute(entity))
			this.font.draw(poseStack, "Speed", 166, 197, -16724992);
		if (DSAoverlayslowfallingProcedure.execute(entity))
			this.font.draw(poseStack, "Slow Falling", 149, 184, -13382656);
		if (DSAoverlayjetpackProcedure.execute(entity))
			this.font.draw(poseStack, "JetPack", 160, 170, -16724992);
		if (DSAoverlaynightvisionProcedure.execute(entity))
			this.font.draw(poseStack, "Night Vision", 150, 156, -16724992);
		if (DSAoverlaywaterbreatheProcedure.execute(entity))
			this.font.draw(poseStack, "Water Breathe", 14, 157, -13382656);
		if (DSAoverlaydolphingraceProcedure.execute(entity))
			this.font.draw(poseStack, "Fast Swim", 22, 184, -16724992);
		this.font.draw(poseStack, "Energy: " + (int) ((entity.getCapability(IndustrialEconomyModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new IndustrialEconomyModVariables.PlayerVariables())).DSA_energy) + "", 78, 3, -16750849);
		this.font.draw(poseStack, "Active Functions", 80, 143, -12829636);
		if (DSAplasmalabelProcedure.execute(entity))
			this.font.draw(poseStack, "Plasma Shoot", 16, 170, -16724992);
		this.font.draw(poseStack,
				"Plasma Shoot CoolDown: " + (int) ((entity.getCapability(IndustrialEconomyModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new IndustrialEconomyModVariables.PlayerVariables())).DSA_PlasmaShoot_Cooldown) + "",
				4, 17, -12829636);
	}

	@Override
	public void onClose() {
		super.onClose();
		Minecraft.getInstance().keyboardHandler.setSendRepeatsToGui(false);
	}

	@Override
	public void init() {
		super.init();
		this.minecraft.keyboardHandler.setSendRepeatsToGui(true);
		this.addRenderableWidget(new Button(this.leftPos + 150, this.topPos + 33, 85, 20, Component.literal("Night Vision"), e -> {
			if (true) {
				IndustrialEconomyMod.PACKET_HANDLER.sendToServer(new DiamondSteelArmorGUIButtonMessage(0, x, y, z));
				DiamondSteelArmorGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 168, this.topPos + 60, 60, 20, Component.literal("Jetpack"), e -> {
			if (true) {
				IndustrialEconomyMod.PACKET_HANDLER.sendToServer(new DiamondSteelArmorGUIButtonMessage(1, x, y, z));
				DiamondSteelArmorGUIButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 168, this.topPos + 114, 50, 20, Component.literal("Speed"), e -> {
			if (true) {
				IndustrialEconomyMod.PACKET_HANDLER.sendToServer(new DiamondSteelArmorGUIButtonMessage(2, x, y, z));
				DiamondSteelArmorGUIButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 6, this.topPos + 33, 90, 20, Component.literal("Water Breathe"), e -> {
			if (true) {
				IndustrialEconomyMod.PACKET_HANDLER.sendToServer(new DiamondSteelArmorGUIButtonMessage(3, x, y, z));
				DiamondSteelArmorGUIButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 150, this.topPos + 87, 85, 20, Component.literal("Slow Falling"), e -> {
			if (true) {
				IndustrialEconomyMod.PACKET_HANDLER.sendToServer(new DiamondSteelArmorGUIButtonMessage(4, x, y, z));
				DiamondSteelArmorGUIButtonMessage.handleButtonAction(entity, 4, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 6, this.topPos + 87, 90, 20, Component.literal("Fast Swim"), e -> {
			if (true) {
				IndustrialEconomyMod.PACKET_HANDLER.sendToServer(new DiamondSteelArmorGUIButtonMessage(5, x, y, z));
				DiamondSteelArmorGUIButtonMessage.handleButtonAction(entity, 5, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 24, this.topPos + 114, 30, 20, Component.literal("X"), e -> {
		}));
		this.addRenderableWidget(new Button(this.leftPos + 10, this.topPos + 59, 85, 20, Component.literal("Plasma Shoot"), e -> {
			if (true) {
				IndustrialEconomyMod.PACKET_HANDLER.sendToServer(new DiamondSteelArmorGUIButtonMessage(7, x, y, z));
				DiamondSteelArmorGUIButtonMessage.handleButtonAction(entity, 7, x, y, z);
			}
		}));
	}
}
