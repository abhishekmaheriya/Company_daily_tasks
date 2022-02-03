package com.example.a24_2_navigation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SlidingDrawer;

public class MainActivity extends AppCompatActivity {
    String[] nameArray = {"Aestro", "Blender", "Cupcake", "Donut", "Eclair", "Froyo", "GingerBread", "HoneyComb", "IceCream Sandwich", "JelliBean", "KitKat", "Lollipop", "MarshMallow"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SlidingDrawer simpleSlidingDrawer = (SlidingDrawer) findViewById(R.id.simpleSlidingDrawer); // initiate the SlidingDrawer
        final Button handleButton = (Button) findViewById(R.id.handle); // inititate a Button which is used for handling the content of SlidingDrawer
        ListView simpleListView = (ListView) findViewById(R.id.simpleListView);  // initiate the ListView that is used for content of Sl.idingDrawer

        // adapter for the list view
        ArrayAdapter<String> arrayAdapter;
        arrayAdapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.activity_list_item, R.id.name, nameArray);

        // set an adapter to fill the data in the ListView
        simpleListView.setAdapter(arrayAdapter);

        // implement setOnDrawerOpenListener event
        simpleSlidingDrawer.setOnDrawerOpenListener(new SlidingDrawer.OnDrawerOpenListener() {
            @Override
            public void onDrawerOpened() {
                handleButton.setText("Close");
            }
        });
        // implement setOnDrawerCloseListener event
        simpleSlidingDrawer.setOnDrawerCloseListener(new SlidingDrawer.OnDrawerCloseListener() {
            @Override
            public void onDrawerClosed() {
                // change the handle button text
                handleButton.setText("Open");
            }
        });


    }
}