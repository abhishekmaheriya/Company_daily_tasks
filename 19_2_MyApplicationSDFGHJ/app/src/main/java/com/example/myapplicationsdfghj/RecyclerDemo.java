package com.example.myapplicationsdfghj;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class RecyclerDemo extends AppCompatActivity {


    RecyclerView recyclerView;
    DemoAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_demo);
        recyclerView=findViewById(R.id.recy);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter=new DemoAdapter(this,"Ankit RANA");
        recyclerView.setAdapter(adapter);



    }
}