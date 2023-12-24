/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Wesley
 */
public class ValidacaoUser {
    
    public static boolean nome(String name) {
        return name.matches("[a-zA-Z]+");
    }

    public static boolean email(String email) {
        return email.matches("^[A-Za-z0-9+_.-]+@(.+)$");
    }

    public static boolean senha(String password) {
        return password.length() >= 8;
    }

}
