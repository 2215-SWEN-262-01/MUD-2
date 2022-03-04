package com.MUD2.app;



public class Move implements Command {
/**
 * Move is a command that is made when a player tries to move their character from one tile to another.
 * 
 * @author Jahmir Hinds
 */

    private Tile tile;
    private PlayerCharacter player;

    /**
     * Constructor for the Move Class
     * @param player The player parameter is the character of the player attempting to move.
     * @param tile is the tile of the map that a player is attempting to move to.
     */

    public Move (PlayerCharacter player, Tile tile) {

    }

    /**
     * When used the player will attempt to move to a tile.
     */
    @Override
    public void execute() {
        // TODO Auto-generated method stub
        
    }
    
}
