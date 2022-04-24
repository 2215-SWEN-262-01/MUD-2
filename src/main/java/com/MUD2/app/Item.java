package com.MUD2.app;

public abstract class Item {
	private String name;
	private String description;
	private int goldValue;
	
	protected Item(String name, String description, int goldValue) {
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

	public abstract String export();
}
