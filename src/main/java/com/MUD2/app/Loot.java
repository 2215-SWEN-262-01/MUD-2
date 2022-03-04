package com.MUD2.app;

public class Loot implements Command {
/**
 * A command that is made whenever a player attempts to loot an item.
 * 
 * @author Jahmir Hinds
 */
    private PlayerCharacter player;
    private Item item;

    /**
     * Constructor for the loot class
     * @param player the player character
     * @param item the item that they will pick up
     */
    public Loot (PlayerCharacter player, Item item) {

    }

    /**
     * WHen used the player will attempt to loot an item.
     */
    @Override
    public void execute() {
        // TODO Auto-generated method stub
        
    }
    
}
