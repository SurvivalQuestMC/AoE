package net.survivalquest.aoe.Commands;

import net.survivalquest.aoe.AoE;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.Arrays;
import java.util.List;

public class TabCompleteAoE implements TabCompleter {

    private AoE plugin;

    public TabCompleteAoE(AoE main){
        plugin = main;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender , Command command , String label , String[] args) {
        if (!sender.hasPermission("aoe.admin")){
            return null;
        }
        if (args.length == 1){
            return Arrays.asList("reload");
        }
        return null;
    }
}
