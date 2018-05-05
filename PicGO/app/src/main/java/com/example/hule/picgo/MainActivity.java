package com.example.hule.picgo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.hule.picgo.Words.Word;
import com.example.hule.picgo.Words.WordFactory;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private TextView text;
    WordFactory wordFactory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                List<String> str = wordFactory.readLine();
                String res = "";
                while(!str.isEmpty()) {
                    res = res+str.get(0)+"\n";
                    str.remove(0);
                }
                text.setText(res);//WordFactory.main());
            }
        });

        text = (TextView) findViewById(R.id.text);

        wordFactory = new WordFactory(MainActivity.this);
    }
}
