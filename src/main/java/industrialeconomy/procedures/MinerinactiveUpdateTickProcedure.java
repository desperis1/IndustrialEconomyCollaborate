package industrialeconomy.procedures;

import net.minecraftforge.fml.loading.FMLPaths;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.BlockPos;

import java.util.Map;

import java.io.IOException;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

import industrialeconomy.init.IndustrialEconomyModBlocks;

import com.google.gson.Gson;

public class MinerinactiveUpdateTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		String owner = "";
		double players_hub_x = 0;
		double players_hub_y = 0;
		double players_hub_z = 0;
		double miners_level = 0;
		File playerConfig = new File("");
		com.google.gson.JsonObject mainObject = new com.google.gson.JsonObject();
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
				if (mainObject.get("Energy").getAsDouble() >= 15 * miners_level
						&& (IndustrialEconomyModBlocks.LIMESTONEACTIVE.get() == (world.getBlockState(new BlockPos(x, y - 1, z))).getBlock()
								|| IndustrialEconomyModBlocks.COAL_NODE.get() == (world.getBlockState(new BlockPos(x, y - 1, z))).getBlock()
								|| IndustrialEconomyModBlocks.IRON_ORE_NODE_BLOCK.get() == (world.getBlockState(new BlockPos(x, y - 1, z))).getBlock()
								|| IndustrialEconomyModBlocks.CATERIUM_NOD_EBLOCK.get() == (world.getBlockState(new BlockPos(x, y - 1, z))).getBlock()
								|| IndustrialEconomyModBlocks.COPPER_NODE.get() == (world.getBlockState(new BlockPos(x, y - 1, z))).getBlock())) {
					{
						BlockPos _bp = new BlockPos(x, y, z);
						BlockState _bs = IndustrialEconomyModBlocks.MINERBLOCK.get().defaultBlockState();
						BlockState _bso = world.getBlockState(_bp);
						for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
							Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
							if (_property != null && _bs.getValue(_property) != null)
								try {
									_bs = _bs.setValue(_property, (Comparable) entry.getValue());
								} catch (Exception e) {
								}
						}
						BlockEntity _be = world.getBlockEntity(_bp);
						CompoundTag _bnbt = null;
						if (_be != null) {
							_bnbt = _be.saveWithFullMetadata();
							_be.setRemoved();
						}
						world.setBlock(_bp, _bs, 3);
						if (_bnbt != null) {
							_be = world.getBlockEntity(_bp);
							if (_be != null) {
								try {
									_be.load(_bnbt);
								} catch (Exception ignored) {
								}
							}
						}
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
