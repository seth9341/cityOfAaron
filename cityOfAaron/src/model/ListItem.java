/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 *This individual assignment was given to
 *Bruce Montgomery who is the author.
 */
public class ListItem implements Serializable{
    
    //Class instance variables
    private String name;
    private int number;

    public ListItem() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
    
    
    
    
}
