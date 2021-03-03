package me.pulsi_.notntplus.Managers;

import jdk.nashorn.internal.runtime.regexp.joni.Config;
import me.pulsi_.notntplus.Main;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.*;
import java.nio.charset.Charset;

public class ConfigManager {

    private final JavaPlugin plugin;
    private final String name;
    private File file;
    private FileConfiguration configuration;

    public ConfigManager(JavaPlugin plugin, String name) {
        this(plugin, new File(plugin.getDataFolder(), name));
    }

    public ConfigManager(JavaPlugin plugin, File file) {
        this.plugin = plugin;
        this.name = file.getName();
        this.file = file;

        if (!file.exists()) {
            if (plugin.getResource(name) == null)
                try {
                    file.createNewFile();
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            else saveDefaultConfig();
        }
        reloadConfig();
    }

    public void reloadConfig() {
        configuration = YamlConfiguration.loadConfiguration(file);
    }


    public FileConfiguration getConfig() {
        if (configuration == null) {
            reloadConfig();
        }
        return configuration;
    }


    public void saveConfig() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.write(String.valueOf(file));
            writer.flush();
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }



    public void saveDefaultConfig() {
        if (!(file.exists())) {
            plugin.saveResource(name, false);
        }
    }



    public void createNewFile(boolean replaceExisting) {
        try {
            if (file.exists() && replaceExisting) {
                file.delete();
            }
            file.createNewFile();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}