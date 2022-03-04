package com.MUD2.app;

import java.util.HashSet;
import java.util.Set;

public class Bag {
	private Set<Item> items;
	private int capacity;
	
	public Bag(int capacity) {
		this.items = new HashSet<>();
		this.capacity = capacity;
	}
	
	public int getSpace() {
		return capacity - items.size();
	}
	
}
