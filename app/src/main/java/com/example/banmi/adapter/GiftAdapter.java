package com.example.banmi.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.banmi.R;
import com.example.banmi.activity.GiftActivity;
import com.example.banmi.bean.CardBean;

import java.util.ArrayList;

//礼品券适配器
public class GiftAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    ArrayList<CardBean> list;
    Context context;

    public GiftAdapter(ArrayList<CardBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getItemViewType(int position) {
        if(position == 0||position == 1||position == 2){
            return 0;
        }else {
            return 1;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if(i == 0){
            View inflate = LayoutInflater.from(context).inflate(R.layout.gift_item_one, null);
            OneViewHolder oneViewHolder = new OneViewHolder(inflate);
            return oneViewHolder;
        }else {
            View inflate = LayoutInflater.from(context).inflate(R.layout.gift_item_two, null);
            TwoViewHolder twoViewHolder = new TwoViewHolder(inflate);
            return twoViewHolder;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        CardBean cardBean = list.get(i);
        if(viewHolder instanceof OneViewHolder){
            OneViewHolder oneViewHolder = (OneViewHolder) viewHolder;
            oneViewHolder.name.setText(cardBean.getName());
            oneViewHolder.title.setText(cardBean.getTitle());

            oneViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context,GiftActivity.class);
                    context.startActivity(intent);
                }
            });
        }else {
            TwoViewHolder twoViewHolder = (TwoViewHolder) viewHolder;
            twoViewHolder.name.setText(cardBean.getName());
            twoViewHolder.title.setText(cardBean.getTitle());
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class OneViewHolder extends RecyclerView.ViewHolder {

        private final TextView name;
        private final TextView title;

        public OneViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            title = itemView.findViewById(R.id.title);
        }
    }

    public class TwoViewHolder extends RecyclerView.ViewHolder {

        private final TextView name;
        private final TextView title;

        public TwoViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            title = itemView.findViewById(R.id.title);
        }
    }

    interface OnClick{
        void Click(int position,CardBean cardBean);
    }
}
