
package industrialeconomy.client.gui;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.Minecraft;

import java.util.HashMap;

import industrialeconomy.world.inventory.MamGUIElectronicsOnClickMenu;

import industrialeconomy.network.MamGUIElectronicsOnClickButtonMessage;

import industrialeconomy.IndustrialEconomyMod;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class MamGUIElectronicsOnClickScreen extends AbstractContainerScreen<MamGUIElectronicsOnClickMenu> {
	private final static HashMap<String, Object> guistate = MamGUIElectronicsOnClickMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;

	public MamGUIElectronicsOnClickScreen(MamGUIElectronicsOnClickMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 293;
		this.imageHeight = 201;
	}

	private static final ResourceLocation texture = new ResourceLocation("industrial_economy:textures/screens/mam_gui_electronics.png");

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

		RenderSystem.setShaderTexture(0, new ResourceLocation("industrial_economy:textures/screens/mamguienergy.png"));
		this.blit(ms, this.leftPos + 9, this.topPos + 176, 0, 0, 16, 16, 16, 16);

		RenderSystem.setShaderTexture(0, new ResourceLocation("industrial_economy:textures/screens/mamguimoney.png"));
		this.blit(ms, this.leftPos + 152, this.topPos + 177, 0, 0, 16, 16, 16, 16);

		RenderSystem.setShaderTexture(0, new ResourceLocation("industrial_economy:textures/screens/mamguienergy.png"));
		this.blit(ms, this.leftPos + 97, this.topPos + 10, 0, 0, 16, 16, 16, 16);

		RenderSystem.setShaderTexture(0, new ResourceLocation("industrial_economy:textures/screens/mamguimoney.png"));
		this.blit(ms, this.leftPos + 164, this.topPos + 10, 0, 0, 16, 16, 16, 16);

		RenderSystem.setShaderTexture(0, new ResourceLocation("industrial_economy:textures/screens/mamguimoney.png"));
		this.blit(ms, this.leftPos + 162, this.topPos + 32, 0, 0, 16, 16, 16, 16);

		RenderSystem.setShaderTexture(0, new ResourceLocation("industrial_economy:textures/screens/mamguienergy.png"));
		this.blit(ms, this.leftPos + 98, this.topPos + 32, 0, 0, 16, 16, 16, 16);

		RenderSystem.setShaderTexture(0, new ResourceLocation("industrial_economy:textures/screens/mamguimoney.png"));
		this.blit(ms, this.leftPos + 191, this.topPos + 54, 0, 0, 16, 16, 16, 16);

		RenderSystem.setShaderTexture(0, new ResourceLocation("industrial_economy:textures/screens/mamguienergy.png"));
		this.blit(ms, this.leftPos + 96, this.topPos + 54, 0, 0, 16, 16, 16, 16);

		RenderSystem.setShaderTexture(0, new ResourceLocation("industrial_economy:textures/screens/mamguienergy.png"));
		this.blit(ms, this.leftPos + 104, this.topPos + 76, 0, 0, 16, 16, 16, 16);

		RenderSystem.setShaderTexture(0, new ResourceLocation("industrial_economy:textures/screens/mamguienergy.png"));
		this.blit(ms, this.leftPos + 104, this.topPos + 98, 0, 0, 16, 16, 16, 16);

		RenderSystem.setShaderTexture(0, new ResourceLocation("industrial_economy:textures/screens/mamguimoney.png"));
		this.blit(ms, this.leftPos + 170, this.topPos + 76, 0, 0, 16, 16, 16, 16);

		RenderSystem.setShaderTexture(0, new ResourceLocation("industrial_economy:textures/screens/mamguimoney.png"));
		this.blit(ms, this.leftPos + 169, this.topPos + 98, 0, 0, 16, 16, 16, 16);

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
		this.font.draw(poseStack, "Energy: " + (new Object() {
			public double getValue(BlockPos pos, String tag) {
				BlockEntity BlockEntity = world.getBlockEntity(pos);
				if (BlockEntity != null)
					return BlockEntity.getPersistentData().getDouble(tag);
				return 0;
			}
		}.getValue(new BlockPos((int) x, (int) y, (int) z), "Energy")) + "", 20, 180, -12829636);
		this.font.draw(poseStack, "Money: " + (new Object() {
			public double getValue(BlockPos pos, String tag) {
				BlockEntity BlockEntity = world.getBlockEntity(pos);
				if (BlockEntity != null)
					return BlockEntity.getPersistentData().getDouble(tag);
				return 0;
			}
		}.getValue(new BlockPos((int) x, (int) y, (int) z), "Money")) + "", 171, 180, -12829636);
		this.font.draw(poseStack, "1 E8 MW", 114, 35, -12829636);
		this.font.draw(poseStack, "150 000 coins", 187, 35, -12829636);
		this.font.draw(poseStack, "2.5 E7 MW", 112, 14, -12829636);
		this.font.draw(poseStack, "25 000 coins", 189, 13, -12829636);
		this.font.draw(poseStack, "350 milions MW", 109, 57, -12829636);
		this.font.draw(poseStack, "150 000 coins", 211, 57, -12829636);
		this.font.draw(poseStack, "1 E9 MW", 119, 79, -12829636);
		this.font.draw(poseStack, "2 E9 MW", 119, 101, -12829636);
		this.font.draw(poseStack, "150 000 coins", 193, 79, -12829636);
		this.font.draw(poseStack, "150 000 coins", 195, 100, -12829636);
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
		this.addRenderableWidget(new Button(this.leftPos + 10, this.topPos + 8, 82, 20, Component.literal("2x Core CPU"), e -> {
			if (true) {
				IndustrialEconomyMod.PACKET_HANDLER.sendToServer(new MamGUIElectronicsOnClickButtonMessage(0, x, y, z));
				MamGUIElectronicsOnClickButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 10, this.topPos + 30, 82, 20, Component.literal("4x Core CPU"), e -> {
			if (true) {
				IndustrialEconomyMod.PACKET_HANDLER.sendToServer(new MamGUIElectronicsOnClickButtonMessage(1, x, y, z));
				MamGUIElectronicsOnClickButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 10, this.topPos + 52, 82, 20, Component.literal("8x Core CPU"), e -> {
			if (true) {
				IndustrialEconomyMod.PACKET_HANDLER.sendToServer(new MamGUIElectronicsOnClickButtonMessage(2, x, y, z));
				MamGUIElectronicsOnClickButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 10, this.topPos + 74, 87, 20, Component.literal("16x Core CPU"), e -> {
			if (true) {
				IndustrialEconomyMod.PACKET_HANDLER.sendToServer(new MamGUIElectronicsOnClickButtonMessage(3, x, y, z));
				MamGUIElectronicsOnClickButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 10, this.topPos + 96, 87, 20, Component.literal("32x Core CPU"), e -> {
			if (true) {
				IndustrialEconomyMod.PACKET_HANDLER.sendToServer(new MamGUIElectronicsOnClickButtonMessage(4, x, y, z));
				MamGUIElectronicsOnClickButtonMessage.handleButtonAction(entity, 4, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 10, this.topPos + 118, 87, 20, Component.literal("64x Core CPU"), e -> {
		}));
		this.addRenderableWidget(new Button(this.leftPos + 10, this.topPos + 140, 92, 20, Component.literal("128x Core CPU"), e -> {
		}));
	}
}
