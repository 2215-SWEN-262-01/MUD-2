package com.MUD2.app;

/**
 * A buff is an item that allows the player character to increase their stats by a specified amount
 */
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
