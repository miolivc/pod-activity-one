/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.client;

import br.edu.ifpb.shared.Usuario;
import com.sun.istack.internal.logging.Logger;
import java.util.concurrent.ExecutorService;
import java.time.LocalTime;
import org.junit.Test;

/**
 *
 * @author miolivc
 */
public class PersistUserTest {
    
    private PersistUser persist = new PersistUser();
    
    @Test
    public void timeFor100Users() {
        Usuario usuario = new Usuario("Teste 100 usuarios");
        LocalTime initialTime = LocalTime.now();
        for (int i = 0; i < 100; i++) {
            persist.persistUser(usuario);
        }
        LocalTime finalTime = LocalTime.now();
        Logger.getLogger(PersistUser.class).info("Tempo para 100 usuarios: " +
                (finalTime.minusSeconds(initialTime.getSecond())));
    }
    
    @Test
    public void timeFor100UsersLoop() {
        Usuario usuario = new Usuario("Teste 1000 usuarios loop");
        LocalTime initialTime = LocalTime.now();
        for (int i = 0; i < 1000; i++) {
            persist.persistUser(usuario);
        }
        LocalTime finalTime = LocalTime.now();
        Logger.getLogger(PersistUser.class).info("Tempo para 1000 usuarios com loop: " +
                (finalTime.minusSeconds(initialTime.getSecond())));
    }
    
    @Test
    public void timeFor100UsersThread() {
        
    }
}
