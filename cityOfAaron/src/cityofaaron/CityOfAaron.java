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

public class CityOfAaron {

    /**
     * @param args the command line arguments 
     */
    public static void main(String[] args) {
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
    }
    
}
