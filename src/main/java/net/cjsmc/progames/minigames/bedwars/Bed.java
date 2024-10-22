package net.cjsmc.progames.minigames.bedwars;

import org.bukkit.Location;

public class Bed {
    private boolean destroyed;
    private Location location; // Store the bed's location

    public Bed(Location location) {
        this.location = location; // Initialize the bed with its location
        this.destroyed = false; // Bed starts intact
    }

    public boolean isDestroyed() {
        return destroyed;
    }

    public void destroy() {
        this.destroyed = true; // Mark the bed as destroyed
    }

    public Location getLocation() {
        return location; // Return the location of the bed
    }
}