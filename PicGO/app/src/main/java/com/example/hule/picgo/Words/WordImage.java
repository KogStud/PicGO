package com.example.hule.picgo.Words;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class WordImage {
    // https://stackoverflow.com/questions/5834221/android-drawable-from-file-path
    public static Drawable getDrawable(Context context, String s) {
        //String pathName = "test.png";//s + ".jpg";
        //Drawable d = Drawable.createFromPath(pathName);

        String url = s + ".jpg";
        Drawable drawable = null;
        InputStream inputStream = null;
        try {
            inputStream = context.getAssets().open(url);
            drawable = Drawable.createFromStream(inputStream, null);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return drawable;
    }
}
