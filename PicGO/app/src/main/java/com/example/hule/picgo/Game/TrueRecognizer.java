package com.example.hule.picgo.Game;

import android.widget.ImageView;

import java.util.Random;

public class TrueRecognizer implements ImageRecognizer {
    @Override
    public Boolean imageContains(ImageView image, String word) {
        int random = new Random().nextInt(2);
        if(random == 0) return true;
        return false;
    }
}
