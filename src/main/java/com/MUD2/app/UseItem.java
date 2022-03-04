package com.MUD2.app;

public class UseItem implements Command {
/**
* UseItem is a command created so that a player will be able to use an item from their inventory. 
* 
* @author Jahmir Hinds
*/
   private PlayerCharacter player;
   private String item;

   /**
    * Constructor for the UseItem class
    * @param player The player parameter is the character of the player attempting to drop an item.
    * @param item is a string that is the name of the item the player is attempting to use.
    */
    public UseItem (PlayerCharacter player,String item) {

    }
    /**
     * When this method is used the player will attempt to use the selected item.
     */
    @Override
    public void execute() {
        // TODO Auto-generated method stub
        
    }


}
