package com.example.banmi.activity;

import android.content.pm.ApplicationInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.banmi.R;
import com.example.banmi.adapter.WinAdapter;
import com.example.banmi.bean.WinBean;

import java.util.ArrayList;

public class WinActivity extends AppCompatActivity {

    private Toolbar mMyToolBar;
    private RecyclerView mMyRecycler;
private ArrayList<WinBean> list;
    private WinAdapter winAdapter;

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

        mMyRecycler.setLayoutManager(new LinearLayoutManager(this));
        winAdapter = new WinAdapter(list, this);
        mMyRecycler.setAdapter(winAdapter);

    }
    public void setData(){
        list=new ArrayList<>();
        ApplicationInfo appInfo = getApplicationInfo();
        int resID = getResources().getIdentifier("icon_me_fenxiang", "mipmap", appInfo.packageName);
        int resID2 = getResources().getIdentifier("icon_me_pingjia", "mipmap", appInfo.packageName);
        int resID3 = getResources().getIdentifier("icon_me_yaoqing", "mipmap", appInfo.packageName);
        int resID4 = getResources().getIdentifier("icon_me_pingjia", "mipmap", appInfo.packageName);
        int resID5 = getResources().getIdentifier("icon_me_ziliao", "mipmap", appInfo.packageName);
        list.add(new WinBean("分享伴米旅行","2元",resID,"去分享"));
        list.add(new WinBean("完善资料","5元",resID2,"去完善"));
        list.add(new WinBean("邀请好友","5元",resID3,"去邀请"));
        list.add(new WinBean("评价线路","1元",resID4,"去评价"));
        list.add(new WinBean("意见反馈","1元",resID5,"去反馈"));
    }
}
