package com.example.hule.picgo.Game;

import android.widget.ImageView;

public class TrueRecognizer implements ImageRecognizer {
    @Override
    public Boolean imageContains(ImageView image, String word) {
        return true;
    }
}
