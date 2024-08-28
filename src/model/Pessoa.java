/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 *
 * @author Gabriel
 */
public class Pessoa {
    private  long id;
    private String nome;
    private LocalDate nascimento;
    private String telefone;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataModificacao;
    private static long idCounter = 0;
    
    
    public  Pessoa(String nome, LocalDate nascimento, String telefone){
        this.id = ++idCounter;
        this.nome = nome;
        this.nascimento = nascimento;
        this.telefone = telefone;
        this.dataCriacao = LocalDateTime.now();
    }
    
    public void updatePessoa(String nome, LocalDate nascimento, String telefone){
        this.nome = nome;
        this.nascimento = nascimento;
        this.telefone = telefone;
        this.dataModificacao = LocalDateTime.now();
    }
    
    public long getId(){
        return this.id;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public String getNome(){
        return this.nome;
    }
    
    public void setNascimento(LocalDate nascimento){
        this.nascimento = nascimento;
    }
    
    public LocalDate getNascimento(){
        return this.nascimento;
    }
    
    public void setTelefone(String telefone){
        this.telefone = telefone;
    }
    
    public String getTelefone(){
        return this.telefone;
    }
    
    public LocalDateTime getDataCriacao(){
        return this.dataCriacao;
    }  
    
    public LocalDateTime getDataModificacao(){
        return this.dataModificacao;
    }
}
