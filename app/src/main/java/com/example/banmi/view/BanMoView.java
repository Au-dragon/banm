package com.example.banmi.view;

import com.example.banmi.bean.BanMiBean;
import com.example.banmi.base.BaseView;

public interface BanMoView extends BaseView {
    void onSuccees(BanMiBean banMiBean);

    void onFiler(String string);
}
