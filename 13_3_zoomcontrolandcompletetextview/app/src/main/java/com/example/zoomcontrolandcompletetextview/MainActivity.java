package com.example.zoomcontrolandcompletetextview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.ZoomControls;

public class MainActivity extends AppCompatActivity {

    ZoomControls simpleZoomControls;
    Button show, hide;
    ImageView image;
    ListView listView;

    String value;
    String[] superStarNames = {"John Cena", "Roman Reign", "Sheamus"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = (ListView) findViewById(R.id.listView);

        // set the adapter to fill the data in ListView
        CustomAdapter customAdapter = new CustomAdapter(getApplicationContext(), superStarNames);
        listView.setAdapter(customAdapter);


        simpleZoomControls = (ZoomControls) findViewById(R.id.simpleZoomControl);
        image = (ImageView) findViewById(R.id.image);
        final ZoomControls simpleZoomControls = (ZoomControls) findViewById(R.id.simpleZoomControl); // initiate a ZoomControls
        show = (Button) findViewById(R.id.show); // initiate show Button
        hide = (Button) findViewById(R.id.hide);

        simpleZoomControls.hide(); // initially hide ZoomControls from the screen
        // perform setOnTouchListener event on ImageView


        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                simpleZoomControls.show();
            }
        });
        hide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                simpleZoomControls.hide();
            }
        });
        image.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                simpleZoomControls.show();
                return false;
            }
        });

        simpleZoomControls.setOnZoomInClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // calculate current scale x and y value of ImageView
                float x = image.getScaleX();
                float y = image.getScaleY();
                // set increased value of scale x and y to perform zoom in functionality
                image.setScaleX((float) (x + 1));
                image.setScaleY((float) (y + 1));
                // display a toast to show Zoom In Message on Screen
                Toast.makeText(getApplicationContext(),"Zoom In",Toast.LENGTH_SHORT).show();
                // hide the ZoomControls from the screen
                simpleZoomControls.hide();
            }
        });

        simpleZoomControls.setOnZoomOutClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // calculate current scale x and y value of ImageView
                float x = image.getScaleX();
                float y = image.getScaleY();
                // set decreased value of scale x and y to perform zoom out functionality
                image.setScaleX((float) (x - 1));
                image.setScaleY((float) (y - 1));
                // display a toast to show Zoom Out Message on Screen
                Toast.makeText(getApplicationContext(),"Zoom Out",Toast.LENGTH_SHORT).show();
                // hide the ZoomControls from the screen
                simpleZoomControls.hide();
            }
        });

    }
}