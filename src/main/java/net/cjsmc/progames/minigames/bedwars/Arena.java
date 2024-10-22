package net.cjsmc.progames.minigames.bedwars;

import org.bukkit.Location;
import org.bukkit.Material;

import java.util.ArrayList;
import java.util.List;

public class Arena {
    private final String name;
    private final List<Team> teams;
    private final List<Spawner> spawners;

    public Arena(String name) {
        this.name = name;
        this.teams = new ArrayList<>();
        this.spawners = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Team> getTeams() {
        return teams;
    }

    public void addTeam(Team team) {
        teams.add(team);
    }

    public void addSpawner(String type, Location location, Material material) {
        spawners.add(new Spawner(type, location, material));
    }

    public List<Spawner> getSpawners() {
        return spawners;
    }
}