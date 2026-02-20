package de.kandiedel.vanish.listeners;

import com.destroystokyo.paper.event.server.PaperServerListPingEvent;
import de.kandiedel.vanish.utils.VanishManager;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class ServerPingListener implements Listener {

    private final VanishManager vanishManager;

    public ServerPingListener(VanishManager vanishManager) {
        this.vanishManager = vanishManager;
    }

    @EventHandler
    public void onServerPing(PaperServerListPingEvent event) {

        int visiblePlayers = (int) Bukkit.getOnlinePlayers().stream()
                .filter(p -> !vanishManager.isVanished(p.getUniqueId()))
                .count();

        event.setNumPlayers(visiblePlayers);
    }
}