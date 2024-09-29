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
 * ctrl+j e ctrl+alt+shift+j
 *
 * @author Gabriel
 */
public class Controller {

    boolean controlForm = true; //Variavel para controle de Form;
    int escolha;
    MenuInicio menuInicio = new MenuInicio();

    Pessoa pessoa;
    Usuario usuario;
    Pessoa[] pessoas = new Pessoa[0];
    Usuario[] usuarios = new Usuario[0];
    Database<Pessoa> pessoasDatabase = new Database<>(new Pessoa[0]);
    Database<Usuario> usuariosDatabase = new Database<>(new Usuario[0]);
    Utils utils = new Utils();
    Gerador gerador = new Gerador();

    public void main(String[] args) {

        while (true) {
            escolha = menuInicio.menuInicial(); // Chamando o menu inicial
            if (escolha == 3 || escolha == -1) {
                escolha = 3;
            }

            switch (escolha) {
                case 0: // Login
                    while (controlForm) {
                        int escolhaPerfil = menuInicio.menuLogin();
                        perfilLogin(escolhaPerfil);
                    }
                    controlForm = true;
                    return;
                case 1: // Entrar sem Registrar
                    menuInicio.menuNaoLogado();
                    return;
                case 2: // Registrar
                    JOptionPane.showMessageDialog(null, "Funcionalidade de Registro.");
                    // Função de registro aqui
                    return;
                case 3: // Sair
                    JOptionPane.showMessageDialog(null, "Saindo do sistema.");
                    System.exit(0); // Finaliza o programa
                    return;
            }
        }
    }

