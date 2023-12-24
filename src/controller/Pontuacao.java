/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Pontos;

/**
 *
 * @author Wesley
 */
public class Pontuacao {
    
    public static List<model.Pontos> getPontuacao(){
        
        List<model.Pontos> resultados = new ArrayList<>();
        
        ConnectionDB connectionDB = new ConnectionDB();
        Connection conn = connectionDB.connectMySQL();
        try {
            String sql = "SELECT * FROM resultado WHERE id_Usuario = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, Usuario.getId());

            ResultSet result = preparedStatement.executeQuery();
            
            while (result.next()) {
                int id = result.getInt("id");
                int nivel = result.getInt("Nivel");
                int pontuacao = result.getInt("Pontuacao");
                String data = result.getString("data_Hora");
                
                model.Pontos pontos = new Pontos(id, nivel, pontuacao, data);
                resultados.add(pontos);
            }

            //Fecha os recursos
            result.close();
            preparedStatement.close();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return resultados;
    }
    
    public static void setPontuacao(int pontuacao) {
   
        ConnectionDB connectionDB = new ConnectionDB();
        Connection conn = connectionDB.connectMySQL();
        try {
            String sql = "INSERT INTO resultado (id_Usuario, Nivel, Pontuacao) VALUES (?, ?, ?)";
            System.out.println(sql);

            PreparedStatement preparedStatement = conn.prepareStatement(sql);

            // Defina os valores dos parâmetros usando os métodos apropriados
            preparedStatement.setInt(1, Usuario.getId());
            preparedStatement.setInt(2, Perguntas.getNivel());
            preparedStatement.setInt(3, pontuacao);

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Pontuacao registrada!");
            } else {
                System.out.println("Falha na marcacao da pontuacao.");
            }

            // Fecha os recursos
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
