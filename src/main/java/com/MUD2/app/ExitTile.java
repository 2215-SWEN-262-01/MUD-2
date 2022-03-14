package com.MUD2.app;

/**
 * A Tile that represents an exit. When Characters move to this tile they will
 * be sent to an adjacent Room's ExitTile.
 * 
 * @author Peyton Martin
 */
public class ExitTile extends Tile{
    public ExitTile(int horizantalLocation, int verticalLocation, GameCharacter character, Room startRoom, Room endRoom){
        super(horizantalLocation, verticalLocation, character);
        this.startRoom = startRoom;
        this.endRoom = endRoom;
    }
    public ExitTile(int horizantalLocation, int verticalLocation, Room startRoom, Room endRoom){
        super(horizantalLocation, verticalLocation);
        this.startRoom = startRoom;
        this.endRoom = endRoom;
    }

    private Room startRoom;
    private Room endRoom;
}
