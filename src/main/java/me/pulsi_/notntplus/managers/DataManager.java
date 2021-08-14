package me.pulsi_.notntplus.managers;

import me.pulsi_.notntplus.NoTNTPlus;
import me.pulsi_.notntplus.cmds.Commands;
import me.pulsi_.notntplus.cmds.Tab;
import me.pulsi_.notntplus.events.*;
import me.pulsi_.notntplus.gui.GuiListener;
import me.pulsi_.notntplus.others.UpdateChecker;
import me.pulsi_.notntplus.utils.ChatUtils;

public class DataManager {

    private NoTNTPlus plugin;
    public DataManager(NoTNTPlus plugin) {
        this.plugin = plugin;
    }

    public void loadCommands() {
        plugin.getCommand("notntplus").setExecutor(new Commands(plugin));
        plugin.getCommand("notntplus").setTabCompleter(new Tab());
    }

    public void loadEvents() {
        plugin.getServer().getPluginManager().registerEvents(new Explosions(plugin), plugin);
        plugin.getServer().getPluginManager().registerEvents(new Place(plugin), plugin);
        plugin.getServer().getPluginManager().registerEvents(new Pickup(plugin), plugin);
        plugin.getServer().getPluginManager().registerEvents(new Interact(plugin), plugin);
        plugin.getServer().getPluginManager().registerEvents(new Damage(plugin), plugin);
        plugin.getServer().getPluginManager().registerEvents(new UpdateChecker(plugin), plugin);
        plugin.getServer().getPluginManager().registerEvents(new GuiListener(), plugin);
    }

    public void startupMessage() {
        plugin.getServer().getConsoleSender().sendMessage("");
        plugin.getServer().getConsoleSender().sendMessage(ChatUtils.c("&8[&a&lNo&c&lTNT&b&l+&8] &bv%v%").replace("%v%", plugin.getDescription().getVersion()));
        plugin.getServer().getConsoleSender().sendMessage(ChatUtils.c("&2Enabling Plugin!"));
        plugin.getServer().getConsoleSender().sendMessage("");
    }

    public void shutdownMessage() {
        plugin.getServer().getConsoleSender().sendMessage("");
        plugin.getServer().getConsoleSender().sendMessage(ChatUtils.c("&8[&a&lNo&c&lTNT&b&l+&8]"));
        plugin.getServer().getConsoleSender().sendMessage(ChatUtils.c("&cDisabling Plugin!"));
        plugin.getServer().getConsoleSender().sendMessage("");
    }
}
