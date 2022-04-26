package com.MUD2.app.tile;

import com.MUD2.app.GameCharacter;

/**
 * A Tile that represents the goal. When a Character moves to this tile the game will conclude
 * 
 * @author Zachary Montgomery
 */
public class GoalTile extends Tile{

    public GoalTile(int horizantalLocation, int verticalLocation, GameCharacter character){
        super(horizantalLocation, verticalLocation, character);
    }
	
}
