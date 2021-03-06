// The GameMenuView class - part of the view layer
// Object of this class is to control the play of the game.
// Author: Bruce Montgomery
// Date last modified: June 2018
//-------------------------------------------------------------
package view;

import java.util.Scanner;
import view.MainMenuView;
import model.Map;
import model.Location;
import model.*;
import cityofaaron.CityOfAaron;


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
    

    //The viewMap method
    //Purpose: to show the player a map of the game
    //Parameters: None
    //Returns: None
    //Seth Huntley
    //Individual Assignment for week 13
    public void viewMap() {
        //get current game instance
        Game theGame = CityOfAaron.getTheGame();
        
        Map map = theGame.getTheMap();
        Location locations = null;
        System.out.println("\nWelcome to the City of Aaron!\n"
        + "Come and see what we have to offer!\n"
        + "Courtesy of the City of Aaron Tourism Council.\n");

        System.out.println("     1     2     3     4     5");
        // row dividers and numbering
        for (int i = 0; i < max; i++) {
            System.out.println("  -------------------------------");
            System.out.print((i + 1) + " ");
            // columns, dividers
            for (int j = 0; j < max; j++) {
                System.out.print("|");
                // Get the symbols and locations(row, column) for the map
                locations = map.getLocation(i,j);
                System.out.print(" " + locations.getSymbol());
            }
         
            System.out.println("|");
        }
        System.out.println("  -------------------------------\n"
        + "  -------------------------------\n");

    System.out.println("Key:\n" + "~~~ = river\n" + "!!! = farmland\n"
    + "---_ = desert\n1" + "$$$$ = court\n" + "|||| = granary\n" + "^^^^ = village\n"
    + ":(:( = border\n" + "MMMM = undeveloped\n" + "**** = rameumpton\n"
    + "#### = amphitheater\n" + "&&&& = Soldiers Quarters\n" + "@@@@ = bakery\n"
    + "%%%% = Village Garden\n" + "!**! = Temple\n" + "##!! = The Palace\n");
    
    System.out.println("  -------------------------------\n"
        + "  -------------------------------\n");
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
    CropView.cropsReportView(); //call the cropsReportView at the beginning of a game
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


