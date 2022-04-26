package com.MUD2.app;

import com.MUD2.app.tile.Tile;

public class ShrineTile extends Tile {
    public ShrineTile(int horizantalLocation, int verticalLocation, GameCharacter character) {
        super(horizantalLocation, verticalLocation, character);
    }

    public String export () {
        if (getCharacter() != null) {
            return "[s:" + getCharacter().export() + "]";
        } else {
            return "[s] ";
        }
    }
}
