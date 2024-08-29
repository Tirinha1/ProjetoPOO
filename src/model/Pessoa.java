/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Gabriel
 */
public class Pessoa {

    private int id;
    private String nome;
    private LocalDate nascimento;
    private String telefone;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataModificacao;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public void setName(String nome) {    
        if (nome.isBlank()) {
            throw new IllegalArgumentException("Nome esta vazio, digite novamente.");
        } else if (nome.isEmpty()) {
            throw new RuntimeException(Integer.toString(JOptionPane.showConfirmDialog(null, "DESEJA SAIR?", "ATENÇÃO", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE)));
        } else {
            this.nome = nome;
        }
    }

    public String getName() {
        return this.nome;
    }

    public void setDate(String nascimento) throws DateTimeParseException {
        DateTimeFormatter formatData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        this.nascimento = LocalDate.parse(nascimento, formatData);
    }

    public LocalDate getDate() {
        return this.nascimento;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getTelefone() {
        return this.telefone;
    }

    public void setDataCriacao() {
        this.dataCriacao = LocalDateTime.now();
    }

    public LocalDateTime getDataCriacao() {
        return this.dataCriacao;
    }

    public void setDataModificacao() {
        this.dataModificacao = LocalDateTime.now();
    }

    public LocalDateTime getDataModificacao() {
        return this.dataModificacao;
    }
}
