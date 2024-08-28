/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDateTime;

/**
 *
 * @author Gabriel
 */
public class Presentes {
    private long id;
    private String nome;
    private String tipo;
    private Pessoa pessoa;
    private double valor;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataModificacao;
    private static long idCounter = 0;
    
    public Presentes(){
        this.id = ++idCounter;
        this.dataCriacao = LocalDateTime.now();
    }
    
    public Presentes(String nome, String tipo, Pessoa pessoa, double valor){
        this.id = ++idCounter;
        this.nome = nome;
        this.tipo = tipo;
        this.pessoa = pessoa;
        this.valor = valor;
        this.dataCriacao = LocalDateTime.now();
    }
    
    public Presentes updatePresentes(String nome, String tipo, Pessoa pessoa, double valor){
        this.nome = nome;
        this.tipo = tipo;
        this.pessoa = pessoa;
        this.valor = valor;
        this.dataModificacao = LocalDateTime.now();
        return this;
    }
    
    public long getId() {
        return this.id;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getNome() {
        return this.nome;
    }
    
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public String getTipo() {
        return this.tipo;
    }
    
    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
    
    public Pessoa getPessoa() {
        return this.pessoa;
    }
    
    public void setValor(double valor) {
        this.valor = valor;
    }
    
    public double getValor() {
        return this.valor;
    }

    public LocalDateTime getDataCriacao() {
        return this.dataCriacao;
    }
    
    public LocalDateTime getDataModificacao() {
        return this.dataModificacao;
    }
}
