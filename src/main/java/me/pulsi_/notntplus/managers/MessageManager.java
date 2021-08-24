package me.pulsi_.notntplus.managers;

import me.pulsi_.notntplus.NoTNTPlus;
import me.pulsi_.notntplus.utils.ChatUtils;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;

public class MessageManager {

    public static void reloadMessage(CommandSender s, NoTNTPlus plugin) {
        s.sendMessage(ChatUtils.c(plugin.messages().getString("reload-message")));
    }

    public static void unknownCommand(CommandSender s, NoTNTPlus plugin) {
        s.sendMessage(ChatUtils.c(plugin.messages().getString("unknown-command")));
    }

    public static void noPermission(CommandSender s, NoTNTPlus plugin) {
        s.sendMessage(ChatUtils.c(plugin.messages().getString("no-permission")));
    }

    public static void cantPlace(Player p, NoTNTPlus plugin) {
        if (plugin.messages().getString("deny-place") == null) return;
        p.sendMessage(ChatUtils.c(plugin.messages().getString("deny-place")));
    }

    public static void cantInteract(Player p, NoTNTPlus plugin) {
        if (plugin.messages().getString("deny-interact") == null) return;
        p.sendMessage(ChatUtils.c(plugin.messages().getString("deny-interact")));
    }

    public static void placeAlert(Player p, NoTNTPlus plugin) {
        if (plugin.messages().getString("place-alert") == null) return;
        ChatUtils.consoleMessage(plugin.messages().getString("place-alert").replace("%player%", p.getName()).replace("%item%", p.getItemInHand().getType().toString()));
    }

    public static void placeAlertAdmin(Player admin, Player p, NoTNTPlus plugin) {
        if (plugin.messages().getString("place-alert") == null) return;
        admin.sendMessage(ChatUtils.c(plugin.messages().getString("place-alert")
                .replace("%player%", p.getName()).replace("%item%", p.getItemInHand().getType().toString())));
    }

    public static void interactAlert(Player p, PlayerInteractEvent e, NoTNTPlus plugin) {
        if (plugin.messages().getString("interact-alert") == null) return;
        ChatUtils.consoleMessage(plugin.messages().getString("interact-alert")
                .replace("%player%", p.getName()).replace("%item%", e.getClickedBlock().getType().toString().replace("_BLOCK", "")));
    }

    public static void interactAlertAdmin(Player admin, Player p, PlayerInteractEvent e, NoTNTPlus plugin) {
        if (plugin.messages().getString("interact-alert") == null) return;
        admin.sendMessage(ChatUtils.c(plugin.messages().getString("interact-alert")
                .replace("%player%", p.getName()).replace("%item%", e.getClickedBlock().getType().toString().replace("_BLOCK", ""))));
    }
}