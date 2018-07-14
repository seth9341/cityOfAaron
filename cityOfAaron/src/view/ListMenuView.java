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
import java.util.Scanner;

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
                   " 2 - View or save a list of animals\n" +
                   " 3 - View a list of tools\n" +
                   " 4 - View or save a list of provisions\n" +
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
                displayMenuView();
            case 2: // View a list of animals
                viewSaveListAnimals();
                displayMenuView();
            case 3: // View a list of tools
                viewListOfTools();
                displayMenuView();
            case 4: // View a list of provisions
                viewSaveListProvisions();
                displayMenuView();
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

//The viewSaveListAnimals() method
//Purpose:  To prompt the player to choose to view or save the animal list
//or return to the lists menu
//Paramaters: none
//Returns:  none
public void viewSaveListAnimals()
{
    int max = 3;
    int menuOption = 0;
    int userInput = 0;
    
    System.out.println("\n" +
                        "   What would you like to do?  \n\n" +
                        " 1 - View a list of animals\n" +
                        " 2 - Save a list of animlas to disk\n" +
                        " 3 - Return to Lists\n");
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
    
    else if(userInput ==2)
    {
        saveListOfAnimals();
    }
    else
    {
        displayMenuView();
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
        
        System.out.println("\n\n        Inventory Report        ");
        System.out.printf("%n%-20s%10s", " Animals", "Quantity");
        System.out.printf("%n%-20s%10s", "-------------", "-----------");
        for(ListItem n: animals){
        System.out.printf("%n%-20s%5d", n.getName(), n.getNumber());
        
    }
        System.out.println("\n\nPress ENTER to continue..."); //added this to stop the output from scrolling before you could read it
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    
}

//The saveListOfAnimals() method
//Purpose: to get the list of animals from the current game
//and save them to disk.  The player will be prompted for the filename
//Parameters:  none
//Returns: none
public void saveListOfAnimals()
{
    ArrayList<ListItem> animals = theGame.getAnimals();
    keyboard.nextLine();
    PrintWriter outFile = null;
    System.out.println("Please enter a file name\n\n");
    String fileName = keyboard.nextLine();  //will hold the file name from the player
    try 
    {
        outFile = new PrintWriter(fileName);  //create the PrintWriter object
        outFile.println("\n\n        Inventory Report        ");
        outFile.printf("%n%-20s%10s", "Live Stock", "Quantity");
        outFile.printf("%n%-20s%10s", "-------------", "-----------");
        for(ListItem n: animals) //loop through the animals array to get the data and output it
            {
                outFile.printf("%n%-20s%5d", n.getName(), n.getNumber());
            }
        outFile.flush();
        
    }catch(Exception e)
    {
        System.out.println("\nThere was an error writing the list to disk ");
    }
    finally 
    {
        if (outFile != null)
            try
            {
              outFile.close(); //close the file
            }catch (Exception e)
                {
                    System.out.println("Error closing file");
                }
    }
    System.out.println("\nYour file has been saved as " + fileName + "\n");
    Scanner scanner = new Scanner(System.in);
    scanner.nextLine();
 
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

//The viewSaveListProvisions() method
//Purpose:  To prompt the player to choose to view or save the provisions list
//or return to the lists menu
//Paramaters: none
//Returns:  none
public void viewSaveListProvisions()
{
    int max = 3;
    int menuOption = 0;
    int userInput = 0;
    
    System.out.println("\n" +
                        "   What would you like to do?  \n\n" +
                        " 1 - View a list of provisions\n" +
                        " 2 - Save a list of animlas to disk\n" +
                        " 3 - Return to Lists\n");
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
        viewListOfProvisions();
    }
    
    else if(userInput ==2)
    {
        saveListOfProvisions();
    }
    else
    {
        displayMenuView();
    }
       
}

//The viewListOfProvisions() method
//Purpose: to get the list of provisions from the
//current game and print them out to the screen.
//Parameters: none
//Returns: none
public void viewListOfProvisions()
{
    ArrayList<ListItem> provisions = theGame.getProvisions();
    
        System.out.println("\n\n        Inventory Report        ");
        System.out.printf("%n%-20s%10s", " Provisions", "Quantity");
        System.out.printf("%n%-20s%10s", "-------------", "-----------");
        for(ListItem n: provisions){
        System.out.printf("%n%-20s%5d", n.getName(), n.getNumber());
    }
        System.out.println("\n\nPress ENTER to continue..."); //added this to stop the output from scrolling before you could read it
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
}

//The saveListOfProvisions() method
//Purpose: to get the list of provisions from the current game
//and save them to disk.  The player will be prompted for the filename
//Parameters:  none
//Returns: none
public void saveListOfProvisions()
{
    ArrayList<ListItem> provisions = theGame.getProvisions();
    keyboard.nextLine();
    PrintWriter outFile = null;
    System.out.println("Please enter a file name\n\n");
    String fileName = keyboard.nextLine();  //will hold the file name from the player
    try 
    {
        outFile = new PrintWriter(fileName);  //create the PrintWriter object
        outFile.println("\n\n        Inventory Report        ");
        outFile.printf("%n%-20s%10s", "Provisions", "Quantity");
        outFile.printf("%n%-20s%10s", "-------------", "-----------");
        for(ListItem n: provisions) //loop through the provisions array to get the data and output it
            {
                outFile.printf("%n%-20s%5d", n.getName(), n.getNumber());
            }
        outFile.flush();
        
    }catch(Exception e)
    {
        System.out.println("\nThere was an error writing the list to disk ");
    }
    finally 
    {
        if (outFile != null)
            try
            {
              outFile.close(); //close the file
            }catch (Exception e)
                {
                    System.out.println("Error closing file");
                }
    }
    System.out.println("\nYour file has been saved as " + fileName + "\n");
    System.out.println("\n\nPress ENTER to continue..."); //added this to stop the output from scrolling before you could read it
    Scanner scanner = new Scanner(System.in);
    scanner.nextLine();
}


public void gameMenuView()
{
    //Create a GameMenuView instance called gmv
    GameMenuView gmv = new GameMenuView();
        
    //Call the displayMenuView method of the newly created mmv instance
    gmv.displayMenuView();
}        

}


