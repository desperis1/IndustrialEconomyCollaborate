/*
 *    MCreator note:
 *
 *    If you lock base mod element files, you can edit this file and it won't get overwritten.
 *    If you change your modid or package, you need to apply these changes to this file MANUALLY.
 *
 *    Settings in @Mod annotation WON'T be changed in case of the base mod element
 *    files lock too, so you need to set them manually here in such case.
 *
 *    If you do not lock base mod element files in Workspace settings, this file
 *    will be REGENERATED on each build.
 *
 */
package industrialeconomy;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import net.minecraftforge.network.simple.SimpleChannel;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.FriendlyByteBuf;

import java.util.function.Supplier;
import java.util.function.Function;
import java.util.function.BiConsumer;
import java.util.List;
import java.util.ArrayList;
import java.util.AbstractMap;

import industrialeconomy.init.IndustrialEconomyModTabs;
import industrialeconomy.init.IndustrialEconomyModSounds;
import industrialeconomy.init.IndustrialEconomyModParticleTypes;
import industrialeconomy.init.IndustrialEconomyModMobEffects;
import industrialeconomy.init.IndustrialEconomyModMenus;
import industrialeconomy.init.IndustrialEconomyModItems;
import industrialeconomy.init.IndustrialEconomyModFluids;
import industrialeconomy.init.IndustrialEconomyModFluidTypes;
import industrialeconomy.init.IndustrialEconomyModFeatures;
import industrialeconomy.init.IndustrialEconomyModEntities;
import industrialeconomy.init.IndustrialEconomyModEnchantments;
import industrialeconomy.init.IndustrialEconomyModBlocks;
import industrialeconomy.init.IndustrialEconomyModBlockEntities;
import industrialeconomy.init.IndustrialEconomyModBiomes;

@Mod("industrial_economy")
public class IndustrialEconomyMod {
	public static final Logger LOGGER = LogManager.getLogger(IndustrialEconomyMod.class);
	public static final String MODID = "industrial_economy";

	public IndustrialEconomyMod() {
		MinecraftForge.EVENT_BUS.register(this);
		IndustrialEconomyModTabs.load();
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		IndustrialEconomyModSounds.REGISTRY.register(bus);
		IndustrialEconomyModBlocks.REGISTRY.register(bus);
		IndustrialEconomyModItems.REGISTRY.register(bus);
		IndustrialEconomyModEntities.REGISTRY.register(bus);
		IndustrialEconomyModBlockEntities.REGISTRY.register(bus);
		IndustrialEconomyModFeatures.REGISTRY.register(bus);
		IndustrialEconomyModFluids.REGISTRY.register(bus);
		IndustrialEconomyModFluidTypes.REGISTRY.register(bus);

		IndustrialEconomyModMobEffects.REGISTRY.register(bus);

		IndustrialEconomyModEnchantments.REGISTRY.register(bus);
		IndustrialEconomyModParticleTypes.REGISTRY.register(bus);
		IndustrialEconomyModMenus.REGISTRY.register(bus);
		IndustrialEconomyModBiomes.REGISTRY.register(bus);
	}

	private static final String PROTOCOL_VERSION = "1";
	public static final SimpleChannel PACKET_HANDLER = NetworkRegistry.newSimpleChannel(new ResourceLocation(MODID, MODID), () -> PROTOCOL_VERSION,
			PROTOCOL_VERSION::equals, PROTOCOL_VERSION::equals);
	private static int messageID = 0;

	public static <T> void addNetworkMessage(Class<T> messageType, BiConsumer<T, FriendlyByteBuf> encoder, Function<FriendlyByteBuf, T> decoder,
			BiConsumer<T, Supplier<NetworkEvent.Context>> messageConsumer) {
		PACKET_HANDLER.registerMessage(messageID, messageType, encoder, decoder, messageConsumer);
		messageID++;
	}

	private static final List<AbstractMap.SimpleEntry<Runnable, Integer>> workQueue = new ArrayList<>();

	public static void queueServerWork(int tick, Runnable action) {
		workQueue.add(new AbstractMap.SimpleEntry(action, tick));
	}

	@SubscribeEvent
	public void tick(TickEvent.ServerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			List<AbstractMap.SimpleEntry<Runnable, Integer>> actions = new ArrayList<>();
			workQueue.forEach(work -> {
				work.setValue(work.getValue() - 1);
				if (work.getValue() == 0)
					actions.add(work);
			});
			actions.forEach(e -> e.getKey().run());
			workQueue.removeAll(actions);
		}
	}
}
