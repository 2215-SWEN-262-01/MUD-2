package com.MUD2.app.tile;

import com.MUD2.app.NPC;
import com.MUD2.app.inventory.*;

import java.util.ArrayList;
import java.util.List;

/**
 * A map is a collection of rooms that the client will be able to play on.
 */
public class Map {
	
	private static List<String> premadeMapList;
	static {
		premadeMapList = new ArrayList<>();
		premadeMapList.add("Classic Dungeon");
		premadeMapList.add("Dungeon of Crafters");
	}
	
	private Room[] rooms;
	private Room currentRoom;
	
	public Map(Room[] rooms, Room currentRoom) {
		this.rooms = rooms;
		this.currentRoom = currentRoom;
	}
	
	public static void listPremadeMaps() {
		for(String name : premadeMapList) {
			System.out.println(name);
		}
	}	
	
	public static Map generateMap(String mapName) {
		if(mapName.equals("Classic Dungeon")) {
			//Dungeon One gen
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
			tilemap[1][1] = new ObstacleTile(1, 1, null);

			Room room1 = new Room(tilemap, 5, 6, "A normal room");
			
			Tile[][] tilemap2 = new Tile[5][3];
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 3; j++) {
					tilemap2[i][j] = new EmptyTile(i, j, null);
				}
			}
			
			ChestTile chest2 = new ChestTile(3, 1, null, new Inventory());
			Weapon bread_weapon = new Weapon("Bread Sword", "The finest blade cut from weapons-grade bread", 10, 5);
			Armor armor = new Armor("Leather Armor", "A sturdy set of armor fit for a new adventurer", 20, 8);
			Bag chest2_bag = chest2.getInventory().getBags()[0];
			chest2_bag.addItem(bread_weapon);
			chest2_bag.addItem(armor);
			tilemap2[3][1] = chest2;
			Room room2 = new Room(tilemap2, 5, 3, "A small room");
			
			tilemap2[1][0] = new ObstacleTile(1, 0, null);
			tilemap2[1][2] = new ObstacleTile(1, 2, null);
			
			NPC boss = new NPC("Golem", "Massive beast", tilemap2[1][1]);
			boss.setAttack(13);
			boss.setDefense(13);
			Item othergem = new Item("Ruby", "A shiny and valuable gem", 30);
			boss.getInventory().getBags()[0].addItem(othergem);
			tilemap2[1][1].setCharacter(boss);

			ExitTile exit_1_2 = new ExitTile(0, 3, null, room2);
			ExitTile exit_2_1 = new ExitTile(4, 2, null, room1);
			exit_1_2.setOtherExit(exit_2_1);
			exit_2_1.setOtherExit(exit_1_2);
			room1.setTile(0, 2, exit_1_2);
			room2.setTile(4, 2, exit_2_1);

