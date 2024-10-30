package net.cjsmc.progames.commandManager;

import org.bukkit.command.CommandSender;

public class ExampleCommand {
    @Command(name = "example", description = "An example command")
    public void exampleCommand(CommandSender sender, String[] args) {
        sender.sendMessage("This is an example command!");
    }
}