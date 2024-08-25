/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDateTime;
import java.util.Date;

/**
 *
 * @author Gabriel
 */
public class Pessoa {
    private int id;
    private String nome;
    private Date nascimento;
    private String telefone;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataModificacao;
    
    public void setId(int id ){
        this.id = id;
    }
    
    public int getId(){
        return this.id;
    }
    
    public void setName(String nome){
        this.nome = nome;
    }
    
    public String getName(String nome){
        return this.nome;
    }
    
    public void setDate(Date nascimento){
        this.nascimento = nascimento;
    }
    
    public Date getDate(){
        return this.nascimento;
    }
    
    public void setTelefone(String telefone){
        this.telefone = telefone;
    }
    
    public String getTelefone(){
        return this.telefone;
    }
    
    public void setDataCriacao(){
        this.dataCriacao = LocalDateTime.now();
    }
    
    public LocalDateTime getDataCriacao(){
        return this.dataCriacao;
    }
    
    public void setDataModificacao(){
        this.dataModificacao = LocalDateTime.now();
    }
    
    public LocalDateTime getDataModificacao(){
        return this.dataModificacao;
    }
}
