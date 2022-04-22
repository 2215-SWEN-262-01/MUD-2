package com.MUD2.app;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SwingUserInput extends JFrame implements Runnable {
    private Map map;
    private final SwingWorldDisplay world;

    public SwingUserInput(Map map) {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(640, 480);
        this.map = map;
        this.world = new SwingWorldDisplay(map);
        world.validate();
        this.getContentPane().add(world);
        this.validate();
        
        ActionListener timerAction = new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                world.repaint();
                //This is a pretty dumb way of doing things but it does work for now
                //Ideally repaint would only be called when each turn is finished
                //But for some reason that doesn't work so timer it is
            }
        };
        Timer timer = new Timer(16, timerAction); //update at 60fps :D
        timer.setRepeats(true);
        timer.start();
    }

    @Override
    public void run() {
        SwingUserInput sui = new SwingUserInput(map);
		sui.setVisible(true);
    }

    public void displayRoom() {
        world.repaint();
    }
}
