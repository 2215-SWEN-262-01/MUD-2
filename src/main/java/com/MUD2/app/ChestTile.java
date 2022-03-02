package com.MUD2.app;

/**
 * A Tile that represents a chest. Characters can loot a chest, and after it is
 * converted to an EmptyTile.
 * 
 * @author Peyton Martin
 */
public class ChestTile extends Tile{
    public ChestTile(Inventory inventory){this.inventory = inventory;}
    
    Inventory inventory;
}
