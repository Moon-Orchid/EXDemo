package com.mo.exdemo.util;

import android.content.Context;
import android.widget.ScrollView;

/**
 * FileName: ScrollViewFling
 * Package Name: com.mo.exdemo.util
 * Founder: MoonOrchid
 * Create Date: 2020/9/22-18:34
 * Profile: 设置ScrollView滚动速度
 * //未成功
 **/
public class ScrollViewFling extends ScrollView {

/*    private static int X = 5;

    public static void flingX(int fX){
        X=fX;
    }*/

    @Override
    public void fling(int velocityY) {
        super.fling(velocityY/5);
    }

    public ScrollViewFling(Context context) {
        super(context);
    }

}
