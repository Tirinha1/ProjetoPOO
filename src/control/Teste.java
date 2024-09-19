/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import javax.swing.JOptionPane;
import view.MenuInicio;
import static view.MenuInicio.menuPresentesNaoLogado;
import static view.MenuInicio.menuRecadosNaoLogado;

/**
 *
 * @author Gabriel
 */
public class Teste {
    static int escolha;

    public static void main(String[] args) {
        
        MenuInicio menuInicio = new MenuInicio();
        while(true){
        escolha = MenuInicio.menuInicial(); // Chamando o menu inicial
         if (escolha == 3 || escolha == JOptionPane.CLOSED_OPTION) {
                escolha = 3;
            }
      
            switch (escolha) {
                case 0: // Login
                    menuLogin();
                    break;
                case 1: // Entrar sem Registrar
                    menuNaoLogado();
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

    public static void menuLogin() {
        while (true) {
            String[] perfis = {"Administrador", "Convidado", "Voltar"};

            int escolhaPerfil = JOptionPane.showOptionDialog(null, "Escolha o perfil de acesso", "Seleção de Perfil",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, perfis, perfis[perfis.length - 1]);

            if (escolhaPerfil == perfis.length - 1 || escolhaPerfil == JOptionPane.CLOSED_OPTION) {
                return; // Volta ao menu anterior
            }

            String perfil = perfis[escolhaPerfil]; // Armazena o perfil selecionado (Administrador ou Convidado)

            String login = JOptionPane.showInputDialog("Digite seu login:");
            String senha = JOptionPane.showInputDialog("Digite sua senha:");

            if ("Administrador".equals(perfil)) {
                if ("admin".equals(login) && "admin".equals(senha)) {
                    menuAdministrador();
                } else {
                    JOptionPane.showMessageDialog(null, "Login ou senha inválidos para Administrador.");
                }
            } else if ("Convidado".equals(perfil)) {
                if ("convidado".equals(login) && "convidado".equals(senha)) {
                    menuConvidado();
                } else {
                    JOptionPane.showMessageDialog(null, "Login ou senha inválidos para Convidado.");
                }
            }
        }
    }
      public static void menuNaoLogado() {
        while (true) {
            String[] opcoes = {"Presentes", "Recados", "Voltar"};
            int escolha = JOptionPane.showOptionDialog(null, "Menu Não Logado", "Menu", JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE, null, opcoes, opcoes[0]);

            switch (escolha) {
                case 0:
                    menuPresentesNaoLogado();
                    break;
                case 1:
                    menuRecadosNaoLogado();
                    break;
                case 2:
                    return; // Volta ao menu anterior
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida.");
            }
        }
    }

}