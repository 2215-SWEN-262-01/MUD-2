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

    /**
     * This Method turns a tile into a string that represents a tile for saving purposes
     */
    public String export() {
        if (getCharacter() != null) {
            return "[c:" + this.inventory.export() +":" + getCharacter().export()+ "]";
        }else {
            return "[" + this.inventory.export() + "]";
        }
    }
}
