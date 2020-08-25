package me.elb1to.event.player;

import me.elb1to.event.utils.CC;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.HashMap;

public class PlayerListener implements Listener {

    public static HashMap<Player, Location> deathLocation = new HashMap<>();

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        if (PlayerManager.getState(player.getUniqueId()) != PlayerManager.PlayerState.DEAD) {
            player.setGameMode(GameMode.SURVIVAL);
        }
    }

    @EventHandler
    public void handlePlayerDeath(PlayerDeathEvent event) {
        event.setDeathMessage(null);

        Player player = event.getEntity().getPlayer();
        Player damager = event.getEntity().getKiller();

        if (PlayerManager.getState(player.getUniqueId()) == PlayerManager.PlayerState.ALIVE) {
            PlayerManager.setState(player.getUniqueId(), PlayerManager.PlayerState.DEAD);
            deathLocation.put(player, player.getLocation());

            player.spigot().respawn();
            player.setGameMode(GameMode.SPECTATOR);
            player.sendMessage(CC.translate("&cYou died!"));
        }

        if (damager != null) {
            Bukkit.broadcastMessage(CC.translate("&7&m------------------------------------"));
            Bukkit.broadcastMessage(CC.translate("&a" + player.getName() + " &7has been slained by &c" + damager.getName()));
            Bukkit.broadcastMessage(CC.translate("&7&m------------------------------------"));
        } else {
            Bukkit.broadcastMessage(CC.translate("&7&m------------------------------------"));
            Bukkit.broadcastMessage(CC.translate("&a" + player.getName() + " &7died due to &cNatural Causes"));
            Bukkit.broadcastMessage(CC.translate("&7&m------------------------------------"));
        }
    }
}
