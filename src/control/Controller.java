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
import model.Fornecedor;
import model.Convidado;
import model.Familia;
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
    Fornecedor fornecedor;
    Convidado convidado;
    Familia familia;
    Pessoa[] todasPessoas;
    Usuario[] todosUsuarios;
    Fornecedor[] todosFornecedores;
    Database<Pessoa> pessoasDatabase = new Database<>(new Pessoa[0]);
    Database<Usuario> usuariosDatabase = new Database<>(new Usuario[0]);
    Database<Fornecedor> fornecedoresDatabase = new Database<>(new Fornecedor[0]);
    Database<Convidado> convidadosDatabase = new Database<>(new Convidado[0]);
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
                        int escolhaFornecedor = menuInicio.menuGerenciarFornecedores();
                        perfilGerenciarFornecedor(escolhaFornecedor);
                    }
                    controlForm = true;
                    return;
                case 3:
                    while (controlForm) {
                        int escolhaConvidado = menuInicio.menuGerenciarConvidados();
                        perfilGerenciarConvidado(escolhaConvidado);

                    }
                    controlForm = true;
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
                fornecedor = fornecedoresDatabase.getById(Integer.parseInt(idRemover));
                if (usuario != null) {
                    JOptionPane.showMessageDialog(null, "Existe usuário vinculado a este ID. Por favor delete o usuário");
                    return;
                } else if (fornecedor != null) {
                    JOptionPane.showMessageDialog(null, "Existe fornecedor vinculado a este ID. Por favor delete o fornecedor");
                    return;
                } else if (pessoa != null) {
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
        if (escolhaFornecedor == 5 || escolhaFornecedor == -1) {
            controlForm = false;
            return;
        }
        switch (escolhaFornecedor) {

            case 0: //incluir

                fornecedor = new Fornecedor();
                String fornecedorId = JOptionPane.showInputDialog("Digite o ID da pessoa para criar fornecedor:");
                if (!ValidaInput.string(fornecedorId) || !fornecedorId.matches("^\\d+$")) { // Verifica se contem somente numero na string
                    return;
                }
                pessoa = pessoasDatabase.getById(Integer.parseInt(fornecedorId));
                if (pessoa == null) {
                    JOptionPane.showMessageDialog(null, "Pessoa com ID " + fornecedorId + " não encontrada.");
                    return;
                }
                if (fornecedoresDatabase.getById(Integer.parseInt(fornecedorId)) != null) {
                    JOptionPane.showMessageDialog(null, "Pessoa com ID " + fornecedorId + " já tem fornecedor vinculado.");
                    return;
                }

                fornecedor.setPessoa(pessoa);

                String razaoSocial = JOptionPane.showInputDialog("Digite a Razão Social ou Nome Fantasia do fornecedor:");
                if (!ValidaInput.string(razaoSocial)) {
                    return; // Volta ao menu se cancelar ou fechar
                }
                fornecedor.setRazaoSocial(razaoSocial);

                String cnpj = JOptionPane.showInputDialog("Digite o CNPJ/CPF do fornecedor (Somente números | 0 - se nao tem.):");
                if (!ValidaInput.string(cnpj) || !cnpj.matches("^\\d+$")) {
                    return; // Volta ao menu se cancelar ou fechar
                }
                fornecedor.setCpfCnpj(cnpj);

                String telefone = JOptionPane.showInputDialog("Digite o telefone empresarial do fornecedor:");
                if (!ValidaInput.string(telefone)) {
                    return; // Volta ao menu se cancelar ou fechar
                }
                fornecedor.setTelefone(telefone);

                // Criar usuário no banco de dados
                fornecedoresDatabase.create(fornecedor);

                JOptionPane.showMessageDialog(null, "Fornecedros incluído com sucesso!");
                return;

            case 1: //alterar

                String idAlterar = JOptionPane.showInputDialog("Digite o ID do fornecedor:");
                if (!ValidaInput.string(idAlterar) || !idAlterar.matches("^\\d+$")) { // Verifica se contem somente numero na string
                    return;
                }
                fornecedor = fornecedoresDatabase.getById(Integer.parseInt(idAlterar));
                if (fornecedor != null) {
                    String novaRazaoSocial = JOptionPane.showInputDialog("Digite a Razão Social ou Nome Fantasia do fornecedor:", fornecedor.getRazaoSocial());
                    if (!ValidaInput.string(novaRazaoSocial)) {
                        return; // Volta ao menu se cancelar ou fechar
                    }
                    fornecedor.setRazaoSocial(novaRazaoSocial);

                    String novoCpfCnpj = JOptionPane.showInputDialog("Digite o CNPJ/CPF do fornecedor (Somente números | 0 - se nao tem.):", fornecedor.getcpfCnpj());
                    if (!ValidaInput.string(novoCpfCnpj) || !novoCpfCnpj.matches("^\\d+$")) {
                        return; // Volta ao menu se cancelar ou fechar
                    }
                    fornecedor.setCpfCnpj(novoCpfCnpj);

                    String novoTelefone = JOptionPane.showInputDialog("Digite o telefone empresarial do fornecedor:", fornecedor.getTelefone());
                    if (!ValidaInput.string(novoTelefone)) {
                        return; // Volta ao menu se cancelar ou fechar
                    }
                    fornecedor.setTelefone(novoTelefone);

                    fornecedor.setDataModificacao();

                    //Atualizar registro no banco de dados
                    usuariosDatabase.update(usuario);
                    JOptionPane.showMessageDialog(null, "Fornecedor alterado com sucesso!");
                } else {
                    JOptionPane.showMessageDialog(null, "Fornecedor com ID " + idAlterar + " não encontrado.");
                }
                return;

            case 2: // remover
                String idRemover = JOptionPane.showInputDialog("Digite o ID do fornecedor:");
                if (!ValidaInput.string(idRemover) || !idRemover.matches("^\\d+$")) { // Verifica se contem somente numero na string
                    return;
                }
                fornecedor = fornecedoresDatabase.getById(Integer.parseInt(idRemover));
                if (fornecedor != null) {
                    int confirmacao = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja remover o usuário com ID " + idRemover + "?", "Confirmação", JOptionPane.YES_NO_OPTION);
                    if (confirmacao == JOptionPane.YES_OPTION) {
                        fornecedoresDatabase.delete(Integer.parseInt(idRemover));
                        JOptionPane.showMessageDialog(null, "Fornecedor removido com sucesso!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Remoção cancelada.");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Fornecedor com ID " + idRemover + " não encontrada.");
                }
                return;

            case 3: // visualizar
                // Visualizar pessoa pelo ID
                String idVisualizar = JOptionPane.showInputDialog("Digite o ID do fornecedor que deseja visualizar:");
                if (!ValidaInput.string(idVisualizar) || !idVisualizar.matches("^\\d+$")) {
                    return;
                }
                fornecedor = fornecedoresDatabase.getById(Integer.parseInt(idVisualizar));
                if (fornecedor != null) {
                    JOptionPane.showMessageDialog(null, fornecedor.toString());
                } else {
                    JOptionPane.showMessageDialog(null, "Usuário com ID " + idVisualizar + " não encontrado.");
                }
                return;

            case 4: // visualizar todos 
                todosFornecedores = fornecedoresDatabase.getAll();
                if (todosFornecedores.length > 0) {
                    String strFornecedores = "";
                    for (Fornecedor f : todosFornecedores) {
                        strFornecedores += f.toString() + "\n";
                    }
                    JOptionPane.showMessageDialog(null, strFornecedores);
                } else {
                    JOptionPane.showMessageDialog(null, "Nenhum usuário cadastrado.");
                }
        }
    }

    public void perfilGerenciarConvidado(int escolhaConvite) {
        if (escolhaConvite == 6 || escolhaConvite == -1) {
            controlForm = false;
            return;
        }

        switch (escolhaConvite) {
            case 0://incluir convite individual

                familia = new Familia();
                convidado = new Convidado();
                String convidadoId = JOptionPane.showInputDialog("Digite o ID da pessoa para criar convidado:");
                if (!ValidaInput.string(convidadoId) || !convidadoId.matches("^\\d+$")) { // Verifica se contem somente numero na string
                    return;
                }
                pessoa = pessoasDatabase.getById(Integer.parseInt(convidadoId));
                if (pessoa == null) {
                    JOptionPane.showMessageDialog(null, "Pessoa com ID " + convidadoId + " não encontrada.");
                    return;
                }
                if (convidadosDatabase.getById(Integer.parseInt(convidadoId)) != null) {
                    JOptionPane.showMessageDialog(null, "Pessoa com ID " + convidadoId + " já tem convite vinculado.");
                    return;
                }
                convidado.setPessoa(pessoa);
                familia.setNomeFamilia("individual");
                String acessoI = "ci" + familia.getDataCriacao();
                String acessoFormatadoI = acessoI.substring(acessoI.length() - 6);
                familia.setAcesso(acessoFormatadoI); //definir como os convidados vao acessar 
                convidado.setFamilia(familia);
                String parentesco = JOptionPane.showInputDialog("Digite o parentesco do convidado (Pai, Mãe, Avô, etc...):");
                if (!ValidaInput.string(parentesco)) {
                    return; // Volta ao menu se cancelar ou fechar
                }
                convidado.setParentesco(parentesco);

                // Criar usuário no banco de dados
                convidadosDatabase.create(convidado);

                JOptionPane.showMessageDialog(null, "Convidado incluído com sucesso!");
                return;

            case 1: //incluir convite familia
                familia = new Familia();
                String nomeFamilia = JOptionPane.showInputDialog("Digite o nome da família:");
                if (!ValidaInput.string(nomeFamilia)) {
                    return; // Volta ao menu se cancelar ou fechar
                }
                familia.setNomeFamilia(nomeFamilia);

                // Vincula várias pessoas à família até que o usuário cancele
                while (true) {
                    String pessoaId = JOptionPane.showInputDialog("Digite o ID da pessoa para vincular à família (ou clique Cancelar para terminar):");
                    if (!ValidaInput.string(pessoaId) || !pessoaId.matches("^\\d+$")) {
                        break; // Sai do loop se o usuário cancelar ou o ID não for válido
                    }

                    pessoa = pessoasDatabase.getById(Integer.parseInt(pessoaId));
                    if (pessoa == null) {
                        JOptionPane.showMessageDialog(null, "Pessoa com ID " + pessoaId + " não encontrada.");
                        continue; // Pede outro ID se a pessoa não for encontrada
                    }

                    if (convidadosDatabase.getById(Integer.parseInt(pessoaId)) != null) {
                        JOptionPane.showMessageDialog(null, "Pessoa com ID " + pessoaId + " já tem convite vinculado.");
                        continue; // Pede outro ID se a pessoa já for um convidado
                    }
                    // Cria um novo convidado e associa à família
                    convidado = new Convidado();
                    convidado.setPessoa(pessoa);
                    convidado.setFamilia(familia);
                    parentesco = "familia" + familia.getNomeFamilia();
                    convidado.setParentesco(parentesco);
                    String acessoF = "cf" + familia.getDataCriacao();
                    String acessoFormatadoF = acessoF.substring(acessoF.length() - 6);
                    familia.setAcesso(acessoFormatadoF);
                    familia.setAcesso("conviteFamilia"); //definir metodo de acesso da familia
                    // Salva o convidado no banco de dados
                    convidadosDatabase.create(convidado);
                }
                JOptionPane.showMessageDialog(null, "Convidados familiares incluídos com sucesso!");
                return;

            case 2: //remover por ID
                String idRemover = JOptionPane.showInputDialog("Digite o ID do convidado:");
                if (!ValidaInput.string(idRemover) || !idRemover.matches("^\\d+$")) { // Verifica se contem somente numero na string
                    return;
                }
                convidado = convidadosDatabase.getById(Integer.parseInt(idRemover));
                if (convidado != null) {
                    int confirmacao = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja remover o convidado com ID " + idRemover + "?", "Confirmação", JOptionPane.YES_NO_OPTION);
                    if (confirmacao == JOptionPane.YES_OPTION) {
                        convidadosDatabase.delete(Integer.parseInt(idRemover));
                        JOptionPane.showMessageDialog(null, "Convidado removido com sucesso!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Remoção cancelada.");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Convidado com ID " + idRemover + " não encontrada.");
                }
                return;
            case 4:
                // Visualizar concidado pelo ID
                String idVisualizar = JOptionPane.showInputDialog("Digite o ID do Convidado que deseja visualizar:");
                if (!ValidaInput.string(idVisualizar) || !idVisualizar.matches("^\\d+$")) {
                    return;
                }
                convidado = convidadosDatabase.getById(Integer.parseInt(idVisualizar));
                if (convidado != null) {
                    JOptionPane.showMessageDialog(null, convidado.toString());
                } else {
                    JOptionPane.showMessageDialog(null, "Usuário com ID " + idVisualizar + " não encontrado.");
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
