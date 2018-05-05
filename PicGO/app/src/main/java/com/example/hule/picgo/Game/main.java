package com.example.hule.picgo.Game;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import com.example.hule.picgo.Words.Word;
import com.example.hule.picgo.Words.WordFactory;
import com.example.hule.picgo.Words.WordImage;

// init() first
// Get info from getInfo()
// compare(pic, word) -> do ML here later
//
public final class Main {

    private int score;
    private static WordFactory wordFactory;
    private Word currentWord;
    private ImageRecognizer imageRecognizer;

    public void init(Context mContext, ImageRecognizer imageRecognizer) {
        wordFactory = WordFactory.singleton(mContext);
        currentWord = wordFactory.getWord();
        this.imageRecognizer = imageRecognizer;
    }

    public void init(Context mContext) {
        init(mContext, new TrueRecognizer());
    }

    public Word getCurrentWord() {
        return new Word(currentWord);
    }
    public String wordToString(){ return currentWord.getWord();}

    public int getScore() {
        return score;
    }

    public boolean checkImage(ImageView img) {
        if(imageRecognizer.imageContains(img, currentWord.getWord())) {
           score += currentWord.getPoints();
           currentWord = wordFactory.getWord();
           return true;
        }
        currentWord = wordFactory.getWord();
        return false;
    }

    public Drawable answerImage() {
        return WordImage.getDrawable(wordToString());
    }
}
