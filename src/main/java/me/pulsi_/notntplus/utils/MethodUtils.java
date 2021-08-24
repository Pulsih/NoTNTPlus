package me.pulsi_.notntplus.utils;

import me.pulsi_.notntplus.NoTNTPlus;
import me.pulsi_.notntplus.managers.MessageManager;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class MethodUtils {

    public static void interactAlertAdmins(Player p, PlayerInteractEvent e) {
        for (Player admins : Bukkit.getOnlinePlayers())
            if (JavaPlugin.getPlugin(NoTNTPlus.class).config().getBoolean("admin-broadcast-alerts"))
                if (admins.hasPermission("notntplus.alerts"))
                    MessageManager.interactAlertAdmin(admins, p, e, JavaPlugin.getPlugin(NoTNTPlus.class));
    }

    public static void placeAlertAdmins(Player p) {
        for (Player admins : Bukkit.getOnlinePlayers())
            if (JavaPlugin.getPlugin(NoTNTPlus.class).config().getBoolean("admin-broadcast-alerts"))
                if (admins.hasPermission("notntplus.alerts"))
                    MessageManager.placeAlertAdmin(admins, p, JavaPlugin.getPlugin(NoTNTPlus.class));
    }
}
