
package industrialeconomy.item;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;

import industrialeconomy.procedures.DiamondSteelArmorLeggingsTickEventProcedure;
import industrialeconomy.procedures.DiamondSteelArmorHelmetTickEventProcedure;
import industrialeconomy.procedures.DiamondSteelArmorBootsTickEventProcedure;
import industrialeconomy.procedures.DiamondSteelArmorBodyTickEventProcedure;

import industrialeconomy.init.IndustrialEconomyModTabs;
import industrialeconomy.init.IndustrialEconomyModItems;

public abstract class DiamondSteelArmorItem extends ArmorItem {
	public DiamondSteelArmorItem(EquipmentSlot slot, Item.Properties properties) {
		super(new ArmorMaterial() {
			@Override
			public int getDurabilityForSlot(EquipmentSlot slot) {
				return new int[]{13, 15, 16, 11}[slot.getIndex()] * 1024;
			}

			@Override
			public int getDefenseForSlot(EquipmentSlot slot) {
				return new int[]{15, 28, 23, 13}[slot.getIndex()];
			}

			@Override
			public int getEnchantmentValue() {
				return 42;
			}

			@Override
			public SoundEvent getEquipSound() {
				return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation(""));
			}

			@Override
			public Ingredient getRepairIngredient() {
				return Ingredient.of(new ItemStack(IndustrialEconomyModItems.DIAMONDSTEELPLATE.get()));
			}

			@Override
			public String getName() {
				return "diamond_steel_armor";
			}

			@Override
			public float getToughness() {
				return 5f;
			}

			@Override
			public float getKnockbackResistance() {
				return 0f;
			}
		}, slot, properties);
	}

	public static class Helmet extends DiamondSteelArmorItem {
		public Helmet() {
			super(EquipmentSlot.HEAD, new Item.Properties().tab(IndustrialEconomyModTabs.TAB_PROJECT_MEGA));
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
			return "industrial_economy:textures/models/armor/diamondsteel_layer_1.png";
		}

		@Override
		public void onArmorTick(ItemStack itemstack, Level world, Player entity) {
			DiamondSteelArmorHelmetTickEventProcedure.execute(entity);
		}
	}

	public static class Chestplate extends DiamondSteelArmorItem {
		public Chestplate() {
			super(EquipmentSlot.CHEST, new Item.Properties().tab(IndustrialEconomyModTabs.TAB_PROJECT_MEGA));
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
			return "industrial_economy:textures/models/armor/diamondsteel_layer_1.png";
		}

		@Override
		public void onArmorTick(ItemStack itemstack, Level world, Player entity) {
			DiamondSteelArmorBodyTickEventProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity);
		}
	}

	public static class Leggings extends DiamondSteelArmorItem {
		public Leggings() {
			super(EquipmentSlot.LEGS, new Item.Properties().tab(IndustrialEconomyModTabs.TAB_PROJECT_MEGA));
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
			return "industrial_economy:textures/models/armor/diamondsteel_layer_2.png";
		}

		@Override
		public void onArmorTick(ItemStack itemstack, Level world, Player entity) {
			DiamondSteelArmorLeggingsTickEventProcedure.execute(entity);
		}
	}

	public static class Boots extends DiamondSteelArmorItem {
		public Boots() {
			super(EquipmentSlot.FEET, new Item.Properties().tab(IndustrialEconomyModTabs.TAB_PROJECT_MEGA));
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
			return "industrial_economy:textures/models/armor/diamondsteel_layer_1.png";
		}

		@Override
		public void onArmorTick(ItemStack itemstack, Level world, Player entity) {
			DiamondSteelArmorBootsTickEventProcedure.execute(entity);
		}
	}
}
