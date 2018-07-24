package com.example.javajoke;

import java.util.Random;

public class Joker {

    private final String[] jokes = {
            "This is a funny joke",
            "This is also a funny joke",
            "And this one too!",
            "Here is the joke! No joke!"
    };

    public String gimmeAJoke(){
        int index = new Random().nextInt(jokes.length);
        return jokes[index];
    }
}
