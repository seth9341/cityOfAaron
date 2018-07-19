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
                break;
            case 6:
                mainMenuView();
        }

    }
    
public void viewGoals() 
{
    System.out.println("The goal of the game is to manage the village’s wheat\n" +
            "crops so that the people of the village can be adequately\n" +
            "fed, while dealing with rats, and random crop yields. The city is\n" +
            "blessed from the Lord above when the people pay their tithes and \n" +
            "offerings. After 10 years you will be judged by the people on how\n" +
            "well you fed the people, if too many people die then your reign will\n" +
            "end and so will the game.");
}

public void viewCityOfAaronLocation() 
{
    System.out.println("The City Of Aaron is located near the cities of Moroni and Nephihah.");
}

public void viewMapHelp()
{
    System.out.println("Return To The MAIN GAME MENU and select option 1\n" +
            "to start a new game. Once you have started a new game \n" +
            "select option 1 on the GAME MENU to view the map.");
}

public void viewMoveHelp()
{
    System.out.println("Return To The MAIN GAME MENU and select option 1\n" +
            "to start a new game. Once you have started a new game \n" +
            "select option 3 on the GAME MENU to move to a new location.");
}

public void viewListHelp()
{
    System.out.println("Return To The MAIN GAME MENU and select option 1\n" +
            "to start a new game. Once you have started a new game \n" +
            "select option 2 on the GAME MENU to view the LIST MENU.\n" +
            "Once you are at the LIST MENU then you may select options 1-4\n" +
            "to view the lists of animals, tools, and provisions.");
}

public void mainMenuView()
{
    //Create a MainMenuView instance called mainMenu
    MainMenuView mainMenu = new MainMenuView();
        
    //Call the displayMenuView method of the newly created mmv instance
    mainMenu.displayMenuView();
}        

    
}
