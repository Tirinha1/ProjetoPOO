package view;

import javax.swing.JOptionPane;
import java.util.Calendar;

public class MenuInicio {

    public class GerenciamentoCasamento {

        static Calendar calendario = Calendar.getInstance(); // Inicializando o calendário com a data atual

        public static void main(String[] args) {
            menuInicial();
        }

        public static void menuInicial() {
            while (true) {
                String[] opcoes = {"Login", "Entrar sem Registrar", "Registrar", "Sair"};
                int escolha = JOptionPane.showOptionDialog(null, "Bem-vindo ao Sistema de Gerenciamento de Casamento!", "Menu Principal",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoes, opcoes[2]);
                if (escolha == opcoes.length-1 || escolha == JOptionPane.CLOSED_OPTION){
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
                    default:
                        JOptionPane.showMessageDialog(null, "Opção inválida.");
                }
            }
        }

        public static void menuLogin() {
            while (true) {
                String[] perfis = {"Administrador", "Convidado", "Voltar"};
               
                int escolhaPerfil = JOptionPane.showOptionDialog(null, "Escolha o perfil de acesso", "Seleção de Perfil",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, perfis, perfis[perfis.length-1]);

                if (escolhaPerfil == perfis.length-1 || escolhaPerfil == JOptionPane.CLOSED_OPTION) {
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
                String[] opcoes = {"Ver Presentes", "Ver Mural de Recados", "Voltar"};
                int escolha = JOptionPane.showOptionDialog(null, "Menu Não Logado", "Menu", JOptionPane.DEFAULT_OPTION,
                        JOptionPane.INFORMATION_MESSAGE, null, opcoes, opcoes[0]);

                switch (escolha) {
                    case 0:
                        JOptionPane.showMessageDialog(null, "Exibindo lista de presentes.");
                        // Função de exibição de presentes aqui
                        break;
                    case 1:
                        JOptionPane.showMessageDialog(null, "Exibindo mural de recados.");
                        // Função de exibição de mural de recados aqui
                        break;
                    case 2:
                        return; // Volta ao menu anterior
                    default:
                        JOptionPane.showMessageDialog(null, "Opção inválida.");
                }
            }
        }

        public static void menuAdministrador() {
            while (true) {
                String[] opcoes = {"Gerenciar Fornecedores", "Gerenciar Convidados", "Gerenciar Pagamentos", "Gerenciar Calendário", "Voltar"};
                int escolha = JOptionPane.showOptionDialog(null, "Menu Administrador", "Administração", JOptionPane.DEFAULT_OPTION,
                        JOptionPane.INFORMATION_MESSAGE, null, opcoes, opcoes[0]);

                switch (escolha) {
                    case 0:
                        menuGerenciarFornecedores();
                        break;
                    case 1:
                        JOptionPane.showMessageDialog(null, "Gerenciando convidados.");
                        // Função de gerenciamento de convidados
                        break;
                    case 2:
                        menuGerenciarPagamentos();
                        break;
                    case 3:
                        menuGerenciarCalendario();
                        break;
                    case 4:
                        return; // Volta ao menu anterior
                    default:
                        JOptionPane.showMessageDialog(null, "Opção inválida.");
                }
            }
        }

        public static void menuGerenciarFornecedores() {
            while (true) {
                String[] opcoes = {"Incluir Fornecedor", "Alterar Fornecedor", "Remover Fornecedor", "Voltar"};
                int escolha = JOptionPane.showOptionDialog(null, "Gerenciar Fornecedores", "Fornecedores", JOptionPane.DEFAULT_OPTION,
                        JOptionPane.INFORMATION_MESSAGE, null, opcoes, opcoes[0]);

                switch (escolha) {
                    case 0:
                        incluirFornecedor();
                        break;
                    case 1:
                        alterarFornecedor();
                        break;
                    case 2:
                        removerFornecedor();
                        break;
                    case 3:
                        return; // Volta ao menu anterior
                    default:
                        JOptionPane.showMessageDialog(null, "Opção inválida.");
                }
            }
        }

        public static void incluirFornecedor() {
            String nomeFornecedor = JOptionPane.showInputDialog("Digite o nome do fornecedor:");
            // Lógica para incluir o fornecedor aqui
            JOptionPane.showMessageDialog(null, "Fornecedor " + nomeFornecedor + " incluído com sucesso!");
        }

        public static void alterarFornecedor() {
            String nomeFornecedor = JOptionPane.showInputDialog("Digite o nome do fornecedor que deseja alterar:");
            // Lógica para alterar o fornecedor aqui
            JOptionPane.showMessageDialog(null, "Fornecedor " + nomeFornecedor + " alterado com sucesso!");
        }

        public static void removerFornecedor() {
            String nomeFornecedor = JOptionPane.showInputDialog("Digite o nome do fornecedor que deseja remover:");
            // Lógica para remover o fornecedor aqui
            JOptionPane.showMessageDialog(null, "Fornecedor " + nomeFornecedor + " removido com sucesso!");
        }

        public static void menuConvidado() {
            while (true) {
                String[] opcoes = {"Confirmar Presença", "Ver Presentes", "Ver Mural de Recados", "Voltar"};
                int escolha = JOptionPane.showOptionDialog(null, "Menu Convidado", "Convidado", JOptionPane.DEFAULT_OPTION,
                        JOptionPane.INFORMATION_MESSAGE, null, opcoes, opcoes[0]);

                switch (escolha) {
                    case 0:
                        JOptionPane.showMessageDialog(null, "Confirmando presença.");
                        // Função de confirmação de presença
                        break;
                    case 1:
                        JOptionPane.showMessageDialog(null, "Exibindo lista de presentes.");
                        // Função de exibição de presentes
                        break;
                    case 2:
                        JOptionPane.showMessageDialog(null, "Exibindo mural de recados.");
                        // Função de exibição de mural de recados
                        break;
                    case 3:
                        return; // Volta ao menu anterior
                    default:
                        JOptionPane.showMessageDialog(null, "Opção inválida.");
                }
            }
        }

        public static void menuGerenciarPagamentos() {
            while (true) {
                String[] opcoes = {"Pagamento à Vista", "Pagamento Agendado", "Verificar Pagamentos Agendados", "Voltar"};
                int escolha = JOptionPane.showOptionDialog(null, "Menu de Pagamentos", "Pagamentos", JOptionPane.DEFAULT_OPTION,
                        JOptionPane.INFORMATION_MESSAGE, null, opcoes, opcoes[0]);

                switch (escolha) {
                    case 0:
                        JOptionPane.showMessageDialog(null, "Processando pagamento à vista.");
                        // Função de pagamento à vista aqui
                        break;
                    case 1:
                        agendarPagamento();
                        break;
                    case 2:
                        verificarPagamentosAgendados();
                        break;
                    case 3:
                        return; // Volta ao menu anterior
                    default:
                        JOptionPane.showMessageDialog(null, "Opção inválida.");
                }
            }
        }

        public static void agendarPagamento() {
            String dataString = JOptionPane.showInputDialog("Digite a data para agendar o pagamento (dd/mm/yyyy):");
            // Lógica para armazenar e agendar o pagamento
            JOptionPane.showMessageDialog(null, "Pagamento agendado para " + dataString + ".");
        }

        public static void verificarPagamentosAgendados() {
            Calendar hoje = Calendar.getInstance();
            if (calendario.get(Calendar.DAY_OF_YEAR) == hoje.get(Calendar.DAY_OF_YEAR)
                    && calendario.get(Calendar.YEAR) == hoje.get(Calendar.YEAR)) {
                JOptionPane.showMessageDialog(null, "Você tem pagamentos agendados para hoje.");
                // Lógica para alterar o estado dos fornecedores
            } else {
                JOptionPane.showMessageDialog(null, "Não há pagamentos agendados para hoje.");
            }
        }

        public static void menuGerenciarCalendario() {
            while (true) {
                String dataInicial = JOptionPane.showInputDialog("Digite a data inicial do calendário (dd/mm/yyyy):");
                // Lógica para modificar manualmente o calendário
                calendario.set(2024, Calendar.SEPTEMBER, 1); // Exemplo de ajuste manual
                JOptionPane.showMessageDialog(null, "O calendário foi ajustado para " + dataInicial + ".");
                String[] opcoes = {"Voltar"};
                JOptionPane.showOptionDialog(null, "Calendário ajustado.", "Calendário",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoes, opcoes[0]);
                return; // Volta ao menu anterior
            }
        }
    }
}
