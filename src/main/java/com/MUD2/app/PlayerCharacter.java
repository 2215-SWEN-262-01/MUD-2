package com.MUD2.app;

public class PlayerCharacter extends GameCharacter{
	public static final int MAX_HEALTH = 100;
	public static final int DEFAULT_ATTACK = 10;
	public static final int DEFAULT_DEFENSE = 0;
	
	private Inventory inventory;
	private Weapon currentWeapon;
	private Armor currentArmor;

	protected PlayerCharacter(String name, String description, Tile tile) {
		super(name, description, MAX_HEALTH, DEFAULT_ATTACK, DEFAULT_DEFENSE, tile);
		this.inventory = new Inventory();
		this.currentArmor = null;
		this.currentWeapon = null;
	}

	public Inventory getInventory() {
		return inventory;
	}

	public void equipWeapon(Weapon weapon) {
		this.currentWeapon = weapon;
	}

	public void equipArmor(Armor armor) {
		this.currentArmor = armor;
	}

	public Weapon getCurrentWeapon() {
		return currentWeapon;
	}

	public Armor getCurrentArmor() {
		return currentArmor;
	}

}
