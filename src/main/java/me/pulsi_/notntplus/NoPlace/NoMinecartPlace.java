package me.pulsi_.notntplus.NoPlace;

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

public class NoMinecartPlace implements Listener {

    ConfigManager messages = new ConfigManager(Main.getInstance(), "messages.yml");

    @EventHandler
    public void NoMinecart(PlayerInteractEvent e) {
        if (Main.getInstance().getConfig().getBoolean("place.disable_tntminecart_place")) {
            Player player = (Player) e.getPlayer();
            if (!(player.hasPermission("notntplus.place.tntminecart"))) {
                if (e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
                    if (e.getItem() != null) {
                        if (e.getItem().getType().equals(Material.TNT_MINECART)) {
                            e.setCancelled(true);

                            if (messages.getConfig().getBoolean("send_tntminecartplace_message")) {
                                player.sendMessage(Translator.Colors(messages.getConfig().getString("tntminecartplace_message")));
                            }

                            if (messages.getConfig().getBoolean("send_tntminecartplace_report")) {
                                String reportMessage = messages.getConfig().getString("tntminecartplace_report_message");
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