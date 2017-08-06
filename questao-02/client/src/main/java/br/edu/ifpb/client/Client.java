/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.client;

import br.edu.ifpb.shared.UnknownAnswerException;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author miolivc
 */
public class Client {
    
    public static void main(String[] args) throws IOException, UnknownAnswerException {
        
        Scanner input = new Scanner(System.in);
        
        System.out.print("Digite o primeiro numero: ");
        double x = input.nextDouble(); input.nextLine();
        
        System.out.print("Digite o segundo numero: ");
        double y = input.nextDouble(); input.nextLine();
        
        System.out.print("Digite 1 ou 2 como escolha de opção: ");
        int option = input.nextInt(); input.nextLine();
        
        if(option == 1 || option == 2) {
            Service service = new Service(option);
            double answer = service.calculate(x, y);
            System.out.println("A resposta do sistema para o calculo foi: " + answer);
        } else {
            System.out.print("O programa encerrará pois sua opção é invalida");
            input.close();
            System.exit(option);
        }
    }
    
}
