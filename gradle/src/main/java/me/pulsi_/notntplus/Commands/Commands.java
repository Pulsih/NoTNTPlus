package me.pulsi_.notntplus.Commands;

import me.pulsi_.notntplus.Main;
import me.pulsi_.notntplus.Managers.ConfigManager;
import me.pulsi_.notntplus.Managers.Translator;
import me.pulsi_.notntplus.Panel.GUI;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Commands implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender s, Command command, String label, String[] args) {

        ConfigManager message = new ConfigManager(Main.getInstance(), "messages.yml");

        //---------------------------------------------------------------------------------------------------------
        //                                          No command
        if (args.length == 0) {
            s.sendMessage(Translator.Colors("&8&m==================================="));
            s.sendMessage(Translator.Colors("&8"));
            s.sendMessage(Translator.Colors("&c&l  &8[&a&lNo&c&lTNT&b&l+&8] &a/Tnt Help"));
            s.sendMessage(Translator.Colors("&8"));
            s.sendMessage(Translator.Colors("&8&m==================================="));
            //                                      No command
            //---------------------------------------------------------------------------------------------------------


            //---------------------------------------------------------------------------------------------------------
            //                                          Help command
        } else if (args[0].equalsIgnoreCase("help")) {
            if (s.hasPermission("notntplus.help")) {
                s.sendMessage(Translator.Colors("&8&m================================="));
                s.sendMessage(Translator.Colors("&5&l          &8[&a&lNo&c&lTNT&b&l+&8] &a&lHelp"));
                s.sendMessage(Translator.Colors("&a"));
                s.sendMessage(Translator.Colors("&8> &a/Tnt reload &7Reload the Plugin"));
                s.sendMessage(Translator.Colors("&8> &a/Tnt help &7See the page help"));
                s.sendMessage(Translator.Colors("&8> &a/Tnt info &7See the Info of the plugin"));
                s.sendMessage(Translator.Colors("&8&m================================="));
            } else {
                s.sendMessage(Translator.Colors(message.getConfig().getString("nopermission_message")));
            }
            //                                          Help command
            //---------------------------------------------------------------------------------------------------------


            //---------------------------------------------------------------------------------------------------------
            //                                          Info command
        } else if (args[0].equalsIgnoreCase("info")) {
            if (!(s.hasPermission("notntplus.info"))) {
                s.sendMessage(Translator.Colors(message.getConfig().getString("nopermission_message")));
            } else if (args.length > 1 && args[1].equalsIgnoreCase("Creator")) {
                s.sendMessage(Translator.Colors("&8&m================================="));
                s.sendMessage(Translator.Colors("&5&l    &8[&a&lNo&c&lTNT&b&l+&8] &a-> &aCreator"));
                s.sendMessage(Translator.Colors("&a"));
                s.sendMessage(Translator.Colors("&8> &aPlugin Creator: &bPulsi_"));
                s.sendMessage(Translator.Colors("&8> &aThanks for using this Plugin!"));
                s.sendMessage(Translator.Colors("&8&m================================="));
            } else if (args.length > 1 && args[1].equalsIgnoreCase("Version")) {
                s.sendMessage(Translator.Colors("&8&m================================="));
                s.sendMessage(Translator.Colors("&5&l    &8[&a&lNo&c&lTNT&b&l+&8] &a-> &aVersion"));
                s.sendMessage(Translator.Colors("&a"));
                s.sendMessage(Translator.Colors("&8> &aPlugin Version: &bv1.5"));
                s.sendMessage(Translator.Colors("&8&m================================="));
            } else if (args.length > 1 && args[1].equalsIgnoreCase("Aliases")) {
                s.sendMessage(Translator.Colors("&8&m================================="));
                s.sendMessage(Translator.Colors("&5&l    &8[&a&lNo&c&lTNT&b&l+&8] &a-> &aAliases"));
                s.sendMessage(Translator.Colors("&a"));
                s.sendMessage(Translator.Colors("&8> &aAliases: NoTNT+, NoTNT, TNT"));
                s.sendMessage(Translator.Colors("&8&m================================="));
            } else if (args.length > 1 && args[1].equalsIgnoreCase("Permissions")) {
                s.sendMessage(Translator.Colors("&8&m================================="));
                s.sendMessage(Translator.Colors("&5&l    &8[&a&lNo&c&lTNT&b&l+&8] &a-> &aPermissions"));
                s.sendMessage(Translator.Colors("&a"));
                s.sendMessage(Translator.Colors("&8> &aPermissions:\n" + "notntplus.place\n"+
                        "notntplus.interact\n"+
                        "notntplus.pickup.tnt\n"+
                        "notntplus.pickup.tntminecart\n"+
                        "notntplus.pickup.creeperegg\n"+
                        "notntplus.info\n"+
                        "notntplus.help\n"+
                        "notntplus.reload"));
                s.sendMessage(Translator.Colors("&8&m================================="));
            } else {
                s.sendMessage(Translator.Colors("&8&m================================="));
                s.sendMessage(Translator.Colors("&5&l      &8[&a&lNo&c&lTNT&b&l+&8] &aPlugin"));
                s.sendMessage(Translator.Colors("&a"));
                s.sendMessage(Translator.Colors("&8> &aInfo -> Creator"));
                s.sendMessage(Translator.Colors("&8> &aInfo -> Version"));
                s.sendMessage(Translator.Colors("&8> &aInfo -> Aliases"));
                s.sendMessage(Translator.Colors("&8> &aInfo -> Permissions"));
                s.sendMessage(Translator.Colors("&8&m================================="));
            }
            //                                      Info command
            //---------------------------------------------------------------------------------------------------------

            //---------------------------------------------------------------------------------------------------------
            //                                      Panel command
        } else if (args[0].equalsIgnoreCase("panel")) {
            if (s.hasPermission("notntplus.panel")) {
                if (s instanceof Player) {
                    Player p = (Player) s;
                    GUI panel = new GUI(p);
                    panel.openPanel();
                } else {
                    s.sendMessage(Translator.Colors("&8[&a&lNo&c&lTNT&b&l+&8] &cThe console can't execute this command!"));
                }
            } else {
                s.sendMessage(Translator.Colors(message.getConfig().getString("nopermission_message")));
            }
            //                                      Panel command
            //---------------------------------------------------------------------------------------------------------


            //---------------------------------------------------------------------------------------------------------
            //                                      Reload command
        } else if (args[0].equalsIgnoreCase("reload")) {
            if (s.hasPermission("notntplus.reload")) {
                Main.getInstance().reloadConfig();
                s.sendMessage(Translator.Colors(message.getConfig().getString("reload_message")));
            } else {
                s.sendMessage(Translator.Colors(message.getConfig().getString("nopermission_message")));
            }
            //                                      Reload command
            //---------------------------------------------------------------------------------------------------------


            //---------------------------------------------------------------------------------------------------------------
            // Unknown Command
        } else {
            s.sendMessage(Translator.Colors(message.getConfig().getString("unknown_command")));
            // Unknown Command
            //---------------------------------------------------------------------------------------------------------------
        }
        return true;
    }
}