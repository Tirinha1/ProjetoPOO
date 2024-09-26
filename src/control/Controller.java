/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import static control.ValidaInput.*;
import java.time.LocalDate;
import javax.swing.JOptionPane;
import model.Pessoa;
import model.Usuario;
import model.dao.Database;
import model.dao.Utils;
import view.MenuInicio;

/**
 *
 * @author Gabriel
 */
public class Controller {

    boolean admOk = true;
    boolean ok = true;
    int escolha;
    MenuInicio menuInicio = new MenuInicio();
    Pessoa[] pessoas = new Pessoa[0];
    Usuario[] usuarios = new Usuario[0];
    //Database pessoasDatabase = new Database(pessoas);
    Database<Pessoa> pessoasDatabase = new Database<>(new Pessoa[0]);
    Database<Usuario> usuariosDatabase = new Database<>(new Usuario[0]);
    Utils utils = new Utils();
    Gerador gerador = new Gerador();

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
        String loginSenha;
        if (escolhaPerfil == 0) {
            loginSenha = "admin";
        } else {
            loginSenha = "convidado";
        }
        String login = JOptionPane.showInputDialog("Digite seu login:", loginSenha);
        if (login == null) {
            return;
        }
        String senha = JOptionPane.showInputDialog("Digite sua senha:", loginSenha);
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
                    int escolhaUsuario = menuInicio.menuUsuario();
                    perfilUsuario(escolhaUsuario);
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

                // Validação de nome
                String nome = JOptionPane.showInputDialog("Digite seu nome:", gerador.gerarNome());
                if (!ValidaInput.string(nome)) {
                    return; // Volta ao menu se cancelar ou fechar
                }
                pessoa.setNome(nome);

                // Validação de telefone
                String telefone = JOptionPane.showInputDialog("Digite seu telefone:", gerador.gerarTelefone());
                if (!ValidaInput.string(telefone)) {
                    return; // Volta ao menu se cancelar ou fechar
                }
                pessoa.setTelefone(telefone);

                // Validação de nascimento
                String nascimento = JOptionPane.showInputDialog("Digite o seu nascimento (dd/MM/yyyy):", gerador.gerarDataNascimento());
                if (!ValidaInput.string(nascimento)) {
                    return; // Volta ao menu se cancelar ou fechar
                }
                pessoa.setNascimento(utils.formatDate(nascimento));

                pessoasDatabase.create(pessoa);
                JOptionPane.showMessageDialog(null, "Pessoa incluída com sucesso!");
                return;

            case 1: // alterar
                // ID da pessoa a ser alterada
                String idAlterar = JOptionPane.showInputDialog("Digite o ID da pessoa que deseja alterar:");
                if ( !ValidaInput.string(idAlterar) || !idAlterar.matches("^\\d+$") ) { // Verifica se contem somente numero na string
                    return;
                }
                Pessoa pessoaAlterar = pessoasDatabase.getById(Integer.parseInt(idAlterar));
                if (pessoaAlterar != null) {
                    // Alterar nome
                    String novoNome = JOptionPane.showInputDialog("Digite o novo nome:", pessoaAlterar.getNome());
                    if (!ValidaInput.string(novoNome)) {
                        return; // Volta ao menu se cancelar ou fechar
                    }
                    pessoaAlterar.setNome(novoNome);

                    // Alterar telefone
                    String novoTelefone = JOptionPane.showInputDialog("Digite o novo telefone:", pessoaAlterar.getTelefone());
                    if (!ValidaInput.string(novoTelefone)) {
                        return; // Volta ao menu se cancelar ou fechar
                    }
                    pessoaAlterar.setTelefone(novoTelefone);

                    // Alterar data de nascimento
                    String novoNascimento = JOptionPane.showInputDialog("Digite a nova data de nascimento (dd/MM/yyyy):", pessoaAlterar.getNascimento().toString());
                    if (!ValidaInput.string(novoNascimento)) {
                        return; // Volta ao menu se cancelar ou fechar
                    }
                    pessoaAlterar.setNascimento(utils.formatDate(novoNascimento));

                    pessoaAlterar.setDataModificacao();
                    pessoasDatabase.update(pessoaAlterar);
                    JOptionPane.showMessageDialog(null, "Pessoa alterada com sucesso!");
                } else {
                    JOptionPane.showMessageDialog(null, "Pessoa com ID " + idAlterar + " não encontrada.");
                }
                return;

            case 2: // remover
                // Confirmação de remoção
                int idRemover = Integer.parseInt(JOptionPane.showInputDialog("Digite o ID da pessoa que deseja remover:"));
                int confirmacao = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja remover a pessoa com ID " + idRemover + "?", "Confirmação", JOptionPane.YES_NO_OPTION);
                if (confirmacao == JOptionPane.YES_OPTION) {
                    pessoasDatabase.delete(idRemover);
                    JOptionPane.showMessageDialog(null, "Pessoa removida com sucesso!");
                } else {
                    JOptionPane.showMessageDialog(null, "Remoção cancelada.");
                }
                return;

