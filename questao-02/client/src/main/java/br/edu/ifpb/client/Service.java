/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.client;

import br.edu.ifpb.shared.Calculator;
import br.edu.ifpb.shared.Provider;
import br.edu.ifpb.shared.UnknownAnswerException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Random;

/**
 *
 * @author miolivc
 */
public class Service {
    private final Socket socket;
    private final int option;

    public Service(int option) throws IOException {
        this.option = option;
        this.socket = new Provider().serverRandom();
    }
    
    public double calculate(double x, double y) throws IOException, UnknownAnswerException {
        OutputStream out = socket.getOutputStream();
        out.write((x + "").getBytes());
        out.write((y + "").getBytes());
        
        InputStream input = socket.getInputStream();
        byte[] b = new byte[1024];
        input.read(b);
        return Double.parseDouble(new String(b).trim());
    }
    
}
