package me.pulsi_.notntplus.AntiTNT;

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

    @EventHandler
    public void playerInteract(PlayerInteractEvent e) {
        if (Main.getInstance().getConfig().getBoolean("disable_tnt_interact")) {
            Player player = (Player) e.getPlayer();
            if (!(player.hasPermission("notntplus.interact"))) {
                if (e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
                    if (e.getClickedBlock().getType().equals(Material.TNT)) {
                        if (player.getInventory().getItemInMainHand().getType().equals(Material.FLINT_AND_STEEL)) {
                            e.setCancelled(true);

                            ConfigManager messages = new ConfigManager(Main.getInstance(), "messages.yml");

                            if (messages.getConfig().getBoolean("interact_send_message")) {
                                player.sendMessage(Translator.Colors(messages.getConfig().getString("interact_message")));
                            }

                            if (messages.getConfig().getBoolean("interact_send_report")) {
                                String reportMessage = messages.getConfig().getString("interact_report_message");
                                String activator = e.getPlayer().getName();
                                Bukkit.getConsoleSender().sendMessage(Translator.Colors(reportMessage.replace("%player%", activator + "")));
                            }

                            if (Main.getInstance().getConfig().getBoolean("remove_the_clicked_tnt")) {
                                e.getClickedBlock().setType(Material.AIR);
                            }
                        }
                    }
                }
            }
        }
    }
}
