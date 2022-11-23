
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

import industrialeconomy.world.inventory.HUBGUIMenu;

import industrialeconomy.network.HUBGUIButtonMessage;

import industrialeconomy.IndustrialEconomyMod;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class HUBGUIScreen extends AbstractContainerScreen<HUBGUIMenu> {
	private final static HashMap<String, Object> guistate = HUBGUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;

	public HUBGUIScreen(HUBGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 380;
		this.imageHeight = 219;
	}

	private static final ResourceLocation texture = new ResourceLocation("industrial_economy:textures/screens/hubgui.png");

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
		this.blit(ms, this.leftPos + 8, this.topPos + 112, 0, 0, 16, 16, 16, 16);

		RenderSystem.setShaderTexture(0, new ResourceLocation("industrial_economy:textures/screens/up_green_arrow.png"));
		this.blit(ms, this.leftPos + 5, this.topPos + 130, 0, 0, 16, 16, 16, 16);

		RenderSystem.setShaderTexture(0, new ResourceLocation("industrial_economy:textures/screens/down_red_arrow.png"));
		this.blit(ms, this.leftPos + 5, this.topPos + 148, 0, 0, 16, 16, 16, 16);

		RenderSystem.setShaderTexture(0, new ResourceLocation("industrial_economy:textures/screens/mamguimoney.png"));
		this.blit(ms, this.leftPos + 5, this.topPos + 167, 0, 0, 16, 16, 16, 16);

		RenderSystem.setShaderTexture(0, new ResourceLocation("industrial_economy:textures/screens/pickaxe_miner.png"));
		this.blit(ms, this.leftPos + 5, this.topPos + 190, 0, 0, 16, 16, 16, 16);

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
		this.font.draw(poseStack, "Energy:", 24, 116, -16724788);
		this.font.draw(poseStack, "" + (new Object() {
			public double getValue(BlockPos pos, String tag) {
				BlockEntity BlockEntity = world.getBlockEntity(pos);
				if (BlockEntity != null)
					return BlockEntity.getPersistentData().getDouble(tag);
				return 0;
			}
		}.getValue(new BlockPos((int) x, (int) y, (int) z), "Energy")) + "", 63, 117, -12829636);
		this.font.draw(poseStack, "Caterium Mined", 10, 18, -12829636);
		this.font.draw(poseStack, "Coal Mined", 20, 35, -12829636);
		this.font.draw(poseStack, "Iron Mined", 20, 54, -12829636);
		this.font.draw(poseStack, "Copper Mined", 14, 72, -12829636);
		this.font.draw(poseStack, "SandStone Mined", 7, 90, -12829636);
		this.font.draw(poseStack, "HUB", 190, 5, -12829636);
		this.font.draw(poseStack, "" + (new Object() {
			public double getValue(BlockPos pos, String tag) {
				BlockEntity BlockEntity = world.getBlockEntity(pos);
				if (BlockEntity != null)
					return BlockEntity.getPersistentData().getDouble(tag);
				return 0;
			}
		}.getValue(new BlockPos((int) x, (int) y, (int) z), "Caterium")) + "", 124, 18, -12829636);
		this.font.draw(poseStack, "" + (new Object() {
			public double getValue(BlockPos pos, String tag) {
				BlockEntity BlockEntity = world.getBlockEntity(pos);
				if (BlockEntity != null)
					return BlockEntity.getPersistentData().getDouble(tag);
				return 0;
			}
		}.getValue(new BlockPos((int) x, (int) y, (int) z), "Coal")) + "", 124, 35, -12829636);
		this.font.draw(poseStack, "" + (new Object() {
			public double getValue(BlockPos pos, String tag) {
				BlockEntity BlockEntity = world.getBlockEntity(pos);
				if (BlockEntity != null)
					return BlockEntity.getPersistentData().getDouble(tag);
				return 0;
			}
		}.getValue(new BlockPos((int) x, (int) y, (int) z), "Iron")) + "", 124, 54, -12829636);
		this.font.draw(poseStack, "" + (new Object() {
			public double getValue(BlockPos pos, String tag) {
				BlockEntity BlockEntity = world.getBlockEntity(pos);
				if (BlockEntity != null)
					return BlockEntity.getPersistentData().getDouble(tag);
				return 0;
			}
		}.getValue(new BlockPos((int) x, (int) y, (int) z), "Copper")) + "", 124, 72, -12829636);
		this.font.draw(poseStack, "" + (new Object() {
			public double getValue(BlockPos pos, String tag) {
				BlockEntity BlockEntity = world.getBlockEntity(pos);
				if (BlockEntity != null)
					return BlockEntity.getPersistentData().getDouble(tag);
				return 0;
			}
		}.getValue(new BlockPos((int) x, (int) y, (int) z), "SandStone")) + "", 124, 90, -12829636);
		this.font.draw(poseStack, "" + (new Object() {
			public double getValue(BlockPos pos, String tag) {
				BlockEntity BlockEntity = world.getBlockEntity(pos);
				if (BlockEntity != null)
					return BlockEntity.getPersistentData().getDouble(tag);
				return 0;
			}
		}.getValue(new BlockPos((int) x, (int) y, (int) z), "Edown")) + "", 75, 153, -12829636);
		this.font.draw(poseStack, "Produced:", 24, 133, -16764160);
		this.font.draw(poseStack, "Consumed:", 24, 152, -13434880);
		this.font.draw(poseStack, "" + (new Object() {
			public double getValue(BlockPos pos, String tag) {
				BlockEntity BlockEntity = world.getBlockEntity(pos);
				if (BlockEntity != null)
					return BlockEntity.getPersistentData().getDouble(tag);
				return 0;
			}
		}.getValue(new BlockPos((int) x, (int) y, (int) z), "Eup")) + "", 74, 134, -12829636);
		this.font.draw(poseStack, "Money:", 25, 170, -6711040);
		this.font.draw(poseStack, "Miner Levels:", 25, 187, -12829636);
		this.font.draw(poseStack, "" + (new Object() {
			public double getValue(BlockPos pos, String tag) {
				BlockEntity BlockEntity = world.getBlockEntity(pos);
				if (BlockEntity != null)
					return BlockEntity.getPersistentData().getDouble(tag);
				return 0;
			}
		}.getValue(new BlockPos((int) x, (int) y, (int) z), "Money")) + "", 61, 171, -12829636);
		this.font.draw(poseStack, "" + (new Object() {
			public double getValue(BlockPos pos, String tag) {
				BlockEntity BlockEntity = world.getBlockEntity(pos);
				if (BlockEntity != null)
					return BlockEntity.getPersistentData().getDouble(tag);
				return 0;
			}
		}.getValue(new BlockPos((int) x, (int) y, (int) z), "minerLevels")) + "", 97, 188, -12829636);
		this.font.draw(poseStack, "" + (new Object() {
			public double getValue(BlockPos pos, String tag) {
				BlockEntity BlockEntity = world.getBlockEntity(pos);
				if (BlockEntity != null)
					return BlockEntity.getPersistentData().getDouble(tag);
				return 0;
			}
		}.getValue(new BlockPos((int) x, (int) y, (int) z), "EnergyForMinerUpgrade")) + "", 102, 201, -12829636);
		this.font.draw(poseStack, "Upgrade Price:", 25, 200, -12829636);
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
		this.addRenderableWidget(new Button(this.leftPos + 270, this.topPos + 110, 98, 20, Component.literal("Upgrade Miners"), e -> {
			if (true) {
				IndustrialEconomyMod.PACKET_HANDLER.sendToServer(new HUBGUIButtonMessage(0, x, y, z));
				HUBGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}));
	}
}
