package com.example.myapplicationsdfghj;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class DemoAdapter extends RecyclerView.Adapter<DemoAdapter.DataViewHolder>{

    Context context;
    String name;


    DemoAdapter(Context context,String name){
        this.context=context;
        this.name=name;
    }



    @NonNull
    @Override
    public DataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        View view=layoutInflater.inflate(R.layout.item_list,parent,false);
        return new DataViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DataViewHolder holder, int position) {

        holder.txtData.setText(""+position);
        String monthName="";

        if (position==0){
            monthName="JANUARY";
        }else  if(position==1){
            monthName="FEB";
        }else {
            monthName="etc";
        }

        holder.txtValue.setText(monthName);

    }

    @Override
    public int getItemCount() {
        return 12;
    }

    public class DataViewHolder extends RecyclerView.ViewHolder{
        TextView txtData,txtValue;
        public DataViewHolder(@NonNull View itemView) {
            super(itemView);
            txtData=itemView.findViewById(R.id.txtNumberData);
            txtValue=itemView.findViewById(R.id.txtNumberValue);

        }
    }

}


