package net.cjsmc.progames;

import net.cjsmc.progames.commandManager.CommandManager;
import net.cjsmc.progames.commandManager.ExampleCommand;
import org.bukkit.plugin.java.JavaPlugin;

public class ProGames extends JavaPlugin {
    public void onEnable() {
       //Startup logic
        new CommandManager(this, new ExampleCommand());
    }

    @Override
    public void onDisable() {
        // Shutdown logic
    }
}
