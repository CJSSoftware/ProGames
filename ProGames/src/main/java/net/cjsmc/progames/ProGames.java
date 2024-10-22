package net.cjsmc.progames;

import net.cjsmc.progames.minigames.bedwars.BedWars;
import org.bukkit.plugin.java.JavaPlugin;

public class ProGames extends JavaPlugin {

    @Override
    public void onEnable() {
        // Register BedWars and other minigame commands
        BedWars bedWars = new BedWars(this);
        getCommand("bedwars").setExecutor(bedWars);
        getCommand("skywars").setExecutor(bedWars);
        getCommand("skyblock").setExecutor(bedWars);
        getCommand("survivalgames").setExecutor(bedWars);

        getLogger().info("ProGames plugin has been enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("ProGames plugin has been disabled!");
    }
}