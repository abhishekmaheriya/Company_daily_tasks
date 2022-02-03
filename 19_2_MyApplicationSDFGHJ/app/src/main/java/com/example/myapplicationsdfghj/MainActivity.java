package com.example.myapplicationsdfghj;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import java.time.Month;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    SearchView search;
    RecyclerView rcv1;
    ArrayList<String> list;
    ArrayAdapter<String > adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        search = findViewById(R.id.search);
        rcv1 = findViewById(R.id.rcv1);

        list = new ArrayList<>();
        list.add("January");
        list.add( "Febuary");
        list.add( "March");
        list.add("April");
        list.add( "May");
        list.add( "June");
        list.add( "July");
        list.add( "August");
        list.add( "September");
        list.add("October");
        list.add("November");
        list.add( "December");

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,list);


        search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                char list=0;
                switch(list){
                    case 1:
                        System.out.println("January");
                        break;

                    case 2:
                        System.out.println("Febuary");
                        break;

                    case 3:
                        System.out.println("March");
                        break;

                    case 4:
                        System.out.println("April");
                        break;

                    case 5:
                        System.out.println("May");
                        break;

                    case 6:
                        System.out.println("June");
                        break;


                    case 7:
                        System.out.println("July");
                        break;

                    case 8:
                        System.out.println("August");
                        break;

                    case 9:
                        System.out.println("September");
                        break;

                    case 10:
                        System.out.println("October");
                        break;

                    case 11:
                        System.out.println("November");
                        break;

                    case 12:
                        System.out.println("December");
                        break;
                    default:
                        System.out.println("Not any Number");
                        break;
                }
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });



    }
}