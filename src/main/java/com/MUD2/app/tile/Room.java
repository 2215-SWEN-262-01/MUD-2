package com.MUD2.app.tile;

import java.util.LinkedList;
import java.util.List;

import com.MUD2.app.GameCharacter;

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
    public void convertToEmptyTile(int x, int y) { 
        GameCharacter character = this.tiles[x][y].getCharacter();
        this.tiles[x][y] = new EmptyTile(x,y,character);
    }

    /**
     * Calculates all the spaces a Character can move to
     *
     * @param character current Character
     * @return array of tiles
     */
    public List<Tile> findAvailableTiles(GameCharacter character) {

        LinkedList<Tile> availableTiles = new LinkedList<>();
        int x = character.getCurrentTile().getHorizantalLocation();
        int y = character.getCurrentTile().getVerticalLocation();
        int[][] offsets = {{1,0}, {-1,0}, {0,1}, {0,-1}, {1, 1}, {-1, -1}, {-1, 1}, {1, -1}};
        for (int[] offset : offsets) {
            try {
                Tile tile = tiles[x+offset[0]][y+offset[1]];
                if (!(tile instanceof ObstacleTile))
                    availableTiles.add(tile);
            } catch (IndexOutOfBoundsException e) {
                //drop tiles out of bounds
            }
        }

        return availableTiles;
    }

    /**
     * Moves the character onto a given tile
     *
     * @param character current Character
     * @param tile where the chacter is moving to
     * @return array of tiles
     */
    public void moveCharacter(GameCharacter character, Tile tile) {
		//Fix for phantom character created when switching tile type underneath a player
		int x = character.getCurrentTile().getHorizantalLocation();
		int y = character.getCurrentTile().getVerticalLocation();
		getTile(x, y).removeCharacter();
		
        character.getCurrentTile().removeCharacter();
		
        tile.setCharacter(character);
        character.setCurrentTile(tile);
    }
    public String getDescription() {
        return description;
    }

    public Tile getTile(int x, int y) {
        try {
            return tiles[x][y];
        } catch (IndexOutOfBoundsException e) {
            //Sanity checking for room bounds
            return null;
        }
    }
	
	public void setTile(int x, int y, Tile tile) {
		try {
            tiles[x][y] = tile;
        } catch (IndexOutOfBoundsException e) {
            //Sanity checking for room bounds
            System.err.println("Attempted to set out of bounds tile at " + x + ", " + y + "!");
        }
	}
	
	public int getWidth() {
		return this.width;
	}
	
	public int getHeight() {
		return this.height;
	}

    public String exportTiles() {
        String returnstring = "";
        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles[0].length; j++) {
                returnstring += tiles[i][j].export();
            }
        }
        return returnstring;
    }

    public String export () {
        String returnString = " Room:" + getDescription() +":"+ getHeight() +":" + getWidth() + ":" + exportTiles() ;
        return returnString;
    }
}
