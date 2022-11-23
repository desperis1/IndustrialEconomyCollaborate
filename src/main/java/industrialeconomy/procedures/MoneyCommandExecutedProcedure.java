package industrialeconomy.procedures;

import org.checkerframework.checker.units.qual.s;

import net.minecraftforge.fml.loading.FMLPaths;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;

import java.io.IOException;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

import com.google.gson.GsonBuilder;
import com.google.gson.Gson;

public class MoneyCommandExecutedProcedure {
	public static void execute(LevelAccessor world, Entity entity, HashMap cmdparams) {
		if (entity == null || cmdparams == null)
			return;
		com.google.gson.JsonObject mainObject = new com.google.gson.JsonObject();
		File playerConfig = new File("");
		double amount = 0;
		double wanttosend = 0;
		playerConfig = new File((FMLPaths.GAMEDIR.get().toString() + "/config/"), File.separator + (entity.getDisplayName().getString() + ".json"));
		if ((cmdparams.containsKey("0") ? cmdparams.get("0").toString() : "").equals("")) {
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
					if (entity instanceof Player _player && !_player.level.isClientSide())
						_player.displayClientMessage(
								Component.literal(
										("You have: " + new java.text.DecimalFormat("#").format(mainObject.get("Money").getAsDouble()) + " coins.")),
								(false));
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} else if ((cmdparams.containsKey("0") ? cmdparams.get("0").toString() : "").equals("add") && entity.hasPermissions(2)) {
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
					mainObject.addProperty("Money", (mainObject.get("Money").getAsDouble() + new Object() {
						double convert(String s) {
							try {
								return Double.parseDouble(s.trim());
							} catch (Exception e) {
							}
							return 0;
						}
					}.convert(cmdparams.containsKey("1") ? cmdparams.get("1").toString() : "")));
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
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (entity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(
						Component.literal(((cmdparams.containsKey("1") ? cmdparams.get("1").toString() : "") + " coins " + "sucessfully added.")),
						(false));
		} else if ((cmdparams.containsKey("0") ? cmdparams.get("0").toString() : "").equals("pay")) {
			if ((cmdparams.containsKey("1") ? cmdparams.get("1").toString() : "").equals("")) {
				if (entity instanceof Player _player && !_player.level.isClientSide())
					_player.displayClientMessage(Component.literal(("Example usage: " + "/money pay playername amount")), (false));
			}
			if (!(cmdparams.containsKey("2") ? cmdparams.get("2").toString() : "").equals("")
					&& !(cmdparams.containsKey("1") ? cmdparams.get("1").toString() : "").equals("")) {
				amount = Math.abs(new Object() {
					double convert(String s) {
						try {
							return Double.parseDouble(s.trim());
						} catch (Exception e) {
						}
						return 0;
					}
				}.convert(cmdparams.containsKey("2") ? cmdparams.get("2").toString() : ""));
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
						wanttosend = mainObject.get("Money").getAsDouble();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				if (wanttosend >= amount) {
					{
						List<? extends Player> _players = new ArrayList<>(world.players());
						for (Entity entityiterator : _players) {
							if ((cmdparams.containsKey("1") ? cmdparams.get("1").toString() : "")
									.equals(entityiterator.getDisplayName().getString())) {
								playerConfig = new File((FMLPaths.GAMEDIR.get().toString() + "/config/"),
										File.separator + (entityiterator.getDisplayName().getString() + ".json"));
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
										mainObject.addProperty("Money", (mainObject.get("Money").getAsDouble() + amount));
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
								playerConfig = new File((FMLPaths.GAMEDIR.get().toString() + "/config/"),
										File.separator + (entity.getDisplayName().getString() + ".json"));
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
										mainObject.addProperty("Money", (mainObject.get("Money").getAsDouble() - amount));
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
								if (entityiterator instanceof Player _player && !_player.level.isClientSide())
									_player.displayClientMessage(
											Component.literal(("You receive " + amount + " coins from " + entity.getDisplayName().getString())),
											(false));
								if (entity instanceof Player _player && !_player.level.isClientSide())
									_player.displayClientMessage(
											Component.literal(("You send " + amount + " coins to " + entityiterator.getDisplayName().getString())),
											(false));
							}
						}
					}
				} else {
					if (entity instanceof Player _player && !_player.level.isClientSide())
						_player.displayClientMessage(Component.literal("You dont have enough money!"), (false));
				}
			}
		}
	}
}
