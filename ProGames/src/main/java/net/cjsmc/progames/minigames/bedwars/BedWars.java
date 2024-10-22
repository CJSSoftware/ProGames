package net.cjsmc.progames.minigames.bedwars;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

public class BedWars extends JavaPlugin {

    private File arenaFolder;

    @Override
    public void onEnable() {
        createArenaFolder();
        createDefaultArenaConfig();
    }

    // Creates the 'arenas' folder within the plugin's data folder
    private void createArenaFolder() {
        arenaFolder = new File(getDataFolder(), "arenas");
        if (!arenaFolder.exists() && arenaFolder.mkdirs()) {
            getLogger().info("Arenas folder created successfully.");
        } else {
            getLogger().info("Arenas folder already exists.");
        }
    }

    // Creates a default arena configuration file if it doesn't exist
    private void createDefaultArenaConfig() {
        File defaultConfigFile = new File(arenaFolder, "default.yml");

        if (!defaultConfigFile.exists()) {
            FileConfiguration defaultArenaConfig = YamlConfiguration.loadConfiguration(defaultConfigFile);
            try {
                // Set default arena configuration settings
                defaultArenaConfig.set("exampleSetting", "value");
                // Save the default configuration file
                defaultArenaConfig.save(defaultConfigFile);
                getLogger().info("Default arena configuration created successfully.");
            } catch (IOException e) {
                getLogger().severe("Error creating default arena configuration: " + e.getMessage());
            }
        } else {
            getLogger().info("Default arena configuration already exists.");
        }
    }

    // Saves arena settings to a specific arena file
    public void saveArenaSettings(Arena arena) {
        File arenaFile = new File(arenaFolder, arena.getName() + ".yml");
        FileConfiguration arenaConfig = YamlConfiguration.loadConfiguration(arenaFile);

        // Set arena properties in the configuration file
        arenaConfig.set("name", arena.getName());
        // Add more settings for the arena, such as teams, beds, spawners, etc.
        // e.g. arenaConfig.set("teams", arena.getTeams());

        try {
            // Save the arena configuration file
            arenaConfig.save(arenaFile);
            getLogger().info("Arena settings saved for arena: " + arena.getName());
        } catch (IOException e) {
            getLogger().severe("Could not save arena settings for arena " + arena.getName() + ": " + e.getMessage());
        }
    }
}