            case 3: // visualizar
                // Visualizar pessoa pelo ID
                int idVisualizar = Integer.parseInt(JOptionPane.showInputDialog("Digite o ID da pessoa que deseja visualizar:"));
                Pessoa pessoaVisualizar = pessoasDatabase.getById(idVisualizar);
                if (pessoaVisualizar != null) {
                    JOptionPane.showMessageDialog(null, pessoaVisualizar.toString());
                } else {
                    JOptionPane.showMessageDialog(null, "Pessoa com ID " + idVisualizar + " não encontrada.");
                }
                return;

            case 4: // visualizar todos
                Pessoa[] todasPessoas = pessoasDatabase.getAll();
                if (todasPessoas.length > 0) {
                    StringBuilder strPessoa = new StringBuilder();
                    for (Pessoa p : todasPessoas) {
                        strPessoa.append(p.toString()).append("\n");
                    }
                    JOptionPane.showMessageDialog(null, strPessoa.toString());
                } else {
                    JOptionPane.showMessageDialog(null, "Nenhuma pessoa cadastrada.");
                }
                return;

            default:
                JOptionPane.showMessageDialog(null, "Opção inválida.");
                break;
        }
    }

    public void perfilUsuario(int escolhaUsuario) {
        if (escolhaUsuario == 5 || escolhaUsuario == -1) {
            admOk = false;
            return;
        }

        switch (escolhaUsuario) {
            case 0: // incluir
                Usuario usuario = new Usuario();

                // Selecionar pessoa associada ao usuário
                int pessoaId = Integer.parseInt(JOptionPane.showInputDialog("Digite o ID da pessoa associada ao usuário:"));
                Pessoa pessoaAssociada = pessoasDatabase.getById(pessoaId);
                if (pessoaAssociada == null) {
                    JOptionPane.showMessageDialog(null, "Pessoa com ID " + pessoaId + " não encontrada.");
                    return;
                }
                usuario.setPessoa(pessoaAssociada);

                String login = JOptionPane.showInputDialog("Digite o login do usuário:");
                usuario.setLogin(login);

                String senha = JOptionPane.showInputDialog("Digite a senha do usuário:");
                usuario.setSenha(senha);

                String tipo = JOptionPane.showInputDialog("Digite o tipo do usuário (Admin/Convidado):", "Convidado");
                usuario.setTipo(tipo);

                usuario.setDataCriacao();
                // Criar usuário no banco de dados
                usuariosDatabase.create(usuario);  // supondo que haja um Database<Usuario> usuariosDatabase similar ao de Pessoa
                JOptionPane.showMessageDialog(null, "Usuário incluído com sucesso!");
                break;

            case 1: // alterar
                int idAlterar = Integer.parseInt(JOptionPane.showInputDialog("Digite o ID do usuário que deseja alterar:"));
                Usuario usuarioAlterar = usuariosDatabase.getById(idAlterar);
                if (usuarioAlterar != null) {
                    String novoLogin = JOptionPane.showInputDialog("Digite o novo login:", usuarioAlterar.getLogin());
                    usuarioAlterar.setLogin(novoLogin);

                    String novaSenha = JOptionPane.showInputDialog("Digite a nova senha:", usuarioAlterar.getSenha());
                    usuarioAlterar.setSenha(novaSenha);

                    String novoTipo = JOptionPane.showInputDialog("Digite o novo tipo de usuário (Admin/Convidado):", usuarioAlterar.getTipo());
                    usuarioAlterar.setTipo(novoTipo);

                    usuarioAlterar.setDataModificacao();
                    usuariosDatabase.update(usuarioAlterar);
                    JOptionPane.showMessageDialog(null, "Usuário alterado com sucesso!");
                } else {
                    JOptionPane.showMessageDialog(null, "Usuário com ID " + idAlterar + " não encontrado.");
                }
                break;

            case 2: // remover
                int idRemover = Integer.parseInt(JOptionPane.showInputDialog("Digite o ID do usuário que deseja remover:"));
                usuariosDatabase.delete(idRemover);
                JOptionPane.showMessageDialog(null, "Usuário removido com sucesso!");
                break;

            case 3: // visualizar
                int idVisualizar = Integer.parseInt(JOptionPane.showInputDialog("Digite o ID do usuário que deseja visualizar:"));
                Usuario usuarioVisualizar = usuariosDatabase.getById(idVisualizar);
                if (usuarioVisualizar != null) {
                    JOptionPane.showMessageDialog(null, usuarioVisualizar.toString());
                } else {
                    JOptionPane.showMessageDialog(null, "Usuário com ID " + idVisualizar + " não encontrado.");
                }
                break;

            case 4: // visualizar todos
                Usuario[] todosUsuarios = usuariosDatabase.getAll();
                if (todosUsuarios.length > 0) {
                    StringBuilder builder = new StringBuilder();
                    for (Usuario u : todosUsuarios) {
                        builder.append(u.toString()).append("\n");
                    }
                    JOptionPane.showMessageDialog(null, builder.toString());
                } else {
                    JOptionPane.showMessageDialog(null, "Nenhum usuário cadastrado.");
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
