/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.server;

import br.edu.ifpb.shared.Usuario;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;

/**
 *
 * @author miolivc
 */
public class ServerMain {
    
    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
        
        ServerSocket server = new ServerSocket(10999);
        Socket socket = server.accept();
        
        while(true) {
            ObjectInputStream input = (ObjectInputStream) socket.getInputStream();
            Usuario usuario = (Usuario) input.readObject();
        
            UsuarioDAO mysql = new UsuarioDAOJDBC(ConnectionFactory.MYSQL);
            mysql.add(usuario);
            
            UsuarioDAO postgres = new UsuarioDAOJDBC(ConnectionFactory.POSTGRES);
            postgres.add(usuario);
        
        }
        
    }
    
}
