/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.client;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author miolivc
 */
public class ClientMain {
    
    private static int generateNumber(int bound) {
        return new Random().nextInt(bound) + 1;
    }
    
    public static void main(String[] args) throws IOException {
        
        Socket socket = new Socket("proxy", 10998);
        
        int x = generateNumber(100);
        int y = generateNumber(100);
        
        OutputStream out = socket.getOutputStream();
        out.write(("" + x).getBytes());
        out.write(("" + y).getBytes());
        
        InputStream in = socket.getInputStream();
        byte[] b = new byte[1024];
        in.read(b);
        int answer = Integer.parseInt(new String(b).trim());
        
        JOptionPane.showMessageDialog(null, "The answer it's: " + answer);
    }
    
}
