package com.example.banmi.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.banmi.R;
import com.example.banmi.adapter.FragmentAdapter;
import com.example.banmi.base.BaseFragment;
import com.example.banmi.bean.DongTaiBean;
import com.example.banmi.presenter.DongtaiPresenter;
import com.example.banmi.view.DongtaiView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class BanmiFragmentone extends BaseFragment<DongtaiView, DongtaiPresenter<DongtaiView>> implements DongtaiView {

    @BindView(R.id.fragrec)
    RecyclerView fragrec;
    Unbinder unbinder;
    private ArrayList<DongTaiBean.ResultBean.DataBean> dongtai = new ArrayList<>();
    private FragmentAdapter adapter;
    private static final String TAG = "BanmiFragmentone";

    @Override
    protected DongtaiPresenter<DongtaiView> createPresenter() {
        return new DongtaiPresenter<>(this);
    }

    @Override
    protected void initService() {
        mPresenter.getDontai();
    }

    @Override
    protected void initData() {

    }

    @Override
    protected int createLayout() {
        return R.layout.fragmentone_banmi;
    }

    @Override
    public void OnSuccees(DongTaiBean dongTaiBean) {
        Log.d(TAG, "OnSuccees: "+dongTaiBean.getResult().getData().size());
        dongtai.addAll(dongTaiBean.getResult().getData());


        fragrec.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new FragmentAdapter(getContext(), dongtai);
        fragrec.setAdapter(adapter);
    }

    @Override
    public void OnFilear(String string) {

    }

}
