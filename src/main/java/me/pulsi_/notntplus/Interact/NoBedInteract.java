package me.pulsi_.notntplus.Interact;

import me.pulsi_.notntplus.Main;
import me.pulsi_.notntplus.Managers.ConfigManager;
import me.pulsi_.notntplus.Managers.Translator;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class NoBedInteract implements Listener {

    ConfigManager messages = new ConfigManager(Main.getInstance(), "messages.yml");

    @EventHandler
    public void playerInteract(PlayerInteractEvent e) {
        if (Main.getInstance().getConfig().getBoolean("interact.disable_bed_interact")) {
            Player p = (Player) e.getPlayer();
            if (!(p.hasPermission("notntplus.interact.bed"))) {
                if (e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
                    if (e.getClickedBlock().getType().name().endsWith("_BED")) {
                        for (String worlds : Main.getInstance().getConfig().getStringList("interact_worlds.interact_bed_worlds")) {
                            if (worlds.contains(p.getWorld().getName())) {
                                e.setCancelled(true);

                                if (messages.getConfig().getBoolean("send_bedinteract_message")) {
                                    p.sendMessage(Translator.Colors(messages.getConfig().getString("bedinteract_message")));
                                }

                                if (messages.getConfig().getBoolean("send_bedinteract_report")) {
                                    String reportMessage = messages.getConfig().getString("bedinteract_report_message");
                                    String activator = e.getPlayer().getName();
                                    Bukkit.getConsoleSender().sendMessage(Translator.Colors(reportMessage.replace("%player%", activator + "")));
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}