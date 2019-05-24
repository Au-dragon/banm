package com.example.banmi.fragment;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.example.banmi.R;

/**
 * creation time 2019/5/24
 * author oujunlong
 */
public class RechargeFragment extends Fragment implements View.OnClickListener {
    private View view;
    /**
     * 30元
     */
    private CheckBox mC1;
    /**
     * 50元
     */
    private CheckBox mC2;
    /**
     * 88元
     */
    private CheckBox mC3;
    /**
     * 108元
     */
    private CheckBox mC4;
    /**
     * 支付金额108元
     */
    private TextView mT1;
    /**
     * 确认支付
     */
    private Button mB1;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_recharge, null);
        initView(view);
        return view;
    }


    private void initView(View view) {
        mC1 = (CheckBox) view.findViewById(R.id.c1);
        mC2 = (CheckBox) view.findViewById(R.id.c2);
        mC3 = (CheckBox) view.findViewById(R.id.c3);
        mC4 = (CheckBox) view.findViewById(R.id.c4);
        mT1 = (TextView) view.findViewById(R.id.t1);
        mB1 = (Button) view.findViewById(R.id.b1);
        mB1.setOnClickListener(this);
        mC4.setChecked(true);
        mT1.setText("支付金额108元");
        mC4.setTextColor(ContextCompat.getColor(getContext(),R.color.bai));
        mC1.setOnClickListener(this);
        mC2.setOnClickListener(this);
        mC3.setOnClickListener(this);
        mC4.setOnClickListener(this);



    }




    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.b1:
                Toast.makeText(getContext(), "充值成功", Toast.LENGTH_SHORT).show();
                break;
            case R.id.c1:
                mT1.setText("支付金额30元");
                mC2.setChecked(false);
                mC3.setChecked(false);
                mC4.setChecked(false);
                mC1.setTextColor(ContextCompat.getColor(getContext(),R.color.bai));
                mC4.setTextColor(ContextCompat.getColor(getContext(),R.color.ju));
                mC3.setTextColor(ContextCompat.getColor(getContext(),R.color.ju));
                mC2.setTextColor(ContextCompat.getColor(getContext(),R.color.ju));
                break;
            case R.id.c2:
                mT1.setText("支付金额50元");
                mC1.setChecked(false);
                mC3.setChecked(false);
                mC4.setChecked(false);
                mC2.setTextColor(ContextCompat.getColor(getContext(),R.color.bai));
                mC4.setTextColor(ContextCompat.getColor(getContext(),R.color.ju));
                mC3.setTextColor(ContextCompat.getColor(getContext(),R.color.ju));
                mC1.setTextColor(ContextCompat.getColor(getContext(),R.color.ju));
                break;
            case R.id.c3:
                mT1.setText("支付金额88元");
                mC2.setChecked(false);
                mC1.setChecked(false);
                mC4.setChecked(false);
                mC3.setTextColor(ContextCompat.getColor(getContext(),R.color.bai));
                mC4.setTextColor(ContextCompat.getColor(getContext(),R.color.ju));
                mC2.setTextColor(ContextCompat.getColor(getContext(),R.color.ju));
                mC1.setTextColor(ContextCompat.getColor(getContext(),R.color.ju));
                break;
            case R.id.c4:
                mT1.setText("支付金额108元");
                mC2.setChecked(false);
                mC3.setChecked(false);
                mC1.setChecked(false);
                mC4.setTextColor(ContextCompat.getColor(getContext(),R.color.bai));
                mC2.setTextColor(ContextCompat.getColor(getContext(),R.color.ju));
                mC3.setTextColor(ContextCompat.getColor(getContext(),R.color.ju));
                mC1.setTextColor(ContextCompat.getColor(getContext(),R.color.ju));
                break;
        }
    }
}
