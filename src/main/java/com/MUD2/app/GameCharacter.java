package com.MUD2.app;

/**
 * Stubbed out GameCharacter class
 */
public class GameCharacter {

    private String name;
    private String description;
    public final int MAX_HEALTH;
    private int health;
    private int attack;
    private int defense;
    private Tile tile;
	private Inventory inventory;

    protected GameCharacter(String name, String description, int MAX_HEALTH, int attack, int defense, Tile tile) {
        this.MAX_HEALTH = MAX_HEALTH;
        this.name = name;
        this.description = description;
        this.health = MAX_HEALTH;
        this.attack = attack;
        this.defense = defense;
        this.tile = tile;
		this.inventory = new Inventory();
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return description;
    }


    public void attack(GameCharacter character) {
        character.takeDamage(attack);
    }

    public void takeDamage(int amount) {
        int damage = amount - defense;
        if(damage <= 0) {
            damage = 1;
        }
        health -= damage;
        if(health < 0) {
            health = 0;
        }
    }

    public void heal(int amount) {
        health += amount;
        if(health > MAX_HEALTH) {
            health = MAX_HEALTH;
        }
    }

    public Tile getCurrentTile () {
        return tile;
    }

    public void setCurrentTile(Tile tile) {
        this.tile = tile;
    }
	
	public Inventory getInventory() {
		return this.inventory;
	}
	
	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}
}
