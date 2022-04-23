package com.MUD2.app;

/**
 * A Tile that represents the goal. When a Character moves to this tile the game will conclude
 * 
 * @author Zachary Montgomery
 */
public class GoalTile extends Tile{

    public GoalTile(int horizantalLocation, int verticalLocation, GameCharacter character){
        super(horizantalLocation, verticalLocation, character);
    }
    /**
     * This Method turns a tile into a string that represents a tile for saving purposes
     */
    @Override
    public String toString() {
        return "[g]";
    }
}
