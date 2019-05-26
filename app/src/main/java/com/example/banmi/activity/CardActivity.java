package com.example.banmi.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

import com.example.banmi.R;
import com.example.banmi.adapter.VpCardAdapter;
import com.example.banmi.fragment.GiftFragment;
import com.example.banmi.fragment.GoldFragment;

import java.util.ArrayList;

//卡券
public class CardActivity extends AppCompatActivity {

    private ImageButton mAdviceBlack;
    private TabLayout mTabLayout;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card);
        initView();
        initService();
    }

    private void initService() {
        mAdviceBlack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        ArrayList<String> titleList = new ArrayList<>();
        titleList.add("礼品券");
        titleList.add("代金券");
        ArrayList<Fragment> fragList = new ArrayList<>();
        fragList.add(new GiftFragment());
        fragList.add(new GoldFragment());
        VpCardAdapter vpCardAdapter = new VpCardAdapter(getSupportFragmentManager(), titleList, fragList);
        mViewPager.setAdapter(vpCardAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
    }

    private void initView() {
        mAdviceBlack = (ImageButton) findViewById(R.id.advice_black);
        mTabLayout = (TabLayout) findViewById(R.id.tabLayout);
        mViewPager = (ViewPager) findViewById(R.id.viewPager);
    }
}
