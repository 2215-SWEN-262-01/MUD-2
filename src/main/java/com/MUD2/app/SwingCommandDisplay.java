package com.MUD2.app;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

import com.MUD2.app.tile.ChestTile;
import com.MUD2.app.tile.Map;
import com.MUD2.app.tile.Room;
import com.MUD2.app.tile.Tile;
import com.MUD2.app.userInput.Loot;
import com.MUD2.app.userInput.Move;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;

public class SwingCommandDisplay extends JPanel implements ActionListener {
    private PlayerCharacter player;
    private Map map;
    private SwingInventoryDisplay invDisplay;

    public SwingCommandDisplay(PlayerCharacter player, Map map, SwingInventoryDisplay invDisplay) {
        this.player = player;
        this.map = map;
        this.invDisplay = invDisplay;
        setBorder(BorderFactory.createLineBorder(Color.BLACK));

        JButton up = new JButton("Up");
        up.setActionCommand("up");
        up.setMnemonic(KeyEvent.VK_W);
        this.add(up);
        JButton down = new JButton("Down");
        down.setActionCommand("down");
        down.setMnemonic(KeyEvent.VK_S);
        this.add(down);
        JButton left = new JButton("Left");
        left.setActionCommand("left");
        left.setMnemonic(KeyEvent.VK_A);
        this.add(left);
        JButton right = new JButton("Right");
        right.setActionCommand("right");
        right.setMnemonic(KeyEvent.VK_D);
        this.add(right);

        JButton loot = new JButton("Loot");
        loot.setActionCommand("loot");
        loot.setMnemonic(KeyEvent.VK_L);
        this.add(loot);
        
        up.addActionListener(this);
        down.addActionListener(this);
        left.addActionListener(this);
        right.addActionListener(this);
        loot.addActionListener(this);
    }

    
    public void actionPerformed(ActionEvent e) {
        Move move;
        Room room = map.getCurrentRoom();
        Tile currentTile = player.getCurrentTile();
        int x = currentTile.getHorizantalLocation();
		int y = currentTile.getVerticalLocation();
        
        switch (e.getActionCommand()) {
            case "up":
				move = new Move(player, room, map, x, y-1);
				move.execute();
				break;
			case "down":
                move = new Move(player, room, map, x, y+1);
				move.execute();
				break;
			case "left":
                move = new Move(player, room, map, x-1, y);
				move.execute();
				break;
			case "right":
				move = new Move(player, room, map, x+1, y);
				move.execute();
				break;
            case "loot":
                if (currentTile instanceof ChestTile) {
                    Loot loot = new Loot(player, ((ChestTile) currentTile).getInventory());
                    loot.execute();
                    invDisplay.updateInventory();
                    room.convertToEmptyTile(x, y);
                } else {
                    System.out.println("No items to loot here...");
                }
                break;
        }
    }
}
