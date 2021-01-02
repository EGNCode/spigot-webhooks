package org.eishgaming.webhooks.http;

import org.bukkit.configuration.file.FileConfiguration;

public class PayloadRequestTask implements Runnable {

    public PayloadRequestTask(FileConfiguration config)
    {
        // ...
    }
    
    @Override
    public void run() {
        System.out.println("The size of the payload bus is: " + PayloadBus.getInstance().getAll().size());
    }
    
}
