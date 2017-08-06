/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.server;

/**
 *
 * @author miolivc
 */

public interface Calculator {
    
    public static int calculate(int x, int y) {
        return (int) (Math.pow(x, y) + Math.pow(y, x));
    }
    
}
