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
public class FormatarTelefone {

    public String telefone(String telefone) {
        // Remover todos os caracteres não numéricos
        if (telefone != null) {
            telefone = telefone.replaceAll("\\D", "");

            // Verificar se o número tem o comprimento esperado (11 dígitos)
            if (telefone.length() == 11) {
                return telefone.replaceFirst("(\\d{2})(\\d{5})(\\d{4})", "($1) $2-$3");
            } else {
                throw new IllegalArgumentException("Número de telefone inválido. Deve conter 11 dígitos.");
            }
        } else {
            throw new NullPointerException(Integer.toString(JOptionPane.showConfirmDialog(null, "DESEJA SAIR?", "ATENÇÃO", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE)));
        }
    }

}
