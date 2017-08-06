/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.proxy;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author miolivc
 */
public class Proxy {
    
    private static int readData(Socket socket) throws IOException {
        byte[] b = new byte[1024];
        try (InputStream in = socket.getInputStream()) {
            in.read(b);
        }
        return Integer.parseInt(new String(b).trim());
    }
    
    private static void writeData(Socket socket, int data) throws IOException {
        OutputStream out = socket.getOutputStream();
        out.write((data + "").getBytes());
        out.flush();
        out.close();
    }
    
    public static int client(int x, int y) throws IOException {
        Socket client = new Socket("server", 10999);
        writeData(client, x);
        writeData(client, y);
        return readData(client);
    }
    
    public static void server() throws IOException{
        try (ServerSocket server = new ServerSocket(10998); Socket socket = server.accept()) {
            int x = readData(socket);
            int y = readData(socket);
            if (x == y) {
                writeData(socket, y);
                socket.close();
            } else {
                int answer = client(x, y);
                writeData(socket, answer);
            }
        }
    }
    
}
