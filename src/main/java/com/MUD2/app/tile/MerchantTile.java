package com.MUD2.app.tile;

import java.util.Scanner;

import com.MUD2.app.GameCharacter;
import com.MUD2.app.inventory.Bag;
import com.MUD2.app.inventory.Item;

/**
 * A MerchantTile is a tile where a player can buy and sell items
 * 
 * @author Peyton Martin
 */
public class MerchantTile extends Tile {
    private Item items[];
    private boolean isOpen;

    public MerchantTile(int horizantalLocation, int verticalLocation, GameCharacter character, Item items[], boolean isOpen) {
        super(horizantalLocation, verticalLocation, character);
        this.items = items;
        this.isOpen = isOpen;
    }

    public Item buy(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("This Merchant contains the following Items");
        for (int i=0; i<items.length; i++) {
            System.out.println(i + ""+ items[i] + ", ");
        }
        System.out.println("Type the number of the desired item, or 'c' to cancel");
        String input = scanner.nextLine();
        scanner.close();

        if (input == "c") {
            return null;
        }
        else {
            try {
                int x = Integer.parseInt(input);
                return items[x];
            } catch (Exception e) {
                System.out.println("Incorrect input");
            }
        }

        return null;
    }

    public void sell() {
        Scanner scanner = new Scanner(System.in);
        Bag[] bags = this.getCharacter().getInventory().getBags();
        
        System.out.println("You contain the following Items");
        
        for (int i = 0; i < bags.length; i++) {
			if (bags[i] != null) {
				System.out.println("Bag " + i + ": " + bags[i].size() + " items");
				for (Item item : bags[i]) {
					System.out.print("\t"+item.getName() + ": " + item.getDescription() +
							", " + item.getGoldValue() +" gold");
					System.out.println();
				}
				System.out.println();
			}
		}

        System.out.println("Type the name of the desired item, or 'c' to cancel");
        String input = scanner.nextLine();
        scanner.close();

        if (input == "c") {
            System.out.println("No items sold");
            return;
        }
        else {
            try {
                for (int i = 0; i < bags.length; i++) {
                    if (bags[i] != null) {
                        Item toSell = bags[i].getItemByName(input);
                        if (toSell != null) {
                            bags[i].removeItem(toSell);
                            System.out.println("Item sold");
                            return;
                        }
                    }
                }
            } catch (Exception e) {
                System.out.println("Incorrect input");
            }
        }
        System.out.println("Item not sold");
    }

    public Item[] getItems() {
        return items;
    }
    public boolean getIsOpen() {
        return isOpen;
    }
    public void setIsOpen(boolean isOpen) {
        this.isOpen = isOpen;
    }

    @Override
    public String export() {
        // TODO needs implementation
        return "";
    }
}
