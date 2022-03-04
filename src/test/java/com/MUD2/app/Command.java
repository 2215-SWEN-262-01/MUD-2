package com.MUD2.app;

public interface Command {
/**
 * A command is an in game action taken by the player.
 * All classes that inherit this interface will be overwrite the 
 * execute method which carries out the commands intended in game action.
 * 
 * @author Jahmir Hinds
 */
    public abstract void execute ();
}
