package com.MUD2.app.userInput;

import com.MUD2.app.PlayerCharacter;
import com.MUD2.app.inventory.*;

public class UseItem implements Command {
/**
* UseItem is a command created so that a player will be able to use an item from their inventory. 
* 
* @author Jahmir Hinds
*/
   private PlayerCharacter player;
   private String itemName;

   /**
    * Constructor for the UseItem class
    * @param player The player parameter is the character of the player attempting to drop an item.
    * @param item is the item the player is attempting to use.
    */
    public UseItem (PlayerCharacter player,String item) {
        this.player = player;
        this.itemName = item;
    }
    /**
     * When this method is used the player will attempt to use the selected item.
     */
    @Override
    public void execute() {
        Inventory temp = player.getInventory();
            Bag[] bags = temp.getBags();
            for (int i = 0; i<bags.length;i++ ) {
                if (bags[i] != null) {
                    Item item = bags[i].getItemByName(itemName);
                    if (item != null) {
                        if (item instanceof Equippable) {
                            ((Equippable) item).equip(player);
                            bags[i].removeItem(item);
							System.out.println("Equipped " + itemName);
                            return;
                        }
						if (item instanceof Consumable) {
                            ((Consumable) item).use(player);
                            bags[i].removeItem(item);
							System.out.println("Used " + itemName);
                            return;
                        } else {
							System.out.println("Item not usable");
							return;
						}
                    }
                }
            }
            System.out.println("Item Not Found");
        }
    }



