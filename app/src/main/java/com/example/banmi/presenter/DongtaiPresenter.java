package com.example.banmi.presenter;


import com.example.banmi.base.BasePresenter;
import com.example.banmi.bean.DongTaiBean;
import com.example.banmi.model.DongTaiModel;
import com.example.banmi.view.DongtaiView;

public class DongtaiPresenter<V extends DongtaiView>extends BasePresenter<V> implements DongTaiModel.CallBack {

    private DongTaiModel dongTaiModel = new DongTaiModel();
    private DongtaiView dongtaiView;

    public DongtaiPresenter( DongtaiView dongtaiView) {
        this.dongtaiView = dongtaiView;
    }

    public void getDontai(){
        dongTaiModel.getData(this);
    }

    @Override
    public void OnSuccees(DongTaiBean dongTaiBean) {
        dongtaiView.OnSuccees(dongTaiBean);
    }

    @Override
    public void OnFilear(String string) {
        dongtaiView.OnFilear(string);
    }
}
