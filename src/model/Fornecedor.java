/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDateTime;

/**
 *
 * @author Gabriel
 */
public class Fornecedor {
    private long id;
    private String nome;
    private String cnpj;
    private String telefone;
    private double valorAPagar;
    private int parcelas;
    private boolean estadoPagamento;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataModificacao;
    private static long idCounter = 0;
    
    public Fornecedor(){
        this.id = ++idCounter;
        this.dataCriacao = LocalDateTime.now();
    }
    
    public Fornecedor(String nome, String cnpj, String telefone, double valorAPagar, int parcelas, boolean estadoPagamento){
        this.nome = nome;
        this.cnpj = cnpj;
        this.telefone = telefone;
        this.valorAPagar = valorAPagar;
        this.parcelas = parcelas;
        this.estadoPagamento = estadoPagamento;
        this.dataCriacao = LocalDateTime.now();
    }
    public Fornecedor updateFornecedor(String nome, String cnpj, String telefone, double valorAPagar, int parcelas, boolean estadoPagamento){
        this.nome = nome;
        this.cnpj = cnpj;
        this.telefone = telefone;
        this.valorAPagar = valorAPagar;
        this.parcelas = parcelas;
        this.estadoPagamento = estadoPagamento;
        this.dataModificacao = LocalDateTime.now();
        return this;
    }
    
    public long getId() {
        return this.id;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getNome() {
        return this.nome;
    }
    
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
    
    public String getCnpj() {
        return this.cnpj;
    }
    
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    public String getTelefone() {
        return this.telefone;
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
    
    
    public LocalDateTime getDataModificacao() {
        return this.dataModificacao;
    }
}