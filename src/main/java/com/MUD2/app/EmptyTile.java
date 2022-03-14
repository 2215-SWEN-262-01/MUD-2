package com.MUD2.app;

/**
 * The default type of Tile. It is an empty space to be occupied by a Character
 * 
 * @author Peyton Martin
 */
public class EmptyTile extends Tile{
    public EmptyTile(int horizantalLocation, int verticalLocation, GameCharacter character){
        super(horizantalLocation, verticalLocation, character);
    }
    public EmptyTile(int horizantalLocation, int verticalLocation){
        super(horizantalLocation, verticalLocation);
    }
}
