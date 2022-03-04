package com.MUD2.app;

public class DropItem implements Command {
/**
 * DropItem is a command created so that a player will be able to remove an item from their inventory. 
 * 
 * @author Jahmir Hinds
 */
    private PlayerCharacter player;
    private String item;
    /**
     * Constructor for the DropItem class
     * @param player The player parameter is the character of the player attempting to drop an item.
     * @param item is a string that is the name of the item the player is attempting to drop.
     */
    public DropItem (PlayerCharacter player,String item) {

    }
    /**
     * When this method is used the selected item will be removed from the player's inventory.
     */
    @Override
    public void execute() {
        // TODO Auto-generated method stub
        
    }
    
}
