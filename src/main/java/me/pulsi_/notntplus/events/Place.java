package me.pulsi_.notntplus.events;

import me.pulsi_.notntplus.NoTNTPlus;
import me.pulsi_.notntplus.managers.MessageManager;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class Place implements Listener {

    private NoTNTPlus plugin;
    public Place(NoTNTPlus plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void tntPlace(BlockPlaceEvent e) {
        Player p = e.getPlayer();
        if (!plugin.config().getBoolean("tnt.place.disable") || !(e.getBlock().getType() == Material.TNT) || !p.hasPermission("notntplus.place.tnt")) return;
        for (String worlds : plugin.config().getStringList("tnt.place.disabled-worlds")) {
            if (worlds.contains(e.getBlock().getWorld().getName())) return;
            e.setCancelled(true);
        }
        MessageManager.cantPlace(p, plugin);
        MessageManager.placeAlert(p, plugin);
    }

    @EventHandler
    public void tntminecartPlace(PlayerInteractEvent e) {
        if (!plugin.config().getBoolean("tntminecart.place.disable")) return;
        if (e.getAction() == Action.RIGHT_CLICK_BLOCK || e.getAction() == Action.RIGHT_CLICK_AIR) {
            Player p = e.getPlayer();
            if (p.hasPermission("notntplus.place.tntminecart")) return;
            try {
                if (!(p.getItemInHand().getType() == Material.TNT_MINECART)) return;
            } catch (NoSuchFieldError er) {
                if (!(p.getItemInHand().getType().name().contains("EXPLOSIVE_MINECART"))) return;
            }
            for (String worlds : plugin.config().getStringList("tntminecart.place.disabled-worlds")) {
                if (worlds.contains(p.getWorld().getName())) return;
                e.setCancelled(true);
            }
            MessageManager.cantPlace(p, plugin);
            MessageManager.placeAlert(p, plugin);
        }
    }

    @EventHandler
    public void creeperPlace(PlayerInteractEvent e) {
        if (!plugin.config().getBoolean("creeperegg.place.disable")) return;
        if (e.getAction() == Action.RIGHT_CLICK_BLOCK || e.getAction() == Action.RIGHT_CLICK_AIR) {
            Player p = e.getPlayer();
            if (p.hasPermission("notntplus.place.creeperegg")) return;
            try {
                if (!(p.getItemInHand().getType() == Material.CREEPER_SPAWN_EGG)) return;
            } catch (NoSuchFieldError er) {
                if (!(p.getItemInHand().getType().name().equals("MONSTER_EGG"))) return;
            }
            for (String worlds : plugin.config().getStringList("creeperegg.place.disabled-worlds")) {
                if (worlds.contains(p.getWorld().getName())) return;
                e.setCancelled(true);
            }
            MessageManager.cantPlace(p, plugin);
            MessageManager.placeAlert(p, plugin);
        }
    }

    @EventHandler
    public void bedPlace(BlockPlaceEvent e) {
        if (!plugin.config().getBoolean("bed.place.disable")) return;
        if (!(e.getBlock().getType().name().contains("BED"))) return;
        Player p = e.getPlayer();
        if (p.hasPermission("notntplus.place.bed")) return;
        for (String worlds : plugin.config().getStringList("bed.place.disabled-worlds")) {
            if (worlds.contains(e.getBlock().getWorld().getName())) return;
            e.setCancelled(true);
        }
        MessageManager.cantPlace(p, plugin);
        MessageManager.placeAlert(p, plugin);
    }
}