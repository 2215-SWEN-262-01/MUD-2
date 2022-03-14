package com.MUD2.app;

public class Buff extends Consumable{
	private StatType statType;

	public Buff(String name, String description, int goldValue, StatType statType, int amount) {
		super(name, description, goldValue);
		this.statType = statType;
	}

	@Override
	public void use(GameCharacter character) {
		
	}

}
