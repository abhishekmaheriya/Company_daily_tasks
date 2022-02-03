package com.example.rwsdtp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RatingBar rtg1;
    Button btn1 , btn2;
    WebView WebView;
    SeekBar seek;
    DatePicker datePicker;
    TextView textView1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addListenerOnButtonClick();
    }

    private void addListenerOnButtonClick() {

        rtg1 = findViewById(R.id.rtg1);
        btn1 = findViewById(R.id.btn1);
        WebView = findViewById(R.id.WebView);
        seek = findViewById(R.id.seek);
        btn2 = findViewById(R.id.btn2);
        datePicker = findViewById(R.id.datePicker);
        textView1 = findViewById(R.id.textView1);


        textView1.setText("Current Date :"+getCurrentDate());
        int getCurrentTime;

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String rating = String.valueOf(rtg1.getRating());

                WebView.loadUrl("https://www.instagram.com/");
                Toast.makeText(getApplicationContext(), rating, Toast.LENGTH_SHORT).show();

            }
        });

        seek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                Toast.makeText(getApplicationContext(), "SeekBar Progress"+i, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Toast.makeText(getApplicationContext(), "SeekBar Touch Started!", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(getApplicationContext(), "SeekBar Touch Stop!", Toast.LENGTH_SHORT).show();

            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView1.setText("Change Date :"+getCurrentDate());
            }
        });
    }
    public String getCurrentDate(){
        StringBuilder builder=new StringBuilder();;
        builder.append((datePicker.getMonth()+1)+"/");
        builder.append(datePicker.getDayOfMonth()+"/");
        builder.append(datePicker.getYear());
        return builder.toString();
    }
}