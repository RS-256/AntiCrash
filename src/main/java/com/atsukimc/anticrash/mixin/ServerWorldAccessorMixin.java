package com.atsukimc.anticrash.mixin;

import it.unimi.dsi.fastutil.objects.ObjectLinkedOpenHashSet;

//? if (>=1.18 && <=1.21.11) {
import net.minecraft.world.entity.Entity;
//?}
//? if (>=26.1 && <=26.3) {
/*import net.minecraft.server.level.ServerLevel;
*///?}

//? if (>=1.18 && <=1.21.11) {
import net.minecraft.world.level.BlockEventData;
//?}
//? if (>=26.1 && <=26.3) {
/*import net.minecraft.world.entity.Entity;
*///?}

//? if (>=1.18 && <=1.21.11) {
import net.minecraft.world.level.entity.PersistentEntitySectionManager;
//?}
//? if (>=26.1 && <=26.3) {
/*import net.minecraft.world.level.BlockEventData;
*///?}

//? if (>=1.18 && <=1.21.11) {
import net.minecraft.server.level.ServerLevel;
//?}
import net.minecraft.world.level.entity.EntityTickList;
//? if (>=26.1 && <=26.3) {
/*import net.minecraft.world.level.entity.PersistentEntitySectionManager;
*///?}

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import java.util.List;

@Mixin(ServerLevel.class)
public interface ServerWorldAccessorMixin {
    @Accessor("blockEvents")
    ObjectLinkedOpenHashSet<BlockEventData> anticrash$getSyncedBlockEventQueue();

    @Accessor("blockEventsToReschedule")
    List<BlockEventData> anticrash$getBlockEventQueue();

    @Accessor("entityManager")
    PersistentEntitySectionManager<Entity> anticrash$getEntityManager();

    @Accessor("entityTickList")
    EntityTickList anticrash$getEntityList();

    /** Ticks this dimension has had neither a player nor a forced chunk; entities stop at 300. */

    @Accessor("emptyTime")
    int anticrash$getIdleTimeout();

    @Accessor("emptyTime")
    void anticrash$setIdleTimeout(int ticks);
}
