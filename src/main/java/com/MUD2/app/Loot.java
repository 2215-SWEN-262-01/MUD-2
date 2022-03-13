package com.MUD2.app;

public class Loot implements Command {
/**
 * A command that is made whenever a player attempts to loot an item.
 * 
 * @author Jahmir Hinds
 */
    private PlayerCharacter player;
    private Inventory inventory;

    /**
     * Constructor for the loot class
     * @param player the player character
     * @param inventory the inventory that a player will take the items from.
     */
    public Loot (PlayerCharacter player, Inventory inventory) {
        this.player = player;
        this.inventory = inventory;
    }

    /**
     * When used the player will attempt to loot an item.
     */
    @Override
    public void execute() {
        Inventory temp = player.getInventory();
        int i = 0;
        int open = 0;
        while ( i <=5 ) {
            if (temp.bags[i].getSpaces() >= 1) {
                open = i;
            }
            i++;
        }
        player.Inventory.bags[open].addItem(item);
    }
    
}
