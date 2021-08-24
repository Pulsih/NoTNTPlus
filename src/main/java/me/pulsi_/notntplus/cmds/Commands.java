package me.pulsi_.notntplus.cmds;

import me.pulsi_.notntplus.NoTNTPlus;
import me.pulsi_.notntplus.gui.Gui;
import me.pulsi_.notntplus.managers.MessageManager;
import me.pulsi_.notntplus.utils.ChatUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Commands implements CommandExecutor {

    private NoTNTPlus plugin;
    public Commands(NoTNTPlus plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender s, Command command, String label, String[] args) {

        if (args.length == 0) {
            s.sendMessage("");
            s.sendMessage(ChatUtils.c("&7Running &8[&a&lNo&c&lTNT&b&l+&8] &7v" + plugin.getDescription().getVersion()));
            s.sendMessage(ChatUtils.c("&7Plugin made by &aPulsi_"));
            s.sendMessage(ChatUtils.c("&7Type &a/tnt help &7for help!"));
            s.sendMessage("");
        }

        if (args.length == 1) {
            switch (args[0]) {
                case "help":
                    if (!s.hasPermission("notntplus.help")) {
                        MessageManager.noPermission(s, plugin);
                        return false;
                    }
                    s.sendMessage("");
                    s.sendMessage(ChatUtils.c("&8[&a&lNo&c&lTNT&b&l+&8] &aHelp Page"));
                    s.sendMessage("");
                    s.sendMessage(ChatUtils.c("&a/notntplus reload &7Reload the plugin."));
                    s.sendMessage(ChatUtils.c("&a/notntplus help &7See this page."));
                    s.sendMessage(ChatUtils.c("&a/notntplus panel &7Open the Control Panel."));
                    s.sendMessage("");
                    break;

                case "reload":
                    if (!s.hasPermission("notntplus.reload")) {
                        MessageManager.noPermission(s ,plugin);
                        return false;
                    }
                    plugin.reloadConfigs();
                    MessageManager.reloadMessage(s, plugin);
                    break;

                case "panel":
                    if (!s.hasPermission("notntplus.panel")) {
                        MessageManager.noPermission(s, plugin);
                        return false;
                    }
                    if (!(s instanceof Player)) {
                        s.sendMessage(ChatUtils.c("&8[&a&lNo&c&lTNT&b&l+&8] &cYou are not a player!"));
                        return false;
                    }
                    new Gui(plugin).openGui((Player) s);
                    s.sendMessage(ChatUtils.c("&8[&a&lNo&c&lTNT&b&l+&8] &aOpened the Control Panel!"));
                    break;

                default:
                    MessageManager.unknownCommand(s, plugin);
                    break;
            }
        }
        return true;
    }
}