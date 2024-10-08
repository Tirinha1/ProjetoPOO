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
    
    public String getLogin() {
        return this.login;
    }
     
     public void setSenha(String senha) {
        this.senha = senha;
    }
     
     public String getSenha() {
        return this.senha;
    }
    
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public String getTipo() {
        return this.tipo;
    }

    @Override
    public String toString() {
        return "Usuario{" + "tipo=" + tipo + ", login=" + login + ", senha=" + senha + super.toString() + '}';
    }
    
}

