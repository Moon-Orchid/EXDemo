package com.mo.exdemo.ex;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RemoteViews;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.mo.exdemo.R;

/**
 * FileName: Ex7_5
 * Package Name: com.mo.exdemo.ex
 * Founder: MoonOrchid
 * Create Date: 2020/10/11-15:32
 * Profile: 状态栏通知 Notification
 **/
public class Ex7_5 extends AppCompatActivity {


    private Button mEx75Btn1;
    private Intent mIntent = null;
    private PendingIntent mPendingIntent = null;
    private Notification mNotification = null;
    private NotificationManager mNotificationManager = null;


    private Button mEx75Btn2;
    private Button mEx75Btn3;
    private Button mEx75Btn4;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ex7_5);

        mEx75Btn1 = (Button) findViewById(R.id.ex7_5_btn1);

        mEx75Btn2 = (Button) findViewById(R.id.ex7_5_btn2);
        mEx75Btn3 = (Button) findViewById(R.id.ex7_5_btn3);
        mEx75Btn4 = (Button) findViewById(R.id.ex7_5_btn4);

        initView();
    }

    private void initView() {
        //普通的通知
        mEx75Btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*mNotificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                mIntent = new Intent(Ex7_5.this, Ex7_5_SecondActivity.class);
                mPendingIntent = PendingIntent.getActivity(Ex7_5.this,0,mIntent,0);
                mNotification = new Notification();
                mNotification.icon = R.drawable.adimg;
                mNotification.tickerText = "实例";
                //使用所有默认值，如声音、震动、闪屏等。
                mNotification.defaults = Notification.DEFAULT_ALL ;
                //设置Notification对象的Flag位。
                mNotification.flags = Notification.FLAG_INSISTENT;
                mNotification.setL(Ex7_5.this,"单击查看","这是一个Notification实例", mPendingIntent);
                mNotificationManager.notify("aaa",1,mNotification);*/


                //1.使用Builder对象来创建创建通知
                Notification.Builder builder = new Notification.Builder(Ex7_5.this);

                //2.设置"通知栏"上的图标，必须
                builder.setSmallIcon(R.drawable.adimg);
                //在通知栏上显示文字信息，非必须
                builder.setTicker("您有一条新消息");

                //3.这是"状态栏"上的信息
                builder.setContentTitle("状态栏信息");//标题信息
                builder.setContentText("状态栏文本内容");//文本信息
                builder.setWhen(System.currentTimeMillis());//显示发送时间
                builder.setContentInfo("文本其他信息");
                /**
                 * 设置通知模式，参数如下
                 * Notification.DEFAULT_LIGHTS  闪光模式
                 * Notification.DEFAULT_SOUND   声音模式
                 * Notification.DEFAULT_VIBRATE 震动模式
                 * Notification.DEFAULT_ALL     以上三中模式都选
                 *
                 * 需要添加手机震动取权限
                 */
                builder.setDefaults(Notification.DEFAULT_ALL);

                //4.创建Notification对象,生成对象 16API以上，支持低版本需要使用v4包中的notificationCompat
                Notification notify = builder.build();
                //设置消息无法被清除
                notify.flags = Notification.FLAG_NO_CLEAR;
                //利用系统的Manage发送信息
                NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                //发送消息
                //第一个参数是通知的唯一标识
                manager.notify((int) (Math.random() * 100), notify);
            }
        });

        //自定义通知
        mEx75Btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Notification.Builder builder = new Notification.Builder(Ex7_5.this);
                builder.setSmallIcon(R.drawable.adimg);
                builder.setTicker("自定义的消息");

                //设置通知模式
                builder.setDefaults(Notification.DEFAULT_ALL);
                //给通知设置自定义布局
                //View布局为RemoteViews类的布局，第一个参数是包名，第二个参数是布局文件名
                RemoteViews view = new RemoteViews(getPackageName(), R.layout.ex7_5_customize_notification);
                //给自定义文本中的设置红色颜色
                view.setTextColor(R.id.textView31, Color.RED);
                //给Builder对象添加布局
                builder.setContent(view);
                //给view里面的文本控件添加监听事件

                //点击文本后要跳转的页面
                Intent intent = new Intent(Ex7_5.this, Ex7_5_SecondActivity.class);
                //下面的方法有四个参数
                //上下文、请求码、代表意图对象、页面跳转的形式
                PendingIntent intent_tv = PendingIntent.getActivity(
                        Ex7_5.this,
                        11,
                        intent,
                        PendingIntent.FLAG_UPDATE_CURRENT);
                view.setOnClickPendingIntent(R.id.imageView, intent_tv);

                //给布局里的图像控件添加点击监听，跟上面文本监听事件一样
                //点击文本后要跳转的页面
                Intent intent2 = new Intent(Ex7_5.this, Ex7_5_SecondActivity.class);
                PendingIntent intent_iv = PendingIntent.getActivity(
                        Ex7_5.this,
                        11,
                        intent2,
                        PendingIntent.FLAG_UPDATE_CURRENT);
                view.setOnClickPendingIntent(R.id.imageView, intent_iv);

                //创建Notification对象,生成对象 16API以上，支持低版本需要使用v4包中的notificationCompat
                Notification notify = builder.build();
                //设置消息可以使用通知栏上的清除按钮清除消息
                notify.flags = Notification.FLAG_AUTO_CANCEL;
                //利用系统的Manage发送消息
                NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                //发送消息
                //第一个参数是通知的一个唯一标识值，
                manager.notify(11, notify);
            }
        });

        //清除自定义的通知
        mEx75Btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //清除消息也用到manager对象
                NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                //清除某一条通知，必须知道它的通知的标识值
                manager.cancel(11);
            }
        });

        //清楚全部通知
        mEx75Btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //清除消息也用到manager对象
                NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                //清除所有的通知
                manager.cancelAll();
            }
        });
    }
}
