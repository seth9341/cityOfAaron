// The CropControl class - part of the control layer
// class contains all of the calculation methods for managing the crops
// Author: Seth Huntley, Bruce Montgomery, Stanley Varner
// Date last modified: 2018.05.30
//-------------------------------------------------------------


package control;

import model.CropData;
import java.util.Random;


public class CropControl
{
    
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
public static int buyLand(int landPrice, int acresToBuy, CropData cropData)
{
//  If acresToBuy < 0, return -1
    if(acresToBuy < 0) {
        return -1;
    }
//  If acresToBuy * landPrice  > wheatInStore, return -1
    int wheat = cropData.getwheatInStore();
      
    if(acresToBuy * landPrice > wheat) {
        return -1;
    }
//  If (acresToBuy + acresOwned)/10 > population, return -1
    int owned = cropData.getacresOwned();
    int pop = cropData.getpopulation();
      
    if((acresToBuy + owned)/10 > pop) {
        return -1;
    }
//  acresOwned = acresOwned + acresToBuy
    owned += acresToBuy;
    cropData.setacresOwned(owned);
      
//  wheatInStore = wheatInStore – (acresToBy * landPrice
    wheat -= acresToBuy * landPrice;
    cropData.setwheatInStore(wheat);
      
//  return acresOwned
    return owned;
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
public int feedPeople(int wheatForPeople, CropData cropData) {
//  check to see if there's any wheatForPeopla at all, and if not, return -1
    if(wheatForPeople < 0) {
        return -1;
    }
    
//  check to see if there's more what in storage than what the people need, if not, then return -1
    int wheat = cropData.getwheatInStore();
  
    if(wheat < wheatForPeople) {
        return -1;
    }
    
//  subtract the wheatForPeople from the wheatInStore and return the reaming wheatInStore
    wheat -= wheatForPeople;
    cropData.setwheatInStore(wheat);
//  set the wheatForPeople
    cropData.setwheatForPeople(wheat);
     
    return wheat;
}

/**
* The plantCrops method
* Author: Bruce Montgomery
*Purpose:  To determine how many acres of land to plant.
*@param acresToPlant the number of acres to plant.
*@param cropData reference to a CropData object
*@return the amount of acres of land to plant
* Pre-conditions:  the number of acres to be planted must be positive.  Check that the city has owns enough land to plant on.  Verify that the city has enough wheat in storage to plant this many acres.
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
    
//  acresPlanted = acresToPlant
    cropData.setacresPlanted(acresToPlant);
    
//  return acresPlanted
    return cropData.getacresPlanted();
}
}
