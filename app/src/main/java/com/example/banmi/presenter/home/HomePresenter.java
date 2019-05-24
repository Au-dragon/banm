package com.example.banmi.presenter.home;

import com.example.banmi.base.BasePresenter;
import com.example.banmi.bean.HomeBean;
import com.example.banmi.model.home.HomeModel;
import com.example.banmi.view.home.HomeView;

import java.util.List;

public class HomePresenter<V extends HomeView> extends BasePresenter<V> implements HomeModel.BaseCallBack {

    @Override
    public void getHomeSuccess(List<HomeBean> homeBeans) {

    }
}
