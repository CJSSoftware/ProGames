package net.cjsmc.progames.minigames.bedwars.commands;

import net.cjsmc.progames.minigames.bedwars.Arena;
import net.cjsmc.progames.minigames.bedwars.BedWars;
import net.cjsmc.progames.minigames.bedwars.Team;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.Map;

public class GameCommand implements CommandExecutor {
    private final JavaPlugin plugin;
    private final Map<String, Arena> arenas;

    public GameCommand(JavaPlugin plugin) {
        this.plugin = plugin;
        this.arenas = new HashMap<>();
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("This command can only be executed by a player!");
            return true;
        }

        Player player = (Player) sender;

        if (args.length == 0) {
            player.sendMessage("Usage: /bwarena <create|join> [name]");
            return true;
        }

        switch (args[0].toLowerCase()) {
            case "create":
                if (args.length < 2) {
                    player.sendMessage("Usage: /bwarena create <arenaname>");
                    return true;
                }
                createArena(args[1], player.getLocation());
                player.sendMessage("Arena " + args[1] + " created!");
                break;

            case "join":
                if (args.length < 2) {
                    player.sendMessage("Usage: /bwarena join <arenaname>");
                    return true;
                }
                joinArena(args[1], player);
                break;

            default:
                player.sendMessage("Unknown command. Use /bwarena <create|join>");
        }
        return true;
    }

    private void createArena(String name, Location location) {
        if (arenas.containsKey(name)) {
            Bukkit.getPlayer(name).sendMessage("Arena " + name + " already exists!");
            return;
        }
        Arena arena = new Arena(name);
        for (int i = 1; i <= 8; i++) {
            // Create teams with unique colors and bed locations
            Location bedLocation = location.clone().add(i, 0, 0); // Example: bed position based on team number
            Team team = new Team("Team " + i, ChatColor.values()[i % ChatColor.values().length], bedLocation);
            arena.addTeam(team);
        }
        // Add spawners for items (example locations)
        arena.addSpawner("iron", location.add(0, 1, 0), Material.IRON_INGOT);
        arena.addSpawner("diamond", location.add(0, 0, 2), Material.DIAMOND);
        arena.addSpawner("emerald", location.add(0, 0, 4), Material.EMERALD);

        arenas.put(name, arena);
        ((BedWars) plugin).addArena(arena);
    }


    private void joinArena(String name, Player player) {
        Arena arena = ((BedWars) plugin).getArena(name);
        if (arena == null) {
            player.sendMessage("Arena " + name + " does not exist!");
            return;
        }

        // Get the bed location of the first team
        Location bedLocation = arena.getTeams().get(0).getBed().getLocation(); // Now this works correctly
        player.teleport(bedLocation); // Teleport the player to the bed location
        player.sendMessage("You have joined the arena " + name + "!");
    }
}
