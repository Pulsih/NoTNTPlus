package me.pulsi_.notntplus.cmds;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.List;

public class Tab implements TabCompleter {

    @Override
    public List<String> onTabComplete(CommandSender s, Command command, String alias, String[] args) {

        List<String> args1 = new ArrayList<>();
        if (s.hasPermission("notntplus.help")) {
            args1.add("help");
        }
        if (s.hasPermission("notntplus.reload")) {
            args1.add("reload");
        }
        if (s.hasPermission("notntplus.panel")) {
            args1.add("panel");
        }

        List<String> resultArgs1 = new ArrayList<>();
        if (args.length == 1) {
            for (String a : args1) {
                if (a.toLowerCase().startsWith(args[0].toLowerCase()))
                    resultArgs1.add(a);
            }
            return resultArgs1;
        }
        return null;
    }
}