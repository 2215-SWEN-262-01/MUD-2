package com.MUD2.app;

import com.MUD2.app.inventory.*;
import com.MUD2.app.tile.*;

/**
 * The Player character is a game character that is controlled by the client
 * 
 * @author Zachary Montgomery
 */
public class PlayerCharacter extends GameCharacter{
	public static final int MAX_HEALTH = 100;
	public static final int DEFAULT_ATTACK = 10;
	public static final int DEFAULT_DEFENSE = 0;
	
	private Weapon currentWeapon;
	private Armor currentArmor;
	private ShrineImprint imprint;
	private int kills;

	public PlayerCharacter(String name, String description, Tile tile) {
		super(name, description, MAX_HEALTH, DEFAULT_ATTACK, DEFAULT_DEFENSE, tile);
		this.currentArmor = null;
		this.currentWeapon = null;
		this.imprint = null;
		this.kills = 0;
	}

	public void equipWeapon(Weapon weapon) {
		if(currentWeapon != null) {
			this.setAttack(this.getAttack() - currentWeapon.getAttack());
			this.addItemToInventory(currentWeapon);
		}
		this.currentWeapon = weapon; 
		this.setAttack(this.getAttack() + currentWeapon.getAttack());
	}

	public void equipArmor(Armor armor) { 
		if(currentArmor != null) {
			this.setDefense(this.getDefense() - currentArmor.getDefense());
			this.addItemToInventory(currentArmor);
		}
		this.currentArmor = armor; 
		this.setDefense(this.getDefense() + currentArmor.getDefense());
	}

	public Weapon getCurrentWeapon() {
		return currentWeapon;
	}

	public Armor getCurrentArmor() {
		return currentArmor;
	}
  
	public void setShrineImprint(ShrineImprint shrineImprint) {
		this.imprint = shrineImprint;
	}

	@Override
	protected void onDefeat() {
		if (imprint == null) {
			this.setDefeated(true);
			System.out.println("You died! Game over...");
			return;
		} else {
			setDefense(imprint.getDefense());
			setAttack(imprint.getAttack());
			setCurrentHealth(imprint.getHealth());
			System.out.println("You were saved by your prayers!");
			this.imprint = null;
			return;
		}
	}

}
