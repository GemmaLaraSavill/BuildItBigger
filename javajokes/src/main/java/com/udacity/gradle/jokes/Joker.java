package com.udacity.gradle.jokes;

import java.util.ArrayList;
import java.util.Random;

/**
 * Class that holds a list of jokes and a method that serves a random joke
 */
public class Joker {

    private final ArrayList<String> jokes;
    private final Random randomGenerator;

    public Joker() {
        jokes = new ArrayList<String>();
        loadJokes();
        randomGenerator = new Random();
    }

    /**
     * Load a list of jokes into the collection
     * Jokes from http://shortestjokes.blogspot.com
     */
    private void loadJokes() {
        jokes.add("What's white and can't climb trees?\n" +
                "A fridge.");
        jokes.add("Why can't you hear a pterodactyl going to the bathroom?\n" +
                "Because the \"P\" is silent.");
        jokes.add("Where do you find a one legged dog?\n" +
                "Wherever you left it.");
        jokes.add("What's red and bad for your teeth?\n" +
                "A brick.");
        jokes.add("Which is the most stupid animal living in the jungle?\"\n" +
                "\"The polar bear.\"");
        jokes.add("Why don't seagulls fly over bays?\n" +
                "Because then they would be bagels!");
        jokes.add("Where did Napoleon keep his armies?\n" +
                "In his sleevies.");
        jokes.add("How much does a pirate pay for corn?\n" +
                "A-buck-an-ear");
        jokes.add("Why do golfers carry two pairs of trousers with them?\n" +
                "In case they had a hole in one.");
        jokes.add("How do you attract a squirrel?\n" +
                "Climb up a tree and act like a nut!");
        jokes.add("Where do polar bears vote?\n" +
                "At the north poll!");
        jokes.add("What did the worker at the rubber band factory say when he lost his job?\n" +
                "!Oh snap!");
        jokes.add("In a marathon race what does the winner lose?\n" +
                "His breath!");


    }

    /**
     * Returns a random joke from this joker's collection
     * @return String a joke
     */
    public String getAJoke() {
        int index = randomGenerator.nextInt(jokes.size());
        return jokes.get(index);
    }
}
