package com.MUD2.app.userInput;
import java.util.Scanner;

import com.MUD2.app.*;
import com.MUD2.app.inventory.*;
import com.MUD2.app.tile.*;


/**
 * Class to conduct console input for the player to control the game in a loop. Serves as the application entry point
 * 
 * @author Jack Ganger-Spivak
 */
public class GameInput {
	/**
	 * Prints out an ASCII representation of the current room
	 * @param room The room to display
	 */
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
				if (tile instanceof GoalTile) {
					tileChar = '$';
				}
				System.out.print(tileChar);
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		System.out.println("Welcome to M.U.D! Enter help for controls");
		
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter your name: ");
		String name = scanner.nextLine();
		System.out.print("Enter a description of your character: ");
		String desc = scanner.nextLine();
		
		Map map = null;
		while(map == null) {
			System.out.println("Choose a map: ");
			Map.listPremadeMaps();
			String mapChoice = scanner.nextLine();
			map = Map.generateMap(mapChoice);
		}
		Room room = map.getCurrentRoom();
		Tile start = room.getTile(2, 2);

		PlayerCharacter player = new PlayerCharacter(name, desc, start);
		start.setCharacter(player);
		displayRoom(room);

		while (!handleInput(scanner, player, map.getCurrentRoom(), map)) {
			displayRoom(map.getCurrentRoom());
		}
		System.out.println("Quitting...");
		scanner.close();
	}
	
	/**
	* Parses and handles one line of user input
	* @return whether the user quit or lost the game
	*/
	public static boolean handleInput(Scanner input, PlayerCharacter player, Room room, Map map) {
		if (player.getDefeated())
			return true;
		System.out.print(": ");
		String[] command = input.nextLine().split(" ");
		Tile currentTile = player.getCurrentTile();
		if(currentTile instanceof GoalTile) {
			return true;
		}
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
				System.out.println("\tuse <item name>: Uses or equips an item");
				System.out.println("\tstats: Shows player stats");
				System.out.println("\texportgame: exports game to CSV file\n");
				System.out.println("Map Key: ");
				System.out.println("\t@: Player");
				System.out.println("\t_: Empty Space");
				System.out.println("\t=: Chest");
				System.out.println("\t!: Enemy");
				System.out.println("\tD: Room Exit");
				System.out.println("\t#: Obstacle");
				break;
			case "w":
				move = new Move(player, room, map, x, y-1);
				move.execute();
				break;
			case "a":
				move = new Move(player, room, map, x-1, y);
				move.execute();
				break;
			case "s":
				move = new Move(player, room, map, x, y+1);
				move.execute();
				break;
			case "d":
				move = new Move(player, room, map, x+1, y);
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
					
				} catch (IndexOutOfBoundsException e) {
					System.out.println("Please enter the name of the item you want to use");
				}
				break;
			case "stats":
				System.out.println("Player Stats:");
				System.out.println("Health: " + player.getHealth() + "/" + player.getMaxHealth());
				System.out.println("Attack: " + player.getAttack());
				System.out.println("Defense: " + player.getDefense());
				break;
			case "exportgame":
				Command export = new ExportGame(FileType.CSV, player, room, map);
				export.execute();
				return true;
		}
		return false;
	}
	
	/**
	 * Displays the player's current inventory and equipped items
	 * @param player the player to show the inventory of
	 */
	public static void displayInventory(PlayerCharacter player) {
		Bag[] bags = player.getInventory().getBags();
		System.out.println("Available Space: " + player.getInventory().getSpace());
		System.out.println("Total Gold: " + player.getInventory().getTotalGold());
		if (player.getCurrentWeapon() != null)
			System.out.println("Equipped Weapon: " + player.getCurrentWeapon().getName());
		if (player.getCurrentArmor() != null)
			System.out.println("Equipped Armor: " + player.getCurrentArmor().getName());

		for (int i = 0; i < bags.length; i++) {
			if (bags[i] != null) {
				System.out.println("Bag " + i + ": " + bags[i].size() + " items");
				for (Item item : bags[i]) {
					System.out.print("\t"+item.getName() + ": " + item.getDescription() +
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