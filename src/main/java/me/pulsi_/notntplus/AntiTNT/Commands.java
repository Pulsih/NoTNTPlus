package me.pulsi_.notntplus.AntiTNT;

import me.pulsi_.notntplus.Managers.MessageManager;
import me.pulsi_.notntplus.Managers.Translator;
import me.pulsi_.notntplus.NoTNTPlus;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Commands implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player p = (Player) sender;

        MessageManager message = new MessageManager(p);

        //---------------------------------------------------------------------------------------------------------
        //                                          No command
        if (args.length == 0) {
            sender.sendMessage(Translator.Colors("&8&m==================================="));
            sender.sendMessage(Translator.Colors("&8"));
            sender.sendMessage(Translator.Colors("&c&l  &8[&a&lNo&c&lTNT&b&l+&8] &a/Tnt Help"));
            sender.sendMessage(Translator.Colors("&8"));
            sender.sendMessage(Translator.Colors("&8&m==================================="));
            p.playSound(p.getLocation(), Sound.BLOCK_DISPENSER_LAUNCH, 2, 1);
            //                                          No command
            //---------------------------------------------------------------------------------------------------------


            //---------------------------------------------------------------------------------------------------------
            //                                          Help command
        } else if (args[0].equalsIgnoreCase("help")) {
            if (p.hasPermission("notntplus.help"))
                sender.sendMessage(Translator.Colors("&8&m================================="));
            sender.sendMessage(Translator.Colors("&5&l          &8[&a&lNo&c&lTNT&b&l+&8] &a&lHelp"));
            sender.sendMessage(Translator.Colors("&a"));
            sender.sendMessage(Translator.Colors("&8> &a/Tnt reload &7Reload the Plugin"));
            sender.sendMessage(Translator.Colors("&8> &a/Tnt help &7See the page help"));
            sender.sendMessage(Translator.Colors("&8> &a/Tnt info &7See the Info of the plugin"));
            sender.sendMessage(Translator.Colors("&8&m================================="));
            p.playSound(p.getLocation(), Sound.BLOCK_DISPENSER_LAUNCH, 2, 1);
            //                                          Help command
            //---------------------------------------------------------------------------------------------------------


            //---------------------------------------------------------------------------------------------------------
            //                                          Help command
        } else if (args[0].equalsIgnoreCase("info")) {
            if (p.hasPermission("notntplus.info")) {
                sender.sendMessage(Translator.Colors("&8&m================================="));
                sender.sendMessage(Translator.Colors("&5&l      &8[&a&lNo&c&lTNT&b&l+&8] &aPlugin"));
                sender.sendMessage(Translator.Colors("&a"));
                sender.sendMessage(Translator.Colors("&8> &aPlugin created by Pulsi_"));
                sender.sendMessage(Translator.Colors("&8> &aVersion: 1.2"));
                sender.sendMessage(Translator.Colors("&8> &aAliases: NoTNT+, NoTNT, TNT"));
                sender.sendMessage(Translator.Colors("&8&m================================="));
                p.playSound(p.getLocation(), Sound.BLOCK_DISPENSER_LAUNCH, 2, 1);
                //                                          Help command
                //---------------------------------------------------------------------------------------------------------


                //---------------------------------------------------------------------------------------------------------
                //                                      Reload command
            } else if (args[0].equalsIgnoreCase("reload")) {
                if (sender.hasPermission("notntplus.reload")) {
                    NoTNTPlus.getInstance().reloadConfig();
                    p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 2, 1);
                    message.reloadMessage();
                } else {
                    message.noPermissions();
                }
                //                                      Reload command
                //---------------------------------------------------------------------------------------------------------


                //---------------------------------------------------------------------------------------------------------------
                // Unknown Command
            } else {
                message.unknownCommand();
                p.playSound(p.getLocation(), Sound.ENTITY_ITEM_BREAK, 2, 2);
                // Unknown Command
                //---------------------------------------------------------------------------------------------------------------
            }
            return true;
        }
        return true;
    }
}
