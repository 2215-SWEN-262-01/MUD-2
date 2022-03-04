package com.MUD2.app;

public class Attack implements Command{
/**
  * An attack is a command created so that the
  * player character can make an attack against an enemy NPC.
  *
  * @author Jahmir Hinds
  */
    private PlayerCharacter player;
    private NPC target;
    /**
     * @param player The player parameter is the player character that will be making the attack.
     * @param target The target parameter is the NPC that the player will be attempting to hit.
     */
    public Attack (PlayerCharacter player, NPC target) {
       this.player = player;
       this.target = target;
    }
    /**
     * This method will carry out the players action of attacking the target.
     */
    @Override
    public void execute() {

    }
    
}
