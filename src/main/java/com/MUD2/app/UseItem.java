package com.MUD2.app;

public class UseItem implements Command {
/**
* UseItem is a command created so that a player will be able to use an item from their inventory. 
* 
* @author Jahmir Hinds
*/
   private PlayerCharacter player;
   private Item item;

   /**
    * Constructor for the UseItem class
    * @param player The player parameter is the character of the player attempting to drop an item.
    * @param item is the item the player is attempting to use.
    */
    public UseItem (PlayerCharacter player,Item item) {
        this.player = player;
        this.item = item;
    }
    /**
     * When this method is used the player will attempt to use the selected item.
     */
    @Override
    public void execute() {
        if (item instanceof Consumable) {
            item.use(player);
        } else {
            item.equip(player);
        }
    }


}
