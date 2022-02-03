package com.example.sharedpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText edit1, edit2;
    Button btn , btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edit1 = findViewById(R.id.edit1);
        edit2 = findViewById(R.id.edit2);
        btn = findViewById(R.id.btn);
        btn2 = findViewById(R.id.btn2);

        SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref",MODE_PRIVATE);
        SharedPreferences.Editor myEdit = sharedPreferences.edit();


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myEdit.putString("name ",edit1.getText().toString());
                myEdit.putInt("age", Integer.parseInt(edit2.getText().toString()));
                myEdit.apply();
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edit1.setText(sharedPreferences.getString("name", ""));
                edit2.setText(String.valueOf(sharedPreferences.getInt("age", 0)));

            }
        });

    }
//    protected void onResume() {
//        super.onResume();
//
//        SharedPreferences sh = getSharedPreferences("MySharedPref", MODE_PRIVATE);
//        String s1 = sh.getString("name" , "");
//        int a = sh.getInt("age",0);
//
//        edit1.setText(s1);
//        edit2.setText(String.valueOf(a));
//
//    }
//
//    @Override
//    protected void onPause() {
//        super.onPause();
//
//
//        SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref",MODE_PRIVATE);
//        SharedPreferences.Editor myEdit = sharedPreferences.edit();
//
//        myEdit.putString("name", edit1.getText().toString());
//        myEdit.putInt("age", Integer.parseInt(edit2.getText().toString()));
//        myEdit.apply();
//    }
}