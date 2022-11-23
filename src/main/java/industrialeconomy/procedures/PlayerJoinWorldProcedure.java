package industrialeconomy.procedures;

import net.minecraftforge.fml.loading.FMLPaths;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.PlayerEvent;

import net.minecraft.world.entity.Entity;

import javax.annotation.Nullable;

import java.io.IOException;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

import com.google.gson.GsonBuilder;
import com.google.gson.Gson;

@Mod.EventBusSubscriber
public class PlayerJoinWorldProcedure {
	@SubscribeEvent
	public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
		execute(event, event.getEntity());
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		File playerConfig = new File("");
		com.google.gson.JsonObject mainObject = new com.google.gson.JsonObject();
		playerConfig = new File((FMLPaths.GAMEDIR.get().toString() + "/config/"), File.separator + (entity.getDisplayName().getString() + ".json"));
		if (!playerConfig.exists()) {
			try {
				playerConfig.getParentFile().mkdirs();
				playerConfig.createNewFile();
			} catch (IOException exception) {
				exception.printStackTrace();
			}
			mainObject.addProperty("MinerLevel", 1);
			mainObject.addProperty("Money", 1000);
			mainObject.addProperty("Energy", 0);
			mainObject.addProperty("Coal", 0);
			mainObject.addProperty("Iron", 0);
			mainObject.addProperty("minerLevels", 1);
			mainObject.addProperty("Copper", 0);
			mainObject.addProperty("Caterium", 0);
			mainObject.addProperty("SandStone", 0);
			mainObject.addProperty("Money", 0);
			mainObject.addProperty("EnergyForMinerUpgrade", 1000000000);
			mainObject.addProperty("Eup", 0);
			mainObject.addProperty("Edown", 0);
			mainObject.addProperty("mamSteel", (false));
			mainObject.addProperty("mamDiamondSteel", (false));
			mainObject.addProperty("mam2CoreCPU", (false));
			mainObject.addProperty("mam4CoreCPU", (false));
			mainObject.addProperty("mam8CoreCPU", (false));
			mainObject.addProperty("mam16CoreCPU", (false));
			mainObject.addProperty("mam32CoreCPU", (false));
			mainObject.addProperty("mam64CoreCPU", (false));
			mainObject.addProperty("mam128CoreCPU", (false));
			mainObject.addProperty("mam256CoreCPU", (false));
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
				mainObject.addProperty("isOnline", (true));
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
