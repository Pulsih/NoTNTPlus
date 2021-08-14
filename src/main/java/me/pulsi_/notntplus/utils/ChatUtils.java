package me.pulsi_.notntplus.utils;

import net.md_5.bungee.api.ChatColor;

public class ChatUtils {
    public static String c(String message) {
        return ChatColor.translateAlternateColorCodes('&', message);
    }
}
