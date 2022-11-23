
package industrialeconomy.block;

import net.minecraft.world.level.material.MaterialColor;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import industrialeconomy.procedures.LiquidHydrogenMobplayerCollidesBlockProcedure;
import industrialeconomy.procedures.LiquidHydrogenClientDisplayRandomTickProcedure;

import industrialeconomy.init.IndustrialEconomyModFluids;

public class LiquidHydrogenBlock extends LiquidBlock {
	public LiquidHydrogenBlock() {
		super(() -> IndustrialEconomyModFluids.LIQUID_HYDROGEN.get(),
				BlockBehaviour.Properties.of(Material.WATER, MaterialColor.ICE).strength(100f).noCollission().noLootTable());
	}

	@Override
	public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
		return 1;
	}

	@Override
	public boolean propagatesSkylightDown(BlockState state, BlockGetter reader, BlockPos pos) {
		return true;
	}

	@Override
	public void entityInside(BlockState blockstate, Level world, BlockPos pos, Entity entity) {
		super.entityInside(blockstate, world, pos, entity);
		LiquidHydrogenMobplayerCollidesBlockProcedure.execute(entity);
	}

	@Override
	public void animateTick(BlockState blockstate, Level world, BlockPos pos, RandomSource random) {
		super.animateTick(blockstate, world, pos, random);
		LiquidHydrogenClientDisplayRandomTickProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ());
	}
}
