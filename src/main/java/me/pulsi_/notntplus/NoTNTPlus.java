package me.pulsi_.notntplus;

import me.pulsi_.notntplus.managers.ConfigManager;
import me.pulsi_.notntplus.managers.DataManager;
import me.pulsi_.notntplus.others.bStats;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class NoTNTPlus extends JavaPlugin {

    private ConfigManager configManager;
    private DataManager dataManager;
    
    @Override
    public void onEnable() {
        this.configManager = new ConfigManager(this);
        configManager.createConfigs();

        this.dataManager = new DataManager(this);
        dataManager.loadCommands();
        dataManager.loadEvents();
        dataManager.startupMessage();

        new bStats(this, 12403);
    }

    @Override
    public void onDisable() {
        this.dataManager = new DataManager(this);
        dataManager.shutdownMessage();
    }
    
    public FileConfiguration config() {
        return configManager.getConfiguration();
    }
    public FileConfiguration messages() {
        return configManager.getMessages();
    }
    public void reloadConfigs() {
        configManager.reloadConfigs();
    }
    public void saveConfig() {
        configManager.saveConfig();
    }
}
