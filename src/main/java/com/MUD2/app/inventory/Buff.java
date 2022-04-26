package com.MUD2.app.inventory;

import com.MUD2.app.GameCharacter;

/**
 * A buff is an item that allows the player character to increase their stats by a specified amount
 * 
 * @author Zachary Montgomery
 */
public class Buff extends Consumable{
	private StatType statType;

	public Buff(String name, String description, int goldValue, StatType statType, int amount) {
		super(name, description, goldValue);
		this.statType = statType;
	}
	public String getStatTypeString () {
		if (this.statType == StatType.HEALTH) {
			return "HEALTH";
		} else if (this.statType == StatType.ATTACK) {
			return "ATTACK";
		} else {
			return "DEFENSE";
		}

	}
	@Override
	public void use(GameCharacter character) {
		
	}
	@Override
	public String export() {
		String returnString = "Buff:"+ this.getName() + ":" + getDescription() + ":" + getGoldValue() + ":" + getStatTypeString();
		return returnString;
	}

}
