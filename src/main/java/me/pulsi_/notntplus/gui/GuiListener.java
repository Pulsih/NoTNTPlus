package me.pulsi_.notntplus.gui;

import me.pulsi_.notntplus.utils.ChatUtils;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.util.ArrayList;
import java.util.List;

public class GuiListener implements Listener {

    @EventHandler
    public void onItemClick(InventoryClickEvent e) {
        if (!e.getView().getTitle().equals(ChatUtils.c("&aNo&cTNT&b+ &aControl Panel"))) return;
        if (e.getCurrentItem() == null) return;
        tntButtonsClick(e);
        tntMinecraftButtonsClick(e);
        creeperEggButtonsClick(e);
        bedButtonsClick(e);
        explosionsButtonsClick(e);
    }

    private void tntButtonsClick(InventoryClickEvent e) {
        if (e.getSlot() == 10) {
            e.setCancelled(true);
        }
        if (e.getSlot() == 11) {
            List<String> lore = new ArrayList<>();
            for (String s : e.getCurrentItem().getItemMeta().getLore()) {
                lore.add(ChatUtils.c(s));
            }
            Gui.changeItem(11, "tnt.place.disable", lore);
            e.setCancelled(true);
        }

        if (e.getSlot() == 12) {
            List<String> lore = new ArrayList<>();
            for (String s : e.getCurrentItem().getItemMeta().getLore()) {
                lore.add(ChatUtils.c(s));
            }
            Gui.changeItem(12, "tnt.interact.disable", lore);
            e.setCancelled(true);
        }
        if (e.getSlot() == 13) {
            List<String> lore = new ArrayList<>();
            for (String s : e.getCurrentItem().getItemMeta().getLore()) {
                lore.add(ChatUtils.c(s));
            }
            Gui.changeItem(13, "tnt.explosion.disable", lore);
            e.setCancelled(true);
        }
        if (e.getSlot() == 14) {
            List<String> lore = new ArrayList<>();
            for (String s : e.getCurrentItem().getItemMeta().getLore()) {
                lore.add(ChatUtils.c(s));
            }
            Gui.changeItem(14, "tnt.pickup.disable", lore);
            e.setCancelled(true);
        }
    }

    private void tntMinecraftButtonsClick(InventoryClickEvent e) {
        if (e.getSlot() == 19) {
            e.setCancelled(true);
        }
        if (e.getSlot() == 20) {
            List<String> lore = new ArrayList<>();
            for (String s : e.getCurrentItem().getItemMeta().getLore()) {
                lore.add(ChatUtils.c(s));
            }
            Gui.changeItem(20, "tntminecart.place.disable", lore);
            e.setCancelled(true);
        }

        if (e.getSlot() == 21) {
            List<String> lore = new ArrayList<>();
            for (String s : e.getCurrentItem().getItemMeta().getLore()) {
                lore.add(ChatUtils.c(s));
            }
            Gui.changeItem(21, "tntminecart.interact.disable", lore);
            e.setCancelled(true);
        }
        if (e.getSlot() == 22) {
            List<String> lore = new ArrayList<>();
            for (String s : e.getCurrentItem().getItemMeta().getLore()) {
                lore.add(ChatUtils.c(s));
            }
            Gui.changeItem(22, "tntminecart.explosion.disable", lore);
            e.setCancelled(true);
        }
        if (e.getSlot() == 23) {
            List<String> lore = new ArrayList<>();
            for (String s : e.getCurrentItem().getItemMeta().getLore()) {
                lore.add(ChatUtils.c(s));
            }
            Gui.changeItem(23, "tntminecart.pickup.disable", lore);
            e.setCancelled(true);
        }
    }

    private void creeperEggButtonsClick(InventoryClickEvent e) {
        if (e.getSlot() == 28) {
            e.setCancelled(true);
        }
        if (e.getSlot() == 29) {
            List<String> lore = new ArrayList<>();
            for (String s : e.getCurrentItem().getItemMeta().getLore()) {
                lore.add(ChatUtils.c(s));
            }
            Gui.changeItem(29, "creeperegg.place.disable", lore);
            e.setCancelled(true);
        }

        if (e.getSlot() == 30) {
            List<String> lore = new ArrayList<>();
            for (String s : e.getCurrentItem().getItemMeta().getLore()) {
                lore.add(ChatUtils.c(s));
            }
            Gui.changeItem(30, "creeperegg.interact.disable", lore);
            e.setCancelled(true);
        }
        if (e.getSlot() == 31) {
            List<String> lore = new ArrayList<>();
            for (String s : e.getCurrentItem().getItemMeta().getLore()) {
                lore.add(ChatUtils.c(s));
            }
            Gui.changeItem(31, "creeperegg.explosion.disable", lore);
            e.setCancelled(true);
        }
        if (e.getSlot() == 32) {
            List<String> lore = new ArrayList<>();
            for (String s : e.getCurrentItem().getItemMeta().getLore()) {
                lore.add(ChatUtils.c(s));
            }
            Gui.changeItem(32, "creeperegg.pickup.disable", lore);
            e.setCancelled(true);
        }
    }

    private void bedButtonsClick(InventoryClickEvent e) {
        if (e.getSlot() == 37) {
            e.setCancelled(true);
        }
        if (e.getSlot() == 38) {
            List<String> lore = new ArrayList<>();
            for (String s : e.getCurrentItem().getItemMeta().getLore()) {
                lore.add(ChatUtils.c(s));
            }
            Gui.changeItem(38, "bed.place.disable", lore);
            e.setCancelled(true);
        }

        if (e.getSlot() == 39) {
            List<String> lore = new ArrayList<>();
            for (String s : e.getCurrentItem().getItemMeta().getLore()) {
                lore.add(ChatUtils.c(s));
            }
            Gui.changeItem(39, "bed.interact.disable", lore);
            e.setCancelled(true);
        }
        if (e.getSlot() == 40) {
            List<String> lore = new ArrayList<>();
            for (String s : e.getCurrentItem().getItemMeta().getLore()) {
                lore.add(ChatUtils.c(s));
            }
            Gui.changeItem(40, "bed.explosion.disable", lore);
            e.setCancelled(true);
        }
        if (e.getSlot() == 41) {
            List<String> lore = new ArrayList<>();
            for (String s : e.getCurrentItem().getItemMeta().getLore()) {
                lore.add(ChatUtils.c(s));
            }
            Gui.changeItem(41, "bed.pickup.disable", lore);
            e.setCancelled(true);
        }
    }

    private void explosionsButtonsClick(InventoryClickEvent e) {
        if (e.getSlot() == 16) {
            e.setCancelled(true);
        }
        if (e.getSlot() == 25) {
            List<String> lore = new ArrayList<>();
            for (String s : e.getCurrentItem().getItemMeta().getLore()) {
                lore.add(ChatUtils.c(s));
            }
            Gui.changeItem(25, "damage.disable-for-players", lore);
            e.setCancelled(true);
        }
        if (e.getSlot() == 34) {
            List<String> lore = new ArrayList<>();
            for (String s : e.getCurrentItem().getItemMeta().getLore()) {
                lore.add(ChatUtils.c(s));
            }
            Gui.changeItem(34, "damage.disable-for-mobs", lore);
            e.setCancelled(true);
        }
        if (e.getSlot() == 43) {
            e.setCancelled(true);
        }
    }
}