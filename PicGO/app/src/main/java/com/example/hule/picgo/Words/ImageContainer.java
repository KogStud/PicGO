package com.example.hule.picgo.Words;

import android.graphics.drawable.Drawable;

import java.util.ArrayList;
import java.util.List;

public class ImageContainer {
    List<ImageItem> items;

    public ImageContainer() {
        items = new ArrayList<>();
    }

    public boolean contains(String s) {
        for(ImageItem i : items) {
            if(i.getString() == s) return true;
        }
        return false;
    }

    public Drawable get(String s) throws IllegalStateException {
        for(ImageItem i : items) {
            if(i.getString() == s) return i.getDrawable();
        }
        throw new IllegalStateException("check if it's there first");
    }

    public void add(Drawable img, String s) {
        items.add(new ImageItem(img, s));
    }

}
