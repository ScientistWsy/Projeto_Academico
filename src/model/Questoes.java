/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Wesley
 */
public class Questoes {

    private int id;
    private String pergunta;
    private int resposta;
    private int tipo_questao;
    private int nivel;
    private String dica;
    public List<Integer> alternativas;
    
    public Questoes(int id, String pergunta, int resposta, int tipo, int nivel, String dica) {
        this.id = id;
        this.pergunta = pergunta;
        this.resposta = resposta;
        this.tipo_questao = tipo;
        this.nivel = nivel;
        this.dica = dica;
        this.alternativas = gerarAlternativas(resposta);
    }

    public Questoes() {

    }
    
    public int getId(){
        return id;
    }

    public String getPergunta() {
        return pergunta;
    }

    public int getResposta() {
        return resposta;
    }

    public int getTipo_questao() {
        return tipo_questao;
    }

    public int getNivel() {
        return nivel;
    }
    
    public String getDica(){
        return dica;
    }

    public List<Integer> gerarAlternativas(int resposta) {
        int numeroDeAlternativas = 4;
        int intervaloMinimo = resposta - 5;
        int intervaloMaximo = resposta + 5;
        List<Integer> alternativas = new ArrayList<>();

        Random random = new Random();
        for (int i = 0; i < numeroDeAlternativas; i++) {
            int alternativa;
            do {
                alternativa = random.nextInt(intervaloMaximo - intervaloMinimo + 1) + intervaloMinimo;
            } while (alternativa == resposta || alternativas.contains(alternativa));

            alternativas.add(alternativa);
        }
        
        // Adiciona a resposta em uma posição aleatória na lista
        int posicaoResposta = random.nextInt(numeroDeAlternativas + 1);
        alternativas.add(posicaoResposta, resposta);

        // Embaralha a ordem dos elementos na lista
        Collections.shuffle(alternativas);

        return alternativas;
    }
}