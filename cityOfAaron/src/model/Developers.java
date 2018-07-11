/*
 * Seth Huntley
 * week 10 individual assignment 
 */
package model;

import java.io.Serializable;

/**
 *
 * @author seth
 */
public class Developers implements Serializable {
    
    private String name;
    private String title;
    
    
    public Developers() {
    }
    
    public Developers(String name, String title){
        setName(name);
            }
    //getters and setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Developer: {" + "name=" + name + '}';
    }

}
