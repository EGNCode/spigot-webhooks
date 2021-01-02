package org.eishgaming.webhooks.listeners;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerLoadEvent;
import org.eishgaming.webhooks.http.PayloadBus;

public class ServerListener implements Listener {

    private FileConfiguration config;

    public ServerListener(FileConfiguration config) {
        this.config = config;
    }

    @EventHandler
    public void onPlayerJoin(ServerLoadEvent event) {
        PayloadBus.getInstance().add(event);
    }
}
