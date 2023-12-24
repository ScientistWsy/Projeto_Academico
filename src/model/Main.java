/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import view.Home;
import view.Login;
import view.Intro;
import view.Nivel;
import view.Questionario;
import view.Cadastro;
import view.Resultado;

/**
 *
 * @author Wesley
 */
public class Main {
    // Declaração da variável intro como uma variável de instância
    private static Home home;
    private static Login login;
    private static Intro intro;
    private static Nivel nivel;
    private static Questionario questoes;
    private static Cadastro cadastro;
    private static Resultado resultado;

    // Métodos de interação das telas/views
    
    public static void main(String[] args) {
        home();
    }

    public static void home(){
        home = new Home();
        home.setVisible(true);
    }
    
    public static void login() {
        home.setVisible(false);
        login = new Login();
        login.setVisible(true);
    }
    
    public static void intro(){
        if (resultado != null){
            resultado.setVisible(false);
            resultado = null;
        }
        login.setVisible(false);
        intro = new Intro();
        intro.setVisible(true);
    }
    
    public static void nivel(){
        intro.setVisible(false);
        if (nivel == null) nivel = new Nivel();
        nivel.setVisible(true);
    }
    
    public static void questoes(int level){
        if (resultado != null) resultado = null;
        nivel.setVisible(false);
        if (questoes == null) {
            questoes = new Questionario(level);
        } 
        else {
            questoes(level);
        }
        questoes.setVisible(true);
    }
    
    public static void cadastro(){
        login.setVisible(false);
        if (cadastro == null) cadastro = new Cadastro();
        cadastro.setVisible(true);
    }
    
    public static void backLogin(){
       cadastro.setVisible(false);
       login.setVisible(true);
    }
    
    public static void resultado(){
        if (questoes != null) questoes.setVisible(false);
        intro.setVisible(false);
        if (resultado == null) resultado = new Resultado();
        resultado.setVisible(true);
    }
}