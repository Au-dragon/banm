package com.example.banmi.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.banmi.MainActivity;
import com.example.banmi.R;

public class WelcomeActivity extends AppCompatActivity {

    private ImageView mIv;
    /**
     * 这不是一段旅程  这是一段好时光
     */
    private TextView mTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        initView();
    }

    private void initView() {
        mIv = (ImageView) findViewById(R.id.iv);
        mTv = (TextView) findViewById(R.id.tv);
        new CountDownTimer(3000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                mTv.setText("这不是一段旅程  这是一段好时光");
            }

            @Override
            public void onFinish() {
                Intent intent = new Intent(WelcomeActivity.this, LoginOne.class);
                startActivity(intent);
            }
        }.start();
    }
}
