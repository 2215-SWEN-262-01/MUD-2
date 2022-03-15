package com.MUD2.app;
import java.util.Scanner;

public class GameInput {
	public static void displayRoom(Room room) {
		for (int y = 0; y < room.getHeight(); y++) {
			for (int x = 0; x < room.getWidth(); x++) {
				Tile tile = room.getTile(x, y);
				char tileChar = '_'; //Empty tile
				
				if (tile instanceof ObstacleTile)
					tileChar = '#';
				if (tile instanceof TrapTile)
					tileChar = '_'; //looks identical to empty
				//Might be a good idea to keep track of whether trap is sprung, 
				//then change it to look different afterwards
				if (tile instanceof ChestTile)
					tileChar = '=';
				if (tile instanceof ExitTile)
					tileChar = 'D';
				if (tile.getCharacter() instanceof PlayerCharacter)
					tileChar = '@';
				if (tile.getCharacter() instanceof NPC)
					tileChar = '!';
				System.out.print(tileChar);
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		System.out.println("Welcome to M.U.D! Enter help for controls");
		
		Scanner scanner = new Scanner(System.in);
		Map map = Map.loadDefaultMap();
		Room room = map.getCurrentRoom();
		Tile start = room.getTile(3, 3);
		assert(start != null);
		PlayerCharacter player = new PlayerCharacter("Lonk", "The Hero", start);
		start.setCharacter(player);
		displayRoom(room);

		while (!handleInput(scanner, player, map.getCurrentRoom())) {
			displayRoom(map.getCurrentRoom());
		}
		System.out.println("Quitting...");
		scanner.close();
	}
	
	/**
	* Parses and handles one line of user input
	* @return whether the user quit
	*/
	public static boolean handleInput(Scanner input, PlayerCharacter player, Room room) {
		System.out.print(": ");
		String[] command = input.nextLine().split(" ");
		Tile currentTile = player.getCurrentTile();
		int x = currentTile.getHorizantalLocation();
		int y = currentTile.getVerticalLocation();
		Move move;
		switch (command[0]) {
			case "quit":
				return true;
			case "help":
				System.out.println("Here are the commands that can be entered: ");
				System.out.println("\tquit: quits the game");
				System.out.println("\thelp: show this menu");
				System.out.println("\t<w/a/s/d>: Moves your character");
				System.out.println("\tloot: Add items to inventory");
				System.out.println("\tinv: Show player inventory");
				System.out.println("\tuse: Uses or equips an item");
				break;
			case "w":
				move = new Move(player, room, x, y-1);
				move.execute();
				break;
			case "a":
				move = new Move(player, room, x-1, y);
				move.execute();
				break;
			case "s":
				move = new Move(player, room, x, y+1);
				move.execute();
				break;
			case "d":
				move = new Move(player, room, x+1, y);
				move.execute();
				break;
			case "loot":
				if (currentTile instanceof ChestTile) {
					Loot loot = new Loot(player, ((ChestTile) currentTile).getInventory());
					loot.execute();
					room.convertToEmptyTile(x, y);
				} else {
					System.out.println("No items to loot here...");
				}
				break;
			case "inv":
				displayInventory(player);
				break;
			case "use":
				try {
					//noinspection Since15
					String itemName = String.join(" ", command).replace("use ", "");
					UseItem use = new UseItem(player, itemName);
					use.execute();
					System.out.println("Equipped " + itemName);
				} catch (IndexOutOfBoundsException e) {
					System.out.println("Please enter the name of the item you want to use");
				}
				break;
		}
		return false;
	}

	public static void displayInventory(PlayerCharacter player) {
		Bag[] bags = player.getInventory().getBags();
		System.out.println("Available Space: " + player.getInventory().getSpace());
		//System.out.println("Total Gold: " + player.getInventory().getTotalGold());
		if (player.getCurrentWeapon() != null)
			System.out.println("Equipped Weapon: " + player.getCurrentWeapon().getName());
		if (player.getCurrentArmor() != null)
			System.out.println("Equipped Armor: " + player.getCurrentArmor().getName());

		for (int i = 0; i < bags.length; i++) {
			if (bags[i] != null) {
				System.out.println("Bag " + i + ": " + bags[i].size() + " items");
				for (Item item : bags[i]) {
					System.out.print(item.getName() + ": " + item.getDescription() +
							", " + item.getGoldValue() +" gold");
					if (item instanceof Equippable) {
						System.out.print(" (Equippable)");
					}
					if (item instanceof Consumable) {
						System.out.print(" (Consumable)");
					}
					System.out.println();
				}
				System.out.println();
			}
		}
	}
}