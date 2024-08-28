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
public class Evento {
    private int id;
    private LocalDate data;
    private Cerimonial cerimonial;
    private Igreja igreja;
    private Cartorio cartorio;
    private Pessoa pessoaNoiva;
    private Pessoa pessoaNoivo;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataModificacao;
    
    public Evento(){
        this.id = 1;
        this.dataCriacao = LocalDateTime.now();
    }
    
    public Evento(LocalDate data, Cerimonial cerimonial, Igreja igreja, Cartorio cartorio, Pessoa pessoaNoiva, Pessoa pessoaNoivo){
        this.id = 1;
        this.data = data;
        this.cerimonial = cerimonial;
        this.igreja = igreja;
        this.cartorio = cartorio;
        this.pessoaNoiva = pessoaNoiva;
        this.pessoaNoivo = pessoaNoivo;
        this.dataCriacao = LocalDateTime.now();
    }
    
    public Evento updateEvento(LocalDate data, Cerimonial cerimonial, Igreja igreja, Cartorio cartorio, Pessoa pessoaNoiva, Pessoa pessoaNoivo){
        this.data = data;
        this.cerimonial = cerimonial;
        this.igreja = igreja;
        this.cartorio = cartorio;
        this.pessoaNoiva = pessoaNoiva;
        this.pessoaNoivo = pessoaNoivo;
        this.dataModificacao = LocalDateTime.now();
        
        return this;
    }
    
    public int getId() {
        return this.id;
    }
    
    public void setData(LocalDate data) {
        this.data = data;
    }
    
    public LocalDate getData() {
        return this.data;
    }
    
    public void setCerimonial(Cerimonial cerimonial) {
        this.cerimonial = cerimonial;
    }
    
    public Cerimonial getCerimonial() {
        return this.cerimonial;
    }
    
    public void setIgreja(Igreja igreja) {
        this.igreja = igreja;
    }
    
    public Igreja getIgreja() {
        return this.igreja;
    }
    
    public void setCartorio(Cartorio cartorio) {
        this.cartorio = cartorio;
    }
    
    public Cartorio getCartorio() {
        return this.cartorio;
    }
    
    public void setPessoaNoiva(Pessoa pessoaNoiva) {
        this.pessoaNoiva = pessoaNoiva;
    }
    
    public Pessoa getPessoaNoiva() {
        return this.pessoaNoiva;
    }
    
    public void setPessoaNoivo(Pessoa pessoaNoivo) {
        this.pessoaNoivo = pessoaNoivo;
    }
    
    public Pessoa getPessoaNoivo() {
        return this.pessoaNoivo;
    }

    public LocalDateTime getDataCriacao() {
        return this.dataCriacao;
    }
    
    public LocalDateTime getDataModificacao() {
        return this.dataModificacao;
    }
}
