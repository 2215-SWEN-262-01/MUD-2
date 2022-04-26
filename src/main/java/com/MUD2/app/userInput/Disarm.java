package com.MUD2.app.userInput;
import java.util.Random;

import com.MUD2.app.PlayerCharacter;
import com.MUD2.app.tile.Room;
import com.MUD2.app.tile.TrapTile;

public class Disarm implements Command {
/**
  * Disarm is a command responsible for removing a trap tile from a room when the 
  * player decides to take that action.
  *
  * @author Jahmir Hinds
  */
    private PlayerCharacter player;
    private Room room;
    int x;
    int y;
    /**
     * Constructor for Disarm class
     * @param player The player parameter is a player character.
     * @param room The room is the suspected the room that has a tile that the player will attempt to disarm.
     * @param x the x coordinate of the tile attempting to be disarmed
     * @param y the y coodrinate of the tile attempting to be disarmed
     */
    public Disarm (PlayerCharacter player, Room room, int x, int y) {
        this.player = player;
        this.room = room;
    }
    /**
     * When this method is called it will have a 50 percent chance of removing a trap.
     */
    @Override
    public void execute() {
        Random random = new Random();
        boolean outcome = random.nextBoolean();
        if (outcome == true) {
            room.convertToEmptyTile(x,y);
        } else {
            if (room.getTile(x,y) instanceof TrapTile) {
                ((TrapTile) room.getTile(x,y)).springTrap();
                room.convertToEmptyTile(x,y);
            }

        }
        
    }
    
}
