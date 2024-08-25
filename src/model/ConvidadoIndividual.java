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
    public class RelacaoFamiliar {
    private int id;
    private Pessoa pessoa;
    private Familia familia;
    private String parentesco;
    private boolean confirmado;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataModificacao;
    
    public void setId(int id) {
        this.id = id;
    }
    
    public int getId() {
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
}
