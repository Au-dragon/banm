package com.example.banmi.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.banmi.bean.BanMiBean;
import com.example.banmi.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

//伴米界面的适配器
public class BanMiAdapter extends RecyclerView.Adapter {

    private Context context;
    private List<BanMiBean.ResultBean.BanmiBean> list;

    public BanMiAdapter(List<BanMiBean.ResultBean.BanmiBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = View.inflate(context, R.layout.layout_banmi, null);
        return new VHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i) {
        VHolder holder = (VHolder) viewHolder;
        Glide.with(context).load(list.get(i).getPhoto()).into(holder.img);
        holder.name.setText(list.get(i).getName());
        holder.guanzhu.setText("关注人数："+list.get(i).getFollowing());
        holder.introduction.setText(list.get(i).getOccupation());
        holder.life.setText(list.get(i).getLocation());

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemClick!=null){
                    onItemClick.onItemClick(i);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void addData(List<BanMiBean.ResultBean.BanmiBean> banmi) {
        list.addAll(banmi);
        notifyDataSetChanged();

    }

    class VHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.name)
        TextView name;
        @BindView(R.id.shoucang)
        Button shoucang;
        @BindView(R.id.guanzhu)
        TextView guanzhu;
        @BindView(R.id.life)
        TextView life;
        @BindView(R.id.introduction)
        TextView introduction;
        @BindView(R.id.banmi_img)
        ImageView img;

        VHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    //收藏按钮


    //条目的点击监听
    public OnItemClick onItemClick;

    public void setOnItemClick(OnItemClick onItemClick) {
        this.onItemClick = onItemClick;
    }

    public interface OnItemClick{
        void onItemClick(int position);
    }
}
