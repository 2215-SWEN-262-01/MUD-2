package com.MUD2.app;

public class History {
    private int gamesPlayed;
    private int livesLost;
    private int goldEarned;
    private int itemsFound;

    public History () {
        this.gamesPlayed = 0;
        this.livesLost = 0;
        this.goldEarned = 0;
        this.itemsFound = 0;
    }

    public void update(PlayerCharacter character, int LivesLost, int gamesPlayed) {
        this.goldEarned += character.getInventory().getTotalGold() ;
        this.itemsFound += character.getInventory().getItemCount();
        this.livesLost += LivesLost;
        this.gamesPlayed += gamesPlayed;
    }
}
