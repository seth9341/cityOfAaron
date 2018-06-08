/*
 * The main() class file for the cityOfAaron project
 * CIT-260
 * Spring 2018
 * Team members: Seth Huntley, Bruce Montgomery, Stanley Varner
 */
package cityofaaron;

import model.ListItem;
import model.Player;
import model.TeamMember;
import model.CropData;
import model.Location;
import control.CropControl;
import view.*; //slides have this capitolized but I did not because it's not
import model.Game;


public class CityOfAaron {
        // variable for keeping a reference to the Game object
        private static Game theGame = null;

    public static Game getTheGame() {
        return theGame;
    }

    public static void setTheGame(Game theGame) {
        CityOfAaron.theGame = theGame;
    }
        
        

    /**
     * @param args the command line arguments 
     */
    public static void main(String[] args) {
        
        // Create a MainMenuView instance called mmv
        MainMenuView mmv = new MainMenuView();
        
        // Call the displayMenuView method of the newly created mmv instance
        mmv.displayMenuView();
        
        
        Player playerOne = new Player();
        
        playerOne.setName("Alma");
        System.out.println("Player Ones Name is " + playerOne.getName());
        
        System.out.println(TeamMember.Son.getName() + " is a " + TeamMember.Son.getTitle());
        
       
       //added by Bruce to test the ListItem Class 
        ListItem shovel = new ListItem( );
        shovel.setName("shovel");
        shovel.setNumber(5);
        System.out.println(shovel.toString());
        
        CropData cropOne = new CropData();
        
        cropOne.setcropYield(33);
        System.out.println("Your crop yields are " + cropOne.getcropYield() + " crops. Yay! You're not starving this year!");
        
        //added by Stanley to test Location Class
        Location earth = new Location();
        earth.setDescription("I'm at the beach");
        earth.setSymbol("@");
        
        System.out.println(earth.toString());
        
        //added by Bruce to test the calcLandCost method
        System.out.println("The random generated cost for land is " + CropControl.calcLandCost() + " bushels of wheat per acre");
        
        //added by Bruce to test the calcCropYield method
        //CropData cropYieldPerAcre = new CropData();
        //cropYieldPerAcre.setoffering(7);
        //System.out.println("The offering is " + cropYieldPerAcre.getoffering());
        System.out.println("The calculated crop yield is " + CropControl.calcCropYield());
    
                
    }
    
    
}
