package net.cjsmc.progames.listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.inventory.InventoryClickEvent;

import net.cjsmc.progames.bedwars.BedWarsGame;
import net.cjsmc.progames.murdermystery.MurderMysteryGame;

public class GameEventListener implements Listener {
    private BedWarsGame bedWarsGame;
    private HungerGamesGame hungerGamesGame;
    private SkyWarsGame skyWarsGame;
    private MurderMysteryGame murderMysteryGame;

    public GameEventListener(BedWarsGame bedWarsGame, HungerGamesGame hungerGamesGame,
                             SkyWarsGame skyWarsGame, MurderMysteryGame murderMysteryGame) {
        this.bedWarsGame = bedWarsGame;
        this.hungerGamesGame = hungerGamesGame;
        this.skyWarsGame = skyWarsGame;
        this.murderMysteryGame = murderMysteryGame;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        // Check if the game has started in any of the games and respond accordingly
        Player player = event.getPlayer();

        if (bedWarsGame.isGameStarted()) {
            player.sendMessage("§cGame is already in progress. You cannot join BedWars.");
        } else if (hungerGamesGame.isGameStarted()) {
            player.sendMessage("§cGame is already in progress. You cannot join Hunger Games.");
        } else if (skyWarsGame.isGameStarted()) {
            player.sendMessage("§cGame is already in progress. You cannot join SkyWars.");
        } else if (murderMysteryGame.isGameStarted()) {
            player.sendMessage("§cGame is already in progress. You cannot join Murder Mystery.");
        }
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();

        // Handle quitting for all game types
        if (bedWarsGame.isPlayerInGame(player)) {
            bedWarsGame.removePlayer(player);
            Bukkit.broadcastMessage("§e" + player.getName() + " has left the BedWars game.");
            if (bedWarsGame.getPlayerCount() < 2) {
                bedWarsGame.endGame();
            }
        }

        if (hungerGamesGame.isPlayerInGame(player)) {
            hungerGamesGame.removePlayer(player);
            Bukkit.broadcastMessage("§e" + player.getName() + " has left the Hunger Games.");
            if (hungerGamesGame.getPlayerCount() < 2) {
                hungerGamesGame.endGame();
            }
        }

        if (skyWarsGame.isPlayerInGame(player)) {
            skyWarsGame.removePlayer(player);
            Bukkit.broadcastMessage("§e" + player.getName() + " has left the SkyWars game.");
            if (skyWarsGame.getPlayerCount() < 2) {
                skyWarsGame.endGame();
            }
        }

        if (murderMysteryGame.isPlayerInGame(player)) {
            murderMysteryGame.removePlayer(player);
            Bukkit.broadcastMessage("§e" + player.getName() + " has left the Murder Mystery game.");
            if (murderMysteryGame.getPlayerCount() < 2) {
                murderMysteryGame.endGame();
            }
        }
    }

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {
        Player player = event.getEntity();

        // Handle death for all game types
        if (bedWarsGame.isPlayerInGame(player)) {
            bedWarsGame.handlePlayerDeath(player);
        }

        if (hungerGamesGame.isPlayerInGame(player)) {
            hungerGamesGame.handlePlayerDeath(player);
        }

        if (skyWarsGame.isPlayerInGame(player)) {
            skyWarsGame.handlePlayerDeath(player);
        }

        if (murderMysteryGame.isPlayerInGame(player)) {
            murderMysteryGame.handlePlayerDeath(player);
        }
    }

    @EventHandler
    public void onPlayerDamage(EntityDamageEvent event) {
        if (event.getEntity() instanceof Player) {
            Player player = (Player) event.getEntity();

            // Prevent damage if the game hasn't started
            if (!bedWarsGame.isGameStarted() && bedWarsGame.isPlayerInGame(player)) {
                event.setCancelled(true);
            }

            if (!hungerGamesGame.isGameStarted() && hungerGamesGame.isPlayerInGame(player)) {
                event.setCancelled(true);
            }

            if (!skyWarsGame.isGameStarted() && skyWarsGame.isPlayerInGame(player)) {
                event.setCancelled(true);
            }

            if (!murderMysteryGame.isGameStarted() && murderMysteryGame.isPlayerInGame(player)) {
                event.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        Player player = event.getPlayer();

        // Prevent block breaking if not in the game
        if (!bedWarsGame.isPlayerInGame(player) && !hungerGamesGame.isPlayerInGame(player)
                && !skyWarsGame.isPlayerInGame(player) && !murderMysteryGame.isPlayerInGame(player)) {
            event.setCancelled(true);
        }

        // Add additional logic specific to each game if needed
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();

        // Prevent inventory access if not in the game
        if (!bedWarsGame.isPlayerInGame(player) && !hungerGamesGame.isPlayerInGame(player)
                && !skyWarsGame.isPlayerInGame(player) && !murderMysteryGame.isPlayerInGame(player)) {
            event.setCancelled(true);
        }

        // Add additional logic for loot management if needed
    }
}