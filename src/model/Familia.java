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
public class Familia {
    private long id;
    private String nomeFamilia;
    private String acesso;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataModificacao;
    private static long idCounter = 0;
    
    public Familia(){
        this.id = ++idCounter;
        this.dataCriacao = LocalDateTime.now();
    }
    
    public Familia(String nomeFamilia){
        this.id = ++idCounter;
        this.nomeFamilia = nomeFamilia;
        this.acesso = null; // TODO:criar pessoaNoivo e pessoaNoiva para gerar o acesso nome noivo + nome noiva + data nasc + 1234
        this.dataCriacao = LocalDateTime.now();
    }
    
    public Familia updateFamilia(String nomeFamilia){
        this.nomeFamilia = nomeFamilia;
        this.dataModificacao =  LocalDateTime.now();
        return this;
    }
   
    public long getId() {
        return this.id;
    }
    
    public void setNomeFamilia(String nomeFamilia) {
        this.nomeFamilia = nomeFamilia;
    }
    
    public String getNomeFamilia() {
        return this.nomeFamilia;
    }
    
    public void setAcesso(String acesso) {
        this.acesso = acesso;
    }
    
    public String getAcesso() {
        return this.acesso;
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