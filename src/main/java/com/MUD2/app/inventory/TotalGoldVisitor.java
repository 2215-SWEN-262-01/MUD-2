package com.MUD2.app.inventory;

/**
 * A visitor for viewing the amount of gold a Character has
 * 
 * @author Jack Ganger-Spivak
 */
public class TotalGoldVisitor implements InventoryVisitor {
    private int totalGold;

    @Override
    public void visit(Item item) {
        totalGold += item.getGoldValue();
    }

    public int getTotalGold() {
        return totalGold;
    }
}
