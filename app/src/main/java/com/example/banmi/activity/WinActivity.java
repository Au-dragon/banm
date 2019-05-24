package com.example.banmi.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.banmi.R;
import com.example.banmi.bean.WinBean;

import java.util.ArrayList;

public class WinActivity extends AppCompatActivity {

    private Toolbar mMyToolBar;
    private RecyclerView mMyRecycler;
private ArrayList<WinBean> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_win);
        initView();
    }

    private void initView() {
        mMyToolBar = (Toolbar) findViewById(R.id.myToolBar);
        mMyRecycler = (RecyclerView) findViewById(R.id.myRecycler);
        mMyToolBar.setTitle("");
                setSupportActionBar(mMyToolBar);
                getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mMyToolBar.setNavigationOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        finish();
                    }
                });
        setData();
    }
    public void setData(){
        list=new ArrayList<>();
        list.add(new WinBean("分享伴米旅行","2元",0,"去分享"));
        list.add(new WinBean("完善资料","5元",0,"去完善"));
        list.add(new WinBean("邀请好友","5元",0,"去邀请"));
        list.add(new WinBean("评价线路","1元",0,"去评价"));
        list.add(new WinBean("意见反馈","1元",0,"去反馈"));
    }
}
