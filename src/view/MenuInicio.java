package view;

import javax.swing.JOptionPane;
import java.util.Calendar;

public class MenuInicio {

    static Calendar calendario = Calendar.getInstance(); // Inicializando o calendário com a data atual

    public int menuInicial() {
        String[] opcoes = {"Login", "Entrar sem Registrar", "Registrar", "Sair"};
        int escolha = JOptionPane.showOptionDialog(null, "Bem-vindo ao Sistema de Gerenciamento de Casamento!", "Menu Principal",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoes, opcoes[2]);
        return escolha;
    }

// Menu de Presentes para Não Logado
    public void menuPresentesNaoLogado() {
        String[] opcoes = {"Dar Presente", "Ver Presentes", "Voltar"};
        int escolha = JOptionPane.showOptionDialog(null, "Menu Presentes", "Presentes", JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE, null, opcoes, opcoes[0]);

        switch (escolha) {
            case 0:
                JOptionPane.showMessageDialog(null, "Dando presente.");
                // Função de dar presente aqui
                break;
            case 1:
                JOptionPane.showMessageDialog(null, "Exibindo lista de presentes.");
                // Função de exibição de presentes aqui
                break;
            case 2:
                return; // Volta ao menu anterior
            default:
                JOptionPane.showMessageDialog(null, "Opção inválida.");
        }
    }

// Menu de Recados para Não Logado
    public void menuRecadosNaoLogado() {
        String[] opcoes = {"Ver Recados", "Deixar Recado", "Voltar"};
        int escolha = JOptionPane.showOptionDialog(null, "Menu Recados", "Recados", JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE, null, opcoes, opcoes[0]);

        switch (escolha) {
            case 0:
                JOptionPane.showMessageDialog(null, "Exibindo mural de recados.");
                // Função de exibição de recados
                break;
            case 1:
                deixarRecadoNaoLogado();
                break;
            case 2:
                return; // Volta ao menu anterior
            default:
                JOptionPane.showMessageDialog(null, "Opção inválida.");
        }
    }

// Deixar Recado no Menu Não Logado
    public void deixarRecadoNaoLogado() {
        String nome = JOptionPane.showInputDialog("Digite seu nome:");
        String recado = JOptionPane.showInputDialog(null, "Digite seu recado (até 4000 caracteres):",
                "Deixar Recado", JOptionPane.PLAIN_MESSAGE);

        if (recado.length() > 4000) {
            recado = recado.substring(0, 4000); // Trunca o recado para 4000 caracteres
        }

        JOptionPane.showMessageDialog(null, "Recado deixado com sucesso!\n" + recado);
        // Lógica para armazenar o recado
    }

