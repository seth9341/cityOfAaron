// The MainMenuView class - part of the view layer
// Object of this class manages the main menu
// Author: Seth Huntley, Bruce Montgomery, Stanley Varner
// Date last modified: May 2018
//-------------------------------------------------------------
package view;

import java.util.Scanner;
import cityofaaron.CityOfAaron;
import model.Player;
import model.Game;
import model.CropData;
import control.GameControl;


public class MainMenuView extends MenuView 
{
        
// The MainMenuView constructor
// Purpose: Initialize the menu data
// Parameters: none
// Returns: none
// ===================================
public MainMenuView()
{
        super("\n" +
                   "**********************************\n" +
                   "* CITY OF AARON: MAIN GAME MENU  *\n" +
                   "**********************************\n" +
                   " 1 - Start new game\n" +
                   " 2 - Get and start a saved game\n" +
                   " 3 - Get help on playing the game\n" +
                   " 4 - Save game\n" +
                   " 5 - Quit\n",
                5);
}
    // The doAction method
    // Purpose: performs the selected action
    // Parameters: none
    // Returns: none
    // ===================================       
    @Override public void doAction(int option)
    {
        switch(option)
        {
            case 1: // create and start a new game
                startNewGame();
                break;
            case 2: // get and start a saved game
                startSavedGame();
                break;
            case 3: // get help menu
                displayHelpMenuView();
                break;
            case 4: // save game
                displaySaveGameView();
                break;
            case 5:
                System.out.println("Thanks for playing ... goodbye.");
        }

    } 
    // The startNewGame method
    // Purpose: creates game object and starts the game
    // Parameters: none
    // Returns: none
    // ===================================     
 public void startNewGame()
 {
    /*
     /Create a new Game object.
    Game theGame = new Game();

    // Save a reference to it in the GameProject class.
    CityOfAaron.setTheGame(theGame);
    */

    // Display the Banner Page.
    System.out.println("\nWelcome to the best city on planet earth, the city of Aaron. \n"
            + "You have been commissioned here by the High Priest \n"
            + "to assume your role as leader of the city. Your responsibility \n"
            + "is to buy and sell land, determine how much wheat to plant each year \n"
            + "and how much to set aside to feed your people. In addition, it will \n"
            + "be your duty to pay an annual tithe on the wheat that is harvested. \n"
            + "If you fail to provide enough wheat for the people, people will starve,  \n"
            + "some people will die, and your workforce will be diminished. Plan \n"
            + "carefully. And Oh, there is always a danger of rats eating your wheat. Freaking rats.");



    // Prompt for and get the user’s name.
    String name;
    System.out.println("\nPlease type in your first name: ");
    name = keyboard.next();
    
    //welcome message
    System.out.println("\nWelcome " + name + ", have fun playing.");
    
    //call the createNewGame() method.  Pass the name as a parameter
    GameControl.createNewGame(name);
    
    // Display the Game menu
    //Create a GameMenuView instance called gmv
    GameMenuView gmv = new GameMenuView();
        
    //Call the displayMenuView method of the newly created mmv instance
    gmv.displayMenuView();
}

public void startSavedGame() 
{
    System.out.println("Called startSavedGame method.");
}

public void displayHelpMenuView()
{
    //Display the Help Menu by creating an instance of the HelpMenuView class called hmv
    HelpMenuView hmv = new HelpMenuView();
    
    //Call the displayMenuView method of the newly created hmv instance
    hmv.displayMenuView();
}

public void displaySaveGameView()
{
    System.out.println("Called displaySaveGameView method.");
}
    
}
