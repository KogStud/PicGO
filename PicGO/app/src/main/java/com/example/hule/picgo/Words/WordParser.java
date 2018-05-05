package com.example.hule.picgo.Words;

public class WordParser {

    //http://pages.cs.wisc.edu/~hasti/cs302/examples/Parsing/parseString.html
    public static Word parse(String str) {
        String delims = "[,]+";
        String[] tokens = str.split(delims);

        String word = tokens[0];
        int points = Integer.parseInt(tokens[1]);

        return new Word(points, word);
    }
}
