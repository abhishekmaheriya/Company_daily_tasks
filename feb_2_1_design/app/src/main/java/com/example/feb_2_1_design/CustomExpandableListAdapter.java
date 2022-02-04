package com.example.feb_2_1_design;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CustomExpandableListAdapter extends BaseExpandableListAdapter {
    private Context context;
    private List<String> listTitulo;
    private HashMap<String, Contacto> expandableListDetalles;

    public CustomExpandableListAdapter(Context context,
                                       List<String> listTitulo,
                                       HashMap<String, Contacto> expandableListDetalles) {
        this.context = context;
        this.listTitulo = listTitulo;
        this.expandableListDetalles = expandableListDetalles;
    }


    @Override
    public View getChildView(final int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {

        final Contacto contacto = (Contacto) getChild(groupPosition, childPosition);

        if (convertView == null) {

            LayoutInflater layoutInflater = (LayoutInflater) this.context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            convertView = layoutInflater.inflate(R.layout.list_item, null);

        }

        ImageView imageView1  = convertView.findViewById(R.id.circleIMG1);
        ImageView imageView2  = convertView.findViewById(R.id.circleIMG2);
        ImageView imageView3  = convertView.findViewById(R.id.circleIMG3);

        Bitmap bitmap1 = BitmapFactory.decodeResource(context.getResources(), contacto.getImg1());
        imageView1.setImageBitmap(bitmap1);

        Bitmap bitmap2 = BitmapFactory.decodeResource(context.getResources(), contacto.getImg2());
        imageView2.setImageBitmap(bitmap2);

        Bitmap bitmap3 = BitmapFactory.decodeResource(context.getResources(), contacto.getImg3());
        imageView3.setImageBitmap(bitmap3);

        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "Success", Toast.LENGTH_SHORT).show();
            }
        });

        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "Mensaje para ", Toast.LENGTH_SHORT).show();
            }
        });

        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "Videollamada a ", Toast.LENGTH_SHORT).show();
            }
        });

        List<String> index = new ArrayList<>(expandableListDetalles.keySet());




        Animation animation = AnimationUtils.loadAnimation(context, android.R.anim.fade_in);
        convertView.startAnimation(animation);


        return convertView;
    }


    @Override
    public View getGroupView(int groupPosition, boolean isExpanded,
                             View convertView, ViewGroup parent) {


        String nombre = (String) getGroup(groupPosition);
        Contacto contacto = (Contacto) getChild(groupPosition,0);

        if (convertView == null) {

            LayoutInflater layoutInflater = (LayoutInflater) this.context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            convertView = layoutInflater.inflate(R.layout.list_group, null);

        }

        TextView txtNombre = convertView.findViewById(R.id.txtname);
        TextView txtNumero = convertView.findViewById(R.id.txtdate);

        txtNombre.setText(nombre);
        txtNumero.setText(contacto.getNumero());

        return convertView;
    }


    @Override
    public int getGroupCount() {
        return this.listTitulo.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return 1;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return this.listTitulo.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return this.expandableListDetalles.get(this.listTitulo.get(groupPosition));
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
