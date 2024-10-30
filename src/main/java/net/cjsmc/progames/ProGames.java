package net.cjsmc.progames;

import net.cjsmc.progames.bedwars.BedWars;
import net.cjsmc.progames.commandManager.CommandManager;
import net.cjsmc.progames.commandManager.ExampleCommand;
import org.bukkit.plugin.java.JavaPlugin;

public class ProGames extends JavaPlugin {

    private BedWars bedWars;

    public void onEnable() {
       //Startup logic
        new CommandManager(this, new ExampleCommand());
        this.bedWars = new BedWars();
    }

    @Override
    public void onDisable() {
        // Shutdown logic
    }

    public BedWars getBedWars() {
        return bedWars;
    }
}