			Room[] rooms = new Room[2];
			rooms[0] = room1;
			rooms[1] = room2;
			room2.setTile(0, 1, new GoalTile(0, 1, null));
			return new Map(rooms, rooms[0]);
		} else if(mapName.equals("Dungeon of Crafters")) {
			//Dungeon Two gen
			Tile[][] tilemap = new Tile[10][5];
			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < 5; j++) {
					tilemap[i][j] = new EmptyTile(i, j, null);
				}
			}
			
			ChestTile chest1 = new ChestTile(5, 4, null, new Inventory());
			Weapon sword = new Weapon("Iron Sword", "Sword crafted from smelted iron bars", 30, 7);
			Item cobble = new Item("Cobblestone", "Some cobble", 2);
			Food apple = new Food("Apple", "Nutritious red fruit", 7, 26);
			Bag bag = chest1.getInventory().getBags()[0];
			bag.addItem(sword);
			bag.addItem(cobble);
			bag.addItem(apple);
			tilemap[5][4] = chest1;

			NPC enemy = new NPC("Skeleton", "Enemy of Bones", tilemap[4][3]);
			Item emerald = new Item("Emerald", "Rare green gem", 60);
			enemy.getInventory().getBags()[0].addItem(emerald);
			tilemap[4][3].setCharacter(enemy);
			tilemap[8][2] = new ObstacleTile(1, 2, null);

			Room room1 = new Room(tilemap, 10, 5, "A normal room");
			
			Tile[][] tilemap2 = new Tile[10][3];
			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < 3; j++) {
					tilemap2[i][j] = new EmptyTile(i, j, null);
				}
			}
			
			ChestTile chest2 = new ChestTile(5, 1, null, new Inventory());
			Food steak = new Food("Steak", "Delicious, well cooked steak", 18, 39);
			Armor armor = new Armor("Chainmail Armor", "Rare and protective set of armor", 50, 10);
			Bag chest2_bag = chest2.getInventory().getBags()[0];
			chest2_bag.addItem(steak);
			chest2_bag.addItem(armor);
			tilemap2[5][1] = chest2;
			Room room2 = new Room(tilemap2, 10, 3, "A long room");
			
			Tile[][] tilemap3 = new Tile[3][6];
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 6; j++) {
					tilemap3[i][j] = new EmptyTile(i, j, null);
				}
			}
			
			NPC zombie = new NPC("Zombie", "Undead foe", tilemap3[2][2]);
			Weapon diamond_sword = new Weapon("Diamond Sword", "Sword crafted from the finest diamonds", 60, 16);
			Food carrot = new Food("Carrot", "Orange vegetable", 10, 24);
			zombie.getInventory().getBags()[0].addItem(diamond_sword);
			zombie.getInventory().getBags()[0].addItem(carrot);
			tilemap3[2][2].setCharacter(zombie);
			
			NPC spider = new NPC("Spider", "Creepy enemy", tilemap3[0][1]);
			Food chicken = new Food("Cooked Chicken", "Well cooked chicken breast", 14, 34);
			spider.getInventory().getBags()[0].addItem(chicken);
			tilemap3[0][1].setCharacter(spider);
			
			tilemap3[0][4] = new ObstacleTile(0, 4, null);
			tilemap3[2][4] = new ObstacleTile(2, 4, null);
			
			NPC boss = new NPC("Wither Skeleton", "A creature; strong and deadly from the depths of hell", tilemap3[1][4]);
			boss.setAttack(19);
			boss.setDefense(15);
			Item diamond = new Item("Diamond", "Rare blue gem", 70);
			boss.getInventory().getBags()[0].addItem(diamond);
			tilemap3[1][4].setCharacter(boss);
			
			Room room3 = new Room(tilemap3, 3, 6, "a tall room");

			ExitTile exit_1_2 = new ExitTile(9, 2, null, room2);
			ExitTile exit_2_1 = new ExitTile(0, 1, null, room1);
			ExitTile exit_2_3 = new ExitTile(9, 1, null, room3);
			ExitTile exit_3_2 = new ExitTile(1, 0, null, room2);
			exit_1_2.setOtherExit(exit_2_1);
			exit_2_1.setOtherExit(exit_1_2);
			exit_2_3.setOtherExit(exit_3_2);
			exit_3_2.setOtherExit(exit_2_3);
			room1.setTile(9, 2, exit_1_2);
			room2.setTile(0, 1, exit_2_1);
			room2.setTile(9, 1, exit_2_3);
			room3.setTile(1, 0, exit_3_2);
			room3.setTile(1, 5, new GoalTile(1, 5, null));

			Room[] rooms = new Room[3];
			rooms[0] = room1;
			rooms[1] = room2;
			rooms[2] = room3;
			return new Map(rooms, rooms[0]);
		} else {
			return null;
		}
	}
	
	public Room getCurrentRoom() {
		return this.currentRoom;
	}

	public void setCurrentRoom(Room currentRoom) {
		this.currentRoom = currentRoom;
	}
}