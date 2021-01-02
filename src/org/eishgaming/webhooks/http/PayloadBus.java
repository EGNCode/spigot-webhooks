package org.eishgaming.webhooks.http;

import java.util.ArrayList;

public class PayloadBus {
    private static PayloadBus instance;
    
    private ArrayList<Object> payloads = new ArrayList<>();
    
    public static PayloadBus getInstance() {
        if (instance == null) {
            instance = new PayloadBus();
        }
        return instance;
    }
    
    public void add(Object event) {
        this.payloads.add(event);
    }
    
    public void clear() {
        this.payloads.clear();
    }
    
    public ArrayList<Object> getAll() {
        return this.payloads;
    }
}
