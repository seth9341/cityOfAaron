// The GameMenuView class - part of the view layer
// Object of this class is to control the play of the game.
// Author: Bruce Montgomery
// Date last modified: June 2018
//-------------------------------------------------------------
package view;


public class ListMenuView extends MenuView {
    
        
// The ListView constructor
// Purpose: Initialize the game menu data
// Parameters: none
// Returns: none
// ===================================
public ListMenuView()
{
        super("\n" +
                   "**********************************\n" +
                   "* CITY OF AARON: LIST MENU       *\n" +
                   "**********************************\n" +
                   " 1 - View the development team\n" +
                   " 2 - View a list of animals\n" +
                   " 3 - View a list of tools\n" +
                   " 4 - View a list of provisions\n" +
                   " 5 - Return to the game menu\n",
        
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
            case 1: // View the development team
                viewDevTeam();
                break;
            case 2: // View a list of animals
                viewListOfAnimals();
                break;
            case 3: // View a list of tools
                viewListOfTools();
                break;
            case 4: // View a list of provisions
                viewListOfProvisions();
                break;
            case 5: // Return to the Game Menu
                gameMenuView();
        }
                
    }
    
public void viewDevTeam() 
{
    System.out.println("Called viewDevTeam method.");
}

//The viewListOfAnimals() method
//Purpose: Creates a ViewList object and calls its
//displayMenuView() method
//Parameters: none
//Returns: none
public void viewListOfAnimals()
    //for (int i = 0; i < animals.size(); i++)
{
    //ListItem animals = animals.get(1);
    //System.out.println(li.getName() + ": " + li.getNumber());
}

public void viewListOfTools()
{
    System.out.println("Called viewListOfTools method.");
}

public void viewListOfProvisions()
{
    System.out.println("Called viewListOfProvisions method.");
}

public void gameMenuView()
{
    System.out.println("Return to Game menu method");
}        

}


