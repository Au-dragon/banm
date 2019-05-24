package com.example.banmi.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.banmi.R;
import com.example.banmi.activity.MessageActivity;
import com.example.banmi.activity.MessageTalkActivity;
import com.example.banmi.bean.NotifactionBean;
import com.mcxtzhang.swipemenulib.SwipeMenuLayout;

import java.util.ArrayList;

////Toolbar上通知按钮列表的适配器
public class NotifactionJsonAdapter extends RecyclerView.Adapter<NotifactionJsonAdapter.ViewHolder> {

    ArrayList<NotifactionBean> list;
    Context context;

    public NotifactionJsonAdapter(ArrayList<NotifactionBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.notifaction_json_item, null);
        ViewHolder viewHolder = new ViewHolder(inflate);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, final int i) {
        final NotifactionBean notifactionBean = list.get(i);
        viewHolder.name.setText(notifactionBean.getName());
        viewHolder.title.setText(notifactionBean.getTitle());
        viewHolder.date.setText(notifactionBean.getDate());

        viewHolder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                list.remove(i);
                notifyDataSetChanged();
                viewHolder.swipeLayout.quickClose();
            }
        });

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(onClick != null){
                    onClick.Click(i,notifactionBean);
                }
            }
        });

        viewHolder.item_go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,MessageTalkActivity.class);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView name;
        private final TextView title;
        private final TextView date;
        private final Button delete;
        private final SwipeMenuLayout swipeLayout;
        private final RelativeLayout item_go;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            title = itemView.findViewById(R.id.title);
            date = itemView.findViewById(R.id.date);
            delete = itemView.findViewById(R.id.navogation_delete);
            swipeLayout = itemView.findViewById(R.id.swipeMenuLayout);
            item_go = itemView.findViewById(R.id.item_go);
        }
    }

    OnClick onClick;

    public void setOnClick(OnClick onClick) {
        this.onClick = onClick;
    }

    public interface OnClick{
        void Click(int position,NotifactionBean notifactionBean);
    }
}
