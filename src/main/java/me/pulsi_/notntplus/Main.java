package me.pulsi_.notntplus;

import me.pulsi_.notntplus.AntiTNT.*;
import me.pulsi_.notntplus.Managers.UpdateChecker;
import me.pulsi_.notntplus.NoPickup.NoPickupCreeper;
import me.pulsi_.notntplus.NoPickup.NoPickupMinecart;
import me.pulsi_.notntplus.NoPickup.NoPickupTNT;
import me.pulsi_.notntplus.Managers.ConfigManager;
import me.pulsi_.notntplus.Managers.Translator;
import me.pulsi_.notntplus.NoExplosions.NoCreeperExplosion;
import me.pulsi_.notntplus.NoExplosions.NoMinecartExplosion;
import me.pulsi_.notntplus.NoExplosions.NoTNTExplosion;
import me.pulsi_.notntplus.Panel.ExplosionManagerListener;
import me.pulsi_.notntplus.Panel.GUIListener;
import me.pulsi_.notntplus.Panel.PickupManagerListener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public final class Main extends JavaPlugin {

    private static Main instance;
    public static Main getInstance() {
        return instance;
    }

    ConfigManager messagesConfig;

    @Override
    public void onEnable() {
        instance = this;

        Logger logger = this.getLogger();
        if (getConfig().getBoolean("update_checker")) {
            new UpdateChecker(this, 89432).getVersion(version -> {
                if (this.getDescription().getVersion().equalsIgnoreCase(version)) {
                    logger.info(Translator.Colors("&8&m-----------------------"));
                    logger.info(Translator.Colors("&8"));
                    logger.info(Translator.Colors("&8[&a&lNo&c&lTNT&b&l+&8]"));
                    logger.info(Translator.Colors("&2&lThere are no updates available!"));
                    logger.info(Translator.Colors("&8"));
                    logger.info(Translator.Colors("&8&m-----------------------"));
                } else {
                    logger.info(Translator.Colors("&8&m-----------------------"));
                    logger.info(Translator.Colors("&8"));
                    logger.info(Translator.Colors("&8[&a&lNo&c&lTNT&b&l+&8]"));
                    logger.info(Translator.Colors("&2&lThere is a new update available!"));
                    logger.info(Translator.Colors("&8"));
                    logger.info(Translator.Colors("&7Download it at:"));
                    logger.info(Translator.Colors("&bhttps://www.spigotmc.org/resources/%E2%9A%A1%EF%B8%8F-notnt-%E2%9A%A1%EF%B8%8F-anti-tnt-plugin-for-the-server-security.89432/"));
                    logger.info(Translator.Colors("&8"));
                    logger.info(Translator.Colors("&8&m-----------------------"));
                }
            });
        }

        this.messagesConfig = new ConfigManager(this, "messages.yml");
        this.saveDefaultConfig();

        //------------------------------------------------------------------------------------------------
        // Listeners / Commands
        getCommand("notntplus").setExecutor(new Commands());

        getServer().getPluginManager().registerEvents(new GUIListener(), this);
        getServer().getPluginManager().registerEvents(new ExplosionManagerListener(), this);
        getServer().getPluginManager().registerEvents(new PickupManagerListener(), this);

        getServer().getPluginManager().registerEvents(new NoTNTPlace(), this);
        getServer().getPluginManager().registerEvents(new NoTNTInteract(), this);
        getServer().getPluginManager().registerEvents(new NoTNTDamage(), this);

        getServer().getPluginManager().registerEvents(new NoPickupTNT(),this);
        getServer().getPluginManager().registerEvents(new NoPickupMinecart(), this);
        getServer().getPluginManager().registerEvents(new NoPickupCreeper(), this);

        getServer().getPluginManager().registerEvents(new NoTNTExplosion(), this);
        getServer().getPluginManager().registerEvents(new NoCreeperExplosion(), this);
        getServer().getPluginManager().registerEvents(new NoMinecartExplosion(), this);
        // Listeners / Commands
        //------------------------------------------------------------------------------------------------

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
