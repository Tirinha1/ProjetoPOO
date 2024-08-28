/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import javax.swing.JOptionPane;

/**
 *
 * @author WAGNERJR
 */
public class MenuTipo {

    public String ExecMenuTipo() {
        String titulo = "Tipo Cadastro";
        String[] tipo = {"1 - DONO", "2 - ADMINISTRADOR", "3 - CONVIDADO"};
        return JOptionPane.showInputDialog(null, tipo,  titulo, JOptionPane.QUESTION_MESSAGE);
    }
 
}
