package com.MUD2.app;

import Character
import Bag
import Inventory
import Room

/**
 * Saves the current game state into a CSV
 *
 * @author Noah Pelletier
 */
public class Save {
    //public Save(Tile tiles[][], int width, int height, String description){
        //this.tiles = tiles;
        //this.width = width;
       // this.height = height;
        //TODO: Map (with contents), player location, NPC stats, player stats


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