package com.MUD2.app;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.ListModel;

import com.MUD2.app.inventory.Bag;
import com.MUD2.app.inventory.Consumable;
import com.MUD2.app.inventory.Equippable;
import com.MUD2.app.inventory.Item;
import com.MUD2.app.userInput.GameInput;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

public class SwingInventoryDisplay extends JPanel implements ActionListener {
    private PlayerCharacter player;
    private JTextArea inv;
    public SwingInventoryDisplay(PlayerCharacter player) {
        this.player = player;
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.inv = new JTextArea(15, 50);
        JLabel invLabel = new JLabel("Inventory");
        invLabel.setLabelFor(inv);
        this.add(inv);
        this.add(invLabel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        
    }

    public void updateInventory() {
        Bag[] bags = player.getInventory().getBags();
        StringBuilder result = new StringBuilder();
		result.append("Available Space: " + player.getInventory().getSpace() + "\n");
		result.append("Total Gold: " + player.getInventory().getTotalGold() + "\n");
		if (player.getCurrentWeapon() != null)
            result.append("Equipped Weapon: " + player.getCurrentWeapon().getName() + "\n");
		if (player.getCurrentArmor() != null)
            result.append("Equipped Armor: " + player.getCurrentArmor().getName() + "\n");

		for (int i = 0; i < bags.length; i++) {
			if (bags[i] != null) {
				result.append("Bag " + i + ": " + bags[i].size() + " items" + "\n");
				for (Item item : bags[i]) {
					result.append("\t"+item.getName() + ": " + item.getDescription() +
							", " + item.getGoldValue() +" gold");
					if (item instanceof Equippable) {
						result.append(" (Equippable)");
					}
					if (item instanceof Consumable) {
						result.append(" (Consumable)");
					}
					result.append("\n");
				}
				result.append("\n");
			}
		}
        inv.setText(result.toString());
        
    }
}
