
package industrialeconomy.client.gui;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.Minecraft;

import java.util.HashMap;

import industrialeconomy.world.inventory.PresserGUIMenu;

import industrialeconomy.procedures.GeneratorWorkingLabelProcedure;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class PresserGUIScreen extends AbstractContainerScreen<PresserGUIMenu> {
	private final static HashMap<String, Object> guistate = PresserGUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;

	public PresserGUIScreen(PresserGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("industrial_economy:textures/screens/presser_gui.png");

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
		if (GeneratorWorkingLabelProcedure.execute(world, x, y, z)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("industrial_economy:textures/screens/mamguienergy.png"));
			this.blit(ms, this.leftPos + 91, this.topPos + 38, 0, 0, 16, 16, 16, 16);
		}

		RenderSystem.setShaderTexture(0, new ResourceLocation("industrial_economy:textures/screens/industrial.png"));
		this.blit(ms, this.leftPos + 50, this.topPos + 16, 0, 0, 16, 16, 16, 16);

		RenderSystem.setShaderTexture(0, new ResourceLocation("industrial_economy:textures/screens/coal_block_gui.png"));
		this.blit(ms, this.leftPos + 14, this.topPos + 16, 0, 0, 16, 16, 16, 16);

		RenderSystem.setShaderTexture(0, new ResourceLocation("industrial_economy:textures/screens/gold_ingot.png"));
		this.blit(ms, this.leftPos + 51, this.topPos + 37, 0, 0, 16, 16, 16, 16);

		RenderSystem.setShaderTexture(0, new ResourceLocation("industrial_economy:textures/screens/caterium_block.png"));
		this.blit(ms, this.leftPos + 14, this.topPos + 37, 0, 0, 16, 16, 16, 16);

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
		this.font.draw(poseStack, "Presser MK1", 37, 4, -13421773);
		if (GeneratorWorkingLabelProcedure.execute(world, x, y, z))
			this.font.draw(poseStack, "Working", 106, 41, -16738048);
		this.font.draw(poseStack, "" + (new Object() {
			public String getValue(BlockPos pos, String tag) {
				BlockEntity BlockEntity = world.getBlockEntity(pos);
				if (BlockEntity != null)
					return BlockEntity.getPersistentData().getString(tag);
				return "";
			}
		}.getValue(new BlockPos((int) x, (int) y, (int) z), "RecipePower")) + "", 108, 4, -16763956);
		this.font.draw(poseStack, "=", 34, 19, -12829636);
		this.font.draw(poseStack, "2", 6, 19, -12829636);
		this.font.draw(poseStack, "1", 45, 19, -12829636);
		this.font.draw(poseStack, "2", 6, 40, -12829636);
		this.font.draw(poseStack, "1", 45, 40, -12829636);
		this.font.draw(poseStack, "=", 34, 40, -12829636);
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
	}
}
