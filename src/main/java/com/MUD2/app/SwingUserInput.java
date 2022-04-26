package com.MUD2.app;


import javax.swing.*;

import com.MUD2.app.tile.Map;
import com.MUD2.app.tile.Room;
import com.MUD2.app.userInput.SwingUserLogin;

import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.util.Scanner;

public class SwingUserInput extends JFrame implements Runnable {
    private Map map;
    private PlayerCharacter player;
    private final SwingWorldDisplay world;
    private final SwingCommandDisplay cmd;
    private final SwingInventoryDisplay inv;
    private final JTextArea log;
    private final SwingUserLogin login;

    public SwingUserInput(Map map, PlayerCharacter player) {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.map = map;
        this.player = player;
        this.world = new SwingWorldDisplay(map);
        this.inv = new SwingInventoryDisplay(player);
        this.cmd = new SwingCommandDisplay(player, map, inv);
        this.log = new JTextArea(5, 30);
        this.login = new SwingUserLogin();
        this.add(new JScrollPane(log), BorderLayout.WEST);
        this.add(inv, BorderLayout.EAST);
        this.add(cmd, BorderLayout.PAGE_END);
        this.add(world, BorderLayout.PAGE_START);
        //this.add(login, BorderLayout.EAST);
        
        
        
        ActionListener timerAction = new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                displayRoom();
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
        SwingUserInput sui = new SwingUserInput(map, player);
        sui.pack();
		sui.setVisible(true);
    }

    public void displayRoom() {
        if (player.getDefeated()) {
            this.dispose();
            System.exit(0);
        }
        this.pack();
        world.repaint();
        
    }

    public void logPrint(String msg) {
        log.setText(log.getText() + msg + "\n");
    }

}
