package net.cjsmc.progames.commandManager;

import org.bukkit.command.CommandSender;

public class ExampleCommand {
    @Command(name = "example", subcommand = "sub1", description = "Subcommand 1")
    public void exampleSubcommand1(CommandSender sender, String[] args) {
        sender.sendMessage("This is subcommand 1!");
    }

    @Command(name = "example", subcommand = "sub2", description = "Subcommand 2")
    public void exampleSubcommand2(CommandSender sender, String[] args) {
        sender.sendMessage("This is subcommand 2!");
    }
}