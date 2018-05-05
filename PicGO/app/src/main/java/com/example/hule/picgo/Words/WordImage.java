package com.example.hule.picgo.Words;

import android.graphics.drawable.Drawable;

public class WordImage {
    // https://stackoverflow.com/questions/5834221/android-drawable-from-file-path
    public static Drawable getDrawable(String s) {
        String pathName = s + ".jpg";
        Drawable d = Drawable.createFromPath(pathName);
        return d;
    }
}
