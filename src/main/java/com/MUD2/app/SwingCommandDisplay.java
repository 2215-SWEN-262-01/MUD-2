package com.MUD2.app;

import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SwingCommandDisplay extends JPanel implements ActionListener {
    private PlayerCharacter player;
    private Map map;

    public SwingCommandDisplay(PlayerCharacter player, Map map) {
        this.player = player;
        this.map = map;
        setBorder(BorderFactory.createLineBorder(Color.BLACK));

        JButton up = new JButton("Up");
        up.setActionCommand("up");
        this.add(up);
        JButton down = new JButton("Down");
        down.setActionCommand("down");
        this.add(down);
        JButton left = new JButton("Left");
        left.setActionCommand("left");
        this.add(left);
        JButton right = new JButton("Right");
        right.setActionCommand("right");
        this.add(right);
        
        up.addActionListener(this);
        down.addActionListener(this);
        left.addActionListener(this);
        right.addActionListener(this);
    }

    
    public void actionPerformed(ActionEvent e) {
        Move move;
        Room room = map.getCurrentRoom();
        Tile currentTile = player.getCurrentTile();
        int x = currentTile.getHorizantalLocation();
		int y = currentTile.getVerticalLocation();
        System.out.println("got here");
        switch (e.getActionCommand()) {
            case "up":
				move = new Move(player, room, map, x, y-1);
				move.execute();
				break;
			case "down":
				move = new Move(player, room, map, x-1, y);
				move.execute();
				break;
			case "left":
				move = new Move(player, room, map, x, y+1);
				move.execute();
				break;
			case "right":
				move = new Move(player, room, map, x+1, y);
				move.execute();
				break;
        }
    }
}
