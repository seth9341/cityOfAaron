/*
 * The main() class file for the cityOfAaron project
 * CIT-260
 * Spring 2018
 * Team members: Seth Huntley, Bruce Montgomery, Stanley Varner
 */
package cityofaaron;

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
    }
    
}
