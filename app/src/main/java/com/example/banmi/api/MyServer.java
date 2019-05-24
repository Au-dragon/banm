package com.example.banmi.api;

import com.example.banmi.bean.HomeBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface MyServer {
    String Url = "http://api.banmi.com/";
    @GET("api/3.0/content/routesbundles?page=0&token=JVy0IvZamK7f7FBZLKFtoniiixKMlnnJ6dWZ6NlsY4HGsxcAA9qvFo8yacHCKHE8YAcd0UF9L59nEm7zk9AUixee0Hl8EeWA880c0ikZBW0KEYuxQy5Z9NP3BNoBi3o3Q0g")
    Observable<HomeBean> getHomeData();
}
