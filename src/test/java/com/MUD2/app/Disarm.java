package com.MUD2.app;


public class Disarm implements Command {
/**
  * Disarm is a command responsible for removing a trap tile from a room when the 
  * player decides to take that action.
  * 
  * @author Jahmir Hinds
  */
    private PlayerCharacter player;
    private Tile tile;
    /**
     *Constructor for Disarm class
     * @param player,tile The player pramater is a player character adn the tile is the 
     * suspected trap tile that the player will attempt to disarm.
     */
    public Disarm (PlayerCharacter player, Tile tile) {

    }
    /**
     * When this method is called it will have a 50 percent chance of removing a trap.
     */
    @Override
    public void execute() {
        // TODO Auto-generated method stub
        
    }
    
}
