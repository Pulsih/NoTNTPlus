package me.pulsi_.notntplus.managers;

import me.pulsi_.notntplus.NoTNTPlus;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class ConfigManager {

    private final NoTNTPlus plugin;
    private File configFile, messagesFile;
    private FileConfiguration config, messages;

    public ConfigManager(NoTNTPlus plugin) {
        this.plugin = plugin;
    }

    public void createConfigs() {
        configFile = new File(plugin.getDataFolder(), "config.yml");
        messagesFile = new File(plugin.getDataFolder(), "messages.yml");

        if (!configFile.exists()) {
            configFile.getParentFile().mkdir();
            plugin.saveResource("config.yml", false);
        }
        if (!messagesFile.exists()) {
            messagesFile.getParentFile().mkdir();
            plugin.saveResource("messages.yml", false);
        }

        config = new YamlConfiguration();
        messages = new YamlConfiguration();

        try {
            config.load(configFile);
            messages.load(messagesFile);
        } catch (InvalidConfigurationException | IOException e) {
            e.printStackTrace();
        }
    }

    public FileConfiguration getConfiguration() {
        return config;
    }
    public FileConfiguration getMessages() {
        return messages;
    }

    public void reloadConfigs() {
        config = YamlConfiguration.loadConfiguration(configFile);
        messages = YamlConfiguration.loadConfiguration(messagesFile);
    }

    public void saveConfig() {
        try {
            config.save(configFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}