package com.example.banmi.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.banmi.R;
import com.example.banmi.adapter.MyHomeAdapter;
import com.example.banmi.base.BaseFragment;
import com.example.banmi.bean.HomeBean;
import com.example.banmi.presenter.home.HomePresenter;
import com.example.banmi.view.home.HomeView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends BaseFragment<HomeView, HomePresenter<HomeView>> implements HomeView {


    @BindView(R.id.home_recy)
    RecyclerView mHomeRecy;
    private ArrayList<HomeBean.ResultBean.RoutesBean> resultBeans;
    private ArrayList<HomeBean.ResultBean.BannersBean> bannerBeans;
    private MyHomeAdapter myHomeAdapter;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    protected void initService() {
    }

    @Override
    protected void initData() {
        mPresenter.getHomeData();
        mHomeRecy.setLayoutManager(new LinearLayoutManager(getContext()));
        resultBeans = new ArrayList<>();
        bannerBeans = new ArrayList<>();
        myHomeAdapter = new MyHomeAdapter(bannerBeans,resultBeans, getActivity());
        mHomeRecy.setAdapter(myHomeAdapter);
    }

    @Override
    protected int createLayout() {
        return R.layout.fragment_home;
    }

    @Override
    protected HomePresenter createPresenter() {
        return new HomePresenter();
    }

    @Override
    public void setHomeData(HomeBean homeBeans) {
        List<HomeBean.ResultBean.RoutesBean> routes = homeBeans.getResult().getRoutes();
        List<HomeBean.ResultBean.BannersBean> banners = homeBeans.getResult().getBanners();
        resultBeans.addAll(routes);
        bannerBeans.addAll(banners);
        myHomeAdapter.notifyDataSetChanged();
    }
}
