package com.example.banmi.fragment;


import android.support.v4.app.Fragment;

import com.example.banmi.R;
import com.example.banmi.base.BaseFragment;
import com.example.banmi.presenter.home.HomePresenter;
import com.example.banmi.view.home.HomeView;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends BaseFragment<HomeView, HomePresenter<HomeView>> implements HomeView {


    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    protected void initService() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected int createLayout() {
        return R.layout.fragment_home;
    }

    @Override
    protected HomePresenter createPresenter() {
        return new HomePresenter();
    }
}
