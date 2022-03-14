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
	
	public static Map loadDefaultMap() {
		Tile[][] tilemap = new Tile[5][6];
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 6; j++) {
				tilemap[i][j] = new EmptyTile(i, j, null);
			}
		}
		
		Room room1 = new Room(tilemap, 5, 6, "A normal room");
		Room[] rooms = new Room[1];
		rooms[0] = room1;
		return new Map(rooms, rooms[0]);
	}
}