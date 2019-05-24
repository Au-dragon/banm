package com.example.banmi.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.banmi.R;
import com.example.banmi.adapter.VpAdapter;
import com.example.banmi.bean.BanMiBean;
import com.example.banmi.fragment.BanmiFragmentone;
import com.example.banmi.fragment.BanmiFragmenttwo;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 伴米条目的详情界面
 */

public class DetailsActivity extends AppCompatActivity {

    @BindView(R.id.details_bank)
    Button xqBank;
    @BindView(R.id.details_tool)
    Toolbar detailsTool;
    @BindView(R.id.details_tab)
    TabLayout detailsTab;
    @BindView(R.id.details_vp)
    ViewPager detailsVp;
    @BindView(R.id.details_img)
    ImageView detailsImg;
    @BindView(R.id.details_name)
    TextView detailsName;
    @BindView(R.id.details_guanzhu)
    TextView detailsGuanzhu;
    @BindView(R.id.details_life)
    TextView detailsLife;
    @BindView(R.id.introduction)
    TextView introduction;
    @BindView(R.id.details_text)
    TextView detailsText;

    private ArrayList<BanMiBean.ResultBean.BanmiBean> banmiBeans;
    private String name;
    private String following;
    private String introduction11;
    private String location;
    private String photo;
    private String occupation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        ButterKnife.bind(this);

        //从fragment传来的值
        Intent intent = getIntent();
        name = intent.getStringExtra("name");
        following = intent.getStringExtra("Following");
        introduction11 = intent.getStringExtra("introduction");
        occupation = intent.getStringExtra("occupation");
        location = intent.getStringExtra("location");
        photo  = intent.getStringExtra("photo");
        initFragment();
        initData();
    }

    @SuppressLint("SetTextI18n")
    protected void initData() {
        detailsTool.setTitle(" ");
        setSupportActionBar(detailsTool);
        xqBank.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        detailsText.setText(introduction11);
        detailsLife.setText(location);
        detailsName.setText(name);
        introduction.setText(occupation);
        detailsGuanzhu.setText("关注人数："+following);
        Glide.with(this).load(photo).into(detailsImg);
    }

    private void initFragment() {
        ArrayList<Fragment> fragList = new ArrayList<>();
        fragList.add(new BanmiFragmentone());
        fragList.add(new BanmiFragmenttwo());

        detailsTab.addTab(detailsTab.newTab().setText("动态"));
        detailsTab.addTab(detailsTab.newTab().setText("线路"));

        VpAdapter vpAdapter = new VpAdapter(getSupportFragmentManager(), fragList);
        detailsVp.setAdapter(vpAdapter);
        detailsTab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                detailsVp.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        detailsVp.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(detailsTab));
    }

}
