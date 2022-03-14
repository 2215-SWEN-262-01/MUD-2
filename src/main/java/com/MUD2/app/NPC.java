package com.MUD2.app;

import java.util.Random;

public class NPC extends Character{
	private static final Random RNG = new Random();
	
	private boolean isNocturnal;

	protected NPC(String name, String description) {
		super(name, description, RNG.nextInt(101) + 50, RNG.nextInt(11) + 5, RNG.nextInt(11));
	}
	
	public boolean isNocturnal() {
		return isNocturnal;
	}

}
