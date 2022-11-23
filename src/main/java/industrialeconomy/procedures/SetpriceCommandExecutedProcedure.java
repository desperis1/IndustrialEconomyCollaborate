package industrialeconomy.procedures;

import org.checkerframework.checker.units.qual.s;

import net.minecraftforge.fml.loading.FMLPaths;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import java.util.HashMap;

import java.io.IOException;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

import com.google.gson.GsonBuilder;
import com.google.gson.Gson;

public class SetpriceCommandExecutedProcedure {
	public static void execute(Entity entity, HashMap cmdparams) {
		if (entity == null || cmdparams == null)
			return;
		double price = 0;
		ItemStack item_in_hand = ItemStack.EMPTY;
		com.google.gson.JsonObject mainObject = new com.google.gson.JsonObject();
		String owner = "";
		File playerConfig = new File("");
		if ((cmdparams.containsKey("0") ? cmdparams.get("0").toString() : "").equals("")) {
			if (entity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(Component.literal(("You can set price to item in hand." + "Example: /setprice 500")), (false));
		}
		playerConfig = new File((FMLPaths.GAMEDIR.get().toString() + "/config/"), File.separator + "prices.json");
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
				if (!(cmdparams.containsKey("0") ? cmdparams.get("0").toString() : "").equals("") && !((ItemStack.EMPTY)
						.getItem() == (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem())) {
					item_in_hand = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
					price = new Object() {
						double convert(String s) {
							try {
								return Double.parseDouble(s.trim());
							} catch (Exception e) {
							}
							return 0;
						}
					}.convert(cmdparams.containsKey("0") ? cmdparams.get("0").toString() : "");
					mainObject.addProperty((item_in_hand.getDisplayName().getString()), new Object() {
						double convert(String s) {
							try {
								return Double.parseDouble(s.trim());
							} catch (Exception e) {
							}
							return 0;
						}
					}.convert(cmdparams.containsKey("0") ? cmdparams.get("0").toString() : ""));
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
					if (entity instanceof Player _player && !_player.level.isClientSide())
						_player.displayClientMessage(
								Component.literal(("You set price for " + item_in_hand.getDisplayName().getString() + " to :" + new Object() {
									double convert(String s) {
										try {
											return Double.parseDouble(s.trim());
										} catch (Exception e) {
										}
										return 0;
									}
								}.convert(cmdparams.containsKey("0") ? cmdparams.get("0").toString() : "") + " coins ")), (false));
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
