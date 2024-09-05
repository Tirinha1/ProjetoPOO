/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao;

import java.time.LocalDate;
import java.util.Scanner;
import java.time.format.DateTimeParseException;
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
        boolean pessoaEncontrada = false;
        for (Pessoa pessoa1 : pessoas) {
            if (pessoa1 != null && pessoa1.getId() == pessoa.getId()) {
                pessoaEncontrada = true;
                Scanner scanner = new Scanner(System.in);
                String update = """
                                O que deseja alterar:
                                1- Nome;
                                2- Data de Nascimento;
                                3- Telefone;""";

                System.out.println(update);
                String opc = scanner.nextLine();
                
                switch(opc) {
                    case "1":
                        String nome;
                        System.out.println("Digite o novo nome:");
                        nome = scanner.nextLine();
                        pessoa.setNome(nome);
                        pessoa.setDataModificacao();
                        break;
                    case "2":
                        LocalDate data;
                        System.out.println("Digite a nova data (formato: YYYY-MM-DD):");
                        try {
                            data = LocalDate.parse(scanner.nextLine());
                            pessoa.setNascimento(data);
                            pessoa.setDataModificacao();
                        } catch(DateTimeParseException e){
                            System.out.println("Formato invalido");
                        }
                        break;
                    case "3":
                        String telefone;
                        System.out.println("Digite o novo telefone");
                        telefone = scanner.nextLine();
                        pessoa.setTelefone(telefone);
                        pessoa.setDataModificacao();
                        break;
                    default:
                        System.out.println("Opção inválida!");
                        break;
                }
            }
            if (!pessoaEncontrada) {
                System.out.println("Pessoa não encontrada");
            }
        }
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
    
    public void getAllPessoa() {
        for (Pessoa pessoa : pessoas) {
            if (pessoa != null) {
                System.out.println(pessoa.toString());
            }
        }
    }
}
