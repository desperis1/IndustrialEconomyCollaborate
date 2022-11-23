package industrialeconomy.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.server.level.ServerLevel;

public class AdminmenuDayNightProcedure {
	public static void execute(LevelAccessor world) {
		if (12000 < world.dayTime()) {
			if (world instanceof ServerLevel _level)
				_level.setDayTime(0);
		} else if (12000 > world.dayTime()) {
			if (world instanceof ServerLevel _level)
				_level.setDayTime(18000);
		}
	}
}
