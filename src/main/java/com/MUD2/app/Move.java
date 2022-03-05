package com.MUD2.app;



public class Move implements Command {
/**
 * Move is a command that is made when a player tries to move their character from one tile to another.
 * 
 * @author Jahmir Hinds
 */

    private Room room;
    private PlayerCharacter player;
    private int newx;
    private int newy;

    /**
     * Constructor for the Move Class
     * @param player The player parameter is the character of the player attempting to move.
     * @param room the room that the player is in.
     * @param x The x coordinate of the new location that the player is moving to.
     * @param y The y coordinate of the new location that the player is moving to.
     */

    public Move (PlayerCharacter player, Room room, int x, int y) {
        this.player = player;
        this.room = room;
        this.newx = x;
        this.newy = y;
    }

    /**
     * When used the player will attempt to move to a tile.
     */
    @Override
    public void execute() {
        List<Tile> tiles = room.findAvailableTiles(player);
        if (tiles.contains(room.getTile(x,y))) {
            room.moveCharacter(x,y);
        } else {
            System.out.print("Can't skip spaces!");
        }
        
    }
    
}
