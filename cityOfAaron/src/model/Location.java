/*
 * The Location class file for the cityOfAaron project
 * CIT-260
 * Spring 2018
 * Team members: Seth Huntley, Bruce Montgomery, Stanley Varner
 */
package model;

import java.io.Serializable;

/**
 *
 * @author for Location is Stanley Varner
 */
public class Location implements Serializable {
    
    //Class instance variables
    private String description;
    private String symbol;
    
    public Location() {
        
    }
    
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
    
    @Override
    public String toString() {
        return "Location{" + "description = " + description + ", symbol = " + symbol + '}';
    }
    
}
