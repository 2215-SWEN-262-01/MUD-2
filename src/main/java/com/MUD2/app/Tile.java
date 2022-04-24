package com.MUD2.app;

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
    void setCharacter(GameCharacter character) {this.character = character;}
    
    /**
     * If the Tile is currently occupied, it will remove its Character
     */
    void removeCharacter() {
        this.setCharacter(null);
    }

    GameCharacter getCharacter() {return character;}
    int getHorizantalLocation() {return horizantalLocation;}
    int getVerticalLocation() {return verticalLocation;}

    abstract String export();
}
