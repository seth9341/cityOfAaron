// The GameControl class - part of the control layer
// class contains all of the calculation methods for managing the crops
// Author: Seth Huntley, Bruce Montgomery, Stanley Varner
// Date last modified: 2018.06.25
//----
package control;

import java.util.ArrayList;
import java.io.*;
import cityofaaron.CityOfAaron;
import model.*;

public class GameControl {
    
    //size of the Locations array/map
    private static final int MAX_ROW = 5;
    private static final int MAX_COL = 5;
    
    //reference to a Game object
    private static Game theGame;
    
    public static void createNewGame(String pName)
    {
        //Created the game object. Save it in the main driver file
        theGame = new Game();
        CityOfAaron.setTheGame(theGame);

        //create the player object. Save it in the game object
        Player thePlayer = new Player();
        thePlayer.setName(pName);
        theGame.setThePlayer(thePlayer);

        createCropDataObject();
        createAnimalList();
        createToolList();
        createProvisionList();
        createMap();
        createDevTeam();
    }
    
    //the getSavedGame method
    //Purpose: load a saved game from disk
    //Parameters: the file path
    //Returns: none
    //Side Effect: the game reference in the driver is updated
    public static void getSavedGame(String filePath)
    {
        Game theGame = null;
        try(FileInputStream fips = new FileInputStream(filePath))
        {
            ObjectInputStream input = new ObjectInputStream(fips);
            theGame = (Game) input.readObject();
            CityOfAaron.setTheGame(theGame);
        }
        catch(Exception e)
        {
            System.out.println("\nThere was an error reading the saved game file");
        }
    }
    
    //the setSaveGame method
    //Purpose: save a game to disk
    //Parameters: the file name/path
    //Returns: none
    public static void setSavedGame(String filePath, Game theGame)
    {
        try(FileOutputStream fops = new FileOutputStream(filePath))
        {
            ObjectOutputStream output = new ObjectOutputStream(fops);
            output.writeObject(theGame);
        }
        catch(Exception e)
        {
            System.out.println("\nThere was an error writing the saved game file");
        }
    }
  
    //create the CropData object method
    public static void createCropDataObject()
    {
        CropData cropData = new CropData();

        //initialize new CropData object
        cropData.setyear(0);
        cropData.setpopulation(100);
        cropData.setnewPeople(5);
        cropData.setcropYield(3);
        cropData.setnumberWhoDied(0);
        cropData.setoffering(10);
        cropData.setwheatInStore(2700);
        cropData.setacresOwned(1000);
        cropData.setacresPlanted(1000);
        cropData.setharvest(3000);
        cropData.setofferingBushels(300);
        cropData.setacresPlanted(1000);

        theGame.setCropData(cropData);
    
    }   
    
    //create the list of animals
    public static void createAnimalList()
    {
        ArrayList<ListItem>animals = new ArrayList<>();
    
        animals.add(new ListItem("chickens",20));
        animals.add(new ListItem("cows", 7));
        animals.add(new ListItem("cats", 4));
        animals.add(new ListItem("mules", 3));
        animals.add(new ListItem("horses", 11));
        animals.add(new ListItem("pigs", 15));
        animals.add(new ListItem("sheep", 17));
        
       theGame.setAnimals(animals);
        
    }
    
    //create the list of tools
    public static void createToolList()
    {
        ArrayList<ListItem> tools = new ArrayList<>();
    
        tools.add(new ListItem("plows", 3));
        tools.add(new ListItem("shovels", 10));
        tools.add(new ListItem("wire cutters", 6));
        tools.add(new ListItem("fence post hole diggers", 4));
       
        theGame.setTools(tools);
        
    }
    
    //create the list of provisions
    public static void createProvisionList()
    {
        ArrayList<ListItem> provisions = new ArrayList<>();
        
        provisions.add(new ListItem("gloves", 20));
        provisions.add(new ListItem("water bottles", 200));
        provisions.add(new ListItem("flour", 400));
        provisions.add(new ListItem("bacon", 300));
        provisions.add(new ListItem("cloth", 10000));

        theGame.setProvisions(provisions);
        
    }


