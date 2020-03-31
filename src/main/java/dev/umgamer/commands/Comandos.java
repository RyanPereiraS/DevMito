package dev.umgamer.commands;

import dev.umgamer.DevMito;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Comandos implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender arg0, Command arg1, String arg2, String[] arg3) {
        Player p;
        if(arg0 instanceof Player){
            p = (Player)arg0;
            if(arg1.getName().equalsIgnoreCase("mito")) {
                if(DevMito.getDevMito().getConfig().getString("Mito_Atual").equals("null")) {
                    p.sendMessage("§5 O Servidor não possui um Mito do PVP!");
                }else {
                    p.sendMessage("§5O mito do pvp atual é: §c"+ DevMito.getDevMito().getConfig().getString("Mito_Atual"));
                }
            } else if(arg1.getName().equalsIgnoreCase("setmito")) {

                if(arg3.length == 0) {
                    p.sendMessage("§5Digite §c/setmito {nick}");
                } else if (arg3.length == 1) {
                    DevMito.getDevMito().getConfig().set("Mito_Atual", arg3[0]);
                    DevMito.getDevMito().getServer().broadcastMessage("§8§l[§5§lMITO§8§l] §8* §6 O Jogador §c"+ arg3[0] + "§6 é o novo Mito do PVP!");
                }

            }

        }
        return false;
    }
}
