package com.example.hule.picgo.Words;

import android.graphics.drawable.Drawable;

class ImageItem {
    private String str;
    private Drawable img;

    public ImageItem(Drawable img, String str) {
        this.str = str;
        this.img = img;
    }

    public String getString() {
        return str;
    }

    public Drawable getDrawable() {
        return img;
    }
}
