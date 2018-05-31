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
     //if acresToSell < 0, return -1
    if(acresToSell < 0)
        return -1;

//if acresToSell > acresOwned, return -1
int owned = cropData.getacresOwned();
if(acresToSell > owned)
    return -1;

//acresOwned = acresOwned - acresToSell
owned -= acresToSell;
cropData.setacresOwned(owned);

//wheatInStore = wheatInStore + acresToSell * landPrice
int wheat = cropData.getwheatInStore();
wheat -= (acresToSell * landPrice);
cropData.setwheatInStore(wheat);

//return acresOwned
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
//    If acresToBuy < 0, return -1
      if(acresToBuy < 0)
          return -1;
         
//    If acresToBuy * landPrice  > wheatInStore, return -1
      int wheat = cropData.getwheatInStore();
      if(acresToBuy * landPrice > wheat)
          return -1;
      
//    If (acresToBuy + acresOwned)/10 > population, return -1
      int owned = cropData.getacresOwned();
      int pop = cropData.getpopulation();
      if((acresToBuy + owned)/10 > pop)
          return -1;
      
//    acresOwned = acresOwned + acresToBuy
      owned += acresToBuy;
      cropData.setacresOwned(owned);
      
//    wheatInStore = wheatInStore – (acresToBy * landPrice
      wheat -= acresToBuy * landPrice;
      cropData.setwheatInStore(wheat);
      
//    return acresOwned
      return owned;
}

// test feedpeople
public int feedPeople(int wheatForPeople, CropData cropData) {
//check to see if there's any wheatForPeopla at all, and if not, return -1
  if(wheatForPeople < 0)
    return -1;
//check to see if there's more what in storage than what the people need, if not, then return -1
int wheat = cropData.getwheatInStore();
  if(wheat < wheatForPeople)
    return -1;
//subtract the wheatForPeople from the wheatInStore and return the reaming wheatInStore
  wheat -= wheatForPeople;
     cropData.setwheatInStore(wheat);
//set the wheatForPeople
     cropData.setwheatInStore(wheat);
     return wheat;
}
}