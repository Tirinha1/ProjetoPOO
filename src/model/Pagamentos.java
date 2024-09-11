/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDate;
import java.time.LocalDateTime;
/**
 *
 * @author Gabriel
 */
public class Pagamentos {
    private long id;
    private LocalDate data;
    private Pessoa pessoa;
    private String descricao;
    private Fornecedor fornecedor;
    private double valor;
    private int parcela;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataModificacao;
    private static long serial = 0;
    
    public Pagamentos(){
        this.id = ++serial;
        this.dataCriacao = LocalDateTime.now();
    }
    
    public long getId() {
        return this.id;
    }
    
    public void setData(LocalDate data) {
        this.data = data;
    }
    
    public LocalDate getData() {
        return this.data;
    }
    
    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
    
    public Pessoa getPessoa() {
        return this.pessoa;
    }
    
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public String getDescricao() {
        return this.descricao;
    }
    
    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }
    
    public Fornecedor getFornecedor() {
        return this.fornecedor;
    }
    
    public void setValor(double valor) {
        this.valor = valor;
    }
    
    public double getValor() {
        return this.valor;
    }
    
    public void setParcela(int parcela) {
        this.parcela = parcela;
    }
    
    public int getParcela() {
        return this.parcela;
    }
    
    
    public LocalDateTime getDataCriacao() {
        return this.dataCriacao;
    }
    
    
    public LocalDateTime getDataModificacao() {
        return this.dataModificacao;
    }
}
