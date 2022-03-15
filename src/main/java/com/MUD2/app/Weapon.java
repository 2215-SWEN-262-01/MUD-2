package com.MUD2.app;

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
	
	public int getAttack() {
		return attack;
	}



}
