package industrialeconomy.procedures;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.BlockPos;

import java.util.Map;

import industrialeconomy.init.IndustrialEconomyModBlocks;

public class LimestoneactiveUpdateTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (!((world.getBlockState(new BlockPos(x + 1, y, z))).getBlock() == Blocks.SANDSTONE
				&& (world.getBlockState(new BlockPos(x - 1, y, z))).getBlock() == Blocks.SANDSTONE
				&& (world.getBlockState(new BlockPos(x, y, z - 1))).getBlock() == Blocks.SANDSTONE
				&& (world.getBlockState(new BlockPos(x, y, z + 1))).getBlock() == Blocks.SANDSTONE)) {
			{
				BlockPos _bp = new BlockPos(x, y, z);
				BlockState _bs = IndustrialEconomyModBlocks.LIMESTONEINACTIVE.get().defaultBlockState();
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
	}
}
