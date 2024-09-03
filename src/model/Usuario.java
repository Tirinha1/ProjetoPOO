/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDateTime;

public class Usuario {
    private long id;
    private Pessoa pessoa;
    private String tipo;
    private String login;
    private String senha;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataModificacao;
    private static long idCounter = 0;
    
    public Usuario(){
        this.id = ++idCounter;
        this.dataCriacao = LocalDateTime.now();
    }
    
    public Usuario(Pessoa pessoa, String tipo){
        this.id = ++idCounter;
        this.pessoa = pessoa;
        this.tipo = tipo;
        this.login = pessoa.getNome();
        this.senha = pessoa.getNome() + pessoa.getNascimento();
        this.dataCriacao = LocalDateTime.now();
    }
    
    public Usuario updateUsuario(Pessoa pessoa, String tipo){
        this.pessoa = pessoa;
        this.tipo = tipo;
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
    
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public String getTipo() {
        return this.tipo;
    }
   
    public LocalDateTime getDataCriacao() {
        return this.dataCriacao;
    }
    
    public LocalDateTime getDataModificacao() {
        return this.dataModificacao;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", pessoa=" + pessoa + ", tipo=" + tipo + ", login=" + login + ", senha=" + senha + ", dataCriacao=" + dataCriacao + ", dataModificacao=" + dataModificacao + '}';
    }
}

