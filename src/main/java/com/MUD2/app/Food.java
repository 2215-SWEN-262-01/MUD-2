package com.MUD2.app;

public class Food extends Consumable{
	private int health;

	public Food(String name, String description, int goldValue, int health) {
		super(name, description, goldValue);
		this.health = health;
	}

	@Override
	public void use(GameCharacter character) {
		character.heal(health);	
	}
	
}
