/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao;

import model.Pessoa;

/**
 *
 * @author Gabriel
 */
public class PessoaDAO {
    final private Pessoa[] pessoas;
    private int contador;

    public PessoaDAO(int tamanho) {
        this.pessoas = new Pessoa[tamanho];
        this.contador = 0;
    }

    public void salvar(Pessoa pessoa) {
        if (contador < pessoas.length) {
            pessoas[contador] = pessoa;
            contador++;
        } else {
            System.out.println("Erro: Limite de pessoas atingido.");
        }
    }

    public Pessoa[] listar() {
        return pessoas;
    }
    
}
