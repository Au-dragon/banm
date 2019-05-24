package com.example.banmi.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.banmi.R;

public class LoginTwo extends AppCompatActivity implements View.OnClickListener {

    /**
     * 请输入手机号码
     */
    private EditText mEt;
    /**
     * 发送验证码
     */
    private Button mTvBut;
    /**
     * 登录或注册即同意伴米旅行
     */
    private TextView mTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_two);
        initView();
    }

    private void initView() {
        mEt = (EditText) findViewById(R.id.et);
        mTvBut = (Button) findViewById(R.id.tv_but);
        mTvBut.setOnClickListener(this);
        mTv = (TextView) findViewById(R.id.tv);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.tv_but:
                startActivity(new Intent(LoginTwo.this, VerificationActivity.class));
                break;
        }
    }
}
