package com.MUD2.app.inventory;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


/**
 * A bag is an item that the player character can equip to make their inventory size larger
 * 
 * @author Zachary Montgomery
 */
public class Bag implements Iterable<Item> {
	private Set<Item> items;
	private final int capacity;
	
	public Bag(int capacity) {
		this.items = new HashSet<>();
		this.capacity = capacity;
	}
	
	public int getSpace() {
		return capacity - items.size();
	}

	public void addItem(Item item) {
		items.add(item);
	}

	public void removeItem(Item item) {
		items.remove(item);
	}

	public Item getItemByName(String name) {
		for (Item i : this) {
			if (i.getName().equalsIgnoreCase(name)) {
				return i;
			}
		}
		return null;
	}
	@Override
	public Iterator<Item> iterator() {
		return items.iterator();
	}

	public int size() {
		return items.size();
	}
}
