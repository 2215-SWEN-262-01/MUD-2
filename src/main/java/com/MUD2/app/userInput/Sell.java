package com.MUD2.app.userInput;

import com.MUD2.app.PlayerCharacter;
import com.MUD2.app.tile.MerchantTile;

/**
 * A command that allows players to sell to MerchantTiles
 * 
 * @author Peyton Martin
 */
public class Sell implements Command{
    private PlayerCharacter player;
    private MerchantTile tile;

    public Sell(PlayerCharacter player, MerchantTile tile) {
        this.player = player;
        this.tile = tile;
    }

    @Override
    public void execute() {
        // TODO Auto-generated method stub
        
    }
    
}
