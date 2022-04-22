package com.MUD2.app;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.event.MouseInputAdapter;

import org.w3c.dom.events.MouseEvent;

public class SwingWorldDisplay extends JPanel {
    private Map map;
    public SwingWorldDisplay(Map map) {
        this.map = map;
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }

    public Dimension getPreferredSize() {
        return new Dimension(map.getCurrentRoom().getWidth()*32, map.getCurrentRoom().getHeight()*32);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Room room = map.getCurrentRoom();
        for (int x = 0; x < room.getWidth(); x++) {
            for (int y = 0; y < room.getHeight(); y++) {
                Tile tile = room.getTile(x, y);
                
                if (tile instanceof EmptyTile) {
                    g.setColor(Color.BLACK);
                    g.fillRect(x*32, y*32, 32, 32);
                }
                if (tile instanceof ObstacleTile) {
					g.setColor(Color.DARK_GRAY);
                    g.fillRect(x*32, y*32, 32, 32);
                }
				if (tile instanceof TrapTile) {
                    g.setColor(Color.BLACK);
                    g.fillRect(x*32, y*32, 32, 32); //looks identical to empty
				    //Might be a good idea to keep track of whether trap is sprung, 
				    //then change it to look different afterwards
                }
                if (tile.getCharacter() instanceof PlayerCharacter) {
                    g.setColor(Color.GREEN);
                    g.fillRect(x*32, y*32, 32, 32);
                }
				if (tile instanceof ChestTile) {
                    g.setColor(new Color(158, 117, 55)); //brown
                    g.fillRect(x*32, y*32, 32, 32);
                }
				if (tile instanceof ExitTile) {
                    g.setColor(Color.RED);
                    g.fillRect(x*32, y*32, 32, 32);
                }
				
				if (tile.getCharacter() instanceof NPC) {
                    g.setColor(Color.BLUE);
                    g.fillRect(x*32, y*32, 32, 32);
                }
				if (tile instanceof GoalTile) {
                    g.setColor(Color.YELLOW);
                    g.fillRect(x*32, y*32, 32, 32);
				}
                g.setColor(Color.WHITE);
                g.drawRect(x*32, y*32, 32, 32); //draw outline around tile
            }
        }
        
        
    }
}
