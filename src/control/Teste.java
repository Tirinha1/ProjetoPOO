/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import javax.swing.JOptionPane;
import view.MenuInicio;

/**
 *
 * @author Gabriel
 */
public class Teste {

    boolean ok = true;
    int escolha;
    MenuInicio menuInicio = new MenuInicio();

    public void main(String[] args) {

        while (true) {
            ok = true;
            escolha = menuInicio.menuInicial(); // Chamando o menu inicial
            if (escolha == 3 || escolha == JOptionPane.CLOSED_OPTION) {
                escolha = 3;
            }

            switch (escolha) {
                case 0: // Login
                    while (ok) {
                        int escolhaPerfil = menuInicio.menuLogin();
                        perfilLogin(escolhaPerfil);
                    }
                    break;
                case 1: // Entrar sem Registrar
                    menuInicio.menuNaoLogado();
                    break;
                case 2: // Registrar
                    JOptionPane.showMessageDialog(null, "Funcionalidade de Registro.");
                    // Função de registro aqui
                    break;
                case 3: // Sair
                    JOptionPane.showMessageDialog(null, "Saindo do sistema.");
                    System.exit(0); // Finaliza o programa
                    break;
            }
        }
    }

    public void perfilLogin(int escolhaPerfil) {
        if (escolhaPerfil == 2 || escolhaPerfil == -1) {
            ok = false;
            return;
        }
        String login = JOptionPane.showInputDialog("Digite seu login:");
        if (login == null) {
            return;
        }
        String senha = JOptionPane.showInputDialog("Digite sua senha:");
        if (senha == null) {
            return;
        }

        while (true) {
            if (escolhaPerfil == 0) {
                if ("admin".equals(login) && "admin".equals(senha)) {
                    int escolhaAdm = menuInicio.menuAdministrador();
                    perfilAdm(escolhaAdm);
                    return;
                } else {
                    JOptionPane.showMessageDialog(null, "Login ou senha inválidos para Administrador.");
                    return;
                }
            } else if (escolhaPerfil == 1) {
                if ("convidado".equals(login) && "convidado".equals(senha)) {
                    int escolhaConvidado = menuInicio.menuConvidado();
                    perfilConvidado(escolhaConvidado);
                    return;
                } else {
                    JOptionPane.showMessageDialog(null, "Login ou senha inválidos para Convidado.");
                    return;
                }
            }
        }
    }

    public void perfilAdm(int escolhaAdm) {
        if (escolhaAdm == 4 || escolhaAdm == -1) {
            return; // Volta ao menu anterior
        }
        while (true) {
            switch (escolhaAdm) {
                case 0:
                    //TODO: Criar menu para gerenciar pessoas
                    break;
                case 1:
                    //TODO: Criar menu para gerenciar Usuarios
                    break;
                case 2:
                    menuInicio.menuGerenciarFornecedores();
                    break;
                case 3:
                    menuInicio.menuGerenciarConvidados();
                    // Função de gerenciamento de convidados
                    break;
                case 4:
                    menuInicio.menuGerenciarPagamentos();
                    break;
                case 5:
                    menuInicio.menuGerenciarCalendario();
                    break;
            }
        }
    }

    public void perfilConvidado(int escolhaConvidado) {
        if (escolhaConvidado == 3 || escolhaConvidado == -1) {
            return;
        }
        while (true) {
            switch (escolhaConvidado) {
                case 0:
                    menuInicio.menuPresentesConvidado();
                    break;
                case 1:
                    menuInicio.menuRecadosConvidado();
                    break;
                case 2:
                    menuInicio.confirmarPresenca();
                    break;
                case 3:
                    return; // Volta ao menu anterior
            }
        }
    }
}
