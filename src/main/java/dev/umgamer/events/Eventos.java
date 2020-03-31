package dev.umgamer.events;

import br.com.devpaulo.legendchat.api.events.ChatMessageEvent;
import dev.umgamer.DevMito;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class Eventos implements Listener {
    @EventHandler
    private void onPlayerDeathEvent(PlayerDeathEvent e){
        Player matou = e.getEntity().getPlayer().getKiller();
        Player morreu = e.getEntity().getPlayer();

        if(morreu.getName().equalsIgnoreCase(DevMito.getDevMito().getConfig().getString("Mito_Atual"))) {
            matou.sendMessage("§8§l[§5§lMITO§8§l] §8* §cVocê é o novo Mito do PVP!");
            morreu.sendMessage("§8§l[§5§lMITO§8§l] §8* §cVocê não é mais o Mito do PVP! :c");
            DevMito.getDevMito().getConfig().set("Mito_Atual", matou.getName());
            DevMito.getDevMito().getServer().broadcastMessage("§8§l[§5§lMITO§8§l] §8* §6 O Jogador §c"+ matou.getName() + "§6 é o novo Mito do PVP!");
        } else {
            return;
        }
    }
    @EventHandler
    private void OnChatMesssageEvent(ChatMessageEvent e) {
        Player p = e.getSender();
        if(p.getName().equalsIgnoreCase(DevMito.getDevMito().getConfig().getString("Mito_Atual"))) {
            if(e.getTags().contains("mito")) {
                e.setTagValue("mito", "&8[&5MITO&8]");
            }
        }


    }


}


