package me.pulsi_.notntplus;

import me.pulsi_.notntplus.Commands.Commands;
import me.pulsi_.notntplus.Interact.NoBedInteract;
import me.pulsi_.notntplus.Interact.NoTNTInteract;
import me.pulsi_.notntplus.Managers.UpdateChecker;
import me.pulsi_.notntplus.NoDamage.NoBedDamagePlayers;
import me.pulsi_.notntplus.NoDamage.NoTNTDamageMobs;
import me.pulsi_.notntplus.NoDamage.NoTNTDamagePlayers;
import me.pulsi_.notntplus.NoExplosions.NoBedExplosion;
import me.pulsi_.notntplus.NoPickup.NoPickupBed;
import me.pulsi_.notntplus.NoPickup.NoPickupCreeper;
import me.pulsi_.notntplus.NoPickup.NoPickupMinecart;
import me.pulsi_.notntplus.NoPickup.NoPickupTNT;
import me.pulsi_.notntplus.Managers.ConfigManager;
import me.pulsi_.notntplus.Managers.Translator;
import me.pulsi_.notntplus.NoExplosions.NoCreeperExplosion;
import me.pulsi_.notntplus.NoExplosions.NoMinecartExplosion;
import me.pulsi_.notntplus.NoExplosions.NoTNTExplosion;
import me.pulsi_.notntplus.NoPlace.NoBedPlace;
import me.pulsi_.notntplus.NoPlace.NoCreeperPlace;
import me.pulsi_.notntplus.NoPlace.NoMinecartPlace;
import me.pulsi_.notntplus.NoPlace.NoTNTPlace;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    private static Main instance;
    public static Main getInstance() {
        return instance;
    }

    ConfigManager messagesConfig, defaultConfig;

    @Override
    public void onEnable() {
        instance = this;

        saveDefaultConfig();
        this.messagesConfig = new ConfigManager(this, "messages.yml");

        //------------------------------------------------------------------------------------------------
        // Listeners / Commands
        getCommand("notntplus").setExecutor(new Commands());

        getServer().getPluginManager().registerEvents(new UpdateChecker(), this);

        getServer().getPluginManager().registerEvents(new NoTNTDamagePlayers(), this);
        getServer().getPluginManager().registerEvents(new NoTNTDamageMobs(), this);
        getServer().getPluginManager().registerEvents(new NoBedDamagePlayers(), this);

        getServer().getPluginManager().registerEvents(new NoTNTPlace(), this);
        getServer().getPluginManager().registerEvents(new NoMinecartPlace(), this);
        getServer().getPluginManager().registerEvents(new NoCreeperPlace(), this);
        getServer().getPluginManager().registerEvents(new NoBedPlace(), this);

        getServer().getPluginManager().registerEvents(new NoTNTInteract(), this);
        getServer().getPluginManager().registerEvents(new NoBedInteract(), this);

        getServer().getPluginManager().registerEvents(new NoPickupTNT(),this);
        getServer().getPluginManager().registerEvents(new NoPickupMinecart(), this);
        getServer().getPluginManager().registerEvents(new NoPickupCreeper(), this);
        getServer().getPluginManager().registerEvents(new NoPickupBed(), this);

        getServer().getPluginManager().registerEvents(new NoTNTExplosion(), this);
        getServer().getPluginManager().registerEvents(new NoCreeperExplosion(), this);
        getServer().getPluginManager().registerEvents(new NoMinecartExplosion(), this);
        getServer().getPluginManager().registerEvents(new NoBedExplosion(), this);
        // Listeners / Commands
        //------------------------------------------------------------------------------------------------

        //------------------------------------------------------------------------------------------------
        // The Console message for Start
        getServer().getConsoleSender().sendMessage(Translator.Colors("&8"));
        getServer().getConsoleSender().sendMessage(Translator.Colors("&8&m---------------"));
        getServer().getConsoleSender().sendMessage(Translator.Colors("&8"));
        getServer().getConsoleSender().sendMessage(Translator.Colors("&8[&a&lNo&c&lTNT&b&l+&8] &bv%version%").replace("%version%", this.getDescription().getVersion()));
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

        //------------------------------------------------------------------------------------------------
        // The Console message for Shutdown
        getServer().getConsoleSender().sendMessage(Translator.Colors("&8"));
        getServer().getConsoleSender().sendMessage(Translator.Colors("&8&m---------------"));
        getServer().getConsoleSender().sendMessage(Translator.Colors("&8"));
        getServer().getConsoleSender().sendMessage(Translator.Colors("&8[&a&lNo&c&lTNT&b&l+&8] &bv%version%").replace("%version%", this.getDescription().getVersion()));
        getServer().getConsoleSender().sendMessage(Translator.Colors("&8"));
        getServer().getConsoleSender().sendMessage(Translator.Colors("&cDisabling Plugin!"));
        getServer().getConsoleSender().sendMessage(Translator.Colors("&8"));
        getServer().getConsoleSender().sendMessage(Translator.Colors("&8&m---------------"));
        getServer().getConsoleSender().sendMessage(Translator.Colors("&8"));
        // The Console message for Shutdown
        //------------------------------------------------------------------------------------------------

    }
}
