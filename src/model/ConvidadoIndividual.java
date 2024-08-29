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
public class ConvidadoIndividual {
    private long id;
    private Pessoa pessoa;
    private Familia familia;
    private String parentesco;
    private boolean confirmado;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataModificacao;
    private static long idCounter = 0;
    
    public ConvidadoIndividual(){
        this.id = ++idCounter;
        this.dataCriacao = LocalDateTime.now();
    }
    
    public ConvidadoIndividual(Pessoa pessoa, String parentesco, boolean confirmado){
        this.id = ++idCounter;
        this.pessoa = pessoa;
        this.parentesco = parentesco;
        this.confirmado = confirmado;
        this.dataCriacao = LocalDateTime.now();
    }
    
    public ConvidadoIndividual updateConvidadoIndividual(Pessoa pessoa, String parentesco, boolean confirmado){
        this.pessoa = pessoa;
        this.parentesco = parentesco;
        this.confirmado = confirmado;
        this.dataModificacao = LocalDateTime.now();
        return this;
    }
    
    public long getId() {
        return this.id;
    }
    
    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
    
    public Pessoa getPessoa() {
        return this.pessoa;
    }
    
    public void setFamilia(Familia familia) {
        this.familia = familia;
    }
    
    public Familia getFamilia() {
        return this.familia;
    }
    
    public void setParentesco(String parentesco) {
        this.parentesco = parentesco;
    }
    
    public String getParentesco() {
        return this.parentesco;
    }
    
    public void setConfirmado(boolean confirmado) {
        this.confirmado = confirmado;
    }
    
    public boolean isConfirmado() {
        return this.confirmado;
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

