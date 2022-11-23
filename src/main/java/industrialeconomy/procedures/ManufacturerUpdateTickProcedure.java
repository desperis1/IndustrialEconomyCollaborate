package industrialeconomy.procedures;

import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.fml.loading.FMLPaths;
import net.minecraftforge.common.capabilities.ForgeCapabilities;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.BlockPos;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicInteger;

import java.io.IOException;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

import industrialeconomy.init.IndustrialEconomyModItems;
import industrialeconomy.init.IndustrialEconomyModBlocks;

import com.google.gson.GsonBuilder;
import com.google.gson.Gson;

public class ManufacturerUpdateTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		com.google.gson.JsonObject mainObject = new com.google.gson.JsonObject();
		String owner = "";
		File playerStorageConfig = new File("");
		File playerConfig = new File("");
		double Energy = 0;
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
				Energy = mainObject.get("Energy").getAsDouble();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if (Energy > 2500 && (new Object() {
			public String getValue(LevelAccessor world, BlockPos pos, String tag) {
				BlockEntity blockEntity = world.getBlockEntity(pos);
				if (blockEntity != null)
					return blockEntity.getPersistentData().getString(tag);
				return "";
			}
		}.getValue(world, new BlockPos(x, y, z), "Recipe")).equals("HighSpeedConnector")) {
			playerStorageConfig = new File((FMLPaths.GAMEDIR.get().toString() + "/config/"), File.separator + (owner + "_storage.json"));
			{
				try {
					BufferedReader bufferedReader = new BufferedReader(new FileReader(playerStorageConfig));
					StringBuilder jsonstringbuilder = new StringBuilder();
					String line;
					while ((line = bufferedReader.readLine()) != null) {
						jsonstringbuilder.append(line);
					}
					bufferedReader.close();
					mainObject = new Gson().fromJson(jsonstringbuilder.toString(), com.google.gson.JsonObject.class);
					if (mainObject.get((new ItemStack(IndustrialEconomyModItems.COPPER_SHEET_ITEM.get()).getDisplayName().getString()))
							.getAsDouble() > 2
							&& mainObject.get((new ItemStack(IndustrialEconomyModItems.CIRCUIT_BOARDITEM.get()).getDisplayName().getString()))
									.getAsDouble() > 3
							&& mainObject.get((new ItemStack(IndustrialEconomyModBlocks.CATERIUM_BLOCK.get()).getDisplayName().getString()))
									.getAsDouble() > 1
							&& mainObject.get((new ItemStack(IndustrialEconomyModItems.CATERIUMWIREITEM.get()).getDisplayName().getString()))
									.getAsDouble() > 1
							&& mainObject.get((new ItemStack(IndustrialEconomyModBlocks.STEEL_BLOCK.get()).getDisplayName().getString()))
									.getAsDouble() > 2
							&& (new Object() {
								public int getAmount(LevelAccessor world, BlockPos pos, int slotid) {
									AtomicInteger _retval = new AtomicInteger(0);
									BlockEntity _ent = world.getBlockEntity(pos);
									if (_ent != null)
										_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null)
												.ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).getCount()));
									return _retval.get();
								}
							}.getAmount(world, new BlockPos(x, y, z), 0) == 0 || new Object() {
								public int getAmount(LevelAccessor world, BlockPos pos, int slotid) {
									AtomicInteger _retval = new AtomicInteger(0);
									BlockEntity _ent = world.getBlockEntity(pos);
									if (_ent != null)
										_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null)
												.ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).getCount()));
									return _retval.get();
								}
							}.getAmount(world, new BlockPos(x, y, z), 0) < 64
									&& IndustrialEconomyModItems.HIGHSPEEDCONECTORITEM.get() == (new Object() {
										public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
											AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
											BlockEntity _ent = world.getBlockEntity(pos);
											if (_ent != null)
												_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null)
														.ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
											return _retval.get();
										}
									}.getItemStack(world, new BlockPos(x, y, z), 0)).getItem())) {
						if (!world.isClientSide()) {
							BlockPos _bp = new BlockPos(x, y, z);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null)
								_blockEntity.getPersistentData().putBoolean("Working", (true));
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
						mainObject.addProperty((new ItemStack(IndustrialEconomyModItems.COPPER_SHEET_ITEM.get()).getDisplayName().getString()),
								(mainObject.get((new ItemStack(IndustrialEconomyModItems.COPPER_SHEET_ITEM.get()).getDisplayName().getString()))
										.getAsDouble() - 2));
						mainObject.addProperty((new ItemStack(IndustrialEconomyModItems.CIRCUIT_BOARDITEM.get()).getDisplayName().getString()),
								(mainObject.get((new ItemStack(IndustrialEconomyModItems.CIRCUIT_BOARDITEM.get()).getDisplayName().getString()))
										.getAsDouble() - 3));
						mainObject.addProperty((new ItemStack(IndustrialEconomyModBlocks.CATERIUM_BLOCK.get()).getDisplayName().getString()),
								(mainObject.get((new ItemStack(IndustrialEconomyModBlocks.CATERIUM_BLOCK.get()).getDisplayName().getString()))
										.getAsDouble() - 1));
						mainObject.addProperty((new ItemStack(IndustrialEconomyModItems.CATERIUMWIREITEM.get()).getDisplayName().getString()),
								(mainObject.get((new ItemStack(IndustrialEconomyModItems.CATERIUMWIREITEM.get()).getDisplayName().getString()))
										.getAsDouble() - 1));
						mainObject.addProperty((new ItemStack(IndustrialEconomyModBlocks.STEEL_BLOCK.get()).getDisplayName().getString()), (mainObject
								.get((new ItemStack(IndustrialEconomyModBlocks.STEEL_BLOCK.get()).getDisplayName().getString())).getAsDouble() - 2));
						{
							Gson mainGSONBuilderVariable = new GsonBuilder().setPrettyPrinting().create();
							try {
								FileWriter fileWriter = new FileWriter(playerStorageConfig);
								fileWriter.write(mainGSONBuilderVariable.toJson(mainObject));
								fileWriter.close();
							} catch (IOException exception) {
								exception.printStackTrace();
							}
						}
						{
							BlockEntity _ent = world.getBlockEntity(new BlockPos(x, y, z));
							if (_ent != null) {
								final int _slotid = 0;
								final ItemStack _setstack = new ItemStack(IndustrialEconomyModItems.HIGHSPEEDCONECTORITEM.get());
								_setstack.setCount((int) (new Object() {
									public int getAmount(LevelAccessor world, BlockPos pos, int slotid) {
										AtomicInteger _retval = new AtomicInteger(0);
										BlockEntity _ent = world.getBlockEntity(pos);
										if (_ent != null)
											_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null)
													.ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).getCount()));
										return _retval.get();
									}
								}.getAmount(world, new BlockPos(x, y, z), 0) + 1));
								_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
									if (capability instanceof IItemHandlerModifiable)
										((IItemHandlerModifiable) capability).setStackInSlot(_slotid, _setstack);
								});
							}
						}
					} else {
						if (!world.isClientSide()) {
							BlockPos _bp = new BlockPos(x, y, z);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null)
								_blockEntity.getPersistentData().putBoolean("Working", (false));
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if ((new Object() {
				public boolean getValue(LevelAccessor world, BlockPos pos, String tag) {
					BlockEntity blockEntity = world.getBlockEntity(pos);
					if (blockEntity != null)
						return blockEntity.getPersistentData().getBoolean(tag);
					return false;
				}
			}.getValue(world, new BlockPos(x, y, z), "Working")) == true) {
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
						mainObject.addProperty("Energy", (mainObject.get("Energy").getAsDouble() - 2500));
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
		if (Energy > 2500 && (new Object() {
			public String getValue(LevelAccessor world, BlockPos pos, String tag) {
				BlockEntity blockEntity = world.getBlockEntity(pos);
				if (blockEntity != null)
					return blockEntity.getPersistentData().getString(tag);
				return "";
			}
		}.getValue(world, new BlockPos(x, y, z), "Recipe")).equals("DiamondSteelPlate")) {
			playerStorageConfig = new File((FMLPaths.GAMEDIR.get().toString() + "/config/"), File.separator + (owner + "_storage.json"));
			{
				try {
					BufferedReader bufferedReader = new BufferedReader(new FileReader(playerStorageConfig));
					StringBuilder jsonstringbuilder = new StringBuilder();
					String line;
					while ((line = bufferedReader.readLine()) != null) {
						jsonstringbuilder.append(line);
					}
					bufferedReader.close();
					mainObject = new Gson().fromJson(jsonstringbuilder.toString(), com.google.gson.JsonObject.class);
					if (mainObject.get((new ItemStack(IndustrialEconomyModItems.DIAMONDSCREWITEM.get()).getDisplayName().getString()))
							.getAsDouble() > 4
							&& mainObject.get((new ItemStack(IndustrialEconomyModItems.IRONPLATE.get()).getDisplayName().getString()))
									.getAsDouble() > 2
							&& mainObject.get((new ItemStack(IndustrialEconomyModBlocks.DIAMOND_STEELBLOCK.get()).getDisplayName().getString()))
									.getAsDouble() > 1
							&& mainObject.get((new ItemStack(IndustrialEconomyModBlocks.HEAVYIRONBLOCK.get()).getDisplayName().getString()))
									.getAsDouble() > 2
							&& (new Object() {
								public int getAmount(LevelAccessor world, BlockPos pos, int slotid) {
									AtomicInteger _retval = new AtomicInteger(0);
									BlockEntity _ent = world.getBlockEntity(pos);
									if (_ent != null)
										_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null)
												.ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).getCount()));
									return _retval.get();
								}
							}.getAmount(world, new BlockPos(x, y, z), 0) == 0 || new Object() {
								public int getAmount(LevelAccessor world, BlockPos pos, int slotid) {
									AtomicInteger _retval = new AtomicInteger(0);
									BlockEntity _ent = world.getBlockEntity(pos);
									if (_ent != null)
										_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null)
												.ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).getCount()));
									return _retval.get();
								}
							}.getAmount(world, new BlockPos(x, y, z), 0) < 64 && IndustrialEconomyModItems.DIAMONDSTEELPLATE.get() == (new Object() {
								public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
									AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
									BlockEntity _ent = world.getBlockEntity(pos);
									if (_ent != null)
										_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null)
												.ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
									return _retval.get();
								}
							}.getItemStack(world, new BlockPos(x, y, z), 0)).getItem())) {
						if (!world.isClientSide()) {
							BlockPos _bp = new BlockPos(x, y, z);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null)
								_blockEntity.getPersistentData().putBoolean("Working", (true));
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
						mainObject.addProperty((new ItemStack(IndustrialEconomyModItems.DIAMONDSCREWITEM.get()).getDisplayName().getString()),
								(mainObject.get((new ItemStack(IndustrialEconomyModItems.DIAMONDSCREWITEM.get()).getDisplayName().getString()))
										.getAsDouble() - 4));
						mainObject.addProperty((new ItemStack(IndustrialEconomyModItems.IRONPLATE.get()).getDisplayName().getString()),
								(mainObject.get((new ItemStack(IndustrialEconomyModItems.IRONPLATE.get()).getDisplayName().getString())).getAsDouble()
										- 2));
						mainObject.addProperty((new ItemStack(IndustrialEconomyModBlocks.DIAMOND_STEELBLOCK.get()).getDisplayName().getString()),
								(mainObject.get((new ItemStack(IndustrialEconomyModBlocks.DIAMOND_STEELBLOCK.get()).getDisplayName().getString()))
										.getAsDouble() - 1));
						mainObject.addProperty((new ItemStack(IndustrialEconomyModBlocks.HEAVYIRONBLOCK.get()).getDisplayName().getString()),
								(mainObject.get((new ItemStack(IndustrialEconomyModBlocks.HEAVYIRONBLOCK.get()).getDisplayName().getString()))
										.getAsDouble() - 2));
						{
							Gson mainGSONBuilderVariable = new GsonBuilder().setPrettyPrinting().create();
							try {
								FileWriter fileWriter = new FileWriter(playerStorageConfig);
								fileWriter.write(mainGSONBuilderVariable.toJson(mainObject));
								fileWriter.close();
							} catch (IOException exception) {
								exception.printStackTrace();
							}
						}
						{
							BlockEntity _ent = world.getBlockEntity(new BlockPos(x, y, z));
							if (_ent != null) {
								final int _slotid = 0;
								final ItemStack _setstack = new ItemStack(IndustrialEconomyModItems.DIAMONDSTEELPLATE.get());
								_setstack.setCount((int) (new Object() {
									public int getAmount(LevelAccessor world, BlockPos pos, int slotid) {
										AtomicInteger _retval = new AtomicInteger(0);
										BlockEntity _ent = world.getBlockEntity(pos);
										if (_ent != null)
											_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null)
													.ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).getCount()));
										return _retval.get();
									}
								}.getAmount(world, new BlockPos(x, y, z), 0) + 1));
								_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
									if (capability instanceof IItemHandlerModifiable)
										((IItemHandlerModifiable) capability).setStackInSlot(_slotid, _setstack);
								});
							}
						}
					} else {
						if (!world.isClientSide()) {
							BlockPos _bp = new BlockPos(x, y, z);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null)
								_blockEntity.getPersistentData().putBoolean("Working", (false));
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if ((new Object() {
				public boolean getValue(LevelAccessor world, BlockPos pos, String tag) {
					BlockEntity blockEntity = world.getBlockEntity(pos);
					if (blockEntity != null)
						return blockEntity.getPersistentData().getBoolean(tag);
					return false;
				}
			}.getValue(world, new BlockPos(x, y, z), "Working")) == true) {
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
						mainObject.addProperty("Energy", (mainObject.get("Energy").getAsDouble() - 2500));
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
		if (Energy > 2500 && (new Object() {
			public String getValue(LevelAccessor world, BlockPos pos, String tag) {
				BlockEntity blockEntity = world.getBlockEntity(pos);
				if (blockEntity != null)
					return blockEntity.getPersistentData().getString(tag);
				return "";
			}
		}.getValue(world, new BlockPos(x, y, z), "Recipe")).equals("AiLimiter")) {
			playerStorageConfig = new File((FMLPaths.GAMEDIR.get().toString() + "/config/"), File.separator + (owner + "_storage.json"));
			{
				try {
					BufferedReader bufferedReader = new BufferedReader(new FileReader(playerStorageConfig));
					StringBuilder jsonstringbuilder = new StringBuilder();
					String line;
					while ((line = bufferedReader.readLine()) != null) {
						jsonstringbuilder.append(line);
					}
					bufferedReader.close();
					mainObject = new Gson().fromJson(jsonstringbuilder.toString(), com.google.gson.JsonObject.class);
					if (mainObject.get((new ItemStack(IndustrialEconomyModItems.HIGHSPEEDCONECTORITEM.get()).getDisplayName().getString()))
							.getAsDouble() > 4
							&& mainObject.get((new ItemStack(IndustrialEconomyModItems.CATERIUMWIREITEM.get()).getDisplayName().getString()))
									.getAsDouble() > 2
							&& mainObject.get((new ItemStack(IndustrialEconomyModItems.CIRCUIT_BOARDITEM.get()).getDisplayName().getString()))
									.getAsDouble() > 2
							&& mainObject.get((new ItemStack(IndustrialEconomyModBlocks.STEEL_BLOCK.get()).getDisplayName().getString()))
									.getAsDouble() > 1
							&& (new Object() {
								public int getAmount(LevelAccessor world, BlockPos pos, int slotid) {
									AtomicInteger _retval = new AtomicInteger(0);
									BlockEntity _ent = world.getBlockEntity(pos);
									if (_ent != null)
										_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null)
												.ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).getCount()));
									return _retval.get();
								}
							}.getAmount(world, new BlockPos(x, y, z), 0) == 0 || new Object() {
								public int getAmount(LevelAccessor world, BlockPos pos, int slotid) {
									AtomicInteger _retval = new AtomicInteger(0);
									BlockEntity _ent = world.getBlockEntity(pos);
									if (_ent != null)
										_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null)
												.ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).getCount()));
									return _retval.get();
								}
							}.getAmount(world, new BlockPos(x, y, z), 0) < 64 && IndustrialEconomyModItems.AI_LIMITERITEM.get() == (new Object() {
								public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
									AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
									BlockEntity _ent = world.getBlockEntity(pos);
									if (_ent != null)
										_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null)
												.ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
									return _retval.get();
								}
							}.getItemStack(world, new BlockPos(x, y, z), 0)).getItem())) {
						if (!world.isClientSide()) {
							BlockPos _bp = new BlockPos(x, y, z);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null)
								_blockEntity.getPersistentData().putBoolean("Working", (true));
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
						mainObject.addProperty((new ItemStack(IndustrialEconomyModItems.HIGHSPEEDCONECTORITEM.get()).getDisplayName().getString()),
								(mainObject.get((new ItemStack(IndustrialEconomyModItems.HIGHSPEEDCONECTORITEM.get()).getDisplayName().getString()))
										.getAsDouble() - 4));
						mainObject.addProperty((new ItemStack(IndustrialEconomyModItems.CATERIUMWIREITEM.get()).getDisplayName().getString()),
								(mainObject.get((new ItemStack(IndustrialEconomyModItems.CATERIUMWIREITEM.get()).getDisplayName().getString()))
										.getAsDouble() - 2));
						mainObject.addProperty((new ItemStack(IndustrialEconomyModItems.CIRCUIT_BOARDITEM.get()).getDisplayName().getString()),
								(mainObject.get((new ItemStack(IndustrialEconomyModItems.CIRCUIT_BOARDITEM.get()).getDisplayName().getString()))
										.getAsDouble() - 2));
						mainObject.addProperty((new ItemStack(IndustrialEconomyModBlocks.STEEL_BLOCK.get()).getDisplayName().getString()), (mainObject
								.get((new ItemStack(IndustrialEconomyModBlocks.STEEL_BLOCK.get()).getDisplayName().getString())).getAsDouble() - 1));
						{
							Gson mainGSONBuilderVariable = new GsonBuilder().setPrettyPrinting().create();
							try {
								FileWriter fileWriter = new FileWriter(playerStorageConfig);
								fileWriter.write(mainGSONBuilderVariable.toJson(mainObject));
								fileWriter.close();
							} catch (IOException exception) {
								exception.printStackTrace();
							}
						}
						{
							BlockEntity _ent = world.getBlockEntity(new BlockPos(x, y, z));
							if (_ent != null) {
								final int _slotid = 0;
								final ItemStack _setstack = new ItemStack(IndustrialEconomyModItems.AI_LIMITERITEM.get());
								_setstack.setCount((int) (new Object() {
									public int getAmount(LevelAccessor world, BlockPos pos, int slotid) {
										AtomicInteger _retval = new AtomicInteger(0);
										BlockEntity _ent = world.getBlockEntity(pos);
										if (_ent != null)
											_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null)
													.ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).getCount()));
										return _retval.get();
									}
								}.getAmount(world, new BlockPos(x, y, z), 0) + 1));
								_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
									if (capability instanceof IItemHandlerModifiable)
										((IItemHandlerModifiable) capability).setStackInSlot(_slotid, _setstack);
								});
							}
						}
					} else {
						if (!world.isClientSide()) {
							BlockPos _bp = new BlockPos(x, y, z);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null)
								_blockEntity.getPersistentData().putBoolean("Working", (false));
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if ((new Object() {
				public boolean getValue(LevelAccessor world, BlockPos pos, String tag) {
					BlockEntity blockEntity = world.getBlockEntity(pos);
					if (blockEntity != null)
						return blockEntity.getPersistentData().getBoolean(tag);
					return false;
				}
			}.getValue(world, new BlockPos(x, y, z), "Working")) == true) {
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
						mainObject.addProperty("Energy", (mainObject.get("Energy").getAsDouble() - 2500));
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
		if (Energy > 2500 && (new Object() {
			public String getValue(LevelAccessor world, BlockPos pos, String tag) {
				BlockEntity blockEntity = world.getBlockEntity(pos);
				if (blockEntity != null)
					return blockEntity.getPersistentData().getString(tag);
				return "";
			}
		}.getValue(world, new BlockPos(x, y, z), "Recipe")).equals("ControlUnit")) {
			playerStorageConfig = new File((FMLPaths.GAMEDIR.get().toString() + "/config/"), File.separator + (owner + "_storage.json"));
			{
				try {
					BufferedReader bufferedReader = new BufferedReader(new FileReader(playerStorageConfig));
					StringBuilder jsonstringbuilder = new StringBuilder();
					String line;
					while ((line = bufferedReader.readLine()) != null) {
						jsonstringbuilder.append(line);
					}
					bufferedReader.close();
					mainObject = new Gson().fromJson(jsonstringbuilder.toString(), com.google.gson.JsonObject.class);
					if (mainObject.get((new ItemStack(IndustrialEconomyModItems.HIGHSPEEDCONECTORITEM.get()).getDisplayName().getString()))
							.getAsDouble() > 2
							&& mainObject.get((new ItemStack(IndustrialEconomyModItems.AI_LIMITERITEM.get()).getDisplayName().getString()))
									.getAsDouble() > 2
							&& mainObject.get((new ItemStack(IndustrialEconomyModItems.CATERIUMWIREITEM.get()).getDisplayName().getString()))
									.getAsDouble() > 3
							&& mainObject.get((new ItemStack(IndustrialEconomyModItems.CIRCUIT_BOARDITEM.get()).getDisplayName().getString()))
									.getAsDouble() > 1
							&& mainObject.get((new ItemStack(IndustrialEconomyModItems.DIAMONDSTEELPLATE.get()).getDisplayName().getString()))
									.getAsDouble() > 1
							&& (new Object() {
								public int getAmount(LevelAccessor world, BlockPos pos, int slotid) {
									AtomicInteger _retval = new AtomicInteger(0);
									BlockEntity _ent = world.getBlockEntity(pos);
									if (_ent != null)
										_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null)
												.ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).getCount()));
									return _retval.get();
								}
							}.getAmount(world, new BlockPos(x, y, z), 0) == 0 || new Object() {
								public int getAmount(LevelAccessor world, BlockPos pos, int slotid) {
									AtomicInteger _retval = new AtomicInteger(0);
									BlockEntity _ent = world.getBlockEntity(pos);
									if (_ent != null)
										_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null)
												.ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).getCount()));
									return _retval.get();
								}
							}.getAmount(world, new BlockPos(x, y, z), 0) < 64 && IndustrialEconomyModItems.CONTROL_UNIT.get() == (new Object() {
								public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
									AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
									BlockEntity _ent = world.getBlockEntity(pos);
									if (_ent != null)
										_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null)
												.ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
									return _retval.get();
								}
							}.getItemStack(world, new BlockPos(x, y, z), 0)).getItem())) {
						if (!world.isClientSide()) {
							BlockPos _bp = new BlockPos(x, y, z);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null)
								_blockEntity.getPersistentData().putBoolean("Working", (true));
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
						mainObject.addProperty((new ItemStack(IndustrialEconomyModItems.HIGHSPEEDCONECTORITEM.get()).getDisplayName().getString()),
								(mainObject.get((new ItemStack(IndustrialEconomyModItems.HIGHSPEEDCONECTORITEM.get()).getDisplayName().getString()))
										.getAsDouble() - 2));
						mainObject.addProperty((new ItemStack(IndustrialEconomyModItems.AI_LIMITERITEM.get()).getDisplayName().getString()),
								(mainObject.get((new ItemStack(IndustrialEconomyModItems.AI_LIMITERITEM.get()).getDisplayName().getString()))
										.getAsDouble() - 2));
						mainObject.addProperty((new ItemStack(IndustrialEconomyModItems.CATERIUMWIREITEM.get()).getDisplayName().getString()),
								(mainObject.get((new ItemStack(IndustrialEconomyModItems.CATERIUMWIREITEM.get()).getDisplayName().getString()))
										.getAsDouble() - 3));
						mainObject.addProperty((new ItemStack(IndustrialEconomyModItems.CIRCUIT_BOARDITEM.get()).getDisplayName().getString()),
								(mainObject.get((new ItemStack(IndustrialEconomyModItems.CIRCUIT_BOARDITEM.get()).getDisplayName().getString()))
										.getAsDouble() - 1));
						mainObject.addProperty((new ItemStack(IndustrialEconomyModItems.DIAMONDSTEELPLATE.get()).getDisplayName().getString()),
								(mainObject.get((new ItemStack(IndustrialEconomyModItems.DIAMONDSTEELPLATE.get()).getDisplayName().getString()))
										.getAsDouble() - 1));
						{
							Gson mainGSONBuilderVariable = new GsonBuilder().setPrettyPrinting().create();
							try {
								FileWriter fileWriter = new FileWriter(playerStorageConfig);
								fileWriter.write(mainGSONBuilderVariable.toJson(mainObject));
								fileWriter.close();
							} catch (IOException exception) {
								exception.printStackTrace();
							}
						}
						{
							BlockEntity _ent = world.getBlockEntity(new BlockPos(x, y, z));
							if (_ent != null) {
								final int _slotid = 0;
								final ItemStack _setstack = new ItemStack(IndustrialEconomyModItems.CONTROL_UNIT.get());
								_setstack.setCount((int) (new Object() {
									public int getAmount(LevelAccessor world, BlockPos pos, int slotid) {
										AtomicInteger _retval = new AtomicInteger(0);
										BlockEntity _ent = world.getBlockEntity(pos);
										if (_ent != null)
											_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null)
													.ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).getCount()));
										return _retval.get();
									}
								}.getAmount(world, new BlockPos(x, y, z), 0) + 1));
								_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
									if (capability instanceof IItemHandlerModifiable)
										((IItemHandlerModifiable) capability).setStackInSlot(_slotid, _setstack);
								});
							}
						}
					} else {
						if (!world.isClientSide()) {
							BlockPos _bp = new BlockPos(x, y, z);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null)
								_blockEntity.getPersistentData().putBoolean("Working", (false));
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if ((new Object() {
				public boolean getValue(LevelAccessor world, BlockPos pos, String tag) {
					BlockEntity blockEntity = world.getBlockEntity(pos);
					if (blockEntity != null)
						return blockEntity.getPersistentData().getBoolean(tag);
					return false;
				}
			}.getValue(world, new BlockPos(x, y, z), "Working")) == true) {
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
						mainObject.addProperty("Energy", (mainObject.get("Energy").getAsDouble() - 2500));
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
		if (Energy > 2500 && (new Object() {
			public String getValue(LevelAccessor world, BlockPos pos, String tag) {
				BlockEntity blockEntity = world.getBlockEntity(pos);
				if (blockEntity != null)
					return blockEntity.getPersistentData().getString(tag);
				return "";
			}
		}.getValue(world, new BlockPos(x, y, z), "Recipe")).equals("CPU")) {
			playerStorageConfig = new File((FMLPaths.GAMEDIR.get().toString() + "/config/"), File.separator + (owner + "_storage.json"));
			{
				try {
					BufferedReader bufferedReader = new BufferedReader(new FileReader(playerStorageConfig));
					StringBuilder jsonstringbuilder = new StringBuilder();
					String line;
					while ((line = bufferedReader.readLine()) != null) {
						jsonstringbuilder.append(line);
					}
					bufferedReader.close();
					mainObject = new Gson().fromJson(jsonstringbuilder.toString(), com.google.gson.JsonObject.class);
					if (mainObject.get((new ItemStack(IndustrialEconomyModItems.HIGHSPEEDCONECTORITEM.get()).getDisplayName().getString()))
							.getAsDouble() > 4
							&& mainObject.get((new ItemStack(IndustrialEconomyModItems.CONTROL_UNIT.get()).getDisplayName().getString()))
									.getAsDouble() > 4
							&& mainObject.get((new ItemStack(IndustrialEconomyModItems.AI_LIMITERITEM.get()).getDisplayName().getString()))
									.getAsDouble() > 1
							&& (new Object() {
								public int getAmount(LevelAccessor world, BlockPos pos, int slotid) {
									AtomicInteger _retval = new AtomicInteger(0);
									BlockEntity _ent = world.getBlockEntity(pos);
									if (_ent != null)
										_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null)
												.ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).getCount()));
									return _retval.get();
								}
							}.getAmount(world, new BlockPos(x, y, z), 0) == 0 || new Object() {
								public int getAmount(LevelAccessor world, BlockPos pos, int slotid) {
									AtomicInteger _retval = new AtomicInteger(0);
									BlockEntity _ent = world.getBlockEntity(pos);
									if (_ent != null)
										_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null)
												.ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).getCount()));
									return _retval.get();
								}
							}.getAmount(world, new BlockPos(x, y, z), 0) < 64 && IndustrialEconomyModItems.CPU.get() == (new Object() {
								public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
									AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
									BlockEntity _ent = world.getBlockEntity(pos);
									if (_ent != null)
										_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null)
												.ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
									return _retval.get();
								}
							}.getItemStack(world, new BlockPos(x, y, z), 0)).getItem())) {
						if (!world.isClientSide()) {
							BlockPos _bp = new BlockPos(x, y, z);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null)
								_blockEntity.getPersistentData().putBoolean("Working", (true));
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
						mainObject.addProperty((new ItemStack(IndustrialEconomyModItems.HIGHSPEEDCONECTORITEM.get()).getDisplayName().getString()),
								(mainObject.get((new ItemStack(IndustrialEconomyModItems.HIGHSPEEDCONECTORITEM.get()).getDisplayName().getString()))
										.getAsDouble() - 4));
						mainObject.addProperty((new ItemStack(IndustrialEconomyModItems.CONTROL_UNIT.get()).getDisplayName().getString()), (mainObject
								.get((new ItemStack(IndustrialEconomyModItems.CONTROL_UNIT.get()).getDisplayName().getString())).getAsDouble() - 4));
						mainObject.addProperty((new ItemStack(IndustrialEconomyModItems.AI_LIMITERITEM.get()).getDisplayName().getString()),
								(mainObject.get((new ItemStack(IndustrialEconomyModItems.AI_LIMITERITEM.get()).getDisplayName().getString()))
										.getAsDouble() - 1));
						{
							Gson mainGSONBuilderVariable = new GsonBuilder().setPrettyPrinting().create();
							try {
								FileWriter fileWriter = new FileWriter(playerStorageConfig);
								fileWriter.write(mainGSONBuilderVariable.toJson(mainObject));
								fileWriter.close();
							} catch (IOException exception) {
								exception.printStackTrace();
							}
						}
						{
							BlockEntity _ent = world.getBlockEntity(new BlockPos(x, y, z));
							if (_ent != null) {
								final int _slotid = 0;
								final ItemStack _setstack = new ItemStack(IndustrialEconomyModItems.CPU.get());
								_setstack.setCount((int) (new Object() {
									public int getAmount(LevelAccessor world, BlockPos pos, int slotid) {
										AtomicInteger _retval = new AtomicInteger(0);
										BlockEntity _ent = world.getBlockEntity(pos);
										if (_ent != null)
											_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null)
													.ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).getCount()));
										return _retval.get();
									}
								}.getAmount(world, new BlockPos(x, y, z), 0) + 1));
								_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
									if (capability instanceof IItemHandlerModifiable)
										((IItemHandlerModifiable) capability).setStackInSlot(_slotid, _setstack);
								});
							}
						}
					} else {
						if (!world.isClientSide()) {
							BlockPos _bp = new BlockPos(x, y, z);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null)
								_blockEntity.getPersistentData().putBoolean("Working", (false));
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if ((new Object() {
				public boolean getValue(LevelAccessor world, BlockPos pos, String tag) {
					BlockEntity blockEntity = world.getBlockEntity(pos);
					if (blockEntity != null)
						return blockEntity.getPersistentData().getBoolean(tag);
					return false;
				}
			}.getValue(world, new BlockPos(x, y, z), "Working")) == true) {
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
						mainObject.addProperty("Energy", (mainObject.get("Energy").getAsDouble() - 2500));
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
		if (Energy > 2500 && (new Object() {
			public String getValue(LevelAccessor world, BlockPos pos, String tag) {
				BlockEntity blockEntity = world.getBlockEntity(pos);
				if (blockEntity != null)
					return blockEntity.getPersistentData().getString(tag);
				return "";
			}
		}.getValue(world, new BlockPos(x, y, z), "Recipe")).equals("EmptyModule")) {
			playerStorageConfig = new File((FMLPaths.GAMEDIR.get().toString() + "/config/"), File.separator + (owner + "_storage.json"));
			{
				try {
					BufferedReader bufferedReader = new BufferedReader(new FileReader(playerStorageConfig));
					StringBuilder jsonstringbuilder = new StringBuilder();
					String line;
					while ((line = bufferedReader.readLine()) != null) {
						jsonstringbuilder.append(line);
					}
					bufferedReader.close();
					mainObject = new Gson().fromJson(jsonstringbuilder.toString(), com.google.gson.JsonObject.class);
					if (mainObject.get((new ItemStack(IndustrialEconomyModItems.CPU.get()).getDisplayName().getString())).getAsDouble() > 1
							&& mainObject.get((new ItemStack(IndustrialEconomyModItems.CONTROL_UNIT.get()).getDisplayName().getString()))
									.getAsDouble() > 7
							&& (new Object() {
								public int getAmount(LevelAccessor world, BlockPos pos, int slotid) {
									AtomicInteger _retval = new AtomicInteger(0);
									BlockEntity _ent = world.getBlockEntity(pos);
									if (_ent != null)
										_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null)
												.ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).getCount()));
									return _retval.get();
								}
							}.getAmount(world, new BlockPos(x, y, z), 0) == 0 || new Object() {
								public int getAmount(LevelAccessor world, BlockPos pos, int slotid) {
									AtomicInteger _retval = new AtomicInteger(0);
									BlockEntity _ent = world.getBlockEntity(pos);
									if (_ent != null)
										_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null)
												.ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).getCount()));
									return _retval.get();
								}
							}.getAmount(world, new BlockPos(x, y, z), 0) < 64 && IndustrialEconomyModItems.CPU.get() == (new Object() {
								public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
									AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
									BlockEntity _ent = world.getBlockEntity(pos);
									if (_ent != null)
										_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null)
												.ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
									return _retval.get();
								}
							}.getItemStack(world, new BlockPos(x, y, z), 0)).getItem())) {
						if (!world.isClientSide()) {
							BlockPos _bp = new BlockPos(x, y, z);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null)
								_blockEntity.getPersistentData().putBoolean("Working", (true));
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
						mainObject.addProperty((new ItemStack(IndustrialEconomyModItems.CPU.get()).getDisplayName().getString()),
								(mainObject.get((new ItemStack(IndustrialEconomyModItems.CPU.get()).getDisplayName().getString())).getAsDouble()
										- 1));
						mainObject.addProperty((new ItemStack(IndustrialEconomyModItems.CONTROL_UNIT.get()).getDisplayName().getString()), (mainObject
								.get((new ItemStack(IndustrialEconomyModItems.CONTROL_UNIT.get()).getDisplayName().getString())).getAsDouble() - 7));
						{
							Gson mainGSONBuilderVariable = new GsonBuilder().setPrettyPrinting().create();
							try {
								FileWriter fileWriter = new FileWriter(playerStorageConfig);
								fileWriter.write(mainGSONBuilderVariable.toJson(mainObject));
								fileWriter.close();
							} catch (IOException exception) {
								exception.printStackTrace();
							}
						}
						{
							BlockEntity _ent = world.getBlockEntity(new BlockPos(x, y, z));
							if (_ent != null) {
								final int _slotid = 0;
								final ItemStack _setstack = new ItemStack(IndustrialEconomyModItems.EMPTYMODULE.get());
								_setstack.setCount((int) (new Object() {
									public int getAmount(LevelAccessor world, BlockPos pos, int slotid) {
										AtomicInteger _retval = new AtomicInteger(0);
										BlockEntity _ent = world.getBlockEntity(pos);
										if (_ent != null)
											_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null)
													.ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).getCount()));
										return _retval.get();
									}
								}.getAmount(world, new BlockPos(x, y, z), 0) + 1));
								_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
									if (capability instanceof IItemHandlerModifiable)
										((IItemHandlerModifiable) capability).setStackInSlot(_slotid, _setstack);
								});
							}
						}
					} else {
						if (!world.isClientSide()) {
							BlockPos _bp = new BlockPos(x, y, z);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null)
								_blockEntity.getPersistentData().putBoolean("Working", (false));
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if ((new Object() {
				public boolean getValue(LevelAccessor world, BlockPos pos, String tag) {
					BlockEntity blockEntity = world.getBlockEntity(pos);
					if (blockEntity != null)
						return blockEntity.getPersistentData().getBoolean(tag);
					return false;
				}
			}.getValue(world, new BlockPos(x, y, z), "Working")) == true) {
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
						mainObject.addProperty("Energy", (mainObject.get("Energy").getAsDouble() - 2500));
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
	}
}
