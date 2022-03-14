package com.MUD2.app;

public class GameInput {
	public void displayRoom(Room room) {
		for (int y = 0; y < room.height; y++) {
			for (int x = 0; x < room.width; x++) {
				Tile tile = room.getTile(x, y);
				char tileChar = ' '; //Empty tile
				
				if (tile instanceof ObstacleTile)
					tileChar = '#';
				if (tile instanceof TrapTile)
					tileChar = ' '; //looks identical to empty
				//Might be a good idea to keep track of whether trap is sprung, 
				//then change it to look different afterwards
				if (tile instanceof ChestTile)
					tileChar = '=';
				if (tile instanceof ExitTile)
					tileChar = '_';
				if (tile.character instanceof PlayerCharacter)
					tileChar = '@';
				if ((tile.character instanceof GameCharacter) && !(tile.character instanceof PlayerCharacter))
					tileChar = '!';
				System.out.print(tileChar);
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		
	}
}