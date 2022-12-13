package net.survivalquest.aoe.Commands;

import net.survivalquest.aoe.AoE;
import net.survivalquest.aoe.AoEUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AoECommand implements CommandExecutor {

    private AoE plugin;

    public AoECommand(AoE main){
        this.plugin = main;
    }

    @Override
    public boolean onCommand(CommandSender sender , Command command , String label , String[] args) {
        if (!sender.hasPermission("aoe.admin")){
            return false;
        }
        if (!command.getName().equalsIgnoreCase("aoe") && !command.getName().equalsIgnoreCase("AreaOfEffect")){
            return false;
        }
        if (args.length >= 1){
            if (args[0].equalsIgnoreCase("reload")) {
                sender.sendMessage(AoEUtils.Colour("&3&lINFO &7Plugin Reloaded!"));
            }
            else if (args[0].equalsIgnoreCase("effect")){
                plugin.getAoEManager().activateEffect(args[1],(Player) sender);
            }
        }
        else {
            if (!(sender instanceof Player)) {
                return false;
            }
        }
        return false;
    }
}
