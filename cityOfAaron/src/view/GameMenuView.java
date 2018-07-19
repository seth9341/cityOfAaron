// The GameMenuView class - part of the view layer
// Object of this class is to control the play of the game.
// Author: Bruce Montgomery
// Date last modified: June 2018
//-------------------------------------------------------------
package view;

import java.util.Scanner;
import view.MainMenuView;

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
                   "* CITY OF AARON: GAME MENU       *\n" +
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
            case 1: // View the map
                viewMap();
                break;
            case 2: // View a list
                viewList();
                break;
            case 3: // Move to a new location
                moveToNewLocation();
                break;
            case 4: // Manage the Crops
                manageCrops();
                break;
            case 5: // Return to the Main Menu
                mainMenuView();
        }
                
    }
    
public void viewMap() 
{
    System.out.println("Called viewMap method.");
}

//The viewList() method
//Purpose: Creates a ViewList object and calls its
//displayMenuView() method
//Parameters: none
//Returns: none
public void viewList()
{
    ListMenuView lv = new ListMenuView();
    lv.displayMenuView();
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
    //Create a MainMenuView instance called mmv
    MainMenuView mmv = new MainMenuView();
        
    //Call the displayMenuView method of the newly created mmv instance
    mmv.displayMenuView();
}        

}


