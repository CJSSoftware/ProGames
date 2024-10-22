package net.cjsmc.progames.minigames.bedwars.listeners;

import net.cjsmc.progames.minigames.bedwars.BedWars;
import net.cjsmc.progames.minigames.bedwars.Team;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class GameListener implements Listener {
    private final BedWars plugin;

    public GameListener(BedWars plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {
        // Logic for when a player dies
        event.getEntity().sendMessage("You have died!"); // Simple message
        // Implement bed destruction check here
        for (Team team : plugin.getArena(event.getEntity().getName()).getTeams()) {
            if (team.getBed().isDestroyed()) {
                event.getEntity().sendMessage(team.getName() + "'s bed is destroyed!");
            }
        }
    }
}
