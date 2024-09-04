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

    private final String bemVindo;
    private final String noivos;
    private final String[] opcMenuI;
    private final String titulo;
    
    public MenuInicio() {
        this.opcMenuI = new String[]{"1 - LOGIN", "2 - ENTRAR SEM REGISTRO", "3 - REGISTRAR"};
        this.noivos = "VAMOS CASAR EDUARDO & MONICA?";
        this.bemVindo = "BEM VINDO A GW CASAMENTOS";
        this.titulo = "GW CASAMENTOS";
        JOptionPane.showMessageDialog(null, bemVindo);
        JOptionPane.showMessageDialog(null, noivos);
    }

    public int exibeMenu() {
        int opc = Integer.parseInt(JOptionPane.showInputDialog(null, opcMenuI, titulo, JOptionPane.QUESTION_MESSAGE));
        return opc;
        
    }
}
