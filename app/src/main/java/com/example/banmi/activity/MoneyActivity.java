package com.example.banmi.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.banmi.R;
import com.example.banmi.fragment.MoneyFragment;

//侧滑菜单头部局我的钱包
public class MoneyActivity extends AppCompatActivity {

    /**
     * 我的钱包
     */
    private TextView mToolbarText;
    private Toolbar mMoneyToolbar;
    private FrameLayout mMyFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_money);
        initView();
    }

    private void initView() {
        mToolbarText = (TextView) findViewById(R.id.toolbar_text);
        mMoneyToolbar = (Toolbar) findViewById(R.id.money_toolbar);
        mMyFragment = (FrameLayout) findViewById(R.id.myFragment);
        setmMoneyToolbar();
        setmMyFragment();
    }

    public void setmMoneyToolbar(){
        mMoneyToolbar.setTitle("");
        setSupportActionBar(mMoneyToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mMoneyToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        }



    public void setmMyFragment(){
        MoneyFragment moneyFragment = new MoneyFragment();
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = supportFragmentManager.beginTransaction();
        transaction.add(R.id.myFragment,moneyFragment);
        transaction.show(moneyFragment);
        transaction.commit();
    }
}
