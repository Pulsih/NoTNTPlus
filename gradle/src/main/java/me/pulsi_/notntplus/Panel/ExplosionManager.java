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

public class ExplosionManager {

    private Player p;

    public ExplosionManager(Player p){
        this.p = p;
    }

    public void openGuiExplosionManager(){

        Inventory guiExplosionManager = Bukkit.createInventory(null, 36, (Translator.Colors("&9&lExplosion Manager")));

        ItemStack buttonToggleTNT = new ItemStack(Material.TNT);
        ItemStack buttonToggleMinecart = new ItemStack(Material.TNT_MINECART);
        ItemStack buttonToggleCreeper = new ItemStack(Material.CREEPER_HEAD);
        ItemStack buttonGoBack = new ItemStack(Material.BARRIER);
        ItemStack buttonToggleBed = new ItemStack(Material.RED_BED);

        //-------------------------------------------------------------------------------------
        // Toggle TNT Explosion

        ItemMeta toggleTNT_meta = buttonToggleTNT.getItemMeta();
        toggleTNT_meta.setDisplayName(Translator.Colors("&c&l&oTNT &a&l&oExplosion"));
        ArrayList<String> toggleTNT_lore = new ArrayList<>();
        toggleTNT_lore.add(Translator.Colors("&aShould the plugin disable TNT explosions?"));
        toggleTNT_lore.add(Translator.Colors("&7"));
        toggleTNT_lore.add(Translator.Colors("&7Click here to toggle the TNT Explosions"));
        toggleTNT_lore.add(Translator.Colors("&7Status: "+Main.getInstance().getConfig().getBoolean("explosions.disable_tnt_explosion")).replace("true", ChatColor.DARK_GREEN+"Enabled").replace("false",ChatColor.RED+"Disabled"));
        toggleTNT_meta.setLore(toggleTNT_lore);
        buttonToggleTNT.setItemMeta(toggleTNT_meta);

        // Toggle TNT Explosion
        //-------------------------------------------------------------------------------------


        //-------------------------------------------------------------------------------------
        // Toggle Minecart Explosion

        ItemMeta ToggleMinecart_meta = buttonToggleMinecart.getItemMeta();
        ToggleMinecart_meta.setDisplayName(Translator.Colors("&c&l&oTNT Minecart &a&l&oExplosion"));
        ArrayList<String> ToggleMinecart_lore = new ArrayList<>();
        ToggleMinecart_lore.add(Translator.Colors("&aShould the plugin disable TNT Minecart explosions?"));
        ToggleMinecart_lore.add(Translator.Colors("&7"));
        ToggleMinecart_lore.add(Translator.Colors("&7Click here to toggle the TNT Minecart Explosions"));
        ToggleMinecart_lore.add(Translator.Colors("&7Status: "+Main.getInstance().getConfig().getBoolean("explosions.disable_tntminecart_explosion")).replace("true",ChatColor.DARK_GREEN+"Enabled").replace("false",ChatColor.RED+"Disabled"));
        ToggleMinecart_meta.setLore(ToggleMinecart_lore);
        buttonToggleMinecart.setItemMeta(ToggleMinecart_meta);

        // Toggle Minecart Explosion
        //-------------------------------------------------------------------------------------


        //-------------------------------------------------------------------------------------
        // Toggle Creeper Explosion

        ItemMeta ToggleCreeper_meta = buttonToggleCreeper.getItemMeta();
        ToggleCreeper_meta.setDisplayName(Translator.Colors("&c&l&oCreeper &a&l&oExplosion"));
        ArrayList<String> ToggleCreeper_lore = new ArrayList<>();
        ToggleCreeper_lore.add(Translator.Colors("&aShould the plugin disable Creeper explosions?"));
        ToggleCreeper_lore.add(Translator.Colors("&7"));
        ToggleCreeper_lore.add(Translator.Colors("&7Click here to toggle the Creeper Explosions"));
        ToggleCreeper_lore.add(Translator.Colors("&7Status: "+Main.getInstance().getConfig().getBoolean("explosions.disable_creeper_explosion")).replace("true",ChatColor.DARK_GREEN+"Enabled").replace("false",ChatColor.RED+"Disabled"));
        ToggleCreeper_meta.setLore(ToggleCreeper_lore);
        buttonToggleCreeper.setItemMeta(ToggleCreeper_meta);

        // Toggle Creeper Explosion
        //-------------------------------------------------------------------------------------


        //-------------------------------------------------------------------------------------
        // Toggle Bed Explosion

        ItemMeta toggleBed_meta = buttonToggleBed.getItemMeta();
        toggleBed_meta.setDisplayName(Translator.Colors("&c&l&oBed &a&l&oExplosion"));
        ArrayList<String> toggleBed_lore = new ArrayList<>();
        toggleBed_lore.add(Translator.Colors("&aShould the plugin disable Bed explosions?"));
        toggleBed_lore.add(Translator.Colors("&7"));
        toggleBed_lore.add(Translator.Colors("&7Click here to toggle the Bed Explosions"));
        toggleBed_lore.add(Translator.Colors("&7Status: "+Main.getInstance().getConfig().getBoolean("explosions.disable_creeper_explosion")).replace("true",ChatColor.DARK_GREEN+"Enabled").replace("false",ChatColor.RED+"Disabled"));
        toggleBed_meta.setLore(toggleBed_lore);
        buttonToggleBed.setItemMeta(toggleBed_meta);

        // Toggle Bed Explosion
        //-------------------------------------------------------------------------------------


        //-------------------------------------------------------------------------------------
        // Go Back

        ItemMeta goBack_meta = buttonGoBack.getItemMeta();
        goBack_meta.setDisplayName(Translator.Colors("&c&l&oGo Back"));
        ArrayList<String> goBack_lore = new ArrayList<>();
        goBack_lore.add(Translator.Colors("&aReturn to the Main Panel"));
        goBack_meta.setLore(goBack_lore);
        buttonGoBack.setItemMeta(goBack_meta);

        // Go Back
        //-------------------------------------------------------------------------------------

        guiExplosionManager.setItem(10, buttonToggleTNT);
        guiExplosionManager.setItem(12, buttonToggleMinecart);
        guiExplosionManager.setItem(14, buttonToggleCreeper);
        guiExplosionManager.setItem(16, buttonToggleBed);
        guiExplosionManager.setItem(31, buttonGoBack);

        p.openInventory(guiExplosionManager);

    }
}
