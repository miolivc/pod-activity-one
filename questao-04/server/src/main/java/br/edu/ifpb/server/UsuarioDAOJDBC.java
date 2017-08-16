/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.server;

import br.edu.ifpb.shared.Usuario;
import java.sql.Connection;

/**
 *
 * @author miolivc
 */
public class UsuarioDAOJDBC implements UsuarioDAO {
    private final Connection connection;

    public UsuarioDAOJDBC(Connection connection) {
        this.connection = connection;
    }
    
    @Override
    public void add(Usuario usuario) {
        String sql = "INSERT INTO USUARIO(ID, NAME) VALUES(?, ?)";
//        PreparedStatement stmt = 
    }
    
}
