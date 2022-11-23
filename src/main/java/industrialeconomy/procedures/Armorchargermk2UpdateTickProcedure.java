package industrialeconomy.procedures;

import net.minecraftforge.fml.loading.FMLPaths;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.core.BlockPos;

import java.io.IOException;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

import industrialeconomy.init.IndustrialEconomyModBlocks;

import com.google.gson.Gson;

public class Armorchargermk2UpdateTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		String owner = "";
		double players_hub_x = 0;
		double players_hub_y = 0;
		double players_hub_z = 0;
		com.google.gson.JsonObject mainObject = new com.google.gson.JsonObject();
		File playerConfig = new File("");
		owner = new Object() {
			public String getValue(LevelAccessor world, BlockPos pos, String tag) {
				BlockEntity blockEntity = world.getBlockEntity(pos);
				if (blockEntity != null)
					return blockEntity.getPersistentData().getString(tag);
				return "";
			}
		}.getValue(world, new BlockPos(x, y, z), "owner");
		playerConfig = new File((FMLPaths.GAMEDIR.get().toString() + "/config/"), File.separator + (owner + ".json"));
		{
			try {
				BufferedReader bufferedReader = new BufferedReader(new FileReader(playerConfig));
				StringBuilder jsonstringbuilder = new StringBuilder();
				String line;
				while ((line = bufferedReader.readLine()) != null) {
					jsonstringbuilder.append(line);
				}
				bufferedReader.close();
				mainObject = new Gson().fromJson(jsonstringbuilder.toString(), com.google.gson.JsonObject.class);
				if (mainObject.get("Energy").getAsDouble() > 1000 && (world.getBlockState(new BlockPos(x, y + 1, z))).getBlock() == Blocks.AIR
						&& (world.getBlockState(new BlockPos(x, y + 2, z))).getBlock() == Blocks.AIR) {
					world.setBlock(new BlockPos(x, y + 1, z), IndustrialEconomyModBlocks.ENERGYPLAZMAMK_2.get().defaultBlockState(), 3);
					if (!world.isClientSide()) {
						BlockPos _bp = new BlockPos(x, y + 1, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null)
							_blockEntity.getPersistentData().putString("owner", (new Object() {
								public String getValue(LevelAccessor world, BlockPos pos, String tag) {
									BlockEntity blockEntity = world.getBlockEntity(pos);
									if (blockEntity != null)
										return blockEntity.getPersistentData().getString(tag);
									return "";
								}
							}.getValue(world, new BlockPos(x, y, z), "owner")));
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
					world.setBlock(new BlockPos(x, y + 2, z), IndustrialEconomyModBlocks.ENERGYPLAZMAMK_2.get().defaultBlockState(), 3);
					if (!world.isClientSide()) {
						BlockPos _bp = new BlockPos(x, y + 2, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null)
							_blockEntity.getPersistentData().putString("owner", (new Object() {
								public String getValue(LevelAccessor world, BlockPos pos, String tag) {
									BlockEntity blockEntity = world.getBlockEntity(pos);
									if (blockEntity != null)
										return blockEntity.getPersistentData().getString(tag);
									return "";
								}
							}.getValue(world, new BlockPos(x, y, z), "owner")));
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
				} else if (mainObject.get("Energy").getAsDouble() <= 1000) {
					world.setBlock(new BlockPos(x, y + 1, z), Blocks.AIR.defaultBlockState(), 3);
					world.setBlock(new BlockPos(x, y + 2, z), Blocks.AIR.defaultBlockState(), 3);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
