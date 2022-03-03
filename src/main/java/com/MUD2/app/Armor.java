package com.MUD2.app;

public class Armor extends Equippable{
	private int defense;

	public Armor(String name, String description, int goldValue, int defense) {
		super(name, description, goldValue);
		this.defense = defense;
	}

}
