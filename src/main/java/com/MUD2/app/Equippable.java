package com.MUD2.app;

/**
 * Equipable is an abstract class that is responsible for establishing what methods that an
 * item that can be wielded or worn by a player character must have.
 */
public abstract class Equippable extends Item{

	protected Equippable(String name, String description, int goldValue) {
		super(name, description, goldValue);
	}
	
	public abstract void equip(PlayerCharacter playerCharacter);

}
