package com.example.banmi.presenter.home;

import com.example.banmi.base.BasePresenter;
import com.example.banmi.bean.HomeBean;
import com.example.banmi.model.home.HomeModel;
import com.example.banmi.view.home.HomeView;

import java.util.List;

public class HomePresenter<V extends HomeView> extends BasePresenter<V> implements HomeModel.HomeCallBack {
    private HomeModel mHomeModel = new HomeModel();
    public void getHomeData(){
        mHomeModel.getHomeData(this);
    }
    @Override
    public void getHomeSuccess(HomeBean homeBeans) {
        mView.setHomeData(homeBeans);
    }
}
