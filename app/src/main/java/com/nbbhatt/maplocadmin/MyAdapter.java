package com.nbbhatt.maplocadmin;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{

    ArrayList<model> dataList;

    public MyAdapter(ArrayList<model> dataList) {
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recyler_view,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.email.setText(dataList.get(position).getEmail());
        holder.name.setText(dataList.get(position).getName());

        holder.number.setText(dataList.get(position).getNumber());
        holder.password.setText(dataList.get(position).getPassword());
        holder.lati.setText(dataList.get(position).getUserLatitude());
        holder.longi.setText(dataList.get(position).getUserLongitude());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView name,email ,number,password,lati,longi;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.userText);
            email = itemView.findViewById(R.id.emailText);

            number = itemView.findViewById(R.id.numberText);
            password = itemView.findViewById(R.id.passText);
            lati = itemView.findViewById(R.id.latText);
            longi = itemView.findViewById(R.id.longText);

        }
    }





}
