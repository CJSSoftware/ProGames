package net.cjsmc.progames.minigames.bedwars;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.scheduler.BukkitRunnable;

public class Spawner {
    private final String type; // Type of spawner (iron, diamond, emerald)
    private final Location location; // Location of the spawner
    private final Material material; // Item to spawn
    private final int spawnDelay; // Time between spawns

    public Spawner(String type, Location location, Material material) {
        this.type = type;
        this.location = location;
        this.material = material;
        this.spawnDelay = 20; // Spawn every second (20 ticks)
        startSpawning(); // Start the spawning process
    }

    public String getType() {
        return type;
    }

    public Location getLocation() {
        return location;
    }

    public Material getMaterial() {
        return material;
    }

    private void startSpawning() {
        new BukkitRunnable() {
            @Override
            public void run() {
                spawnItem();
            }
        }.runTaskTimer(Bukkit.getPluginManager().getPlugin("ProGames"), spawnDelay, spawnDelay);
    }

    private void spawnItem() {
        // Create the item and drop it at the spawner's location
        Item item = location.getWorld().dropItem(location, new org.bukkit.inventory.ItemStack(material));
        item.setPickupDelay(0); // Players can pick it up immediately
    }
}