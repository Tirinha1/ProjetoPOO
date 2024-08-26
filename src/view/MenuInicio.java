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
public class MenuInicio {

    private final String bemVindo = "BEM VINDO A GW CASAMENTOS";
    private final String noivos;
    private final String[] opcMenuI;


    public MenuInicio() {
        this.opcMenuI = new String[]{"LOGIN", "ENTRAR SEM REGISTRO", "REGISTRAR"};
        this.noivos = "VAMOS CASAR EDUARDO & MONICA?";
    }

    public int exibeMenu() {
        int opc = JOptionPane.showOptionDialog(null, noivos, bemVindo, 0, JOptionPane.INFORMATION_MESSAGE, null, opcMenuI, 0);
        return opc;
    }
}
