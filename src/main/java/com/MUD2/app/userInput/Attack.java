package com.MUD2.app.userInput;

import com.MUD2.app.GameCharacter;
import com.MUD2.app.PlayerCharacter;
import com.MUD2.app.tile.*;

public class Attack implements Command{
/**
  * An attack is a command created so that the
  * player character can make an attack against an enemy NPC.
  *
  * @author Jahmir Hinds
  */
    private PlayerCharacter player;
    private GameCharacter target;
	private Room room;
    /**
     * @param player The player parameter is the player character that will be making the attack.
     * @param target The target parameter is the NPC that the player will be attempting to hit.
     */
    public Attack (PlayerCharacter player, GameCharacter target, Room room) {
       this.player = player;
       this.target = target;
	   this.room = room;
    }
    /**
     * This method will carry out the players action of attacking the target.
     */
    @Override
    public void execute() {
		
        int damage = player.attack(target);
		System.out.println("You attack the " + target.getName() + " for " + damage + " damage.");
		System.out.println("The " + target.getName() + " has " + target.getHealth() + " health remaining.");
		if (target.getDefeated()) {
			Tile tile = target.getCurrentTile();
			int x = tile.getHorizantalLocation();
			int y = tile.getVerticalLocation();
			room.setTile(x, y, new ChestTile(x, y, null, target.getInventory()));
		}
			
		damage = target.attack(player);
		if (!player.getDefeated()) {
			System.out.println("The " + target.getName() + " counter-attacks you for " + damage + " damage.");
			System.out.println("You have " + player.getHealth() + " health remaining.");
		}
		
    }
    
}
