package com.MUD2.app;

public abstract class GameCharacter {
	
	private String name;
	private String description;
	public final int MAX_HEALTH;
	private int health;
	private int attack;
	private int defense;
	private Tile currentTile;
	
	protected GameCharacter(String name, String description, int maxHealth, int attack, int defense, Tile currentTile) {
		this.MAX_HEALTH = maxHealth;
		this.name = name;
		this.description = description;
		this.health = MAX_HEALTH;
		this.attack = attack;
		this.defense = defense;
		this.currentTile = currentTile;
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
			onDefeat();
		}
	}
	
	public void heal(int amount) {
		health += amount;
		if(health > MAX_HEALTH) {
			health = MAX_HEALTH;
		}
	}
	
	private void onDefeat() {
		return;
	}
	
	@Override
	public String toString() {
		return "Character{name=" + name + ", desc=" + description + ", health=" + health + ", attack=" + attack + ", defense=" + defense + "}";
	}
}
