package com.MUD2.app;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class SwingWorldDisplay extends JPanel {
    private Map map;
    public SwingWorldDisplay(Map map) {
        this.map = map;
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }

    public Dimension getPreferredSize() {
        return new Dimension(320, 320);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Room room = map.getCurrentRoom();
        
        g.setColor(Color.BLACK);
        g.fillRect(32, 32, 32, 32);
    }
}
