// The GameMenuView class - part of the view layer
// Object of this class is to control the play of the game.
// Author: Bruce Montgomery
// Date last modified: June 2018
//-------------------------------------------------------------
package view;

import model.*;
import cityofaaron.*;
import java.util.ArrayList;
import java.io.PrintWriter;

public class ListMenuView extends MenuView {
    
    //getTheGame and assign to theGame. Will be used by the viewlist methods
    Game theGame = CityOfAaron.getTheGame();
           
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
                chooseAnimal();
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
    

//The viewDevTeam() method
//Purpose: Creates a ViewList object and calls its
//displayMenuView() method
//Parameters: none
//Returns: none
public void viewDevTeam()
{
    ArrayList<ListItem> developers = theGame.getDevelopers();
    for(ListItem n: developers){
        System.out.println("The members of the development team are " + n.getName());
    }
}

public void chooseAnimal()
{
    int max = 3;
    int menuOption = 0;
    int userInput = 0;
    ArrayList<ListItem> animals = theGame.getAnimals();
        
    System.out.println("\n" +
                        "   What would you like to do?  \n\n" +
                        " 1 - View a list of animals\n" +
                        " 2 - Save a list of animlas to disk\n" +
                        " 3 - Return to Lists");
    do
    {
        userInput = keyboard.nextInt();
        
        if(userInput < 1 || userInput > max)
        {
            System.out.println("\noption must be between 1 and " + max);
        }
    } while(userInput < 1 || userInput > max);
    
    if(userInput == 1)
    {
        viewListOfAnimals();
    }
    else{
    
        saveListOfAnimals(animals);
    }
    
    
    
}

//The viewListOfAnimals() method
//Purpose: to get the list of animals from the
//current game and print them out to the screen.
//Parameters: none
//Returns: none
public void viewListOfAnimals()
{
    ArrayList<ListItem> animals = theGame.getAnimals();
        
        //System.out.println("There are " + n.getNumber() + " " + n.getName());
        System.out.println("\n\n        Inventory Report        ");
        System.out.printf("%n%-20s%10s", "Live Stock", "Quantity");
        System.out.printf("%n%-20s%10s", "-------------", "-----------");
        for(ListItem n: animals){
        System.out.printf("%n%-20s%5d", n.getName(), n.getNumber());
    }
    
}
public void saveListOfAnimals(ArrayList<ListItem> animals)
{
    String animalOutput;
    keyboard.nextLine();
    System.out.println("Please enter a file name");
    
    animalOutput = keyboard.nextLine();
    try (PrintWriter out = new PrintWriter(animalOutput))
    {
        System.out.println("\n\n        Inventory Report        ");
        System.out.printf("%n%-20s%10s", "Live Stock", "Quantity");
        System.out.printf("%n%-20s%10s", "-------------", "-----------");
        for(ListItem n: animals)
            {
                System.out.printf("%n%-20s%5d", n.getName(), n.getNumber());
            }
    }catch(Exception e)
    {
        System.out.println("\nThere was an error writing the list to disk ");
    }    
}

//The viewListOfTools() method
//Purpose: Creates a ViewList object and calls its
//displayMenuView() method
//Parameters: none
//Returns: none
public void viewListOfTools()
{
    ArrayList<ListItem> tools = theGame.getTools();
    for(ListItem n: tools){
        System.out.println("There are " + n.getNumber() + " " + n.getName());
    }
}

//The viewListOfProvisions() method
//Purpose: Creates a ViewList object and calls its
//displayMenuView() method
//Parameters: none
//Returns: none
public void viewListOfProvisions()
{
    ArrayList<ListItem> provisions = theGame.getProvisions();
    for(ListItem n: provisions){
        System.out.println("There are " + n.getNumber() + " " + n.getName());
    }
}

public void gameMenuView()
{
    System.out.println("Return to Game menu method");
}        

}


