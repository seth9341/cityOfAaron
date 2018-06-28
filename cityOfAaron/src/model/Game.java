/*
 * The Game class file for the cityOfAaron project
 * CIT-260
 * Spring 2018
 * Team members: Seth Huntley, Bruce Montgomery, Stanley Varner
 */
package model;

import java.io.Serializable;

/**
 *
 * @author brucem
 */
public class Game implements Serializable{
    
   //class instance variables
    private Player thePlayer;
    
   //variable for keeping a reference to a CropData object
    private CropData cropData = null;
    
   //variable for keeping a reference to the animals ListItem object
    private ListItem animals = null;
    
  //class constructor
    public Game() {
    }
    
    public Player getThePlayer() {
        return thePlayer;
    }

    public void setThePlayer(Player thePlayer) {
        this.thePlayer = thePlayer;
    }
   //the getCropData() method
   //Purpose:  get a reference to the crop object
   //Parameters: none
   //Returns: a reference to a crop object
    public CropData getCropData() {
        return cropData;
    }
    
   //the setCropData() method
   //Purpose:  store a reference to a crop object
   //Parameters: a reference to a crop object
   //Returns: none
    public void setCropData(CropData cropData) {
        this.cropData = cropData;
    }

    public ListItem getAnimals() {
        return animals;
    }

    public void setAnimals(ListItem animals) {
        this.animals = animals;
    }
    
}
