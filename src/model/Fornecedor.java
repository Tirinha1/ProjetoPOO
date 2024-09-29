/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDateTime;
import model.dao.Identifiable;

/**
 *
 * @author Gabriel
 */
public class Fornecedor extends Identifiable {

    private String razaoSocial;
    private String cpfCnpj;
    private String telefone;
    private Pessoa pessoa;
    private double valorAPagar;
    private int parcelas;
    private boolean estadoPagamento;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataModificacao;

    public Fornecedor() {
        this.dataCriacao = LocalDateTime.now();
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getRazaoSocial() {
        return this.razaoSocial;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public String getcpfCnpj() {
        return this.cpfCnpj;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getTelefone() {
        return this.telefone;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public void setValorAPagar(double valorAPagar) {
        this.valorAPagar = valorAPagar;
    }

    public double getValorAPagar() {
        return this.valorAPagar;
    }

    public void setParcelas(int parcelas) {
        this.parcelas = parcelas;
    }

    public int getParcelas() {
        return this.parcelas;
    }

    public void setEstadoPagamento(boolean estadoPagamento) {
        this.estadoPagamento = estadoPagamento;
    }

    public boolean isEstadoPagamento() {
        return this.estadoPagamento;
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

    @Override
    public String toString() {
        return "Fornecedor{" + "razaoSocial=" + razaoSocial + ", cpfCnpj=" + cpfCnpj + ", telefone=" + telefone + ", dataCriacao=" + dataCriacao + ", dataModificacao=" + dataModificacao + "\n"
                + "valorAPagar=" + valorAPagar + ", parcelas=" + parcelas + ", estadoPagamento=" + estadoPagamento + "\n"
                + pessoa.toString() + '}';
    }
    
    
}
