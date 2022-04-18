package com.MUD2.app.inventory;

import com.MUD2.app.GameCharacter;

/**
 * Food is an object that when consumed by a player character it restores a certain number of health.
 */
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
