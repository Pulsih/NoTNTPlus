package me.pulsi_.notntplus.Interact;

import me.pulsi_.notntplus.Main;
import me.pulsi_.notntplus.Managers.ConfigManager;
import me.pulsi_.notntplus.Managers.Translator;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class NoTNTInteract implements Listener {

    ConfigManager messages = new ConfigManager(Main.getInstance(), "messages.yml");

    @EventHandler
    public void playerInteract(PlayerInteractEvent e) {
        if (Main.getInstance().getConfig().getBoolean("interact.disable_tnt_interact")) {
            Player p = (Player) e.getPlayer();
            if (!(p.hasPermission("notntplus.interact.tnt"))) {
                if (e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
                    if (e.getClickedBlock().getType().equals(Material.TNT)) {
                        if (e.getItem() != null) {
                            if (e.getItem().getType().equals(Material.FLINT_AND_STEEL)) {
                                for (String worlds : Main.getInstance().getConfig().getStringList("interact_worlds.interact_tnt_worlds")) {
                                    if (worlds.contains(p.getWorld().getName())) {
                                        e.setCancelled(true);

                                        if (messages.getConfig().getBoolean("send_tntinteract_message")) {
                                            p.sendMessage(Translator.Colors(messages.getConfig().getString("tntinteract_message")));
                                        }

                                        if (messages.getConfig().getBoolean("send_tntinteract_report")) {
                                            String reportMessage = messages.getConfig().getString("tntinteract_report_message");
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
    }
}