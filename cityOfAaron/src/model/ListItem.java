/*
 * The ListItem class file for the cityOfAaron project
 * CIT-260
 * Spring 2018
 * Team members: Seth Huntley, Bruce Montgomery, Stanley Varner
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


    public ListItem(String name, int number) {
        this.name = name;
        this.number = number;
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
