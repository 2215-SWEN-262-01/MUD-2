package com.MUD2.app;

public class Weapon extends Equippable{
	private int attack;

	public Weapon(String name, String description, int goldValue, int attack) {
		super(name, description, goldValue);
		this.attack = attack;
	}
	
	@Override
	public void equip(PlayerCharacter playerCharacter) {
		playerCharacter.equipWeapon(this);
	}

}
