package com.example.banmi.activity;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Paint;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.banmi.R;

public class LoginOne extends AppCompatActivity implements View.OnClickListener {

    /**
     * 请输入手机号码
     */
    private EditText mEt;
    /**
     * 发送验证码
     */
    private Button mTvBut;
    private ImageView mIvWei;
    /**
     * 用户协议
     */
    private TextView mXieyi;
    private NotificationManager mManager;
    private int randomnum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_one);
        initView();
    }

    private void initView() {
        mEt = (EditText) findViewById(R.id.et);
        mTvBut = (Button) findViewById(R.id.tv_but);
        mXieyi = (TextView) findViewById(R.id.xieyi);
        //添加下横线
        mXieyi.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);

        mTvBut.setOnClickListener(this);
        mIvWei = (ImageView) findViewById(R.id.iv_wei);
        mIvWei.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginOne.this, LoginTwo.class));
            }
        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.tv_but:
                String regex_mobile = "^((13[0-9])|(15[^4])|(18[0-9])|(17[0-8])|(147,145))\\d{8}$";
                String shuru = mEt.getText().toString().trim();
                randomnum = (int) (Math.random() * ((9999-1000)+1)+1000);

                if (!TextUtils.isEmpty(shuru)) {
                    if (shuru.matches(regex_mobile)) {
                        Intent intent = new Intent(LoginOne.this, VerificationActivity.class);
                        intent.putExtra("name",randomnum+"");
                        startActivity(intent);
                        //发送通知4步
                        //1.获取通知管理器
                        mManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                        //2.适配Android 8.0
                        String channelId = "shui";
                        String chanelName = "李四";

                        //通知消息渠道/管道
                        //android.os.Build.VERSION.SDK_INT 获取当前手机的系统api版本
                        //android.os.Build.VERSION_CODES.O 26的api,也就是Android 8.0
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                            NotificationChannel channel = new NotificationChannel(channelId, chanelName, NotificationManager.IMPORTANCE_DEFAULT);
                            mManager.createNotificationChannel(channel);
                        }


                        //3.构建Notification对象
                        //获取一个含有开启页面的延时意图
//                        Intent intent = new Intent(this, VerificationActivity.class);
//                        PendingIntent pendingIntent = PendingIntent.getActivity(this,
//                                1, intent, PendingIntent.FLAG_UPDATE_CURRENT);
                        //获取一个广播的延时意图.
                        //PendingIntent.getBroadcast()
                        //获取一个开启服务的意图
                        //PendingIntent.getService()
                        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
                        Notification build = new NotificationCompat.Builder(this, channelId)
                                .setSmallIcon(R.mipmap.ic_launcher)//小图标,必要
                                .setContentTitle("1008610010")//标题,必要
                                .setContentText("本次验证码为"+randomnum)//内容,必要
                               //.setContentIntent(pendingIntent)//设置延时意图
                                .setAutoCancel(true)//点击通知消失,必须和延时意图配合使用
                                .setDefaults(Notification.DEFAULT_ALL)//通知的效果
                                .setLargeIcon(bitmap)//设置大图标
                                .build();

                        //4.发送通知
                        mManager.notify(100, build);
                    } else {
                        Toast.makeText(LoginOne.this, "格式不正确，请重新输入", Toast.LENGTH_SHORT).show();
                    }

                } else {
                    Toast.makeText(LoginOne.this, "手机号码不能为空", Toast.LENGTH_SHORT).show();
                }
        }
    }
}
