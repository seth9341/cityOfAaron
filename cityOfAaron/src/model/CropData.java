/*
 * The CropData Class file for the cityOfAaron project
 * CIT-260
 * Spring 2018
 * Authors: Seth Huntley
*/

package model;


import java.io.Serializable;

public class CropData implements Serializable {

    //Class instance variables
    private int year;
    private int population;
    private int acresOwned;
    private int cropYield;
    private int wheatInStore;
    private int numberWhoDied;
    private int newPeople;
    private int harvest;
    private int harvestAfterOffering;
    private int offering;
    private int offeringBushels;
    private int peopleFed;
    private int acresPlanted;
    private int numStarved;
    private int eatenByRats;
    private int wheatForPeople;

    public CropData() {}

            public int getyear() {
                    return year;
            }
            public void setyear(int year) {
                    this.year = year;
            }
            public int getpopulation() {
                    return population;
            }
            public void setpopulation(int population) {
                    this.population = population;
            }
            public int getacresOwned() {
                    return acresOwned;
            }
            public void setacresOwned(int acresOwned) {
                    this.acresOwned = acresOwned;
            }
            public int getcropYield() {
                    return cropYield;
            }
            public void setcropYield(int cropYield) {
                    this.cropYield = cropYield;
            }
            public int getwheatInStore() {
                    return wheatInStore;
            }
            public void setwheatInStore(int wheatInStore) {
                    this.wheatInStore = wheatInStore;
            }
            public int getnumberWhoDied() {
                    return numberWhoDied;
            }
            public void setnumberWhoDied(int numberWhoDied) {
                    this.numberWhoDied = numberWhoDied;
            }
            public int getnewPeople() {
                    return newPeople;
            }
            public void setnewPeople(int newPeople) {
                    this.newPeople = newPeople;
            }
            public int getharvest() {
                    return harvest;
            }
            public void setharvest(int harvest) {
                    this.harvest = harvest;
            }
            public int getharvestAfterOffering() {
                    return harvestAfterOffering;
            }
            public void setharvestAfterOffering(int harvestAfterOffering) {
                    this.harvestAfterOffering = harvestAfterOffering;
            }
            public int getoffering() {
                    return offering;
            }
            public void setoffering(int offering) {
                    this.offering = offering;
            }
            public int getofferingBushels() {
                    return offeringBushels;
            }
            public void setofferingBushels(int offeringBushels) {
                    this.offeringBushels = offeringBushels;
            }
            public int getpeopleFed() {
                    return peopleFed;
            }
            public void setpeopleFed(int peopleFed) {
                    this.peopleFed = peopleFed;
            }
            public int getacresPlanted() {
                    return acresPlanted;
            }
            public void setacresPlanted(int acresPlanted) {
                    this.acresPlanted = acresPlanted;
            }
            public int getnumStarved() {
                    return numStarved;
            }
            public void setnumStarved(int numStarved) {
                    this.numStarved = numStarved;
            }
            public int geteatenByRats() {
                    return eatenByRats;
            }
            public void seteatenByRats(int eatenByRats) {
                    this.eatenByRats = eatenByRats;
            }
            public int getwheatForPeople() {
                    return wheatForPeople;
            }
            public void setwheatForPeople(int wheatForPeople) {
                    this.wheatForPeople = wheatForPeople;
            }

    @Override
    public String toString() {
        return  "\t\t Annual Report\n" +
                "You have been ruling for: " + year + " years\n" +
                "The number of citizens who starved to death this year: "  + numStarved + "\n" +
                "The number of new people that moved into the city this year: " + newPeople + "\n" +
                "The current population: " + population + "\n" +
                "The number of acres of crop land owned by the city: " + acresOwned + "\n" +
                "The number of bushels per acre in this years harvest: " + cropYield + "\n" +
                "The total number of bushels of wheat harvested: " + harvest + "\n" +
                "The number of bushels paid in tithes and offerings: " + offeringBushels + "\n" +
                "The number of bushels of wheat eaten by rats: " + eatenByRats + "\n" +
                "The number of bushels of wheat in store: " + wheatInStore + "\n";
                }
                
                
                
              
            
            

}
