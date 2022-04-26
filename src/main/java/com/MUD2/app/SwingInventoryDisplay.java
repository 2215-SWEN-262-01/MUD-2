package com.MUD2.app;

import javax.swing.BorderFactory;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListModel;

import com.MUD2.app.inventory.Item;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

public class SwingInventoryDisplay extends JPanel implements ActionListener {
    private PlayerCharacter player;
    private ListModel<Item> invList;
    public SwingInventoryDisplay(PlayerCharacter player) {
        this.player = player;
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        JList<Item> list = new JList<>();
        this.add(list);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        
    }
}
