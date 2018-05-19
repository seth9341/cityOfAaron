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
    private int numberWhoDIed;
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
            public void setyear(int _year) {
                    year = _year;
            }
            public int getpopulation() {
                    return population;
            }
            public void setpopulation(int _population) {
                    population = _population;
            }
            public int getacresOwned() {
                    return acresOwned;
            }
            public void setacresOwned(int _acresOwned) {
                    acresOwned = _acresOwned;
            }
            public int getcropYield() {
                    return cropYield;
            }
            public void setcropYield(int _cropYield) {
                    cropYield = _cropYield;
            }
            public int getwheatInStore() {
                    return wheatInStore;
            }
            public void setwheatInStore(int _wheatInStore) {
                    wheatInStore = _wheatInStore;
            }
            public int getnumberWhoDIed() {
                    return numberWhoDIed;
            }
            public void setnumberWhoDIed(int _numberWhoDIed) {
                    numberWhoDIed = _numberWhoDIed;
            }
            public int getnewPeople() {
                    return newPeople;
            }
            public void setnewPeople(int _newPeople) {
                    newPeople = _newPeople;
            }
            public int getharvest() {
                    return harvest;
            }
            public void setharvest(int _harvest) {
                    harvest = _harvest;
            }
            public int getharvestAfterOffering() {
                    return harvestAfterOffering;
            }
            public void setharvestAfterOffering(int _harvestAfterOffering) {
                    harvestAfterOffering = _harvestAfterOffering;
            }
            public int getoffering() {
                    return offering;
            }
            public void setoffering(int _offering) {
                    offering = _offering;
            }
            public int getofferingBushels() {
                    return offeringBushels;
            }
            public void setofferingBushels(int _offeringBushels) {
                    offeringBushels = _offeringBushels;
            }
            public int getpeopleFed() {
                    return peopleFed;
            }
            public void setpeopleFed(int _peopleFed) {
                    peopleFed = _peopleFed;
            }
            public int getacresPlanted() {
                    return acresPlanted;
            }
            public void setacresPlanted(int _acresPlanted) {
                    acresPlanted = _acresPlanted;
            }
            public int getnumStarved() {
                    return numStarved;
            }
            public void setnumStarved(int _numStarved) {
                    numStarved = _numStarved;
            }
            public int geteatenByRats() {
                    return eatenByRats;
            }
            public void seteatenByRats(int _eatenByRats) {
                    eatenByRats = _eatenByRats;
            }
            public int getwheatForPeople() {
                    return wheatForPeople;
            }
            public void setwheatForPeople(int _wheatForPeople) {
                    wheatForPeople = _wheatForPeople;
            }

}