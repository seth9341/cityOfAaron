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

}


