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
public class Evento {
    private int id;
    private Date data;
    private Cerimonial cerimonial;
    private Igreja igreja;
    private Cartorio cartorio;
    private Pessoa pessoaNoiva;
    private Pessoa pessoaNoivo;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataModificacao;
    
    public void setId(int id) {
        this.id = id;
    }
    
    public int getId() {
        return this.id;
    }
    
    public void setData(Date data) {
        this.data = data;
    }
    
    public Date getData() {
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
    
    public void setDataCriacao() {
        this.dataCriacao = LocalDateTime.now();
    }
    
    public LocalDateTime getDataCriacao() {
        return this.dataCriacao;
    }
    
    public void setDataModificacao() {
        this.dataModificacao = LocalDateTime.now();
    }
    
    public LocalDateTime getDataModificacao() {
        return this.dataModificacao;
    }
}
