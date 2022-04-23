package com.MUD2.app;

/**
 * A Tile that represents an exit. When Characters move to this tile they will
 * be sent to an adjacent Room's ExitTile.
 * 
 * @author Peyton Martin
 */
public class ExitTile extends Tile{


    public ExitTile(int horizantalLocation, int verticalLocation, GameCharacter character, Room endRoom){
        super(horizantalLocation, verticalLocation, character);
        this.endRoom = endRoom;
        this.otherExit = null;
    }
	
	public Room getEndRoom() {
		return this.endRoom;
	}

    public ExitTile getOtherExit() { return this.otherExit; }

    public void setOtherExit(ExitTile otherExit) {
        this.otherExit = otherExit;
    }

    private Room endRoom;
    private ExitTile otherExit;

    /**
     * This Method turns a tile into a string that represents a tile for saving purposes
     */
    @Override
    public String toString() {
        return "[]";
    }
}
