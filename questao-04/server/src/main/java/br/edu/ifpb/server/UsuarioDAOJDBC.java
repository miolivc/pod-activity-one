/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.server;

import br.edu.ifpb.shared.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author miolivc
 */
public class UsuarioDAOJDBC implements UsuarioDAO {
    private final Connection connection;

    public UsuarioDAOJDBC(int connectionType) throws ClassNotFoundException, SQLException {
        this.connection = ConnectionFactory.getConnection(connectionType);
    }
    
    @Override
    public void add(Usuario usuario) {
        try {
            String sql = "INSERT INTO USUARIO(ID, NAME) VALUES(?, ?)";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, usuario.getId());
            stmt.setString(2, usuario.getName());
            if (stmt.executeUpdate() != 1) throw new SQLException();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
