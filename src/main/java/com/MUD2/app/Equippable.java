package com.MUD2.app;

public abstract class Equippable extends Item{

	protected Equippable(String name, String description, int goldValue) {
		super(name, description, goldValue);
	}
	
	public abstract void equip(PlayerCharacter playerCharacter);

}
