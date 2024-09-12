/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao;

import java.util.Arrays;
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
        Usuario secondUser = new Usuario();
        
        firstUser.setLogin("abc");
        firstUser.setSenha("abc");
        
        secondUser.setLogin("azc");
        secondUser.setSenha("azb");
        
        usersDatabase.create(firstUser);
        usersDatabase.create(secondUser);
        
        System.out.println(usersDatabase.getById(1));
        System.out.println(Arrays.toString(usersDatabase.getAll()));
    }
}
