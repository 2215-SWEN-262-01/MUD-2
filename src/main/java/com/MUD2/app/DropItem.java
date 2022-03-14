package com.MUD2.app;

public class DropItem implements Command {
/**
 * DropItem is a command created so that a player will be able to remove an item from their inventory. 
 * 
 * @author Jahmir Hinds
 */
    private PlayerCharacter player;
    private String itemName;
    /**
     * Constructor for the DropItem class
     * @param player The player parameter is the character of the player attempting to drop an item.
     * @param itemName is the name of the item the player is attempting to drop.
     */
    public DropItem (PlayerCharacter player,String itemName) {
        this.player = player;
        this.itemName = itemName;
    }
    /**
     * When this method is used the selected item will be removed from the player's inventory.
     */
    @Override
    public void execute() {
        Inventory temp = player.getInventory();
        if (temp.getSpace() >= 1) {
            Bag[] bags = temp.getBags();
            for (int i = 0; i<bags.length;i++ ) {
                Item item = bags[i].getItemByName(itemName);
                if (item != null) {
                    bags[i].removeItem(item);
                    break;
                }
            }
            System.out.println("Item Not Found");
        } else {
            System.out.println("Your bag is full!");
        }
    }
    
}
