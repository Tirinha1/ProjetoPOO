/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao;

/**
 *
 * @author Gabriel
 */

import java.util.Scanner;
import model.Usuario;

public class UsuarioDAO {

    private Usuario[] usuarios;
    private int count;

    public UsuarioDAO(int tamanho) {
        usuarios = new Usuario[tamanho];
        count = 0;
    }

    public void criarUsuario(Usuario usuario) {
        if (count < usuarios.length) {
            usuarios[count] = usuario;
            count++;
        } else {
            System.out.println("Capacidade máxima atingida");
        }
    }

    public Usuario getUsuarioById(long id) {
        for (int i = 0; i < count; i++) {
            if (usuarios[i].getId() == id) {
                return usuarios[i];
            }
        }
        return null; 
    }

    public void updateUsuario(Usuario usuario) {
        for (Usuario usuario1 : usuarios) {
            if (usuario1.getId() == usuario.getId()) {
                Scanner scanner = new Scanner(System.in);
                String update = """
                                O que deseja alterar:
                                1- Tipo;
                                2- Login;
                                3- Senha;""";

                System.out.println(update);
                String opc = scanner.nextLine();
                
                switch(opc) {
                    case "1":
                        String tipo;
                        String alterarTipo = "Insira o novo tipo de Usuario:";
                        System.out.println(alterarTipo);
                        tipo = scanner.nextLine();
                        usuario.setTipo(tipo);
                        usuario.setDataModificacao();
                        break;
                    case "2":
                        String login;
                        String alterarLogin = "Insira o seu novo Login:";
                        System.out.println(alterarLogin);
                        login = scanner.nextLine();
                        usuario.setLogin(login);
                        break;
                    case "3":
                        String senha;
                        String alterarSenha = "Insira a sua noao Senha:";
                        System.out.println(alterarSenha);
                        senha = scanner.nextLine();
                        usuario.setSenha(senha);
                        break;
                    default:
                        System.out.println("Opção inválida!");
                        break;
                }
            } else {
                System.out.println("Usuario não encontrado");
            }
        }
    }

    public void deleteUsuario(long id) {
        for (int i = 0; i < count; i++) {
            if (usuarios[i].getId() == id) {
                for (int j = i; j < count - 1; j++) {
                    usuarios[j] = usuarios[j + 1];
                }
                usuarios[count - 1] = null;
                count--;
                return;
            }
        }
        System.out.println("Usuário não encontrado");
    }
    
    public void getAllUsuario() {
        for (Usuario usuario : usuarios) {
            if (usuario != null) {
                System.out.println(usuario.toString());
            }
        }
    }
}
