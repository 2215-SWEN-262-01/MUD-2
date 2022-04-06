package com.MUD2.app;

/**
 * A map is a collection of rooms that the client will be able to play on.
 */
public class Map {
	private Room[] rooms;
	private Room currentRoom;

	public Map(Room[] rooms, Room currentRoom) {
		this.rooms = rooms;
		this.currentRoom = currentRoom;
	}
	
	public Room getCurrentRoom() {
		return this.currentRoom;
	}

	public void setCurrentRoom(Room currentRoom) {
		this.currentRoom = currentRoom;
	}
	
	public static Map loadDefaultMap() {
		Tile[][] tilemap = new Tile[5][6];
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 6; j++) {
				tilemap[i][j] = new EmptyTile(i, j, null);
			}
		}
		
		ChestTile chest = new ChestTile(2, 2, null, new Inventory());
		Weapon sword = new Weapon("Master Sword", "The Blade of Evil's Bane", 50, 10);
		Item rock = new Item("Rock", "It's just a rock", 2);
		Food bread = new Food("Bread", "A somewhat-stale loaf of bread", 5, 20);
		Bag bag = chest.getInventory().getBags()[0];
		bag.addItem(sword);
		bag.addItem(rock);
		bag.addItem(bread);
		tilemap[2][2] = chest;

		NPC enemy = new NPC("Gerblin", "A common foe", tilemap[4][4]);
		Item gem = new Item("Ruby", "A shiny and valuable gem", 30);
		enemy.getInventory().getBags()[0].addItem(gem);
		tilemap[4][4].setCharacter(enemy);

		Room room1 = new Room(tilemap, 5, 6, "A normal room");
		
		Tile[][] tilemap2 = new Tile[3][3];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				tilemap2[i][j] = new EmptyTile(i, j, null);
			}
		}
		
		ChestTile chest2 = new ChestTile(1, 1, null, new Inventory());
		Weapon bread_weapon = new Weapon("Bread Sword", "The finest blade cut from weapons-grade bread", 10, 5);
		chest2.getInventory().getBags()[0].addItem(bread_weapon);
		tilemap2[1][1] = chest2;
		Room room2 = new Room(tilemap2, 3, 3, "A small room");

		ExitTile exit_1_2 = new ExitTile(0, 3, null, room2);
		ExitTile exit_2_1 = new ExitTile(2, 2, null, room1);
		exit_1_2.setOtherExit(exit_2_1);
		exit_2_1.setOtherExit(exit_1_2);
		room1.setTile(0, 2, exit_1_2);
		room2.setTile(2, 2, exit_2_1);

		Room[] rooms = new Room[2];
		rooms[0] = room1;
		rooms[1] = room2;
		return new Map(rooms, rooms[0]);
	}
}