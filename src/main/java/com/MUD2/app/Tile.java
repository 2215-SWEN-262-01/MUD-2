package com.MUD2.app;

/**
 * A Tile is a space for Characters to occupy. Different subclasses of Tiles 
 * will have different functionality, such as being traps or containing loot.
 * 
 * @author Peyton Martin
 */
public abstract class Tile {
    int horizantalLocation;
    int verticalLocation;
    Character character;

    /**
     * Adds character to a tile if it is not currently occupied
     *
     * @param character
     */
    void addCharacter(Character character) {

    }
    
    /**
     * If the Tile is currently occupied, it will remove its Character
     */
    void removeCharacter() {

    }

    /**
     * Converts any type of Tile to an EmptyTile
     */
    void convertToEmptyTile() { 

    }
}
