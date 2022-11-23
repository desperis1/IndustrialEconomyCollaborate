
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package industrialeconomy.init;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.gui.screens.MenuScreens;

import industrialeconomy.client.gui.SteeldiamondguiScreen;
import industrialeconomy.client.gui.SandstoneextractorGUIScreen;
import industrialeconomy.client.gui.PresserMK2GUIScreen;
import industrialeconomy.client.gui.PresserGUIScreen;
import industrialeconomy.client.gui.PocketchestScreen;
import industrialeconomy.client.gui.PlaceToolGUIScreen;
import industrialeconomy.client.gui.ParticleAcceleratorGUIScreen;
import industrialeconomy.client.gui.MinerGUIScreen;
import industrialeconomy.client.gui.ManufacturerGUIScreen;
import industrialeconomy.client.gui.MamGUIElectronicsOnClickScreen;
import industrialeconomy.client.gui.MAMguiScreen;
import industrialeconomy.client.gui.MAMGUIMAINScreen;
import industrialeconomy.client.gui.IronextractorGUIScreen;
import industrialeconomy.client.gui.HUBGUIScreen;
import industrialeconomy.client.gui.Generatormk3guiScreen;
import industrialeconomy.client.gui.GeneratorMK2GUIScreen;
import industrialeconomy.client.gui.GeneratorMK1GuiScreen;
import industrialeconomy.client.gui.FoundryGUIScreen;
import industrialeconomy.client.gui.ElectricFurnancemk1guiScreen;
import industrialeconomy.client.gui.ElectricFurnanceScreen;
import industrialeconomy.client.gui.DiamondsteelswordguiScreen;
import industrialeconomy.client.gui.DiamondsteelAXEguiScreen;
import industrialeconomy.client.gui.DiamondSteelArmorGUIScreen;
import industrialeconomy.client.gui.CopperExtracotrguiScreen;
import industrialeconomy.client.gui.Constructormk2guiScreen;
import industrialeconomy.client.gui.ConstructorguiScreen;
import industrialeconomy.client.gui.ConcreteMixerGUIScreen;
import industrialeconomy.client.gui.CompressorGUIScreen;
import industrialeconomy.client.gui.CoalExtractorGUIScreen;
import industrialeconomy.client.gui.ChargerguiScreen;
import industrialeconomy.client.gui.CentralStorageGUIScreen;
import industrialeconomy.client.gui.CentralStorageChestGUIScreen;
import industrialeconomy.client.gui.CateriumExtracotorGUIScreen;
import industrialeconomy.client.gui.BuilderGUIScreen;
import industrialeconomy.client.gui.AutoSellGUIScreen;
import industrialeconomy.client.gui.AssemblerguiScreen;
import industrialeconomy.client.gui.AdminMenuScreen;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class IndustrialEconomyModScreens {
	@SubscribeEvent
	public static void clientLoad(FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			MenuScreens.register(IndustrialEconomyModMenus.ADMIN_MENU.get(), AdminMenuScreen::new);
			MenuScreens.register(IndustrialEconomyModMenus.GENERATOR_MK_1_GUI.get(), GeneratorMK1GuiScreen::new);
			MenuScreens.register(IndustrialEconomyModMenus.CONSTRUCTORGUI.get(), ConstructorguiScreen::new);
			MenuScreens.register(IndustrialEconomyModMenus.CHARGERGUI.get(), ChargerguiScreen::new);
			MenuScreens.register(IndustrialEconomyModMenus.FOUNDRY_GUI.get(), FoundryGUIScreen::new);
			MenuScreens.register(IndustrialEconomyModMenus.PRESSER_GUI.get(), PresserGUIScreen::new);
			MenuScreens.register(IndustrialEconomyModMenus.GENERATOR_MK_2_GUI.get(), GeneratorMK2GUIScreen::new);
			MenuScreens.register(IndustrialEconomyModMenus.ELECTRIC_FURNANCE.get(), ElectricFurnanceScreen::new);
			MenuScreens.register(IndustrialEconomyModMenus.IRONEXTRACTOR_GUI.get(), IronextractorGUIScreen::new);
			MenuScreens.register(IndustrialEconomyModMenus.COPPER_EXTRACOTRGUI.get(), CopperExtracotrguiScreen::new);
			MenuScreens.register(IndustrialEconomyModMenus.CATERIUM_EXTRACOTOR_GUI.get(), CateriumExtracotorGUIScreen::new);
			MenuScreens.register(IndustrialEconomyModMenus.COAL_EXTRACTOR_GUI.get(), CoalExtractorGUIScreen::new);
			MenuScreens.register(IndustrialEconomyModMenus.STEELDIAMONDGUI.get(), SteeldiamondguiScreen::new);
			MenuScreens.register(IndustrialEconomyModMenus.DIAMONDSTEEL_AX_EGUI.get(), DiamondsteelAXEguiScreen::new);
			MenuScreens.register(IndustrialEconomyModMenus.DIAMONDSTEELSWORDGUI.get(), DiamondsteelswordguiScreen::new);
			MenuScreens.register(IndustrialEconomyModMenus.POCKETCHEST.get(), PocketchestScreen::new);
			MenuScreens.register(IndustrialEconomyModMenus.ASSEMBLERGUI.get(), AssemblerguiScreen::new);
			MenuScreens.register(IndustrialEconomyModMenus.DIAMOND_STEEL_ARMOR_GUI.get(), DiamondSteelArmorGUIScreen::new);
			MenuScreens.register(IndustrialEconomyModMenus.CONCRETE_MIXER_GUI.get(), ConcreteMixerGUIScreen::new);
			MenuScreens.register(IndustrialEconomyModMenus.SANDSTONEEXTRACTOR_GUI.get(), SandstoneextractorGUIScreen::new);
			MenuScreens.register(IndustrialEconomyModMenus.BUILDER_GUI.get(), BuilderGUIScreen::new);
			MenuScreens.register(IndustrialEconomyModMenus.AUTO_SELL_GUI.get(), AutoSellGUIScreen::new);
			MenuScreens.register(IndustrialEconomyModMenus.COMPRESSOR_GUI.get(), CompressorGUIScreen::new);
			MenuScreens.register(IndustrialEconomyModMenus.MA_MGUI.get(), MAMguiScreen::new);
			MenuScreens.register(IndustrialEconomyModMenus.HUBGUI.get(), HUBGUIScreen::new);
			MenuScreens.register(IndustrialEconomyModMenus.ELECTRIC_FURNANCEMK_1GUI.get(), ElectricFurnancemk1guiScreen::new);
			MenuScreens.register(IndustrialEconomyModMenus.PRESSER_MK_2_GUI.get(), PresserMK2GUIScreen::new);
			MenuScreens.register(IndustrialEconomyModMenus.GENERATORMK_3GUI.get(), Generatormk3guiScreen::new);
			MenuScreens.register(IndustrialEconomyModMenus.MAMGUIMAIN.get(), MAMGUIMAINScreen::new);
			MenuScreens.register(IndustrialEconomyModMenus.MAM_GUI_ELECTRONICS.get(), MamGUIElectronicsOnClickScreen::new);
			MenuScreens.register(IndustrialEconomyModMenus.MINER_GUI.get(), MinerGUIScreen::new);
			MenuScreens.register(IndustrialEconomyModMenus.CONSTRUCTORMK_2GUI.get(), Constructormk2guiScreen::new);
			MenuScreens.register(IndustrialEconomyModMenus.CENTRAL_STORAGE_CHEST_GUI.get(), CentralStorageChestGUIScreen::new);
			MenuScreens.register(IndustrialEconomyModMenus.CENTRAL_STORAGE_GUI.get(), CentralStorageGUIScreen::new);
			MenuScreens.register(IndustrialEconomyModMenus.MANUFACTURER_GUI.get(), ManufacturerGUIScreen::new);
			MenuScreens.register(IndustrialEconomyModMenus.PLACE_TOOL_GUI.get(), PlaceToolGUIScreen::new);
			MenuScreens.register(IndustrialEconomyModMenus.PARTICLE_ACCELERATOR_GUI.get(), ParticleAcceleratorGUIScreen::new);
		});
	}
}
