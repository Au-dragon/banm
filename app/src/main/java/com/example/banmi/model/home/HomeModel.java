package com.example.banmi.model.home;

import android.widget.Toast;

import com.example.banmi.api.MyServer;
import com.example.banmi.bean.HomeBean;
import com.example.banmi.net.ToastUtil;
import com.example.banmi.presenter.home.HomePresenter;
import com.example.banmi.view.home.HomeView;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class HomeModel{
    public void getHomeData(final HomeCallBack mHomeCallBack) {
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(MyServer.Url)
                .build();
        MyServer myServer = retrofit.create(MyServer.class);
        Observable<HomeBean> homeData = myServer.getHomeData();
        homeData.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<HomeBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(HomeBean homeBean) {
                        mHomeCallBack.getHomeSuccess(homeBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        ToastUtil.showShort("数据错误");
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public interface HomeCallBack{
        void getHomeSuccess(HomeBean homeBeans);
    }

}
