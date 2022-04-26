package com.MUD2.app;

import java.util.Random;

import com.MUD2.app.tile.Tile;

/**
 * An NPC is a game character that is not controlled by the client and can attack a player character.
 * 
 * @author Zachary Montgomery
 */
public class NPC extends GameCharacter{
	private static final Random RNG = new Random();
	
	private boolean isNocturnal;

	public NPC(String name, String description, Tile tile) {
		super(name, description, RNG.nextInt(101) + 50, RNG.nextInt(11) + 5, RNG.nextInt(11), tile);
	}
	
	public boolean isNocturnal() {
		return isNocturnal;
	}

}
