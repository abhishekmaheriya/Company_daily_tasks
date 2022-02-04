package com.example.feb_2_1_design;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private ExpandableListView expandableListView;
    private ExpandableListAdapter expandableListAdapter;
    private List<String> expandableListNombres;
    private HashMap<String, Contacto> listaContactos;
    private int lastExpandedPosition = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        expandableListView.setAdapter(expandableListAdapter);

        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {
                if(lastExpandedPosition != -1 && groupPosition != lastExpandedPosition){
                    expandableListView.collapseGroup(lastExpandedPosition);
                }
                lastExpandedPosition = groupPosition;
            }
        });
    }


    private void init() {
        this.expandableListView = findViewById(R.id.expandableListView);
        this.listaContactos = getContactos();
        this.expandableListNombres = new ArrayList<>(listaContactos.keySet());
        this.expandableListAdapter = new CustomExpandableListAdapter(this,
                expandableListNombres, listaContactos);

    }
    private HashMap<String, Contacto> getContactos() {
        HashMap<String, Contacto> listaC = new HashMap<>();

        listaC.put("Navratri", new Contacto("24/11/2020", R.drawable.img_11 ,
                R.drawable.img_22, R.drawable.img_33));
        listaC.put("Diwali", new Contacto("29/12/2020", R.drawable.img_11 ,
                R.drawable.img_22, R.drawable.img_33));
        listaC.put("Chritmas Event", new Contacto("04/01/2021", R.drawable.img_11 ,
                R.drawable.img_22, R.drawable.img_33));
        listaC.put("Uttrayan Event", new Contacto("24/01/2021", R.drawable.img_11 ,
                R.drawable.img_22, R.drawable.img_33));
        listaC.put("Dhuleti", new Contacto("17/03/2021", R.drawable.img_11 ,
                R.drawable.img_22, R.drawable.img_33));
        return listaC;
    }

}