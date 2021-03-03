package me.pulsi_.notntplus.Panel;

import me.pulsi_.notntplus.Managers.Translator;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class GUIListener implements Listener {

    @EventHandler
    public void clickEvent(InventoryClickEvent event) {
        if (event.getView().getTitle().equals(Translator.Colors("&9&lNoTNT+ Panel"))) {
            if (event.getCurrentItem() != null) {
                Player p = (Player) event.getWhoClicked();
                event.setCancelled(true);

                GUI panel = new GUI(p);
                ExplosionManager panelExplosionManager = new ExplosionManager(p);

                if (event.getSlot() == 10) {
                        panelExplosionManager.openGuiExplosionManager();
                    }
                }
            }
        }
    }
