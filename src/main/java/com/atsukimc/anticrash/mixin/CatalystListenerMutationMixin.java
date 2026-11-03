//? if (>=1.20 && <=26.3) {
/*package com.atsukimc.anticrash.mixin;

//? if (>=1.20 && <=1.21.11) {
/^import net.minecraft.world.level.block.entity.SculkCatalystBlockEntity;
^///?}
//? if (>=26.1 && <=26.3) {
/^import net.minecraft.core.BlockPos;
^///?}

import net.minecraft.server.level.ServerLevel;

//? if (>=1.20 && <=1.21.11) {
/^import net.minecraft.core.BlockPos;
^///?}
//? if (>=26.1 && <=26.3) {
/^import net.minecraft.world.level.block.entity.SculkCatalystBlockEntity;
^///?}

//? if (>=1.20 && <=1.21.11) {
/^import net.minecraft.world.phys.Vec3;
^///?}
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.gameevent.PositionSource;
//? if (>=26.1 && <=26.3) {
/^import net.minecraft.world.phys.Vec3;
^///?}


import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(SculkCatalystBlockEntity.CatalystListener.class)
public abstract class CatalystListenerMutationMixin {
    @Shadow
    public abstract PositionSource getListenerSource();



//? if (>=1.20 && <=1.20.4) {
/^@Inject(method = "handleGameEvent", at = @At("RETURN"))
    private void anticrash$dirtyCursor(
            ServerLevel world,
            GameEvent event,
            GameEvent.Context emitter,
            Vec3 origin,
            CallbackInfoReturnable<Boolean> ci)
^///?}
//? if (>=1.20.5 && <=26.3) {
/^@Inject(method = "handleGameEvent", at = @At("RETURN"))
    private void anticrash$dirtyCursor(
            ServerLevel world,
            net.minecraft.core.Holder<GameEvent> event,
            GameEvent.Context emitter,
            Vec3 origin,
            CallbackInfoReturnable<Boolean> ci)
^///?}
{
        if (ci.getReturnValueZ())

getListenerSource()
                    .getPosition(world)
                    .ifPresent(pos -> world.blockEntityChanged(BlockPos.containing(pos)));

    }
}
*///?}
