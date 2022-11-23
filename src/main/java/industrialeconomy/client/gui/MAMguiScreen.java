
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

import industrialeconomy.world.inventory.MAMguiMenu;

import industrialeconomy.procedures.TimetoCompleteShowConditionProcedure;

import industrialeconomy.network.MAMguiButtonMessage;

import industrialeconomy.IndustrialEconomyMod;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class MAMguiScreen extends AbstractContainerScreen<MAMguiMenu> {
	private final static HashMap<String, Object> guistate = MAMguiMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;

	public MAMguiScreen(MAMguiMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 350;
		this.imageHeight = 200;
	}

	private static final ResourceLocation texture = new ResourceLocation("industrial_economy:textures/screens/ma_mgui.png");

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
		this.blit(ms, this.leftPos + 8, this.topPos + 174, 0, 0, 16, 16, 16, 16);

		RenderSystem.setShaderTexture(0, new ResourceLocation("industrial_economy:textures/screens/mamguimoney.png"));
		this.blit(ms, this.leftPos + 198, this.topPos + 176, 0, 0, 16, 16, 16, 16);

		RenderSystem.setShaderTexture(0, new ResourceLocation("industrial_economy:textures/screens/mamguienergy.png"));
		this.blit(ms, this.leftPos + 114, this.topPos + 11, 0, 0, 16, 16, 16, 16);

		RenderSystem.setShaderTexture(0, new ResourceLocation("industrial_economy:textures/screens/mamguimoney.png"));
		this.blit(ms, this.leftPos + 189, this.topPos + 12, 0, 0, 16, 16, 16, 16);

		RenderSystem.setShaderTexture(0, new ResourceLocation("industrial_economy:textures/screens/mamguimoney.png"));
		this.blit(ms, this.leftPos + 251, this.topPos + 33, 0, 0, 16, 16, 16, 16);

		RenderSystem.setShaderTexture(0, new ResourceLocation("industrial_economy:textures/screens/mamguimoney.png"));
		this.blit(ms, this.leftPos + 200, this.topPos + 53, 0, 0, 16, 16, 16, 16);

		RenderSystem.setShaderTexture(0, new ResourceLocation("industrial_economy:textures/screens/mamguienergy.png"));
		this.blit(ms, this.leftPos + 151, this.topPos + 32, 0, 0, 16, 16, 16, 16);

		RenderSystem.setShaderTexture(0, new ResourceLocation("industrial_economy:textures/screens/mamguienergy.png"));
		this.blit(ms, this.leftPos + 140, this.topPos + 53, 0, 0, 16, 16, 16, 16);

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
		this.font.draw(poseStack, "" + (new Object() {
			public double getValue(BlockPos pos, String tag) {
				BlockEntity BlockEntity = world.getBlockEntity(pos);
				if (BlockEntity != null)
					return BlockEntity.getPersistentData().getDouble(tag);
				return 0;
			}
		}.getValue(new BlockPos((int) x, (int) y, (int) z), "Energy")) + "", 22, 178, -12829636);
		this.font.draw(poseStack, "" + (new Object() {
			public double getValue(BlockPos pos, String tag) {
				BlockEntity BlockEntity = world.getBlockEntity(pos);
				if (BlockEntity != null)
					return BlockEntity.getPersistentData().getDouble(tag);
				return 0;
			}
		}.getValue(new BlockPos((int) x, (int) y, (int) z), "Money")) + "", 216, 179, -12829636);
		if (TimetoCompleteShowConditionProcedure.execute(world, x, y, z))
			this.font.draw(poseStack, "Time to complete research: " + (new Object() {
				public double getValue(BlockPos pos, String tag) {
					BlockEntity BlockEntity = world.getBlockEntity(pos);
					if (BlockEntity != null)
						return BlockEntity.getPersistentData().getDouble(tag);
					return 0;
				}
			}.getValue(new BlockPos((int) x, (int) y, (int) z), "TimeToComplete")) + "", 4, 159, -12829636);
		this.font.draw(poseStack, "50 000 MW", 129, 15, -12829636);
		this.font.draw(poseStack, "5 000 coins", 210, 15, -12829636);
		this.font.draw(poseStack, "5 000 000 MW", 169, 36, -12829636);
		this.font.draw(poseStack, "50 000 coins", 271, 36, -12829636);
		this.font.draw(poseStack, "5 E7", 154, 57, -12829636);
		this.font.draw(poseStack, "150 000 coins", 224, 57, -12829636);
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
		this.addRenderableWidget(new Button(this.leftPos + 8, this.topPos + 9, 93, 20, Component.literal("Steel Upgrade"), e -> {
			if (true) {
				IndustrialEconomyMod.PACKET_HANDLER.sendToServer(new MAMguiButtonMessage(0, x, y, z));
				MAMguiButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 8, this.topPos + 30, 134, 20, Component.literal("Diamond Steel Upgrade"), e -> {
			if (true) {
				IndustrialEconomyMod.PACKET_HANDLER.sendToServer(new MAMguiButtonMessage(1, x, y, z));
				MAMguiButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 8, this.topPos + 51, 119, 20, Component.literal("Black Opal Upgrade"), e -> {
			if (true) {
				IndustrialEconomyMod.PACKET_HANDLER.sendToServer(new MAMguiButtonMessage(2, x, y, z));
				MAMguiButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}));
	}
}
