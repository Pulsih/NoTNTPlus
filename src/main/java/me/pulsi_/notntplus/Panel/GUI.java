package me.pulsi_.notntplus.Panel;

import me.pulsi_.notntplus.Main;
import me.pulsi_.notntplus.Managers.Translator;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class GUI {

    private Player p;

    public GUI(Player p){
        this.p = p;
    }

    public void openPanel(){

        Inventory panel = Bukkit.createInventory(null, 27, (Translator.Colors("&9&lNoTNT+ Panel")));

        ItemStack buttonToggleTNT = new ItemStack(Material.TNT);
        ItemStack buttonToggleMinecart = new ItemStack(Material.TNT_MINECART);

        //-------------------------------------------------------------------------------------
        // Toggle TNT Explosion

        ItemMeta ToggleTNT_meta = buttonToggleTNT.getItemMeta();
        ToggleTNT_meta.setDisplayName(Translator.Colors("&c&l&oTNT &a&l&oExplosions"));
        ArrayList<String> ToggleTNT_lore = new ArrayList<>();
        ToggleTNT_lore.add(Translator.Colors("&aManage the TNT Explosion in Game!"));
        ToggleTNT_lore.add(Translator.Colors("&7"));
        ToggleTNT_lore.add(Translator.Colors("&7Click here to open the Explosions Manager"));
        ToggleTNT_meta.setLore(ToggleTNT_lore);
        buttonToggleTNT.setItemMeta(ToggleTNT_meta);

        // Toggle TNT Explosion
        //-------------------------------------------------------------------------------------


        //-------------------------------------------------------------------------------------
        // Toggle Minecart Explosion

        ItemMeta ToggleMinecart_meta = buttonToggleMinecart.getItemMeta();
        ToggleMinecart_meta.setDisplayName(Translator.Colors("&c&l&oTNT Minecart &a&l&oExplosions"));
        ArrayList<String> ToggleMinecart_lore = new ArrayList<>();
        ToggleMinecart_lore.add(Translator.Colors("&aShould the plugin disable TNT Minecart explosions?"));
        ToggleMinecart_lore.add(Translator.Colors("&7"));
        ToggleMinecart_lore.add(Translator.Colors("&7Click here to toggle the TNT Minecart Explosions"));
        ToggleMinecart_lore.add(Translator.Colors("&7Status: "+Main.getInstance().getConfig().getBoolean("disable_tntminecart_explosion")).replace("true",ChatColor.DARK_GREEN+"Enabled").replace("false",ChatColor.RED+"Disabled"));
        ToggleMinecart_meta.setLore(ToggleMinecart_lore);
        buttonToggleMinecart.setItemMeta(ToggleMinecart_meta);

        // Toggle Minecart Explosion
        //-------------------------------------------------------------------------------------

        panel.setItem(10, buttonToggleTNT);
        panel.setItem(11, buttonToggleMinecart);

        p.openInventory(panel);

    }
}
