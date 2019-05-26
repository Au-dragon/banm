package com.example.banmi.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.banmi.R;
import com.example.banmi.adapter.GiftAdapter;
import com.example.banmi.bean.CardBean;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
//礼品券
public class GiftFragment extends Fragment {


    private View view;
    private RecyclerView mRec;

    public GiftFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_gift, container, false);
        initView(inflate);
        initService();
        return inflate;
    }

    private void initService() {
        ArrayList<CardBean> list = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            CardBean cardBean = new CardBean();
            cardBean.setName("一家民宿");
            cardBean.setTitle("有效期至:2019/5/26");
            list.add(cardBean);
        }
        GiftAdapter giftAdapter = new GiftAdapter(list, getContext());
        mRec.setAdapter(giftAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        mRec.setLayoutManager(linearLayoutManager);
    }

    private void initView(View inflate) {
        mRec = (RecyclerView) inflate.findViewById(R.id.rec);
    }
}
