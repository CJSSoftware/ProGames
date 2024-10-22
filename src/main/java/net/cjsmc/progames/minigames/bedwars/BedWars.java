package net.cjsmc.progames.minigames.bedwars;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import java.io.File;
import java.io.IOException;

public class BedWars extends JavaPlugin {
    private File arenaFolder;

    @Override
    public void onEnable() {
        createArenaFolder();
        createDefaultConfig();
    }

    // Method to create the arena folder
    private void createArenaFolder() {
        arenaFolder = new File(getDataFolder(), "arenas");
        if (!arenaFolder.exists()) {
            arenaFolder.mkdirs(); // Create the folder if it does not exist
        }
    }

    // Method to create a default configuration file for arena settings
    private void createDefaultConfig() {
        File defaultConfigFile = new File(arenaFolder, "default.yml");
        FileConfiguration arenaConfig;
        if (!defaultConfigFile.exists()) {
            try {
                defaultConfigFile.createNewFile(); // Create the file if it does not exist
                arenaConfig = YamlConfiguration.loadConfiguration(defaultConfigFile);
                // Add any default settings to the configuration here
                arenaConfig.set("exampleSetting", "value");
                arenaConfig.save(defaultConfigFile); // Save the changes
            } catch (IOException e) {
                getLogger().severe("Could not create default configuration file: " + e.getMessage());
            }
        } else {
            arenaConfig = YamlConfiguration.loadConfiguration(defaultConfigFile); // Load existing config
        }
    }

    // Method to save arena settings
    public void saveArenaSettings(Arena arena) {
        File file = new File(arenaFolder, arena.getName() + ".yml");
        YamlConfiguration config = YamlConfiguration.loadConfiguration(file);

        config.set("name", arena.getName());
        // Save other arena properties here, like teams, beds, and spawners

        try {
            config.save(file); // Save the arena configuration
        } catch (IOException e) {
            getLogger().severe("Could not save arena settings: " + e.getMessage());
        }
    }
}