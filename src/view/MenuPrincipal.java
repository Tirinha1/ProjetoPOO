/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;


import javax.swing.JOptionPane;
/**
 *
 * @author Gabriel
 */
public class MenuPrincipal {

    public static void main(String[] args) {
        String[] options = {"Option 1", "Option 2", "Option 3", "Exit"};
        int choice;

        do {
            choice = JOptionPane.showOptionDialog(null,
                "Choose an option",
                "Menu",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                options,
                options[0]);

            switch (choice) {
                case 0:
                    JOptionPane.showMessageDialog(null, "You chose Option 1");
                    break;
                case 1:
                    JOptionPane.showMessageDialog(null, "You chose Option 2");
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null, "You chose Option 3");
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, "Exiting...");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Invalid choice");
                    break;
            }
        } while (choice != 3); // Continue until the user selects "Exit"
    }
}


