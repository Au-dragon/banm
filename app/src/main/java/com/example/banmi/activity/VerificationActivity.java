package com.example.banmi.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.banmi.MainActivity;
import com.example.banmi.PhoneCode;
import com.example.banmi.R;

public class VerificationActivity extends AppCompatActivity {

    private ImageView mIvFanhui;
    /**
     * 重新发送
     */
    private TextView mTvFasong;
    /**
     * (56s)
     */
    private TextView mTvMiao;
    private PhoneCode mPc1;
    private String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verification);
        initView();

    }

    private void initView() {
        mIvFanhui = (ImageView) findViewById(R.id.iv_fanhui);
        mTvFasong = (TextView) findViewById(R.id.tv_fasong);
        mTvMiao = (TextView) findViewById(R.id.tv_miao);
        mPc1 = (PhoneCode) findViewById(R.id.pc_1);


        mPc1.setOnInputListener(new PhoneCode.OnInputListener() {
            @Override
            public void onSucess(String code) {
                //TODO: 例如底部【下一步】按钮可点击
                test();
            }

            @Override
            public void onInput() {
                //TODO:例如底部【下一步】按钮不可点击
            }
        });
    }

    private void test() {
        //获得验证码。
        String phoneCode = mPc1.getPhoneCode();
        //......
        //......
        //更多操作
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        if (phoneCode.equals(name)) {
            Toast.makeText(this, "请稍后...", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(VerificationActivity.this, MainActivity.class));
        } else {
            Toast.makeText(this, "验证码有误", Toast.LENGTH_SHORT).show();
        }
    }
}
