package org.eishgaming.webhooks;

import org.bukkit.Bukkit;
import org.eishgaming.webhooks.listeners.PlayerListener;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import org.eishgaming.webhooks.http.PayloadRequestTask;
import org.eishgaming.webhooks.listeners.ServerListener;

public class WebhookPlugin extends JavaPlugin {
    FileConfiguration config = getConfig();
    
    @Override
    public void onEnable() {
        initialiseConfig();
        registerListeners();
        
        Bukkit.getScheduler().runTaskTimerAsynchronously(this, new PayloadRequestTask(config), 20 * 30, config.getInt("webhook_frequency"));
    }

    @Override
    public void onDisable() {
    }
    
    private void initialiseConfig() {
        config.addDefault("endpoint", "http://example.com/webhook");
        config.addDefault("listen_player", true);
        config.addDefault("listen_server", true);
        
        config.addDefault("webhook_frequency", 20 * 30); // every 30 seconds

        config.options().copyDefaults(true);

        saveConfig();
    }
    
    private void registerListeners() {
        if (config.getBoolean("listen_player")) {
            getServer().getPluginManager().registerEvents(new PlayerListener(config), this);
        }
        
        if (config.getBoolean("listen_server")) {
            getServer().getPluginManager().registerEvents(new ServerListener(config), this);
        }
    }
}
