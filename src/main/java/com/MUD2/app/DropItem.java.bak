package com.MUD2.app;

public class DropItem implements Command {
/**
 * DropItem is a command created so that a player will be able to remove an item from their inventory. 
 * 
 * @author Jahmir Hinds
 */
    private PlayerCharacter player;
    private Item item;
    /**
     * Constructor for the DropItem class
     * @param player The player parameter is the character of the player attempting to drop an item.
     * @param item is the item the player is attempting to drop.
     */
    public DropItem (PlayerCharacter player,Item item) {
        this.player = player;
        this.item = item;
    }
    /**
     * When this method is used the selected item will be removed from the player's inventory.
     */
    @Override
    public void execute() {
        Inventory temp = player.Inventory;
        int i = 0;
        int local;
        while ( i <=5 ) {
             int bagCount = 0;
             if (temp.bags[bagCount].contains(item)) {
                 local = bagCount;
             }
             i++;
             player.Inventory.bags[bagCount].removeItem(item);
        }
    }
    
}
