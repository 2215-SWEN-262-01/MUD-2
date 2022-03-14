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
}