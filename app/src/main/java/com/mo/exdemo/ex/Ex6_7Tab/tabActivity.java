package com.mo.exdemo.ex.Ex6_7Tab;

import android.app.TabActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.TabHost;

import com.mo.exdemo.R;

/**
 * FileName: tabactivity
 * Package Name: com.mo.exdemo.ex.Ex6_7Tab.Ex6_7
 * Founder: MoonOrchid
 * Create Date: 2020/9/23-22:10
 * Profile:
 **/
public class tabActivity extends TabActivity {

    private TabHost tabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //获取Activity用于容纳tab的TabHost对象
        tabHost = this.getTabHost();

        //LayoutInflater用来查找layout下的xml布局文件，并且实例化，
        //将tabactivity布局内容嵌入到tabHost.getTabContentView()所返回的FrameLayout中。
        LayoutInflater.from(this).inflate(R.layout.tabactivity,
                tabHost.getTabContentView(), true);
        //增加选项卡
        tabHost.addTab(tabHost
                .newTabSpec("选项卡1")//返回一个TabHost.TabSpec对象，用于表示一个选项卡的Tag。
                .setIndicator(null,getResources().getDrawable(R.drawable.adimg))//显示选项卡上的文字。
                .setContent(R.id.onetab));//指定选项卡的内容，参数必须为ID，控件ID或layout的ID。
        tabHost.addTab(tabHost
                .newTabSpec("选项卡2")
                .setIndicator("选项卡2",getResources().getDrawable(R.drawable.ic_launcher_background))
                .setContent(R.id.tweTab));
        tabHost.addTab(tabHost
                .newTabSpec("选项卡3")
                .setIndicator("选项卡3",getResources().getDrawable(R.drawable.adimg))
                .setContent(R.id.threetab));
    }
}
