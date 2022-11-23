
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package industrialeconomy.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.BlockItem;

import industrialeconomy.item.TwoHundredFiftySixCoreCPUItem;
import industrialeconomy.item.TwoCoreCPUItem;
import industrialeconomy.item.TurbofuelitemItem;
import industrialeconomy.item.Turbofuelitem3Item;
import industrialeconomy.item.Turbofuelitem2Item;
import industrialeconomy.item.TurboFuelMK4Item;
import industrialeconomy.item.ThirtytwoCoreCPUItem;
import industrialeconomy.item.TestdimensionItem;
import industrialeconomy.item.SteelingotItem;
import industrialeconomy.item.SteelToolSSwordItem;
import industrialeconomy.item.SteelToolSShovelItem;
import industrialeconomy.item.SteelToolSPickaxeItem;
import industrialeconomy.item.SteelToolSHoeItem;
import industrialeconomy.item.SteelToolSAxeItem;
import industrialeconomy.item.SteelDustItem;
import industrialeconomy.item.SpaceSuitWithCanisterItem;
import industrialeconomy.item.SpaceSuitItem;
import industrialeconomy.item.SixtyFourCoreCPUItem;
import industrialeconomy.item.SixteenCoreCPUItem;
import industrialeconomy.item.ScrewItem;
import industrialeconomy.item.RedstoneingotitemItem;
import industrialeconomy.item.PowerwireItem;
import industrialeconomy.item.PocketchestitemItem;
import industrialeconomy.item.PlasmabulletitemItem;
import industrialeconomy.item.PlasmaRANGEDITEMItem;
import industrialeconomy.item.PlaceToolItem;
import industrialeconomy.item.PermadayupgradeItem;
import industrialeconomy.item.OxygencanisterItem;
import industrialeconomy.item.OneHundredTwentyEightCoreCPUItem;
import industrialeconomy.item.NodeScannerToolItem;
import industrialeconomy.item.Money500Item;
import industrialeconomy.item.Money5000Item;
import industrialeconomy.item.Money50000Item;
import industrialeconomy.item.Money2000Item;
import industrialeconomy.item.Money100Item;
import industrialeconomy.item.Money1000Item;
import industrialeconomy.item.Money10000Item;
import industrialeconomy.item.Money100000Item;
import industrialeconomy.item.LiquidHydrogenItem;
import industrialeconomy.item.IronplateItem;
import industrialeconomy.item.IndustrialDiamondItem;
import industrialeconomy.item.HighspeedconectoritemItem;
import industrialeconomy.item.FourCoreCPUItem;
import industrialeconomy.item.EmptymoduleItem;
import industrialeconomy.item.EightCoreCPUItem;
import industrialeconomy.item.DiamondstellshovelItem;
import industrialeconomy.item.DiamondsteelplateItem;
import industrialeconomy.item.DiamondsteelitemItem;
import industrialeconomy.item.DiamondsteelaxeItem;
import industrialeconomy.item.DiamondscrewitemItem;
import industrialeconomy.item.DiamondSteelpickaxeItem;
import industrialeconomy.item.DiamondSteelSwordItem;
import industrialeconomy.item.DiamondSteelNuggetItem;
import industrialeconomy.item.DiamondSteelHOeItem;
import industrialeconomy.item.DiamondSteelArmorItem;
import industrialeconomy.item.CrystalchunkItem;
import industrialeconomy.item.CpuItem;
import industrialeconomy.item.CopperSheetItemItem;
import industrialeconomy.item.CopperIngotItem;
import industrialeconomy.item.CopperFoundationItem;
import industrialeconomy.item.ControlUnitItem;
import industrialeconomy.item.ConcreteItem;
import industrialeconomy.item.CircuitBoarditemItem;
import industrialeconomy.item.CateriumwireitemItem;
import industrialeconomy.item.CateriumroditemItem;
import industrialeconomy.item.CateriumIngotItem;
import industrialeconomy.item.BuildertoolItem;
import industrialeconomy.item.BlackOpalItem;
import industrialeconomy.item.BlackOpalIngotItem;
import industrialeconomy.item.AiLimiteritemItem;

import industrialeconomy.IndustrialEconomyMod;

