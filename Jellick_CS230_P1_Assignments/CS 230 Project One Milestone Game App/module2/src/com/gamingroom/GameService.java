package com.gamingroom;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * A singleton service for the game engine
 * 
 * @author coce@snhu.edu
 */
public class GameService {

    /**
     * A list of the active games
     */
    private static List<Game> games = new ArrayList<>();

    /*
     * Holds the next game identifier
     */
    private static long nextGameId = 1;

    // Singleton instance - private and static
    private static GameService instance = null;

    // Private constructor to prevent instantiation from other classes
    private GameService() {
    }

    // Public method to provide access to the single instance
    public static GameService getInstance() {
        if (instance == null) {
            instance = new GameService();
        }
        return instance;
    }

    /**
     * Construct a new game instance
     * 
     * name the unique name of the game
     * the game instance (new or existing)
     */
    public Game addGame(String name) {

        // Use iterator to look for existing game with same name
        Iterator<Game> iter = games.iterator();
        while (iter.hasNext()) {
            Game existingGame = iter.next();
            if (name.equalsIgnoreCase(existingGame.getName())) {
                return existingGame; // Return the existing game if name matches
            }
        }

        // If not found, create a new game instance, assign a new ID, and add it to the list
        Game game = new Game(nextGameId++, name);
        games.add(game);

        return game;
    }

    /**
     * Returns the game instance at the specified index.
     * 
     * Scope is package/local for testing purposes.
     * 
     * 
     * index index position in the list to return
     * requested game instance
     */
    Game getGame(int index) {
        return games.get(index);
    }

    /**
     * Returns the game instance with the specified id.
     * 
     * id unique identifier of game to search for
     * requested game instance
     */
    public Game getGame(long id) {

        // Use iterator to look for existing game with same id
        Iterator<Game> iter = games.iterator();
        while (iter.hasNext()) {
            Game existingGame = iter.next();
            if (existingGame.getId() == id) {
                return existingGame;
            }
        }

        return null; // Return null if no game found with the given id
    }

    /**
     * Returns the game instance with the specified name.
     * 
     *  name unique name of game to search for
     *  requested game instance
     */
    public Game getGame(String name) {

        // Use iterator to look for existing game with same name
        Iterator<Game> iter = games.iterator();
        while (iter.hasNext()) {
            Game existingGame = iter.next();
            if (name.equalsIgnoreCase(existingGame.getName())) {
                return existingGame;
            }
        }

        return null; // Return null if no game found with the given name
    }

    /**
     * Returns the number of games currently active
     * 
     * the number of games currently active
     */
    public int getGameCount() {
        return games.size();
    }
}
