package com.mo.exdemo.util;

import android.text.TextUtils;
import android.util.Log;

import java.text.SimpleDateFormat;

/**
 * FileName: utilTools
 * Package Name: com.mo.exdemo.util
 * Founder: MoonOrchid
 * Create Date: 2020/9/10-10:10
 * Profile: 打印工具
 **/
public class LogUtils {

    //TAG
    private static String TAG = "LogTAG";
    //日志时间
    private static SimpleDateFormat mSimpleDateFormat = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");


    //打印日志
    public static void i(String text){
            //判断传入内容是否为空
        if (!TextUtils.isEmpty(text)){
            Log.i(TAG,text);
        }
    }

    public static void d(String text){
        Log.d(TAG, "d: "+text);
    }
}
