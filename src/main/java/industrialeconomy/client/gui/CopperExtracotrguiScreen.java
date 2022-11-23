
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

import industrialeconomy.world.inventory.CopperExtracotrguiMenu;

import industrialeconomy.procedures.GeneratorWorkingLabelProcedure;

import industrialeconomy.network.CopperExtracotrguiButtonMessage;

import industrialeconomy.IndustrialEconomyMod;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class CopperExtracotrguiScreen extends AbstractContainerScreen<CopperExtracotrguiMenu> {
	private final static HashMap<String, Object> guistate = CopperExtracotrguiMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;

	public CopperExtracotrguiScreen(CopperExtracotrguiMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("industrial_economy:textures/screens/copper_extracotrgui.png");

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
		this.font.draw(poseStack, "Copper Extractor", 46, 6, -12829636);
		if (GeneratorWorkingLabelProcedure.execute(world, x, y, z))
			this.font.draw(poseStack, "Working", 67, 17, -16711936);
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
		this.addRenderableWidget(new Button(this.leftPos + 58, this.topPos + 52, 55, 20, Component.literal("ON/OFF"), e -> {
			if (true) {
				IndustrialEconomyMod.PACKET_HANDLER.sendToServer(new CopperExtracotrguiButtonMessage(0, x, y, z));
				CopperExtracotrguiButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}));
	}
}