    public void perfilLogin(int escolhaPerfil) {
        if (escolhaPerfil == 2 || escolhaPerfil == -1) {
            controlForm = false;
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
                        while (controlForm) {
                            int escolhaAdm = menuInicio.menuAdministrador();
                            perfilAdm(escolhaAdm);
                        }
                        controlForm = true;
                        return;
                    } else {
                        JOptionPane.showMessageDialog(null, "Login ou senha inválidos para Administrador.");
                    }
                    return;
                case 1:
                    if ("convidado".equals(login) && "convidado".equals(senha)) {
                        int escolhaConvidado = menuInicio.menuConvidado();
                        perfilConvidado(escolhaConvidado);
                        return;
                    } else {
                        JOptionPane.showMessageDialog(null, "Login ou senha inválidos para Convidado.");
                    }
                    return;
            }
        }
    }

    public void perfilAdm(int escolhaAdm) {
        if (escolhaAdm == 6 || escolhaAdm == -1) {
            controlForm = false;
            return;
        }
        while (controlForm) {
            switch (escolhaAdm) {
                case 0:
                    while (controlForm) {
                        int escolhaPessoa = menuInicio.menuPessoas();
                        perfilPessoa(escolhaPessoa);
                    }
                    controlForm = true;
                    return;
                case 1:
                    while (controlForm) {
                        int escolhaUsuario = menuInicio.menuUsuario();
                        perfilUsuario(escolhaUsuario);
                    }
                    controlForm = true;
                    return;
                case 2:
                    while (controlForm) {
                        int escolhaUsuario = menuInicio.menuGerenciarFornecedores();
                        perfilGerenciarFornecedor(escolhaUsuario);
                    }
                    controlForm = true;
                    return;
                case 3:
                    menuInicio.menuGerenciarConvidados();
                    return;
                case 4:
                    menuInicio.menuGerenciarPagamentos();
                    return;
                case 5:
                    menuInicio.menuGerenciarCalendario();
                    return;
            }
        }
    }

    public void perfilPessoa(int escolhaPessoa) {
        if (escolhaPessoa == 5 || escolhaPessoa == -1) {
            controlForm = false;
            return;
        }

        switch (escolhaPessoa) {
            case 0: // incluir
                pessoa = new Pessoa();

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
                if (!ValidaInput.string(idAlterar) || !idAlterar.matches("^\\d+$")) { // Verifica se contem somente numero na string
                    return;
                }
                pessoa = pessoasDatabase.getById(Integer.parseInt(idAlterar));
                if (pessoa != null) {
                    // Alterar nome
                    String novoNome = JOptionPane.showInputDialog("Digite o novo nome:", pessoa.getNome());
                    if (!ValidaInput.string(novoNome)) {
                        return; // Volta ao menu se cancelar ou fechar
                    }
                    pessoa.setNome(novoNome);

                    // Alterar telefone
                    String novoTelefone = JOptionPane.showInputDialog("Digite o novo telefone:", pessoa.getTelefone());
                    if (!ValidaInput.string(novoTelefone)) {
                        return; // Volta ao menu se cancelar ou fechar
                    }
                    pessoa.setTelefone(novoTelefone);

                    // Alterar data de nascimento
                    String novoNascimento = JOptionPane.showInputDialog("Digite a nova data de nascimento (dd/MM/yyyy):", pessoa.getNascimento().toString());
                    if (!ValidaInput.string(novoNascimento)) {
                        return; // Volta ao menu se cancelar ou fechar
                    }
                    pessoa.setNascimento(utils.formatDate(novoNascimento));

                    pessoa.setDataModificacao();
                    pessoasDatabase.update(pessoa);
                    JOptionPane.showMessageDialog(null, "Pessoa alterada com sucesso!");
                } else {
                    JOptionPane.showMessageDialog(null, "Pessoa com ID " + idAlterar + " não encontrada.");
                }
                return;

            case 2: // remover
                // Confirmação de remoção
                String idRemover = JOptionPane.showInputDialog("Digite o ID da pessoa que deseja remover:");
                if (!ValidaInput.string(idRemover) || !idRemover.matches("^\\d+$")) {
                    return;
                }
                pessoa = pessoasDatabase.getById(Integer.parseInt(idRemover));
                usuario = usuariosDatabase.getById(Integer.parseInt(idRemover));
                if (usuario != null){
                    JOptionPane.showMessageDialog(null, "Existe usuário vinculado a este ID. Por favor delete o usuário");
                    return;
                }else if (pessoa != null) {
                    int confirmacao = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja remover a pessoa com ID " + idRemover + "?", "Confirmação", JOptionPane.YES_NO_OPTION);
                    if (confirmacao == JOptionPane.YES_OPTION) {
                        pessoasDatabase.delete(Integer.parseInt(idRemover));
                        JOptionPane.showMessageDialog(null, "Pessoa removida com sucesso!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Remoção cancelada.");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Pessoa com ID " + idRemover + " não encontrada.");
                }
                return;

            case 3: // visualizar
                // Visualizar pessoa pelo ID
                String idVisualizar = JOptionPane.showInputDialog("Digite o ID da pessoa que deseja visualizar:");
                if (!ValidaInput.string(idVisualizar) || !idVisualizar.matches("^\\d+$")) {
                    return;
                }
                pessoa = pessoasDatabase.getById(Integer.parseInt(idVisualizar));
                if (pessoa != null) {
                    JOptionPane.showMessageDialog(null, pessoa.toString());
                } else {
                    JOptionPane.showMessageDialog(null, "Pessoa com ID " + idVisualizar + " não encontrada.");
                }
                return;

            case 4: // visualizar todos
                Pessoa[] todasPessoas;
                todasPessoas = pessoasDatabase.getAll();
                if (todasPessoas.length > 0) {
                    String strPessoa = "";
                    for (Pessoa p : todasPessoas) {
                        strPessoa += p.toString() + "\n";
                    }
                    JOptionPane.showMessageDialog(null, strPessoa);
                } else {
                    JOptionPane.showMessageDialog(null, "Nenhuma pessoa cadastrada.");
                }
        }
    }

    public void perfilUsuario(int escolhaUsuario) {
        if (escolhaUsuario == 5 || escolhaUsuario == -1) {
            controlForm = false;
            return;
        }
        //System.out.println(pessoa + " | " + usuario);
        switch (escolhaUsuario) {

            case 0: // incluir
                usuario = new Usuario();
                String pessoaId = JOptionPane.showInputDialog("Digite o ID da pessoa para criar usuário:");
                if (!ValidaInput.string(pessoaId) || !pessoaId.matches("^\\d+$")) { // Verifica se contem somente numero na string
                    return;
                }
                pessoa = pessoasDatabase.getById(Integer.parseInt(pessoaId));
                if (pessoa == null) {
                    JOptionPane.showMessageDialog(null, "Pessoa com ID " + pessoaId + " não encontrada.");
                    return;
                }
                if (usuariosDatabase.getById(Integer.parseInt(pessoaId)) != null) {
                    JOptionPane.showMessageDialog(null, "Pessoa com ID " + pessoaId + " já tem usuário vinculado.");
                    return;
                }

                usuario.setPessoa(pessoa);
                String login = JOptionPane.showInputDialog("Digite o login do usuário:");
                if (!ValidaInput.string(login)) {
                    return; // Volta ao menu se cancelar ou fechar
                }
                usuario.setLogin(login);

                String senha = JOptionPane.showInputDialog("Digite a senha do usuário:");
                if (!ValidaInput.string(senha)) {
                    return; // Volta ao menu se cancelar ou fechar
                }
                usuario.setSenha(senha);

                String tipo = JOptionPane.showInputDialog("Digite o tipo do usuário (Admin/Convidado):", "Convidado");
                if (!ValidaInput.string(tipo)) {
                    return; // Volta ao menu se cancelar ou fechar
                }
                usuario.setTipo(tipo);
                usuario.setDataCriacao();

                // Criar usuário no banco de dados
                usuariosDatabase.create(usuario);

                JOptionPane.showMessageDialog(null, "Usuário incluído com sucesso!");
                return;

            case 1: // alterar
                String idAlterar = JOptionPane.showInputDialog("Digite o ID do usuário:");
                if (!ValidaInput.string(idAlterar) || !idAlterar.matches("^\\d+$")) { // Verifica se contem somente numero na string
                    return;
                }
                usuario = usuariosDatabase.getById(Integer.parseInt(idAlterar));
                if (usuario != null) {
                    String novoLogin = JOptionPane.showInputDialog("Digite o novo login:", usuario.getLogin());
                    if (!ValidaInput.string(novoLogin)) {
                        return;
                    }
                    usuario.setLogin(novoLogin);

                    String novaSenha = JOptionPane.showInputDialog("Digite a nova senha:", usuario.getSenha());
                    if (!ValidaInput.string(novaSenha)) {
                        return;
                    }
                    usuario.setSenha(novaSenha);

                    String novoTipo = JOptionPane.showInputDialog("Digite o novo tipo de usuário (Admin/Convidado):", usuario.getTipo());
                    if (!ValidaInput.string(novoTipo)) {
                        return;
                    }
                    usuario.setTipo(novoTipo);
                    usuario.setDataModificacao();

                    //Atualizar registro no banco de dados
                    usuariosDatabase.update(usuario);
                    JOptionPane.showMessageDialog(null, "Usuário alterado com sucesso!");
                } else {
                    JOptionPane.showMessageDialog(null, "Usuário com ID " + idAlterar + " não encontrado.");
                }
                return;

            case 2: // remover
                String idRemover = JOptionPane.showInputDialog("Digite o ID do usuário:");
                if (!ValidaInput.string(idRemover) || !idRemover.matches("^\\d+$")) { // Verifica se contem somente numero na string
                    return;
                }
                usuario = usuariosDatabase.getById(Integer.parseInt(idRemover));
                if (usuario != null) {
                    int confirmacao = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja remover o usuário com ID " + idRemover + "?", "Confirmação", JOptionPane.YES_NO_OPTION);
                    if (confirmacao == JOptionPane.YES_OPTION) {
                        usuariosDatabase.delete(Integer.parseInt(idRemover));
                        JOptionPane.showMessageDialog(null, "Usuário removido com sucesso!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Remoção cancelada.");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Usuário com ID " + idRemover + " não encontrada.");
                }
                return;

            case 3: // visualizar
                // Visualizar pessoa pelo ID
                String idVisualizar = JOptionPane.showInputDialog("Digite o ID do usuário que deseja visualizar:");
                if (!ValidaInput.string(idVisualizar) || !idVisualizar.matches("^\\d+$")) {
                    return;
                }
                usuario = usuariosDatabase.getById(Integer.parseInt(idVisualizar));
                if (usuario != null) {
                    JOptionPane.showMessageDialog(null, usuario.toString());
                } else {
                    JOptionPane.showMessageDialog(null, "Usuário com ID " + idVisualizar + " não encontrado.");
                }
                return;

            case 4: // visualizar todos
                Usuario[] todosUsuarios; 
                todosUsuarios = usuariosDatabase.getAll();
                if (todosUsuarios.length > 0) {
                    String strUsuario = "";
                    for (Usuario u : todosUsuarios) {
                        strUsuario += u.toString() + "\n";
                    }
                    JOptionPane.showMessageDialog(null, strUsuario);
                } else {
                    JOptionPane.showMessageDialog(null, "Nenhum usuário cadastrado.");
                }
        }
    }

    public void perfilGerenciarFornecedor(int escolhaFornecedor) {

        switch (escolha) {
            case 0: //incluir
                String nomeFornecedor = JOptionPane.showInputDialog("Digite o nome do fornecedor:");
                // Lógica para incluir o fornecedor aqui
                JOptionPane.showMessageDialog(null, "Fornecedor " + nomeFornecedor + " incluído com sucesso!");
                return;
            case 1: //alterar
                String idAlterar = JOptionPane.showInputDialog("Digite o ID do fornecedor que deseja alterar:");
                // Lógica para buscar o fornecedor pelo ID7
                // Suponha que exista uma função buscarFornecedorPorId(id) que retorna o fornecedor
                /*String fornecedor = buscarFornecedorPorId(idFornecedor); // Exemplo de busca
                if (fornecedor != null) {
                // Lógica para alterar o fornecedor
                JOptionPane.showMessageDialog(null, "Fornecedor com ID " + idFornecedor + " alterado com sucesso!");
                } else {
                JOptionPane.showMessageDialog(null, "Fornecedor com ID " + idFornecedor + " não encontrado.");
                }*/

                return;
            case 2: //remover
                String idRemover = JOptionPane.showInputDialog("Digite o ID do fornecedor que deseja remover:");
                // Lógica para buscar o fornecedor pelo ID e removê-lo
                /*String fornecedor = buscarFornecedorPorId(idFornecedor); // Exemplo de busca
                if (fornecedor != null) {
                // Lógica para remover o fornecedor
                JOptionPane.showMessageDialog(null, "Fornecedor com ID " + idFornecedor + " removido com sucesso!");
                } else {
                JOptionPane.showMessageDialog(null, "Fornecedor com ID " + idFornecedor + " não encontrado.");
                }*/
                return;
            case 3: //visualizar fornecedores
                return; // Volta ao menu anterior
            default:
                JOptionPane.showMessageDialog(null, "Opção inválida.");
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
                    return;
                case 1:
                    menuInicio.menuRecadosConvidado();
                    return;
                case 2:
                    menuInicio.confirmarPresenca();
                    return;
            }
        }
    }
}
