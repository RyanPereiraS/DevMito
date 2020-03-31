package dev.umgamer;

import dev.umgamer.commands.Comandos;
import dev.umgamer.events.Eventos;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public class DevMito extends JavaPlugin {


    public void onEnable(){

        Bukkit.getConsoleSender().sendMessage(ChatColor.AQUA+"[DevMito]" + ChatColor.DARK_GRAY+" * "+ ChatColor.GOLD+"Plugin Iniciado!");

        getCommand("mito").setExecutor(new Comandos());
        getCommand("setmito").setExecutor(new Comandos());
        getServer().getPluginManager().registerEvents(new Eventos(), this);

        if(!new File(getDataFolder(), "config.yml").exists()) {
            saveDefaultConfig();
        }

    }

    public void onDisable(){

        Bukkit.getConsoleSender().sendMessage(ChatColor.AQUA+"[DevMito]" + ChatColor.DARK_GRAY+" * "+ ChatColor.GOLD+"Plugin Iniciado!");
        saveConfig();

    }
    public static DevMito getDevMito(){
        return (DevMito) Bukkit.getServer().getPluginManager().getPlugin("DevMito");
    }

}
