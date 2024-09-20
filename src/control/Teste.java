/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import java.time.LocalDate;
import javax.swing.JOptionPane;
import model.Pessoa;
import model.dao.Database;
import model.dao.Utils;
import view.MenuInicio;

/**
 *
 * @author Gabriel
 */
public class Teste {

    boolean admOk = true;
    boolean ok = true;
    int escolha;
    MenuInicio menuInicio = new MenuInicio();
    Pessoa[] pessoas = new Pessoa[0];
    Database pessoasDatabase = new Database(pessoas);
    Utils utils = new Utils();

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
            switch (escolhaPerfil) {
                case 0:
                    if ("admin".equals(login) && "admin".equals(senha)) {
                        int escolhaAdm = menuInicio.menuAdministrador();
                        perfilAdm(escolhaAdm);
                        admOk = true;
                        return;
                    } else {
                        JOptionPane.showMessageDialog(null, "Login ou senha inválidos para Administrador.");
                    }
                    break;
                case 1:
                    if ("convidado".equals(login) && "convidado".equals(senha)) {
                        int escolhaConvidado = menuInicio.menuConvidado();
                        perfilConvidado(escolhaConvidado);
                        return;
                    } else {
                        JOptionPane.showMessageDialog(null, "Login ou senha inválidos para Convidado.");
                    }
                    break;
            }
        }
    }
    

    public void perfilAdm(int escolhaAdm) {
        if (escolhaAdm == 6 || escolhaAdm == -1) {
            return;
        }
        while (admOk) {
            switch (escolhaAdm) {
                case 0:
                    int escolhaPessoa = menuInicio.menuPessoas();
                    perfilPessoa(escolhaPessoa);
                    System.out.println(escolhaPessoa);
                    break;
                case 1:
                    menuInicio.menuUsuario();
                    break;
                case 2:
                    menuInicio.menuGerenciarFornecedores();
                    break;
                case 3:
                    menuInicio.menuGerenciarConvidados();
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
            }
        }
    }

    public void perfilPessoa(int escolhaPessoa) {
        if (escolhaPessoa == 5 || escolhaPessoa == -1) {
            admOk = false;
            return;
        }

        switch (escolhaPessoa) {
            case 0: // incluir
                Pessoa pessoa = new Pessoa();
                String nome = JOptionPane.showInputDialog("Digite seu nome:");
                pessoa.setNome(nome);
                String telefone = JOptionPane.showInputDialog("Digite seu telefone:");
                pessoa.setTelefone(telefone);
                String nascimento = JOptionPane.showInputDialog("Digite o seu nascimento:");
                pessoa.setNascimento(utils.formatDate(nascimento));
                pessoasDatabase.create(pessoa);
                break;
            case 1: // alterar

                break;
            case 2: // remover

                break;
            case 3: // visualizar
                break;
            case 4: // visualizar todos
                break;
        }

    }
}
