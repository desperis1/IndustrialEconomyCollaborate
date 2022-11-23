
package industrialeconomy.potion;

import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class OxygenEffectMobEffect extends MobEffect {
	public OxygenEffectMobEffect() {
		super(MobEffectCategory.NEUTRAL, -3342337);
	}

	@Override
	public String getDescriptionId() {
		return "effect.industrial_economy.oxygen_effect";
	}

	@Override
	public boolean isInstantenous() {
		return true;
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