public class IndustrialEconomyModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, IndustrialEconomyMod.MODID);
	public static final RegistryObject<Item> CATERIUM_INGOT = REGISTRY.register("caterium_ingot", () -> new CateriumIngotItem());
	public static final RegistryObject<Item> CATERIUM_ORE = block(IndustrialEconomyModBlocks.CATERIUM_ORE, IndustrialEconomyModTabs.TAB_PROJECT_MEGA);
	public static final RegistryObject<Item> CATERIUM_BLOCK = block(IndustrialEconomyModBlocks.CATERIUM_BLOCK,
			IndustrialEconomyModTabs.TAB_PROJECT_MEGA);
	public static final RegistryObject<Item> CATERIUM_NOD_EBLOCK = block(IndustrialEconomyModBlocks.CATERIUM_NOD_EBLOCK,
			IndustrialEconomyModTabs.TAB_PROJECT_MEGA);
	public static final RegistryObject<Item> CATERIUM_NODE_BLOCK_INACTIVE = block(IndustrialEconomyModBlocks.CATERIUM_NODE_BLOCK_INACTIVE, null);
	public static final RegistryObject<Item> IRON_ORE_NODE_BLOCK = block(IndustrialEconomyModBlocks.IRON_ORE_NODE_BLOCK,
			IndustrialEconomyModTabs.TAB_PROJECT_MEGA);
	public static final RegistryObject<Item> IRON_ORE_NODE_BLOCK_INACTIVE = block(IndustrialEconomyModBlocks.IRON_ORE_NODE_BLOCK_INACTIVE, null);
	public static final RegistryObject<Item> COPPER_INGOT = REGISTRY.register("copper_ingot", () -> new CopperIngotItem());
	public static final RegistryObject<Item> COPPER_ORE = block(IndustrialEconomyModBlocks.COPPER_ORE, IndustrialEconomyModTabs.TAB_PROJECT_MEGA);
	public static final RegistryObject<Item> COPPER_BLOCK = block(IndustrialEconomyModBlocks.COPPER_BLOCK, IndustrialEconomyModTabs.TAB_PROJECT_MEGA);
	public static final RegistryObject<Item> COAL_NODE = block(IndustrialEconomyModBlocks.COAL_NODE, IndustrialEconomyModTabs.TAB_PROJECT_MEGA);
	public static final RegistryObject<Item> COPPER_SHEET_ITEM = REGISTRY.register("copper_sheet_item", () -> new CopperSheetItemItem());
	public static final RegistryObject<Item> COAL_NODE_INACTIVE = block(IndustrialEconomyModBlocks.COAL_NODE_INACTIVE, null);
	public static final RegistryObject<Item> TURBOFUELITEM = REGISTRY.register("turbofuelitem", () -> new TurbofuelitemItem());
	public static final RegistryObject<Item> TURBOFUELITEM_2 = REGISTRY.register("turbofuelitem_2", () -> new Turbofuelitem2Item());
	public static final RegistryObject<Item> TURBOFUELITEM_3 = REGISTRY.register("turbofuelitem_3", () -> new Turbofuelitem3Item());
	public static final RegistryObject<Item> HUB = block(IndustrialEconomyModBlocks.HUB, IndustrialEconomyModTabs.TAB_PROJECT_MEGA);
	public static final RegistryObject<Item> REDSTONEINGOTITEM = REGISTRY.register("redstoneingotitem", () -> new RedstoneingotitemItem());
	public static final RegistryObject<Item> MINERBLOCK = block(IndustrialEconomyModBlocks.MINERBLOCK, null);
	public static final RegistryObject<Item> GENERATOR_MK_1 = block(IndustrialEconomyModBlocks.GENERATOR_MK_1,
			IndustrialEconomyModTabs.TAB_PROJECT_MEGA);
	public static final RegistryObject<Item> CIRCUIT_BOARDITEM = REGISTRY.register("circuit_boarditem", () -> new CircuitBoarditemItem());
	public static final RegistryObject<Item> CONSTRUCTORBLOCK = block(IndustrialEconomyModBlocks.CONSTRUCTORBLOCK,
			IndustrialEconomyModTabs.TAB_PROJECT_MEGA);
	public static final RegistryObject<Item> NODE_SCANNER_TOOL = REGISTRY.register("node_scanner_tool", () -> new NodeScannerToolItem());
	public static final RegistryObject<Item> COPPER_NODE = block(IndustrialEconomyModBlocks.COPPER_NODE, IndustrialEconomyModTabs.TAB_PROJECT_MEGA);
	public static final RegistryObject<Item> COPPER_NODE_INACTVE = block(IndustrialEconomyModBlocks.COPPER_NODE_INACTVE, null);
	public static final RegistryObject<Item> CHARGERBLOCK = block(IndustrialEconomyModBlocks.CHARGERBLOCK, IndustrialEconomyModTabs.TAB_PROJECT_MEGA);
	public static final RegistryObject<Item> FOUNDYBLOCK = block(IndustrialEconomyModBlocks.FOUNDYBLOCK, IndustrialEconomyModTabs.TAB_PROJECT_MEGA);
	public static final RegistryObject<Item> STEELINGOT = REGISTRY.register("steelingot", () -> new SteelingotItem());
	public static final RegistryObject<Item> STEEL_BLOCK = block(IndustrialEconomyModBlocks.STEEL_BLOCK, IndustrialEconomyModTabs.TAB_PROJECT_MEGA);
	public static final RegistryObject<Item> DIAMONDSTEELITEM = REGISTRY.register("diamondsteelitem", () -> new DiamondsteelitemItem());
	public static final RegistryObject<Item> DIAMOND_STEELBLOCK = block(IndustrialEconomyModBlocks.DIAMOND_STEELBLOCK,
			IndustrialEconomyModTabs.TAB_PROJECT_MEGA);
	public static final RegistryObject<Item> PRESSERBLOCK = block(IndustrialEconomyModBlocks.PRESSERBLOCK, IndustrialEconomyModTabs.TAB_PROJECT_MEGA);
	public static final RegistryObject<Item> GENERATORMK_2 = block(IndustrialEconomyModBlocks.GENERATORMK_2,
			IndustrialEconomyModTabs.TAB_PROJECT_MEGA);
	public static final RegistryObject<Item> HIGHSPEEDCONECTORITEM = REGISTRY.register("highspeedconectoritem",
			() -> new HighspeedconectoritemItem());
	public static final RegistryObject<Item> DIAMOND_STEEL_SWORD = REGISTRY.register("diamond_steel_sword", () -> new DiamondSteelSwordItem());
	public static final RegistryObject<Item> DIAMOND_STEELPICKAXE = REGISTRY.register("diamond_steelpickaxe", () -> new DiamondSteelpickaxeItem());
	public static final RegistryObject<Item> DIAMONDSTEELAXE = REGISTRY.register("diamondsteelaxe", () -> new DiamondsteelaxeItem());
	public static final RegistryObject<Item> DIAMONDSTELLSHOVEL = REGISTRY.register("diamondstellshovel", () -> new DiamondstellshovelItem());
	public static final RegistryObject<Item> AI_LIMITERITEM = REGISTRY.register("ai_limiteritem", () -> new AiLimiteritemItem());
	public static final RegistryObject<Item> ELECTRIC_FURNANCE_BLOCK = block(IndustrialEconomyModBlocks.ELECTRIC_FURNANCE_BLOCK, null);
	public static final RegistryObject<Item> IRONEXTRACTOR = block(IndustrialEconomyModBlocks.IRONEXTRACTOR,
			IndustrialEconomyModTabs.TAB_PROJECT_MEGA);
	public static final RegistryObject<Item> COAL_EXTRACTOR = block(IndustrialEconomyModBlocks.COAL_EXTRACTOR,
			IndustrialEconomyModTabs.TAB_PROJECT_MEGA);
	public static final RegistryObject<Item> CATERIUM_EXTRACTOR = block(IndustrialEconomyModBlocks.CATERIUM_EXTRACTOR,
			IndustrialEconomyModTabs.TAB_PROJECT_MEGA);
	public static final RegistryObject<Item> COPPER_EXTRACTOR = block(IndustrialEconomyModBlocks.COPPER_EXTRACTOR,
			IndustrialEconomyModTabs.TAB_PROJECT_MEGA);
	public static final RegistryObject<Item> SCREW = REGISTRY.register("screw", () -> new ScrewItem());
	public static final RegistryObject<Item> IRONPLATE = REGISTRY.register("ironplate", () -> new IronplateItem());
	public static final RegistryObject<Item> HARDENEDCOBBLE = block(IndustrialEconomyModBlocks.HARDENEDCOBBLE,
			IndustrialEconomyModTabs.TAB_PROJECT_MEGA);
	public static final RegistryObject<Item> MINERINACTIVE = block(IndustrialEconomyModBlocks.MINERINACTIVE,
			IndustrialEconomyModTabs.TAB_PROJECT_MEGA);
	public static final RegistryObject<Item> ELECTRIC_FUNANCEINACTIVE = block(IndustrialEconomyModBlocks.ELECTRIC_FUNANCEINACTIVE,
			IndustrialEconomyModTabs.TAB_PROJECT_MEGA);
	public static final RegistryObject<Item> DIAMONDSTEELPLATE = REGISTRY.register("diamondsteelplate", () -> new DiamondsteelplateItem());
	public static final RegistryObject<Item> HEAVYIRONBLOCK = block(IndustrialEconomyModBlocks.HEAVYIRONBLOCK,
			IndustrialEconomyModTabs.TAB_PROJECT_MEGA);
	public static final RegistryObject<Item> DIAMOND_STEEL_ARMOR_HELMET = REGISTRY.register("diamond_steel_armor_helmet",
			() -> new DiamondSteelArmorItem.Helmet());
	public static final RegistryObject<Item> DIAMOND_STEEL_ARMOR_CHESTPLATE = REGISTRY.register("diamond_steel_armor_chestplate",
			() -> new DiamondSteelArmorItem.Chestplate());
	public static final RegistryObject<Item> DIAMOND_STEEL_ARMOR_LEGGINGS = REGISTRY.register("diamond_steel_armor_leggings",
			() -> new DiamondSteelArmorItem.Leggings());
	public static final RegistryObject<Item> DIAMOND_STEEL_ARMOR_BOOTS = REGISTRY.register("diamond_steel_armor_boots",
			() -> new DiamondSteelArmorItem.Boots());
	public static final RegistryObject<Item> POCKETCHESTITEM = REGISTRY.register("pocketchestitem", () -> new PocketchestitemItem());
	public static final RegistryObject<Item> DIAMONDSCREWITEM = REGISTRY.register("diamondscrewitem", () -> new DiamondscrewitemItem());
	public static final RegistryObject<Item> CATERIUMRODITEM = REGISTRY.register("cateriumroditem", () -> new CateriumroditemItem());
	public static final RegistryObject<Item> CATERIUMWIREITEM = REGISTRY.register("cateriumwireitem", () -> new CateriumwireitemItem());
	public static final RegistryObject<Item> SOLARPANELBLOCKACTIVE = block(IndustrialEconomyModBlocks.SOLARPANELBLOCKACTIVE, null);
	public static final RegistryObject<Item> SOLARPANELBLOCKINACTIVE = block(IndustrialEconomyModBlocks.SOLARPANELBLOCKINACTIVE,
			IndustrialEconomyModTabs.TAB_PROJECT_MEGA);
	public static final RegistryObject<Item> MODULARFRAME = block(IndustrialEconomyModBlocks.MODULARFRAME, IndustrialEconomyModTabs.TAB_PROJECT_MEGA);
	public static final RegistryObject<Item> HEAVYFRAME = block(IndustrialEconomyModBlocks.HEAVYFRAME, IndustrialEconomyModTabs.TAB_PROJECT_MEGA);
	public static final RegistryObject<Item> ASSEMBLERBLOCK = block(IndustrialEconomyModBlocks.ASSEMBLERBLOCK,
			IndustrialEconomyModTabs.TAB_PROJECT_MEGA);
	public static final RegistryObject<Item> PERMADAYUPGRADE = REGISTRY.register("permadayupgrade", () -> new PermadayupgradeItem());
	public static final RegistryObject<Item> MARKBLOCK = block(IndustrialEconomyModBlocks.MARKBLOCK, null);
	public static final RegistryObject<Item> LIMESTONEACTIVE = block(IndustrialEconomyModBlocks.LIMESTONEACTIVE, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Item> LIMESTONEINACTIVE = block(IndustrialEconomyModBlocks.LIMESTONEINACTIVE,
			CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Item> CONCRETEMIXER = block(IndustrialEconomyModBlocks.CONCRETEMIXER,
			IndustrialEconomyModTabs.TAB_PROJECT_MEGA);
	public static final RegistryObject<Item> CONCRETE = REGISTRY.register("concrete", () -> new ConcreteItem());
	public static final RegistryObject<Item> SANDSTONEEXTRACTOR = block(IndustrialEconomyModBlocks.SANDSTONEEXTRACTOR,
			IndustrialEconomyModTabs.TAB_PROJECT_MEGA);
	public static final RegistryObject<Item> CONTROL_UNIT = REGISTRY.register("control_unit", () -> new ControlUnitItem());
	public static final RegistryObject<Item> CPU = REGISTRY.register("cpu", () -> new CpuItem());
	public static final RegistryObject<Item> POSITION_1BLOCK = block(IndustrialEconomyModBlocks.POSITION_1BLOCK,
			IndustrialEconomyModTabs.TAB_PROJECT_MEGA);
	public static final RegistryObject<Item> POSITION_2BLOCK = block(IndustrialEconomyModBlocks.POSITION_2BLOCK,
			IndustrialEconomyModTabs.TAB_PROJECT_MEGA);
	public static final RegistryObject<Item> BUILDERTOOL = REGISTRY.register("buildertool", () -> new BuildertoolItem());
	public static final RegistryObject<Item> BUILDER_PREVIEWBLOCK = block(IndustrialEconomyModBlocks.BUILDER_PREVIEWBLOCK, null);
	public static final RegistryObject<Item> ARMORCHARGER = block(IndustrialEconomyModBlocks.ARMORCHARGER, IndustrialEconomyModTabs.TAB_PROJECT_MEGA);
	public static final RegistryObject<Item> ENERGYPLAZMA = block(IndustrialEconomyModBlocks.ENERGYPLAZMA, null);
	public static final RegistryObject<Item> PLASMABULLETITEM = REGISTRY.register("plasmabulletitem", () -> new PlasmabulletitemItem());
	public static final RegistryObject<Item> CRUSHER = block(IndustrialEconomyModBlocks.CRUSHER, IndustrialEconomyModTabs.TAB_PROJECT_MEGA);
	public static final RegistryObject<Item> ARMORCHARGERMK_2 = block(IndustrialEconomyModBlocks.ARMORCHARGERMK_2,
			IndustrialEconomyModTabs.TAB_PROJECT_MEGA);
	public static final RegistryObject<Item> ENERGYPLAZMAMK_2 = block(IndustrialEconomyModBlocks.ENERGYPLAZMAMK_2, null);
	public static final RegistryObject<Item> WHITE_CONCRETE_SLAB = block(IndustrialEconomyModBlocks.WHITE_CONCRETE_SLAB,
			CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Item> WHITE_CONCRETE_STAIRS = block(IndustrialEconomyModBlocks.WHITE_CONCRETE_STAIRS,
			CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Item> ORANGE_CONCRETE_SLAB = block(IndustrialEconomyModBlocks.ORANGE_CONCRETE_SLAB,
			CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Item> ORANGE_CONCRETE_STAIRS = block(IndustrialEconomyModBlocks.ORANGE_CONCRETE_STAIRS,
			CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Item> MAGENTA_CONCRETE_SLAB = block(IndustrialEconomyModBlocks.MAGENTA_CONCRETE_SLAB,
			CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Item> MAGENTA_CONCRETE_STAIRS = block(IndustrialEconomyModBlocks.MAGENTA_CONCRETE_STAIRS,
			CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Item> LIGHT_BLUE_CONCRETE_SLAB = block(IndustrialEconomyModBlocks.LIGHT_BLUE_CONCRETE_SLAB,
			CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Item> LIGHT_BLUE_CONCRETE_STAIRS = block(IndustrialEconomyModBlocks.LIGHT_BLUE_CONCRETE_STAIRS,
			CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Item> YELLOW_CONCRETE_SLAB = block(IndustrialEconomyModBlocks.YELLOW_CONCRETE_SLAB,
			CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Item> YELLOW_CONCRETE_STAIRS = block(IndustrialEconomyModBlocks.YELLOW_CONCRETE_STAIRS,
			CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Item> LIME_CONCRETE_SLAB = block(IndustrialEconomyModBlocks.LIME_CONCRETE_SLAB,
			CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Item> LIME_CONCRETE_STAIRS = block(IndustrialEconomyModBlocks.LIME_CONCRETE_STAIRS,
			CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Item> PINK_CONCRETE_SLAB = block(IndustrialEconomyModBlocks.PINK_CONCRETE_SLAB,
			CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Item> PINK_CONCRETE_STAIRS = block(IndustrialEconomyModBlocks.PINK_CONCRETE_STAIRS,
			CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Item> GRAY_CONCRETE_SLAB = block(IndustrialEconomyModBlocks.GRAY_CONCRETE_SLAB,
			CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Item> GRAY_CONCRETE_STAIRS = block(IndustrialEconomyModBlocks.GRAY_CONCRETE_STAIRS,
			CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Item> LIGHT_GRAY_CONCRETE_SLAB = block(IndustrialEconomyModBlocks.LIGHT_GRAY_CONCRETE_SLAB,
			CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Item> LIGHT_GRAY_CONCRETE_STAIRS = block(IndustrialEconomyModBlocks.LIGHT_GRAY_CONCRETE_STAIRS,
			CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Item> CYAN_CONCRETE_SLAB = block(IndustrialEconomyModBlocks.CYAN_CONCRETE_SLAB,
			CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Item> CYAN_CONCRETE_STAIRS = block(IndustrialEconomyModBlocks.CYAN_CONCRETE_STAIRS,
			CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Item> PURPLE_CONCRETE_SLAB = block(IndustrialEconomyModBlocks.PURPLE_CONCRETE_SLAB,
			CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Item> PURPLE_CONCRETE_STAIRS = block(IndustrialEconomyModBlocks.PURPLE_CONCRETE_STAIRS,
			CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Item> BLUE_CONCRETE_SLAB = block(IndustrialEconomyModBlocks.BLUE_CONCRETE_SLAB,
			CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Item> BLUE_CONCRETE_STAIRS = block(IndustrialEconomyModBlocks.BLUE_CONCRETE_STAIRS,
			CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Item> BROWN_CONCRETE_SLAB = block(IndustrialEconomyModBlocks.BROWN_CONCRETE_SLAB,
			CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Item> BROWN_CONCRETE_STAIRS = block(IndustrialEconomyModBlocks.BROWN_CONCRETE_STAIRS,
			CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Item> GREEN_CONCRETE_SLAB = block(IndustrialEconomyModBlocks.GREEN_CONCRETE_SLAB,
			CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Item> GREEN_CONCRETE_STAIRS = block(IndustrialEconomyModBlocks.GREEN_CONCRETE_STAIRS,
			CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Item> RED_CONCRETE_SLAB = block(IndustrialEconomyModBlocks.RED_CONCRETE_SLAB,
			CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Item> RED_CONCRETE_STAIRS = block(IndustrialEconomyModBlocks.RED_CONCRETE_STAIRS,
			CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Item> BLACK_CONCRETE_SLAB = block(IndustrialEconomyModBlocks.BLACK_CONCRETE_SLAB,
			CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Item> BLACK_CONCRETE_STAIRS = block(IndustrialEconomyModBlocks.BLACK_CONCRETE_STAIRS,
			CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Item> EMPTYMODULE = REGISTRY.register("emptymodule", () -> new EmptymoduleItem());
	public static final RegistryObject<Item> INDUSTRIAL_DIAMOND = REGISTRY.register("industrial_diamond", () -> new IndustrialDiamondItem());
	public static final RegistryObject<Item> DIAMOND_STEEL_H_OE = REGISTRY.register("diamond_steel_h_oe", () -> new DiamondSteelHOeItem());
	public static final RegistryObject<Item> AUTO_SELL = block(IndustrialEconomyModBlocks.AUTO_SELL, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Item> PLASMA_RANGEDITEM = REGISTRY.register("plasma_rangeditem", () -> new PlasmaRANGEDITEMItem());
	public static final RegistryObject<Item> SPACE_SUIT_HELMET = REGISTRY.register("space_suit_helmet", () -> new SpaceSuitItem.Helmet());
	public static final RegistryObject<Item> SPACE_SUIT_CHESTPLATE = REGISTRY.register("space_suit_chestplate", () -> new SpaceSuitItem.Chestplate());
	public static final RegistryObject<Item> SPACE_SUIT_LEGGINGS = REGISTRY.register("space_suit_leggings", () -> new SpaceSuitItem.Leggings());
	public static final RegistryObject<Item> SPACE_SUIT_BOOTS = REGISTRY.register("space_suit_boots", () -> new SpaceSuitItem.Boots());
	public static final RegistryObject<Item> OXYGENCANISTER = REGISTRY.register("oxygencanister", () -> new OxygencanisterItem());
	public static final RegistryObject<Item> COMPRESSOR = block(IndustrialEconomyModBlocks.COMPRESSOR, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Item> SPACE_SUIT_WITH_CANISTER_CHESTPLATE = REGISTRY.register("space_suit_with_canister_chestplate",
			() -> new SpaceSuitWithCanisterItem.Chestplate());
	public static final RegistryObject<Item> STEEL_DUST = REGISTRY.register("steel_dust", () -> new SteelDustItem());
	public static final RegistryObject<Item> STEEL_STONE = block(IndustrialEconomyModBlocks.STEEL_STONE, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Item> LIQUID_HYDROGEN_BUCKET = REGISTRY.register("liquid_hydrogen_bucket", () -> new LiquidHydrogenItem());
	public static final RegistryObject<Item> CRYSTAL = block(IndustrialEconomyModBlocks.CRYSTAL, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Item> CRYSTALCHUNK = REGISTRY.register("crystalchunk", () -> new CrystalchunkItem());
	public static final RegistryObject<Item> MONEY_100 = REGISTRY.register("money_100", () -> new Money100Item());
	public static final RegistryObject<Item> MONEY_500 = REGISTRY.register("money_500", () -> new Money500Item());
	public static final RegistryObject<Item> MONEY_1000 = REGISTRY.register("money_1000", () -> new Money1000Item());
	public static final RegistryObject<Item> MONEY_2000 = REGISTRY.register("money_2000", () -> new Money2000Item());
	public static final RegistryObject<Item> MONEY_5000 = REGISTRY.register("money_5000", () -> new Money5000Item());
	public static final RegistryObject<Item> MONEY_10000 = REGISTRY.register("money_10000", () -> new Money10000Item());
	public static final RegistryObject<Item> MONEY_50000 = REGISTRY.register("money_50000", () -> new Money50000Item());
	public static final RegistryObject<Item> MONEY_100000 = REGISTRY.register("money_100000", () -> new Money100000Item());
	public static final RegistryObject<Item> STEEL_TOOL_S_PICKAXE = REGISTRY.register("steel_tool_s_pickaxe", () -> new SteelToolSPickaxeItem());
	public static final RegistryObject<Item> STEEL_TOOL_S_AXE = REGISTRY.register("steel_tool_s_axe", () -> new SteelToolSAxeItem());
	public static final RegistryObject<Item> STEEL_TOOL_S_SWORD = REGISTRY.register("steel_tool_s_sword", () -> new SteelToolSSwordItem());
	public static final RegistryObject<Item> STEEL_TOOL_S_SHOVEL = REGISTRY.register("steel_tool_s_shovel", () -> new SteelToolSShovelItem());
	public static final RegistryObject<Item> STEEL_TOOL_S_HOE = REGISTRY.register("steel_tool_s_hoe", () -> new SteelToolSHoeItem());
	public static final RegistryObject<Item> MAM = block(IndustrialEconomyModBlocks.MAM, IndustrialEconomyModTabs.TAB_PROJECT_MEGA);
	public static final RegistryObject<Item> MA_MPART = block(IndustrialEconomyModBlocks.MA_MPART, IndustrialEconomyModTabs.TAB_PROJECT_MEGA);
	public static final RegistryObject<Item> ELECTRIC_FURNANCE_MK_1 = block(IndustrialEconomyModBlocks.ELECTRIC_FURNANCE_MK_1,
			IndustrialEconomyModTabs.TAB_PROJECT_MEGA);
	public static final RegistryObject<Item> BLACK_OPAL = REGISTRY.register("black_opal", () -> new BlackOpalItem());
	public static final RegistryObject<Item> HEAVY_DIAMOND_STEEL = block(IndustrialEconomyModBlocks.HEAVY_DIAMOND_STEEL,
			IndustrialEconomyModTabs.TAB_PROJECT_MEGA);
	public static final RegistryObject<Item> PRESSER_MK_2 = block(IndustrialEconomyModBlocks.PRESSER_MK_2, IndustrialEconomyModTabs.TAB_PROJECT_MEGA);
	public static final RegistryObject<Item> GENERATORMK_3 = block(IndustrialEconomyModBlocks.GENERATORMK_3,
			IndustrialEconomyModTabs.TAB_PROJECT_MEGA);
	public static final RegistryObject<Item> BLACK_OPAL_INGOT = REGISTRY.register("black_opal_ingot", () -> new BlackOpalIngotItem());
	public static final RegistryObject<Item> INDUSTIAL_DIAMOND_BLOCK = block(IndustrialEconomyModBlocks.INDUSTIAL_DIAMOND_BLOCK,
			IndustrialEconomyModTabs.TAB_PROJECT_MEGA);
	public static final RegistryObject<Item> TWO_CORE_CPU = REGISTRY.register("two_core_cpu", () -> new TwoCoreCPUItem());
	public static final RegistryObject<Item> FOUR_CORE_CPU = REGISTRY.register("four_core_cpu", () -> new FourCoreCPUItem());
	public static final RegistryObject<Item> CONSTRUCTOR_MK_2 = block(IndustrialEconomyModBlocks.CONSTRUCTOR_MK_2,
			IndustrialEconomyModTabs.TAB_PROJECT_MEGA);
	public static final RegistryObject<Item> CENTRAL_STORAGE = block(IndustrialEconomyModBlocks.CENTRAL_STORAGE,
			IndustrialEconomyModTabs.TAB_PROJECT_MEGA);
	public static final RegistryObject<Item> CENTRAL_STORAGE_CHEST = block(IndustrialEconomyModBlocks.CENTRAL_STORAGE_CHEST,
			IndustrialEconomyModTabs.TAB_PROJECT_MEGA);
	public static final RegistryObject<Item> MANUFACTURER = block(IndustrialEconomyModBlocks.MANUFACTURER, IndustrialEconomyModTabs.TAB_PROJECT_MEGA);
	public static final RegistryObject<Item> EIGHT_CORE_CPU = REGISTRY.register("eight_core_cpu", () -> new EightCoreCPUItem());
	public static final RegistryObject<Item> SIXTEEN_CORE_CPU = REGISTRY.register("sixteen_core_cpu", () -> new SixteenCoreCPUItem());
	public static final RegistryObject<Item> THIRTYTWO_CORE_CPU = REGISTRY.register("thirtytwo_core_cpu", () -> new ThirtytwoCoreCPUItem());
	public static final RegistryObject<Item> SIXTY_FOUR_CORE_CPU = REGISTRY.register("sixty_four_core_cpu", () -> new SixtyFourCoreCPUItem());
	public static final RegistryObject<Item> ONE_HUNDRED_TWENTY_EIGHT_CORE_CPU = REGISTRY.register("one_hundred_twenty_eight_core_cpu",
			() -> new OneHundredTwentyEightCoreCPUItem());
	public static final RegistryObject<Item> TWO_HUNDRED_FIFTY_SIX_CORE_CPU = REGISTRY.register("two_hundred_fifty_six_core_cpu",
			() -> new TwoHundredFiftySixCoreCPUItem());
	public static final RegistryObject<Item> PLACE_TOOL = REGISTRY.register("place_tool", () -> new PlaceToolItem());
	public static final RegistryObject<Item> COPPER_FOUNDATION = REGISTRY.register("copper_foundation", () -> new CopperFoundationItem());
	public static final RegistryObject<Item> POWERWIRE = REGISTRY.register("powerwire", () -> new PowerwireItem());
	public static final RegistryObject<Item> INDUCTION_BLOCK = block(IndustrialEconomyModBlocks.INDUCTION_BLOCK,
			IndustrialEconomyModTabs.TAB_PROJECT_MEGA);
	public static final RegistryObject<Item> PARTICLE_ACCELERATOR = block(IndustrialEconomyModBlocks.PARTICLE_ACCELERATOR,
			IndustrialEconomyModTabs.TAB_PROJECT_MEGA);
	public static final RegistryObject<Item> DIAMOND_STEEL_NUGGET = REGISTRY.register("diamond_steel_nugget", () -> new DiamondSteelNuggetItem());
	public static final RegistryObject<Item> TURBO_FUEL_MK_4 = REGISTRY.register("turbo_fuel_mk_4", () -> new TurboFuelMK4Item());
	public static final RegistryObject<Item> TESTDIMENSION = REGISTRY.register("testdimension", () -> new TestdimensionItem());

	private static RegistryObject<Item> block(RegistryObject<Block> block, CreativeModeTab tab) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
	}
}
