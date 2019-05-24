package com.example.banmi.fragment;


import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.example.banmi.bean.BanMiBean;
import com.example.banmi.R;
import com.example.banmi.activity.DetailsActivity;
import com.example.banmi.adapter.BanMiAdapter;
import com.example.banmi.base.BaseFragment;
import com.example.banmi.presenter.BanMiPresenter;
import com.example.banmi.view.BanMoView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.Unbinder;

import static android.support.constraint.Constraints.TAG;

/**
 * A simple {@link Fragment} subclass.
 */
public class BanmiFragment extends BaseFragment<BanMoView, BanMiPresenter<BanMoView>> implements BanMoView {


    @BindView(R.id.banmirec)
    RecyclerView banmirec;
    Unbinder unbinder;
    private BanMiAdapter banMiAdapter;
    private List<BanMiBean.ResultBean.BanmiBean> list;
    private BanMiPresenter<BanMoView> miPresenter;

    @Override
    protected BanMiPresenter<BanMoView> createPresenter() {
        return miPresenter;
    }

    @Override
    protected void viewCreate(View inflate) {
        banmirec.setLayoutManager(new LinearLayoutManager(getContext()));
        list = new ArrayList<>();
        banMiAdapter = new BanMiAdapter(list,getContext());
        banmirec.setAdapter(banMiAdapter);
    }

    @Override
    protected void initService() {}

    @Override
    protected void initData() {
        miPresenter = new BanMiPresenter<>(this);
        miPresenter.getData1();
    }
    @Override
    protected int createLayout() {
        return R.layout.fragment_banmi;
    }


    @Override
    public void onSuccees(final BanMiBean banMiBean) {
        banMiAdapter.addData(banMiBean.getResult().getBanmi());
        banMiAdapter.setOnItemClick(new BanMiAdapter.OnItemClick() {
            @Override
            public void onItemClick(int position) {
                Intent intent = new Intent(getContext(),DetailsActivity.class);
                intent.putExtra("Following",list.get(position).getFollowing());//关注人数
                intent.putExtra("name",list.get(position).getName());//姓名
                intent.putExtra("occupation",list.get(position).getOccupation());//单一介绍
                intent.putExtra("introduction",list.get(position).getIntroduction());//个人介绍
                intent.putExtra("location",list.get(position).getLocation());//住址
                intent.putExtra("photo",list.get(position).getPhoto());//照片
                startActivity(intent);
            }
        });//点击Item条目进入详情页
    }

    @Override
    public void onFiler(String string) {
        Log.i(TAG, "onFiler: "+string);
    }

}
