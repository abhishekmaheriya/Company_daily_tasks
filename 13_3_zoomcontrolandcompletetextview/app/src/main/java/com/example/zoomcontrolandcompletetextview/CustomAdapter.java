package com.example.zoomcontrolandcompletetextview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckedTextView;
import android.widget.Toast;

public class CustomAdapter extends BaseAdapter {

    String[] names;
    Context context;
    LayoutInflater inflter;
    String value;

    public CustomAdapter(Context context, String[] names) {
        this.context = context;
        this.names = names;
        inflter = (LayoutInflater.from(context));

    }

    @Override
    public int getCount() {
        return names.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflter.inflate(R.layout.list_item ,null);
        final CheckedTextView simpleCheckedTextview =   view.findViewById(R.id.simpleCheckedTextView);
        simpleCheckedTextview.setText(names[i]);
        simpleCheckedTextview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (simpleCheckedTextview.isChecked()){
                    value= "un-Checked";
                    simpleCheckedTextview.setCheckMarkDrawable(0);
                    simpleCheckedTextview.setChecked(false);
                }else{
                    value = "Checked";
                    simpleCheckedTextview.setCheckMarkDrawable(R.drawable.ic_baseline_check_24);
                    simpleCheckedTextview.setChecked(true);
                }
                Toast.makeText(context.getApplicationContext(),value, Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }
}
