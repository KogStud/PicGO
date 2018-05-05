package com.example.hule.picgo;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.hule.picgo.Game.Main;

public class MainActivity extends AppCompatActivity {

    private static final int request_capture = 1;
    private ImageView result_photo;

    private Button button;
    private TextView score;
    private TextView word;
    private Main main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        result_photo = (ImageView)findViewById(R.id.imageView);


        main = new Main();
        final Context context = this.getBaseContext();
        main.init(context);

        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                launchCamera(v);
            }
        });

        score = (TextView) findViewById(R.id.score);
        score.setText(Integer.toString(main.getScore()));

        word = (TextView) findViewById(R.id.word);
        word.setText(main.wordToString());

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
}
