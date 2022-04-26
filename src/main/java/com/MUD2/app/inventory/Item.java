package com.MUD2.app.inventory;

/**
 * An Item is an abstract object to be used by Characters
 * 
 * @author Zachary Montgomery
 */
public class Item {
	private String name;
	private String description;
	private int goldValue;
	
	public Item(String name, String description, int goldValue) {
		this.name = name;
		this.description = description;
		this.goldValue = goldValue;
	}
	
	public String getName() {
		return name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public int getGoldValue() {
		return goldValue;
	}
	@Override
	public String toString() {
		String returnString = name + " " + description + " " + goldValue;
		return returnString;
	}

	public String export() {
		String returnString = "item:"+ this.getName() + ":" + getDescription() + ":" + getGoldValue();
		return returnString;
	}
}
