package com.gamingroom;

/**
 * A simple class to hold information about a player
 * <p>
 * Notice the overloaded constructor that requires
 * an id and name to be passed when creating.
 * Also note that no mutators (setters) defined so
 * these values cannot be changed once a player is
 * created.
 * </p>
 * @author coce@snhu.edu
 *
 */
public class Player extends Entity {

    /**
     * Hide the default constructor to prevent creating empty instances.
     */
    private Player() {
        super(0, null);  // Call the Entity constructor with placeholder values
    }

    /**
     * Constructor with an identifier and name
     */
    public Player(long id, String name) {
        super(id, name);  // Call the Entity constructor with actual values
    }

    
    public String toString() {
        return super.toString();  // Use Entity's toString for consistent formatting
    }
}
