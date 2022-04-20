package com.MUD2.app;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.util.List;

/**
 * Command for exporting a game file
 * @author Zachary Montgomery
 */
public class ExportGame implements Command {
	private FileType type;
	private PlayerCharacter player;
	private Room room;
	private Map map;
	
	public ExportGame(FileType type, PlayerCharacter player, Room room, Map map) {
		this.type = type;
		this.player = player;
		this.room = room;
		this.map = map;
	}

	@Override
	public void execute(){
		if(type.equals(FileType.CSV)) {
			File dir = new File("gamesaves");
			if(!dir.exists()) {
				dir.mkdir();
			}
			File file = new File("gamesaves/save.csv");
			PrintWriter writer;
			try {
				writer = new PrintWriter(file);
				
				//Saving happens here
				
				writer.close();
			} catch (FileNotFoundException e) {
				//squash
			}
		
			
		} else if(type.equals(FileType.XML)) {
			
		} else if(type.equals(FileType.JSON)) {
			
		}
	}
	
}
