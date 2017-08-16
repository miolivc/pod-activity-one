/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.client;

import br.edu.ifpb.shared.Usuario;
import java.io.IOException;

/**
 *
 * @author miolivc
 */
public class ClientMain {
    
    public static void main(String[] args) throws IOException {
        
        Usuario usuario = new Usuario("Michelle");
        PersistUser persistUser = new PersistUser();
        persistUser.persistUser(usuario);
        
    }
    
}
