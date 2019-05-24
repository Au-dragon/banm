package com.example.banmi.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.banmi.R;
import com.example.banmi.adapter.NotifactionJsonAdapter;
import com.example.banmi.bean.NotifactionBean;

import java.util.ArrayList;

//Toolbar消息按钮界面
public class MessageActivity extends AppCompatActivity {

    private ImageView mBack;
    /**
     * 清除全部
     */
    private TextView mClearAll;
    private RecyclerView mRec;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);
        initView();
        initData();
    }

    private void initData() {
        final ArrayList<NotifactionBean> list = new ArrayList<>();
        list.add(new NotifactionBean("消息回复","2019/5/24","dasd回复了你的留言"));
        list.add(new NotifactionBean("系统通知","2019/5/24","林竹回复了你的留言"));
        list.add(new NotifactionBean("消息回复","2019/5/24","康索龙回复了你的留言"));
        /*for (int i = 0; i < 3; i++) {
            *//*NotifactionBean notifactionBean = new NotifactionBean();
            notifactionBean.setName("系统通知");
            notifactionBean.setTitle("通过分享获得2米粒");
            notifactionBean.setDate("2019/5/24");
            list.add(notifactionBean);*//*
            list
        }*/
        final NotifactionJsonAdapter notifactionJsonAdapter = new NotifactionJsonAdapter(list, this);
        mRec.setAdapter(notifactionJsonAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mRec.setLayoutManager(linearLayoutManager);

        notifactionJsonAdapter.setOnClick(new NotifactionJsonAdapter.OnClick() {
            @Override
            public void Click(int position, NotifactionBean notifactionBean) {
                Intent intent = new Intent(MessageActivity.this,MessageTalkActivity.class);
                startActivity(intent);
            }
        });

        mClearAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                list.clear();
                notifactionJsonAdapter.notifyDataSetChanged();
            }
        });

    }

    private void initView() {
        mBack = (ImageView) findViewById(R.id.back);
        mClearAll = (TextView) findViewById(R.id.clearAll);
        mRec = (RecyclerView) findViewById(R.id.rec);

        mBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
