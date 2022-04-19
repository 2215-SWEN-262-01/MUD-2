package com.MUD2.app;


import java.util.List;

public class Move implements Command {
/**
 * Move is a command that is made when a player tries to move their character from one tile to another.
 * 
 * @author Jahmir Hinds
 */

    private Room room;
	private Map map;
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

    public Move (PlayerCharacter player, Room room, Map map, int x, int y) {
        this.player = player;
        this.room = room;
		this.map = map;
        this.newx = x;
        this.newy = y;
    }

    /**
     * When used the player will attempt to move to a tile.
     */
    @Override
    public void execute() {
        //First check bounds to avoid index out of bounds
        if (newx >= room.getWidth() || newx < 0) {
            return;
        }
        if (newy >= room.getHeight() || newy < 0) {
            return;
        }
        //Then do check to avoid players skipping spaces
        List<Tile> tiles = room.findAvailableTiles(player);
        if (tiles.contains(room.getTile(newx,newy))) {
			Tile tile = room.getTile(newx, newy);
			if (tile instanceof ExitTile) {
				ExitTile exit = (ExitTile) tile;
				map.setCurrentRoom(exit.getEndRoom());
                //player.setCurrentTile(exit);
                tile = exit.getOtherExit();
			} else if(tile instanceof GoalTile) {
				System.out.println("You won! Use any movement key to exit...");
			}
			if (tile.getCharacter() != null) {
				Attack attack = new Attack(player, tile.getCharacter(), room);
				attack.execute();
				return;
			}

            room.moveCharacter(player, tile);
        } else {
            System.out.println("Can't move there.");
        }
        
    }
    
}
