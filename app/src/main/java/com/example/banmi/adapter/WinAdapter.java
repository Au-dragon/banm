package com.example.banmi.adapter;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.banmi.R;
import com.example.banmi.bean.WinBean;

import java.util.ArrayList;
import java.util.List;

/**
 * creation time 2019/5/24
 * author oujunlong
 */
public class WinAdapter extends RecyclerView.Adapter {
    private ArrayList<WinBean> list;
    private Context context;

    public WinAdapter(ArrayList<WinBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_winadapter, null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
MyViewHolder myViewHolder= (MyViewHolder) viewHolder;
myViewHolder.t1.setText(list.get(i).getTitle());
myViewHolder.t2.setText(list.get(i).getMoney());
myViewHolder.b1.setText(list.get(i).getType());
myViewHolder.img.setImageResource(list.get(i).getImage());

myViewHolder.b1.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent textIntent = new Intent(Intent.ACTION_SEND);
        textIntent.setType("text/plain");
        textIntent.putExtra(Intent.EXTRA_TEXT, "这是一段分享的文字");
        context.startActivity(Intent.createChooser(textIntent, "分享"));
    }
});
    }



    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        private final ImageView img;
        private final TextView t1;
        private final TextView t2;
        private final Button b1;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img);
            t1 = itemView.findViewById(R.id.t1);
            t2 = itemView.findViewById(R.id.t2);
            b1 = itemView.findViewById(R.id.b1);
        }
    }
}
