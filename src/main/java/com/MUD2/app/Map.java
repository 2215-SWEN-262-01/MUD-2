package com.MUD2.app;

/**
 * A Map is a collection of Rooms
 * 
 * @author Peyton Martin
 */
public class Map {
    public Map(){}

    private Room[] rooms;

    public Room[] getRooms() {return rooms;}
    public void setRooms(Room[] rooms) {this.rooms = rooms;}
}
