package me.pulsi_.notntplus;

import me.pulsi_.notntplus.AntiTNT.*;
import me.pulsi_.notntplus.Managers.ConfigManager;
import me.pulsi_.notntplus.Managers.Translator;
import org.bukkit.plugin.java.JavaPlugin;

public final class NoTNTPlus extends JavaPlugin {

    private static NoTNTPlus instance;
    public static NoTNTPlus getInstance() {
        return instance;
    }

    ConfigManager messagesConfig;

    @Override
    public void onEnable() {
        instance = this;

        this.messagesConfig = new ConfigManager(this, "messages.yml");
        this.saveDefaultConfig();

        getCommand("notntplus").setExecutor(new Commands());
        getServer().getPluginManager().registerEvents(new NoTNTPlace(), this);
        getServer().getPluginManager().registerEvents(new TNTDrop(), this);
        getServer().getPluginManager().registerEvents(new NotPickupTNT(), this);
        getServer().getPluginManager().registerEvents(new DisableTNTPowerOn(), this);
        getServer().getPluginManager().registerEvents(new DisableExplosion(), this);


        //------------------------------------------------------------------------------------------------
        // The Console message for Start
        getServer().getConsoleSender().sendMessage(Translator.Colors("&8"));
        getServer().getConsoleSender().sendMessage(Translator.Colors("&8&m---------------"));
        getServer().getConsoleSender().sendMessage(Translator.Colors("&8"));
        getServer().getConsoleSender().sendMessage(Translator.Colors("&8[&a&lNo&c&lTNT&b&l+&8]"));
        getServer().getConsoleSender().sendMessage(Translator.Colors("&8"));
        getServer().getConsoleSender().sendMessage(Translator.Colors("&2Enabling Plugin!"));
        getServer().getConsoleSender().sendMessage(Translator.Colors("&8"));
        getServer().getConsoleSender().sendMessage(Translator.Colors("&8&m---------------"));
        getServer().getConsoleSender().sendMessage(Translator.Colors("&8"));
        // The Console message for Start
        //------------------------------------------------------------------------------------------------


    }

    @Override
    public void onDisable() {
        instance = this;
    }
}
