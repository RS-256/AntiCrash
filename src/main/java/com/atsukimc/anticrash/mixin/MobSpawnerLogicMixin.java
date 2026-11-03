package com.atsukimc.anticrash.mixin;

//? if (>=1.20.3 && <=1.21.11) {
/*import net.minecraft.world.level.BaseSpawner;
*///?}
//? if (>=26.1 && <=26.3) {
/*import net.minecraft.core.BlockPos;
*///?}

import net.minecraft.server.level.ServerLevel;

//? if (>=1.18 && <=1.21.11) {
import net.minecraft.core.BlockPos;
//?}

//? if (>=1.18 && <=1.20.2) {
import net.minecraft.world.level.BaseSpawner;
//?}
//? if (>=26.1 && <=26.3) {
/*import net.minecraft.world.level.BaseSpawner;
*///?}

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/** The spawner {@code Delay} changes while a player is in range without a chunk save mark. */
@Mixin(BaseSpawner.class)
public abstract class MobSpawnerLogicMixin {

    @Shadow private int spawnDelay;
    @Unique private int anticrash$delayBefore;

    @Inject(method = "serverTick", at = @At("HEAD"))
    private void anticrash$rememberDelay(
            ServerLevel world, BlockPos pos, CallbackInfo callbackInfo) {
        anticrash$delayBefore = spawnDelay;
    }

    @Inject(method = "serverTick", at = @At("RETURN"))
    private void anticrash$markDelayDirty(
            ServerLevel world, BlockPos pos, CallbackInfo callbackInfo) {
        if (spawnDelay != anticrash$delayBefore) world.blockEntityChanged(pos);
    }
}
