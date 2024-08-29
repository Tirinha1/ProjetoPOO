/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao;

import java.time.LocalDate;
import model.Pessoa;

/**
 *
 * @author Gabriel
 */
public class PessoaDAO {

    private Pessoa[] pessoas;
    private int count;

    public PessoaDAO(int tamanho) {
        pessoas = new Pessoa[tamanho];
        count = 0;
    }

    public void criarPessoa(Pessoa pessoa) {
        if (count < pessoas.length) {
            pessoas[count] = pessoa;
            count++;
        } else {
            System.out.println("capacidade maxima atingida");
        }
    }

    public Pessoa getPessoaById(int id) {
        for (int i = 0; i < count; i++) {
            if (pessoas[i].getId() == id) {
                return pessoas[i];
            }
        }
        return null;
    }

    public void updatePessoa(Pessoa pessoa) {
        for (int i = 0; i < count; i++) {
            if (pessoas[i].getId() == pessoa.getId()) {
                pessoas[i].updatePessoa(pessoa.getNome(), pessoa.getNascimento(), pessoa.getTelefone());
                return;
            }
        }
        System.out.println("Pessoa não encontrada");
    }

    public void deletePessoa(int id) {
        for (int i = 0; i < count; i++) {
            if (pessoas[i].getId() == id) {
                for (int j = i; j < count - 1; j++) {
                    pessoas[j] = pessoas[j + 1];
                }
                pessoas[count - 1] = null;
                count--;
                return;
            }
        }
        
        System.out.println("Pessoa não encontrada");
    }
    
    public void getAllPessoa(){
        for(int i = 0; i < count; i++){
            System.out.println(pessoas[i].toString());
        }
    }
}
