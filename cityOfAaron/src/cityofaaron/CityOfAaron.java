/*
 * The main() class file for the cityOfAaron project
 * CIT-260
 * Spring 2018
 * Team members: Seth Huntley, Bruce Montgomery, Stanley Varner
 */
package cityofaaron;

import java.util.ArrayList;
import model.ListItem;
import model.Player;
import model.TeamMember;

/**
 *
 * @author seth
 */
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
        ArrayList<ListItem> tools = new ArrayList<>();
        tools.add(new ListItem ("Axe", 2));
        
        
    }
    
}
