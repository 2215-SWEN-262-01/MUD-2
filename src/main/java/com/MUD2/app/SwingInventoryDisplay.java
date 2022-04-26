package com.MUD2.app;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
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
import com.MUD2.app.userInput.UseItem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.event.KeyEvent;

public class SwingInventoryDisplay extends JPanel implements ActionListener {
    private PlayerCharacter player;
    private JTextArea inv;
    private JTextArea itemName;
    public SwingInventoryDisplay(PlayerCharacter player) {
        this.player = player;
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.inv = new JTextArea(15, 50);
        inv.setEditable(false);
        JLabel invLabel = new JLabel("Inventory");
        invLabel.setLabelFor(inv);
        
        this.itemName = new JTextArea(1, 15);
        JLabel itemNameLabel = new JLabel("Item Name");
        itemNameLabel.setLabelFor(itemName);
        JButton use = new JButton("Use Item");
        use.setActionCommand("use");
        use.setMnemonic(KeyEvent.VK_U);
        use.addActionListener(this);

        this.add(inv);
        this.add(invLabel);
        this.add(itemName);
        this.add(itemNameLabel);
        this.add(use);
    }
    @Override
    public void actionPerformed(ActionEvent event) {
        switch (event.getActionCommand()) {
            case "use":
                try {
                    String name = itemName.getText();
                    UseItem cmd = new UseItem(player, name);
                    cmd.execute();
                    
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("Please enter the name of the item you want to use");
                }
                break;
        }
        
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
