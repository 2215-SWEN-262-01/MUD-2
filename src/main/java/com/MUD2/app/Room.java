package com.MUD2.app;

/**
 * A Room contains Tiles for different characters to move to and interact
 * with.
 * 
 * @author Peyton Martin
 */
public class Room {
    public Room(Tile tiles[][], int width, int height, String description){
        this.tiles = tiles;
        this.width = width;
        this.height = height;
        this.description = description;
    }

    Tile tiles[][];
    int width;
    int height;
    String description;

    /**
     * Calculates all the spaces a Character can move to
     *
     * @param character current Character
     * @return array of tiles
     */
    Tile[] findAvailableTiles(Character character) {

    }

    /**
     * Calculates all the spaces a Character can move to
     *
     * @param character current Character
     * @param tile where the chacter is moving to
     * @return array of tiles
     */
    void moveCharacter(Character character, Tile tile) {

    }
}
