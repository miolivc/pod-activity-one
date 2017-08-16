/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.client;

import br.edu.ifpb.shared.Usuario;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 *
 * @author miolivc
 */
public class PersistUser {
    private static final String HOST = "server";
    private static final int PORT = 10999;
    private Socket socket;

    public PersistUser() {
        try {
            this.socket = new Socket(HOST, PORT);
        } catch (IOException ex) {
            System.err.println("Erro ao instanciar socket: " + ex);
        }
    }
    
    public void persistUser(Usuario usuario) {
        try {
            try (ObjectOutputStream output = (ObjectOutputStream) socket.getOutputStream()) {
                output.writeObject(usuario);
                output.close();
            }
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }
    
}
