package com.example.banmi.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.banmi.MainActivity;
import com.example.banmi.R;

public class LoginOne extends AppCompatActivity implements View.OnClickListener {

    /**
     * 请输入手机号码
     */
    private EditText mEt;
    /**
     * 发送验证码
     */
    private Button mTvBut;
    private ImageView mIvWei;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_one);
        initView();
    }

    private void initView() {
        mEt = (EditText) findViewById(R.id.et);
        mTvBut = (Button) findViewById(R.id.tv_but);
        mTvBut.setOnClickListener(this);
        mIvWei = (ImageView) findViewById(R.id.iv_wei);
        mIvWei.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginOne.this, LoginTwo.class));
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.tv_but:
                startActivity(new Intent(LoginOne.this, MainActivity.class));
                break;
        }
    }
}
