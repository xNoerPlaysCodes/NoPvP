package net.noerlol.nopvp;

import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class NoPvP extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
        getLogger().info("NoPvP is enabled!");
    }

    @EventHandler
    public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
        if ((event.getDamager() instanceof Player && event.getEntity() instanceof Player)) {
            String Message = ChatColor.RED + "[!] You cannot PvP here.";
            Player Damager = (Player) event.getDamager();
            Player Victim = (Player) event.getEntity();

            Damager.sendMessage(Message);
            event.setCancelled(true);
        }
    }

    @Override
    public void onDisable() {
        getLogger().info("NoPvP is disabled!");
    }
}
