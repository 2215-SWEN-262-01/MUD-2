package com.MUD2.app;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Unit test suite for Tiles
 * 
 * @author Peyton Martin
 */
public class TileTest {
    /**
    * Tests if characters are correctly added to Tile
    */
    @Test
    public void testSetCharacter(){
        GameCharacter character = new GameCharacter();

        EmptyTile tile = new EmptyTile(2,2,character);
        EmptyTile testTile = new EmptyTile(2,2);

        testTile.setCharacter(character);

        assertTrue(tile.equals(testTile));
    }

    /**
    * Tests if characters are correctly removed Tile TODO
    */
    @Test
    public void testRemoveCharacter(){
        GameCharacter character = new GameCharacter();

        EmptyTile tile = new EmptyTile(2,2){};
        EmptyTile testTile = new EmptyTile(2,2,character){};

        testTile.removeCharacter();

        assertEquals(tile, testTile);;
    }
}
