/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author IFTM
 */
public class Utils {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    LocalDate data;
    
    //formato dd-MM-yy
    public LocalDate formatDate(String data){
        try{
            this.data = LocalDate.parse(data, formatter);
        } catch(Exception e){
            System.out.println("ERROR: " + e.getMessage());
        }
        System.out.println(data);
        return this.data;
    }
}
