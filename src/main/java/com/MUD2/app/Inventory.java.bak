package com.MUD2.app;

import java.util.Iterator;

public class Inventory {
	
	private Bag[] bags;
	
	public Inventory() {
		this.bags = new Bag[] {new Bag(6), null, null, null, null, null};
	}
	

	public int getSpace() {
		int totalSpace = 0;
		for(Bag bag : this.bags) {
			if(bag != null) {
				totalSpace += bag.getSpace();
			}
		}
		return totalSpace;
	}

	public int getTotalGoldInBag(int bagID) {
		TotalGoldVisitor visitor = new TotalGoldVisitor();
		for (Item item : this.bags[bagID]) {
			visitor.visit(item);
		}
		return visitor.getTotalGold();
	}

	public int getTotalGold() {
		int result = 0;
		for (int i = 0; i < this.bags.length; i++) {
			result += getTotalGoldInBag(i);
		}
		return result;
	}

	public Item[] getEquippableItems() {
		EquippableVistor visitor = new EquippableVistor();
		for (Bag bag : this.bags) {
			if (bag != null) {
				for (Item item : bag) {
					visitor.visit(item);
				}
			}
		}
		return visitor.getEquippableItems();
	}

	public Bag[] getBags() {
		return bags;
	}
}
