package com.MUD2.app;

public class Armor extends Equippable{
	private int defense;

	public int getDefense() {
		return defense;
	}

	public Armor(String name, String description, int goldValue, int defense) {
		super(name, description, goldValue);
		this.defense = defense;
	}

	@Override
	public void equip(PlayerCharacter playerCharacter) {
		playerCharacter.equipArmor(this);
	}
}
