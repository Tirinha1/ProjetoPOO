/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import model.dao.Identifiable;

/**
 *
 * @author Gabriel
 */
public class Pessoa extends Identifiable {
    private long id;
    private String nome;
    private LocalDate nascimento;
    private String telefone;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataModificacao;
    private static long serial = 0;
    
    public Pessoa(){
        this.id = ++serial;
        this.dataCriacao = LocalDateTime.now();
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
    
    public void setDataModificacao(){
        this.dataModificacao = LocalDateTime.now();
    }
    
    public LocalDateTime getDataModificacao(){
        return this.dataModificacao;
    }

    @Override
    public String toString() {
        return " Pessoa{" + "id=" + id + ", nome=" + nome + ", nascimento=" + nascimento + ", telefone=" + telefone + ", dataCriacao=" + dataCriacao + ", dataModificacao=" + dataModificacao + '}';
    }
    
}
