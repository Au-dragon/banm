package com.example.banmi.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.banmi.R;
import com.example.banmi.bean.MoneyBean;

import java.util.ArrayList;

/**
 * creation time 2019/5/24
 * author oujunlong
 */
public class MoneyRvAdapter extends RecyclerView.Adapter {
    private ArrayList<MoneyBean> list;
    private Context context;

    public MoneyRvAdapter(ArrayList<MoneyBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_moeny_recycler, null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
MyViewHolder myViewHolder= (MyViewHolder) viewHolder;
myViewHolder.t1.setText(list.get(i).getTitle());
myViewHolder.t2.setText(list.get(i).getTime());
myViewHolder.t3.setText(list.get(i).getMoney());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class MyViewHolder extends RecyclerView.ViewHolder {

        private final TextView t1;
        private final TextView t2;
        private final TextView t3;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            t1 = itemView.findViewById(R.id.t1);
            t2 = itemView.findViewById(R.id.t2);
            t3 = itemView.findViewById(R.id.t3);
        }
    }
}
