
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package industrialeconomy.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;

import industrialeconomy.block.YellowConcreteStairsBlock;
import industrialeconomy.block.YellowConcreteSlabBlock;
import industrialeconomy.block.WhiteConcreteStairsBlock;
import industrialeconomy.block.WhiteConcreteSlabBlock;
import industrialeconomy.block.TestdimensionPortalBlock;
import industrialeconomy.block.SteelStoneBlock;
import industrialeconomy.block.SteelBlockBlock;
import industrialeconomy.block.SolarpanelblockinactiveBlock;
import industrialeconomy.block.SolarpanelblockactiveBlock;
import industrialeconomy.block.SandstoneextractorBlock;
import industrialeconomy.block.RedConcreteStairsBlock;
import industrialeconomy.block.RedConcreteSlabBlock;
import industrialeconomy.block.PurpleConcreteStairsBlock;
import industrialeconomy.block.PurpleConcreteSlabBlock;
import industrialeconomy.block.PresserblockBlock;
import industrialeconomy.block.PresserMK2Block;
import industrialeconomy.block.Position2blockBlock;
import industrialeconomy.block.Position1blockBlock;
import industrialeconomy.block.PinkConcreteStairsBlock;
import industrialeconomy.block.PinkConcreteSlabBlock;
import industrialeconomy.block.ParticleAcceleratorBlock;
import industrialeconomy.block.OrangeConcreteStairsBlock;
import industrialeconomy.block.OrangeConcreteSlabBlock;
import industrialeconomy.block.ModularframeBlock;
import industrialeconomy.block.MinerinactiveBlock;
import industrialeconomy.block.MinerblockBlock;
import industrialeconomy.block.MarkblockBlock;
import industrialeconomy.block.ManufacturerBlock;
import industrialeconomy.block.MagentaConcreteStairsBlock;
import industrialeconomy.block.MagentaConcreteSlabBlock;
import industrialeconomy.block.MAMpartBlock;
import industrialeconomy.block.MAMBlock;
import industrialeconomy.block.LiquidHydrogenBlock;
import industrialeconomy.block.LimestoneinactiveBlock;
import industrialeconomy.block.LimestoneactiveBlock;
import industrialeconomy.block.LimeConcreteStairsBlock;
import industrialeconomy.block.LimeConcreteSlabBlock;
import industrialeconomy.block.LightGrayConcreteStairsBlock;
import industrialeconomy.block.LightGrayConcreteSlabBlock;
import industrialeconomy.block.LightBlueConcreteStairsBlock;
import industrialeconomy.block.LightBlueConcreteSlabBlock;
import industrialeconomy.block.IronextractorBlock;
import industrialeconomy.block.IronOreNodeBlockInactiveBlock;
import industrialeconomy.block.IronOreNodeBlockBlock;
import industrialeconomy.block.IndustialDiamondBlockBlock;
import industrialeconomy.block.InductionBlockBlock;
import industrialeconomy.block.HubBlock;
import industrialeconomy.block.HeavyironblockBlock;
import industrialeconomy.block.HeavyframeBlock;
import industrialeconomy.block.HeavyDiamondSteelBlock;
import industrialeconomy.block.HardenedcobbleBlock;
import industrialeconomy.block.GreenConcreteStairsBlock;
import industrialeconomy.block.GreenConcreteSlabBlock;
import industrialeconomy.block.GrayConcreteStairsBlock;
import industrialeconomy.block.GrayConcreteSlabBlock;
import industrialeconomy.block.Generatormk3Block;
import industrialeconomy.block.Generatormk2Block;
import industrialeconomy.block.GeneratorMK1Block;
import industrialeconomy.block.FoundyblockBlock;
import industrialeconomy.block.Energyplazmamk2Block;
import industrialeconomy.block.EnergyplazmaBlock;
import industrialeconomy.block.ElectricFurnanceMK1Block;
import industrialeconomy.block.ElectricFurnanceBlockBlock;
import industrialeconomy.block.ElectricFunanceinactiveBlock;
import industrialeconomy.block.DiamondSteelblockBlock;
import industrialeconomy.block.CyanConcreteStairsBlock;
import industrialeconomy.block.CyanConcreteSlabBlock;
import industrialeconomy.block.CrystalBlock;
import industrialeconomy.block.CrusherBlock;
import industrialeconomy.block.CopperOreBlock;
import industrialeconomy.block.CopperNodeInactveBlock;
import industrialeconomy.block.CopperNodeBlock;
import industrialeconomy.block.CopperExtractorBlock;
import industrialeconomy.block.CopperBlockBlock;
import industrialeconomy.block.ConstructorblockBlock;
import industrialeconomy.block.ConstructorMK2Block;
import industrialeconomy.block.ConcretemixerBlock;
import industrialeconomy.block.CompressorBlock;
import industrialeconomy.block.CoalNodeInactiveBlock;
import industrialeconomy.block.CoalNodeBlock;
import industrialeconomy.block.CoalExtractorBlock;
import industrialeconomy.block.ChargerblockBlock;
import industrialeconomy.block.CentralStorageChestBlock;
import industrialeconomy.block.CentralStorageBlock;
import industrialeconomy.block.CateriumOreBlock;
import industrialeconomy.block.CateriumNodeBlockInactiveBlock;
import industrialeconomy.block.CateriumNODEblockBlock;
import industrialeconomy.block.CateriumExtractorBlock;
import industrialeconomy.block.CateriumBlockBlock;
import industrialeconomy.block.BuilderPreviewblockBlock;
import industrialeconomy.block.BrownConcreteStairsBlock;
import industrialeconomy.block.BrownConcreteSlabBlock;
import industrialeconomy.block.BlueConcreteStairsBlock;
import industrialeconomy.block.BlueConcreteSlabBlock;
import industrialeconomy.block.BlackConcreteStairsBlock;
import industrialeconomy.block.BlackConcreteSlabBlock;
import industrialeconomy.block.AutoSellBlock;
import industrialeconomy.block.AssemblerblockBlock;
import industrialeconomy.block.Armorchargermk2Block;
import industrialeconomy.block.ArmorchargerBlock;