    //create the list of developers
    public static void createDevTeam()
    {
        ArrayList<ListItem> developers = new ArrayList<>();
        
        developers.add(new ListItem("Bruce Montgomery", 1));
        developers.add(new ListItem("Stanley Varner", 1));
        developers.add(new ListItem("Seth Huntley", 1));

        theGame.setDevelopers(developers);
        
    }


    
    //The createMap method
    //Purpose: creates the location objects and the map
    //Parameters: none
    //Returns: none
    public static void createMap()
    {
        Map theMap = new Map(MAX_ROW,MAX_COL);
        
        //define a string that will go in the Location objects that contain the river
        String river = "\nYou are on the River. The river is the source" +
                "\nof life for our city. The river marks the easter" +
                "\nboundary of the city - it is wilderness to the East.";
        
        //create a new Location object
        Location loc = new Location();
        
        //use setters in the Location class to set the description and symbol
        loc.setDescription(river);
        loc.setSymbol("~~~~");
        
        //set this location object in each cell of the array in column 4
        for(int i = 0; i<MAX_ROW; i++)
        {
            theMap.setLocation(i, 4, loc);
        }
        
        //define the string for a farmland location
        String farmland = "\nYou are on the fiertile banks of the River." +
                "\nIn the spring this low farmland floods and is covereed with rich" +
                "\nnew soil. Wheat is planted as far as you can see.";
        
        //set a farmland location with a hint
        loc = new Location();
        loc.setDescription(farmland + "\nOne bushel will plant two acres of wheat.");
        loc.setSymbol("!!!!");
        theMap.setLocation(0,2, loc);
        
        //define the string for the desert location
        String desert = "\nYou are in the desert! The temperatures during the day" +
                "\ncan reach 130 degrees. Be very careful here!";
        
        //set desert location
        loc = new Location();
        loc.setDescription(desert);
        loc.setSymbol("----");
        
        //set this location object in row 0,1,2 in column 0
        for(int i =0; i<3; i++)
        {
            theMap.setLocation(i, 0, loc);
        }
        
        // define the string for the Ruler's Court
        String court = "\nYou've found yourself in the Ruler's Court" +
                "\nbeware lest you offend him with your manners!";

        //set The Ruler's Court location
        loc = new Location();
        loc.setDescription(court);
        loc.setSymbol("$$$$");

        // set this location object in row 0 in column 1
        {
          theMap.setLocation(0, 1, loc);
        }

        // define the string for the Granary and Storehouse
        String granary = "\nYou've found a granary and storehouse" +
                "\nthis is where your crops will be stored after the harvest";

        // set the location for the granary and storehouse
        loc = new Location();
        loc.setDescription(granary);
        loc.setSymbol("||||");

        // set this location object in row 1 in column 1
        {
          theMap.setLocation(1, 1, loc);
        }

        //define the string for the village location
        String village = "\nYou found the village!";

        // set the location for the village
        loc = new Location();
        loc.setDescription(village + "20 Bushels to feed 1 person");
        loc.setSymbol("^^^^");
      
        //set this location object in row 2, 3 & in column 1
        for(int i =2; i<4; i++)
        {
            theMap.setLocation(i, 1, loc);
        }
      
        //define the string for the Lamanite Land Border
        String border = "\nThis is the border of the land with the Lamanites!" +
                "\nBe careful about hanging around here";

        // set the location for the Lamanite Land border
        loc = new Location();
        loc.setDescription(border);
        loc.setSymbol(":(:(");
      
        //set this location object in row 3, 4 & in column 0
        for(int i =3; i<5; i++)
        {
            theMap.setLocation(i, 0, loc);
        }
      
        //define the string for Undeveloped land
        String undeveloped = "\nThis area isn't developed yet.";

        // set the location for the village
        loc = new Location();
        loc.setDescription(undeveloped);
        loc.setSymbol("MMMM");
      
        //set this location object in row 4 &  column 1, 2, & 3
        for(int i =1; i<4; i++)
        {
            theMap.setLocation(4, i, loc);
        }
        
        //define the string for the Rameumpton historical location
        String rameumpton = "\nYou are on the site of an historical reprsentation of the Rameumpton" +
                "\nThis historical replication of the Rameumpton reminds the people of the city of Aaron" +
                "\nthat following Gods commandments will keep them safe.";
        
        //set the Rameumpton location
        loc = new Location();
        loc.setDescription(rameumpton);
        loc.setSymbol("****");
        theMap.setLocation(1,2, loc);
        
        //define the string for the Outdoor amphitheater location
        String amphitheater = "\nYou are in a natural amphitheater where the people of the city of Aaron" +
                "\nand people from all across the land come to be entertained by some of the greatest traveling" +
                "\ntheatrical groups in the Land of the Nephites.";
        
        //set the Amphitheater location
        loc = new Location();
        loc.setDescription(amphitheater);
        loc.setSymbol("####");
        theMap.setLocation(2,2, loc);
        
        //define the string for the soldiers quarters location
        String soldierQuarters = "\nHere you see the quarters where soldiers are housed in times of war." +
        "\nIn times of war there areas for medical treatment, training and downtime.";
        
        //set the soldiers quarters location
        loc = new Location();
        loc.setDescription(soldierQuarters);
        loc.setSymbol("&&&&");
        theMap.setLocation(3,2, loc);
        
        //define the string for the bakery location
        String bakery = "\nYou are in the bakery where you can smell delicious bread. The people of Aaron" +
                "\nlove the bakery and the smells bring them joy to their souls.";
        
        // set the location of the bakery
        loc = new Location();
        loc.setDescription(bakery);
        loc.setSymbol("@@@@");
        theMap.setLocation(0, 3, loc);        
        
        //define the string for the villageGarden location
        String villageGarden = "\nYou are in the village rose garden. It has lots of colorful roses. " +
                "\nThe garden is beautiful and hosts many weddings.";
        
        // set the location of the villageGarden
        loc = new Location();
        loc.setDescription(villageGarden);
        loc.setSymbol("%%%%");
        theMap.setLocation(1, 3, loc);  
        
        //define the string for the temple location
        String temple = "\nYou are at the temple of doom. Peasants are allowed to worship here." +
                "\nFrom this temple you can overlook the beautiful rose garden.";
        
        // set the location of the temple
        loc = new Location();
        loc.setDescription(temple);
        loc.setSymbol("!**!");
        theMap.setLocation(2, 3, loc);
        
        //define the string for the palace location
        String palace = "\nYou are at the Palace. This is an ancient Palace used by Emperors for hundreds of years."; 
        
        // set the location of the palace
        loc = new Location();
        loc.setDescription(palace);
        loc.setSymbol("##!!");
        theMap.setLocation(3, 3, loc);
        
        theGame.setTheMap(theMap);
    }
    
}


