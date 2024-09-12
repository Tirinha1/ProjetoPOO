/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import model.dao.Identifiable;

/**
 *
 * @author Gabriel
 */
public class Cerimonial extends Identifiable{
    private String nome;
    
    public void setName(String nome){
        this.nome = nome;
    }
    
    public String getName(){
        return this.nome;
    }
}
