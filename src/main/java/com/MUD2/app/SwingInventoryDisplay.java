package com.MUD2.app;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListModel;

import com.MUD2.app.inventory.Bag;
import com.MUD2.app.inventory.Item;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

public class SwingInventoryDisplay extends JPanel implements ActionListener {
    private PlayerCharacter player;
    private DefaultListModel<Item> invList;
    public SwingInventoryDisplay(PlayerCharacter player) {
        this.player = player;
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.invList = new DefaultListModel<>();
        JList<Item> list = new JList<>();
        this.add(list);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        
    }

    public void updateInventory() {
        Bag[] bags = player.getInventory().getBags();
        for (Bag bag : bags) {
            for (Item item : bag) {
                if (!invList.contains(item))
                    invList.addElement(item);
            }
        }
    }
}
