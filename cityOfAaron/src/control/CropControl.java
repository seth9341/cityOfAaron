// The CropControl class - part of the control layer
// class contains all of the calculation methods for managing the crops
// Author: Seth Huntley, Bruce Montgomery, Stanley Varner
// Date last modified: 2018.05.30
//-------------------------------------------------------------


package control;

import model.CropData;
import exceptions.CropException;
import exceptions.FeedPeopleException;
import java.util.Random;


public class CropControl
{
    //constants to calculate land cost
    private static final int LAND_BASE = 17;
    private static final int LAND_RANGE = 10;
    
    //constants to calculate crop yield
    private static final int HARV_8TO12_BASE = 2;
    private static final int HARV_8TO12_RANGE = 3;
    private static final int HARV_0TO7_BASE = 1;
    private static final int HARV_0TO7_RANGE = 3;
    private static final int HARV_ABOVE12_BASE = 2;
    private static final int HARV_ABOVE12_RANGE = 4;
    
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




// The sellLand method
// Purpose: To sell land
// Parameters: the price of land, the number of acres to sell, and
//    a reference to a CropData object
// Returns: the number of acres owned after the sale
// Pre-conditions: acres to sell must be positive
// and <= acresOwned
 public static int sellLand(int landPrice, int acresToSell, CropData cropData)
 {
//  if acresToSell < 0, return -1
    if(acresToSell < 0) {
        return -1;
    }
//  if acresToSell > acresOwned, return -1
    int owned = cropData.getacresOwned();
    
    if(acresToSell > owned) {
        return -1;
    }
//  acresOwned = acresOwned - acresToSell
    owned -= acresToSell;
    cropData.setacresOwned(owned);

//  wheatInStore = wheatInStore + acresToSell * landPrice
    int wheat = cropData.getwheatInStore();
    wheat -= (acresToSell * landPrice);
    cropData.setwheatInStore(wheat);

//  return acresOwned
    return owned;

 }
/**
* The buyLand method
*Purpose:  To buy land
*@param landPrice the price of land
*@param acresToBuy the number of acres to buy.
*@param cropData reference to a CropData object
*@return the amount of land after the buy
* Pre-conditions:  the number of acres to be bought must be positive.
* The player must have enough wheat to purchase the number of acres desired.
* The city must have enough people to tend the land.
*/
public static void buyLand(int landPrice, int acresToBuy, CropData cropData) throws CropException
{
//  If acresToBuy < 0, throw exception
    if(acresToBuy < 0) {
        throw new CropException("A negative value was input");
    }
//  get the current amount of wheatInStore and assign it to the wheat variable.
    int wheat = cropData.getwheatInStore();
    
//  If acresToBuy * landPrice  > wheatInStore, throw exception      
    if(acresToBuy * landPrice > wheat) {
        throw new CropException("There is insufficient wheat to buy this much land.");
    }

//  get the 
    int owned = cropData.getacresOwned();
    int pop = cropData.getpopulation();
    
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
      
//  return acresOwned
 //   return owned;
}


/**
* The feedPeople method
* Author: Seth Huntley
*Purpose: Is it possible to feed the people with the wheat you have
*@param wheatForPeople the amount of what the people need
*@param cropData reference to a CropData object
*@return the amount of wheat
* Pre-conditions:  the number of wheat has to be positive.  Check that there's
* enough wheat to feed the people.
*/
public static int feedPeople(int wheatForPeople, CropData cropData) throws FeedPeopleException {

// if wheatForPeople is less than 0, throw an exception
    if(wheatForPeople < 0) {
        throw new FeedPeopleException("Wheat for People can't be a negative value");
    }

    int wheatInStore = cropData.getwheatInStore();
//  If wheatInStore is less than wheatForPeople throw an exception      
    if (wheatInStore < wheatForPeople ){
        throw new FeedPeopleException("There's not enough what in storage to meet the needs of the people.");
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
public static int checkOffering(int tithe, CropData cropData) {
    
    //check to see if offering is neg or above 100
    //if so print out to get new number
    if (tithe < 0 || tithe > 100){
        System.out.println("Please enter a number between 0-100");
        return -1;
    }
    //if offering is between 0-100 then save/setoffering
    else {
        cropData.setoffering(tithe);
    }
    return tithe;
    
}

/**
* The plantCrops method
* Author: Bruce Montgomery
*Purpose:  To determine how many acres of land to plant.
*@param acresToPlant the number of acres to plant.
*@param cropData reference to a CropData object
*@return the amount of acres of land to plant
* Pre-conditions:  the number of acres to be planted must be positive.  Check that the city has owns enough land to plant on.
* Verify that the city has enough wheat in storage to plant this many acres.
*/
public static int plantCrops(int acresToPlant, CropData cropData)
{
//  If acresToPlant < 0, return -1
    if(acresToPlant < 0){
        return -1;
    }
//  If acresToPlant > acresOwned, return -1
    int owned = cropData.getacresOwned();
    if(acresToPlant > owned){
        return -1;
    }
    
//  If wheatInStore < acresToPlant / 2 return -1
    int wheat = cropData.getwheatInStore();
    if(wheat < acresToPlant/2) {
        return -1;
    }
//  costToPlant = acresToPlant /2
    double costToPlant;
    costToPlant = acresToPlant/2;
    
//  wheatInStore = wheatInStore – costToPlant
    wheat -= costToPlant;
    cropData.setwheatInStore(wheat);
    System.out.println("There are " + wheat + " bushels of wheat in storage");
    
//  acresPlanted = acresToPlant
    cropData.setacresPlanted(acresToPlant);
    
//  return acresPlanted
    return cropData.getacresPlanted();
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
    System.out.println("The offering is " + offering);
    
  
    if(offering < 8) {
        int yield = random.nextInt(HARV_0TO7_RANGE) + HARV_0TO7_BASE;
        System.out.println("the yield is " + yield);
        int acres = cropData.getacresPlanted();
        lvHarvest = yield * acres;
        cropData.setharvest(lvHarvest);
        System.out.println("You harvested " + lvHarvest + " bushels of wheat.");
        return lvHarvest;}
    
    
    if (offering >= 8 && offering <= 12) {
        int yield = random.nextInt(HARV_8TO12_RANGE) + HARV_8TO12_BASE;
        System.out.println("the yield is " + yield);
        int acres = cropData.getacresPlanted();
        lvHarvest = yield * acres;
        cropData.setharvest(lvHarvest);
        System.out.println("You harvested " + lvHarvest + " bushels of wheat.");
        return lvHarvest;}
    
    else {
        int yield = random.nextInt(HARV_ABOVE12_RANGE) + HARV_ABOVE12_BASE;
        System.out.println("the yield is " + yield);
        int acres = cropData.getacresPlanted();
        lvHarvest = yield * acres;
        cropData.setharvest(lvHarvest);
        System.out.println("You harvested " + lvHarvest + " bushels of wheat.");
        return lvHarvest;}
    
  

}
}
