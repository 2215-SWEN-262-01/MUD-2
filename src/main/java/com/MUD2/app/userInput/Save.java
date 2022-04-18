package com.MUD2.app.userInput;

/*
import Character
import Bag
import Inventory
import Room
//We don't need these imports while the project is all in one package
*/
import java.io.IOException;
import java.io.File;
import java.io.FileWriter;

/**
 * Saves the current game state into a CSV
 *
 * @author Noah Pelletier
 */

public class Save {
	public static void main(String[] args) throws IOException {
		String[][] saveStats = {
				//Save, comma seperated{}

		};

		File csvFile = new File("saveStats.csv");
		FileWriter fileWriter = new FileWriter(csvFile);


		for (String[] data : saveStats) {
			StringBuilder line = new StringBuilder();
			for (int i = 0; i < data.length; i++) {
				line.append("\"");
				line.append(data[i].replaceAll("\"","\"\""));
				line.append("\"");
				if (i != data.length - 1) {
					line.append(',');
				}
			}
			line.append("\n");
			fileWriter.write(line.toString());
		}
		fileWriter.close();
	}
}