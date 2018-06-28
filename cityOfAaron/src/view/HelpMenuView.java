// The HelpMenuView class - part of the view layer
// Object of this class is to control the selling of land
// Author: Stanley Varner
// Date last modified: June 2018
//-------------------------------------------------------------
package view;

import java.util.Scanner;


public class HelpMenuView extends MenuView {
    

// The HelpMenuView constructor
// Purpose: Initialize the game menu data
// Parameters: none
// Returns: none
// ===================================
public HelpMenuView()
{
            super("\n" +
                   "**********************************\n" +
                   "* HELP MENU                      *\n" +
                   "**********************************\n" +
                   " 1 - What are the goals of the game?\n" +
                   " 2 - Where is the city of Aaron?\n" +
                   " 3 - How do I view the map?\n" +
                   " 4 - How do I move to another location?\n" +
                   " 5 - How do I display a list of animals, provisions and tools in the city storehouse?\n" +
                   " 6 - Back to the Main Menu.",
               6);
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
            case 1: // how to view the goals of the game
                viewGoals();
                break;
            case 2: // how to see the location of city of aaron
                viewCityOfAaronLocation(); // this is not on the UML so made
                //one up until we here back about it
                break;
            case 3: // how to view the map
                viewMapHelp();
                break;
            case 4: // how to move to another location
                viewMoveHelp();
                break;
            case 5: // how to list goods
                viewListHelp();
            case 6:
                mainMenuView();
        }

    }
    
public void viewGoals() 
{
    System.out.println("Called viewGoals method.");
}

public void viewCityOfAaronLocation() 
{
    System.out.println("Called viewCityOfAaronLocation method.");
}

public void viewMapHelp()
{
    System.out.println("Called viewMapHelp method.");
}

public void viewMoveHelp()
{
    System.out.println("Called viewMoveHelp method.");
}

public void viewListHelp()
{
    System.out.println("Called viewListHelp method.");
}

public void mainMenuView()
{
    System.out.println("Return to main menu method");
}        

    
}
