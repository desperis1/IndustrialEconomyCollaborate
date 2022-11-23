package industrialeconomy.procedures;

import org.checkerframework.checker.units.qual.s;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import industrialeconomy.network.IndustrialEconomyModVariables;

import industrialeconomy.init.IndustrialEconomyModEnchantments;

public class BuildertoolRightClickedInAirProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double result = 0;
		double a = 0;
		double b = 0;
		double c = 0;
		a = new Object() {
			double convert(String s) {
				try {
					return Double.parseDouble(s.trim());
				} catch (Exception e) {
				}
				return 0;
			}
		}.convert(new java.text.DecimalFormat("##").format(Math.abs(Math
				.abs((entity.getCapability(IndustrialEconomyModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new IndustrialEconomyModVariables.PlayerVariables())).builder_pos1_x)
				- Math.abs((entity.getCapability(IndustrialEconomyModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new IndustrialEconomyModVariables.PlayerVariables())).builder_pos2_x))));
		b = new Object() {
			double convert(String s) {
				try {
					return Double.parseDouble(s.trim());
				} catch (Exception e) {
				}
				return 0;
			}
		}.convert(new java.text.DecimalFormat("##").format(Math.abs(Math
				.abs((entity.getCapability(IndustrialEconomyModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new IndustrialEconomyModVariables.PlayerVariables())).builder_pos1_y)
				- Math.abs((entity.getCapability(IndustrialEconomyModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new IndustrialEconomyModVariables.PlayerVariables())).builder_pos2_y))));
		c = new Object() {
			double convert(String s) {
				try {
					return Double.parseDouble(s.trim());
				} catch (Exception e) {
				}
				return 0;
			}
		}.convert(new java.text.DecimalFormat("##").format(Math.abs(Math
				.abs((entity.getCapability(IndustrialEconomyModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new IndustrialEconomyModVariables.PlayerVariables())).builder_pos1_z)
				- Math.abs((entity.getCapability(IndustrialEconomyModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new IndustrialEconomyModVariables.PlayerVariables())).builder_pos2_z))));
		if (Math.round(a) == 0) {
			a = 1;
		}
		if (Math.round(b) == 0) {
			b = 1;
		}
		if (Math.round(c) == 0) {
			c = 1;
		}
		result = a * b * c;
		if (EnchantmentHelper.getItemEnchantmentLevel(IndustrialEconomyModEnchantments.BUILDRANGE.get(),
				(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)) == 0 && result <= 64) {
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands()
						.performPrefixedCommand(
								new CommandSourceStack(
										CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level
												.getServer(),
										null).withSuppressedOutput(),
								("fill " + new java.text.DecimalFormat("##")
										.format((entity.getCapability(IndustrialEconomyModVariables.PLAYER_VARIABLES_CAPABILITY, null)
												.orElse(new IndustrialEconomyModVariables.PlayerVariables())).builder_pos1_x)
										+ " "
										+ new java.text.DecimalFormat("##")
												.format((entity.getCapability(IndustrialEconomyModVariables.PLAYER_VARIABLES_CAPABILITY, null)
														.orElse(new IndustrialEconomyModVariables.PlayerVariables())).builder_pos1_y)
										+ " "
										+ new java.text.DecimalFormat("##")
												.format((entity.getCapability(IndustrialEconomyModVariables.PLAYER_VARIABLES_CAPABILITY, null)
														.orElse(new IndustrialEconomyModVariables.PlayerVariables())).builder_pos1_z)
										+ " "
										+ new java.text.DecimalFormat("##")
												.format((entity.getCapability(IndustrialEconomyModVariables.PLAYER_VARIABLES_CAPABILITY, null)
														.orElse(new IndustrialEconomyModVariables.PlayerVariables())).builder_pos2_x)
										+ " "
										+ new java.text.DecimalFormat("##")
												.format((entity.getCapability(IndustrialEconomyModVariables.PLAYER_VARIABLES_CAPABILITY, null)
														.orElse(new IndustrialEconomyModVariables.PlayerVariables())).builder_pos2_y)
										+ " "
										+ new java.text.DecimalFormat("##")
												.format((entity.getCapability(IndustrialEconomyModVariables.PLAYER_VARIABLES_CAPABILITY, null)
														.orElse(new IndustrialEconomyModVariables.PlayerVariables())).builder_pos2_z)
										+ " " + "industrial_economy:builder_previewblock" + " replace air"));
			if (entity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(Component.literal("Preview Activated! You can Clear it in build gun menu."), (false));
		}
		if (EnchantmentHelper.getItemEnchantmentLevel(IndustrialEconomyModEnchantments.BUILDRANGE.get(),
				(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)) == 1 && result <= 90) {
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands()
						.performPrefixedCommand(
								new CommandSourceStack(
										CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level
												.getServer(),
										null).withSuppressedOutput(),
								("fill " + new java.text.DecimalFormat("##")
										.format((entity.getCapability(IndustrialEconomyModVariables.PLAYER_VARIABLES_CAPABILITY, null)
												.orElse(new IndustrialEconomyModVariables.PlayerVariables())).builder_pos1_x)
										+ " "
										+ new java.text.DecimalFormat("##")
												.format((entity.getCapability(IndustrialEconomyModVariables.PLAYER_VARIABLES_CAPABILITY, null)
														.orElse(new IndustrialEconomyModVariables.PlayerVariables())).builder_pos1_y)
										+ " "
										+ new java.text.DecimalFormat("##")
												.format((entity.getCapability(IndustrialEconomyModVariables.PLAYER_VARIABLES_CAPABILITY, null)
														.orElse(new IndustrialEconomyModVariables.PlayerVariables())).builder_pos1_z)
										+ " "
										+ new java.text.DecimalFormat("##")
												.format((entity.getCapability(IndustrialEconomyModVariables.PLAYER_VARIABLES_CAPABILITY, null)
														.orElse(new IndustrialEconomyModVariables.PlayerVariables())).builder_pos2_x)
										+ " "
										+ new java.text.DecimalFormat("##")
												.format((entity.getCapability(IndustrialEconomyModVariables.PLAYER_VARIABLES_CAPABILITY, null)
														.orElse(new IndustrialEconomyModVariables.PlayerVariables())).builder_pos2_y)
										+ " "
										+ new java.text.DecimalFormat("##")
												.format((entity.getCapability(IndustrialEconomyModVariables.PLAYER_VARIABLES_CAPABILITY, null)
														.orElse(new IndustrialEconomyModVariables.PlayerVariables())).builder_pos2_z)
										+ " " + "industrial_economy:builder_previewblock" + " replace air"));
			if (entity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(Component.literal("Preview Activated! You can Clear it in build gun menu."), (false));
		}
		if (EnchantmentHelper.getItemEnchantmentLevel(IndustrialEconomyModEnchantments.BUILDRANGE.get(),
				(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)) == 2 && result <= 128) {
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands()
						.performPrefixedCommand(
								new CommandSourceStack(
										CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level
												.getServer(),
										null).withSuppressedOutput(),
								("fill " + new java.text.DecimalFormat("##")
										.format((entity.getCapability(IndustrialEconomyModVariables.PLAYER_VARIABLES_CAPABILITY, null)
												.orElse(new IndustrialEconomyModVariables.PlayerVariables())).builder_pos1_x)
										+ " "
										+ new java.text.DecimalFormat("##")
												.format((entity.getCapability(IndustrialEconomyModVariables.PLAYER_VARIABLES_CAPABILITY, null)
														.orElse(new IndustrialEconomyModVariables.PlayerVariables())).builder_pos1_y)
										+ " "
										+ new java.text.DecimalFormat("##")
												.format((entity.getCapability(IndustrialEconomyModVariables.PLAYER_VARIABLES_CAPABILITY, null)
														.orElse(new IndustrialEconomyModVariables.PlayerVariables())).builder_pos1_z)
										+ " "
										+ new java.text.DecimalFormat("##")
												.format((entity.getCapability(IndustrialEconomyModVariables.PLAYER_VARIABLES_CAPABILITY, null)
														.orElse(new IndustrialEconomyModVariables.PlayerVariables())).builder_pos2_x)
										+ " "
										+ new java.text.DecimalFormat("##")
												.format((entity.getCapability(IndustrialEconomyModVariables.PLAYER_VARIABLES_CAPABILITY, null)
														.orElse(new IndustrialEconomyModVariables.PlayerVariables())).builder_pos2_y)
										+ " "
										+ new java.text.DecimalFormat("##")
												.format((entity.getCapability(IndustrialEconomyModVariables.PLAYER_VARIABLES_CAPABILITY, null)
														.orElse(new IndustrialEconomyModVariables.PlayerVariables())).builder_pos2_z)
										+ " " + "industrial_economy:builder_previewblock" + " replace air"));
			if (entity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(Component.literal("Preview Activated! You can Clear it in build gun menu."), (false));
		}
		if (result > 129) {
			if (entity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(Component.literal("Cant Show Preview. Too many blocks selected."), (false));
		}
	}
}
