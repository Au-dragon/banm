package com.example.banmi.model;

import android.util.Log;

import com.example.banmi.api.MyServer;
import com.example.banmi.bean.DongTaiBean;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class DongTaiModel {

    private static final String TAG = "DongTaiModel";

    public interface CallBack{
        void OnSuccees(DongTaiBean dongTaiBean);

        void OnFilear(String string);
    }

    public void getData(final CallBack callBack){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(MyServer.dturl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        MyServer myServer = retrofit.create(MyServer.class);
        Observable<DongTaiBean> dongtai = myServer.getDongtai();
        dongtai.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<DongTaiBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(DongTaiBean dongTaiBean) {
                        Log.d(TAG, "onNext: "+dongTaiBean.getResult().getData().size());
                        callBack.OnSuccees(dongTaiBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "onError: "+e.getMessage());
                        callBack.OnFilear(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
