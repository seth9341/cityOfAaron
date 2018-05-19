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
     
    
  //class constructor
    public Game() {
    }
    
    public Player getThePlayer() {
        return thePlayer;
    }

    public void setThePlayer(Player thePlayer) {
        this.thePlayer = thePlayer;
    }
}
