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
    //Database pessoasDatabase = new Database(pessoas);
    Database<Pessoa> pessoasDatabase = new Database<>(new Pessoa[0]);
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
                String nascimento = JOptionPane.showInputDialog("Digite o seu nascimento (dd/MM/yyyy):");
                pessoa.setNascimento(utils.formatDate(nascimento));
                pessoasDatabase.create(pessoa);
                JOptionPane.showMessageDialog(null, "Pessoa incluída com sucesso!");
                break;

            case 1: // alterar
                int idAlterar = Integer.parseInt(JOptionPane.showInputDialog("Digite o ID da pessoa que deseja alterar:"));
                Pessoa pessoaAlterar = pessoasDatabase.getById(idAlterar); // Agora retorna Pessoa
                if (pessoaAlterar != null) {
                    String novoNome = JOptionPane.showInputDialog("Digite o novo nome:", pessoaAlterar.getNome());
                    pessoaAlterar.setNome(novoNome);
                    String novoTelefone = JOptionPane.showInputDialog("Digite o novo telefone:", pessoaAlterar.getTelefone());
                    pessoaAlterar.setTelefone(novoTelefone);
                    String novoNascimento = JOptionPane.showInputDialog("Digite a nova data de nascimento (dd/MM/yyyy):", pessoaAlterar.getNascimento().toString());
                    pessoaAlterar.setNascimento(utils.formatDate(novoNascimento));
                    pessoaAlterar.setDataModificacao();
                    pessoasDatabase.update(pessoaAlterar);
                    JOptionPane.showMessageDialog(null, "Pessoa alterada com sucesso!");
                } else {
                    JOptionPane.showMessageDialog(null, "Pessoa com ID " + idAlterar + " não encontrada.");
                }
                break;

            case 2: // remover
                int idRemover = Integer.parseInt(JOptionPane.showInputDialog("Digite o ID da pessoa que deseja remover:"));
                pessoasDatabase.delete(idRemover);
                JOptionPane.showMessageDialog(null, "Pessoa removida com sucesso!");
                break;

            case 3: // visualizar
                int idVisualizar = Integer.parseInt(JOptionPane.showInputDialog("Digite o ID da pessoa que deseja visualizar:"));
                Pessoa pessoaVisualizar = pessoasDatabase.getById(idVisualizar); // Agora retorna Pessoa
                if (pessoaVisualizar != null) {
                    JOptionPane.showMessageDialog(null, pessoaVisualizar.toString());
                } else {
                    JOptionPane.showMessageDialog(null, "Pessoa com ID " + idVisualizar + " não encontrada.");
                }
                break;

            case 4: // visualizar todos
                Pessoa[] todasPessoas = pessoasDatabase.getAll(); // Agora retorna array de Pessoa
                if (todasPessoas.length > 0) {
                    String strPessoa = "";
                    for (Pessoa p : todasPessoas) {
                        strPessoa += (p.toString()+"\n");
                    }
                    JOptionPane.showMessageDialog(null, strPessoa);
                    /*StringBuilder builder = new StringBuilder();
                    for (Pessoa p : todasPessoas) {
                        builder.append(p.toString()).append("\n");
                    }
                    JOptionPane.showMessageDialog(null, builder.toString());*/
                } else {
                    JOptionPane.showMessageDialog(null, "Nenhuma pessoa cadastrada.");
                }
                break;

            default:
                JOptionPane.showMessageDialog(null, "Opção inválida.");
                break;
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
}
