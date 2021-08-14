package me.pulsi_.notntplus.events;

import me.pulsi_.notntplus.NoTNTPlus;
import me.pulsi_.notntplus.managers.MessageManager;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class Interact implements Listener {

    private final NoTNTPlus plugin;
    public Interact(NoTNTPlus plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void tntInteract(PlayerInteractEvent e) {
            Player p = e.getPlayer();
            if (e.getAction() != Action.RIGHT_CLICK_BLOCK || !plugin.config().getBoolean("tnt.interact.disable")|| e.getClickedBlock().getType() != Material.TNT ||
                    !p.hasPermission("notntplus.interact.tnt")) return;
            for (String worlds : plugin.config().getStringList("tnt.interact.disabled-worlds")) {
                if (!worlds.contains(p.getWorld().getName()))
                    e.setCancelled(true);
            }
            MessageManager.cantInteract(p, plugin);
            MessageManager.interactAlert(p, e, plugin);
    }

    @EventHandler
    public void bedInteract(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        if (e.getAction() != Action.RIGHT_CLICK_BLOCK || !plugin.config().getBoolean("bed.interact.disable")|| !e.getClickedBlock().getType().name().contains("BED") ||
                !p.hasPermission("notntplus.interact.bed")) return;
        for (String worlds : plugin.config().getStringList("bed.interact.disabled-worlds")) {
            if (!worlds.contains(p.getWorld().getName()))
                e.setCancelled(true);
        }
        MessageManager.cantInteract(p, plugin);
        MessageManager.interactAlert(p, e, plugin);
    }
}
