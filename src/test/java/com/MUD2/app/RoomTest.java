package com.MUD2.app;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.LinkedList;

/**
 * Unit test suite for Rooms
 * 
 * @author Peyton Martin
 */
public class RoomTest {
    /**
    * Tests if a Tile is correctly converted to an EmptyTile
    */
    @Test
    public void testConvertToEmptyTile(){
        Tile testTiles[][] = new Tile[3][3];
        GameCharacter character = new GameCharacter();
        Inventory inventory = new Inventory();
        
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                testTiles[x][y] = new EmptyTile(x,y,character);
            }
        }
        testTiles[2][2] = new ChestTile(2,2, character, inventory);

        Room room = new Room(testTiles, 2, 2, "description");
        EmptyTile testTile = new EmptyTile(2,2,character);

        room.convertToEmptyTile(2, 2);

        assertEquals(room.getTile(2, 2), testTile);
    }

    /**
    * Tests if available Tiles are correctly found TODO
    */
    @Test
    public void testFindAvailableTiles(){
        LinkedList<Tile> availableTiles = new LinkedList<>();
        Tile testTiles[][] = new Tile[3][3];
        GameCharacter character = new GameCharacter();
        
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                testTiles[x][y] = new EmptyTile(x,y);
            }
        }
        testTiles[1][2].setCharacter(character);

        Room room = new Room(testTiles, testTiles.length, 2, "description");
        EmptyTile testTile = new EmptyTile(2,2,character);

        room.findAvailableTiles(character);

        assertEquals(room.findAvailableTiles(character), availableTiles);
    }

    /**
    * Tests if Characters are correctly moved TODO
    */
    @Test
    public void testMoveCharacter(){
        Tile testTiles[][] = new Tile[3][3];
        GameCharacter character = new GameCharacter();
        
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                testTiles[x][y] = new EmptyTile(x,y);
            }
        }
        testTiles[1][2].setCharacter(character);

        Room room = new Room(testTiles, 2, 2, "description");
        EmptyTile testTile = new EmptyTile(2,2,character);

        room.moveCharacter(character, testTiles[2][2]);

        assertEquals(room.getTile(2, 2).getCharacter(), testTile.getCharacter());
    }

}
