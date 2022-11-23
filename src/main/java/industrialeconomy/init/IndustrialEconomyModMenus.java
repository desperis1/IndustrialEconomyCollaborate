
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package industrialeconomy.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.extensions.IForgeMenuType;

import net.minecraft.world.inventory.MenuType;

import industrialeconomy.world.inventory.SteeldiamondguiMenu;
import industrialeconomy.world.inventory.SandstoneextractorGUIMenu;
import industrialeconomy.world.inventory.PresserMK2GUIMenu;
import industrialeconomy.world.inventory.PresserGUIMenu;
import industrialeconomy.world.inventory.PocketchestMenu;
import industrialeconomy.world.inventory.PlaceToolGUIMenu;
import industrialeconomy.world.inventory.ParticleAcceleratorGUIMenu;
import industrialeconomy.world.inventory.MinerGUIMenu;
import industrialeconomy.world.inventory.ManufacturerGUIMenu;
import industrialeconomy.world.inventory.MamGUIElectronicsOnClickMenu;
import industrialeconomy.world.inventory.MAMguiMenu;
import industrialeconomy.world.inventory.MAMGUIMAINMenu;
import industrialeconomy.world.inventory.IronextractorGUIMenu;
import industrialeconomy.world.inventory.HUBGUIMenu;
import industrialeconomy.world.inventory.Generatormk3guiMenu;
import industrialeconomy.world.inventory.GeneratorMK2GUIMenu;
import industrialeconomy.world.inventory.GeneratorMK1GuiMenu;
import industrialeconomy.world.inventory.FoundryGUIMenu;
import industrialeconomy.world.inventory.ElectricFurnancemk1guiMenu;
import industrialeconomy.world.inventory.ElectricFurnanceMenu;
import industrialeconomy.world.inventory.DiamondsteelswordguiMenu;
import industrialeconomy.world.inventory.DiamondsteelAXEguiMenu;
import industrialeconomy.world.inventory.DiamondSteelArmorGUIMenu;
import industrialeconomy.world.inventory.CopperExtracotrguiMenu;
import industrialeconomy.world.inventory.Constructormk2guiMenu;
import industrialeconomy.world.inventory.ConstructorguiMenu;
import industrialeconomy.world.inventory.ConcreteMixerGUIMenu;
import industrialeconomy.world.inventory.CompressorGUIMenu;
import industrialeconomy.world.inventory.CoalExtractorGUIMenu;
import industrialeconomy.world.inventory.ChargerguiMenu;
import industrialeconomy.world.inventory.CentralStorageGUIMenu;
import industrialeconomy.world.inventory.CentralStorageChestGUIMenu;
import industrialeconomy.world.inventory.CateriumExtracotorGUIMenu;
import industrialeconomy.world.inventory.BuilderGUIMenu;
import industrialeconomy.world.inventory.AutoSellGUIMenu;
import industrialeconomy.world.inventory.AssemblerguiMenu;
import industrialeconomy.world.inventory.AdminMenuMenu;

import industrialeconomy.IndustrialEconomyMod;

