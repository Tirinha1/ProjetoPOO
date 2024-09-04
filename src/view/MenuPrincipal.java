/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.time.format.DateTimeParseException;
import javax.swing.JOptionPane;
import model.*;

/**
 *
 * @author Gabriel
 */
public class MenuPrincipal {

    public static void main(String[] args) {
        MenuInicio menuInicio = new MenuInicio();
        int opc;
        do {
            opc = menuInicio.exibeMenu();
            System.out.println(opc);
            switch (opc) {
                case 0 -> {
                }
                case 1 -> {
                }
                case 2 -> {
                    //REGISTRAR
                    
                    Pessoa p = new Pessoa();
                    Usuario u = new Usuario();
                    MenuTipo mt = new MenuTipo();
                    FormatarTelefone tel = new FormatarTelefone();
                    boolean nomeValido = false;
                    boolean telefoneValido = false;
                    boolean dataValida = false;
                    //INSERE NOME
                    while (!nomeValido){
                        try {
                            p.setName(JOptionPane.showInputDialog(null, "Digite seu nome: ", "Nome", JOptionPane.QUESTION_MESSAGE));
                            nomeValido = true;
                        } catch (IllegalArgumentException iae) {
                            JOptionPane.showMessageDialog(null, iae.getMessage());
                        } catch (RuntimeException e) {
                            if (Integer.parseInt(e.getMessage()) == JOptionPane.YES_OPTION) {
                                System.exit(0);
                            }
                            //System.out.println(e.getMessage());
                        }
                        
                    }
                    //INSERE TELEFONE E VALIDA SE TEM 11 DIGITOS
                    while (!telefoneValido) {
                        try {
                            p.setTelefone(tel.telefone(JOptionPane.showInputDialog(null, "Digite seu telefone: ", "Telefone", JOptionPane.QUESTION_MESSAGE)));
                            telefoneValido = true;
                        } catch (IllegalArgumentException e) {
                            JOptionPane.showMessageDialog(null, e.getMessage());
                        } catch (NullPointerException en) {
                            String q = en.getMessage();
                            if (Integer.parseInt(q) == JOptionPane.YES_OPTION){
                                System.exit(0);
                            }
                        }
                    }
                    //TRATAR DATA INVALIDA
                    while (!dataValida) {
                        try {
                            p.setDate(JOptionPane.showInputDialog(null, "Digite sua data nascimento no formato ('DD/MM/AAAA'): ", "Data Nascimento", JOptionPane.QUESTION_MESSAGE));
                            dataValida = true;
                        } catch (DateTimeParseException e) {
                            JOptionPane.showMessageDialog(null, "Formato invalido. Tente digitar a data no formato 'DD/MM/AAAA'");
                        }
                    }
                    p.setDataCriacao();
                    p.setDataModificacao();

                    u.setTipo(mt.ExecMenuTipo());
                    u.setLogin(JOptionPane.showInputDialog(null, "Digite seu login: ", "Login", JOptionPane.QUESTION_MESSAGE));
                    u.setSenha(JOptionPane.showInputDialog(null, "Digite sua senha: ", "Senha", JOptionPane.QUESTION_MESSAGE));
                    u.setDataCriacao(p.getDataCriacao());
                    u.setDataModificacao(p.getDataModificacao());

                    System.out.println(p.getName());
                    System.out.println(p.getTelefone());
                    System.out.println(p.getDate());
                    System.out.println(p.getDataCriacao());
                    System.out.println(p.getDataModificacao());
                    System.out.println(u.getTipo());
                    System.out.println(u.getLogin());
                    System.out.println(u.getSenha());
                    System.out.println(u.getDataCriacao());
                    System.out.println(u.getDataModificacao());
                }

                case -1 -> {
                    int q = JOptionPane.showConfirmDialog(null, "DESEJA SAIR?", "ATENÇÃO", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                    if (q == JOptionPane.YES_OPTION) {
                        JOptionPane.showMessageDialog(null, "Bom casamento e uma ótima festa!", "GW CASAMENTOS AGRADECE", JOptionPane.INFORMATION_MESSAGE);
                        opc = -2;
                    }
                }
            }
        } while (opc != -2);
    }
}

/*

package gestaocasamento;

import javax.swing.JOptionPane;

public class Menu {
    private String titulo = "Menu";
    private String[] opcMenu = {"1 - Opção 1", "2 - Opção 2", "3 - Opção 3", "4 - Opção", "5 - Opção", "0 - SAIR"};
    private int exibeMenu() {
        //return JOptionPane.showInputDialog(opcMenu);
        //return JOptionPane.showInputDialog(null, opcMenu, titulo, -1);
        int opc = JOptionPane.showOptionDialog(null, titulo, titulo, 0, JOptionPane.QUESTION_MESSAGE, null, opcMenu, 0);
        return opc;
    }
    
    public int executaMenu() {
        int opcao = -1;
        while (opcao != 0) {
            opcao = exibeMenu();
            
            switch (opcao) {

                case 1:
                    executaOpção1();
                    break;

                case 2:
                    executaOpção2();
                    break;

                case 3:
                    executaOpção3();
                    break;

                case 4:
                    executaOpção4();
                    break;
                    
                case 5:
                    executaOpção5();
                    break;

                case 0:
                    JOptionPane.showMessageDialog(null, "Adeus");
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Não entendi sua escolha\nVou exibir o menu novamente");

            }
        }
        return opcao;
    }

    private void executaOpção1() {
        JOptionPane.showMessageDialog(null, "Neste método você insere código para executar a opção");
    }

    private void executaOpção2() {
        JOptionPane.showMessageDialog(null, "Neste método você insere código para executar a opção");
    }

    private void executaOpção3() {
        JOptionPane.showMessageDialog(null, "Neste método você insere código para executar a opção");
    }
    
    private void executaOpção4() {
        JOptionPane.showMessageDialog(null, "Neste método você insere código para executar a opção");
    }
    
    private void executaOpção5() {
        JOptionPane.showMessageDialog(null, "Neste método você insere código para executar a opção");
    }
}












import javax.swing.JOptionPane;

public class Menu {

    //  "variável global" - string definida como campo da classe Menu

    String texto = "1 – Opção 1\n2 – Opção 2\n3 – Opção 3\nS – SAIR";

    // Método que exibe o menu usando JOptionPane.showInputDialog

    public String exibeMenu() {

        return JOptionPane.showInputDialog(null, texto);

    }

    // Método principal que contém o laço que exibe o menu e executa a escolha do usuário repetidamente até que o usuário escolhe sair 

    public void executaMenu() {

        String opcao = "";

        while (!opcao.equalsIgnoreCase("s")) {

            opcao = exibeMenu();

            switch (opcao) {

                case "1":

                    executaOpção1();

                    break;

                case "2":

                    executaOpção2();

                    break;

                case "3":

                    executaOpção3();

                    break;

                case "S":

                case "s":

                    JOptionPane.showMessageDialog(null, "Adeus");

                    break;

                default:

                    JOptionPane.showMessageDialog(null, "Não entendi sua escolha\nVou exibir o menu novamente");

            }

        }

    }

    private void executaOpção1() {

        double raio = Double.parseDouble(JOptionPane.showInputDialog("Digite o raio do circulo"));

        Circulo c = new Circulo(raio);

        JOptionPane.showMessageDialog(null, "A circunferência do círculo com raio " + raio + " é " + c.circunferencia());

    }

    private void executaOpção2() {

        JOptionPane.showMessageDialog(null, "Neste método você insere código para executar a opção");

    }

    private void executaOpção3() {

        JOptionPane.showMessageDialog(null, "Neste método você insere código para executar a opção");

    }

    public static void main(String[] args) {

        Menu m = new Menu();

        m.ExecutaMenu();

    }

}
 */
