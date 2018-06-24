// The GameMenuView class - part of the view layer
// Object of this class is to control the play of the game.
// Author: Bruce Montgomery
// Date last modified: June 2018
//-------------------------------------------------------------
package view;

import java.util.Scanner;

public class GameMenuView extends MenuView {
    
        
// The GameMenuView constructor
// Purpose: Initialize the game menu data
// Parameters: none
// Returns: none
// ===================================
public GameMenuView()
{
        super("\n" +
                   "**********************************\n" +
                   "* GAME MENU                      *\n" +
                   "**********************************\n" +
                   " 1 - View the map\n" +
                   " 2 - View/Print a list\n" +
                   " 3 - Move to a new location\n" +
                   " 4 - Manage the Crops\n" +
                   " 5 - Return to the Main menu\n",
        
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


