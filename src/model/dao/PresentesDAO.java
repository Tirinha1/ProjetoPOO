package model.dao;

import java.util.Scanner;
import model.Presentes;
import model.Pessoa;

public class PresentesDAO {

    private Presentes[] presentes;
    private int count;

    public PresentesDAO(int tamanho) {
        presentes = new Presentes[tamanho];
        count = 0;
    }

    public void criarPresente(Presentes presente) {
        if (count < presentes.length) {
            presentes[count] = presente;
            count++;
        } else {
            System.out.println("Capacidade máxima atingida");
        }
    }

    public Presentes getPresenteById(long id) {
        for (int i = 0; i < count; i++) {
            if (presentes[i].getId() == id) {
                return presentes[i];
            }
        }
        return null;
    }

    public void updatePresente(Presentes presente) {
        boolean presenteExiste = false;
        for (Presentes p : presentes) {
            if (p != null && p.getId() == presente.getId()) {
                presenteExiste = true;
                Scanner scanner = new Scanner(System.in);
                String update = """
                                O que deseja alterar:
                                1- Nome;
                                2- Tipo;
                                3- Pessoa;
                                4- Valor;""";

                System.out.println(update);
                String opc = scanner.nextLine();

                switch(opc) {
                    case "1":
                        System.out.println("Digite o novo nome:");
                        String nome = scanner.nextLine();
                        p.setNome(nome);
                        p.setDataModificacao();
                        break;
                    case "2":
                        System.out.println("Digite o novo tipo:");
                        String tipo = scanner.nextLine();
                        p.setTipo(tipo);
                        p.setDataModificacao();
                        break;
                    case "3":
                        PessoaDAO pessoaDAO = new PessoaDAO(100);
                        pessoaDAO.getAllPessoa();
                        System.out.println("Digite o ID da nova pessoa:");
                        int idPessoa = Integer.parseInt(scanner.nextLine());
                        Pessoa novaPessoa = pessoaDAO.getPessoaById(idPessoa);

                        if (novaPessoa != null) {
                            p.setPessoa(novaPessoa);
                            p.setDataModificacao();
                            System.out.println("Pessoa atribuída com sucesso.");
                        } else {
                            System.out.println("Pessoa não encontrada. Atualização cancelada.");
                        }
                        break;
                    case "4":
                        System.out.println("Digite o novo valor:");
                        double valor = Double.parseDouble(scanner.nextLine());
                        p.setValor(valor);
                        p.setDataModificacao();
                        break;
                    default:
                        System.out.println("Opção inválida!");
                        break;
                }
            }
        }

        if (!presenteExiste) {
            System.out.println("Presente não encontrado");
        }
    }

    public void deletePresente(long id) {
        for (int i = 0; i < count; i++) {
            if (presentes[i].getId() == id) {
                for (int j = i; j < count - 1; j++) {
                    presentes[j] = presentes[j + 1];
                }
                presentes[count - 1] = null;
                count--;
                return;
            }
        }
        System.out.println("Presente não encontrado");
    }

    public void getAllPresentes() {
        for (Presentes presente : presentes) {
            if (presente != null) {
                System.out.println(presente.toString());
            }
        }
    }
}
