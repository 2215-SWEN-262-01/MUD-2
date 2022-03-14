package com.MUD2.app;

public class Main {
	public static void main(String[] args) {
		PlayerCharacter me = new PlayerCharacter("NuclearMario", "cool guy");
		
		Armor helm = new Armor("leather helm", "defensive helm of leather", 20, 5);
		Armor chest = new Armor("iron chestplate", "chestplate of iron", 50, 8);
		Weapon sword = new Weapon("big sword", "a big sword", 30, 6);
		Weapon knife = new Weapon("smol knife", "a smol knife", 20, 4);
		
		System.out.println(me);
		me.equipArmor(helm);
		me.equipArmor(chest);
		me.equipWeapon(sword);
		me.equipWeapon(knife);
		
		
		
		NPC enemy = new NPC("zombie", "undead enemy");
		
		
		System.out.println(enemy);
		System.out.println(me);
		enemy.attack(me);
		me.attack(enemy);
		System.out.println(enemy);
		System.out.println(me);
	}
}
