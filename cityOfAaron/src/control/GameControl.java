// The GameControl class - part of the control layer
// class contains all of the calculation methods for managing the crops
// Author: Seth Huntley, Bruce Montgomery, Stanley Varner
// Date last modified: 2018.06.25
//----
package control;

import java.util.ArrayList;
import cityofaaron.CityOfAaron;
import model.*;

public class GameControl {
    
    //size of the Locations array
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
    
        animals.add(new ListItem("chickens",10));
        animals.add(new ListItem("cows", 7));
        animals.add(new ListItem("cats", 4));
        animals.add(new ListItem("mules", 3));
        
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
        
        theGame.setProvisions(provisions);
        
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
        loc.setSymbol("~~~");
        
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
        loc.setSymbol("!!!");
        theMap.setLocation(0,2, loc);
        
        //define the string for the desert location
        String desert = "\nYou are in the desert! The temperatures during the day" +
                "\ncan reach 130 degrees. Be very careful here!";
        
        //set desert location
        loc = new Location();
        loc.setDescription(desert);
        loc.setSymbol("---");
        
        //set this location object in row 0,1,2 in column 0
        for(int i =0; i<3; i++)
        {
            theMap.setLocation(i, 0, loc);
        }
            
        
    }    
}
