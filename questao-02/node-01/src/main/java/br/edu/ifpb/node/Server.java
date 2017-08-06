/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.node;

import br.edu.ifpb.shared.Provider;
import br.edu.ifpb.shared.UnknownAnswerException;
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
    
    private static double readData(Socket socket) throws IOException {
        byte[] b;
        try (InputStream input = socket.getInputStream()) {
            b = new byte[1024];
            input.read(b);
        }
        return Double.parseDouble(new String(b).trim());
    }
    
    private static void writeData(Socket socket, double data) throws IOException {
        OutputStream output = socket.getOutputStream();
        output.write((data + "").getBytes());
        output.flush();
        output.close();
    }
    
    private static double client(double x, double y) throws IOException {
        Provider provider = new Provider();
        Socket socket = provider.getServer("node3");
        writeData(socket, x);
        writeData(socket, y);
        return readData(socket);
    }
    
    private static double process(int option, double x, double y) throws IOException {
        Service service = new Service();
        if (option == 2) {
            try {
                return service.op2(x, y);
            } catch (UnknownAnswerException ex) {
                return client(x, y);
            }
        }
        return service.op1(x, y);
    }
    
    public static void main(String[] args) throws IOException {
        
        try (ServerSocket server = new ServerSocket(10997); Socket socket = server.accept()) {
            
            double x = readData(socket);
            double y = readData(socket);
            
            byte[] b = new byte[1024];
            socket.getInputStream().read(b);
            int option = Integer.parseInt(new String(b).trim());
            
            double answer = process(option, x, y);
            writeData(socket, answer);
            
        }
    }
    
}
