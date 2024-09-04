/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao;

/**
 *
 * @author Gabriel
 */

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
            // Você pode querer lançar uma exceção em vez de imprimir uma mensagem
        }
    }

    public Usuario getUsuarioById(long id) {
        for (int i = 0; i < count; i++) {
            if (usuarios[i].getId() == id) {
                return usuarios[i];
            }
        }
        return null; // Ou lançar uma exceção se o usuário não for encontrado
    }

    /*public void updateUsuario(Usuario usuario) {
        for (int i = 0; i < count; i++) {
            if (usuarios[i].getId() == usuario.getId()) {
                usuarios[i].updateUsuario(usuario.getPessoa(), usuario.getTipo());
                return;
            }
        }
        System.out.println("Usuário não encontrado");
        // Outra opção seria lançar uma exceção
    } */

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
    /*public Usuario[] getAllUsuarios() {
        Usuario[] usuariosAtivos = new Usuario[count];
        for (int i = 0; i < count; i++) {
            usuariosAtivos[i] = usuarios[i];
        }
        return usuariosAtivos;
    } */
}
