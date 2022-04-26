package com.MUD2.app.tile;

import com.MUD2.app.GameCharacter;

/**
 * A Tile that represents an obstacle. This tile cannot be occupied by a 
 * Character.
 * 
 * @author Peyton Martin
 */
public class ObstacleTile extends Tile{
    public ObstacleTile(int horizantalLocation, int verticalLocation, GameCharacter character){
        super(horizantalLocation, verticalLocation, character);
    }
}
