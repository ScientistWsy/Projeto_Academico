/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Wesley
 */
public class Usuario {
    
    private static int id;
    private static String nome;
    private static String email;
    private static String senha;
    private static int idade;
    
    public static int getId() {
        return id;
    }
    
    public static boolean getUser(String login, String senha){
        
        Usuario.nome = login;
        Usuario.senha = senha;
        
        boolean validado = false;
        
        ConnectionDB connectionDB = new ConnectionDB();
        Connection conn = connectionDB.connectMySQL();
        try {
            String sql = "SELECT * FROM usuario WHERE nome = ? AND senha = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, Usuario.nome);
            preparedStatement.setString(2, Usuario.senha);

            ResultSet result = preparedStatement.executeQuery();
            
            while (result.next()) {
                id = result.getInt("id");
                String text = result.getString("nome");
                email = result.getString("email");
                idade = Integer.parseInt(result.getString("idade"));
                validado = true;
            }

            //Fecha os recursos
            result.close();
            preparedStatement.close();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return validado;
    }
    
    public static void insereUser(String nome, String email, String senha, int idade) {
   
        ConnectionDB connectionDB = new ConnectionDB();
        Connection conn = connectionDB.connectMySQL();
        try {
            String sql = "INSERT INTO usuario (nome, email, senha, idade) VALUES (?, ?, ?, ?)";
            System.out.println(sql);

            PreparedStatement preparedStatement = conn.prepareStatement(sql);

            // Defina os valores dos parâmetros usando os métodos apropriados
            preparedStatement.setString(1, nome);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, senha);
            preparedStatement.setInt(4, idade);

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Cadastro bem-sucedido!");
                JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!");
            } else {
                System.out.println("Nenhuma linha foi afetada.");
            }

            // Fecha os recursos
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
