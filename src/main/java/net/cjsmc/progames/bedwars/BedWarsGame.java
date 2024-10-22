package net.cjsmc.progames.bedwars;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BedWarsGame implements CommandExecutor {
    private List<Player> players = new ArrayList<>();
    private Map<Player, Integer> scores = new HashMap<>();
    private boolean gameStarted = false;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (label.equalsIgnoreCase("bedwars")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;

                if (gameStarted) {
                    player.sendMessage("§cGame is already in progress.");
                } else {
                    if (!players.contains(player)) {
                        players.add(player);
                        scores.put(player, 0);
                        player.sendMessage("§aYou joined the BedWars game!");

                        // Start game if enough players have joined
                        if (players.size() >= 2) {
                            startGame();
                        }
                    } else {
                        player.sendMessage("§eYou are already in the game.");
                    }
                }
            } else {
                sender.sendMessage("§cOnly players can start BedWars games.");
            }
            return true;
        }
        return false;
    }

    private void startGame() {
        gameStarted = true;
        Bukkit.broadcastMessage("§aBedWars game has started! Good luck!");

        // Game loop example
        new BukkitRunnable() {
            int countdown = 300; // 5 minutes

            @Override
            public void run() {
                if (countdown <= 0) {
                    endGame();
                    cancel();
                } else {
                    countdown--;
                    if (countdown % 60 == 0) {
                        Bukkit.broadcastMessage("§eTime remaining: " + (countdown / 60) + " minutes.");
                    }
                }
            }
        }.runTaskTimer(MyPlugin.getInstance(), 0, 20); // 20 ticks = 1 second
    }

    private void endGame() {
        gameStarted = false;

        // Determine the winner based on scores or remaining players
        Player winner = determineWinner();
        if (winner != null) {
            Bukkit.broadcastMessage("§a" + winner.getName() + " has won the BedWars game!");
        } else {
            Bukkit.broadcastMessage("§cThe game ended without a winner.");
        }

        resetGame();
    }

    private Player determineWinner() {
        // Placeholder logic for determining a winner
        // You can change this to your game's winning conditions
        if (players.size() > 0) {
            return players.get(0); // Default winner, change to actual winner logic
        }
        return null;
    }

    private void resetGame() {
        players.clear();
        scores.clear();
        gameStarted = false;
        Bukkit.broadcastMessage("§eThe game has been reset. Players can rejoin!");
    }
}