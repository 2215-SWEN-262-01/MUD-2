package com.MUD2.app.userInput;

public interface Command {
/**
 * A command is an in game action taken by the player.
 * All classes that inherit this interface will overwrite the
 * execute method which carries out the commands intended in game action.
 *
 * @author Jahmir Hinds
 */

    /**
     * This abstract method will be inherited and modified to fit each specific command and allow them to carry out their
     * task that they are responsible for.
     */
    public abstract void execute();
}
