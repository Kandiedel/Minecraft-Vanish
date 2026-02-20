package de.kandiedel.vanish.listeners;

import de.kandiedel.vanish.utils.VanishManager;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerConnectionListener implements Listener {

    private VanishManager vanishManager;

    public PlayerConnectionListener (VanishManager vanishManager) {
        this.vanishManager = vanishManager;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {

        Player player = event.getPlayer();

        if (vanishManager.isVanished(player.getUniqueId())) {
            event.setJoinMessage(null);
        }

        for (Player all : Bukkit.getOnlinePlayers()) {
            if (vanishManager.isVanished(all.getUniqueId())) {
                vanishManager.vanishPlayer(all.getUniqueId());
            }

            if (vanishManager.isVanished(player.getUniqueId())) {
                vanishManager.vanishPlayer(player.getUniqueId());
            }
        }
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {

        Player player = event.getPlayer();

        if (vanishManager.isVanished(player.getUniqueId())) {
            event.setQuitMessage(null);
        }
    }

}
