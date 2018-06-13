// The GameMenuView class - part of the view layer
// Object of this class is to control the play of the game.
// Author: Bruce Montgomery
// Date last modified: June 2018
//-------------------------------------------------------------
package view;

import java.util.Scanner;

public class GameMenuView {
    
    //Create a Scanner object
    private static Scanner keyboard = new Scanner(System.in);
    private String theMenu;
    private int max;
        
// The GameMenuView constructor
// Purpose: Initialize the game menu data
// Parameters: none
// Returns: none
// ===================================
public GameMenuView()
{
        theMenu = "\n" +
                   "**********************************\n" +
                   "* GAME MENU                      *\n" +
                   "**********************************\n" +
                   " 1 - View the map\n" +
                   " 2 - View/Print a list\n" +
                   " 3 - Move to a new location\n" +
                   " 4 - Manage the Crops\n" +
                   " 5 - Return to the Main menu\n";
        
        max = 5;
}

 // The displayMenuView method
    // Purpose: displays the menu, gets the user's input, and does the 
    //               selected action
    // Parameters: none
    // Returns: none
    // =========================================================    
public void displayMenuView()
{
    int menuOption;
    do
    {   
     // Display the menu
        System.out.println(theMenu);

     // Prompt the user and get the user’s input
        menuOption = getMenuOption();

     // Perform the desired action
        doAction(menuOption);

     // Determine and display the next view
    } while (menuOption != max);


}
    // The getMenuOption method
    // Purpose: gets the user's input
    // Parameters: none
    // Returns: integer - the option selected
    // ===================================       
    public int getMenuOption()
    {
        // declare a variable to hold user’s input
        int userInput;

        // begin loop
        do
        {
        // get user input from the keyboard
            userInput = keyboard.nextInt();

        // if it is not a valid value, output an error message
            if(userInput < 1 || userInput > max)
            {
                System.out.println("\noption must be between 1 and " + max);
            }

        // loop back to the top if input was not valid
        } while(userInput < 1 || userInput > max);

        // return the value input by the user
        return userInput;
        
    }
    // The doAction method
    // Purpose: performs the selected action
    // Parameters: none
    // Returns: none
    // ===================================       
    public void doAction(int option)
    {
        switch(option)
        {
            case 1: // create and start a new game
                viewMap();
                break;
            case 2: // get and start a saved game
                viewList();
                break;
            case 3: // get help menu
                moveToNewLocation();
                break;
            case 4: // save game
                manageCrops();
                break;
            case 5:
                mainMenuView();
        }

    }
    
public void viewMap() 
{
    System.out.println("Called viewMap method.");
}

public void viewList()
{
    System.out.println("Called viewList method.");
}

public void moveToNewLocation()
{
    System.out.println("Called moveToNewLocation method.");
}

public void manageCrops()
{
    CropView.runCropsView();
}

public void mainMenuView()
{
    System.out.println("Return to main menu method");
}        


}


