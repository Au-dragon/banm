package com.example.banmi.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.banmi.R;

//意见反馈
public class TalkActivity extends AppCompatActivity implements View.OnClickListener {

    /**
     * 说点什么吧~我们会做得更好~
     */
    private EditText mEtContent;
    /**
     * 0/200
     */
    private TextView mTextCount;
    /**
     * 提交
     */
    private Button mBtnSubmit;

    private static final int MAX_COUNT = 200;
    private ImageButton mAdviceBlack;
    /**
     * 提交
     */
    private Button mBtnCc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_talk);
        initView();
        initEdit();
    }

    private void initEdit() {
        mBtnSubmit.setVisibility(View.GONE);
        mBtnCc.setVisibility(View.VISIBLE);
        mAdviceBlack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        mEtContent.addTextChangedListener(new TextWatcher() { //对EditText进行监听
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                mBtnSubmit.setVisibility(View.VISIBLE);
                mBtnCc.setVisibility(View.GONE);
            }

            @Override
            public void afterTextChanged(Editable editable) {
                mTextCount.setText((MAX_COUNT - editable.length()) + "/200");
            }
        });
    }

    private void initView() {
        mEtContent = (EditText) findViewById(R.id.et_content);
        mTextCount = (TextView) findViewById(R.id.text_count);
        mBtnSubmit = (Button) findViewById(R.id.btn_submit);
        mBtnSubmit.setOnClickListener(this);
        mAdviceBlack = (ImageButton) findViewById(R.id.advice_black);
        mBtnCc = (Button) findViewById(R.id.btn_cc);
        mBtnCc.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.btn_submit:
                Toast.makeText(this, "BiuBiuBiu~~", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_cc:
                Toast.makeText(this, "请先写出您宝贵的意见再提交哦~~", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
