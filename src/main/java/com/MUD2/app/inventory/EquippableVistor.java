package com.MUD2.app.inventory;

import java.util.LinkedList;

public class EquippableVistor implements InventoryVisitor {
    private LinkedList<Item> items = new LinkedList<>();

    @Override
    public void visit(Item item) {
        if (item instanceof Equippable)
            items.add(item);
    }

    public Item[] getEquippableItems() {
        return items.toArray(new Item[0]);
    }
}
