package net.cjsmc.progames.minigames.skywars.listeners;

import net.cjsmc.progames.minigames.skywars.SkyWars;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class GameListener implements Listener {
    private final SkyWars plugin;

    public GameListener(SkyWars plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        event.getPlayer().sendMessage("Welcome to SkyWars!");
        // Additional event handling
    }
}
