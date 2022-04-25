package com.MUD2.app;

public class ShrineImprint {
    private int health;
    private  int attack;
    private  int defense;

    public ShrineImprint(int CurrentHealth, int CurrentAttack, int CurrentDefense ) {
        this.health = CurrentHealth;
        this.attack = CurrentAttack;
        this.defense = CurrentDefense;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public  int getHealth () {
        return health;
    }
}
