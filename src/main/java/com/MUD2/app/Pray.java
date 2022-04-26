package com.MUD2.app;

import java.util.Random;

public class Pray implements Command {
    /**
     * Pray is a command responsible for creating a ShrineImprint of a character when they pray
     * at a shrine.
     *
     * @author Jahmir Hinds
     */
    private PlayerCharacter player;
    private Room room;
    int x;
    int y;
    /**
     * Constructor for Pray class
     * @param player The player parameter is a player character.
     * @param room The room is the suspected the room that has a tile that the player will attempt to pray at
     * @param x the x coordinate of the tile attempting to pray at
     * @param y the y coodrinate of the tile attempting to pray at
     */
    public Pray (PlayerCharacter player, Room room, int x, int y) {
        this.player = player;
        this.room = room;
    }
    /**
     * When this method is called it will create a shrine Imprint of the player character.
     */
    @Override
    public void execute() {
        ShrineImprint imprint = new ShrineImprint(player.getHealth(), player.getAttack(), player.getDefense());
        player.setShrineImprint(imprint);
    }
}
