
package industrialeconomy.entity;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.network.PlayMessages;
import net.minecraftforge.network.NetworkHooks;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.projectile.ItemSupplier;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.util.RandomSource;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.protocol.Packet;

import industrialeconomy.procedures.PlasmaShootrangeditemWhileBulletFlyingTickProcedure;
import industrialeconomy.procedures.PlasmaShootrangeditemBulletHitsBlockProcedure;

import industrialeconomy.init.IndustrialEconomyModItems;
import industrialeconomy.init.IndustrialEconomyModEntities;

@OnlyIn(value = Dist.CLIENT, _interface = ItemSupplier.class)
public class PlasmaRANGEDITEMEntity extends AbstractArrow implements ItemSupplier {
	public PlasmaRANGEDITEMEntity(PlayMessages.SpawnEntity packet, Level world) {
		super(IndustrialEconomyModEntities.PLASMA_RANGEDITEM.get(), world);
	}

	public PlasmaRANGEDITEMEntity(EntityType<? extends PlasmaRANGEDITEMEntity> type, Level world) {
		super(type, world);
	}

	public PlasmaRANGEDITEMEntity(EntityType<? extends PlasmaRANGEDITEMEntity> type, double x, double y, double z, Level world) {
		super(type, x, y, z, world);
	}

	public PlasmaRANGEDITEMEntity(EntityType<? extends PlasmaRANGEDITEMEntity> type, LivingEntity entity, Level world) {
		super(type, entity, world);
	}

	@Override
	public Packet<?> getAddEntityPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public ItemStack getItem() {
		return new ItemStack(IndustrialEconomyModItems.PLASMABULLETITEM.get());
	}

	@Override
	protected ItemStack getPickupItem() {
		return new ItemStack(IndustrialEconomyModItems.PLASMABULLETITEM.get());
	}

	@Override
	protected void doPostHurtEffects(LivingEntity entity) {
		super.doPostHurtEffects(entity);
		entity.setArrowCount(entity.getArrowCount() - 1);
	}

	@Override
	public void onHitBlock(BlockHitResult blockHitResult) {
		super.onHitBlock(blockHitResult);
		PlasmaShootrangeditemBulletHitsBlockProcedure.execute(this.level, blockHitResult.getBlockPos().getX(), blockHitResult.getBlockPos().getY(),
				blockHitResult.getBlockPos().getZ());
	}

	@Override
	public void tick() {
		super.tick();
		PlasmaShootrangeditemWhileBulletFlyingTickProcedure.execute(this.level, this.getX(), this.getY(), this.getZ());
		if (this.inGround)
			this.discard();
	}

	public static PlasmaRANGEDITEMEntity shoot(Level world, LivingEntity entity, RandomSource random, float power, double damage, int knockback) {
		PlasmaRANGEDITEMEntity entityarrow = new PlasmaRANGEDITEMEntity(IndustrialEconomyModEntities.PLASMA_RANGEDITEM.get(), entity, world);
		entityarrow.shoot(entity.getViewVector(1).x, entity.getViewVector(1).y, entity.getViewVector(1).z, power * 2, 0);
		entityarrow.setSilent(true);
		entityarrow.setCritArrow(false);
		entityarrow.setBaseDamage(damage);
		entityarrow.setKnockback(knockback);
		world.addFreshEntity(entityarrow);
		world.playSound(null, entity.getX(), entity.getY(), entity.getZ(),
				ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("industrial_economy:plasma_shoot")), SoundSource.PLAYERS, 1,
				1f / (random.nextFloat() * 0.5f + 1) + (power / 2));
		return entityarrow;
	}

	public static PlasmaRANGEDITEMEntity shoot(LivingEntity entity, LivingEntity target) {
		PlasmaRANGEDITEMEntity entityarrow = new PlasmaRANGEDITEMEntity(IndustrialEconomyModEntities.PLASMA_RANGEDITEM.get(), entity, entity.level);
		double dx = target.getX() - entity.getX();
		double dy = target.getY() + target.getEyeHeight() - 1.1;
		double dz = target.getZ() - entity.getZ();
		entityarrow.shoot(dx, dy - entityarrow.getY() + Math.hypot(dx, dz) * 0.2F, dz, 1f * 2, 12.0F);
		entityarrow.setSilent(true);
		entityarrow.setBaseDamage(5);
		entityarrow.setKnockback(5);
		entityarrow.setCritArrow(false);
		entity.level.addFreshEntity(entityarrow);
		entity.level.playSound(null, entity.getX(), entity.getY(), entity.getZ(),
				ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("industrial_economy:plasma_shoot")), SoundSource.PLAYERS, 1,
				1f / (RandomSource.create().nextFloat() * 0.5f + 1));
		return entityarrow;
	}
}
