// The ViewInterface interface - part of the view layer
// Object of this interface is to provide a common interface for the different menus
// Author: Seth Huntley, Bruce Montgomery, Stanley Varner
// Date last modified: June 2018
//-------------------------------------------------------------
package view;


public interface ViewInterface {
    public void displayMenuView();
    public int getMenuOption();
    public void doAction(int option);
}
