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

        ItemStack buttonExplosions = new ItemStack(Material.TNT);
        ItemStack buttonPickup = new ItemStack(Material.SNOWBALL);
        ItemStack buttonPlace = new ItemStack(Material.BOOKSHELF);
        ItemStack buttonInteract = new ItemStack(Material.REDSTONE);

        //-------------------------------------------------------------------------------------
        // Explosion

        ItemMeta Explosions_meta = buttonExplosions.getItemMeta();
        Explosions_meta.setDisplayName(Translator.Colors("&c&l&oExplosions &d&l&oManager"));
        ArrayList<String> Explosions_lore = new ArrayList<>();
        Explosions_lore.add(Translator.Colors("&aManage the Explosions Settings in Game!"));
        Explosions_lore.add(Translator.Colors("&7"));
        Explosions_lore.add(Translator.Colors("&7Click here to open the Explosions Manager"));
        Explosions_meta.setLore(Explosions_lore);
        buttonExplosions.setItemMeta(Explosions_meta);

        // Explosion
        //-------------------------------------------------------------------------------------


        //-------------------------------------------------------------------------------------
        // Pickup

        ItemMeta Pickup_meta = buttonPickup.getItemMeta();
        Pickup_meta.setDisplayName(Translator.Colors("&c&l&oPickup &d&l&oManager"));
        ArrayList<String> Pickup_lore = new ArrayList<>();
        Pickup_lore.add(Translator.Colors("&aManage the Pickup Settings in Game!"));
        Pickup_lore.add(Translator.Colors("&7"));
        Pickup_lore.add(Translator.Colors("&7Click here to open the Pickup Manager"));
        Pickup_meta.setLore(Pickup_lore);
        buttonPickup.setItemMeta(Pickup_meta);

        // Pickup
        //-------------------------------------------------------------------------------------


        //-------------------------------------------------------------------------------------
        // Place

        ItemMeta Place_meta = buttonPlace.getItemMeta();
        Place_meta.setDisplayName(Translator.Colors("&c&l&oPlace &d&l&oManager"));
        ArrayList<String> Place_lore = new ArrayList<>();
        Place_lore.add(Translator.Colors("&aManage the Place Settings in Game!"));
        Place_lore.add(Translator.Colors("&7"));
        Place_lore.add(Translator.Colors("&7Click here to open the Place Manager"));
        Place_meta.setLore(Place_lore);
        buttonPlace.setItemMeta(Place_meta);

        // Place
        //-------------------------------------------------------------------------------------


        //-------------------------------------------------------------------------------------
        // Interact

        ItemMeta Interact_meta = buttonInteract.getItemMeta();
        Interact_meta.setDisplayName(Translator.Colors("&c&l&oInteract &d&l&oManager"));
        ArrayList<String> Interact_lore = new ArrayList<>();
        Interact_lore.add(Translator.Colors("&aManage the Interact Settings in Game!"));
        Interact_lore.add(Translator.Colors("&7"));
        Interact_lore.add(Translator.Colors("&7Click here to open the Interact Manager"));
        Interact_meta.setLore(Interact_lore);
        buttonInteract.setItemMeta(Interact_meta);

        // Interact
        //-------------------------------------------------------------------------------------

        panel.setItem(10, buttonExplosions);
        panel.setItem(11, buttonPickup);
        panel.setItem(12, buttonPlace);
        panel.setItem(13, buttonInteract);

        p.openInventory(panel);

    }
}