package com.example.banmi.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.banmi.R;

//联系客服
public class CallActivity extends AppCompatActivity {

    /**
     * 联系客服
     */
    private TextView mTv;
    private Toolbar mToolBar;
    private ImageView mIv1;
    private ImageView mIv2;
    private ImageView mIv3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call);
        initView();
    }

    private void initView() {
        mTv = (TextView) findViewById(R.id.tv);
        mToolBar = (Toolbar) findViewById(R.id.toolBar);
        mIv1 = (ImageView) findViewById(R.id.iv1);
        mIv2 = (ImageView) findViewById(R.id.iv2);
        mIv3 = (ImageView) findViewById(R.id.iv3);
        mToolBar.setTitle("");
        setSupportActionBar(mToolBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mToolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
