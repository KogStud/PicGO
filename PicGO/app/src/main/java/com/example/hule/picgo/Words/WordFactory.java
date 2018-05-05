package com.example.hule.picgo.Words;

import android.content.Context;
import android.content.res.AssetManager;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WordFactory {
    private static boolean initiated = false;
    private static WordFactory wordFactory;

    private List<Word> words;

    // stackoverflow
    private String fileName = "wordFile.txt";
    private Context mContext;

    private WordFactory(Context mContext) {
        this.mContext = mContext;
        initiated = true;
        wordFactory = this;
        words = readLine();
    }

    public Word getWord() {
        int random = new Random().nextInt(words.size());
        return words.get(random);
    }

    public static WordFactory singleton(Context mContext) {
        if(initiated) return wordFactory;
        wordFactory = new WordFactory(mContext);
        return wordFactory;
    }

    private List<Word> readLine() {//String path){
        List<Word> mLines = new ArrayList<>();

        AssetManager am = mContext.getAssets();

        try {
            InputStream is = am.open(fileName);//path);
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            String line;

            while ((line = reader.readLine()) != null)
                mLines.add(WordParser.parse(line));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return mLines;
    }
}
