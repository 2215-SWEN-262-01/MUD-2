package com.MUD2.app.inventory;

/**
 * A visitor for viewing Items
 * 
 * @author Jack Ganger-Spivak
 */
public interface InventoryVisitor {
    void visit(Item item);
}
