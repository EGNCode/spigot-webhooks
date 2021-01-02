package org.eishgaming.webhooks.listeners;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerLevelChangeEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.eishgaming.webhooks.http.PayloadBus;

public class PlayerListener implements Listener {

    private FileConfiguration config;

    public PlayerListener(FileConfiguration config) {
        this.config = config;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        PayloadBus.getInstance().add(event);
    }

    @EventHandler
    public void onPlayerKick(PlayerKickEvent event) {
        PayloadBus.getInstance().add(event);
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        PayloadBus.getInstance().add(event);
    }

    @EventHandler
    public void onPlayerLevelChange(PlayerLevelChangeEvent event) {
        PayloadBus.getInstance().add(event);
    }
}
