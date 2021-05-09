package com.example.projectmcs;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder>{
    Context ctx;
    ArrayList<list_view> listitem;

    public DataAdapter (Context ctx,ArrayList<list_view>listitem){
        this.ctx = ctx;
        this.listitem = listitem;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(ctx).inflate(R.layout.list_item, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        list_view listview = listitem.get(i);
        viewHolder.productname.setText(listview.name);
        viewHolder.productprice.setText(listview.price);
        viewHolder.productdate.setText(listview.date);
    }

    @Override
    public int getItemCount() {
        return listitem.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView productname;
        TextView productdate;
        TextView productprice;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            productname = itemView.findViewById(R.id.productname);
            productdate = itemView.findViewById(R.id.productdate);
            productprice = itemView.findViewById(R.id.productprice);
        }
    }

}
