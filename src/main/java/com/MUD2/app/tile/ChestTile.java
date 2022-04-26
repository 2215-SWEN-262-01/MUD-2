package com.MUD2.app.tile;

import com.MUD2.app.GameCharacter;
import com.MUD2.app.inventory.*;

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
    
    private Inventory inventory;

    public Inventory getInventory() {
        return inventory;
    }
}