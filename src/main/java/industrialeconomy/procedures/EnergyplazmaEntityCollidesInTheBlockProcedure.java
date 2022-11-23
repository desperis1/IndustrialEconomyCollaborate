package industrialeconomy.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.loading.FMLPaths;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import java.io.IOException;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

import industrialeconomy.network.IndustrialEconomyModVariables;

import com.google.gson.GsonBuilder;
import com.google.gson.Gson;

public class EnergyplazmaEntityCollidesInTheBlockProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
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
				if (mainObject.get("Energy")
						.getAsDouble() > 100 == (entity.getCapability(IndustrialEconomyModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new IndustrialEconomyModVariables.PlayerVariables())).DSA_energy < 15000) {
					{
						double _setval = (entity.getCapability(IndustrialEconomyModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new IndustrialEconomyModVariables.PlayerVariables())).DSA_energy + 1;
						entity.getCapability(IndustrialEconomyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.DSA_energy = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					mainObject.addProperty("name", (mainObject.get("Energy").getAsDouble() - 50));
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, new BlockPos(x, y, z),
									ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("industrial_economy:plazma")), SoundSource.NEUTRAL,
									(float) 0.01, (float) 0.01);
						} else {
							_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("industrial_economy:plazma")),
									SoundSource.NEUTRAL, (float) 0.01, (float) 0.01, false);
						}
					}
					world.addParticle(ParticleTypes.ENCHANTED_HIT, (x + 0.5), y, (z + 0.5), 0, 0.5, 0);
					world.addParticle(ParticleTypes.ENCHANTED_HIT, (x + 0.5), y, (z + 0.5), 0.7, 0.5, 0);
					world.addParticle(ParticleTypes.ENCHANTED_HIT, (x + 0.5), y, (z + 0.5), (-0.7), 0.5, 0);
					world.addParticle(ParticleTypes.ENCHANTED_HIT, (x + 0.5), y, (z + 0.5), 0, 0.5, (-0.7));
					world.addParticle(ParticleTypes.ENCHANTED_HIT, (x + 0.5), y, (z + 0.5), 0, 0.5, 0.7);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		{
			Gson mainGSONBuilderVariable = new GsonBuilder().setPrettyPrinting().create();
			try {
				FileWriter fileWriter = new FileWriter(playerConfig);
				fileWriter.write(mainGSONBuilderVariable.toJson(mainObject));
				fileWriter.close();
			} catch (IOException exception) {
				exception.printStackTrace();
			}
		}
	}
}
