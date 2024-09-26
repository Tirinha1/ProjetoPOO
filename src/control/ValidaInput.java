/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

/**
 *
 * @author DEVENG
 */
public class ValidaInput {

    public static boolean string(String input) {
        return !(input == null || input.isBlank());
    }

    public static boolean stringEhNumero(String input) {
        return input.matches("^\\d+$");
    }

}
