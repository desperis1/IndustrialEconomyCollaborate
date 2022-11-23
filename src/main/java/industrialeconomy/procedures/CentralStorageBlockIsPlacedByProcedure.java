package industrialeconomy.procedures;

import net.minecraftforge.fml.loading.FMLPaths;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;

import java.io.IOException;
import java.io.FileWriter;
import java.io.File;

import industrialeconomy.init.IndustrialEconomyModItems;
import industrialeconomy.init.IndustrialEconomyModBlocks;

import com.google.gson.GsonBuilder;
import com.google.gson.Gson;

public class CentralStorageBlockIsPlacedByProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		String owner = "";
		File playerStorageConfig = new File("");
		com.google.gson.JsonObject mainObject = new com.google.gson.JsonObject();
		if (!world.isClientSide()) {
			BlockPos _bp = new BlockPos(x, y, z);
			BlockEntity _blockEntity = world.getBlockEntity(_bp);
			BlockState _bs = world.getBlockState(_bp);
			if (_blockEntity != null)
				_blockEntity.getPersistentData().putString("owner", (entity.getDisplayName().getString()));
			if (world instanceof Level _level)
				_level.sendBlockUpdated(_bp, _bs, _bs, 3);
		}
		playerStorageConfig = new File((FMLPaths.GAMEDIR.get().toString() + "/config/"),
				File.separator + (entity.getDisplayName().getString() + "_storage.json"));
		if (!playerStorageConfig.exists()) {
			mainObject.addProperty("placed", (true));
			mainObject.addProperty((new ItemStack(IndustrialEconomyModItems.CATERIUM_INGOT.get()).getDisplayName().getString()), 1);
			mainObject.addProperty((new ItemStack(IndustrialEconomyModItems.COPPER_INGOT.get()).getDisplayName().getString()), 1);
			mainObject.addProperty((new ItemStack(IndustrialEconomyModBlocks.COPPER_BLOCK.get()).getDisplayName().getString()), 1);
			mainObject.addProperty((new ItemStack(IndustrialEconomyModItems.REDSTONEINGOTITEM.get()).getDisplayName().getString()), 1);
			mainObject.addProperty((new ItemStack(IndustrialEconomyModItems.COPPER_SHEET_ITEM.get()).getDisplayName().getString()), 1);
			mainObject.addProperty((new ItemStack(IndustrialEconomyModItems.TURBOFUELITEM_3.get()).getDisplayName().getString()), 1);
			mainObject.addProperty((new ItemStack(IndustrialEconomyModItems.TURBOFUELITEM.get()).getDisplayName().getString()), 1);
			mainObject.addProperty((new ItemStack(IndustrialEconomyModItems.TURBOFUELITEM_2.get()).getDisplayName().getString()), 1);
			mainObject.addProperty((new ItemStack(IndustrialEconomyModBlocks.GENERATOR_MK_1.get()).getDisplayName().getString()), 1);
			mainObject.addProperty((new ItemStack(IndustrialEconomyModBlocks.CONSTRUCTORBLOCK.get()).getDisplayName().getString()), 1);
			mainObject.addProperty((new ItemStack(IndustrialEconomyModItems.CIRCUIT_BOARDITEM.get()).getDisplayName().getString()), 1);
			mainObject.addProperty((new ItemStack(IndustrialEconomyModItems.DIAMONDSTEELITEM.get()).getDisplayName().getString()), 1);
			mainObject.addProperty((new ItemStack(IndustrialEconomyModBlocks.DIAMOND_STEELBLOCK.get()).getDisplayName().getString()), 1);
			mainObject.addProperty((new ItemStack(IndustrialEconomyModItems.STEELINGOT.get()).getDisplayName().getString()), 1);
			mainObject.addProperty((new ItemStack(IndustrialEconomyModBlocks.STEEL_BLOCK.get()).getDisplayName().getString()), 1);
			mainObject.addProperty((new ItemStack(IndustrialEconomyModBlocks.PRESSERBLOCK.get()).getDisplayName().getString()), 1);
			mainObject.addProperty((new ItemStack(IndustrialEconomyModBlocks.FOUNDYBLOCK.get()).getDisplayName().getString()), 1);
			mainObject.addProperty((new ItemStack(IndustrialEconomyModBlocks.GENERATORMK_2.get()).getDisplayName().getString()), 1);
			mainObject.addProperty((new ItemStack(IndustrialEconomyModItems.HIGHSPEEDCONECTORITEM.get()).getDisplayName().getString()), 1);
			mainObject.addProperty((new ItemStack(IndustrialEconomyModBlocks.ELECTRIC_FUNANCEINACTIVE.get()).getDisplayName().getString()), 1);
			mainObject.addProperty((new ItemStack(IndustrialEconomyModItems.AI_LIMITERITEM.get()).getDisplayName().getString()), 1);
			mainObject.addProperty((new ItemStack(IndustrialEconomyModBlocks.IRONEXTRACTOR.get()).getDisplayName().getString()), 1);
			mainObject.addProperty((new ItemStack(IndustrialEconomyModBlocks.COAL_EXTRACTOR.get()).getDisplayName().getString()), 1);
			mainObject.addProperty((new ItemStack(IndustrialEconomyModBlocks.CATERIUM_EXTRACTOR.get()).getDisplayName().getString()), 1);
			mainObject.addProperty((new ItemStack(IndustrialEconomyModBlocks.COPPER_EXTRACTOR.get()).getDisplayName().getString()), 1);
			mainObject.addProperty((new ItemStack(IndustrialEconomyModItems.SCREW.get()).getDisplayName().getString()), 1);
			mainObject.addProperty((new ItemStack(IndustrialEconomyModItems.IRONPLATE.get()).getDisplayName().getString()), 1);
			mainObject.addProperty((new ItemStack(IndustrialEconomyModBlocks.HARDENEDCOBBLE.get()).getDisplayName().getString()), 1);
			mainObject.addProperty((new ItemStack(IndustrialEconomyModItems.DIAMONDSTEELPLATE.get()).getDisplayName().getString()), 1);
			mainObject.addProperty((new ItemStack(IndustrialEconomyModBlocks.HEAVYIRONBLOCK.get()).getDisplayName().getString()), 1);
			mainObject.addProperty((new ItemStack(IndustrialEconomyModItems.DIAMONDSCREWITEM.get()).getDisplayName().getString()), 1);
			mainObject.addProperty((new ItemStack(IndustrialEconomyModItems.CATERIUMRODITEM.get()).getDisplayName().getString()), 1);
			mainObject.addProperty((new ItemStack(IndustrialEconomyModBlocks.SOLARPANELBLOCKINACTIVE.get()).getDisplayName().getString()), 1);
			mainObject.addProperty((new ItemStack(IndustrialEconomyModItems.CATERIUMWIREITEM.get()).getDisplayName().getString()), 1);
			mainObject.addProperty((new ItemStack(IndustrialEconomyModBlocks.HEAVYFRAME.get()).getDisplayName().getString()), 1);
			mainObject.addProperty((new ItemStack(IndustrialEconomyModBlocks.MODULARFRAME.get()).getDisplayName().getString()), 1);
			mainObject.addProperty((new ItemStack(IndustrialEconomyModBlocks.ASSEMBLERBLOCK.get()).getDisplayName().getString()), 1);
			mainObject.addProperty((new ItemStack(IndustrialEconomyModItems.CPU.get()).getDisplayName().getString()), 1);
			mainObject.addProperty((new ItemStack(IndustrialEconomyModItems.CONCRETE.get()).getDisplayName().getString()), 1);
			mainObject.addProperty((new ItemStack(IndustrialEconomyModBlocks.SANDSTONEEXTRACTOR.get()).getDisplayName().getString()), 1);
			mainObject.addProperty((new ItemStack(IndustrialEconomyModItems.CONTROL_UNIT.get()).getDisplayName().getString()), 1);
			mainObject.addProperty((new ItemStack(IndustrialEconomyModItems.EMPTYMODULE.get()).getDisplayName().getString()), 1);
			mainObject.addProperty((new ItemStack(IndustrialEconomyModItems.INDUSTRIAL_DIAMOND.get()).getDisplayName().getString()), 1);
			mainObject.addProperty((new ItemStack(IndustrialEconomyModBlocks.CATERIUM_BLOCK.get()).getDisplayName().getString()), 1);
			{
				Gson mainGSONBuilderVariable = new GsonBuilder().setPrettyPrinting().create();
				try {
					FileWriter fileWriter = new FileWriter(playerStorageConfig);
					fileWriter.write(mainGSONBuilderVariable.toJson(mainObject));
					fileWriter.close();
				} catch (IOException exception) {
					exception.printStackTrace();
				}
			}
		}
		if (entity instanceof Player _player && !_player.level.isClientSide())
			_player.displayClientMessage(Component.literal("Storage Sucessfuly loaded."), (false));
	}
}
