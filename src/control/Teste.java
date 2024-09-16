/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import view.MenuInicio;

/**
 *
 * @author Gabriel
 */
public class Teste {
    public static void main(String[] args) {
        MenuInicio menuInicio = new MenuInicio();
        MenuInicio.GerenciamentoCasamento gerenciamento = menuInicio.new GerenciamentoCasamento(); // Instanciando a classe interna
        gerenciamento.menuInicial(); // Chamando o menu inicial
    }
}