import industrialeconomy.IndustrialEconomyMod;

public class IndustrialEconomyModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, IndustrialEconomyMod.MODID);
	public static final RegistryObject<Block> CATERIUM_ORE = REGISTRY.register("caterium_ore", () -> new CateriumOreBlock());
	public static final RegistryObject<Block> CATERIUM_BLOCK = REGISTRY.register("caterium_block", () -> new CateriumBlockBlock());
	public static final RegistryObject<Block> CATERIUM_NOD_EBLOCK = REGISTRY.register("caterium_nod_eblock", () -> new CateriumNODEblockBlock());
	public static final RegistryObject<Block> CATERIUM_NODE_BLOCK_INACTIVE = REGISTRY.register("caterium_node_block_inactive",
			() -> new CateriumNodeBlockInactiveBlock());
	public static final RegistryObject<Block> IRON_ORE_NODE_BLOCK = REGISTRY.register("iron_ore_node_block", () -> new IronOreNodeBlockBlock());
	public static final RegistryObject<Block> IRON_ORE_NODE_BLOCK_INACTIVE = REGISTRY.register("iron_ore_node_block_inactive",
			() -> new IronOreNodeBlockInactiveBlock());
	public static final RegistryObject<Block> COPPER_ORE = REGISTRY.register("copper_ore", () -> new CopperOreBlock());
	public static final RegistryObject<Block> COPPER_BLOCK = REGISTRY.register("copper_block", () -> new CopperBlockBlock());
	public static final RegistryObject<Block> COAL_NODE = REGISTRY.register("coal_node", () -> new CoalNodeBlock());
	public static final RegistryObject<Block> COAL_NODE_INACTIVE = REGISTRY.register("coal_node_inactive", () -> new CoalNodeInactiveBlock());
	public static final RegistryObject<Block> HUB = REGISTRY.register("hub", () -> new HubBlock());
	public static final RegistryObject<Block> MINERBLOCK = REGISTRY.register("minerblock", () -> new MinerblockBlock());
	public static final RegistryObject<Block> GENERATOR_MK_1 = REGISTRY.register("generator_mk_1", () -> new GeneratorMK1Block());
	public static final RegistryObject<Block> CONSTRUCTORBLOCK = REGISTRY.register("constructorblock", () -> new ConstructorblockBlock());
	public static final RegistryObject<Block> COPPER_NODE = REGISTRY.register("copper_node", () -> new CopperNodeBlock());
	public static final RegistryObject<Block> COPPER_NODE_INACTVE = REGISTRY.register("copper_node_inactve", () -> new CopperNodeInactveBlock());
	public static final RegistryObject<Block> CHARGERBLOCK = REGISTRY.register("chargerblock", () -> new ChargerblockBlock());
	public static final RegistryObject<Block> FOUNDYBLOCK = REGISTRY.register("foundyblock", () -> new FoundyblockBlock());
	public static final RegistryObject<Block> STEEL_BLOCK = REGISTRY.register("steel_block", () -> new SteelBlockBlock());
	public static final RegistryObject<Block> DIAMOND_STEELBLOCK = REGISTRY.register("diamond_steelblock", () -> new DiamondSteelblockBlock());
	public static final RegistryObject<Block> PRESSERBLOCK = REGISTRY.register("presserblock", () -> new PresserblockBlock());
	public static final RegistryObject<Block> GENERATORMK_2 = REGISTRY.register("generatormk_2", () -> new Generatormk2Block());
	public static final RegistryObject<Block> ELECTRIC_FURNANCE_BLOCK = REGISTRY.register("electric_furnance_block",
			() -> new ElectricFurnanceBlockBlock());
	public static final RegistryObject<Block> IRONEXTRACTOR = REGISTRY.register("ironextractor", () -> new IronextractorBlock());
	public static final RegistryObject<Block> COAL_EXTRACTOR = REGISTRY.register("coal_extractor", () -> new CoalExtractorBlock());
	public static final RegistryObject<Block> CATERIUM_EXTRACTOR = REGISTRY.register("caterium_extractor", () -> new CateriumExtractorBlock());
	public static final RegistryObject<Block> COPPER_EXTRACTOR = REGISTRY.register("copper_extractor", () -> new CopperExtractorBlock());
	public static final RegistryObject<Block> HARDENEDCOBBLE = REGISTRY.register("hardenedcobble", () -> new HardenedcobbleBlock());
	public static final RegistryObject<Block> MINERINACTIVE = REGISTRY.register("minerinactive", () -> new MinerinactiveBlock());
	public static final RegistryObject<Block> ELECTRIC_FUNANCEINACTIVE = REGISTRY.register("electric_funanceinactive",
			() -> new ElectricFunanceinactiveBlock());
	public static final RegistryObject<Block> HEAVYIRONBLOCK = REGISTRY.register("heavyironblock", () -> new HeavyironblockBlock());
	public static final RegistryObject<Block> SOLARPANELBLOCKACTIVE = REGISTRY.register("solarpanelblockactive",
			() -> new SolarpanelblockactiveBlock());
	public static final RegistryObject<Block> SOLARPANELBLOCKINACTIVE = REGISTRY.register("solarpanelblockinactive",
			() -> new SolarpanelblockinactiveBlock());
	public static final RegistryObject<Block> MODULARFRAME = REGISTRY.register("modularframe", () -> new ModularframeBlock());
	public static final RegistryObject<Block> HEAVYFRAME = REGISTRY.register("heavyframe", () -> new HeavyframeBlock());
	public static final RegistryObject<Block> ASSEMBLERBLOCK = REGISTRY.register("assemblerblock", () -> new AssemblerblockBlock());
	public static final RegistryObject<Block> MARKBLOCK = REGISTRY.register("markblock", () -> new MarkblockBlock());
	public static final RegistryObject<Block> LIMESTONEACTIVE = REGISTRY.register("limestoneactive", () -> new LimestoneactiveBlock());
	public static final RegistryObject<Block> LIMESTONEINACTIVE = REGISTRY.register("limestoneinactive", () -> new LimestoneinactiveBlock());
	public static final RegistryObject<Block> CONCRETEMIXER = REGISTRY.register("concretemixer", () -> new ConcretemixerBlock());
	public static final RegistryObject<Block> SANDSTONEEXTRACTOR = REGISTRY.register("sandstoneextractor", () -> new SandstoneextractorBlock());
	public static final RegistryObject<Block> POSITION_1BLOCK = REGISTRY.register("position_1block", () -> new Position1blockBlock());
	public static final RegistryObject<Block> POSITION_2BLOCK = REGISTRY.register("position_2block", () -> new Position2blockBlock());
	public static final RegistryObject<Block> BUILDER_PREVIEWBLOCK = REGISTRY.register("builder_previewblock", () -> new BuilderPreviewblockBlock());
	public static final RegistryObject<Block> ARMORCHARGER = REGISTRY.register("armorcharger", () -> new ArmorchargerBlock());
	public static final RegistryObject<Block> ENERGYPLAZMA = REGISTRY.register("energyplazma", () -> new EnergyplazmaBlock());
	public static final RegistryObject<Block> CRUSHER = REGISTRY.register("crusher", () -> new CrusherBlock());
	public static final RegistryObject<Block> ARMORCHARGERMK_2 = REGISTRY.register("armorchargermk_2", () -> new Armorchargermk2Block());
	public static final RegistryObject<Block> ENERGYPLAZMAMK_2 = REGISTRY.register("energyplazmamk_2", () -> new Energyplazmamk2Block());
	public static final RegistryObject<Block> WHITE_CONCRETE_SLAB = REGISTRY.register("white_concrete_slab", () -> new WhiteConcreteSlabBlock());
	public static final RegistryObject<Block> WHITE_CONCRETE_STAIRS = REGISTRY.register("white_concrete_stairs",
			() -> new WhiteConcreteStairsBlock());
	public static final RegistryObject<Block> ORANGE_CONCRETE_SLAB = REGISTRY.register("orange_concrete_slab", () -> new OrangeConcreteSlabBlock());
	public static final RegistryObject<Block> ORANGE_CONCRETE_STAIRS = REGISTRY.register("orange_concrete_stairs",
			() -> new OrangeConcreteStairsBlock());
	public static final RegistryObject<Block> MAGENTA_CONCRETE_SLAB = REGISTRY.register("magenta_concrete_slab",
			() -> new MagentaConcreteSlabBlock());
	public static final RegistryObject<Block> MAGENTA_CONCRETE_STAIRS = REGISTRY.register("magenta_concrete_stairs",
			() -> new MagentaConcreteStairsBlock());
	public static final RegistryObject<Block> LIGHT_BLUE_CONCRETE_SLAB = REGISTRY.register("light_blue_concrete_slab",
			() -> new LightBlueConcreteSlabBlock());
	public static final RegistryObject<Block> LIGHT_BLUE_CONCRETE_STAIRS = REGISTRY.register("light_blue_concrete_stairs",
			() -> new LightBlueConcreteStairsBlock());
	public static final RegistryObject<Block> YELLOW_CONCRETE_SLAB = REGISTRY.register("yellow_concrete_slab", () -> new YellowConcreteSlabBlock());
	public static final RegistryObject<Block> YELLOW_CONCRETE_STAIRS = REGISTRY.register("yellow_concrete_stairs",
			() -> new YellowConcreteStairsBlock());
	public static final RegistryObject<Block> LIME_CONCRETE_SLAB = REGISTRY.register("lime_concrete_slab", () -> new LimeConcreteSlabBlock());
	public static final RegistryObject<Block> LIME_CONCRETE_STAIRS = REGISTRY.register("lime_concrete_stairs", () -> new LimeConcreteStairsBlock());
	public static final RegistryObject<Block> PINK_CONCRETE_SLAB = REGISTRY.register("pink_concrete_slab", () -> new PinkConcreteSlabBlock());
	public static final RegistryObject<Block> PINK_CONCRETE_STAIRS = REGISTRY.register("pink_concrete_stairs", () -> new PinkConcreteStairsBlock());
	public static final RegistryObject<Block> GRAY_CONCRETE_SLAB = REGISTRY.register("gray_concrete_slab", () -> new GrayConcreteSlabBlock());
	public static final RegistryObject<Block> GRAY_CONCRETE_STAIRS = REGISTRY.register("gray_concrete_stairs", () -> new GrayConcreteStairsBlock());
	public static final RegistryObject<Block> LIGHT_GRAY_CONCRETE_SLAB = REGISTRY.register("light_gray_concrete_slab",
			() -> new LightGrayConcreteSlabBlock());
	public static final RegistryObject<Block> LIGHT_GRAY_CONCRETE_STAIRS = REGISTRY.register("light_gray_concrete_stairs",
			() -> new LightGrayConcreteStairsBlock());
	public static final RegistryObject<Block> CYAN_CONCRETE_SLAB = REGISTRY.register("cyan_concrete_slab", () -> new CyanConcreteSlabBlock());
	public static final RegistryObject<Block> CYAN_CONCRETE_STAIRS = REGISTRY.register("cyan_concrete_stairs", () -> new CyanConcreteStairsBlock());
	public static final RegistryObject<Block> PURPLE_CONCRETE_SLAB = REGISTRY.register("purple_concrete_slab", () -> new PurpleConcreteSlabBlock());
	public static final RegistryObject<Block> PURPLE_CONCRETE_STAIRS = REGISTRY.register("purple_concrete_stairs",
			() -> new PurpleConcreteStairsBlock());
	public static final RegistryObject<Block> BLUE_CONCRETE_SLAB = REGISTRY.register("blue_concrete_slab", () -> new BlueConcreteSlabBlock());
	public static final RegistryObject<Block> BLUE_CONCRETE_STAIRS = REGISTRY.register("blue_concrete_stairs", () -> new BlueConcreteStairsBlock());
	public static final RegistryObject<Block> BROWN_CONCRETE_SLAB = REGISTRY.register("brown_concrete_slab", () -> new BrownConcreteSlabBlock());
	public static final RegistryObject<Block> BROWN_CONCRETE_STAIRS = REGISTRY.register("brown_concrete_stairs",
			() -> new BrownConcreteStairsBlock());
	public static final RegistryObject<Block> GREEN_CONCRETE_SLAB = REGISTRY.register("green_concrete_slab", () -> new GreenConcreteSlabBlock());
	public static final RegistryObject<Block> GREEN_CONCRETE_STAIRS = REGISTRY.register("green_concrete_stairs",
			() -> new GreenConcreteStairsBlock());
	public static final RegistryObject<Block> RED_CONCRETE_SLAB = REGISTRY.register("red_concrete_slab", () -> new RedConcreteSlabBlock());
	public static final RegistryObject<Block> RED_CONCRETE_STAIRS = REGISTRY.register("red_concrete_stairs", () -> new RedConcreteStairsBlock());
	public static final RegistryObject<Block> BLACK_CONCRETE_SLAB = REGISTRY.register("black_concrete_slab", () -> new BlackConcreteSlabBlock());
	public static final RegistryObject<Block> BLACK_CONCRETE_STAIRS = REGISTRY.register("black_concrete_stairs",
			() -> new BlackConcreteStairsBlock());
	public static final RegistryObject<Block> AUTO_SELL = REGISTRY.register("auto_sell", () -> new AutoSellBlock());
	public static final RegistryObject<Block> COMPRESSOR = REGISTRY.register("compressor", () -> new CompressorBlock());
	public static final RegistryObject<Block> STEEL_STONE = REGISTRY.register("steel_stone", () -> new SteelStoneBlock());
	public static final RegistryObject<Block> LIQUID_HYDROGEN = REGISTRY.register("liquid_hydrogen", () -> new LiquidHydrogenBlock());
	public static final RegistryObject<Block> CRYSTAL = REGISTRY.register("crystal", () -> new CrystalBlock());
	public static final RegistryObject<Block> MAM = REGISTRY.register("mam", () -> new MAMBlock());
	public static final RegistryObject<Block> MA_MPART = REGISTRY.register("ma_mpart", () -> new MAMpartBlock());
	public static final RegistryObject<Block> ELECTRIC_FURNANCE_MK_1 = REGISTRY.register("electric_furnance_mk_1",
			() -> new ElectricFurnanceMK1Block());
	public static final RegistryObject<Block> HEAVY_DIAMOND_STEEL = REGISTRY.register("heavy_diamond_steel", () -> new HeavyDiamondSteelBlock());
	public static final RegistryObject<Block> PRESSER_MK_2 = REGISTRY.register("presser_mk_2", () -> new PresserMK2Block());
	public static final RegistryObject<Block> GENERATORMK_3 = REGISTRY.register("generatormk_3", () -> new Generatormk3Block());
	public static final RegistryObject<Block> INDUSTIAL_DIAMOND_BLOCK = REGISTRY.register("industial_diamond_block",
			() -> new IndustialDiamondBlockBlock());
	public static final RegistryObject<Block> CONSTRUCTOR_MK_2 = REGISTRY.register("constructor_mk_2", () -> new ConstructorMK2Block());
	public static final RegistryObject<Block> CENTRAL_STORAGE = REGISTRY.register("central_storage", () -> new CentralStorageBlock());
	public static final RegistryObject<Block> CENTRAL_STORAGE_CHEST = REGISTRY.register("central_storage_chest",
			() -> new CentralStorageChestBlock());
	public static final RegistryObject<Block> MANUFACTURER = REGISTRY.register("manufacturer", () -> new ManufacturerBlock());
	public static final RegistryObject<Block> INDUCTION_BLOCK = REGISTRY.register("induction_block", () -> new InductionBlockBlock());
	public static final RegistryObject<Block> PARTICLE_ACCELERATOR = REGISTRY.register("particle_accelerator", () -> new ParticleAcceleratorBlock());
	public static final RegistryObject<Block> TESTDIMENSION_PORTAL = REGISTRY.register("testdimension_portal", () -> new TestdimensionPortalBlock());
}
