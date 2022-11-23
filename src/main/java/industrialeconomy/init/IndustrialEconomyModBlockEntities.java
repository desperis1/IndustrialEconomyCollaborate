
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package industrialeconomy.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.Block;

import industrialeconomy.block.entity.SolarpanelblockinactiveBlockEntity;
import industrialeconomy.block.entity.SolarpanelblockactiveBlockEntity;
import industrialeconomy.block.entity.SandstoneextractorBlockEntity;
import industrialeconomy.block.entity.PresserblockBlockEntity;
import industrialeconomy.block.entity.PresserMK2BlockEntity;
import industrialeconomy.block.entity.ParticleAcceleratorBlockEntity;
import industrialeconomy.block.entity.MinerinactiveBlockEntity;
import industrialeconomy.block.entity.MinerblockBlockEntity;
import industrialeconomy.block.entity.ManufacturerBlockEntity;
import industrialeconomy.block.entity.MAMBlockEntity;
import industrialeconomy.block.entity.LimestoneinactiveBlockEntity;
import industrialeconomy.block.entity.LimestoneactiveBlockEntity;
import industrialeconomy.block.entity.IronextractorBlockEntity;
import industrialeconomy.block.entity.IronOreNodeBlockInactiveBlockEntity;
import industrialeconomy.block.entity.IronOreNodeBlockBlockEntity;
import industrialeconomy.block.entity.HubBlockEntity;
import industrialeconomy.block.entity.Generatormk3BlockEntity;
import industrialeconomy.block.entity.Generatormk2BlockEntity;
import industrialeconomy.block.entity.GeneratorMK1BlockEntity;
import industrialeconomy.block.entity.FoundyblockBlockEntity;
import industrialeconomy.block.entity.Energyplazmamk2BlockEntity;
import industrialeconomy.block.entity.EnergyplazmaBlockEntity;
import industrialeconomy.block.entity.ElectricFurnanceMK1BlockEntity;
import industrialeconomy.block.entity.ElectricFurnanceBlockBlockEntity;
import industrialeconomy.block.entity.ElectricFunanceinactiveBlockEntity;
import industrialeconomy.block.entity.CopperNodeInactveBlockEntity;
import industrialeconomy.block.entity.CopperNodeBlockEntity;
import industrialeconomy.block.entity.CopperExtractorBlockEntity;
import industrialeconomy.block.entity.ConstructorblockBlockEntity;
import industrialeconomy.block.entity.ConstructorMK2BlockEntity;
import industrialeconomy.block.entity.ConcretemixerBlockEntity;
import industrialeconomy.block.entity.CompressorBlockEntity;
import industrialeconomy.block.entity.CoalNodeInactiveBlockEntity;
import industrialeconomy.block.entity.CoalNodeBlockEntity;
import industrialeconomy.block.entity.CoalExtractorBlockEntity;
import industrialeconomy.block.entity.ChargerblockBlockEntity;
import industrialeconomy.block.entity.CentralStorageChestBlockEntity;
import industrialeconomy.block.entity.CentralStorageBlockEntity;
import industrialeconomy.block.entity.CateriumNodeBlockInactiveBlockEntity;
import industrialeconomy.block.entity.CateriumNODEblockBlockEntity;
import industrialeconomy.block.entity.CateriumExtractorBlockEntity;
import industrialeconomy.block.entity.AutoSellBlockEntity;
import industrialeconomy.block.entity.AssemblerblockBlockEntity;
import industrialeconomy.block.entity.Armorchargermk2BlockEntity;

import industrialeconomy.IndustrialEconomyMod;

