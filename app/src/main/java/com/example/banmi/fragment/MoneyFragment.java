package com.example.banmi.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.banmi.R;
import com.example.banmi.activity.RechargeActivity;
import com.example.banmi.adapter.MoneyRvAdapter;
import com.example.banmi.bean.MoneyBean;

import java.util.ArrayList;

/**
 * creation time 2019/5/24
 * author oujunlong
 */
public class MoneyFragment extends Fragment implements View.OnClickListener {
    private View view;
    /**
     * 赢取奖金
     */
    private Button mWin;
    /**
     * 去充值
     */
    private Button mRecharge;
    private RecyclerView mMyRecycler;
private ArrayList<MoneyBean> list;
    private MoneyRvAdapter moneyRvAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_money, null);
        initView(view);
        return view;
    }

    private void initView(View view) {
        mWin = (Button) view.findViewById(R.id.win);
        mWin.setOnClickListener(this);
        mRecharge = (Button) view.findViewById(R.id.recharge);
        mRecharge.setOnClickListener(this);
        mMyRecycler = (RecyclerView) view.findViewById(R.id.myRecycler);
setData();
        moneyRvAdapter = new MoneyRvAdapter(list, getContext());
        mMyRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        mMyRecycler.setAdapter(moneyRvAdapter);

    }
    public void setData(){
list=new ArrayList<>();
list.add(new MoneyBean("购买路线：自由之丘时尚街拍...","2017/10/25","- 9 元"));
list.add(new MoneyBean("购买路线：自由之丘时尚街拍...","2017/10/25","- 9 元"));
list.add(new MoneyBean("分享 [伴米]","2017/10/25","+ 2 元"));
list.add(new MoneyBean("分享 [伴米]","2017/10/25","+ 2 元"));
list.add(new MoneyBean("分享 [伴米]","2017/10/25","+ 2 元"));
list.add(new MoneyBean("分享 [伴米]","2017/10/25","+ 2 元"));


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.win:
                break;
            case R.id.recharge:
                Intent intent = new Intent(getContext(),RechargeActivity.class);
                startActivity(intent);
                break;
        }
    }
}
