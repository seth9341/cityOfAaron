// The CropView class - part of the view layer
// Object of this class manages the crops
// Author: Seth Huntley, Bruce Montgomery, Stanley Varner
// Date last modified: June 2018
//-------------------------------------------------------------
package view;

import model.*;
import control.*;
import java.util.Scanner;
import cityofaaron.CityOfAaron;

public class CropView {
    
    //Create a Scanner object
    private static Scanner keyboard = new Scanner(System.in);
    
    //Get references to the Game object and the CropData object
    private static Game theGame = CityOfAaron.getTheGame();
    private static CropData cropData = theGame.getCropData();
    //store price variable here so the buyLandView and sellLandView methods can
    //use the same value
    private static int price = CropControl.calcLandCost();
    
    //The runCropsView method()
    //Purpose: runs the CropView methods in the correct order when the user
    //selects "Manage Crops" from the Game menu;
    //Parameters: none
    //Returns: none
    public static void runCropsView()
    {
        //call the buyLandView() method
        buyLandView();
        
        //call the feedPeopleView() method
        feedPeopleView();
    }
            
    
    //The buyLandView method
    //Purpose: interface with the user input for buying land
    //Parameters: none
    //Returns: none
    public static void buyLandView()
    {
               
        //Prompt the user to enter the number of acres to buy.
        System.out.format("Land is selling for %d bushels per acre.%n",price);
        System.out.print("\nHow many acres of land do you wish to buy? ");
        
        //Get the user's input and save it.
        int toBuy = keyboard.nextInt();
        
        //Call the buyland() method in the control layer to buy the land.
        CropControl.buyLand(price, toBuy, cropData);
    }
    
    //The feedPeopleView method
    //Author: Bruce Montgomery
    //Purpose:  Find out how much wheat to set aside to feed the people
    //Parameters: none
    //Returns: none
    public static void feedPeopleView()
    {
        //Get the total number of people in the city.
        int people = cropData.getpopulation();
        
        //Prompt the user to enter the number of acres to sell.
        System.out.println();
        System.out.println("The current population in the City of Aaron is " + people);
        System.out.print("\nHow many bushels of wheat would you like to allocate for feeding the people? ");
        
        //Get the user's input and saves it the toSell variable.
        int toSell = keyboard.nextInt();
        
        //Call the feedPeople() method in the control layer to feed the people. Passes the toSell, and cropData parameters
        CropControl.feedPeople(toSell, cropData);
    }
    
    
}
