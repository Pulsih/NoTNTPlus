package me.pulsi_.notntplus.NoPlace;

import me.pulsi_.notntplus.Main;
import me.pulsi_.notntplus.Managers.ConfigManager;
import me.pulsi_.notntplus.Managers.Translator;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class NoTNTPlace implements Listener {

    ConfigManager messages = new ConfigManager(Main.getInstance(), "messages.yml");

    @EventHandler
    public void NoTNT(PlayerInteractEvent e) {
        if (Main.getInstance().getConfig().getBoolean("place.disable_tnt_place")) {
            Player p = (Player) e.getPlayer();
            if (!(p.hasPermission("notntplus.place.tnt"))) {
                if (e.getItem() != null) {
                    if (e.getItem().getType().equals(Material.TNT)) {
                        for (String worlds : Main.getInstance().getConfig().getStringList("place_worlds.place_tnt_worlds")) {
                            if (worlds.contains(p.getWorld().getName())) {
                                e.setCancelled(true);

                                if (messages.getConfig().getBoolean("send_tntplace_message")) {
                                    p.sendMessage(Translator.Colors(messages.getConfig().getString("tntplace_message")));
                                }

                                if (messages.getConfig().getBoolean("send_tntplace_report")) {
                                    String reportMessage = messages.getConfig().getString("tntplace_report_message");
                                    String placer = e.getPlayer().getName();
                                    Bukkit.getConsoleSender().sendMessage(Translator.Colors(reportMessage.replace("%player%", placer + "")));
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}