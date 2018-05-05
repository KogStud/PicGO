package com.example.hule.picgo.Words;

public class Word {

    private int points;
    private String word;

    public Word(int points, String word) {
        this.points = points;
        this.word = word;
    }

    public Word(Word word) {
        this.points = word.getPoints();
        this.word = word.getWord();
    }

    public String toString() {
        String str = word + ",  " + points;
        return str;
    }

    public String getWord() { return word; }
    public int getPoints() { return points; }
}
