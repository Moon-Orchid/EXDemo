package com.mo.exdemo.ex;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.mo.exdemo.R;

/**
 * FileName: Ex7_1
 * Package Name: com.mo.exdemo.ex
 * Founder: MoonOrchid
 * Create Date: 2020/10/7-21:59
 * Profile: 选项菜单-Menu
 **/
public class Ex7_1 extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ex7_1);

        textView = findViewById(R.id.ex7_1_textView);
    }

    //创建菜单项
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        //子菜单项SubMenu
        SubMenu subMenu = menu.addSubMenu(Menu.NONE, Menu.FIRST, 0, "发送").setIcon(android.R.drawable.ic_menu_send);
        subMenu.add(Menu.NONE, Menu.FIRST + 6, 6, "发送到蓝牙");
        subMenu.add(Menu.NONE, Menu.FIRST + 7, 7, "发送到微博");
        subMenu.add(Menu.NONE, Menu.FIRST + 8, 8, "发送到E-Mail");

        //给menu菜单添加MenuItem菜单项
        menu.add(Menu.NONE, Menu.FIRST + 1, 1, "保存").setIcon(android.R.drawable.ic_menu_edit);
        menu.add(Menu.NONE, Menu.FIRST + 2, 2, "帮助").setIcon(android.R.drawable.ic_menu_add);
        menu.add(Menu.NONE, Menu.FIRST + 3, 3, "添加").setIcon(android.R.drawable.ic_menu_help);
        menu.add(Menu.NONE, Menu.FIRST + 4, 4, "详细").setIcon(android.R.drawable.ic_menu_info_details);
        menu.add(Menu.NONE, Menu.FIRST + 5, 5, "退出").setIcon(android.R.drawable.ic_menu_delete);

        return true;
    }

    //为菜单项添加响应
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        textView = (TextView) findViewById(R.id.ex7_1_textView);
        switch (item.getItemId()) {
            case Menu.FIRST:
                textView.setText("你单击了发送菜单");
                break;
            case Menu.FIRST + 1:
                textView.setText("你单击了保存菜单");
                break;
            case Menu.FIRST + 2:
                textView.setText("你单击了帮助菜单");
                break;
            case Menu.FIRST + 3:
                textView.setText("你单击了添加菜单");
                break;
            case Menu.FIRST + 4:
                textView.setText("你单击了详细菜单");
                break;
            case Menu.FIRST + 5:
                textView.setText("你单击了退出菜单");
                break;
            case Menu.FIRST + 6:
                textView.setText("你单击了发送到蓝牙");
                break;
            case Menu.FIRST + 7:
                textView.setText("你单击了发送到微博");
                break;
            case Menu.FIRST + 8:
                textView.setText("你单击了发送到E-Mail");
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
