// The CropControl class - part of the control layer
// class contains all of the calculation methods for managing the crops
// Author: Seth Huntley, Bruce Montgomery, Stanley Varner
// Date last modified: 2018.07.06
//-------------------------------------------------------------


package control;

import model.CropData;
import exceptions.CropException;
import java.util.Random;


public class CropControl
{
    //constants to calculate a random number between 17 and 25 to be used to calculate land cost
    private static final int LAND_BASE = 17;
    private static final int LAND_RANGE = 10;
    
    //constants to calculate random number between 1 and 100 for Amount of wheat eaten by rats
    private static final int RAT_BASE = 1;
    private static final int RAT_RANGE = 100;
    
    //constant to calculate a random number between 1 and 5 to be used to calculate the population growth
    private static final int PGRTH_BASE = 1;
    private static final int PGRTH_RANGE = 4;
    
    //constants to calculate a random number between 1 and 7 to be used to calculate the crop yield
    private static final int HARV_8TO12_BASE = 2;
    private static final int HARV_8TO12_RANGE = 3;
    private static final int HARV_0TO7_BASE = 1;
    private static final int HARV_0TO7_RANGE = 3;
    private static final int HARV_ABOVE12_BASE = 2;
    private static final int HARV_ABOVE12_RANGE = 4;
    
    //constants to calculate a random number between 3 and 10 to be used to calculate the bushels of wheat eaten by rats
    private static final int EBRS_8TO12_BASE = 3;
    private static final int EBRS_8TO12_RANGE = 4;
    private static final int EBRS_0TO7_BASE = 6;
    private static final int EBRS_0TO7_RANGE = 4;
    private static final int EBRS_ABOVE_BASE = 3;
    private static final int EBRS_ABOVE_RANGE = 2;
    
