package com.MUD2.app.tile;

import java.util.Scanner;

import com.MUD2.app.GameCharacter;
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
}