public class IndustrialEconomyModBlockEntities {
	public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES,
			IndustrialEconomyMod.MODID);
	public static final RegistryObject<BlockEntityType<?>> CATERIUM_NOD_EBLOCK = register("caterium_nod_eblock",
			IndustrialEconomyModBlocks.CATERIUM_NOD_EBLOCK, CateriumNODEblockBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> CATERIUM_NODE_BLOCK_INACTIVE = register("caterium_node_block_inactive",
			IndustrialEconomyModBlocks.CATERIUM_NODE_BLOCK_INACTIVE, CateriumNodeBlockInactiveBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> IRON_ORE_NODE_BLOCK = register("iron_ore_node_block",
			IndustrialEconomyModBlocks.IRON_ORE_NODE_BLOCK, IronOreNodeBlockBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> IRON_ORE_NODE_BLOCK_INACTIVE = register("iron_ore_node_block_inactive",
			IndustrialEconomyModBlocks.IRON_ORE_NODE_BLOCK_INACTIVE, IronOreNodeBlockInactiveBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> COAL_NODE = register("coal_node", IndustrialEconomyModBlocks.COAL_NODE,
			CoalNodeBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> COAL_NODE_INACTIVE = register("coal_node_inactive",
			IndustrialEconomyModBlocks.COAL_NODE_INACTIVE, CoalNodeInactiveBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> HUB = register("hub", IndustrialEconomyModBlocks.HUB, HubBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> MINERBLOCK = register("minerblock", IndustrialEconomyModBlocks.MINERBLOCK,
			MinerblockBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> GENERATOR_MK_1 = register("generator_mk_1", IndustrialEconomyModBlocks.GENERATOR_MK_1,
			GeneratorMK1BlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> CONSTRUCTORBLOCK = register("constructorblock",
			IndustrialEconomyModBlocks.CONSTRUCTORBLOCK, ConstructorblockBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> COPPER_NODE = register("copper_node", IndustrialEconomyModBlocks.COPPER_NODE,
			CopperNodeBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> COPPER_NODE_INACTVE = register("copper_node_inactve",
			IndustrialEconomyModBlocks.COPPER_NODE_INACTVE, CopperNodeInactveBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> CHARGERBLOCK = register("chargerblock", IndustrialEconomyModBlocks.CHARGERBLOCK,
			ChargerblockBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> FOUNDYBLOCK = register("foundyblock", IndustrialEconomyModBlocks.FOUNDYBLOCK,
			FoundyblockBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> PRESSERBLOCK = register("presserblock", IndustrialEconomyModBlocks.PRESSERBLOCK,
			PresserblockBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> GENERATORMK_2 = register("generatormk_2", IndustrialEconomyModBlocks.GENERATORMK_2,
			Generatormk2BlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> ELECTRIC_FURNANCE_BLOCK = register("electric_furnance_block",
			IndustrialEconomyModBlocks.ELECTRIC_FURNANCE_BLOCK, ElectricFurnanceBlockBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> IRONEXTRACTOR = register("ironextractor", IndustrialEconomyModBlocks.IRONEXTRACTOR,
			IronextractorBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> COAL_EXTRACTOR = register("coal_extractor", IndustrialEconomyModBlocks.COAL_EXTRACTOR,
			CoalExtractorBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> CATERIUM_EXTRACTOR = register("caterium_extractor",
			IndustrialEconomyModBlocks.CATERIUM_EXTRACTOR, CateriumExtractorBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> COPPER_EXTRACTOR = register("copper_extractor",
			IndustrialEconomyModBlocks.COPPER_EXTRACTOR, CopperExtractorBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> MINERINACTIVE = register("minerinactive", IndustrialEconomyModBlocks.MINERINACTIVE,
			MinerinactiveBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> ELECTRIC_FUNANCEINACTIVE = register("electric_funanceinactive",
			IndustrialEconomyModBlocks.ELECTRIC_FUNANCEINACTIVE, ElectricFunanceinactiveBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> SOLARPANELBLOCKACTIVE = register("solarpanelblockactive",
			IndustrialEconomyModBlocks.SOLARPANELBLOCKACTIVE, SolarpanelblockactiveBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> SOLARPANELBLOCKINACTIVE = register("solarpanelblockinactive",
			IndustrialEconomyModBlocks.SOLARPANELBLOCKINACTIVE, SolarpanelblockinactiveBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> ASSEMBLERBLOCK = register("assemblerblock", IndustrialEconomyModBlocks.ASSEMBLERBLOCK,
			AssemblerblockBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> LIMESTONEACTIVE = register("limestoneactive", IndustrialEconomyModBlocks.LIMESTONEACTIVE,
			LimestoneactiveBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> LIMESTONEINACTIVE = register("limestoneinactive",
			IndustrialEconomyModBlocks.LIMESTONEINACTIVE, LimestoneinactiveBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> CONCRETEMIXER = register("concretemixer", IndustrialEconomyModBlocks.CONCRETEMIXER,
			ConcretemixerBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> SANDSTONEEXTRACTOR = register("sandstoneextractor",
			IndustrialEconomyModBlocks.SANDSTONEEXTRACTOR, SandstoneextractorBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> ENERGYPLAZMA = register("energyplazma", IndustrialEconomyModBlocks.ENERGYPLAZMA,
			EnergyplazmaBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> ARMORCHARGERMK_2 = register("armorchargermk_2",
			IndustrialEconomyModBlocks.ARMORCHARGERMK_2, Armorchargermk2BlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> ENERGYPLAZMAMK_2 = register("energyplazmamk_2",
			IndustrialEconomyModBlocks.ENERGYPLAZMAMK_2, Energyplazmamk2BlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> AUTO_SELL = register("auto_sell", IndustrialEconomyModBlocks.AUTO_SELL,
			AutoSellBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> COMPRESSOR = register("compressor", IndustrialEconomyModBlocks.COMPRESSOR,
			CompressorBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> MAM = register("mam", IndustrialEconomyModBlocks.MAM, MAMBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> ELECTRIC_FURNANCE_MK_1 = register("electric_furnance_mk_1",
			IndustrialEconomyModBlocks.ELECTRIC_FURNANCE_MK_1, ElectricFurnanceMK1BlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> PRESSER_MK_2 = register("presser_mk_2", IndustrialEconomyModBlocks.PRESSER_MK_2,
			PresserMK2BlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> GENERATORMK_3 = register("generatormk_3", IndustrialEconomyModBlocks.GENERATORMK_3,
			Generatormk3BlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> CONSTRUCTOR_MK_2 = register("constructor_mk_2",
			IndustrialEconomyModBlocks.CONSTRUCTOR_MK_2, ConstructorMK2BlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> CENTRAL_STORAGE = register("central_storage", IndustrialEconomyModBlocks.CENTRAL_STORAGE,
			CentralStorageBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> CENTRAL_STORAGE_CHEST = register("central_storage_chest",
			IndustrialEconomyModBlocks.CENTRAL_STORAGE_CHEST, CentralStorageChestBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> MANUFACTURER = register("manufacturer", IndustrialEconomyModBlocks.MANUFACTURER,
			ManufacturerBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> PARTICLE_ACCELERATOR = register("particle_accelerator",
			IndustrialEconomyModBlocks.PARTICLE_ACCELERATOR, ParticleAcceleratorBlockEntity::new);

	private static RegistryObject<BlockEntityType<?>> register(String registryname, RegistryObject<Block> block,
			BlockEntityType.BlockEntitySupplier<?> supplier) {
		return REGISTRY.register(registryname, () -> BlockEntityType.Builder.of(supplier, block.get()).build(null));
	}
}
