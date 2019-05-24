package com.example.banmi.presenter;

import com.example.banmi.bean.BanMiBean;
import com.example.banmi.model.BanMoModel;
import com.example.banmi.base.BasePresenter;
import com.example.banmi.view.BanMoView;

public class BanMiPresenter<V extends BanMoView>extends BasePresenter<V> implements BanMoModel.CallBack{

    private BanMoModel banMoModel = new BanMoModel();
    private BanMoView banMoView;

    public BanMiPresenter(BanMoView banMoView) {
        this.banMoView = banMoView;
    }

    public void getData1(){
        banMoModel.getData(this);
    }

    @Override
    public void OnSuccees(BanMiBean banMiBean) {
        banMoView.onSuccees(banMiBean);
    }

    @Override
    public void OnFailer(String string) {banMoView.onFiler(string);}


}
