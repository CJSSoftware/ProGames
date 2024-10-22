package net.cjsmc.progames.minigames.skywars.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class GameCommand implements CommandExecutor {
    private final JavaPlugin plugin;

    public GameCommand(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        // Command handling logic
        if (args.length == 0) {
            sender.sendMessage("Usage: /swarena <create|join> [name]");
            return true;
        }
        switch (args[0].toLowerCase()) {
            case "create":
                // Logic for creating arena
                break;
            case "join":
                // Logic for joining arena
                break;
            default:
                sender.sendMessage("Unknown command. Use /swarena <create|join>");
        }
        return true;
    }
}
