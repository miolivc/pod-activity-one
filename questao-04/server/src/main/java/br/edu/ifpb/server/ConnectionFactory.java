/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author miolivc
 */
public class ConnectionFactory {
    public static final int POSTGRES = 0;
    public static final int MYSQL = 1;
    
    public static Connection getConnection(int typeConnection) throws ClassNotFoundException, SQLException {
        Connection connection = null;
        switch(typeConnection) {
            case POSTGRES: {
                Class.forName("org.postgresql.Driver");
                connection = DriverManager.getConnection(
                        "jdbc:postgresql://host_pg:5432/db_usuario",
                        "postgres",
                        "postgres");
            } break;
            case MYSQL: {
                Class.forName("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection(
                        "jdbc:mysql://host_mysql:3306/db_usuario",
                        "myuser",
                        "mypass");
            } break;
        }
        return connection;
    }
    
}
