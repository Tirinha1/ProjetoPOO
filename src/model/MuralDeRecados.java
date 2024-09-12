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
public class MuralDeRecados {
    private Pessoa pessoa;
    private String comentario;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataModificacao;
    
    
    public MuralDeRecados(){
        dataCriacao = LocalDateTime.now();
    }
    
    public MuralDeRecados(Pessoa pessoa, String comentario){
        this.pessoa = pessoa;
        this.comentario = comentario;
        this.dataCriacao = LocalDateTime.now();
    }
    public MuralDeRecados UpdateMural(String comentario){
        this.comentario = comentario;
        this.dataModificacao = LocalDateTime.now();
        return this;
    }
    
    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
    
    public Pessoa getPessoa() {
        return this.pessoa;
    }
    
    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
    
    public String getComentario() {
        return this.comentario;
    }
    
    public LocalDateTime getDataCriacao() {
        return this.dataCriacao;
    }
    
    public LocalDateTime getDataModificacao() {
        return this.dataModificacao;
    }
}