public class IndustrialEconomyModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.MENU_TYPES, IndustrialEconomyMod.MODID);
	public static final RegistryObject<MenuType<AdminMenuMenu>> ADMIN_MENU = REGISTRY.register("admin_menu",
			() -> IForgeMenuType.create(AdminMenuMenu::new));
	public static final RegistryObject<MenuType<GeneratorMK1GuiMenu>> GENERATOR_MK_1_GUI = REGISTRY.register("generator_mk_1_gui",
			() -> IForgeMenuType.create(GeneratorMK1GuiMenu::new));
	public static final RegistryObject<MenuType<ConstructorguiMenu>> CONSTRUCTORGUI = REGISTRY.register("constructorgui",
			() -> IForgeMenuType.create(ConstructorguiMenu::new));
	public static final RegistryObject<MenuType<ChargerguiMenu>> CHARGERGUI = REGISTRY.register("chargergui",
			() -> IForgeMenuType.create(ChargerguiMenu::new));
	public static final RegistryObject<MenuType<FoundryGUIMenu>> FOUNDRY_GUI = REGISTRY.register("foundry_gui",
			() -> IForgeMenuType.create(FoundryGUIMenu::new));
	public static final RegistryObject<MenuType<PresserGUIMenu>> PRESSER_GUI = REGISTRY.register("presser_gui",
			() -> IForgeMenuType.create(PresserGUIMenu::new));
	public static final RegistryObject<MenuType<GeneratorMK2GUIMenu>> GENERATOR_MK_2_GUI = REGISTRY.register("generator_mk_2_gui",
			() -> IForgeMenuType.create(GeneratorMK2GUIMenu::new));
	public static final RegistryObject<MenuType<ElectricFurnanceMenu>> ELECTRIC_FURNANCE = REGISTRY.register("electric_furnance",
			() -> IForgeMenuType.create(ElectricFurnanceMenu::new));
	public static final RegistryObject<MenuType<IronextractorGUIMenu>> IRONEXTRACTOR_GUI = REGISTRY.register("ironextractor_gui",
			() -> IForgeMenuType.create(IronextractorGUIMenu::new));
	public static final RegistryObject<MenuType<CopperExtracotrguiMenu>> COPPER_EXTRACOTRGUI = REGISTRY.register("copper_extracotrgui",
			() -> IForgeMenuType.create(CopperExtracotrguiMenu::new));
	public static final RegistryObject<MenuType<CateriumExtracotorGUIMenu>> CATERIUM_EXTRACOTOR_GUI = REGISTRY.register("caterium_extracotor_gui",
			() -> IForgeMenuType.create(CateriumExtracotorGUIMenu::new));
	public static final RegistryObject<MenuType<CoalExtractorGUIMenu>> COAL_EXTRACTOR_GUI = REGISTRY.register("coal_extractor_gui",
			() -> IForgeMenuType.create(CoalExtractorGUIMenu::new));
	public static final RegistryObject<MenuType<SteeldiamondguiMenu>> STEELDIAMONDGUI = REGISTRY.register("steeldiamondgui",
			() -> IForgeMenuType.create(SteeldiamondguiMenu::new));
	public static final RegistryObject<MenuType<DiamondsteelAXEguiMenu>> DIAMONDSTEEL_AX_EGUI = REGISTRY.register("diamondsteel_ax_egui",
			() -> IForgeMenuType.create(DiamondsteelAXEguiMenu::new));
	public static final RegistryObject<MenuType<DiamondsteelswordguiMenu>> DIAMONDSTEELSWORDGUI = REGISTRY.register("diamondsteelswordgui",
			() -> IForgeMenuType.create(DiamondsteelswordguiMenu::new));
	public static final RegistryObject<MenuType<PocketchestMenu>> POCKETCHEST = REGISTRY.register("pocketchest",
			() -> IForgeMenuType.create(PocketchestMenu::new));
	public static final RegistryObject<MenuType<AssemblerguiMenu>> ASSEMBLERGUI = REGISTRY.register("assemblergui",
			() -> IForgeMenuType.create(AssemblerguiMenu::new));
	public static final RegistryObject<MenuType<DiamondSteelArmorGUIMenu>> DIAMOND_STEEL_ARMOR_GUI = REGISTRY.register("diamond_steel_armor_gui",
			() -> IForgeMenuType.create(DiamondSteelArmorGUIMenu::new));
	public static final RegistryObject<MenuType<ConcreteMixerGUIMenu>> CONCRETE_MIXER_GUI = REGISTRY.register("concrete_mixer_gui",
			() -> IForgeMenuType.create(ConcreteMixerGUIMenu::new));
	public static final RegistryObject<MenuType<SandstoneextractorGUIMenu>> SANDSTONEEXTRACTOR_GUI = REGISTRY.register("sandstoneextractor_gui",
			() -> IForgeMenuType.create(SandstoneextractorGUIMenu::new));
	public static final RegistryObject<MenuType<BuilderGUIMenu>> BUILDER_GUI = REGISTRY.register("builder_gui",
			() -> IForgeMenuType.create(BuilderGUIMenu::new));
	public static final RegistryObject<MenuType<AutoSellGUIMenu>> AUTO_SELL_GUI = REGISTRY.register("auto_sell_gui",
			() -> IForgeMenuType.create(AutoSellGUIMenu::new));
	public static final RegistryObject<MenuType<CompressorGUIMenu>> COMPRESSOR_GUI = REGISTRY.register("compressor_gui",
			() -> IForgeMenuType.create(CompressorGUIMenu::new));
	public static final RegistryObject<MenuType<MAMguiMenu>> MA_MGUI = REGISTRY.register("ma_mgui", () -> IForgeMenuType.create(MAMguiMenu::new));
	public static final RegistryObject<MenuType<HUBGUIMenu>> HUBGUI = REGISTRY.register("hubgui", () -> IForgeMenuType.create(HUBGUIMenu::new));
	public static final RegistryObject<MenuType<ElectricFurnancemk1guiMenu>> ELECTRIC_FURNANCEMK_1GUI = REGISTRY.register("electric_furnancemk_1gui",
			() -> IForgeMenuType.create(ElectricFurnancemk1guiMenu::new));
	public static final RegistryObject<MenuType<PresserMK2GUIMenu>> PRESSER_MK_2_GUI = REGISTRY.register("presser_mk_2_gui",
			() -> IForgeMenuType.create(PresserMK2GUIMenu::new));
	public static final RegistryObject<MenuType<Generatormk3guiMenu>> GENERATORMK_3GUI = REGISTRY.register("generatormk_3gui",
			() -> IForgeMenuType.create(Generatormk3guiMenu::new));
	public static final RegistryObject<MenuType<MAMGUIMAINMenu>> MAMGUIMAIN = REGISTRY.register("mamguimain",
			() -> IForgeMenuType.create(MAMGUIMAINMenu::new));
	public static final RegistryObject<MenuType<MamGUIElectronicsOnClickMenu>> MAM_GUI_ELECTRONICS = REGISTRY.register("mam_gui_electronics",
			() -> IForgeMenuType.create(MamGUIElectronicsOnClickMenu::new));
	public static final RegistryObject<MenuType<MinerGUIMenu>> MINER_GUI = REGISTRY.register("miner_gui",
			() -> IForgeMenuType.create(MinerGUIMenu::new));
	public static final RegistryObject<MenuType<Constructormk2guiMenu>> CONSTRUCTORMK_2GUI = REGISTRY.register("constructormk_2gui",
			() -> IForgeMenuType.create(Constructormk2guiMenu::new));
	public static final RegistryObject<MenuType<CentralStorageChestGUIMenu>> CENTRAL_STORAGE_CHEST_GUI = REGISTRY
			.register("central_storage_chest_gui", () -> IForgeMenuType.create(CentralStorageChestGUIMenu::new));
	public static final RegistryObject<MenuType<CentralStorageGUIMenu>> CENTRAL_STORAGE_GUI = REGISTRY.register("central_storage_gui",
			() -> IForgeMenuType.create(CentralStorageGUIMenu::new));
	public static final RegistryObject<MenuType<ManufacturerGUIMenu>> MANUFACTURER_GUI = REGISTRY.register("manufacturer_gui",
			() -> IForgeMenuType.create(ManufacturerGUIMenu::new));
	public static final RegistryObject<MenuType<PlaceToolGUIMenu>> PLACE_TOOL_GUI = REGISTRY.register("place_tool_gui",
			() -> IForgeMenuType.create(PlaceToolGUIMenu::new));
	public static final RegistryObject<MenuType<ParticleAcceleratorGUIMenu>> PARTICLE_ACCELERATOR_GUI = REGISTRY.register("particle_accelerator_gui",
			() -> IForgeMenuType.create(ParticleAcceleratorGUIMenu::new));
}
