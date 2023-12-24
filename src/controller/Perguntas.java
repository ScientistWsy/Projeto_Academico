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
import model.Questoes;

/**
 *
 * @author Wesley
 */

public class Perguntas {
    
    public static int nivel;

    public static int getNivel() {
        return nivel;
    }
    
    public static List<Questoes> getPerguntas(int nivel){
             
        Perguntas.nivel = nivel;
        
        List<Questoes> backPerguntas = new ArrayList<>();
        
        ConnectionDB connectionDB = new ConnectionDB();
        Connection conn = connectionDB.connectMySQL();
        try {
            String sql = "(SELECT * FROM perguntas WHERE tipo = 1 AND nivel = ? ORDER BY RAND() LIMIT 3) UNION ALL \n" +
             "(SELECT * FROM perguntas WHERE tipo = 2 AND nivel = ? ORDER BY RAND() LIMIT 3) UNION ALL \n" +
             "(SELECT * FROM perguntas WHERE tipo = 3 AND nivel = ? ORDER BY RAND() LIMIT 3) UNION ALL \n" +
             "(SELECT * FROM perguntas WHERE tipo = 4 AND nivel = ? ORDER BY RAND() LIMIT 3);";

            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, nivel);
            preparedStatement.setInt(2, nivel);
            preparedStatement.setInt(3, nivel);
            preparedStatement.setInt(4, nivel);
            
            ResultSet result = preparedStatement.executeQuery();

            while (result.next()) {
                int id = result.getInt("id");
                String pergunta = result.getString("Pergunta");
                int resposta = result.getInt("Resposta");
                int tipo = result.getInt("Tipo");
                int level = result.getInt("Nivel");
                String dica = result.getString("Dica");
                
                Questoes meuObjeto = new Questoes(id, pergunta, resposta, tipo, level, dica);
                backPerguntas.add(meuObjeto);
            }
            
            //System.out.println(quest);

            //Fecha os recursos
            result.close();
            preparedStatement.close();
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        
        return backPerguntas;
    }
    
}
