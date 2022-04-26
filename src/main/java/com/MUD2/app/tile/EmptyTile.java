package com.MUD2.app.tile;

import com.MUD2.app.GameCharacter;

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
    public String export() {
        if (getCharacter() != null) {
            return "[" + getCharacter().export()+ "]";
        }else {
            return "[]";
        }
    }
}
