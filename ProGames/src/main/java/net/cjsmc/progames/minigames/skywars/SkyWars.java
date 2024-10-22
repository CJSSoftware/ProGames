package net.cjsmc.progames.minigames.skywars;

import org.bukkit.plugin.java.JavaPlugin;

public class SkyWars extends JavaPlugin {
    @Override
    public void onEnable() {
        // Register commands and events
        getCommand("swarena").setExecutor(new net.cjsmc.progames.minigames.skywars.commands.GameCommand(this));
        getServer().getPluginManager().registerEvents(new net.cjsmc.progames.minigames.skywars.listeners.GameListener(this), this);
        // Additional initialization code here
    }

    @Override
    public void onDisable() {
        // Cleanup code here
    }
}
