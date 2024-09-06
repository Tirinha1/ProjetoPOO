/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao;

import model.Usuario;

/**
 *
 * @author Gabriel
 */
public class Identifiable {
    int id;

    public static void main(String[] args) {
        Usuario[] users = new Usuario[10];
        Database usersDatabase = new Database(users);
        Usuario firstUser = new Usuario();
        
        firstUser.setLogin("abc");
        firstUser.setSenha("abc");
        usersDatabase.create(firstUser);
        System.out.println(usersDatabase.getById(1));
    }
}