    public void menuAdministrador() {
        while (true) {
            String[] opcoes = {"Gerenciar Fornecedores", "Gerenciar Convidados", "Gerenciar Pagamentos", "Gerenciar Calendário", "Voltar"};
            int escolha = JOptionPane.showOptionDialog(null, "Menu Administrador", "Administração", JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE, null, opcoes, opcoes[0]);

            switch (escolha) {
                case 0:
                    menuGerenciarFornecedores();
                    break;
                case 1:
                    menuGerenciarConvidados();
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

    public void menuGerenciarFornecedores() {
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

    public void incluirFornecedor() {
        String nomeFornecedor = JOptionPane.showInputDialog("Digite o nome do fornecedor:");
        // Lógica para incluir o fornecedor aqui
        JOptionPane.showMessageDialog(null, "Fornecedor " + nomeFornecedor + " incluído com sucesso!");
    }

    public void alterarFornecedor() {
        String idFornecedor = JOptionPane.showInputDialog("Digite o ID do fornecedor que deseja alterar:");
        // Lógica para buscar o fornecedor pelo ID7
        // Suponha que exista uma função buscarFornecedorPorId(id) que retorna o fornecedor
        /*String fornecedor = buscarFornecedorPorId(idFornecedor); // Exemplo de busca
            if (fornecedor != null) {
                // Lógica para alterar o fornecedor
                JOptionPane.showMessageDialog(null, "Fornecedor com ID " + idFornecedor + " alterado com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Fornecedor com ID " + idFornecedor + " não encontrado.");
            }*/
    }

    public void removerFornecedor() {
        String idFornecedor = JOptionPane.showInputDialog("Digite o ID do fornecedor que deseja remover:");
        // Lógica para buscar o fornecedor pelo ID e removê-lo
        /*String fornecedor = buscarFornecedorPorId(idFornecedor); // Exemplo de busca
            if (fornecedor != null) {
                // Lógica para remover o fornecedor
                JOptionPane.showMessageDialog(null, "Fornecedor com ID " + idFornecedor + " removido com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Fornecedor com ID " + idFornecedor + " não encontrado.");
            }*/
    }

    public void menuGerenciarConvidados() {
        while (true) {
            String[] opcoes = {"Incluir Convidado", "Alterar Convidado", "Remover Convidado", "Voltar"};
            int escolha = JOptionPane.showOptionDialog(null, "Gerenciar Convidados", "Convidados", JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE, null, opcoes, opcoes[0]);

            switch (escolha) {
                case 0:
                    incluirConvidado();
                    break;
                case 1:
                    alterarConvidado();
                    break;
                case 2:
                    removerConvidado();
                    break;
                case 3:
                    return; // Volta ao menu anterior
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida.");
            }
        }
    }

    public void incluirConvidado() {
        String nomeConvidado = JOptionPane.showInputDialog("Digite o nome do convidado:");
        // Lógica para incluir o convidado aqui
        JOptionPane.showMessageDialog(null, "Convidado " + nomeConvidado + " incluído com sucesso!");
    }

    public void alterarConvidado() {
        String idConvidado = JOptionPane.showInputDialog("Digite o ID do convidado que deseja alterar:");
        // Lógica para buscar e alterar o convidado pelo ID
        /*String convidado = buscarConvidadoPorId(idConvidado); // Exemplo de busca
            if (convidado != null) {
                // Lógica para alterar o convidado
                JOptionPane.showMessageDialog(null, "Convidado com ID " + idConvidado + " alterado com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Convidado com ID " + idConvidado + " não encontrado.");
            }*/
    }

    public void removerConvidado() {
        String idConvidado = JOptionPane.showInputDialog("Digite o ID do convidado que deseja remover:");
        // Lógica para buscar e remover o convidado pelo ID
        /*String convidado = buscarConvidadoPorId(idConvidado); // Exemplo de busca
            if (convidado != null) {
                // Lógica para remover o convidado
                JOptionPane.showMessageDialog(null, "Convidado com ID " + idConvidado + " removido com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Convidado com ID " + idConvidado + " não encontrado.");
            }*/
    }

    public void menuGerenciarPagamentos() {
        while (true) {
            String[] opcoes = {"Pagamento à Vista", "Pagamento Agendado", "Verificar Pagamentos Agendados", "Voltar"};
            int escolha = JOptionPane.showOptionDialog(null, "Menu de Pagamentos", "Pagamentos", JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE, null, opcoes, opcoes[0]);

            switch (escolha) {
                case 0:
                    pagamentoAVista();
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

    public void pagamentoAVista() {
        String idFornecedor = JOptionPane.showInputDialog("Digite o ID do fornecedor:");
        String valorPagamento = JOptionPane.showInputDialog("Digite o valor do pagamento:");
        String dataPagamento = JOptionPane.showInputDialog("Digite a data do pagamento (dd/mm/yyyy):");

        // Aqui você pode adicionar a lógica para registrar o pagamento à vista
        JOptionPane.showMessageDialog(null, "Pagamento à vista registrado:\nFornecedor ID: " + idFornecedor
                + "\nValor: R$ " + valorPagamento + "\nData: " + dataPagamento);
    }

    public void agendarPagamento() {
        String idFornecedor = JOptionPane.showInputDialog("Digite o ID do fornecedor:");
        String valorPagamento = JOptionPane.showInputDialog("Digite o valor do pagamento:");
        String dataVencimento = JOptionPane.showInputDialog("Digite a data de vencimento do pagamento (dd/mm/yyyy):");

        // Aqui você pode adicionar a lógica para agendar o pagamento
        JOptionPane.showMessageDialog(null, "Pagamento agendado:\nFornecedor ID: " + idFornecedor
                + "\nValor: R$ " + valorPagamento + "\nData de Vencimento: " + dataVencimento);
    }

    public void verificarPagamentosAgendados() {
        Calendar hoje = Calendar.getInstance();
        if (calendario.get(Calendar.DAY_OF_YEAR) == hoje.get(Calendar.DAY_OF_YEAR)
                && calendario.get(Calendar.YEAR) == hoje.get(Calendar.YEAR)) {
            JOptionPane.showMessageDialog(null, "Você tem pagamentos agendados para hoje.");
            // Lógica para alterar o estado dos fornecedores
        } else {
            JOptionPane.showMessageDialog(null, "Não há pagamentos agendados para hoje.");
        }
    }

    public void menuGerenciarCalendario() {
        while (true) {
            String[] opcoes = {"Adicionar Evento", "Visualizar Calendário", "Voltar"};
            int escolha = JOptionPane.showOptionDialog(null, "Gerenciamento de Calendário", "Calendário", JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE, null, opcoes, opcoes[0]);

            switch (escolha) {
                case 0:
                    adicionarEvento();
                    break;
                case 1:
                    visualizarCalendario();
                    break;
                case 2:
                    return; // Volta ao menu anterior
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida.");
            }
        }
    }

    // Lista para armazenar eventos
    //static List<String> eventos = new ArrayList<>();
    public void adicionarEvento() {
        String dataEvento = JOptionPane.showInputDialog("Digite a data do evento (dd/mm/yyyy):");
        String descricaoEvento = JOptionPane.showInputDialog(null, "Digite a descrição do evento (até 4000 caracteres):",
                "Adicionar Evento", JOptionPane.PLAIN_MESSAGE);

        // Limitar a descrição a 4000 caracteres
        if (descricaoEvento.length() > 4000) {
            descricaoEvento = descricaoEvento.substring(0, 4000); // Trunca o texto para 4000 caracteres
        }

        // Armazena o evento em formato adequado
        String evento = "Data: " + dataEvento + " - Descrição: " + descricaoEvento;
        //eventos.add(evento);

        JOptionPane.showMessageDialog(null, "Evento adicionado com sucesso!\n" + evento);
    }

    public void visualizarCalendario() {
        StringBuilder calendarioCompleto = new StringBuilder("Calendário Completo:\n");

        // Adiciona os eventos anotados
        /*if (!eventos.isEmpty()) {
                calendarioCompleto.append("Eventos:\n");
                for (String evento : eventos) {
                    calendarioCompleto.append(evento).append("\n");
                }
            } else {
                calendarioCompleto.append("Nenhum evento anotado.\n");
            }*/
        // Simulação de pagamentos feitos e agendados
        // Aqui você pode utilizar as listas ou estruturas que você já tenha para armazenar pagamentos e agendamentos
        calendarioCompleto.append("\nPagamentos Feitos:\n");
        // Exemplo: listaPagamentosFeitos (lista fictícia)
        // for (Pagamento p : listaPagamentosFeitos) {
        //     calendarioCompleto.append(p).append("\n");
        // }

        calendarioCompleto.append("\nPagamentos Agendados:\n");
        // Exemplo: listaPagamentosAgendados (lista fictícia)
        // for (Pagamento p : listaPagamentosAgendados) {
        //     calendarioCompleto.append(p).append("\n");
        // }

        // Exibe o calendário completo
        JOptionPane.showMessageDialog(null, calendarioCompleto.toString(), "Visualizar Calendário", JOptionPane.INFORMATION_MESSAGE);
    }

    public void menuConvidado() {
        while (true) {
            String[] opcoes = {"Presentes", "Recados", "Confirmar Presença", "Voltar"};
            int escolha = JOptionPane.showOptionDialog(null, "Menu Convidado", "Convidado", JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE, null, opcoes, opcoes[0]);

            switch (escolha) {
                case 0:
                    menuPresentesConvidado();
                    break;
                case 1:
                    menuRecadosConvidado();
                    break;
                case 2:
                    confirmarPresenca();
                    break;
                case 3:
                    return; // Volta ao menu anterior
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida.");
            }
        }
    }

// Menu de Presentes para Convidado
    public void menuPresentesConvidado() {
        String[] opcoes = {"Dar Presente", "Ver Presentes", "Voltar"};
        int escolha = JOptionPane.showOptionDialog(null, "Menu Presentes", "Presentes", JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE, null, opcoes, opcoes[0]);

        switch (escolha) {
            case 0:
                JOptionPane.showMessageDialog(null, "Dando presente.");
                // Função de dar presente aqui
                break;
            case 1:
                JOptionPane.showMessageDialog(null, "Exibindo lista de presentes.");
                // Função de exibição de presentes aqui
                break;
            case 2:
                return; // Volta ao menu anterior
            default:
                JOptionPane.showMessageDialog(null, "Opção inválida.");
        }
    }

// Menu de Recados para Convidado
    public void menuRecadosConvidado() {
        String[] opcoes = {"Ver Recados", "Deixar Recado", "Voltar"};
        int escolha = JOptionPane.showOptionDialog(null, "Menu Recados", "Recados", JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE, null, opcoes, opcoes[0]);

        switch (escolha) {
            case 0:
                JOptionPane.showMessageDialog(null, "Exibindo mural de recados.");
                // Função de exibição de recados
                break;
            case 1:
                deixarRecadoLogado();
                break;
            case 2:
                return; // Volta ao menu anterior
            default:
                JOptionPane.showMessageDialog(null, "Opção inválida.");
        }
    }

// Deixar Recado no Menu Logado
    public void deixarRecadoLogado() {
        String idConvidado = JOptionPane.showInputDialog("Digite o ID do convidado:");
        String recado = JOptionPane.showInputDialog(null, "Digite seu recado (até 4000 caracteres):",
                "Deixar Recado", JOptionPane.PLAIN_MESSAGE);

        if (recado.length() > 4000) {
            recado = recado.substring(0, 4000); // Trunca o recado para 4000 caracteres
        }

        JOptionPane.showMessageDialog(null, "Recado deixado com sucesso!\n" + recado);
        // Lógica para armazenar o recado
    }

    // Método de Confirmar Presença
    public void confirmarPresenca() {
        String idConvidado = JOptionPane.showInputDialog("Digite o ID do convidado:");

        if (idConvidado != null && !idConvidado.isEmpty()) {
            // Lógica para confirmar presença (armazenar ou marcar a presença)
            JOptionPane.showMessageDialog(null, "Presença confirmada com sucesso para o convidado com ID: " + idConvidado);
        } else {
            JOptionPane.showMessageDialog(null, "ID do convidado inválido. Tente novamente.");
        }
    }
}
