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
    
    public void Usuario(Pessoa pessoa, String tipo){
        this.id = ++idCounter;
        this.pessoa = pessoa;
        this.tipo = tipo;
        this.login = pessoa.getNome();
        this.senha = pessoa.getNome() + pessoa.getNascimento();
        this.dataCriacao = LocalDateTime.now();
    }
    
    public void updateUsuario(Pessoa pessoa, String tipo){
        this.pessoa = pessoa;
        this.tipo = tipo;
        this.dataModificacao = LocalDateTime.now();
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
    public void setLogin(String login) {
        this.login = login;
    }
    
    public String setLogin() {
        return this.login;
    }
    
    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public String getSenha() {
        return this.senha;
    }
    
    public LocalDateTime getDataCriacao() {
        return this.dataCriacao;
    }
    
    public LocalDateTime getDataModificacao() {
        return this.dataModificacao;
    }
}

