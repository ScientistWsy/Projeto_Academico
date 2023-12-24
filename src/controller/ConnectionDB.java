/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
/**
 *
 * @author Wesley
 */

public class ConnectionDB {
    
    public Connection connectMySQL(){
        Connection conn = null;
        
        try {
            String url = "jdbc:mysql://localhost:3306/matheasy?user=root&password=123456&useSSL=false";

            conn = DriverManager.getConnection(url);
            
            System.out.println("Conexao realizada com sucesso.");
		    
        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, error.getMessage());
        }
        return conn;
    }
}
