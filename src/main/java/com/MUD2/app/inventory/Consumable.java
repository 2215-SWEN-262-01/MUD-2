package com.MUD2.app.inventory;

import com.MUD2.app.GameCharacter;

/**
 * A Consumable is an abstract class that is responsible for establishing the methods
 * that an item with a limited number of uses must have.
 */
public abstract class Consumable extends Item{

	protected Consumable(String name, String description, int goldValue) {
		super(name, description, goldValue);
	}
	
	public abstract void use(GameCharacter character);
}
