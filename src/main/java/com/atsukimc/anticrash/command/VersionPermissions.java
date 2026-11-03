//? if (>=1.21.11 && <=26.3) {
/*package com.atsukimc.anticrash.command;

//? if 1.21.11 {
/^import net.minecraft.server.permissions.Permission;
^///?}
//? if (>=26.1 && <=26.3) {
/^import net.minecraft.commands.CommandSourceStack;
^///?}

//? if 1.21.11 {
/^import net.minecraft.server.permissions.PermissionLevel;
^///?}
//? if (>=26.1 && <=26.3) {
/^import net.minecraft.server.permissions.Permission;
^///?}

//? if 1.21.11 {
/^import net.minecraft.server.permissions.PermissionSet;
^///?}
//? if (>=26.1 && <=26.3) {
/^import net.minecraft.server.permissions.PermissionLevel;
^///?}

//? if 1.21.11 {
/^import net.minecraft.commands.CommandSourceStack;
^///?}
//? if (>=26.1 && <=26.3) {
/^import net.minecraft.server.permissions.PermissionSet;
^///?}


/^* Preserve configurable 0..4 command levels using Vanilla's new permission predicate. ^/
public final class VersionPermissions {
    private VersionPermissions() {}


public static boolean hasLevel(CommandSourceStack source, int level)
{

return hasLevel(source.permissions(), level);

    }


public static boolean hasLevel(PermissionSet permissions, int level)
{
        if (level < 0 || level > 4 || permissions == null) return false;

return level == 0
                || permissions.hasPermission(
                        new Permission.HasCommandLevel(PermissionLevel.byId(level)));

    }
}
*///?}
