package com.example.hule.picgo;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.hule.picgo.Game.Main;
import com.example.hule.picgo.Words.WordImage;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    private static final int request_capture = 1;
    private ImageView result_photo;

    private Button capture;
    private Button skip;
    private Button submit;
    private TextView score;
    private TextView word;
    private Main main;
    private ImageView correct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        result_photo = (ImageView)findViewById(R.id.imageView);
        correct = findViewById(R.id.correct);
        correct.setVisibility(View.INVISIBLE);

        main = new Main();
        final Context context = this.getBaseContext();
        main.init(context);

        capture = (Button) findViewById(R.id.capture);
        capture.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                launchCamera(v);
            }
        });

        submit = (Button) findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if(main.checkImage(result_photo)) {
                    correct.setImageDrawable(main.answerImage());
                } else {
                    correct.setImageDrawable(main.answerImage());
                }
                showCorrect();
                correct.setVisibility(View.VISIBLE);
                update();
            }
        });

        skip = (Button) findViewById(R.id.skip);
        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                correct.setVisibility(View.INVISIBLE);
                main.nextWord();
                update();
            }
        });

        score = (TextView) findViewById(R.id.score);
        word = (TextView) findViewById(R.id.word);
        update();

    }

    private void launchCamera(View v){
        Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(i, request_capture);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == requestCode && resultCode == RESULT_OK){
            Bundle extras = data.getExtras();
            Bitmap photo = (Bitmap) extras.get("data");
            result_photo.setImageBitmap(photo);
        }
    }

    private void update(){
        word.setText(main.wordToString() + "   " + main.getCurrentWord().getPoints());
        score.setText("Score: "+ Integer.toString(main.getScore()));
    }

    private void showCorrect(){
        result_photo.setImageDrawable(main.answerImage());
    }
}
