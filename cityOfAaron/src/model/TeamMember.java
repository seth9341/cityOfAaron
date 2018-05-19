/*
 * The TeamMember Class file for the cityOfAaron project
 * CIT-260
 * Spring 2018
 * Team members: Seth Huntley, Bruce Montgomery, Stanley Varner
 */
package model;

import java.io.Serializable;

/**
 *
 * @author brucem
 */
public enum TeamMember implements Serializable{
    
    Grandfather("Bruce Montgomery", "Old Man"),
    Father("Seth Huntley", "Man"),
    Son("Stanley Varner", "Youngun");
    
    //class instance variables
    private String name;
    private String title;

TeamMember(String name, String title) {
    this.name = name;
    this.title = title;
}

    public String getName() {
        return name;
    }

    public String getTitle() {
        return title;
    }


}
