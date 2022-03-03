package com.MUD2.app;

public class Character {
	
	private String name;
	private String description;
	private int health;
	private int attack;
	private int defense;
	
	protected Character(String name, String description, int health, int attack, int defense) {
		this.name = name;
		this.description = description;
		this.health = health;
		this.attack = attack;
		this.defense = defense;
	}
	
	public String getName() {
		return name;
	}
	
	public String getDesc() {
		return description;
	}
	
	public void use(Item item) {
		
	}
	
	public void attack(Character character) {
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
}
