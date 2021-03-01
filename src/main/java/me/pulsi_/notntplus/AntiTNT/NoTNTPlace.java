package me.pulsi_.notntplus.AntiTNT;

import me.pulsi_.notntplus.Main;
import me.pulsi_.notntplus.Managers.ConfigManager;
import me.pulsi_.notntplus.Managers.Translator;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class NoTNTPlace implements Listener {

    @EventHandler
    public void NoTNT(BlockPlaceEvent e) {
        if (Main.getInstance().getConfig().getBoolean("disable_tnt_place")) {
            Player player = (Player) e.getPlayer();
            if (!(player.hasPermission("notntplus.place"))) {
                if (e.getBlock().getType().equals(Material.TNT)) {
                    e.setCancelled(true);

                    ConfigManager messages = new ConfigManager(Main.getInstance(), "messages.yml");

                    if (messages.getConfig().getBoolean("place_send_message")) {
                        player.sendMessage(Translator.Colors(messages.getConfig().getString("place_message")));
                    }

                    if (messages.getConfig().getBoolean("place_send_report")) {
                        String reportMessage = messages.getConfig().getString("place_report_message");
                        String placer = e.getPlayer().getName();
                        Bukkit.getConsoleSender().sendMessage(Translator.Colors(reportMessage.replace("%player%", placer + "")));
                    }
                }
            }
        }
    }
}
