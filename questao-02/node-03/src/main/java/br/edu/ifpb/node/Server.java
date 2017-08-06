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
import java.util.TimerTask;
import javafx.concurrent.Task;

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
    
    private static double client(Socket socket, double x, double y) throws IOException {
        writeData(socket, x);
        writeData(socket, y);
        return readData(socket);
    }
    
    private static double process(int option, double x, double y) throws IOException {
        Service service = new Service();
        double answer;
        if (option == 1) {
            try {
                return service.op1(x, y);
            } catch (UnknownAnswerException ex) {
                answer = client(new Provider().getServer("node1"), x, y);
//                Falta o node 2 e timeout
//                answer = client(new Provider().getServer("node2"), x, y);
            }
        }
        return service.op2(x, y);
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
