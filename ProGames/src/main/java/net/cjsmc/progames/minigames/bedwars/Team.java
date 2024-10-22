package net.cjsmc.progames.minigames.bedwars;

import org.bukkit.ChatColor;
import org.bukkit.Location;

public class Team {
    private final String name;
    private final ChatColor color;
    private Bed bed;

    public Team(String name, ChatColor color, Location bedLocation) {
        this.name = name;
        this.color = color;
        this.bed = new Bed(bedLocation); // Pass the bed location to the Bed class
    }

    public String getName() {
        return name;
    }

    public ChatColor getColor() {
        return color;
    }

    public Bed getBed() {
        return bed;
    }

    // Additional methods for team management can go here
}