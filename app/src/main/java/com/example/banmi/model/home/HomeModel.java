package com.example.banmi.model.home;

import com.example.banmi.bean.HomeBean;

import java.util.List;

public class HomeModel{
    public interface BaseCallBack{
        void getHomeSuccess(List<HomeBean> homeBeans);
    }

}
