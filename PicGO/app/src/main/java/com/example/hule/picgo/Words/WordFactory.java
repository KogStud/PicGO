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

public class WordFactory {

    // stackoverflow

    String fileName = "wordFile.txt";
    Context mContext;

    public WordFactory(Context mContext) {
        this.mContext = mContext;
    }

    public List<String> readLine() {//String path){
        List<String> mLines = new ArrayList<>();

        AssetManager am = mContext.getAssets();

        try {
            InputStream is = am.open(fileName);//path);
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            String line;

            while ((line = reader.readLine()) != null)
                mLines.add(line);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return mLines;
    }
}
