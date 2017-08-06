/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.shared;

import java.io.IOException;
import java.util.Map;
import java.net.Socket;
import java.util.HashMap;
import java.util.Random;
import java.util.Set;

/**
 *
 * @author miolivc
 */
public class Provider {
    private final Map<String, Socket> servers = new HashMap<>();

    public Provider() throws IOException {
        servers.put("node1", new Socket("node1", 10997));
        servers.put("node2", new Socket("node2", 10997));
        servers.put("node3",  new Socket("node3", 10997));
    }

    public Socket getServer(String name) {
        return servers.get(name);
    }
    
    public Socket serverRandom() {
        int element = new Random().nextInt(servers.size());
        return getServer((String) servers.keySet().toArray()[element]);
    }
    
}
