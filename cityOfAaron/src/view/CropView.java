// The CropView class - part of the view layer
// Object of this class manages the crops
// Author: Seth Huntley, Bruce Montgomery, Stanley Varner
// Date last modified: June 2018
//-------------------------------------------------------------
package view;

import model.*;
import control.*;
import exceptions.CropException;
import java.util.Scanner;
import cityofaaron.CityOfAaron;

public class CropView {
    
    //Create a Scanner object
    private static Scanner keyboard = new Scanner(System.in);
    
    //Get references to the Game object and the CropData object
    private static Game theGame = CityOfAaron.getTheGame();
    private static CropData cropData = theGame.getCropData();
    //declare the price variable here for the buyLandView and sellLandView methods
    private static int price;
    
    //The runCropsView method()
    //Purpose: runs the CropView methods in the correct order when the user
    //selects "Manage Crops" from the Game menu;
    //Parameters: none
    //Returns: none
    public static void runCropsView()
    {
        //call the buyLandView() method
        buyLandView();
        
        //call the sellLandView() method
        sellLandView();
        
        //call the feedPeopleView() method
        feedPeopleView();
        
        //call the plantCropsView() method
        plantCropsView();
        
        //call the setOfferingView() method
        setOfferingView();
        
        //call the harvestCrops() method to calculate the amount of wheat harvested, no user input
        CropControl.harvestCrops(cropData);
        
        //call the payOffering() method to calculate how much wheat to pay as tithing, no user input
        CropControl.payOffering(cropData);
        
        //call the calcWheatLostToRats() method to calculate the amount of wheat lost to rats, no user input        
        CropControl.calcEatenByRats(cropData);
        
        //call the calcPopulationGrowth() method to calculate the number of people that moved into the city, no user input
        CropControl.growPopulation(cropData);
        
        //call the calcPopulationDecrease() method to calculate the population by subtracting from the population the number that starved, no user input
        CropControl.calcStarved(cropData);
        
        //call the cropsReportView() method that gathers all of the crops report data and displays it at the end of the game, no user input
        cropsReportView();
        
        System.out.println("\n\nPress ENTER to continue..."); //added this to stop the output from scrolling before you could read it
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        
    }
            
    
    //The cropReportView
    //Purpose:  view a report that displays the status for various crop and city data.
    //Parameters: none
    //Returns: none
    public static void cropsReportView()
    {
        System.out.println(cropData.toString());
    }
    
    //The buyLandView method
    //Purpose: interface with the user input for buying land
    //Parameters: none
    //Returns: none
    public static void buyLandView()
    {
        int price = CropControl.calcLandCost();
        int currentAcresOwned = cropData.getacresOwned();
        
        //Let the user know how much land is currently selling for.
         System.out.format("Land is selling for %d bushels per acre.%n",price);
                
        //Get the user's input and save it.
        int toBuy;
        boolean paramsNotOkay;
        
        do
        {
            paramsNotOkay = false;
            //Prompt the user to enter the number of acres to buy
            System.out.print("\nHow many acres of land do you wish to buy? ");
            toBuy = keyboard.nextInt();
            try  //the try block
            {    
                //Call the buyland() method in the control layer to buy the land.
                CropControl.buyLand(price, toBuy, cropData);
            }
            catch(CropException e)  //the catch block
            {
                System.out.println("I am sorry , I cannot do this. Try again.");
                System.out.println(e.getMessage());
                paramsNotOkay = true;
            }
        }while(paramsNotOkay);
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
        int toSell;
        boolean paramsNotOkay;
        do
        {
           paramsNotOkay = false;
           System.out.print("How many bushels of wheat do you want to set aside to feed the city? ");
           toSell = keyboard.nextInt();
           
           try {
               // Call the feedPeople( ) method in the control layer to buy the land
                CropControl.feedPeople(toSell,cropData);
           }
           catch(CropException e){
                System.out.println("Sorry, try again."); 
                System.out.println(e.getMessage()); 
                paramsNotOkay = true;
            }
        } while(paramsNotOkay);     
        
    }
    
    //The sellLandView method
    //Author: Stanely Varner
    //Purpose: interface with the user input for selling land
    //Parameters: none
    //Returns: none
    public static void sellLandView()
    {
        boolean paramsNotOkay;
        do
        {
            paramsNotOkay = false;
            //Prompt the user to enter the number of acres to sell.
            System.out.print("How many acres of new land do you want sell? ");
        
            //Get the user's input and save it.
            int toSell = keyboard.nextInt();
            
            try
            {        
                //Call the sellLand() method in the control layer to sell the land.
                CropControl.sellLand(price, toSell, cropData);
            }
            catch(CropException e)
            {
                System.out.println("I am sorry, I cannot do this");
                System.out.println(e.getMessage());
                paramsNotOkay = true;
            }
        }while (paramsNotOkay);
    }
    
    //The plantCropsView method
    //Author: Seth Huntley
    //Purpose: interface with the user input for planting crops
    //Parameters: none
    //Returns: none  
    public static void plantCropsView()
    {
        boolean paramsNotOkay;
        do
        {
            paramsNotOkay = false;               
            // Prompt the user for the amount of wheat to plant
            System.out.print("How much wheat would you like to plant? ");
        
            // Get input from the user and save it
            int acresPlanted = keyboard.nextInt();
        
            try
            {
                // Call the plantCrops() method to plant crops to harvest.
                CropControl.plantCrops(acresPlanted, cropData);
            }
        
            catch(CropException e)
            {
                System.out.println("I am sorry, I cannot do this");
                System.out.println(e.getMessage());
                paramsNotOkay = true;
            }
        }while(paramsNotOkay);
    }
        
            
    
    //The showStarvedView method
    //Author: Seth Huntley
    //Purpose: determine how many people starved because of poor planning
    //Parameters: none
    //Returns: none
     public static void showStarvedView(){
    //How many people starved due to your choices? 
     int starved = cropData.getnumStarved();
           System.out.println("\n" + starved + " people have starved due to your incompetance!");
                 
    } 
     
     //The setOffering method
    //Author: Stanely Varner
    //Purpose: interface with the user input for setting offering
    //Parameters: none
    //Returns: none
    public static void setOfferingView()
    {
        boolean paramsNotOkay;
        do
        {
            paramsNotOkay = false;
            //Prompt the user to enter the percentage to pay in tithes and offerings.
            System.out.print("What percentage of your harvest do you want to pay in tithes and offerings? ");
        
            //Get the user's input and save it.
            int tithe = keyboard.nextInt();
            
            try
            {        
                //Call the checkOffering() method in the control layer to set the offering amount.
                CropControl.checkOffering(tithe, cropData);
            }
            catch(CropException e)
            {
                System.out.println("I'm sorry, invalid input. ");
                System.out.println(e.getMessage());
                paramsNotOkay = true;
            }
        }while (paramsNotOkay);
    }


}
