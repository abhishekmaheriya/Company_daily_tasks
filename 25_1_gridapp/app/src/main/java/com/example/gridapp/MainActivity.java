package com.example.gridapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    GridView gridView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridView = findViewById(R.id.gridview);
        gridView.setAdapter(new ImageAdapter(this));


    }


}
class ImageAdapter extends BaseAdapter{
    Context context;

    ImageAdapter(Context con){
        context = con;
    }

    @Override
    public int getCount() {
        return img.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int posotion, View convertView, ViewGroup parent) {

        ImageView imgv;

        if (convertView==null){
            imgv = new ImageView(context);
            imgv.setLayoutParams(new GridView.LayoutParams(100,100 ));
            imgv.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imgv.setPadding(10, 10,10 ,10 );


        }
        else {
            imgv = (ImageView) convertView;

        }

        imgv.setImageResource(img[posotion]);

        return imgv;
    }
    int img[] = {R.drawable.f,R.drawable.dlogo,R.drawable.facebook,R.drawable.jlogo,R.drawable.m,R.drawable.mobile1};


}