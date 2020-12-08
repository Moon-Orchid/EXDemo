package com.mo.exdemo.ex;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.mo.exdemo.R;

/**
 * FileName: Ex4_4
 * Package Name: com.mo.exdemo.ex
 * Founder: MoonOrchid
 * Create Date: 2020/9/27-14:43
 * Profile:
 **/
public class Ex4_4 extends AppCompatActivity {

    private Button button1;
    private Button button2;
    String TAG = "myTag";
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ex4_4);
        Log.d(TAG, "onCreate: ");

        button1 = findViewById(R.id.ex4_4_btn1);
        button2 = findViewById(R.id.ex4_4_btn2);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Ex4_4.this,Ex4_2_2.class);
                startActivity(intent);
            }
        });

        //翻转屏幕
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Android提供的方法
                /*//若当前屏幕状态为横屏
                if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
                    //切换为竖屏
                    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
                }
                //若当前屏幕状态为竖屏
                if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){
                    //切换为横屏
                    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
                }*/

                //获取当前屏幕的显示信息的方法
                WindowManager wm = getWindowManager();
                Display d = wm.getDefaultDisplay();
                if(d.getWidth() > d.getHeight()) {
                    //---landscape mode---
                    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
                    Log.d("Orientation", "Landscape mode");
                } else {
                    //---portrait mode---
                    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
                    Log.d("Orientation", "Portrait mode");
                }
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: ");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }
}
