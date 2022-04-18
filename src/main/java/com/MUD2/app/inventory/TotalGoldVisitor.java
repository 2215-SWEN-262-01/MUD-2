package com.MUD2.app.inventory;

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
