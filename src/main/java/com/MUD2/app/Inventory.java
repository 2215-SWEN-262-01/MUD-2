package com.MUD2.app;

public class Inventory {
	
	private Bag[] bags;
	
	public Inventory() {
		this.bags = new Bag[] {new Bag(6), null, null, null, null, null};
	}
	

	public int getSpace() {
		int totalSpace = 0;
		for(Bag bag : bags) {
			if(bag != null) {
				totalSpace += bag.getSpace();
			}
		}
		return totalSpace;
	}
}
