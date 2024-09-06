/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao;

import java.util.Arrays;

/**
 *
 * @author Gabriel
 * @param <T>
 */
public class Database<T extends Identifiable>{
    T[] data;
    
    public Database(T[] arr){
        data = arr;
    }
    
    public void create(T datum){
        data = Arrays.copyOf(data, data.length + 1);
        data[data.length - 1] = datum;
    }
    
    public void delete(int id){
        T[] temp = Arrays.copyOf(data, data.length - 1);
        int deletePosition = -1;
        
        for(int i = 0; i < data.length; i++){
            if(data[i].id == id){
                deletePosition = i;
            }
        }
        
        if(deletePosition < 0){
            return;
        } 
        int currentPosition = 0;
        for(int i = 0; i < data.length; i++){
            if(i != deletePosition){
                temp[currentPosition] = data[i];
                currentPosition++;
            }
        }
        data = temp;
    } 
    
    public T getById(int id){
        T result = null;
        for (T data1 : data) {
            if (data1.id == id) {
                return data1;
            }
        }
        return result;
    }
    
    public T[] getAll(){
        return data;
    }
    
    public void update(T datum){
        for(int i = 0; i < data.length; i++){
            if(datum.id == data[i].id){
                data[i] = datum;
            }
        }
    }
}
