//? if (>=1.21 && <=26.3) {
/*package com.atsukimc.anticrash.mixin;

//? if (>=1.21 && <=1.21.11) {
/^import net.minecraft.world.level.block.Portal;
^///?}
import net.minecraft.world.entity.PortalProcessor;
//? if (>=26.1 && <=26.3) {
/^import net.minecraft.world.level.block.Portal;
^///?}


import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(PortalProcessor.class)
public interface PortalManagerAccessorMixin {

@Accessor("portal")
    Portal anticrash$getPortal();


@Accessor("portalTime")
    void anticrash$setTicksInPortal(int ticks);

}
*///?}
