package com.MUD2.app.userInput;

import com.MUD2.app.SwingUserInput;

import javax.swing.*;
import java.awt.*;

/**
 * GUI for logging in anc choosing gameplay.
 *
 * @author Noah Pelletier
 */

public class SwingUserLogin extends JPanel {
    public SwingUserLogin(){
            final boolean GUI = true;
            SwingUserInput sui;

            JLabel welcome = new JLabel("Welcome to M.U.D! Enter help for controls");
            this.add(welcome);

            JRadioButton mapClassic = new JRadioButton("Classic Dungeon");
            mapClassic.setActionCommand("Classic Dungeon");
            mapClassic.setSelected(true);

            JRadioButton mapCrafters = new JRadioButton("Dungeon of Crafters");
            mapCrafters.setActionCommand("Dungeon of Crafters");

            ButtonGroup buttonMap = new ButtonGroup();
            buttonMap.add(mapClassic);
            buttonMap.add(mapCrafters);

            this.add(mapClassic);
            this.add(mapCrafters);


            JTextField userName = new JTextField("Enter your name: ",20);
            JLabel userNameLabel = new JLabel();
            userNameLabel.setText("Enter your name: ");
            userName.add(userNameLabel);
            this.add(userName);

            JTextField userDescription = new JTextField("Enter a description of your character: ",20);
            this.add(userDescription);



    }


}



