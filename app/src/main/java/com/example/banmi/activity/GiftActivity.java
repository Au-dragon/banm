package com.example.banmi.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.banmi.R;

public class GiftActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageButton mAdviceBlack;
    /**
     * 复制
     */
    private Button mGoOn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gift);
        initView();
    }

    private void initView() {
        mAdviceBlack = (ImageButton) findViewById(R.id.advice_black);
        mGoOn = (Button) findViewById(R.id.goOn);
        mGoOn.setOnClickListener(this);

        mAdviceBlack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.goOn:
                Toast.makeText(this, "内容已复制", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
