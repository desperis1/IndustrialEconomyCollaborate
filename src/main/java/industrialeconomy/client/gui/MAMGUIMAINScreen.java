
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

import industrialeconomy.world.inventory.MAMGUIMAINMenu;

import industrialeconomy.procedures.TimetoCompleteShowConditionProcedure;

import industrialeconomy.network.MAMGUIMAINButtonMessage;

import industrialeconomy.IndustrialEconomyMod;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class MAMGUIMAINScreen extends AbstractContainerScreen<MAMGUIMAINMenu> {
	private final static HashMap<String, Object> guistate = MAMGUIMAINMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;

	public MAMGUIMAINScreen(MAMGUIMAINMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 293;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("industrial_economy:textures/screens/mamguimain.png");

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

		RenderSystem.setShaderTexture(0, new ResourceLocation("industrial_economy:textures/screens/mamguimoney.png"));
		this.blit(ms, this.leftPos + 144, this.topPos + 143, 0, 0, 16, 16, 16, 16);

		RenderSystem.setShaderTexture(0, new ResourceLocation("industrial_economy:textures/screens/mamguienergy.png"));
		this.blit(ms, this.leftPos + 9, this.topPos + 142, 0, 0, 16, 16, 16, 16);

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
		if (TimetoCompleteShowConditionProcedure.execute(world, x, y, z))
			this.font.draw(poseStack, "Time to complete research: " + (new Object() {
				public double getValue(BlockPos pos, String tag) {
					BlockEntity BlockEntity = world.getBlockEntity(pos);
					if (BlockEntity != null)
						return BlockEntity.getPersistentData().getDouble(tag);
					return 0;
				}
			}.getValue(new BlockPos((int) x, (int) y, (int) z), "TimeToComplete")) + "", 3, 130, -12829636);
		this.font.draw(poseStack, "Energy: " + (new Object() {
			public double getValue(BlockPos pos, String tag) {
				BlockEntity BlockEntity = world.getBlockEntity(pos);
				if (BlockEntity != null)
					return BlockEntity.getPersistentData().getDouble(tag);
				return 0;
			}
		}.getValue(new BlockPos((int) x, (int) y, (int) z), "Energy")) + "", 26, 146, -12829636);
		this.font.draw(poseStack, "Money: " + (new Object() {
			public double getValue(BlockPos pos, String tag) {
				BlockEntity BlockEntity = world.getBlockEntity(pos);
				if (BlockEntity != null)
					return BlockEntity.getPersistentData().getDouble(tag);
				return 0;
			}
		}.getValue(new BlockPos((int) x, (int) y, (int) z), "Money")) + "", 165, 146, -12829636);
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
		this.addRenderableWidget(new Button(this.leftPos + 9, this.topPos + 8, 72, 20, Component.literal("Materials"), e -> {
			if (true) {
				IndustrialEconomyMod.PACKET_HANDLER.sendToServer(new MAMGUIMAINButtonMessage(0, x, y, z));
				MAMGUIMAINButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 9, this.topPos + 31, 82, 20, Component.literal("Electronics"), e -> {
			if (true) {
				IndustrialEconomyMod.PACKET_HANDLER.sendToServer(new MAMGUIMAINButtonMessage(1, x, y, z));
				MAMGUIMAINButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 9, this.topPos + 54, 77, 20, Component.literal("Technology"), e -> {
		}));
	}
}
