/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Gabriel
 */
public class Cerimonial {
    private String nome;
    
    public Cerimonial(String nome){
        this.nome = nome;
    }
    
    public Cerimonial updateCerimonial(String nome){
        this.nome = nome;
        return this;
    }
    
    public void setName(String nome){
        this.nome = nome;
    }
    
    public String getName(){
        return this.nome;
    }
}
