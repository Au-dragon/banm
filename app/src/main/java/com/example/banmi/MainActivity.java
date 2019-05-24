package com.example.banmi;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.banmi.activity.AttentionActivity;
import com.example.banmi.activity.CallActivity;
import com.example.banmi.activity.CardActivity;
import com.example.banmi.activity.CollectActivity;
import com.example.banmi.activity.DetectionActivity;
import com.example.banmi.activity.MessageActivity;
import com.example.banmi.activity.MoneyActivity;
import com.example.banmi.activity.NotifactionActivity;
import com.example.banmi.activity.PersonalActivity;
import com.example.banmi.activity.TalkActivity;
import com.example.banmi.activity.TourismActivity;
import com.example.banmi.adapter.VpAdapter;
import com.example.banmi.base.BaseActivity;
import com.example.banmi.fragment.BanmiFragment;
import com.example.banmi.fragment.HomeFragment;
import com.example.banmi.presenter.EmptyPresenter;
import com.example.banmi.view.EmptyView;

import java.util.ArrayList;

import butterknife.BindView;
//rtsger7dgytrstriedycgytytgholtsrdcujgyg
public class MainActivity extends BaseActivity<EmptyView, EmptyPresenter<EmptyView>> implements EmptyView {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.tabLayout)
    TabLayout tabLayout;
    @BindView(R.id.navigationView)
    NavigationView navigationView;
    @BindView(R.id.drawerLayout)
    DrawerLayout drawerLayout;
    @BindView(R.id.viewPager)
    ViewPager viewPager;
    @BindView(R.id.call)
    TextView call;
    @BindView(R.id.talk)
    TextView talk;
    @BindView(R.id.detection)
    TextView detection;
    @BindView(R.id.open)
    ImageView open;
    @BindView(R.id.notifaction)
    ImageView notifaction;
    @BindView(R.id.message)
    ImageView message;

    @Override
    protected EmptyPresenter<EmptyView> createPresenter() {
        return new EmptyPresenter<>();
    }

    @Override
    protected int creataLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initData() {
        initToolbar();
        //添加两个Fragment
        initFragment();
        //侧滑头部局
        hearder();
        //侧滑菜单栏
        initMenu();
        //侧滑底部三个TextView
        setting();
        //打开侧滑菜单
        openThis();
        //Toolbar通知和消息图片按钮
        toolbarImg();
    }

    private void toolbarImg() {
        //通知界面
        notifaction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, NotifactionActivity.class);
                startActivity(intent);
            }
        });
        //消息界面
        message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MessageActivity.class);
                startActivity(intent);
            }
        });
    }

    private void openThis() {
        open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(Gravity.LEFT);
            }
        });
    }

    private void setting() {
        //联系客服
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent5 = new Intent(MainActivity.this, CallActivity.class);
                startActivity(intent5);
            }
        });
        //意见反馈
        talk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent6 = new Intent(MainActivity.this, TalkActivity.class);
                startActivity(intent6);
            }
        });
        //版本检测
        detection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent7 = new Intent(MainActivity.this, DetectionActivity.class);
                startActivity(intent7);
            }
        });
    }

    private void initMenu() {
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.card://卡券
                        Intent intent1 = new Intent(MainActivity.this, CardActivity.class);
                        startActivity(intent1);
                        break;
                    case R.id.tourism://旅程
                        Intent intent2 = new Intent(MainActivity.this, TourismActivity.class);
                        startActivity(intent2);
                        break;
                    case R.id.collect://收藏
                        Intent intent3 = new Intent(MainActivity.this, CollectActivity.class);
                        startActivity(intent3);
                        break;
                    case R.id.attention://关注
                        Intent intent4 = new Intent(MainActivity.this, AttentionActivity.class);
                        startActivity(intent4);
                        break;
                }
                return false;
            }
        });
    }

    private void hearder() {
        View headerView = navigationView.getHeaderView(0);
        RelativeLayout personal_information = headerView.findViewById(R.id.personal_information);
        LinearLayout my_money = headerView.findViewById(R.id.my_money);
        //侧滑菜单头部局个人信息
        personal_information.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, PersonalActivity.class);
                startActivity(intent);
            }
        });
        //侧滑菜单头部局我的钱包
        my_money.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MoneyActivity.class);
                startActivity(intent);
            }
        });

    }

    private void initToolbar() {
        setSupportActionBar(toolbar);
    }

    private void initFragment() {
        ArrayList<Fragment> fragList = new ArrayList<>();
        fragList.add(new HomeFragment());
        fragList.add(new BanmiFragment());

        tabLayout.addTab(tabLayout.newTab().setText("首页").setIcon(R.drawable.tablayout_select));
        tabLayout.addTab(tabLayout.newTab().setText("半米").setIcon(R.drawable.tablayout_select2));

        VpAdapter vpAdapter = new VpAdapter(getSupportFragmentManager(), fragList);
        viewPager.setAdapter(vpAdapter);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
    }
}
