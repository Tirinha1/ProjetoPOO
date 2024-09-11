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
    private static long serial = 0;
    
    public Familia(){
        this.id = ++serial;
        this.dataCriacao = LocalDateTime.now();
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
    
    public LocalDateTime getDataCriacao() {
        return this.dataCriacao;
    }

    public LocalDateTime getDataModificacao() {
        return this.dataModificacao;
    }
}