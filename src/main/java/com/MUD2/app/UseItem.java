package com.MUD2.app;

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
                Item item = bags[i].getItemByName(itemName);
                if (item != null) {
                    if (item instanceof Equippable) {
                        ((Equippable) item).equip(player);
                    } else {
                        ((Consumable) item).use(player);
                        bags[i].removeItem(item);
                    }
                    break;
                }
            }
            System.out.println("Item Not Found");
        }
    }



