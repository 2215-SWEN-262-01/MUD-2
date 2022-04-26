package com.MUD2.app;

import javax.management.Descriptor;

public class User {
    private String username;
    private int password;
    private PlayerCharacter character;
    private Map currentGame;
    private History history;

    public User(String username, String Password) {
        this.character = null;
        this.username = username;
        this.history = new History();
        this.currentGame = null;
        this.password = hash(Password);
    }

    public void newCharacter(String Name, String Descripton) {
        this.character = new PlayerCharacter(Name, Descripton, null);
    }

    public String getName() {
        return this.username;
    }
    public History getHistory() {
        return history;
    }
    public Map getCurrentGame() {
        return currentGame;
    }

    public void updateHistory(PlayerCharacter character, int deaths, int games ) {
        history.update(character, deaths, games);
    }

    public void setCurrentGame(Map map) {
        currentGame = map;
    }

    public void setPassword(String pass) {
        password = hash(pass);
    }

    public boolean validatePassword(String pass) {
        return hash(pass) == this.password;
    }

    public int hash(String password) {
        int hash = 7;
        for (int i = 0; i < password.length(); i++) {
            hash = hash*31 + password.charAt(i);
        }
        return hash;
    }
}
