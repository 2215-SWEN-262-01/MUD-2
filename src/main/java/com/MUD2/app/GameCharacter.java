package com.MUD2.app;

import com.MUD2.app.inventory.*;
import com.MUD2.app.tile.*;

/**
 * This abstract class represents an individual game character that can be on the map.
 * 
 * @author Zachary Montgomery
 */
public abstract class GameCharacter {
	
	private String name;
	private String description;
	public final int MAX_HEALTH;
	private int health;
	private int attack;
	private int defense;
	private Inventory inventory;
	private boolean defeated;
	private Tile currentTile;
	
	protected GameCharacter(String name, String description, int maxHealth, int attack, int defense, Tile currentTile) {
		this.MAX_HEALTH = maxHealth;
		this.name = name;
		this.description = description;
		this.health = MAX_HEALTH;
		this.attack = attack;
		this.defense = defense;
		this.inventory = new Inventory();
		this.defeated = false;
		this.currentTile = currentTile;
	}
	
	public boolean getDefeated() {
		return this.defeated;
	}
	
	public void setDefeated(boolean defeated) {
		this.defeated = defeated;
	}
	
	public Inventory getInventory() {
		return inventory;
	}
	
	public String getName() {
		return name;
	}
	
	public String getDesc() {
		return description;
	}
	
	public int getAttack() {
		return attack;
	}
	
	public int getDefense() {
		return defense;
	}
	
	public void setAttack(int value) {
		this.attack = value;
	}
	
	public void setDefense(int value) {
		this.defense = value;
	}
	
	public Tile getCurrentTile() {
        return currentTile;
    }

	public void setCurrentTile(Tile tile) {
		this.currentTile = tile;
	}
	
	public int getHealth() {
		return this.health;
	}
	
	public int getMaxHealth() {
		return this.MAX_HEALTH;
	}
	
	public int attack(GameCharacter character) {
		return character.takeDamage(attack);
	}
	
	/**
	* Processes incoming damage
	* @return the amount of damage dealt
	*/
	public int takeDamage(int amount) {
		int damage = amount - defense;
		if(damage <= 0) {
			damage = 1;
		}
		health -= damage;
		if(health < 0) {
			health = 0;
			onDefeat();
		}
		return damage;
	}
	
	public void heal(int amount) {
		health += amount;
		if(health > MAX_HEALTH) {
			health = MAX_HEALTH;
		}
	}
	
	protected void onDefeat() {
		this.defeated = true;
		System.out.println(this.name + " has been defeated!");
		this.currentTile.removeCharacter();
		return;
	}
	
	@Override
	public String toString() {
		return "Character{name=" + name + ", desc=" + description + ", health=" + health + ", attack=" + attack + ", defense=" + defense + "}";
	}


	protected void addItemToInventory(Item item) {
		for ( Bag checkbag : this.inventory.getBags()) {
			if (checkbag != null && checkbag.getSpace() > 0) {
				checkbag.addItem(item);
				break;
			}
		}
	}
}
