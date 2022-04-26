package com.MUD2.app.inventory;

import com.MUD2.app.PlayerCharacter;

/**
 * The Weapon class is responsible for creating an item that can augment the attack of a player character
 * 
 * @author Zachary Montgomery
 */
public class Weapon extends Equippable{
	private int attack;

	public int getAttack() {
		return attack;
	}

	public Weapon(String name, String description, int goldValue, int attack) {
		super(name, description, goldValue);
		this.attack = attack;
	}
	
	@Override
	public void equip(PlayerCharacter playerCharacter) {
		playerCharacter.equipWeapon(this);
	}




}
