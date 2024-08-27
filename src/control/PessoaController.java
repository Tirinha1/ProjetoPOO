/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import model.Pessoa;
import model.dao.PessoaDAO;

/**
 *
 * @author Gabriel
 */
public class PessoaController {
    final private PessoaDAO pessoaDAO;

    public PessoaController(int tamanhoArray) {
        this.pessoaDAO = new PessoaDAO(tamanhoArray);
    }

    public void criarPessoa(String nome, String nascimentoStr, String telefone) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date nascimento = dateFormat.parse(nascimentoStr);

        Pessoa pessoa = new Pessoa();
        pessoa.setDataCriacao();
        pessoa.setDataModificacao();
        pessoa.setName(nome);
        pessoa.setDate(nascimento);
        pessoa.setTelefone(telefone)
                ;
        pessoaDAO.salvar(pessoa);
    }
    
     public void listarPessoas() {
        for (Pessoa pessoa : pessoaDAO.listar()) {
            if (pessoa != null) {
                System.out.println(pessoa.getName());
            }
        }
    }
}

