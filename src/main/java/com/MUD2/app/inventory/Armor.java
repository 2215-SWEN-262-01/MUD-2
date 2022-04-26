package com.MUD2.app.inventory;

import com.MUD2.app.PlayerCharacter;

/***
 * The Armor class is responsible for creating an item that can augment the defenses of a player character
 * 
 * @author Zachary Montgomery
 */
public class Armor extends Equippable{
	private int defense;

	public Armor(String name, String description, int goldValue, int defense) {
		super(name, description, goldValue);
		this.defense = defense;
	}

	@Override
	public void equip(PlayerCharacter playerCharacter) {
		playerCharacter.equipArmor(this);
	}
	
	public int getDefense() {
		return defense;
	}
}