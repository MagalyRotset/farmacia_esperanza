/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Magaly García
 */
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;

public class conexion {
    Connection con;
    String url = "jdbc:mysql://localhost:3306/bd_farmacia_esperanza";
    String user = "root";
    String pass = "089714MG";

    public Connection Conectar() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, user, pass);
        } catch (Exception e) {

        }
        return con;

    }
}

