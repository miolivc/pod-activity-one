/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.node;

import br.edu.ifpb.shared.Calculator;
import br.edu.ifpb.shared.UnknownAnswerException;

/**
 *
 * @author miolivc
 */
public class Service implements Calculator {
    
    @Override
    public double op1(double x, double y) {
        return (2 * x * y);
    }

    @Override
    public double op2(double x, double y) throws UnknownAnswerException {
        throw new UnknownAnswerException();
    }
  
}
