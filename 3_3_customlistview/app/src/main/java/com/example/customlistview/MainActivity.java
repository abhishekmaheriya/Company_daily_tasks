package com.example.customlistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView list;

    String[] maintitle ={
            "Title 1" , "Title 2",
            "Title 3" , "Title 4",
            "Tital 5"
    };

    String[] subtitle ={
            "Sub Title 1" , "Sub Title 2",
            "Sub Title 3" , "Sub Title 4",
            "Sub Tital 5"
    };

    Integer[] imgid={
            R.drawable.gradient,R.drawable.google,
            R.drawable.phone,R.drawable.gradient,
            R.drawable.google,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyListAdapter adapter= new MyListAdapter(this, maintitle , subtitle , imgid);
        list =(ListView)findViewById(R.id.list);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                // to-do auto generate method
                if (position == 0){
                    Toast.makeText(getApplicationContext(), "Place Your First Option Code", Toast.LENGTH_SHORT).show();
                }
                else if (position == 1){
                    Toast.makeText(getApplicationContext(), "Place Your Second Option Code", Toast.LENGTH_SHORT).show();
                }
                else if (position == 2){
                    Toast.makeText(getApplicationContext(), "Place Your Third Option Code", Toast.LENGTH_SHORT).show();
                }
                else if (position == 3){
                    Toast.makeText(getApplicationContext(), "Place Your Fourth Option Code", Toast.LENGTH_SHORT).show();
                }
                else if (position == 4){
                    Toast.makeText(getApplicationContext(), "Place Your Fifth Option Code", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}