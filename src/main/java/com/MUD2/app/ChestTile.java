package com.MUD2.app;

/**
 * A Tile that represents a chest. Characters can loot a chest, and after it is
 * converted to an EmptyTile.
 * 
 * @author Peyton Martin
 */
public class ChestTile extends Tile{
    public ChestTile(int horizantalLocation, int verticalLocation, GameCharacter character, Inventory inventory){
        super(horizantalLocation, verticalLocation, character);
        this.inventory = inventory;
    }
    public ChestTile(int horizantalLocation, int verticalLocation, Inventory inventory){
        super(horizantalLocation, verticalLocation);
        this.inventory = inventory;
    }
    
    private Inventory inventory;
}
