package com.example.hule.picgo.Game;

import android.content.Context;

import com.example.hule.picgo.Words.Word;
import com.example.hule.picgo.Words.WordFactory;

public final class main {

    private int score;
    private static WordFactory wordFactory;

    public static void init(Context mContext) {
        wordFactory = WordFactory.singleton(mContext);
    }
}
