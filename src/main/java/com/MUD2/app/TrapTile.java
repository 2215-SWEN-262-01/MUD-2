package com.MUD2.app;

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
    public TrapTile(int horizantalLocation, int verticalLocation, int attackValue){
        super(horizantalLocation, verticalLocation);
        this.attackValue = attackValue;
    }

    private int attackValue;
    private GameCharacter character;

    public void springTrap() {
        character.takeDamage(this.attackValue);
    }
}
