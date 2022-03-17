package com.MUD2.app;

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
		Bag bag = chest.getInventory().getBags()[0];
		bag.addItem(sword);
		bag.addItem(rock);
		tilemap[2][2] = chest;



		Room room1 = new Room(tilemap, 5, 6, "A normal room");
		Room[] rooms = new Room[1];
		rooms[0] = room1;
		return new Map(rooms, rooms[0]);
	}
}