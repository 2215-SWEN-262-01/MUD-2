package com.MUD2.app;

import java.util.Iterator;

public class Loot implements Command {
/**
 * A command that is made whenever a player attempts to loot an item.
 * 
 * @author Jahmir Hinds
 */
    private PlayerCharacter player;
    private Inventory inventory;

    /**
     * Constructor for the loot class
     * @param player the player character
     * @param inventory the inventory that a player will take the items from.
     */
    public Loot (PlayerCharacter player, Inventory inventory) {
        this.player = player;
        this.inventory = inventory;
    }

    /**
     * When used the player will attempt to loot an item.
     */
    @Override
    public void execute() {
        Bag[] bags = inventory.getBags();
        Bag bag = bags[0];
        Inventory inv = player.getInventory();
        Bag[] playerBags = inv.getBags();
        for (Item item : bag) {
            if (inv.getSpace() == 0) {
                System.out.println("Your bag is full!");
            } else {
                for ( Bag checkbag : inv.getBags()) {
                    if (checkbag.getSpace() > 0) {
                        checkbag.addItem(item);
                        break;
                    }
                }
            }
        }
    }
}
