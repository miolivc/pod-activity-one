/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author miolivc
 */
public class Server {
    
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(10999);
        Socket socket = server.accept();
       
        InputStream in = socket.getInputStream();
        byte[] b = new byte[1024];
        
        in.read(b);
        int x = Integer.parseInt(new String(b).trim());
        
        in.read(b);
        int y = Integer.parseInt(new String(b).trim());
        
        int answer = Calculator.calculate(x,y);
        
        OutputStream out = socket.getOutputStream();
        out.write(("" + answer).getBytes());
        
        in.close();
        out.close();
        socket.close();
        server.close();
    }
    
}
