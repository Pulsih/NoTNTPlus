package me.pulsi_.notntplus.NoExplosions;

import me.pulsi_.notntplus.Main;
import me.pulsi_.notntplus.Managers.ConfigManager;
import me.pulsi_.notntplus.Managers.Translator;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class NoBedExplosion implements Listener {

    ConfigManager messages = new ConfigManager(Main.getInstance(), "messages.yml");

    @EventHandler
    public void disableBedExplosion(PlayerInteractEvent e) {
        Player p = (Player) e.getPlayer();
        if (Main.getInstance().getConfig().getBoolean("explosions.disable_bed_explosion")) {
            if (!(p.hasPermission("notntplus.bed"))) {
                if (e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
                    if (e.getClickedBlock().getType().name().contains("BED")) {
                        e.setCancelled(true);

                        if (messages.getConfig().getBoolean("interact_send_message")) {
                            p.sendMessage(Translator.Colors(messages.getConfig().getString("interact_message")));
                        }

                        if (messages.getConfig().getBoolean("interact_send_report")) {
                            String reportMessage = messages.getConfig().getString("interact_report_message");
                            String activator = e.getPlayer().getName();
                            Bukkit.getConsoleSender().sendMessage(Translator.Colors(reportMessage.replace("%player%", activator + "")));
                        }
                    }
                }
            }
        }
    }
}