package com.MUD2.app;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class SwingUserInput extends JFrame implements Runnable {
    private Map map;
    private SwingWorldDisplay world;

    public SwingUserInput(Map map) {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(640, 480);
        this.map = map;
        this.world = new SwingWorldDisplay(map);
        this.add(world);
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        SwingUserInput sui = new SwingUserInput(map);
		sui.setVisible(true);
    }

    public void displayRoom() {
        world.repaint();
        repaint();
    }
}
