package com.MUD2.app.tile;

import com.MUD2.app.GameCharacter;

/**
 * A Tile is a space for Characters to occupy. Different subclasses of Tiles 
 * will have different functionality, such as being traps or containing loot.
 * 
 * @author Peyton Martin
 */
public abstract class Tile {
    private int horizantalLocation;
    private int verticalLocation;
    private GameCharacter character;

    public Tile(int horizantalLocation, int verticalLocation, GameCharacter character) {
        this.horizantalLocation = horizantalLocation;
        this.verticalLocation = verticalLocation;
        this.character = character;
    }

    /**
     * Adds character to a tile if it is not currently occupied
     *
     * @param character
     */
    public void setCharacter(GameCharacter character) {this.character = character;}
    
    /**
     * If the Tile is currently occupied, it will remove its Character
     */
    public void removeCharacter() {
        this.setCharacter(null);
    }

    public GameCharacter getCharacter() {return character;}
    public int getHorizantalLocation() {return horizantalLocation;}
    public int getVerticalLocation() {return verticalLocation;}

    public abstract String export();
}
