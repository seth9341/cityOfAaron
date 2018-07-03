/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;

/**
 *
 * @author brucem
 */


public class CropException extends Exception {
    
    //Default contstructor
    //Purpose: Initializes data members to default values
    //Parameters: none
    //Returns: non
    public CropException(){}
    
    //Parameterized constructor
    //Purpose: Initializes data members to value passed as a parameter
    //Parameters: A string containing the error message
    //Returns: non
    public CropException(String string)
    {
        super(string);
    }
}