    //random number generator
    private static Random random = new Random();
    
// calcLandCost() method
// Purpose:  Calculate a random land cost between 17 and 26 bushels/acre
// Parameters: none
// Returns: the land cost
public static int calcLandCost()
{
    int landPrice = random.nextInt(LAND_RANGE) + LAND_BASE;
    return landPrice;
}

//calcRandomRatNumber() method
//Purpose: Calculate a random number between 1 and 100 to provide number to
//determine the amount of wheat eaten by rats
//Parameters: none
//Returns: random number
public static int calcRandomRatNumber()
{
    int ratNumber = random.nextInt(RAT_RANGE) + RAT_BASE;
    return ratNumber;
}

//calcGrowthNumber() method
//Purpose: Calculates a random number between 1 and 5 to prived a number to determine the population growth
public static int calcGrowthNumber()
{
    int populationGrowth = random.nextInt(PGRTH_RANGE) + PGRTH_BASE;
    return populationGrowth;
}



// The sellLand method
// Purpose: To sell land
// Parameters: the price of land, the number of acres to sell, and
// a reference to a CropData object
// Throws and exception if a pre-codition isn't met
// Pre-conditions: acres to sell must be positive
// and <= acresOwned
 public static void sellLand(int landPrice, int acresToSell, CropData cropData) throws CropException
 {
//  if acresToSell < 0, throw exception
    if(acresToSell < 0) {
        throw new CropException("A negative value was input.");
    }
//  if acresToSell > acresOwned, throw exception
    int owned = cropData.getacresOwned();    
    if(acresToSell > owned) {
        throw new CropException("You can't sell more land then you own.");
    }
//  acresOwned = acresOwned - acresToSell
    owned -= acresToSell;
    cropData.setacresOwned(owned);

//  wheatInStore = wheatInStore + acresToSell * landPrice
    int wheat = cropData.getwheatInStore();
    wheat -= (acresToSell * landPrice);
    cropData.setwheatInStore(wheat);
 }
/**
* The buyLand method
*Purpose:  To buy land
*@param landPrice the price of land
*@param acresToBuy the number of acres to buy.
*@param cropData reference to a CropData object
*@throws exception based on the precondition that isn't met.
* Pre-conditions:  the number of acres to be bought must be positive.
* The player must have enough wheat to purchase the number of acres desired.
* The city must have enough people to tend the land.
*/
public static void buyLand(int landPrice, int acresToBuy, CropData cropData) throws CropException
{
    
    int wheat = cropData.getwheatInStore();//get the current amount of wheatInStore and assign it to the wheat variable.
    int owned = cropData.getacresOwned();//get the current amount of acresOwned and assign it to the owned variable
    int pop = cropData.getpopulation();//get the current population and assign it to the pop variable
    
//  If acresToBuy < 0, throw exception
    if(acresToBuy < 0) {
        throw new CropException("A negative value was input");
    }
    
//  If acresToBuy * landPrice  > wheatInStore, throw exception      
    if(acresToBuy * landPrice > wheat) {
        throw new CropException("There is insufficient wheat to buy this much land.");
    }

//  If (acresToBuy + acresOwned)/10 > population, throw exception      
    if((acresToBuy + owned)/10 > pop) {
        throw new CropException("You don't have enough people to tend this much land");
    }
//  add the number of acres to buy to the current number of acres owned
    owned += acresToBuy;
    cropData.setacresOwned(owned);
      
//  deduct cost from the wheat in store
    wheat -= acresToBuy * landPrice;
    cropData.setwheatInStore(wheat);
}


/**
* The feedPeople method
* Author: Seth Huntley
*Purpose: Is it possible to feed the people with the wheat you have
*@param wheatForPeople the amount of what the people need
*@param cropData reference to a CropData object
*@throws CropException based on the precondition that isn't met.
*@return wheatForPeople
* Pre-conditions:  the number of wheat has to be positive.  Check that there's
* enough wheat to feed the people.
*/
public static int feedPeople(int wheatForPeople, CropData cropData) throws CropException {

// if wheatForPeople is less than 0, throw an exception
    if(wheatForPeople < 0) {
        throw new CropException("Wheat for People can't be a negative value");
    }

    int wheatInStore = cropData.getwheatInStore();
//  If wheatInStore is less than wheatForPeople throw an exception      
    if (wheatInStore < wheatForPeople ){
        throw new CropException("There's not enough what in storage.");
}
    
//  subtract the wheatForPeople from the wheatInStore and return the reaming wheatInStore
    wheatInStore -= wheatForPeople;
    cropData.setwheatInStore(wheatInStore);

//  set the wheatForPeople
    wheatForPeople += cropData.getwheatForPeople();
    cropData.setwheatForPeople(wheatForPeople);
     
    return wheatForPeople;
}

/**
* The Set Offering method
* Author: Stanley Varner
*Purpose:  Set aside wheat to pay tithes and offerings
*@param percentage of harvest to pay tithes  
*@ Save value entered by user
* Pre-conditions:  the tithe number must be positive.  The number needs to be not greater than 100
*/
public static void checkOffering(int tithe, CropData cropData) throws CropException {
    
    //check to see if offering is neg or above 100
    //if so print out to get new number
    if (tithe < 0 || tithe > 100){
        throw new CropException("Please enter a number between 0-100");
    }
    //if offering is between 0-100 then save/setoffering
    else {
        cropData.setoffering(tithe);
    }
    
}

/**
* The plantCrops method
* Author: Bruce Montgomery
*Purpose:  To determine how many acres of land to plant.
*@param acresToPlant the number of acres to plant.
*@param cropData reference to a CropData object
*@throws exception based on the precondition that isn't met.
* Pre-conditions:  the number of acres to be planted must be positive.  Check that the city has owns enough land to plant on.
* Verify that the city has enough wheat in storage to plant this many acres.
*/
public static void plantCrops(int acresToPlant, CropData cropData) throws CropException
{
//  If acresToPlant < 0, throw exception message
    if(acresToPlant < 0){
        throw new CropException("A negative value was input");
    }
//  If acresToPlant > acresOwned, throw exception message
    int owned = cropData.getacresOwned();
    if(acresToPlant > owned){
        throw new CropException("You don't own enough land");
    }
    
//  If wheatInStore < acresToPlant / 2, throw exception message
    int wheat = cropData.getwheatInStore();
    if(wheat < acresToPlant/2) {
        throw new CropException("You don't have enough wheat in storage to pay for planting this many acres");
    }
//  costToPlant = acresToPlant /2
    double costToPlant;
    costToPlant = acresToPlant/2;
    
//  wheatInStore = wheatInStore – costToPlant
    wheat -= costToPlant;
    cropData.setwheatInStore(wheat);
        
//  acresPlanted = acresToPlant
    cropData.setacresPlanted(acresToPlant);
 
}

// harvestCrops() method
// Purpose:  calculate the crop/wheat yielded per acre.  The crop yield is based on a
// random generated number based on three distinct tithing brackets.  After calculating
// the yield, get the amount of acres planted.  Multiply the yield * acres planted to get
// the amount of wheat harvested.
// Parameters: cropData reference to a CropData object
// Returns: the amount of wheat harvested.

public static int harvestCrops(CropData cropData)
{
    int offering = cropData.getoffering();
    int lvHarvest;
         
    if(offering < 8) {
        int yield = random.nextInt(HARV_0TO7_RANGE) + HARV_0TO7_BASE;
        cropData.setcropYield(yield);
        int acres = cropData.getacresPlanted();
        lvHarvest = yield * acres;
        cropData.setharvest(lvHarvest);
        System.out.println("You harvested " + lvHarvest + " bushels of wheat.");
        return lvHarvest;}
        
    if (offering >= 8 && offering <= 12) {
        int yield = random.nextInt(HARV_8TO12_RANGE) + HARV_8TO12_BASE;
        cropData.setcropYield(yield);
        int acres = cropData.getacresPlanted();
        lvHarvest = yield * acres;
        cropData.setharvest(lvHarvest);
        System.out.println("You harvested " + lvHarvest + " bushels of wheat.");
        return lvHarvest;}
    
    else {
        int yield = random.nextInt(HARV_ABOVE12_RANGE) + HARV_ABOVE12_BASE;
        cropData.setcropYield(yield);
        int acres = cropData.getacresPlanted();
        lvHarvest = yield * acres;
        cropData.setharvest(lvHarvest);
        System.out.println("You harvested " + lvHarvest + " bushels of wheat.");
        return lvHarvest;}
    
  }

//payOffering() method
//Purpose: To pay the amount of the offering that they player said they would pay. The offering is the percentage
//that was promised as tithing by the player.  This percentage will be removed from the harvest.
//Parameters: cropData reference to a CropData object
//Returns: nothing
public static void payOffering(CropData cropData)
{
    int offering = cropData.getoffering(); //get the offering
    int lvHarvest = cropData.getharvest(); //get the amount of wheat harvested.
    int payOffering = offering * lvHarvest / 100; //calculate how much wheat will need to be paid as an offering. Change to a percentage
    cropData.setofferingBushels(payOffering); //set the amount of tithing (in bushels of wheat) that was paid.
    lvHarvest = lvHarvest - payOffering; //this will be the new amount of wheat harvested after tithing is paid on it.
    cropData.setharvestAfterOffering(lvHarvest);//set the harvest amount after paying tithing on it.
    int wheatInStore = cropData.getwheatInStore() + lvHarvest;//get the current wheat in store and add the new harvested amount
    cropData.setwheatInStore(wheatInStore);//set the new amount of wheat in store
     
}

//calcWheatLostToRats() method
//Purpose: To find out how much wheat the rats ate/destroyed and subtract this from the Wheat in store
//if the randomly generated number between 1 & 100 is less than 30 then a perecentage of the wheat in store
//will be eaten based upon how much tithing was paid.
//Parameters: cropData reference to a CropData object
//Returns: nothing
public static void calcEatenByRats(CropData cropData)
{
    int randomRatNumber = calcRandomRatNumber(); //calculate the random rat number between 1 - 100
    int tithingPaid = cropData.getoffering();  //get the amount of tithing paid.
    int wheatInStore = cropData.getwheatInStore(); //get the amount of wheat in store
    
    
    if(randomRatNumber >= 30) //first check of the random generated number is above 30
        {
            cropData.seteatenByRats(0);
        }
    else if (tithingPaid < 8)  //if random generated number is less than 30 and tithingPaid is less than 8
        {
            int multiplier = random.nextInt(EBRS_0TO7_RANGE) + EBRS_0TO7_BASE;
            int eatenByRats = wheatInStore * multiplier / 100;
            cropData.seteatenByRats(eatenByRats);
            wheatInStore = wheatInStore - eatenByRats;
            cropData.setwheatInStore(wheatInStore);
        }
        
    else if (tithingPaid >= 8 && tithingPaid <=12) //if random generated number is less than 30 and tithingPaid is less >= 8 and <= 12
        {
            int multiplier = random.nextInt(EBRS_8TO12_RANGE) + EBRS_8TO12_BASE;
            int eatenByRats = wheatInStore * multiplier / 100;
            cropData.seteatenByRats(eatenByRats);
            wheatInStore = wheatInStore - eatenByRats;
            cropData.setwheatInStore(wheatInStore);
        }
    
    else 
        {
            int multiplier = random.nextInt(EBRS_ABOVE_RANGE) + EBRS_ABOVE_BASE; //all other conditions
            int eatenByRats = wheatInStore * multiplier / 100;
            cropData.seteatenByRats(eatenByRats);
            wheatInStore = wheatInStore - eatenByRats;
            cropData.setwheatInStore(wheatInStore);
        }
}

//calcPopulationGrowth() method
//Purpose: To grow the population based on generating a random number between 1 and 5 percent and multiplying that by the current population to get the population increase.
//Paramaters: cropData reference to a CropData object
//Returns: nothing
public static void growPopulation(CropData cropData)
{
    int randomGrowthNumber = calcGrowthNumber();//call method to generate number between 1 and 5
    int currentPopulation = cropData.getpopulation();//get current population
    int populationGrowth = currentPopulation * randomGrowthNumber / 100;//get the population growth, divide by 100 to change to a percentage number
    cropData.setnewPeople(populationGrowth);//set the number of new people that moved to the city
    int newPopulation = currentPopulation + populationGrowth;
    cropData.setpopulation(newPopulation);//set the new population
            
}

//calcPopulationDecrease() method
//Purpose: Calculate the number of people that starved to death and update the population of the city
//Paramaters: cropData reference to a CropData object
//Returns: nothing
public static void calcStarved(CropData cropData)
{
    int wheatSetAside = cropData.getwheatForPeople();  //Gets the amount of wheat set aside to feed the people for the year.
    int numThatCanBeFed = wheatSetAside/20; //Divides the wheat set aside by 20 to get how many people can be fed for the year (it takes 20 bushels of wheat per person per year).
    int currentPopulation = cropData.getpopulation(); //Gets current population.
    int numThatStarve = currentPopulation - numThatCanBeFed;//Get the number of people that starved by subtracting the number of people that "can" be fed from the current population
    
    if(numThatCanBeFed >= currentPopulation) //This is good no one starved
    {
        cropData.setnumStarved(0);
        cropData.setpeopleFed(currentPopulation);
    }
    else
    {
        cropData.setnumStarved(numThatStarve);//Sets the number of people that starved for the year
        cropData.setpeopleFed(numThatCanBeFed);//sets the number of people fed
        currentPopulation = currentPopulation - numThatStarve;//Updates the population by subtracting the number that starved from the population
        cropData.setpopulation(currentPopulation);//sets the current population
        
    }
    System.out.println("\n\n");
}

}
