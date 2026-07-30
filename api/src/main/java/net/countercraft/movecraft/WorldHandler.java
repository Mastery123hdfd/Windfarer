package net.countercraft.movecraft;

import net.countercraft.movecraft.craft.Craft;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.data.BlockData;
import org.bukkit.entity.Player;
import org.bukkit.inventory.InventoryView;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class WorldHandler {
    public abstract void rotateCraft(@NotNull Craft craft, @NotNull MovecraftLocation originLocation, @NotNull MovecraftRotation rotation);
    public abstract void translateCraft(@NotNull Craft craft, @NotNull MovecraftLocation newLocation, @NotNull World world);
    public abstract void setBlockFast(@NotNull Location location, @NotNull BlockData data);
    public abstract void setBlockFast(@NotNull Location location, @NotNull MovecraftRotation rotation, @NotNull BlockData data);

    public static @NotNull String[] getPackageNames(@NotNull String minecraftVersion) {
        String[] parts = minecraftVersion.split("\\.");
        String patch = parts.length > 2 ? parts[2] : "0";
        // TODO: Replace with ServiceLoaders!
        return new String[] {
                // Exact version (e.g. 1.21.11 or 26.1.2)
                "v" + parts[0] + "_" + parts[1] + "_" + patch,
                // After that minor version (e.g. 1.21 or 26.1)
                "v" + parts[0] + "_" + parts[1],
                // And at last, the major version only (e.g. 1 or 26), hopefully we never need this!
                "v" + parts[0]
        };
    }
}
