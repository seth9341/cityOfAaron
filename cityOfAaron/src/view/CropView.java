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
    
    //The runCropsView method()
    //Purpose: runs the CropView methods in the correct order when the user
    //selects "Manage Crops" from the Game menu;
    //Parameters: none
    //Returns: none
    public static void runCropsView()
    {
        //call the buyLandView() method
        buyLandView();
    }
            
    
    //The buyLandView method
    //Purpose: interface with the user input for buying land
    //Parameters: none
    //Returns: none
    public static void buyLandView()
    {
        //Get the cost of land for this round.
        int price = CropControl.calcLandCost();
        
        //Prompt the user to enter the number of acres to buy.
        System.out.format("Land is selling for %d bushels per acre.%n",price);
        System.out.print("\nHow many acres of land do you wish to buys?");
        
        //Get the user's input and save it.
        int toBuy = keyboard.nextInt();
        
        //Call the buyland() method in the control layer to buy the land.
        CropControl.buyLand(price, toBuy, cropData);
    }
    
}
