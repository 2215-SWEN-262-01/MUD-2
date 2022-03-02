package com.MUD2.app;

/**
 * A Tile that represents an exit. When Characters move to this tile they will
 * be sent to an adjacent Room's ExitTile.
 * 
 * @author Peyton Martin
 */
public class ExitTile extends Tile{
    public ExitTile(Room startRoom, Room endRoom){
        this.startRoom = startRoom;
        this.endRoom = endRoom;
    }

    Room startRoom;
    Room endRoom;
}
