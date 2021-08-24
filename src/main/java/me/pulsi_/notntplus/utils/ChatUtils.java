package me.pulsi_.notntplus.utils;

import me.pulsi_.notntplus.NoTNTPlus;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class ChatUtils {
    public static String c(String message) {
        return ChatColor.translateAlternateColorCodes('&', message);
    }
    public static void consoleMessage(String message) {
        JavaPlugin.getPlugin(NoTNTPlus.class).getServer().getConsoleSender().sendMessage(c(message));
    }
}