package com.example.banmi.activity;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.banmi.MainActivity;
import com.example.banmi.PhoneCode;
import com.example.banmi.R;

public class VerificationActivity extends AppCompatActivity {

    private ImageView mIvFanhui;
    /**
     * 重新发送
     */
    private TextView mTvFasong;
    /**
     * (56s)
     */
    private TextView mTvMiao;
    private PhoneCode mPc1;
    private String name;
    private int randomnum;
    private NotificationManager mManager;
    private int num = 60;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verification);
        initView();
        mTvFasong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (num == 1) {
                    mTvFasong.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            randomnum = (int) (Math.random() * ((9999 - 1000) + 1) + 1000);
                            //发送通知4步
                            //1.获取通知管理器
                            mManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                            //2.适配Android 8.0
                            String channelId = "shui";
                            String chanelName = "李四";
                            //通知消息渠道/管道
                            //android.os.Build.VERSION.SDK_INT 获取当前手机的系统api版本
                            //android.os.Build.VERSION8_CODES.O 26的api,也就是Android 8.0
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
                            Notification build = new NotificationCompat.Builder(VerificationActivity.this, channelId)
                                    .setSmallIcon(R.mipmap.ic_launcher)//小图标,必要
                                    .setContentTitle("1008610010")//标题,必要,
                                    .setContentText("本次验证码为" + randomnum)//内容,必要
                                    //.setContentIntent(pendingIntent)//设置延时意图
                                    .setAutoCancel(true)//点击通知消失,必须和延时意图配合使用
                                    .setDefaults(Notification.DEFAULT_ALL)//通知的效果
                                    .setLargeIcon(bitmap)//设置大图标
                                    .build();

                            //4.发送通知
                            mManager.notify(100, build);
                        }
                    });
                } else {
                    Toast.makeText(VerificationActivity.this, "验证码已发送手机，不可重复操作", Toast.LENGTH_SHORT).show();
                }
            }
        });
        new CountDownTimer(60000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                num--;
                mTvMiao.setText("(" + millisUntilFinished / 1000 + ")");
            }

            @Override
            public void onFinish() {

            }
        }.start();

    }

    private void initView() {
        mIvFanhui = (ImageView) findViewById(R.id.iv_fanhui);
        mTvFasong = (TextView) findViewById(R.id.tv_fasong);
        mTvMiao = (TextView) findViewById(R.id.tv_miao);
        mPc1 = (PhoneCode) findViewById(R.id.pc_1);


        mPc1.setOnInputListener(new PhoneCode.OnInputListener() {
            @Override
            public void onSucess(String code) {
                //TODO: 例如底部【下一步】按钮可点击
                test();
            }

            @Override
            public void onInput() {
                //TODO:例如底部【下一步】按钮不可点击
            }
        });
    }

    private void test() {
        //获得验证码。。
        String phoneCode = mPc1.getPhoneCode();
        //......
        //......
        //更多操作
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        if (phoneCode.equals(name) || phoneCode.equals(randomnum + "")) {
            Toast.makeText(this, "请稍后...", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(VerificationActivity.this, MainActivity.class));
        } else {
            Toast.makeText(this, "验证码有误", Toast.LENGTH_SHORT).show();
        }
    }
}
