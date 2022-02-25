package com.example.vishalsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button button;
    TextView timerDisplay;
    EditText input;
    ImageView img;
    CountDownTimer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button1);

        timerDisplay = findViewById(R.id.textView2);
         input = findViewById(R.id.time);
         img = findViewById(R.id.imageView);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int time = Integer.parseInt(input.getText().toString());


                 timer= new CountDownTimer(time*1000,1000) {
                     @Override
                     public void onTick(long l) {
                         int timeInSec = (int)l/1000;
                         int min = timeInSec/60;
                         int sec = timeInSec%60;
                         String display = min +"::"+ sec;
                         timerDisplay.setText(display);
                         img.setImageDrawable(getDrawable(R.drawable.egg));

                     }


                     @Override
                     public void onFinish() {
                         img.setImageDrawable(getDrawable(R.drawable.crackedegg));

                     }
                 };
                 timer.start();
            }
        });
    }
}