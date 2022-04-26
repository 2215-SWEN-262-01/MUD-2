package com.MUD2.app.tile;

import com.MUD2.app.GameCharacter;

/**
 * A Tile that represents a trap. Characters that move to the TrapTile will
 * take damage. After triggered, a TrapTile will convert to an EmptyTile
 * 
 * @author Peyton Martin
 */
public class TrapTile extends Tile {
    public TrapTile(int horizantalLocation, int verticalLocation, GameCharacter character, int attackValue){
        super(horizantalLocation, verticalLocation, character);
        this.attackValue = attackValue;
        this.character = character;
    }

    private int attackValue;
    private GameCharacter character;

    public void springTrap() {
        character.takeDamage(this.attackValue);
    }

    /**
     * This Method turns a tile into a string that represents a tile for saving purposes
     */
    public String export() {
        if (getCharacter() != null) {
            return "[t:" + attackValue +":" + getCharacter().export() + "]";
        } else {
            return "[t] " + attackValue;
        }
    }
}
