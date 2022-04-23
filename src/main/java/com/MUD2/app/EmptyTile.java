package com.MUD2.app;

/**
 * The default type of Tile. It is an empty space to be occupied by a Character
 * 
 * @author Peyton Martin
 */
public class EmptyTile extends Tile{
    public EmptyTile(int horizantalLocation, int verticalLocation, GameCharacter character){
        super(horizantalLocation, verticalLocation, character);
    }

    /**
     * This Method turns a tile into a string that represents a tile for saving purposes
     */
    @Override
    public String toString() {
        return "[]";
    }
}
