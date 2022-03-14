package com.MUD2.app;

public abstract class Consumable extends Item{

	protected Consumable(String name, String description, int goldValue) {
		super(name, description, goldValue);
	}
	
	public abstract void use(GameCharacter character);
}
