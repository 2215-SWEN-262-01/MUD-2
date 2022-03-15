package com.MUD2.app;

import java.util.LinkedList;
import java.util.List;

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

    private Tile tiles[][];
    private int width;
    private int height;
    private String description;

    /**
     * Converts any type of Tile to an EmptyTile
     */
    void convertToEmptyTile(int x, int y) { 
        GameCharacter character = this.tiles[x][y].getCharacter();
        this.tiles[x][y] = new EmptyTile(x,y,character);
    }

    /**
     * Calculates all the spaces a Character can move to
     *
     * @param character current Character
     * @return array of tiles
     */
    List<Tile> findAvailableTiles(GameCharacter character) {

        LinkedList<Tile> availableTiles = new LinkedList<>();
        int x = character.getCurrentTile().getHorizantalLocation();
        int y = character.getCurrentTile().getVerticalLocation();
        int[][] offsets = {{1,0}, {-1,0}, {0,1}, {0,-1}, {1, 1}, {-1, -1}, {-1, 1}, {1, -1}};
        for (int[] offset : offsets) {
            try {
                availableTiles.add(tiles[x+offset[0]][y+offset[1]]);
            } catch (IndexOutOfBoundsException e) {
                //drop tiles out of bounds
            }
        }
        //Adding all adjacent tiles to list
        /*availableTiles.add(tiles[x+1][y]);
        availableTiles.add(tiles[x-1][y]);
        availableTiles.add(tiles[x][y+1]);
        availableTiles.add(tiles[x][y-1]);
        availableTiles.add(tiles[x+1][y+1]);
        availableTiles.add(tiles[x-1][y-1]);
        availableTiles.add(tiles[x-1][y+1]);
        availableTiles.add(tiles[x+1][y-1]);*/

        return availableTiles;
    }

    /**
     * Moves the character onto a given tile
     *
     * @param character current Character
     * @param tile where the chacter is moving to
     * @return array of tiles
     */
    void moveCharacter(GameCharacter character, Tile tile) {
        character.getCurrentTile().removeCharacter();
        tile.setCharacter(character);
        character.setCurrentTile(tile);
    }

    Tile getTile(int x, int y) {
        try {
            return tiles[x][y];
        } catch (IndexOutOfBoundsException e) {
            //Sanity checking for room bounds
            return null;
        }

    }
	
	public int getWidth() {
		return this.width;
	}
	
	public int getHeight() {
		return this.height;
	}
}
