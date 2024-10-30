package net.cjsmc.progames.commandManager;

import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import net.cjsmc.progames.commandManager.Command;
import org.bukkit.command.PluginCommand;
import org.bukkit.plugin.java.JavaPlugin;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class CommandManager implements CommandExecutor {
    private final Map<String, Method> commands = new HashMap<>();
    private final Object commandObject;
    private final JavaPlugin plugin;

    public CommandManager(JavaPlugin plugin, Object commandObject) {
        this.plugin = plugin;
        this.commandObject = commandObject;
        registerCommands(commandObject);
    }

    private void registerCommands(Object commandObject) {
        for (Method method : commandObject.getClass().getDeclaredMethods()) {
            if (method.isAnnotationPresent(net.cjsmc.progames.commandManager.Command.class)) {
                Command command = method.getAnnotation(Command.class);
                commands.put(command.name(), method);
                registerCommand(command.name());
            }
        }
    }

    private void registerCommand(String commandName) {
        PluginCommand pluginCommand = plugin.getCommand(commandName);
        if (pluginCommand == null) {
            pluginCommand = plugin.getServer().getPluginCommand(commandName);
        }
        if (pluginCommand != null) {
            pluginCommand.setExecutor(this);
        } else {
            System.out.println("Command " + commandName + " is not defined in plugin.yml");
        }
    }

    @Override
    public boolean onCommand(CommandSender sender, org.bukkit.command.Command cmd, String label, String[] args) {
        Method method = commands.get(cmd.getName());
        if (method != null) {
            try {
                method.invoke(commandObject, sender, args);
                return true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}