package com.example.banmi.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.banmi.MainActivity;
import com.example.banmi.R;

//侧滑菜单头部局个人信息
public class PersonalActivity extends AppCompatActivity implements View.OnClickListener {

    /**
     * 个人信息
     */
    private TextView mTv;
    private Toolbar mToolBar;
    private ImageView mIv;
    /**
     * 退出登录
     */
    private Button mBt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal);
        initView();
    }

    private void initView() {
        mTv = (TextView) findViewById(R.id.tv);
        mToolBar = (Toolbar) findViewById(R.id.toolBar);
        mIv = (ImageView) findViewById(R.id.iv);
        mBt = (Button) findViewById(R.id.bt);
        mBt.setOnClickListener(this);
        mToolBar.setTitle("");
        setSupportActionBar(mToolBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mToolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        RequestOptions requestOptions = new RequestOptions().circleCrop();
        Glide.with(this).load(R.mipmap.banmi_highlight).apply(requestOptions).into(mIv);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.bt:
                startActivity(new Intent(PersonalActivity.this, MainActivity.class));
                break;
        }
    }
}
