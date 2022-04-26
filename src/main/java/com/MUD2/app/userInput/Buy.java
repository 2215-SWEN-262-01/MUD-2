package com.MUD2.app.userInput;

import com.MUD2.app.PlayerCharacter;
import com.MUD2.app.inventory.*;
import com.MUD2.app.tile.MerchantTile;

/**
 * A command that allows players to buy from MerchantTiles
 * 
 * @author Peyton Martin
 */
public class Buy implements Command{
    private PlayerCharacter player;
    private MerchantTile tile;

    public Buy(PlayerCharacter player, MerchantTile tile) {
        this.player = player;
        this.tile = tile;
    }
    
    @Override
    public void execute() {
        Item item = tile.buy();

        if (item == null){
            System.out.println("Purchase cancelled");
        }
        else {
            player.addItemToInventory(item);
        }
        
    }
    
}
