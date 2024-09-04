/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public class Usuario extends Pessoa {
    private String tipo;
    private String login;
    private String senha;
    
    public Usuario(){
        super();
    }
    
    public void setLogin(String login) {
        this.login = login;
    }
     
     public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public String getTipo() {
        return this.tipo;
    }
}

