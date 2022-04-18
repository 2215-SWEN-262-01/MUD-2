package com.MUD2.app;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class SwingUserInput extends JFrame{
    private Map map;
    private SwingWorldDisplay world;

    public SwingUserInput(Map map) {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(640, 480);
        this.map = map;
        this.world = new SwingWorldDisplay(map);
        this.add(world);
    }


}
