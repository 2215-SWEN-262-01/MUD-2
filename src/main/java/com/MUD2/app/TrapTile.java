package com.MUD2.app;

/**
 * A Tile that represents a trap. Characters that move to the TrapTile will
 * take damage. After triggered, a TrapTile will convert to an EmptyTile
 * 
 * @author Peyton Martin
 */
public class TrapTile extends Tile {
    public TrapTile(int attackValue){this.attackValue = attackValue;}

    int attackValue;
}
