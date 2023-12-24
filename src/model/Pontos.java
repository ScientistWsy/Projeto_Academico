/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Wesley
 */
public class Pontos {
    
    private int idUser;
    private int nivel;
    private int pontuacao;
    private String dataHora;
    
    public Pontos(int idUser, int nivel, int pontuacao, String dataHora) {
        this.idUser = idUser;
        this.nivel = nivel;
        this.pontuacao = pontuacao;
        this.dataHora = dataHora;
    }

    public int getIdUser() {
        return idUser;
    }

    public int getNivel() {
        return nivel;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public String getDataHora() {
        return dataHora;
    }

}
