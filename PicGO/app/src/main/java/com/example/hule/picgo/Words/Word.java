package com.example.hule.picgo.Words;

public class Word {

    private int points;
    private String word;

    public Word(int points, String word) {
        this.points = points;
        this.word = word;
    }

    public String toString() {
        String str = word + ",  " + points;
        return str;
    }
}
