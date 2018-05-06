package com.example.hule.picgo.Game;

import android.widget.ImageView;

import java.util.Random;

public class TrueRecognizer implements ImageRecognizer {
    private static Boolean matches = true;
    @Override
    public Boolean imageContains(ImageView image, String word) {
        matches = !matches;
        return matches;
    }
}
