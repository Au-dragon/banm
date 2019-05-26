package com.example.banmi.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.banmi.R;
import com.example.banmi.fragment.RechargeFragment;
import com.example.banmi.fragment.VoucherFragment;

public class RechargeActivity extends AppCompatActivity {

    /**
     * 我的钱包
     */
    private TextView mToolbarText;
    private Toolbar mMoneyToolbar;
    /**
     * 99
     */
    private TextView mT1;
    private TabLayout mMyTab;
    private FrameLayout mMyFragment;
    private VoucherFragment voucherFragment;
    private RechargeFragment rechargeFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recharge);
        initView();
    }

    private void initView() {
        mToolbarText = (TextView) findViewById(R.id.toolbar_text);
        mMoneyToolbar = (Toolbar) findViewById(R.id.money_toolbar);
        mT1 = (TextView) findViewById(R.id.t1);
        mMyTab = (TabLayout) findViewById(R.id.myTab);
        mMyFragment = (FrameLayout) findViewById(R.id.myFragment);
        mMoneyToolbar.setTitle("");
        setSupportActionBar(mMoneyToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mMoneyToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        setmMyFragment();
        setmMyTab();


    }
    public void setmMyTab(){
        mMyTab.addTab(mMyTab.newTab().setText("现金"));
        mMyTab.addTab(mMyTab.newTab().setText("代金券"));
        mMyTab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                FragmentManager supportFragmentManager = getSupportFragmentManager();
                switch (tab.getPosition()) {
                    case 0:
                        FragmentTransaction fragmentTransaction = supportFragmentManager.beginTransaction();
                        fragmentTransaction.show(rechargeFragment);
                        fragmentTransaction.hide(voucherFragment);
                        fragmentTransaction.commit();
                        break;
                    case 1:
                        FragmentTransaction fragmentTransaction2 = supportFragmentManager.beginTransaction();
                        fragmentTransaction2.hide(rechargeFragment);
                        fragmentTransaction2.show(voucherFragment);
                        fragmentTransaction2.commit();
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
    public void setmMyFragment(){
        voucherFragment = new VoucherFragment();
        rechargeFragment = new RechargeFragment();
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = supportFragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.myFragment,voucherFragment);
        fragmentTransaction.add(R.id.myFragment, rechargeFragment);
        fragmentTransaction.hide(voucherFragment);
        fragmentTransaction.show(rechargeFragment);
        fragmentTransaction.commit();
    }
}
