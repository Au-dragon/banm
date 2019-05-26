package com.example.banmi.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.banmi.R;
import com.example.banmi.bean.DongTaiBean;

import java.util.ArrayList;
import java.util.Date;

public class FragmentAdapter extends RecyclerView.Adapter {

    private Context context;
    private ArrayList<DongTaiBean.ResultBean.DataBean> dongtai;

    public FragmentAdapter(Context context, ArrayList<DongTaiBean.ResultBean.DataBean> dongtai) {
        this.context = context;
        this.dongtai = dongtai;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(context, R.layout.layout_fragmentonetwo, null);
        return new VHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        VHolder vHolder = (VHolder) viewHolder;
        vHolder.name.setText(dongtai.get(i).getAuthor_name());
        vHolder.title.setText(dongtai.get(i).getTitle());
        Glide.with(context).load(dongtai.get(i).getThumbnail_pic_s()).into(vHolder.mainimg);
        Date date = new Date();
        vHolder.time.setText(date.toString());
    }

    @Override
    public int getItemCount() {
        return dongtai.size();
    }

    public void addItem(ArrayList<DongTaiBean.ResultBean.DataBean> dtai) {
        dongtai.addAll(dtai);
        notifyDataSetChanged();
    }

    class VHolder extends RecyclerView.ViewHolder {
        public TextView time;
        public TextView name;
        public ImageView mainimg;
        public TextView title;

       public VHolder(@NonNull View itemView) {
           super(itemView);
           this.time = (TextView) itemView.findViewById(R.id.time);
           this.name = (TextView) itemView.findViewById(R.id.name);
           this.mainimg = (ImageView) itemView.findViewById(R.id.mainimg);
           this.title = (TextView) itemView.findViewById(R.id.title);
       }
   }
}
