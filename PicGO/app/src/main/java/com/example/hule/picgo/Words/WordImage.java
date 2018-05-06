package com.example.hule.picgo.Words;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class WordImage {
    private static boolean initiated = false;
    private static WordImage wordImage;
    private Context context;
    private ImageContainer images;

    private WordImage(Context context) {
        this.context = context;
        images = new ImageContainer();
    }

    public static WordImage singleton(Context context) {
        if(initiated) return wordImage;
        wordImage = new WordImage(context);
        return wordImage;
    }

    public Drawable getDrawable(String s) {
        if(images.contains(s)) return images.get(s);
        Drawable img = loadDrawable(s);
        images.add(img, s);
        return img;
    }


    // https://stackoverflow.com/questions/5834221/android-drawable-from-file-path
    private Drawable loadDrawable(String s) {
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