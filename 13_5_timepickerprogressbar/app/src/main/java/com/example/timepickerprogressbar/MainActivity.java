package com.example.timepickerprogressbar;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {

    TextView textView1;
    TimePicker timePicker;
    Button changetime , btn2;
    ProgressBar progressbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        textView1= findViewById(R.id.textView1);
        timePicker = findViewById(R.id.timePicker);
        changetime = findViewById(R.id.button1);
        btn2 = findViewById(R.id.btn2);
        progressbar = findViewById(R.id.progressbar);


        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                progressbar.setVisibility(View.GONE);
            }
        });


        timePicker.setIs24HourView(false);
        changetime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                textView1.setText(getCurrentTime());
            }
        });

    }
    public String getCurrentTime(){
        String currentTime = "Current Time:"+timePicker.getCurrentHour()+":"+timePicker.getCurrentMinute();
        return currentTime;
    }
}