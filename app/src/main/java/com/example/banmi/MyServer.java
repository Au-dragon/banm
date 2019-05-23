package com.example.banmi;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface MyServer<T> {

    String url= "http://api.banmi.com/";
    //伴米界面
    @GET()
    Observable<BanMiBean> getBanMiData(@Url String url);

    //home界面
    @GET()
    Observable<T> getHomeData(@Url String string);
}
