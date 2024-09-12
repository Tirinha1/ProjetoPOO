/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao;

import java.util.Arrays;
import model.Presentes;
import model.Usuario;

/**
 *
 * @author Gabriel
 */
public class Identifiable {
    private int id;
    
    public int getID(){
        return this.id;
    }
    
    public void setID(int id){
        this.id = id;
    }

    public static void main(String[] args) {
        Utils util = new Utils();
        Usuario[] users = new Usuario[10];
        Database usersDatabase = new Database(users);
        Usuario firstUser = new Usuario();
        Usuario secondUser = new Usuario();
        
        Presentes[] gifts = new Presentes[0];
        Database giftsDatabase = new Database(gifts);
        
        Presentes firstGift = new Presentes();
        Presentes secondGift = new Presentes();
        
        giftsDatabase.create(firstGift);
        giftsDatabase.create(secondGift);
        
        firstGift.setPessoa(firstUser);
        secondGift.setPessoa(secondUser);
        
        firstUser.setLogin("abc");
        firstUser.setSenha("abc");
        firstUser.setNascimento(util.formatDate("03-04-2001"));
        
        secondUser.setLogin("azc");
        secondUser.setSenha("azb");
        
        usersDatabase.create(firstUser);
        usersDatabase.create(secondUser);
        
 
        
        System.out.println(usersDatabase.getById(1));
        System.out.println(Arrays.toString(usersDatabase.getAll()));
        System.out.println(giftsDatabase.getById(1));
        System.out.println(Arrays.toString(giftsDatabase.getAll()));
    }
}
